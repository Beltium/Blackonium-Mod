
package mc.beltium.blackoniummod.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumFacing;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import mc.beltium.blackoniummod.procedure.ProcedureBlackoniumtntOnBlockRightClicked;
import mc.beltium.blackoniummod.procedure.ProcedureBlackoniumtntBlockDestroyedByExplosionn;
import mc.beltium.blackoniummod.creativetab.TabBeltiumsMod;
import mc.beltium.blackoniummod.ElementsBlackoniumMod;

@ElementsBlackoniumMod.ModElement.Tag
public class BlockBlackoniumtnt extends ElementsBlackoniumMod.ModElement {
	@GameRegistry.ObjectHolder("blackoniummod:blackoniumtnt")
	public static final Block block = null;
	public BlockBlackoniumtnt(ElementsBlackoniumMod instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("blackoniumtnt"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("blackoniummod:blackoniumtnt", "inventory"));
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.ROCK);
			setUnlocalizedName("blackoniumtnt");
			setSoundType(SoundType.SAND);
			setHardness(0F);
			setResistance(0F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabBeltiumsMod.tab);
		}

		@Override
		public void onBlockDestroyedByExplosion(World world, BlockPos pos, Explosion e) {
			super.onBlockDestroyedByExplosion(world, pos, e);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				ProcedureBlackoniumtntBlockDestroyedByExplosionn.executeProcedure($_dependencies);
			}
		}

		@Override
		public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer entity, EnumHand hand, EnumFacing direction,
				float hitX, float hitY, float hitZ) {
			super.onBlockActivated(world, pos, state, entity, hand, direction, hitX, hitY, hitZ);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				ProcedureBlackoniumtntOnBlockRightClicked.executeProcedure($_dependencies);
			}
			return true;
		}
	}
}
