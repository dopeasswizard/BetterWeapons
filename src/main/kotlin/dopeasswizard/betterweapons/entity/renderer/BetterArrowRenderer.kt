package dopeasswizard.betterweapons.entity.renderer

import dopeasswizard.betterweapons.entity.projectile.EntityBetterArrow
import net.minecraft.client.render.Tessellator
import net.minecraft.client.render.entity.EntityRenderer
import net.minecraft.core.util.helper.MathHelper
import org.lwjgl.opengl.GL11


class BetterArrowRenderer : EntityRenderer<EntityBetterArrow>() {


	fun renderArrow(arrow: EntityBetterArrow, x: Double, y: Double, z: Double, yaw: Float, delta: Float) {

		if (arrow.yRotO == 0.0f && arrow.xRotO == 0.0f) return

		loadTexture("/assets/betterweapons/entity/arrows.png")

		GL11.glEnable(GL11.GL_BLEND)
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f)
		GL11.glEnable(GL11.GL_LIGHTING)
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA)
		GL11.glPushMatrix()
		GL11.glTranslated(x, y, z)
		GL11.glRotatef(arrow.yRotO + (arrow.yRot - arrow.yRotO) * delta - 90.0f, 0.0f, 1.0f, 0.0f)
		GL11.glRotatef(arrow.xRotO + (arrow.xRot - arrow.xRotO) * delta, 0.0f, 0.0f, 1.0f)

		val type = arrow.getRenderType()

		val bodyMinU = 0.0f
		val bodyMaxU = 0.5f
		val bodyMinV: Float = (type * 10).toFloat() / 32.0f
		val bodyMaxV: Float = (5 + type * 10).toFloat() / 32.0f
		val tailMinU = 0.0f
		val tailMaxU = 0.15625f
		val tailMinV: Float = (5 + type * 10).toFloat() / 32.0f
		val tailMaxV: Float = (10 + type * 10).toFloat() / 32.0f
		val scale = 0.05625f

		GL11.glEnable(32826);

		val shakeAmount: Float = arrow.arrowShake.toFloat() - delta
		if (shakeAmount > 0.0f) {
			val shakeAngle = -MathHelper.sin(shakeAmount * 3.0f) * shakeAmount
			GL11.glRotatef(shakeAngle, 0.0f, 0.0f, 1.0f)
		}

		GL11.glRotatef(45.0f, 1.0f, 0.0f, 0.0f)
		GL11.glScalef(scale, scale, scale)
		GL11.glTranslatef(-4.0f, 0.0f, 0.0f)
		GL11.glNormal3f(scale, 0.0f, 0.0f)

		val tessellator = Tessellator.instance
		tessellator.startDrawingQuads()
		tessellator.addVertexWithUV(-7.0, -2.0, -2.0, tailMinU.toDouble(), tailMinV.toDouble())
		tessellator.addVertexWithUV(-7.0, -2.0,  2.0, tailMaxU.toDouble(), tailMinV.toDouble())
		tessellator.addVertexWithUV(-7.0,  2.0,  2.0, tailMaxU.toDouble(), tailMaxV.toDouble())
		tessellator.addVertexWithUV(-7.0,  2.0, -2.0, tailMinU.toDouble(), tailMaxV.toDouble())
		tessellator.draw()
		GL11.glNormal3f(-scale, 0.0f, 0.0f)
		tessellator.startDrawingQuads()
		tessellator.addVertexWithUV(-7.0,  2.0, -2.0, tailMinU.toDouble(), tailMinV.toDouble())
		tessellator.addVertexWithUV(-7.0,  2.0,  2.0, tailMaxU.toDouble(), tailMinV.toDouble())
		tessellator.addVertexWithUV(-7.0, -2.0,  2.0, tailMaxU.toDouble(), tailMaxV.toDouble())
		tessellator.addVertexWithUV(-7.0, -2.0, -2.0, tailMinU.toDouble(), tailMaxV.toDouble())
		tessellator.draw()
		for (i in 0..3) {
			GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f)
			GL11.glNormal3f(0.0f, 0.0f, scale)
			tessellator.startDrawingQuads()
			tessellator.addVertexWithUV(-8.0, -2.0, 0.0, bodyMinU.toDouble(), bodyMinV.toDouble())
			tessellator.addVertexWithUV( 8.0, -2.0, 0.0, bodyMaxU.toDouble(), bodyMinV.toDouble())
			tessellator.addVertexWithUV( 8.0,  2.0, 0.0, bodyMaxU.toDouble(), bodyMaxV.toDouble())
			tessellator.addVertexWithUV(-8.0,  2.0, 0.0, bodyMinU.toDouble(), bodyMaxV.toDouble())
			tessellator.draw()
		}
		GL11.glDisable(32826)
		GL11.glPopMatrix()

	}

	override fun doRender(entity: EntityBetterArrow, x: Double, y: Double, z: Double, yaw: Float, delta: Float) {
		renderArrow(entity, x, y, z, yaw, delta)
	}


}
