package dopeasswizard.betterweapons.entity.projectile

import dopeasswizard.betterweapons.item.ModItems
import net.minecraft.core.entity.EntityLiving
import net.minecraft.core.item.ItemStack
import net.minecraft.core.world.World

class EntityArrowSteel(world: World, owner: EntityLiving) : EntityBetterArrow(world, owner) {

	override fun getItemStack(): ItemStack {
		return ModItems.ammoArrowSteel.defaultStack
	}

	override fun getRenderType(): Int {
		return 2
	}

	override fun getGravity(): Float {
		return 0.08f
	}

	override fun getDrag(): Float {
		return 0.99f
	}

	override fun getDamage(): Float {
		return 10f
	}

}
