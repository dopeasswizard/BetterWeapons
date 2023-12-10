package dopeasswizard.betterweapons.item

import dopeasswizard.betterweapons.BetterWeapons
import dopeasswizard.betterweapons.Config
import dopeasswizard.betterweapons.item.items.ItemBoomerang
import dopeasswizard.betterweapons.item.items.ItemBowSteel
import dopeasswizard.betterweapons.item.items.ItemPebblePouch
import dopeasswizard.betterweapons.item.items.ItemToolPike
import net.minecraft.core.item.Item
import net.minecraft.core.item.material.ToolMaterial
import turniplabs.halplibe.helper.ItemHelper

object ModItems {

	val toolBowSteel: Item = ItemHelper.createItem(
		BetterWeapons.MOD_ID,
		ItemBowSteel("tool.bow.steel", Config.nextItem()),
		"tool.bow.steel",
		"bow_steel.png"
	)

	val ammoArrowIron: Item = ItemHelper.createItem(
		BetterWeapons.MOD_ID,
		Item("ammo.arrow.iron", Config.nextItem()),
		"ammo.arrow.iron",
		"arrow_iron.png"
	)

	val ammoArrowSteel: Item = ItemHelper.createItem(
		BetterWeapons.MOD_ID,
		Item("ammo.arrow.steel", Config.nextItem()),
		"ammo.arrow.steel",
		"arrow_steel.png"
	)

	val pouchPebble: Item = ItemHelper.createItem(
		BetterWeapons.MOD_ID,
		ItemPebblePouch("pouch.pebble", Config.nextItem()),
		"pouch.pebble",
		"pouch.png"
	)



	val toolPikeWood: Item = ItemHelper.createItem(
		BetterWeapons.MOD_ID,
		ItemToolPike("tool.pike.wood", Config.nextItem(), ToolMaterial.wood),
		"tool.pike.wood",
		"pike_wood.png"
	)

	val toolPikeStone: Item = ItemHelper.createItem(
		BetterWeapons.MOD_ID,
		ItemToolPike("tool.pike.stone", Config.nextItem(), ToolMaterial.stone),
		"tool.pike.stone",
		"pike_stone.png"
	)

	val toolPikeIron: Item = ItemHelper.createItem(
		BetterWeapons.MOD_ID,
		ItemToolPike("tool.pike.iron", Config.nextItem(), ToolMaterial.iron),
		"tool.pike.iron",
		"pike_iron.png"
	)

	val toolPikeGold: Item = ItemHelper.createItem(
		BetterWeapons.MOD_ID,
		ItemToolPike("tool.pike.gold", Config.nextItem(), ToolMaterial.gold),
		"tool.pike.gold",
		"pike_gold.png"
	)

	val toolPikeDiamond: Item = ItemHelper.createItem(
		BetterWeapons.MOD_ID,
		ItemToolPike("tool.pike.gold", Config.nextItem(), ToolMaterial.diamond),
		"tool.pike.diamond",
		"pike_diamond.png"
	)

	val toolPikeSteel: Item = ItemHelper.createItem(
		BetterWeapons.MOD_ID,
		ItemToolPike("tool.pike.steel", Config.nextItem(), ToolMaterial.steel),
		"tool.pike.steel",
		"pike_steel.png"
	)



	val toolBoomerangWood: Item = ItemHelper.createItem(
		BetterWeapons.MOD_ID,
		ItemBoomerang("tool.boomerang.wood", Config.nextItem(), ToolMaterial.wood),
		"tool.boomerang.wood",
		"boomerang_wood.png"
	)

	val toolBoomerangStone: Item = ItemHelper.createItem(
		BetterWeapons.MOD_ID,
		ItemBoomerang("tool.boomerang.stone", Config.nextItem(), ToolMaterial.stone),
		"tool.boomerang.stone",
		"boomerang_stone.png"
	)

	val toolBoomerangIron: Item = ItemHelper.createItem(
		BetterWeapons.MOD_ID,
		ItemBoomerang("tool.boomerang.iron", Config.nextItem(), ToolMaterial.iron),
		"tool.boomerang.iron",
		"boomerang_iron.png"
	)

	val toolBoomerangGold: Item = ItemHelper.createItem(
		BetterWeapons.MOD_ID,
		ItemBoomerang("tool.boomerang.gold", Config.nextItem(), ToolMaterial.gold),
		"tool.boomerang.gold",
		"boomerang_gold.png"
	)

	val toolBoomerangDiamond: Item = ItemHelper.createItem(
		BetterWeapons.MOD_ID,
		ItemBoomerang("tool.boomerang.diamond", Config.nextItem(), ToolMaterial.diamond),
		"tool.boomerang.diamond",
		"boomerang_diamond.png"
	)

	val toolBoomerangSteel: Item = ItemHelper.createItem(
		BetterWeapons.MOD_ID,
		ItemBoomerang("tool.boomerang.steel", Config.nextItem(), ToolMaterial.steel),
		"tool.boomerang.steel",
		"boomerang_steel.png"
	)

	fun register() {}
}
