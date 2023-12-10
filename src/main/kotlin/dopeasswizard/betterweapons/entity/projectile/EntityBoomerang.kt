package dopeasswizard.betterweapons.entity.projectile

import dopeasswizard.betterweapons.item.items.ItemBoomerang
import dopeasswizard.betterweapons.util.AssetUtil
import net.minecraft.core.HitResult
import net.minecraft.core.entity.Entity
import net.minecraft.core.entity.EntityLiving
import net.minecraft.core.entity.player.EntityPlayer
import net.minecraft.core.item.Item
import net.minecraft.core.util.helper.DamageType
import net.minecraft.core.util.helper.Side
import net.minecraft.core.util.phys.Vec3d
import net.minecraft.core.world.World

class EntityBoomerang(world: World, owner: EntityLiving, item: Item) : EntityBetterProjectile(world, owner, item) {

	private var attractForce = 0.1f
	private val spinSpeed = 360/20 * 2 // 2 rotations per second

	private var lifetime = 20 * 3 // 3 seconds
	private var hasHit = false
	private var hasBouncedFromEntity = false

	init {
	    setSize(0.75f, 0.1f)
	}

	override fun tick() {

		super.tick()

		if (owner == null) {
			remove()
			return
		}

		lifetime--
		if (lifetime <= 0) {
			remove()
			return
		}


		val dirToOwner = Vec3d.createVectorHelper(
			owner.x - x,
			owner.y - y,
			owner.z - z
		).normalize()

		xd += dirToOwner.xCoord * attractForce
		yd += dirToOwner.yCoord * attractForce
		zd += dirToOwner.zCoord * attractForce

		attractForce += 0.002f;

		val drag = 0.9f
		xd *= drag
		yd *= drag
		zd *= drag


		val oldPos = Vec3d.createVectorHelper(x, y, z)
		var newPos = Vec3d.createVectorHelper(x + xd, y + yd, z + zd)
		var collision = world.checkBlockCollisionBetweenPoints(oldPos, newPos, false, true)

		val entitiesCollided = world.getEntitiesWithinAABBExcludingEntity(this, bb.addCoord(xd, yd, zd))
		var entityCollision: Entity? = null
		var minDist = Double.MAX_VALUE

		for (entity in entitiesCollided) {
			if (entity == owner) continue

			val dist = distanceToSqr(entity)
			if (dist >= minDist) continue

			minDist = dist
			entityCollision = entity
		}

		if (entityCollision != null)
			collision = HitResult(entityCollision)


		if (collision != null) {
			if (collision.entity != null) {

				if (!hasHit) {
					hasHit = true

					if (collision.entity.hurt(owner, getDamage(), DamageType.COMBAT)) {

						if (this.isOnFire) collision.entity.fireHurt()
						world.playSoundAtEntity(this, "random.drr", 1.0f, 1.2f / (random.nextFloat() * 0.2f + 0.9f))
					}
				}
			}
			else {
				xTile = collision.x
				yTile = collision.y
				zTile = collision.z
			}
		}

		x += xd
		y += yd
		z += zd

		yRot += spinSpeed

		bounce(collision)

		setPos(x, y, z)
	}

	fun bounce(collision: HitResult?) {

		if (collision == null) return

		if (collision.entity != null) {
			if (hasBouncedFromEntity) return
			hasBouncedFromEntity = true

			xd *= -1
			yd *= -1
			zd *= -1

			return
		}

		val hitPos = collision.location

		var deltaX = xd
		var deltaY = yd
		var deltaZ = zd

		var normalX = 0.0
		var normalY = 0.0
		var normalZ = 0.0

		when (collision.side) {
			Side.EAST -> normalX = -1.0
			Side.WEST -> normalX = 1.0
			Side.TOP -> normalY = -1.0
			Side.BOTTOM -> normalY = 1.0
			Side.NORTH -> normalZ = 1.0
			Side.SOUTH -> normalZ = -1.0
			Side.NONE, null -> {}
		}

		val dot = deltaX * normalX + deltaY * normalY + deltaZ * normalZ

		deltaX -= 2 * dot * normalX
		deltaY -= 2 * dot * normalY
		deltaZ -= 2 * dot * normalZ

		x = hitPos.xCoord + deltaX * 0.05
		y = hitPos.yCoord + deltaY * 0.05
		z = hitPos.zCoord + deltaZ * 0.05

		when (collision.side) {
			Side.EAST, Side.WEST -> xd *= -1
			Side.TOP, Side.BOTTOM -> yd *= -1
			Side.NORTH, Side.SOUTH -> zd *= -1
			Side.NONE, null -> {}
		}
	}

	override fun playerTouch(player: EntityPlayer) {

		if (player != owner) return

		tick()

		if (isComingBack()) {
			remove()
		}
	}

	private fun isComingBack(): Boolean {
		owner ?: return false

		val entityPos = Vec3d.createVectorHelper(x, y, z)
		val ownerPos = Vec3d.createVectorHelper(owner.x, owner.y, owner.z)

		val relPos = entityPos.subtract(ownerPos)
		val vel = Vec3d.createVectorHelper(xd, yd, zd)

		val dot = relPos.xCoord * vel.xCoord + relPos.yCoord * vel.yCoord + relPos.zCoord * vel.zCoord
		return dot > 0
	}

	override fun getDamage(): Int {
		return 3 + (item as ItemBoomerang).material.damage
	}

	override fun getLaunchForce(): Float {
		return 1.75f + (item as ItemBoomerang).material.miningLevel * 0.25f
	}

	override fun getEntityTexture(): String {
		val materialName = AssetUtil.getMaterialName((item as ItemBoomerang).material)
		return "/assets/betterweapons/item/boomerang_$materialName.png"
	}
}
