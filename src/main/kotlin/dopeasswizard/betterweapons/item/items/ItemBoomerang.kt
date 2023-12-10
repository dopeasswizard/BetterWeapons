package dopeasswizard.betterweapons.item.items

import dopeasswizard.betterweapons.entity.projectile.EntityBoomerang
import dopeasswizard.betterweapons.interfaces.IRenderTweakable
import net.minecraft.core.entity.player.EntityPlayer
import net.minecraft.core.item.ItemStack
import net.minecraft.core.item.material.ToolMaterial
import net.minecraft.core.world.World

class ItemBoomerang(name: String, id: Int, material: ToolMaterial) : ItemWeapon(name, id, material, 2), IRenderTweakable {


	override fun onItemRightClick(stack: ItemStack, world: World, player: EntityPlayer): ItemStack {

		if (!world.isClientSide) {
			player.swingItem()
			world.entityJoinedWorld(EntityBoomerang(world, player, stack.item))
		}

		return stack
	}


	override fun bowHolding(): Boolean {
		return true
	}

}
