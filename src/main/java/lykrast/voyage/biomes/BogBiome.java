package lykrast.voyage.biomes;

import lykrast.voyage.VoyageBiomes;
import lykrast.voyage.biomebuilder.DefaultFeature;
import lykrast.voyage.init.ConfiguredSurfaceBuilders;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;

public class BogBiome {
  public static final Biome BOG_BIOME = VoyageBiomes.BIOME_TEMPLATE.builder()
      .surfaceBuilder(ConfiguredSurfaceBuilders.CONFIGURED_GRASSY_SWAMP)
      .precipitation(Biome.RainType.RAIN)
      .category(Biome.Category.SWAMP)
      .depth(-0.2f)
      .scale(0.0f)
      .temperature(0.8f)
      .downfall(0.9f)
      .addDefaultFeatures(DefaultFeature.CLAY, DefaultFeature.LAKES, DefaultFeature.JUNGLE_GRASS, DefaultFeature.SPRINGS, DefaultFeature.DEFAULT_MUSHROOMS, DefaultFeature.FOSSILS, DefaultFeature.FROZEN_TOP_LAYER)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.FLOWER_SWAMP)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_DEAD_BUSH_2)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_BROWN_MUSHROOM)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_RED_MUSHROOM)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_SUGAR_CANE_SWAMP)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_PUMPKIN)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_SWAMP)
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SHEEP, 12, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.PIG, 10, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.CHICKEN, 10, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.COW, 8, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.BAT, 10, 8, 8))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SPIDER, 100, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 95, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.ZOMBIE_VILLAGER, 5, 1, 1))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SKELETON, 100, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.CREEPER, 100, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SLIME, 100, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 10, 1, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.WITCH, 5, 1, 1)).build();
}
