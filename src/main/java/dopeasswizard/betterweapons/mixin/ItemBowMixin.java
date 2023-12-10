package dopeasswizard.betterweapons.mixin;

import dopeasswizard.betterweapons.entity.projectile.EntityArrowIron;
import dopeasswizard.betterweapons.entity.projectile.EntityArrowSteel;
import dopeasswizard.betterweapons.interfaces.IRanged;
import dopeasswizard.betterweapons.item.ModItems;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.entity.projectile.EntityArrow;
import net.minecraft.core.entity.projectile.EntityArrowGolden;
import net.minecraft.core.entity.projectile.EntityArrowPurple;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemBow;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = ItemBow.class, remap = false)
public class ItemBowMixin extends Item
{

	public ItemBowMixin(int id) { super(id); }

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {

		ItemStack quiverSlot = player.inventory.armorItemInSlot(2);

		// quiver
		if (quiverSlot != null && quiverSlot.itemID == Item.armorQuiver.id && quiverSlot.getMetadata() < quiverSlot.getMaxDamage()) {
			player.inventory.armorItemInSlot(2).damageItem(1, player);
			shootArrow(stack, world, player, new EntityArrow(world, player, true, 0));
		}

		// golden quiver
		else if (quiverSlot != null && quiverSlot.itemID == Item.armorQuiverGold.id)
			shootArrow(stack, world, player, new EntityArrowPurple(world, player, false));

		// golden arrows
		else if (player.inventory.consumeInventoryItem(Item.ammoArrowGold.id))
			shootArrow(stack, world, player, new EntityArrowGolden(world, player, true));

		// iron arrows
		else if (player.inventory.consumeInventoryItem(ModItems.INSTANCE.getAmmoArrowIron().id))
			shootArrow(stack, world, player, new EntityArrowIron(world, player));

		// steel arrows
		else if (player.inventory.consumeInventoryItem(ModItems.INSTANCE.getAmmoArrowSteel().id))
			shootArrow(stack, world, player, new EntityArrowSteel(world, player));

		// normal arrows
		else if (player.inventory.consumeInventoryItem(Item.ammoArrow.id))
			shootArrow(stack, world, player, new EntityArrow(world, player, true, 0));

		return stack;
	}

	void shootArrow(ItemStack bow, World world, EntityPlayer player, EntityArrow arrow) {
		bow.damageItem(1, player);
		world.playSoundAtEntity(player, "random.bow", 0.3f, 1.0f / (itemRand.nextFloat() * 0.4f + 0.8f));

		if (bow.getItem() instanceof IRanged ranged) {
			ranged.onProjectileSpawn(arrow);
		}

		if (!world.isClientSide)
			world.entityJoinedWorld(arrow);
	}

}
