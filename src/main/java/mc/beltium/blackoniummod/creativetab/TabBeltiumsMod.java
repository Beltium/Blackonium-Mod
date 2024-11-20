
package mc.beltium.blackoniummod.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import mc.beltium.blackoniummod.block.BlockBlackoniumore;
import mc.beltium.blackoniummod.ElementsBlackoniumMod;

@ElementsBlackoniumMod.ModElement.Tag
public class TabBeltiumsMod extends ElementsBlackoniumMod.ModElement {
	public TabBeltiumsMod(ElementsBlackoniumMod instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabbeltiumsmod") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(BlockBlackoniumore.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static CreativeTabs tab;
}
