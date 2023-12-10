package dopeasswizard.betterweapons.entity.renderer

import dopeasswizard.betterweapons.entity.projectile.EntityBoomerang
import dopeasswizard.betterweapons.entity.renderer.model.ModelBoomerang
import net.minecraft.client.render.EntityRenderDispatcher
import net.minecraft.client.render.entity.EntityRenderer
import org.lwjgl.opengl.GL11.*

class BoomerangRenderer : EntityRenderer<EntityBoomerang>() {

	private val modelBoomerang = ModelBoomerang()


	fun renderBoomerang(boomerang: EntityBoomerang, x: Double, y: Double, z: Double, yaw: Float, renderPartialTicks: Float) {
		glPushMatrix()
		glTranslated(x, y, z)

		glRotatef(90f, 1f, 0f, 0f)

		// spin
		glRotatef(-yaw, 0f, 0f, 1f)

		// center the rotation
		glTranslatef(-boomerang.bbWidth/2, -boomerang.bbWidth/2, 0f)

		// scale
		glScalef(boomerang.bbWidth, boomerang.bbWidth, 1f)

		loadTexture(boomerang.entityTexture)
		EntityRenderDispatcher.instance.itemRenderer.renderItem(boomerang, boomerang.item!!.defaultStack, false)

		glPopMatrix()
	}

	override fun doRender(entity: EntityBoomerang, x: Double, y: Double, z: Double, yaw: Float, renderPartialTicks: Float) {

		renderBoomerang(entity, x, y, z, yaw, renderPartialTicks)

	}

}
