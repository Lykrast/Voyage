package lykrast.voyage.biomes;

import lykrast.voyage.ColorConstants;
import lykrast.voyage.VoyageBiomes;
import lykrast.voyage.biomebuilder.DefaultFeature;
import lykrast.voyage.init.ConfiguredSurfaceBuilders;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.feature.structure.StructureFeatures;

public class DesertPolarBiome {
  public static Biome DESERT_POLAR = VoyageBiomes.BIOME_TEMPLATE.builder()
      .surfaceBuilder(ConfiguredSurfaceBuilders.CONFIGURED_POLAR_DESERT)
      .precipitation(Biome.RainType.SNOW)
      .category(Biome.Category.ICY)
      .depth(0.05F)
      .scale(0.0F)
      .temperature(0.0F)
      .downfall(0.0F)
      .effects(VoyageBiomes.createDefaultBiomeAmbience()
          .setWaterColor(ColorConstants.STANDARD_WATER)
          .setWaterFogColor(ColorConstants.STANDARD_WATERFOG))
      .addDefaultFeatureFunctions(DefaultBiomeFeatures::withCavesAndCanyons, // addCarvers
          DefaultBiomeFeatures::withStrongholdAndMineshaft, // not equivalent to add structures
          DefaultBiomeFeatures::withLavaLakes, // addDesertLakes
          DefaultBiomeFeatures::withMonsterRoom, // addMonsterRooms
          DefaultBiomeFeatures::withCommonOverworldBlocks, // addStoneVariants
          DefaultBiomeFeatures::withOverworldOres, // addOres
          DefaultBiomeFeatures::withDisks, // addSedimentDisks
          DefaultBiomeFeatures::withNormalMushroomGeneration, // addMushrooms
          DefaultBiomeFeatures::withLavaAndWaterSprings, // addSprings
          DefaultBiomeFeatures::withFrozenTopLayer
      )
      .addStructureFeature(StructureFeatures.RUINED_PORTAL_DESERT)
      .addSpawnFunction(DefaultBiomeFeatures::withSnowyBiomeMobs)
      .build();
}
