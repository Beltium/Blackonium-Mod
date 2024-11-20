
package mc.beltium.blackoniummod.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import mc.beltium.blackoniummod.procedure.ProcedureBlackoniumarmorLeggingsTickEvent;
import mc.beltium.blackoniummod.procedure.ProcedureBlackoniumarmorHelmetTickEvent;
import mc.beltium.blackoniummod.procedure.ProcedureBlackoniumarmorBootsTickEvent;
import mc.beltium.blackoniummod.procedure.ProcedureBlackoniumarmorBodyTickEvent;
import mc.beltium.blackoniummod.creativetab.TabBeltiumsMod;
import mc.beltium.blackoniummod.ElementsBlackoniumMod;

@ElementsBlackoniumMod.ModElement.Tag
public class ItemBlackoniumarmor extends ElementsBlackoniumMod.ModElement {
	@GameRegistry.ObjectHolder("blackoniummod:blackoniumarmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("blackoniummod:blackoniumarmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("blackoniummod:blackoniumarmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("blackoniummod:blackoniumarmorboots")
	public static final Item boots = null;
	public ItemBlackoniumarmor(ElementsBlackoniumMod instance) {
		super(instance, 11);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("BLACKONIUMARMOR", "blackoniummod:iron_", 15, new int[]{2, 5, 6, 2}, 9,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("block.anvil.place")), 1.5f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				super.onArmorTick(world, entity, itemstack);
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureBlackoniumarmorHelmetTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("blackoniumarmorhelmet").setRegistryName("blackoniumarmorhelmet").setCreativeTab(TabBeltiumsMod.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureBlackoniumarmorBodyTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("blackoniumarmorbody").setRegistryName("blackoniumarmorbody").setCreativeTab(TabBeltiumsMod.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureBlackoniumarmorLeggingsTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("blackoniumarmorlegs").setRegistryName("blackoniumarmorlegs").setCreativeTab(TabBeltiumsMod.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureBlackoniumarmorBootsTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("blackoniumarmorboots").setRegistryName("blackoniumarmorboots").setCreativeTab(TabBeltiumsMod.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("blackoniummod:blackoniumarmorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("blackoniummod:blackoniumarmorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("blackoniummod:blackoniumarmorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("blackoniummod:blackoniumarmorboots", "inventory"));
	}
}
