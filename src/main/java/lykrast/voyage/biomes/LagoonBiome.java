package lykrast.voyage.biomes;

import lykrast.voyage.ColorConstants;
import lykrast.voyage.VoyageRegistry;
import lykrast.voyage.init.ConfiguredSurfaceBuilders;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;

public class LagoonBiome {
  private static final BiomeBuilder.BiomeTemplate LAGOON_TEMPLATE = new BiomeBuilder.BiomeTemplate(BiomeBuilder.BIOME_TEMPLATE.builder()
      .surfaceBuilder(ConfiguredSurfaceBuilders.CONFIGURED_DEFAULT_GRASS)
      .precipitation(Biome.RainType.RAIN)
      .category(Biome.Category.BEACH)
      .addDefaultFeatureFunctions(
          DefaultBiomeFeatures::withOceanCavesAndCanyons,
          DefaultBiomeFeatures::withOceanStructures,
          DefaultBiomeFeatures::withLavaAndWaterLakes,
          DefaultBiomeFeatures::withMonsterRoom,
          DefaultBiomeFeatures::withCommonOverworldBlocks,
          DefaultBiomeFeatures::withOverworldOres,
          DefaultBiomeFeatures::withDisks,
          DefaultBiomeFeatures::withTreesInWater, // addScatteredOakTrees
          DefaultBiomeFeatures::withDefaultFlowers,
          DefaultBiomeFeatures::withNormalMushroomGeneration,
          DefaultBiomeFeatures::withSugarCaneAndPumpkins,
          DefaultBiomeFeatures::withLavaAndWaterSprings,
          DefaultBiomeFeatures::withFrozenTopLayer
      )
      .addStructureFeature(StructureFeatures.BURIED_TREASURE));

  public static Biome LAGOON_COLD = LAGOON_TEMPLATE.builder()
      .effects(VoyageRegistry.createDefaultBiomeAmbience()
          .setWaterColor(ColorConstants.OCEAN_COLD_WATER)
          .setWaterFogColor(ColorConstants.STANDARD_WATERFOG))
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_COLD)
      .addSpawnFunction((o) -> DefaultBiomeFeatures.withOceanMobs(o, 3, 4, 15))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SALMON, 15, 1, 5))
      .addDefaultFeatureFunction(
          DefaultBiomeFeatures::withNormalGrassPatch
      )
      .depth(-0.3F)
      .scale(0.0125F)
      .temperature(0.5F)
      .downfall(0.5F)
      .build();

  public static Biome LAGOON_LUKEWARM = LAGOON_TEMPLATE.builder()
      .effects(VoyageRegistry.createDefaultBiomeAmbience()
          .setWaterColor(ColorConstants.OCEAN_LUKEWARM_WATER)
          .setWaterFogColor(ColorConstants.OCEAN_LUKEWARM_WATERFOG))
      .addDefaultFeatureFunctions(
          DefaultBiomeFeatures::withWarmKelp,
          DefaultBiomeFeatures::withNormalGrassPatch
      )
      .addSpawnFunctions(
          (o) -> DefaultBiomeFeatures.withOceanMobs(o, 3, 4, 15),
          (o) -> o.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.TURTLE, 5, 2, 5))
      )
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.PUFFERFISH, 5, 1, 3))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.TROPICAL_FISH, 25, 8, 8))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.DOLPHIN, 2, 1, 2))
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_WARM)
      .depth(-0.3F)
      .scale(0.0125F)
      .temperature(0.5F)
      .downfall(0.5F)
      .build();

  public static Biome LAGOON_WARM = LAGOON_TEMPLATE.builder()
      .effects(VoyageRegistry.createDefaultBiomeAmbience()
          .setWaterColor(ColorConstants.OCEAN_WARM_WATER)
          .setWaterFogColor(ColorConstants.OCEAN_WARM_WATERFOG))
      .addDefaultFeatureFunctions(
          DefaultBiomeFeatures::withBadlandsGrass
      )
      .addSpawnFunctions(
          (o) -> DefaultBiomeFeatures.withOceanMobs(o, 1, 4, 10),
          (o) -> DefaultBiomeFeatures.withWarmOceanMobs(o, 10, 4),
          (o) -> o.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.TURTLE, 5, 2, 5))
      )
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.DOLPHIN, 1, 1, 2))
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.WARM_OCEAN_VEGETATION)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_WARM)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SEA_PICKLE)
      .depth(-0.3F)
      .scale(0.0125F)
      .temperature(0.5F)
      .downfall(0.5F)
      .build();

}
