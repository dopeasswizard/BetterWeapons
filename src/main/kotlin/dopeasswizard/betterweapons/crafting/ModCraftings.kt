package dopeasswizard.betterweapons.crafting

import dopeasswizard.betterweapons.item.ModItems
import net.minecraft.core.block.Block
import net.minecraft.core.item.Item
import net.minecraft.core.item.ItemStack

import turniplabs.halplibe.helper.RecipeHelper




object ModCraftings {

	fun register() {

		RecipeHelper.Crafting.createRecipe(ModItems.toolBowSteel, 1, arrayOf<Any>(
			"OAB",
			"AOB",
			"OAB",
			'A', Item.ingotSteel,
			'B', Item.string
		))

		RecipeHelper.Crafting.createRecipe(ModItems.ammoArrowIron, 1, arrayOf<Any>(
			"OAO",
			"AIO",
			"OBO",
			'A', Item.ingotIron,
			'I', Item.stick,
			'B', Item.featherChicken
		))

		RecipeHelper.Crafting.createRecipe(ModItems.ammoArrowSteel, 1, arrayOf<Any>(
			"OAO",
			"AIO",
			"OBO",
			'A', Item.ingotSteel,
			'I', Item.stick,
			'B', Item.featherChicken
		))

		RecipeHelper.Crafting.createRecipe(ModItems.toolPikeWood, 1, arrayOf<Any>(
			"OOA",
			"OIO",
			"IOO",
			'A', Block.planksOak,
			'I', Item.stick
		))

		RecipeHelper.Crafting.createRecipe(ModItems.toolPikeStone, 1, arrayOf<Any>(
			"OOA",
			"OIO",
			"IOO",
			'A', Block.cobbleStone,
			'I', Item.stick
		))

		RecipeHelper.Crafting.createRecipe(ModItems.toolPikeIron, 1, arrayOf<Any>(
			"OOA",
			"OIO",
			"IOO",
			'A', Item.ingotIron,
			'I', Item.stick
		))

		RecipeHelper.Crafting.createRecipe(ModItems.toolPikeGold, 1, arrayOf<Any>(
			"OOA",
			"0IO",
			"IOO",
			'A', Item.ingotGold,
			'I', Item.stick
		))

		RecipeHelper.Crafting.createRecipe(ModItems.toolPikeDiamond, 1, arrayOf<Any>(
			"OOA",
			"OIO",
			"IOO",
			'A', Item.diamond,
			'I', Item.stick
		))

		RecipeHelper.Crafting.createRecipe(ModItems.toolPikeSteel, 1, arrayOf<Any>(
			"OOA",
			"OIO",
			"IOO",
			'A', Item.ingotSteel,
			'I', Item.stick
		))

		RecipeHelper.Crafting.createRecipe(ItemStack(ModItems.pouchPebble, 1, ModItems.pouchPebble.maxDamage), arrayOf<Any>(
			"OBO",
			"AOA",
			"AAA",
			'A', Item.leather,
			'B', Item.string
		))

		RecipeHelper.Crafting.createRecipe(ModItems.toolBoomerangWood, 1, arrayOf<Any>(
			"ABB",
			"BOO",
			"BOO",
			'A', Item.leather,
			'B', Block.planksOak
		))

		RecipeHelper.Crafting.createRecipe(ModItems.toolBoomerangStone, 1, arrayOf<Any>(
			"ABB",
			"BOO",
			"BOO",
			'A', Item.leather,
			'B', Block.cobbleStone
		))

		RecipeHelper.Crafting.createRecipe(ModItems.toolBoomerangIron, 1, arrayOf<Any>(
			"ABB",
			"BOO",
			"BOO",
			'A', Item.leather,
			'B', Item.ingotIron
		))

		RecipeHelper.Crafting.createRecipe(ModItems.toolBoomerangGold, 1, arrayOf<Any>(
			"ABB",
			"BOO",
			"BOO",
			'A', Item.leather,
			'B', Item.ingotGold
		))

		RecipeHelper.Crafting.createRecipe(ModItems.toolBoomerangDiamond, 1, arrayOf<Any>(
			"ABB",
			"BOO",
			"BOO",
			'A', Item.leather,
			'B', Item.diamond
		))

		RecipeHelper.Crafting.createRecipe(ModItems.toolBoomerangSteel, 1, arrayOf<Any>(
			"ABB",
			"BOO",
			"BOO",
			'A', Item.leather,
			'B', Item.ingotSteel
		))


	}


}
