package lykrast.voyage;

import lykrast.voyage.biomebuilder.BiomeTemplate;
import lykrast.voyage.biomebuilder.TerraformBiomeBuilder;
import lykrast.voyage.config.BiomeConfig;
import lykrast.voyage.config.ConfigManager;
import lykrast.voyage.init.ConfiguredSurfaceBuilders;
import lykrast.voyage.init.ModBiomes;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static lykrast.voyage.biomebuilder.DefaultFeature.*;
import static net.minecraftforge.common.BiomeDictionary.Type.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class VoyageBiomes {
  public static final BiomeTemplate BIOME_TEMPLATE = new BiomeTemplate(TerraformBiomeBuilder.create()
      .surfaceBuilder(ConfiguredSurfaceBuilders.CONFIGURED_DEFAULT_GRASS)
      .addDefaultFeatures(LAND_CARVERS, DEFAULT_UNDERGROUND_STRUCTURES, DUNGEONS, MINEABLES, ORES, DISKS, DEFAULT_MUSHROOMS, DEFAULT_VEGETATION, SPRINGS, FROZEN_TOP_LAYER)
      .addStructureFeature(StructureFeatures.STRONGHOLD)
      .addStructureFeature(StructureFeatures.MINESHAFT)
      .precipitation(Biome.RainType.RAIN)
      .effects(createDefaultBiomeAmbience()));

  @SubscribeEvent(priority = EventPriority.LOW)
  public static void registerBiomes(final RegistryEvent.Register<Biome> event) {
    register(ModBiomes.MOUNT, ConfigManager.MOUNT, BiomeType.COOL, OVERWORLD, MOUNTAIN, COLD);
    register(ModBiomes.BOG, ConfigManager.BOG, BiomeType.WARM, OVERWORLD, WET, SWAMP);
    register(ModBiomes.LAGOON_WARM, ConfigManager.LAGOON_WARM, BiomeType.WARM, OVERWORLD, BEACH, WET, HOT);
    register(ModBiomes.LAGOON_LUKEWARM, ConfigManager.LAGOON_LUKEWARM, BiomeType.WARM, OVERWORLD, BEACH, WET);
    register(ModBiomes.LAGOON_COLD, ConfigManager.LAGOON_COLD, BiomeType.COOL, OVERWORLD, BEACH, WET, COLD);
    register(ModBiomes.STEPPE, ConfigManager.STEPPE, BiomeType.WARM, OVERWORLD, PLAINS, SPARSE, HOT, DRY);
    register(ModBiomes.ROCKY_PEAKS, ConfigManager.ROCKY_PEAKS, BiomeType.WARM, OVERWORLD, MOUNTAIN);
    register(ModBiomes.DESERT_MIXED, ConfigManager.DESERT_MIXED, BiomeType.DESERT, OVERWORLD, SANDY, HOT, DRY);
    register(ModBiomes.DESERT_MIXED_HILLS, ConfigManager.DESERT_MIXED_HILLS, BiomeType.DESERT, OVERWORLD, SANDY, HILLS, HOT, DRY);
    register(ModBiomes.FLOWER_PLAINS, ConfigManager.FLOWER_PLAINS, BiomeType.WARM, OVERWORLD, PLAINS);
    register(ModBiomes.DESERT_MOUNTAINS, ConfigManager.DESERT_MOUNTAINS, BiomeType.DESERT, OVERWORLD, SANDY, HILLS, MOUNTAIN, HOT, DRY);
    register(ModBiomes.DESERT_POLAR, ConfigManager.DESERT_POLAR, BiomeType.ICY, OVERWORLD, SNOWY, WASTELAND, COLD, DRY);
    register(ModBiomes.FOREST_LUSH, ConfigManager.FOREST_LUSH, BiomeType.WARM, OVERWORLD, FOREST, DENSE);
    register(ModBiomes.ROCK_FIELD, ConfigManager.ROCK_FIELD, BiomeType.WARM, OVERWORLD, HILLS, DRY);
  }

  //Convenience
  private static void register(Biome b, BiomeConfig config, BiomeType managerType, Type... dictTypes) {
    RegistryKey<Biome> biome = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, b.getRegistryName());
    if (config.shouldSpawn()) {
      BiomeManager.addBiome(managerType, new BiomeManager.BiomeEntry(biome, config.weight()));
      BiomeDictionary.addTypes(biome, dictTypes);
    }
  }

  private static int getSkyColor(float temperature) {
    float f = temperature / 3.0F;
    f = MathHelper.clamp(f, -1.0F, 1.0F);
    return MathHelper.hsvToRGB(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
  }

  public static BiomeAmbience.Builder createDefaultBiomeAmbience() {
    return new BiomeAmbience.Builder()
        .setWaterColor(0x3F76E4)
        .setWaterFogColor(0x50533)
        .withSkyColor(getSkyColor(0.2F))
        .setFogColor(0xC0D8FF);
  }
}
