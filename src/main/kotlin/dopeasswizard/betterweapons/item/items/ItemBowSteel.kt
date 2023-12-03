package dopeasswizard.betterweapons.item.items

import dopeasswizard.betterweapons.interfaces.IRenderTweakable
import dopeasswizard.betterweapons.mixin.EntityArrowAccessor
import net.minecraft.core.entity.player.EntityPlayer
import net.minecraft.core.entity.projectile.EntityArrow
import net.minecraft.core.entity.projectile.EntityArrowGolden
import net.minecraft.core.entity.projectile.EntityArrowPurple
import net.minecraft.core.item.ItemBow
import net.minecraft.core.item.ItemStack
import net.minecraft.core.world.World

class ItemBowSteel(name: String, id: Int) : ItemBow(name, id), IRenderTweakable {

	private val gravityMultiplier: Float = 0.5f
	private val damageMultiplier: Float = 2f

	init {
		setMaxDamage(384 * 2)
	}


	@Override
	override fun onItemRightClick(stack: ItemStack, world: World, player: EntityPlayer): ItemStack {

		val quiverSlot: ItemStack? = player.inventory.armorItemInSlot(2)


		if (quiverSlot != null && quiverSlot.itemID == armorQuiver.id && quiverSlot.metadata < quiverSlot.maxDamage) {
			player.inventory.armorItemInSlot(2).damageItem(1, player)
			shootArrow(stack, world, player, EntityArrow(world, player, true, 0))
		}

		else if (quiverSlot != null && quiverSlot.itemID == armorQuiverGold.id)
			shootArrow(stack, world, player, EntityArrowPurple(world, player, false))

		else if (player.inventory.consumeInventoryItem(ammoArrowGold.id))
			shootArrow(stack, world, player, EntityArrowGolden(world, player, true))

		else if (player.inventory.consumeInventoryItem(ammoArrow.id))
			shootArrow(stack, world, player, EntityArrow(world, player, true, 0))

		return stack
	}

	fun shootArrow(bow: ItemStack, world: World, player: EntityPlayer, arrow: EntityArrow) {
		bow.damageItem(1, player)
		world.playSoundAtEntity(player, "random.bow", 0.3f, 1.0f / (itemRand.nextFloat() * 0.4f + 0.8f))

		(arrow as EntityArrowAccessor).run {
			arrowGravity *= gravityMultiplier
			arrowDamage = (arrowDamage * damageMultiplier).toInt()
		}

		if (!world.isClientSide)
			world.entityJoinedWorld(arrow)
	}

	override fun isFull3D(): Boolean {
		return true
	}

	override fun bowHolding(): Boolean {
		return true
	}

}
