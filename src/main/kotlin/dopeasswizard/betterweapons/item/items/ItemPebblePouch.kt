package dopeasswizard.betterweapons.item.items

import net.minecraft.core.entity.player.EntityPlayer
import net.minecraft.core.entity.projectile.EntityPebble
import net.minecraft.core.item.Item
import net.minecraft.core.item.ItemStack
import net.minecraft.core.world.World

class ItemPebblePouch(name: String, id: Int) : ItemPouch(name, id, Item.ammoPebble) {

	init {
		maxDamage = 64 * 3
	}

	override fun onItemRightClick(stack: ItemStack, world: World, player: EntityPlayer): ItemStack {
		if (getItemCount(stack) > 0) {
			addItemCount(stack, -1)
			world.playSoundAtEntity(player, "random.bow", 0.5f, 0.4f / (itemRand.nextFloat() * 0.4f + 0.8f))

			if (!world.isClientSide)
				world.entityJoinedWorld(EntityPebble(world, player))
		}

		return stack
	}

}
