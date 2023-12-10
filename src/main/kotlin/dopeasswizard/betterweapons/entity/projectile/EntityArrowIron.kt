package dopeasswizard.betterweapons.entity.projectile

import dopeasswizard.betterweapons.item.ModItems
import net.minecraft.core.entity.EntityLiving
import net.minecraft.core.item.ItemStack
import net.minecraft.core.world.World

class EntityArrowIron(world: World, owner: EntityLiving) : EntityBetterArrow(world, owner) {


	override fun getItemStack(): ItemStack {
		return ModItems.ammoArrowIron.defaultStack
	}

	override fun getRenderType(): Int {
		return 1
	}

	override fun getGravity(): Float {
		return 0.05f
	}

	override fun getDrag(): Float {
		return 0.99f
	}

	override fun getDamage(): Float {
		return 7f
	}
}
