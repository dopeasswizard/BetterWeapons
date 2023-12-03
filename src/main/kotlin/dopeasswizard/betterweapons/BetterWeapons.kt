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




        LOG.info("Better Weapons initializing...")

		ModItems.register()
		ModCraftings.register()
    }

}
