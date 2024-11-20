
package mc.beltium.blackoniummod.item;

import net.minecraftforge.fml.common.registry.GameRegistry;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumActionResult;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;

import mc.beltium.blackoniummod.world.WorldBlackoniumdiemsion;
import mc.beltium.blackoniummod.creativetab.TabBeltiumsMod;

public class ItemBlackoniumdiemsion extends Item {
	@GameRegistry.ObjectHolder("blackoniummod:blackoniumdiemsion")
	public static final Item block = null;
	public ItemBlackoniumdiemsion() {
		super();
		this.maxStackSize = 1;
		setMaxDamage(64);
		setCreativeTab(TabBeltiumsMod.tab);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer entity, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY,
			float hitZ) {
		pos = pos.offset(facing);
		ItemStack itemstack = entity.getHeldItem(hand);
		if (!entity.canPlayerEdit(pos, facing, itemstack)) {
			return EnumActionResult.FAIL;
		} else {
			if (world.isAirBlock(pos))
				WorldBlackoniumdiemsion.portal.portalSpawn(world, pos);
			itemstack.damageItem(1, entity);
			return EnumActionResult.SUCCESS;
		}
	}
}
