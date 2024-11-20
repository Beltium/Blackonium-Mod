package mc.beltium.blackoniummod.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import mc.beltium.blackoniummod.potion.PotionBlackoniumpotion;
import mc.beltium.blackoniummod.ElementsBlackoniumMod;

@ElementsBlackoniumMod.ModElement.Tag
public class ProcedureBlackoniumfluidMobplayerCollidesBlock extends ElementsBlackoniumMod.ModElement {
	public ProcedureBlackoniumfluidMobplayerCollidesBlock(ElementsBlackoniumMod instance) {
		super(instance, 6);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure BlackoniumfluidMobplayerCollidesBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(PotionBlackoniumpotion.potion, (int) 60, (int) 1));
	}
}
