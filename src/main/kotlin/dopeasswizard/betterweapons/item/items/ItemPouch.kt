package dopeasswizard.betterweapons.item.items

import net.minecraft.core.entity.player.EntityPlayer
import net.minecraft.core.item.Item
import net.minecraft.core.item.ItemStack
import net.minecraft.core.player.inventory.slot.Slot

abstract class ItemPouch(name: String, id: Int, val storedItem: Item) : Item(name, id) {


	init {
		maxStackSize = 1
	}

	override fun hasInventoryInteraction(): Boolean {
		return true
	}


	override fun onInventoryInteract(player: EntityPlayer, slot: Slot, stackInSlot: ItemStack?, isItemGrabbed: Boolean): ItemStack? {

		val pouchStack = if (isItemGrabbed) player.inventory.heldItemStack else stackInSlot
		val totalSpace = maxDamage
		val storedCount: Int = getItemCount(pouchStack)
		val freeSpace = totalSpace - storedCount

		// Click with the pouch on the item
		if (isItemGrabbed) {
			if (stackInSlot == null) {
				val amount = storedCount.coerceAtMost(64)
				val storedItemStack = storedItem.defaultStack.apply { stackSize = amount }
				if (amount > 0 && slot.canPutStackInSlot(storedItemStack)) {
					setItemCount(pouchStack, storedCount - amount)
					return storedItemStack
				}
			}
			else if (stackInSlot.itemID == storedItem.id) {
				val amount = stackInSlot.stackSize.coerceAtMost(freeSpace)
				if (amount > 0) {
					setItemCount(pouchStack, storedCount + amount)
					stackInSlot.stackSize -= amount
				}
			}
		}
		else { // Click with the item on the pouch
			val grabbedStack = player.inventory.heldItemStack

			if (grabbedStack == null) { // clicked with nothing, take item out
				val amount = storedCount.coerceAtMost(64) // take up to 64 items at the time
				if (amount > 0 ) {
					setItemCount(pouchStack, storedCount - amount)
					player.inventory.heldItemStack = storedItem.defaultStack.apply { stackSize = amount }
				}
			}
			else if (grabbedStack.itemID == storedItem.id) {
				val amount = grabbedStack.stackSize.coerceAtMost(freeSpace)
				if (amount > 0) {
					grabbedStack.stackSize -= amount
					setItemCount(pouchStack, storedCount + amount)
					if (grabbedStack.stackSize <= 0) {
						player.inventory.heldItemStack = null
					}
				}
			}
		}

		return stackInSlot
	}


	fun getItemCount(stack: ItemStack?): Int {
		stack ?: return 0
		return stack.maxDamage - stack.metadata
	}

	fun setItemCount(stack: ItemStack?, count: Int) {
		stack ?: return
		stack.metadata = stack.maxDamage - count
	}

	fun addItemCount(stack: ItemStack?, count: Int) {
		stack ?: return
		setItemCount(stack, getItemCount(stack) + count)
	}

	override fun showFullDurability(): Boolean {
		return true
	}

}
