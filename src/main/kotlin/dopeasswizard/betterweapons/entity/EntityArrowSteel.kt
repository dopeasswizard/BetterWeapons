package dopeasswizard.betterweapons.entity

import dopeasswizard.betterweapons.item.ModItems
import net.minecraft.core.entity.EntityLiving
import net.minecraft.core.entity.player.EntityPlayer
import net.minecraft.core.entity.projectile.EntityArrow
import net.minecraft.core.world.World

class EntityArrowSteel(world: World, entityLiving: EntityLiving, doesArrowBelongToPlayer: Boolean)
	: EntityArrow(world, entityLiving, doesArrowBelongToPlayer, 4) {

	init {
		stack = ModItems.ammoArrowSteel.defaultStack
	}

	override fun init() {
		arrowGravity = 0.08f
		arrowSpeed = 0.99f
		arrowDamage = 10

		if (owner !is EntityPlayer) {
			doesArrowBelongToPlayer = false
		}
	}

	override fun playerTouch(player: EntityPlayer) {
		if (world.isClientSide) return

		if (!inGround || arrowShake > 0) return

		player.inventory.insertItem(stack, true)
		if (stack.stackSize > 0) return

		world.playSoundAtEntity(this, "random.pop", 0.2f, ((random.nextFloat() - random.nextFloat()) * 0.7f + 1.0f) * 2.0f)
		player.onItemPickup(this, ModItems.ammoArrowSteel.id)
		remove()
	}

}
