
package mc.beltium.blackoniummod.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

import mc.beltium.blackoniummod.world.WorldBlackoniumdiemsion;
import mc.beltium.blackoniummod.procedure.ProcedureBlackoniumfluidMobplayerCollidesBlock;
import mc.beltium.blackoniummod.ElementsBlackoniumMod;

import java.util.Random;

@ElementsBlackoniumMod.ModElement.Tag
public class BlockBlackoniumfluid extends ElementsBlackoniumMod.ModElement {
	@GameRegistry.ObjectHolder("blackoniummod:blackoniumfluid")
	public static final Block block = null;
	@GameRegistry.ObjectHolder("blackoniummod:blackoniumfluid")
	public static final Item item = null;
	private Fluid fluid;
	public BlockBlackoniumfluid(ElementsBlackoniumMod instance) {
		super(instance, 2);
		fluid = new Fluid("blackoniumfluid", new ResourceLocation("blackoniummod:blocks/still"), new ResourceLocation("blackoniummod:blocks/flow"))
				.setLuminosity(0).setDensity(12000).setViscosity(800).setGaseous(false);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockFluidClassic(fluid, Material.WATER) {
			@Override
			public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
				super.onEntityCollidedWithBlock(world, pos, state, entity);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureBlackoniumfluidMobplayerCollidesBlock.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("blackoniumfluid").setRegistryName("blackoniumfluid"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName("blackoniumfluid"));
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		ModelBakery.registerItemVariants(item);
		ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition() {
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				return new ModelResourceLocation("blackoniummod:blackoniumfluid", "blackoniumfluid");
			}
		});
		ModelLoader.setCustomStateMapper(block, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return new ModelResourceLocation("blackoniummod:blackoniumfluid", "blackoniumfluid");
			}
		});
	}

	@Override
	public void generateWorld(Random random, int chunkX, int chunkZ, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
		boolean dimensionCriteria = false;
		if (dimID == WorldBlackoniumdiemsion.DIMID)
			dimensionCriteria = true;
		if (!dimensionCriteria)
			return;
		int i = chunkX + random.nextInt(16) + 8;
		int j = random.nextInt(256);
		int k = chunkZ + random.nextInt(16) + 8;
		new WorldGenLakes(block).generate(world, random, new BlockPos(i, j, k));
	}
}
