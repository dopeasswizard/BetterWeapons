package dopeasswizard.betterweapons

import dopeasswizard.betterweapons.crafting.ModCraftings
import dopeasswizard.betterweapons.item.ModItems
import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object BetterWeapons: ModInitializer {
    @JvmField
    val MOD_ID: String = "betterweapons"

    @JvmField
    val LOG: Logger = LoggerFactory.getLogger(MOD_ID)

    override fun onInitialize() {


		/*
		TODO:
			add new arrows:
				iron - 50% more damage, heaver
				steel - 100% more damage, heaviest
				cloth - can bounce maybe?
				fire - crafted using cloth arrow and fire striker (takes away durability)
				explosive - explode on contact (don't destroy blocks)
			add melee:
				hammer - big knock-back
			add throwable:
				boomerangs - bounce and come back, can pickup items maybe?
				spears
				knifes
				shurikens
			add primitive ranged
				eoka pistol - shotgun-like, single shot, reload, shoots pebbles, uses sulphur
				crossbow - very heavy and slow, a lot od damage, shoots arrows?
				sling shot - already a mod, shoots pebbles (extra pebble types?)
				longbow - slow, a bow but long lol
			add shields?
			add utility
				pebble pouch - works like a quiver
		*/

        LOG.info("Better Weapons initializing...")

		ModItems.register()
		ModCraftings.register()
    }

}
