package dopeasswizard.betterweapons.entity.projectile

import com.mojang.nbt.CompoundTag
import dopeasswizard.betterweapons.util.EntityUtil
import net.minecraft.core.entity.Entity
import net.minecraft.core.entity.EntityLiving
import net.minecraft.core.item.Item
import net.minecraft.core.world.World

open class EntityBetterProjectile(world: World, val owner: EntityLiving?, val item: Item?) : Entity(world) {

	protected var xTile = -1
	protected var yTile = -1
	protected var zTile = -1

	val gravity: Float = -10f

	constructor(world: World) : this(world, null, null)

	init {
	    if (owner != null) {

			setSize(0.5f, 0.5f)
			moveTo(owner.x, owner.y + owner.headHeight, owner.z, owner.yRot, owner.xRot)

			val dir = EntityUtil.getDir(owner)
			launchInDir(dir.xCoord, dir.yCoord, dir.zCoord, getLaunchForce().toDouble())
		}

	}

	override fun init() {


	}

	override fun tick() {
		super.tick()
	}

	fun launchInDir(x: Double, y: Double, z: Double, force: Double) {
		xd = x * force
		yd = y * force
		zd = z * force
	}

	override fun readAdditionalSaveData(compoundTag: CompoundTag?) {

	}

	override fun addAdditionalSaveData(compoundTag: CompoundTag?) {

	}

	open fun getRenderType(): Int {
		return 0
	}

	open fun getLaunchForce(): Float {
		return 1f
	}

	open fun getDamage(): Int {
		return 1
	}

}
