package dopeasswizard.betterweapons.mixin;

import net.minecraft.core.entity.projectile.EntityArrow;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = EntityArrow.class)
public interface EntityArrowAccessor
{

	@Accessor("arrowSpeed")
	float getArrowSpeed();
	@Accessor("arrowSpeed")
	void setArrowSpeed(float speed);

	@Accessor("arrowGravity")
	float getArrowGravity();
	@Accessor("arrowGravity")
	void setArrowGravity(float gravity);

	@Accessor("arrowDamage")
	int getArrowDamage();
	@Accessor("arrowDamage")
	void setArrowDamage(int damage);
}
