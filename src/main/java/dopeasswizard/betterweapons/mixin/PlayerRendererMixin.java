package dopeasswizard.betterweapons.mixin;

import dopeasswizard.betterweapons.interfaces.IRenderTweakable;
import net.minecraft.client.render.entity.PlayerRenderer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = PlayerRenderer.class, remap = false)
public class PlayerRendererMixin
{

	@Redirect(method = "renderSpecials", at = @At(value = "FIELD", target = "Lnet/minecraft/core/item/ItemStack;itemID:I", ordinal = 3))
	int getItemID(ItemStack stack) {
		if (stack.getItem() instanceof IRenderTweakable tweakable) {
			if (tweakable.bowHolding())
				return Item.toolBow.id;
		}

		return stack.itemID;
	}
}
