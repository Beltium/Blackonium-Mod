
package mc.beltium.blackoniummod.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import mc.beltium.blackoniummod.creativetab.TabBeltiumsMod;
import mc.beltium.blackoniummod.ElementsBlackoniumMod;

@ElementsBlackoniumMod.ModElement.Tag
public class ItemBlackoniumdisk extends ElementsBlackoniumMod.ModElement {
	@GameRegistry.ObjectHolder("blackoniummod:blackoniumdisk")
	public static final Item block = null;
	public ItemBlackoniumdisk(ElementsBlackoniumMod instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("blackoniummod:blackoniumdisk", "inventory"));
	}
	public static class MusicDiscItemCustom extends ItemRecord {
		public MusicDiscItemCustom() {
			super("blackoniumdisk", ElementsBlackoniumMod.sounds.get(new ResourceLocation("blackoniummod:error_sound")));
			setUnlocalizedName("blackoniumdisk");
			setRegistryName("blackoniumdisk");
			setCreativeTab(TabBeltiumsMod.tab);
		}
	}
}
