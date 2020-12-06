package lykrast.voyage.biomes;

import lykrast.voyage.ColorConstants;
import lykrast.voyage.VoyageRegistry;
import lykrast.voyage.init.ConfiguredSurfaceBuilders;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;

public class SteppeBiome {
  public static Biome STEPPE = BiomeBuilder.BIOME_TEMPLATE.builder()
      .effects(VoyageRegistry.createDefaultBiomeAmbience()
          .setWaterColor(ColorConstants.STANDARD_WATER)
          .setWaterFogColor(ColorConstants.STANDARD_WATERFOG))
      .surfaceBuilder(ConfiguredSurfaceBuilders.CONFIGURED_STEPPE)
      .precipitation(Biome.RainType.RAIN)
      .category(Biome.Category.PLAINS)
      .depth(0.125F)
      .scale(0.05F)
      .temperature(1.2F)
      .downfall(0.0F)
      .addDefaultFeatureFunctions(
          DefaultBiomeFeatures::withStrongholdAndMineshaft,
          DefaultBiomeFeatures::withCavesAndCanyons,
          DefaultBiomeFeatures::withLavaAndWaterLakes,
          DefaultBiomeFeatures::withMonsterRoom,
          DefaultBiomeFeatures::withNoiseTallGrass,
          DefaultBiomeFeatures::withCommonOverworldBlocks,
          DefaultBiomeFeatures::withOverworldOres,
          DefaultBiomeFeatures::withDesertDeadBushes,
          DefaultBiomeFeatures::withNormalMushroomGeneration,
          DefaultBiomeFeatures::withSugarCaneAndPumpkins,
          DefaultBiomeFeatures::withLavaAndWaterSprings,
          DefaultBiomeFeatures::withFrozenTopLayer
      )
      .addStructureFeature(StructureFeatures.VILLAGE_SAVANNA)
      .addStructureFeature(StructureFeatures.PILLAGER_OUTPOST)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_NORMAL)
      .addStructureFeature(StructureFeatures.RUINED_PORTAL)
      .addSpawnFunctions(
          DefaultBiomeFeatures::withPassiveMobs,
          DefaultBiomeFeatures::withBatsAndHostiles
      )
      .build();
}
