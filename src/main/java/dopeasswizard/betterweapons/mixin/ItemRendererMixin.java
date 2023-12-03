package dopeasswizard.betterweapons.mixin;

import dopeasswizard.betterweapons.interfaces.IRenderTweakable;
import dopeasswizard.betterweapons.item.items.ItemToolPike;
import dopeasswizard.betterweapons.item.items.ItemWeapon;
import net.minecraft.client.render.ItemRenderer;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.phys.Vec3d;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ItemRenderer.class, remap = false)
public class ItemRendererMixin
{

	@Inject(method = "renderItem(Lnet/minecraft/core/entity/EntityLiving;Lnet/minecraft/core/item/ItemStack;)V", at = @At("HEAD"))
	void renderItem(EntityLiving entity, ItemStack stack, CallbackInfo info) {
		if (stack.getItem() instanceof IRenderTweakable tweakable) {
			tweakable.onRender();
		}
	}

}
