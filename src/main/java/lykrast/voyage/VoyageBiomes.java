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
		register(reg, new MountBiome(), "mount", 5, false, BiomeType.COOL, OVERWORLD, MOUNTAIN, COLD);
		register(reg, new BogBiome(), "bog", 10, false, BiomeType.WARM, OVERWORLD, WET, SWAMP);
		register(reg, new LagoonWarmBiome(), "lagoon_warm", 10, false, BiomeType.WARM, OVERWORLD, BEACH, WET, HOT);
		register(reg, new LagoonLukewarmBiome(), "lagoon_lukewarm", 10, false, BiomeType.WARM, OVERWORLD, BEACH, WET);
		register(reg, new LagoonColdBiome(), "lagoon_cold", 10, false, BiomeType.COOL, OVERWORLD, BEACH, WET, COLD);
		register(reg, new SteppeBiome(), "steppe", 10, false, BiomeType.WARM, OVERWORLD, PLAINS, SPARSE, HOT, DRY);
		register(reg, new RockyPeaksBiome(), "rocky_peaks", 8, false, BiomeType.WARM, OVERWORLD, MOUNTAIN);
		register(reg, new DesertMixedBiome(), "desert_mixed", 10, false, BiomeType.DESERT, OVERWORLD, SANDY, HOT, DRY);
		register(reg, new DesertMixedHillsBiome(), "desert_mixed_hills", 10, false, BiomeType.DESERT, OVERWORLD, SANDY, HILLS, HOT, DRY);
		register(reg, new FlowerPlainsBiome(), "flower_plains", 10, true, BiomeType.WARM, OVERWORLD, PLAINS);
		register(reg, new DesertMountainsBiome(), "desert_mountains", 10, false, BiomeType.DESERT, OVERWORLD, SANDY, HILLS, MOUNTAIN, HOT, DRY);
		register(reg, new DesertPolarBiome(), "desert_polar", 10, false, BiomeType.ICY, OVERWORLD, SNOWY, WASTELAND, COLD, DRY);
		register(reg, new ForestLushBiome(), "forest_lush", 5, true, BiomeType.WARM, OVERWORLD, FOREST, DENSE);
		register(reg, new RockFieldBiome(), "rock_field", 10, false, BiomeType.WARM, OVERWORLD, HILLS, DRY);
	}
	
	//Convenience
	private static Biome register(IForgeRegistry<Biome> reg, Biome biome, String name, int weight, boolean canSpawn, BiomeType managerType, Type... dictTypes) {
		reg.register(biome.setRegistryName(Voyage.loc(name)));
		BiomeManager.addBiome(managerType, new BiomeManager.BiomeEntry(biome, weight));
		if (canSpawn) BiomeManager.addSpawnBiome(biome);
		BiomeDictionary.addTypes(biome, dictTypes);
		return biome;
	}
}
