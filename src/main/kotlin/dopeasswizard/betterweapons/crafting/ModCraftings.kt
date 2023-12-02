package dopeasswizard.betterweapons.crafting

import dopeasswizard.betterweapons.item.ModItems
import net.minecraft.core.block.Block
import net.minecraft.core.item.Item

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

		RecipeHelper.Crafting.createRecipe(ModItems.toolPikeWood, 1, arrayOf<Any>(
			"O0A",
			"0I0",
			"I00",
			'A', Block.planksOak,
			'I', Item.stick
		))

		RecipeHelper.Crafting.createRecipe(ModItems.toolPikeStone, 1, arrayOf<Any>(
			"O0A",
			"0I0",
			"I00",
			'A', Block.cobbleStone,
			'I', Item.stick
		))

		RecipeHelper.Crafting.createRecipe(ModItems.toolPikeIron, 1, arrayOf<Any>(
			"O0A",
			"0I0",
			"I00",
			'A', Item.ingotIron,
			'I', Item.stick
		))

		RecipeHelper.Crafting.createRecipe(ModItems.toolPikeGold, 1, arrayOf<Any>(
			"O0A",
			"0I0",
			"I00",
			'A', Item.ingotGold,
			'I', Item.stick
		))

		RecipeHelper.Crafting.createRecipe(ModItems.toolPikeDiamond, 1, arrayOf<Any>(
			"O0A",
			"0I0",
			"I00",
			'A', Item.diamond,
			'I', Item.stick
		))

		RecipeHelper.Crafting.createRecipe(ModItems.toolPikeSteel, 1, arrayOf<Any>(
			"O0A",
			"0I0",
			"I00",
			'A', Item.ingotSteel,
			'I', Item.stick
		))


	}


}
