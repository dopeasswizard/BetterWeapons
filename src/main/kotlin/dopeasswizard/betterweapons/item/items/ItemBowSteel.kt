package dopeasswizard.betterweapons.item.items

import dopeasswizard.betterweapons.interfaces.IRanged
import dopeasswizard.betterweapons.interfaces.IRenderTweakable
import dopeasswizard.betterweapons.mixin.EntityArrowAccessor
import net.minecraft.core.entity.Entity
import net.minecraft.core.entity.projectile.EntityArrow
import net.minecraft.core.item.ItemBow

class ItemBowSteel(name: String, id: Int) : ItemBow(name, id), IRenderTweakable, IRanged {

	private val gravityMultiplier: Float = 0.5f
	private val damageMultiplier: Float = 1.5f

	init {
		setMaxDamage(384 * 2)
	}


	override fun onProjectileSpawn(projectile: Entity) {
		(projectile as? EntityArrow as? EntityArrowAccessor)?.run {
			arrowGravity *= gravityMultiplier
			arrowDamage = (arrowDamage * damageMultiplier).toInt()
		}
	}

	override fun bowHolding(): Boolean {
		return true
	}

}
