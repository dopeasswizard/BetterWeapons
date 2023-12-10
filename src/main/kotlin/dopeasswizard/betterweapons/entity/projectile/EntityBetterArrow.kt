package dopeasswizard.betterweapons.entity.projectile

import net.minecraft.core.entity.EntityLiving
import net.minecraft.core.entity.player.EntityPlayer
import net.minecraft.core.entity.projectile.EntityArrow
import net.minecraft.core.item.Item
import net.minecraft.core.item.ItemStack
import net.minecraft.core.world.World
import kotlin.math.roundToInt

open class EntityBetterArrow(world: World, owner: EntityLiving) : EntityArrow(world, owner, false, 0) {

	init {
	    stack = getItemStack()
	}

	override fun init() {
		arrowGravity = getGravity()
		arrowSpeed = getDrag()
		arrowDamage = getDamage().roundToInt()

		doesArrowBelongToPlayer = owner is EntityPlayer
	}


	override fun playerTouch(player: EntityPlayer) {
		if (world.isClientSide) return

		if (!inGround || arrowShake > 0) return

		player.inventory.insertItem(stack, true)
		if (stack.stackSize > 0) return

		world.playSoundAtEntity(this, "random.pop", 0.2f, ((random.nextFloat() - random.nextFloat()) * 0.7f + 1.0f) * 2.0f)
		player.onItemPickup(this, getItemStack().itemID)
		remove()
	}

	open fun getItemStack(): ItemStack {
		return ItemStack(Item.ammoArrow, 1)
	}

	open fun getRenderType(): Int {
		return 0
	}

	open fun getGravity(): Float {
		return 0.03f
	}

	open fun getDrag(): Float {
		return 0.99f
	}

	open fun getDamage(): Float {
		return 5f
	}


}
