package dopeasswizard.betterweapons.item.items

import net.minecraft.core.item.material.ToolMaterial
import net.minecraft.core.util.phys.Vec3d

class ItemToolPike(name: String, id: Int, material: ToolMaterial) : ItemWeapon(name, id, material, 2) {

	init {
	    renderScale = Vec3d.createVectorHelper(1.0, 1.6, 1.0)
		extraEntityRange = 2f
	}


}
