package lykrast.voyage.biomes;

import lykrast.voyage.ColorConstants;
import lykrast.voyage.VoyageBiomes;
import lykrast.voyage.biomebuilder.DefaultFeature;
import lykrast.voyage.init.ConfiguredSurfaceBuilders;
import lykrast.voyage.init.ModFeatures;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;

public class RockyPeaksBiome {
  public static Biome ROCKY_PEAKS = VoyageBiomes.BIOME_TEMPLATE.builder()
       .effects(VoyageBiomes.createDefaultBiomeAmbience()
          .setWaterColor(ColorConstants.STANDARD_WATER)
          .setWaterFogColor(ColorConstants.STANDARD_WATERFOG))
      .surfaceBuilder(ConfiguredSurfaceBuilders.CONFIGURED_PEAKS)
      .precipitation(Biome.RainType.RAIN)
      .category(Biome.Category.EXTREME_HILLS)
      .depth(1.0F)
      .scale(1.1F)
      .temperature(0.7F)
      .downfall(0.8F)
      .addDefaultFeatureFunctions(
          DefaultBiomeFeatures::withStrongholdAndMineshaft,
          DefaultBiomeFeatures::withCavesAndCanyons,
          DefaultBiomeFeatures::withLavaAndWaterLakes,
          DefaultBiomeFeatures::withMonsterRoom,
          DefaultBiomeFeatures::withCommonOverworldBlocks,
          DefaultBiomeFeatures::withOverworldOres,
          DefaultBiomeFeatures::withDisks,
          DefaultBiomeFeatures::withLavaAndWaterSprings,
          DefaultBiomeFeatures::withMushroomBiomeVegetation,
          DefaultBiomeFeatures::withEmeraldOre,
          DefaultBiomeFeatures::withInfestedStone,
          DefaultBiomeFeatures::withFrozenTopLayer
      )
      .addSpawnFunctions(
          DefaultBiomeFeatures::withBatsAndHostiles,
          (o) -> o.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.LLAMA, 5, 4, 6))
      )
      .addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, ModFeatures.ROCK_BOULDERS) // TODO: IMPROVE
      .build();
}
