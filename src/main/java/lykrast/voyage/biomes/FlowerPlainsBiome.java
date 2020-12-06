package lykrast.voyage.biomes;

import lykrast.voyage.ColorConstants;
import lykrast.voyage.VoyageBiomes;
import lykrast.voyage.init.ConfiguredSurfaceBuilders;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;

public class FlowerPlainsBiome {
  public static Biome FLOWER_PLAINS = VoyageBiomes.BIOME_TEMPLATE.builder()
      .surfaceBuilder(ConfiguredSurfaceBuilders.CONFIGURED_DEFAULT_GRASS)
      .precipitation(Biome.RainType.RAIN)
      .category(Biome.Category.PLAINS)
      .depth(0.125F)
      .scale(0.025F)
      .temperature(0.7F)
      .downfall(0.8F)
      .effects(VoyageBiomes.createDefaultBiomeAmbience()
          .setWaterColor(ColorConstants.STANDARD_WATER)
          .setWaterFogColor(ColorConstants.STANDARD_WATERFOG))
      .addDefaultFeatureFunctions(DefaultBiomeFeatures::withCavesAndCanyons, // addCarvers
          DefaultBiomeFeatures::withStrongholdAndMineshaft, // part of addStructures
          DefaultBiomeFeatures::withLavaAndWaterLakes, // addLakes
          DefaultBiomeFeatures::withMonsterRoom, // addMonsterRooms
          DefaultBiomeFeatures::withNoiseTallGrass, // addPlainsTallGrass
          DefaultBiomeFeatures::withCommonOverworldBlocks, // addStoneVariants
          DefaultBiomeFeatures::withOverworldOres, // addOres
          DefaultBiomeFeatures::withDisks, // addSedimentDisks
          DefaultBiomeFeatures::withBadlandsGrass, // addSparseGrass
          DefaultBiomeFeatures::withNormalMushroomGeneration, // addMushrooms
          DefaultBiomeFeatures::withSugarCaneAndPumpkins, // addReedsandPumpkins
          DefaultBiomeFeatures::withLavaAndWaterSprings, // addSprings
          DefaultBiomeFeatures::withFrozenTopLayer
      )
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.FOREST_FLOWER_VEGETATION_COMMON)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.FLOWER_FOREST)
      .addStructureFeature(StructureFeatures.RUINED_PORTAL)
      .addSpawnFunction(DefaultBiomeFeatures::withSpawnsWithHorseAndDonkey)
      .build();
}
