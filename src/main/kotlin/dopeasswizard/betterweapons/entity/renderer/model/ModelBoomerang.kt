package dopeasswizard.betterweapons.entity.renderer.model

import net.minecraft.client.render.model.Cube
import net.minecraft.client.render.model.ModelBase

class ModelBoomerang : ModelBase() {

	var cube = Cube(0, 0)

	init {
	    cube.addBox(0f, 0f, 0f, 16, 1, 16)
		cube.setRotationPoint(0f, 0f, 0f)
	}

	override fun render(limbSwing: Float, limbYaw: Float, ticksExisted: Float, headYaw: Float, headPitch: Float, scale: Float) {
		cube.render(scale)
	}

	override fun setRotationAngles(limbSwing: Float, limbYaw: Float, ticksExisted: Float, headYaw: Float, headPitch: Float, scale: Float) {
	}

}
