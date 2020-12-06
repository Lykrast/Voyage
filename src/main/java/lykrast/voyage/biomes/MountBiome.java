package lykrast.voyage.biomes;

import lykrast.voyage.ColorConstants;
import lykrast.voyage.VoyageBiomes;
import lykrast.voyage.init.ConfiguredSurfaceBuilders;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;

public class MountBiome {
  public static Biome MOUNT = VoyageBiomes.BIOME_TEMPLATE.builder()
      .surfaceBuilder(ConfiguredSurfaceBuilders.CONFIGURED_MOUNTAIN)
      .effects(VoyageBiomes.createDefaultBiomeAmbience()
          .setWaterColor(ColorConstants.STANDARD_WATER)
          .setWaterFogColor(ColorConstants.STANDARD_WATERFOG))
      .precipitation(Biome.RainType.RAIN)
      .category(Biome.Category.EXTREME_HILLS)
      .depth(4.0F)
      .scale(0.5F)
      .temperature(0.2F)
      .downfall(0.3F)
      .addDefaultFeatureFunctions(
          DefaultBiomeFeatures::withCavesAndCanyons,
          DefaultBiomeFeatures::withStrongholdAndMineshaft,
          DefaultBiomeFeatures::withLavaAndWaterLakes,
          DefaultBiomeFeatures::withMonsterRoom,
          DefaultBiomeFeatures::withCommonOverworldBlocks,
          DefaultBiomeFeatures::withOverworldOres,
          DefaultBiomeFeatures::withDisks,
          DefaultBiomeFeatures::withDefaultFlowers,
          DefaultBiomeFeatures::withBadlandsGrass,
          DefaultBiomeFeatures::withNormalMushroomGeneration,
          DefaultBiomeFeatures::withLavaAndWaterSprings,
          DefaultBiomeFeatures::withEmeraldOre,
          DefaultBiomeFeatures::withInfestedStone,
          DefaultBiomeFeatures::withFrozenTopLayer
      )
      .addSpawnFunctions(
          DefaultBiomeFeatures::withPassiveMobs,
          DefaultBiomeFeatures::withBatsAndHostiles,
          (o) -> o.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.LLAMA, 5, 4, 6))
      )
      .build();
}
