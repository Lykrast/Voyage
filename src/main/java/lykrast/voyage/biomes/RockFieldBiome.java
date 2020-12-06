package lykrast.voyage.biomes;

import lykrast.voyage.ColorConstants;
import lykrast.voyage.VoyageBiomes;
import lykrast.voyage.biomebuilder.DefaultFeature;
import lykrast.voyage.init.ConfiguredSurfaceBuilders;
import lykrast.voyage.init.ModFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;

public class RockFieldBiome {
  public static Biome ROCK_FIELD = VoyageBiomes.BIOME_TEMPLATE.builder()
      .effects(VoyageBiomes.createDefaultBiomeAmbience()
          .withGrassColor(0xFFEE96)
          .withFoliageColor(0xFFEE96)
          .setWaterColor(ColorConstants.STANDARD_WATER)
          .setWaterFogColor(ColorConstants.STANDARD_WATERFOG))
      .surfaceBuilder(ConfiguredSurfaceBuilders.CONFIGURED_ROCKY)
      .precipitation(Biome.RainType.RAIN)
      .category(Biome.Category.SAVANNA)
      .depth(0.1F)
      .scale(0.2F)
      .temperature(2.0F)
      .downfall(0.0F)
      .addDefaultFeatureFunctions(
          DefaultBiomeFeatures::withBadlandsStructures,
          DefaultBiomeFeatures::withCavesAndCanyons,
          DefaultBiomeFeatures::withLavaAndWaterLakes,
          DefaultBiomeFeatures::withMonsterRoom,
          DefaultBiomeFeatures::withCommonOverworldBlocks,
          DefaultBiomeFeatures::withOverworldOres,
          DefaultBiomeFeatures::withDisks,
          DefaultBiomeFeatures::withBadlandsGrassAndBush,
          DefaultBiomeFeatures::withMushroomBiomeVegetation,
          DefaultBiomeFeatures::withLavaAndWaterSprings,
          DefaultBiomeFeatures::withFrozenTopLayer
      )
      .addSpawnFunction(DefaultBiomeFeatures::withBatsAndHostiles)
      .addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, ModFeatures.ROCK_BOULDERS) // TODO: Improve this
      .build();
}
