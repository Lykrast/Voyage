package lykrast.voyage.biomes;

import lykrast.voyage.ColorConstants;
import lykrast.voyage.VoyageBiomes;
import lykrast.voyage.biomebuilder.DefaultFeature;
import lykrast.voyage.init.ConfiguredSurfaceBuilders;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;

public class ForestLushBiome {
  public static Biome FOREST_LUSH = VoyageBiomes.BIOME_TEMPLATE.builder()
      .surfaceBuilder(ConfiguredSurfaceBuilders.CONFIGURED_DEFAULT_GRASS)
      .precipitation(Biome.RainType.RAIN)
      .category(Biome.Category.FOREST)
      .depth(0.1F)
      .scale(0.2F)
      .temperature(0.7F)
      .downfall(0.8F)
      .effects(VoyageBiomes.createDefaultBiomeAmbience()
          .withGrassColor(0x3DD424)
          .withFoliageColor(0x2FB519)
          .setWaterColor(ColorConstants.OCEAN_LUKEWARM_WATER)
          .setWaterFogColor(ColorConstants.OCEAN_LUKEWARM_WATERFOG))
      .addDefaultFeatures(DefaultFeature.LAND_CARVERS, DefaultFeature.DEFAULT_UNDERGROUND_STRUCTURES, DefaultFeature.LAKES, DefaultFeature.SPRINGS, DefaultFeature.DUNGEONS, DefaultFeature.DISKS, DefaultFeature.DEFAULT_FLOWERS, DefaultFeature.DEFAULT_MUSHROOMS, DefaultFeature.EXTRA_DEFAULT_FLOWERS, DefaultFeature.DEFAULT_VEGETATION, DefaultFeature.JUNGLE_GRASS, DefaultFeature.FOREST_TREES, DefaultFeature.FROZEN_TOP_LAYER)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.FOREST_FLOWER_VEGETATION)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_MELON)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.FOREST_FLOWER_TREES)
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SHEEP, 12, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.PIG, 10, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.CHICKEN, 10, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.COW, 8, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.WOLF, 5, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.BAT, 10, 8, 8))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SPIDER, 100, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 95, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.ZOMBIE_VILLAGER, 5, 1, 1))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SKELETON, 100, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.CREEPER, 100, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SLIME, 100, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 10, 1, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.WITCH, 5, 1, 1))
      .build();
}
