package dopeasswizard.betterweapons.item.items

import dopeasswizard.betterweapons.interfaces.IRenderTweakable
import net.minecraft.core.item.material.ToolMaterial
import org.lwjgl.opengl.GL11

class ItemToolPike(name: String, id: Int, material: ToolMaterial) : ItemWeapon(name, id, material, 2), IRenderTweakable {

	init {
		extraEntityRange = 2f
	}

	override fun onRender() {
		GL11.glScalef(1f, 1.6f, 1f)
	}

}
