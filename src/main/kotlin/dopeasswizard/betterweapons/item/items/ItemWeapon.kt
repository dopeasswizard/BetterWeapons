package dopeasswizard.betterweapons.item.items

import net.minecraft.core.block.Block
import net.minecraft.core.block.tag.BlockTags
import net.minecraft.core.entity.Entity
import net.minecraft.core.entity.EntityLiving
import net.minecraft.core.item.Item
import net.minecraft.core.item.ItemStack
import net.minecraft.core.item.material.ToolMaterial
import net.minecraft.core.item.tag.ItemTags

open class ItemWeapon(name: String, id: Int, val material: ToolMaterial, baseDamage: Int) : Item(name, id) {

	private var weaponDamage: Int = baseDamage + material.damage * 2

	var extraEntityRange: Float = 0f; protected set
	var extraBlockRange: Float = 0f; protected set


	init {
		maxStackSize = 1
		maxDamage = material.durability
	    withTags(ItemTags.preventCreativeMining)
	}


	override fun getDamageVsEntity(entity: Entity?): Int {
		return weaponDamage
	}

	override fun hitEntity(stack: ItemStack, entity: EntityLiving, player: EntityLiving): Boolean {
		stack.damageItem(1, player)
		return true
	}

	override fun canHarvestBlock(block: Block): Boolean {
		return block.hasTag(BlockTags.MINEABLE_BY_SWORD)
	}

	override fun onBlockDestroyed(stack: ItemStack, id: Int, x: Int, y: Int, z: Int, player: EntityLiving): Boolean {
		val block = Block.blocksList[id] ?: return true

		if (block.hardness > 0.0f || this.isSilkTouch) {
			stack.damageItem(2, player)
		}

		return true
	}

	override fun isSilkTouch(): Boolean {
		return material.isSilkTouch
	}

	override fun isFull3D(): Boolean {
		return true
	}


}
