package lykrast.voyage.biomes;

import lykrast.voyage.ColorConstants;
import lykrast.voyage.VoyageBiomes;
import lykrast.voyage.biomebuilder.BiomeTemplate;
import lykrast.voyage.biomebuilder.DefaultFeature;
import lykrast.voyage.init.ConfiguredSurfaceBuilders;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.feature.structure.StructureFeatures;

public class DesertBiome {
  public static final BiomeTemplate DESERT_TEMPLATE = new BiomeTemplate(VoyageBiomes.BIOME_TEMPLATE.builder()
      .surfaceBuilder(ConfiguredSurfaceBuilders.CONFIGURED_DESERT_MIXED)
      .precipitation(Biome.RainType.NONE)
      .category(Biome.Category.DESERT)
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
          DefaultBiomeFeatures::withDefaultFlowers, // addDefaultFlowers
          DefaultBiomeFeatures::withBadlandsGrassAndBush, // Possibly Add Sparse Grass and Add Dead Bushes
          DefaultBiomeFeatures::withNormalMushroomGeneration, // addMushrooms
          DefaultBiomeFeatures::withDesertVegetation, // addExtraReedsPumpkinsCactus
          DefaultBiomeFeatures::withLavaAndWaterSprings, // addSprings
          DefaultBiomeFeatures::withDesertWells, // addDesertFeatures
          DefaultBiomeFeatures::withFossils, // second part of addDesertFeatures
          DefaultBiomeFeatures::withFrozenTopLayer
      )
      .addStructureFeature(StructureFeatures.RUINED_PORTAL_DESERT)
      .addSpawnFunction(DefaultBiomeFeatures::withDesertMobs)
      .temperature(2.0F)
      .downfall(0.0F));

  public static Biome DESERT_MIXED = DESERT_TEMPLATE.builder()
      .addStructureFeature(StructureFeatures.PILLAGER_OUTPOST)
      .addStructureFeature(StructureFeatures.VILLAGE_DESERT)
      .addStructureFeature(StructureFeatures.DESERT_PYRAMID)
      .depth(0.125F)
      .scale(0.05F)
      .build();


  public static Biome DESERT_MIXED_HILLS = DESERT_TEMPLATE.builder()
      .depth(0.45F)
      .scale(0.3F)
      .build();

  public static Biome DESERT_MOUNTAINS = DESERT_TEMPLATE.builder()
      .surfaceBuilder(ConfiguredSurfaceBuilders.CONFIGURED_DESERT)
      .depth(1.0f)
      .scale(0.5f)
      .build();
}