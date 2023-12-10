package dopeasswizard.betterweapons.entity

import dopeasswizard.betterweapons.Config
import dopeasswizard.betterweapons.entity.projectile.EntityBetterArrow
import dopeasswizard.betterweapons.entity.projectile.EntityBoomerang
import dopeasswizard.betterweapons.entity.renderer.BetterArrowRenderer
import dopeasswizard.betterweapons.entity.renderer.BoomerangRenderer
import turniplabs.halplibe.helper.EntityHelper

object ModEntities {

	fun register() {
		EntityHelper.createEntity(EntityBetterArrow::class.java, BetterArrowRenderer(), Config.nextEntity(), "betterarrow")
		EntityHelper.createEntity(EntityBoomerang::class.java, BoomerangRenderer(), Config.nextEntity(), "boomerang")
	}

}
