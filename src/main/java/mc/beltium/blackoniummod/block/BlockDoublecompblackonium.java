
package mc.beltium.blackoniummod.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import mc.beltium.blackoniummod.creativetab.TabBeltiumsMod;
import mc.beltium.blackoniummod.ElementsBlackoniumMod;

@ElementsBlackoniumMod.ModElement.Tag
public class BlockDoublecompblackonium extends ElementsBlackoniumMod.ModElement {
	@GameRegistry.ObjectHolder("blackoniummod:doublecompblackonium")
	public static final Block block = null;
	public BlockDoublecompblackonium(ElementsBlackoniumMod instance) {
		super(instance, 29);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("doublecompblackonium"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("blackoniummod:doublecompblackonium", "inventory"));
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.IRON);
			setUnlocalizedName("doublecompblackonium");
			setSoundType(SoundType.METAL);
			setHardness(40F);
			setResistance(40F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabBeltiumsMod.tab);
		}
	}
}
