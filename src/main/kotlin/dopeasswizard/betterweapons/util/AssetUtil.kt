package dopeasswizard.betterweapons.util

import net.minecraft.core.item.material.ToolMaterial

object AssetUtil {

	private val toolMaterialNames = mapOf(
		ToolMaterial.wood to "wood",
		ToolMaterial.stone to "stone",
		ToolMaterial.iron to "iron",
		ToolMaterial.gold to "gold",
		ToolMaterial.diamond to "diamond",
		ToolMaterial.steel to "steel"
	)

	fun getMaterialName(material: ToolMaterial): String {
		return toolMaterialNames[material].toString()
	}

}
