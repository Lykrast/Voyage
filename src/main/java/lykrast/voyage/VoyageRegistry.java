package lykrast.voyage;

import lykrast.voyage.config.ConfigManager;
import lykrast.voyage.init.VoyageBiomes;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import noobanidus.libs.noobutil.config.BiomeConfig;
import noobanidus.libs.noobutil.world.gen.ColorConstants;

import java.util.Objects;

import static net.minecraftforge.common.BiomeDictionary.Type.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class VoyageRegistry {

  @SubscribeEvent(priority = EventPriority.LOW)
  public static void registerBiomes(final RegistryEvent.Register<Biome> event) {
    register(VoyageBiomes.MOUNT, ConfigManager.MOUNT, BiomeType.COOL, OVERWORLD, MOUNTAIN, COLD);
    register(VoyageBiomes.BOG, ConfigManager.BOG, BiomeType.WARM, OVERWORLD, WET, SWAMP);
    register(VoyageBiomes.LAGOON_WARM, ConfigManager.LAGOON_WARM, BiomeType.WARM, OVERWORLD, BEACH, WET, HOT);
    register(VoyageBiomes.LAGOON_LUKEWARM, ConfigManager.LAGOON_LUKEWARM, BiomeType.WARM, OVERWORLD, BEACH, WET);
    register(VoyageBiomes.LAGOON_COLD, ConfigManager.LAGOON_COLD, BiomeType.COOL, OVERWORLD, BEACH, WET, COLD);
    register(VoyageBiomes.STEPPE, ConfigManager.STEPPE, BiomeType.WARM, OVERWORLD, PLAINS, SPARSE, HOT, DRY);
    register(VoyageBiomes.ROCKY_PEAKS, ConfigManager.ROCKY_PEAKS, BiomeType.WARM, OVERWORLD, MOUNTAIN);
    register(VoyageBiomes.DESERT_MIXED, ConfigManager.DESERT_MIXED, BiomeType.DESERT, OVERWORLD, SANDY, HOT, DRY);
    register(VoyageBiomes.DESERT_MIXED_HILLS, ConfigManager.DESERT_MIXED_HILLS, BiomeType.DESERT, OVERWORLD, SANDY, HILLS, HOT, DRY);
    register(VoyageBiomes.FLOWER_PLAINS, ConfigManager.FLOWER_PLAINS, BiomeType.WARM, OVERWORLD, PLAINS);
    register(VoyageBiomes.DESERT_MOUNTAINS, ConfigManager.DESERT_MOUNTAINS, BiomeType.DESERT, OVERWORLD, SANDY, HILLS, MOUNTAIN, HOT, DRY);
    register(VoyageBiomes.DESERT_POLAR, ConfigManager.DESERT_POLAR, BiomeType.ICY, OVERWORLD, SNOWY, WASTELAND, COLD, DRY);
    register(VoyageBiomes.FOREST_LUSH, ConfigManager.FOREST_LUSH, BiomeType.WARM, OVERWORLD, FOREST, DENSE);
    register(VoyageBiomes.ROCK_FIELD, ConfigManager.ROCK_FIELD, BiomeType.WARM, OVERWORLD, HILLS, DRY);
  }

  //Convenience
  private static void register(Biome b, BiomeConfig config, BiomeType managerType, Type... dictTypes) {
    RegistryKey<Biome> biome = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, Objects.requireNonNull(b.getRegistryName()));
    if (config.shouldSpawn()) {
      BiomeManager.addBiome(managerType, new BiomeManager.BiomeEntry(biome, config.weight()));
      BiomeDictionary.addTypes(biome, dictTypes);
    }
  }

  public static BiomeAmbience.Builder createDefaultBiomeAmbience() {
    return new BiomeAmbience.Builder()
        .setWaterColor(0x3F76E4)
        .setWaterFogColor(0x50533)
        .withSkyColor(ColorConstants.getSkyColor(0.2F))
        .setFogColor(0xC0D8FF);
  }
}
