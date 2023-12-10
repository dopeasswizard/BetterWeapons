package dopeasswizard.betterweapons.util

import net.minecraft.core.entity.Entity
import net.minecraft.core.util.phys.Vec3d
import kotlin.math.cos
import kotlin.math.sin

object EntityUtil {

	fun getDir(entity: Entity): Vec3d {
		return Vec3d.createVectorHelper(
			-sin(entity.yRot / 180.0f * Math.PI) * cos(entity.xRot / 180.0f * Math.PI),
			-sin(entity.xRot / 180.0f * Math.PI),
			cos(entity.yRot / 180.0f * Math.PI) * cos(entity.xRot / 180.0f * Math.PI)
		)
	}

}
