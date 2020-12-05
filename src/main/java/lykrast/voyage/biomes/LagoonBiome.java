package lykrast.voyage.biomes;

import lykrast.voyage.ColorConstants;
import lykrast.voyage.VoyageBiomes;
import lykrast.voyage.biomebuilder.BiomeTemplate;
import lykrast.voyage.biomebuilder.DefaultFeature;
import lykrast.voyage.init.ConfiguredSurfaceBuilders;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;

public class LagoonBiome {
  private static final BiomeTemplate LAGOON_TEMPLATE = new BiomeTemplate(VoyageBiomes.BIOME_TEMPLATE.builder()
      .surfaceBuilder(ConfiguredSurfaceBuilders.CONFIGURED_DEFAULT_GRASS)
      .precipitation(Biome.RainType.RAIN)
      .category(Biome.Category.BEACH)
      .addDefaultFeatures(DefaultFeature.AQUATIC_STRUCTURES, DefaultFeature.OCEAN_CARVERS, DefaultFeature.DEFAULT_UNDERGROUND_STRUCTURES, DefaultFeature.LAKES, DefaultFeature.DUNGEONS, DefaultFeature.DISKS, DefaultFeature.DEFAULT_FLOWERS, DefaultFeature.DEFAULT_MUSHROOMS, DefaultFeature.SPRINGS, DefaultFeature.FROZEN_TOP_LAYER, DefaultFeature.DEFAULT_VEGETATION, DefaultFeature.KELP, DefaultFeature.BADLANDS_GRASS, DefaultFeature.DEFAULT_GRASS)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.TREES_WATER)
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SQUID, 3, 1, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.COD, 15, 3, 6))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SALMON, 15, 1, 5))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.BAT, 10, 8, 8))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SPIDER, 100, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 95, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.DROWNED, 5, 1, 1))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.ZOMBIE_VILLAGER, 5, 1, 1))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SKELETON, 100, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.CREEPER, 100, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SLIME, 100, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 10, 1, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.WITCH, 5, 1, 1)));

  public static Biome LAGOON_COLD = LAGOON_TEMPLATE.builder()
      .effects(VoyageBiomes.createDefaultBiomeAmbience()
          .setWaterColor(ColorConstants.OCEAN_COLD_WATER)
          .setWaterFogColor(ColorConstants.STANDARD_WATERFOG))
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_COLD)
      .depth(-0.3F)
      .scale(0.0125F)
      .temperature(0.5F)
      .downfall(0.5F)
      .build();

  public static Biome LAGOON_LUKEWARM = LAGOON_TEMPLATE.builder()
      .effects(VoyageBiomes.createDefaultBiomeAmbience()
          .setWaterColor(ColorConstants.OCEAN_LUKEWARM_WATER)
          .setWaterFogColor(ColorConstants.OCEAN_LUKEWARM_WATERFOG))
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_WARM)
      .addDefaultFeatures(DefaultFeature.SEAGRASS_ON_STONE)
      .depth(-0.3F)
      .scale(0.0125F)
      .temperature(0.5F)
      .downfall(0.5F)
      .build();

  public static Biome LAGOON_WARM = LAGOON_TEMPLATE.builder()
      .effects(VoyageBiomes.createDefaultBiomeAmbience()
          .setWaterColor(ColorConstants.OCEAN_LUKEWARM_WATER)
          .setWaterFogColor(ColorConstants.OCEAN_LUKEWARM_WATERFOG))
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.WARM_OCEAN_VEGETATION)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SEA_PICKLE)
      .depth(-0.3F)
      .scale(0.0125F)
      .temperature(0.5F)
      .downfall(0.5F)
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.PUFFERFISH, 15, 1, 3))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.TROPICAL_FISH, 25, 8, 8))
      .build();

}
