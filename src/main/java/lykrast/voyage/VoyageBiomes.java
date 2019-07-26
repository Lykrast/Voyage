package lykrast.voyage;

import static net.minecraftforge.common.BiomeDictionary.Type.*;

import lykrast.voyage.biomes.*;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
//@ObjectHolder(Voyage.MODID)
public class VoyageBiomes {
	@SubscribeEvent
	public static void registerBiomes(final RegistryEvent.Register<Biome> event) {
		IForgeRegistry<Biome> reg = event.getRegistry();
		register(reg, new MountBiome(), "mount", 10, false, BiomeType.COOL, MOUNTAIN, COLD);
		register(reg, new BogBiome(), "bog", 10, false, BiomeType.WARM, WET, SWAMP);
		register(reg, new LagoonWarmBiome(), "lagoon_warm", 10, false, BiomeType.WARM, BEACH, WET, HOT);
		register(reg, new LagoonLukewarmBiome(), "lagoon_lukewarm", 10, true, BiomeType.WARM, BEACH, WET);
		register(reg, new LagoonColdBiome(), "lagoon_cold", 10, true, BiomeType.COOL, BEACH, WET, COLD);
	}
	
	//Convenience
	private static Biome register(IForgeRegistry<Biome> reg, Biome biome, String name, int weight, boolean canSpawn, BiomeType managerType, Type... dictTypes) {
		reg.register(biome.setRegistryName(Voyage.MODID, name));
		BiomeManager.addBiome(managerType, new BiomeManager.BiomeEntry(biome, weight));
		if (canSpawn) BiomeManager.addSpawnBiome(biome);
		BiomeDictionary.addTypes(biome, dictTypes);
		return biome;
	}
}
