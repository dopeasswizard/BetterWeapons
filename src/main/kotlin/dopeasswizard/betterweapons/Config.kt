package dopeasswizard.betterweapons

import turniplabs.halplibe.util.ConfigUpdater
import turniplabs.halplibe.util.TomlConfigHandler
import turniplabs.halplibe.util.toml.Toml

object Config {

	private val updater = ConfigUpdater.fromProperties()
	private val properties = Toml("BetterWeapons TOML Config")
	val cfg: TomlConfigHandler by lazy { TomlConfigHandler(updater, BetterWeapons.MOD_ID, properties) }

	private var currItemID: Int = 0
	private var currEntityID: Int = 0

	init {
		properties.addCategory("Item IDs")
			.addEntry("First ID", 2137_0)

		properties.addCategory("Entity IDs")
			.addEntry("First ID", 2137)

		currItemID = cfg.getInt("Item IDs.First ID")
		currEntityID = cfg.getInt("Entity IDs.First ID")
	}

	fun nextItem(): Int {
		return currItemID++
	}

	fun nextEntity(): Int {
		return currEntityID++
	}



}
