package dopeasswizard.betterweapons.mixin;

import dopeasswizard.betterweapons.item.items.ItemWeapon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.controller.PlayerController;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = PlayerController.class, remap = false)
public class PlayerControllerMixin
{
	@Inject(method = "getEntityReachDistance", at = @At("RETURN"), cancellable = true)
	void getEntityReachDistance(CallbackInfoReturnable<Float> info) {

		ItemStack heldStack = Minecraft.getMinecraft(Minecraft.class).thePlayer.getHeldItem();
		if (heldStack == null) return;

		if (heldStack.getItem() instanceof ItemWeapon weapon)
			info.setReturnValue(info.getReturnValue() + weapon.getExtraEntityRange());
	}

	@Inject(method = "getBlockReachDistance", at = @At("RETURN"), cancellable = true)
	void getBlockReachDistance(CallbackInfoReturnable<Float> info) {

		ItemStack heldStack = Minecraft.getMinecraft(Minecraft.class).thePlayer.getHeldItem();
		if (heldStack == null) return;

		if (heldStack.getItem() instanceof ItemWeapon weapon)
			info.setReturnValue(info.getReturnValue() + weapon.getExtraBlockRange());
	}


}
