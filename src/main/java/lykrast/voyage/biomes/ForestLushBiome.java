package lykrast.voyage.biomes;

import lykrast.voyage.ColorConstants;
import lykrast.voyage.VoyageBiomes;
import lykrast.voyage.init.ConfiguredSurfaceBuilders;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;

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
      .addDefaultFeatureFunctions(
          DefaultBiomeFeatures::withCavesAndCanyons, // addCarvers
          DefaultBiomeFeatures::withStrongholdAndMineshaft, // addStructures
          DefaultBiomeFeatures::withLavaAndWaterLakes, // addLakes
          DefaultBiomeFeatures::withLavaAndWaterSprings, // addSprings
          DefaultBiomeFeatures::withMonsterRoom, // addMonsterRooms
          DefaultBiomeFeatures::withAllForestFlowerGeneration, // addDoubleFlowers
          DefaultBiomeFeatures::withCommonOverworldBlocks, // addStoneVariants
          DefaultBiomeFeatures::withOverworldOres, // addOres
          DefaultBiomeFeatures::withDisks, // addSedimentDisks
          DefaultBiomeFeatures::withJungleGrass,
          DefaultBiomeFeatures::withSugarCaneAndPumpkins,
          DefaultBiomeFeatures::withTallBirches, // tall birch trees
          DefaultBiomeFeatures::withFrozenTopLayer
      )
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.FLOWER_FOREST) // addExtraDefaultFlowers
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_MELON)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.FANCY_OAK_BEES_002)
      .addStructureFeature(StructureFeatures.RUINED_PORTAL)
      .addSpawnFunctions(DefaultBiomeFeatures::withPassiveMobs, // Sheep, pig, chicken, cow
          DefaultBiomeFeatures::withBatsAndHostiles // Bats etc
      )
      .build();
}
