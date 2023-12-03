package dopeasswizard.betterweapons.mixin;

import dopeasswizard.betterweapons.interfaces.IRenderTweakable;
import net.minecraft.client.render.entity.MobRenderer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = MobRenderer.class, remap = false)
public class MobRendererMixin
{
	@Redirect(method = "renderEquippedItems", at = @At(value = "FIELD", target = "Lnet/minecraft/core/item/ItemStack;itemID:I", ordinal = 2))
	int getItemID(ItemStack stack) {
		if (stack.getItem() instanceof IRenderTweakable tweakable) {
			if (tweakable.bowHolding())
				return Item.toolBow.id;
		}

		return stack.itemID;
	}
}
