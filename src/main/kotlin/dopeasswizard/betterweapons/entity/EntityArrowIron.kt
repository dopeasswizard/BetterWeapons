package dopeasswizard.betterweapons.entity

import net.minecraft.core.entity.player.EntityPlayer
import net.minecraft.core.entity.projectile.EntityArrow
import net.minecraft.core.world.World

class EntityArrowIron(world: World) : EntityArrow(world) {

	override fun init() {
		arrowGravity = 0.05f
		arrowSpeed = 0.99f
		arrowDamage = 7
		if (owner !is EntityPlayer) {
			doesArrowBelongToPlayer = false
		}
	}

}
