
package mc.beltium.blackoniummod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import mc.beltium.blackoniummod.item.ItemBlackoniumingot;
import mc.beltium.blackoniummod.block.BlockBlackoniumore;
import mc.beltium.blackoniummod.ElementsBlackoniumMod;

@ElementsBlackoniumMod.ModElement.Tag
public class RecipeBlackoniumoresmelt extends ElementsBlackoniumMod.ModElement {
	public RecipeBlackoniumoresmelt(ElementsBlackoniumMod instance) {
		super(instance, 10);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockBlackoniumore.block, (int) (1)), new ItemStack(ItemBlackoniumingot.block, (int) (1)), 3F);
	}
}
