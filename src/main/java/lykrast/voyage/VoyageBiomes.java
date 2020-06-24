package lykrast.voyage;

import static net.minecraftforge.common.BiomeDictionary.Type.BEACH;
import static net.minecraftforge.common.BiomeDictionary.Type.COLD;
import static net.minecraftforge.common.BiomeDictionary.Type.DENSE;
import static net.minecraftforge.common.BiomeDictionary.Type.DRY;
import static net.minecraftforge.common.BiomeDictionary.Type.FOREST;
import static net.minecraftforge.common.BiomeDictionary.Type.HILLS;
import static net.minecraftforge.common.BiomeDictionary.Type.HOT;
import static net.minecraftforge.common.BiomeDictionary.Type.MOUNTAIN;
import static net.minecraftforge.common.BiomeDictionary.Type.OVERWORLD;
import static net.minecraftforge.common.BiomeDictionary.Type.PLAINS;
import static net.minecraftforge.common.BiomeDictionary.Type.SANDY;
import static net.minecraftforge.common.BiomeDictionary.Type.SNOWY;
import static net.minecraftforge.common.BiomeDictionary.Type.SPARSE;
import static net.minecraftforge.common.BiomeDictionary.Type.SWAMP;
import static net.minecraftforge.common.BiomeDictionary.Type.WASTELAND;
import static net.minecraftforge.common.BiomeDictionary.Type.WET;

import lykrast.voyage.biomes.BogBiome;
import lykrast.voyage.biomes.DesertMixedBiome;
import lykrast.voyage.biomes.DesertMixedHillsBiome;
import lykrast.voyage.biomes.DesertMountainsBiome;
import lykrast.voyage.biomes.DesertPolarBiome;
import lykrast.voyage.biomes.FlowerPlainsBiome;
import lykrast.voyage.biomes.ForestLushBiome;
import lykrast.voyage.biomes.LagoonColdBiome;
import lykrast.voyage.biomes.LagoonLukewarmBiome;
import lykrast.voyage.biomes.LagoonWarmBiome;
import lykrast.voyage.biomes.MountBiome;
import lykrast.voyage.biomes.RockFieldBiome;
import lykrast.voyage.biomes.RockyPeaksBiome;
import lykrast.voyage.biomes.SteppeBiome;
import lykrast.voyage.config.BiomeConfig;
import lykrast.voyage.config.ConfigManager;
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
		register(reg, new MountBiome(), ConfigManager.MOUNT, false, BiomeType.COOL, OVERWORLD, MOUNTAIN, COLD);
		register(reg, new BogBiome(), ConfigManager.BOG, false, BiomeType.WARM, OVERWORLD, WET, SWAMP);
		register(reg, new LagoonWarmBiome(), ConfigManager.LAGOON_WARM, false, BiomeType.WARM, OVERWORLD, BEACH, WET, HOT);
		register(reg, new LagoonLukewarmBiome(), ConfigManager.LAGOON_LUKEWARM, false, BiomeType.WARM, OVERWORLD, BEACH, WET);
		register(reg, new LagoonColdBiome(), ConfigManager.LAGOON_COLD, false, BiomeType.COOL, OVERWORLD, BEACH, WET, COLD);
		register(reg, new SteppeBiome(), ConfigManager.STEPPE, false, BiomeType.WARM, OVERWORLD, PLAINS, SPARSE, HOT, DRY);
		register(reg, new RockyPeaksBiome(), ConfigManager.ROCKY_PEAKS, false, BiomeType.WARM, OVERWORLD, MOUNTAIN);
		register(reg, new DesertMixedBiome(), ConfigManager.DESERT_MIXED, false, BiomeType.DESERT, OVERWORLD, SANDY, HOT, DRY);
		register(reg, new DesertMixedHillsBiome(), ConfigManager.DESERT_MIXED_HILLS, false, BiomeType.DESERT, OVERWORLD, SANDY, HILLS, HOT, DRY);
		register(reg, new FlowerPlainsBiome(), ConfigManager.FLOWER_PLAINS, true, BiomeType.WARM, OVERWORLD, PLAINS);
		register(reg, new DesertMountainsBiome(), ConfigManager.DESERT_MOUNTAINS, false, BiomeType.DESERT, OVERWORLD, SANDY, HILLS, MOUNTAIN, HOT, DRY);
		register(reg, new DesertPolarBiome(), ConfigManager.DESERT_POLAR, false, BiomeType.ICY, OVERWORLD, SNOWY, WASTELAND, COLD, DRY);
		register(reg, new ForestLushBiome(), ConfigManager.FOREST_LUSH, true, BiomeType.WARM, OVERWORLD, FOREST, DENSE);
		register(reg, new RockFieldBiome(), ConfigManager.ROCK_FIELD, false, BiomeType.WARM, OVERWORLD, HILLS, DRY);
	}
	
	//Convenience
	private static Biome register(IForgeRegistry<Biome> reg, Biome biome, BiomeConfig config, boolean canSpawn, BiomeType managerType, Type... dictTypes) {
		//Config part from Traverse, nooby said is cool (and MIT)
		//https://github.com/MysticMods/Traverse/blob/master/src/main/java/epicsquid/traverse/RegistryManager.java
		reg.register(biome.setRegistryName(Voyage.loc(config.name())));
		if (config.shouldSpawn()) {
			BiomeManager.addBiome(managerType, new BiomeManager.BiomeEntry(biome, config.weight()));
			if (canSpawn) BiomeManager.addSpawnBiome(biome);
			BiomeDictionary.addTypes(biome, dictTypes);
		}
		return biome;
	}
}
