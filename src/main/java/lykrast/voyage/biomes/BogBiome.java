package lykrast.voyage.biomes;

import lykrast.voyage.ColorConstants;
import lykrast.voyage.VoyageRegistry;
import lykrast.voyage.init.ConfiguredSurfaceBuilders;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;

public class BogBiome {
  public static final Biome BOG_BIOME = BiomeBuilder.BIOME_TEMPLATE.builder()
      .surfaceBuilder(ConfiguredSurfaceBuilders.CONFIGURED_GRASSY_SWAMP)
      .precipitation(Biome.RainType.RAIN)
      .category(Biome.Category.SWAMP)
      .depth(-0.2f)
      .scale(0.0f)
      .temperature(0.8f)
      .downfall(0.9f)
      .effects(VoyageRegistry.createDefaultBiomeAmbience()
          .setWaterColor(ColorConstants.SWAMP_WATER)
          .setWaterFogColor(ColorConstants.SWAMP_WATERFOG))
      .addDefaultFeatureFunctions(DefaultBiomeFeatures::withCavesAndCanyons, // addCarvers
          DefaultBiomeFeatures::withStrongholdAndMineshaft, // Not equivalent to addStructures
          DefaultBiomeFeatures::withLavaAndWaterLakes, // addLakes
          DefaultBiomeFeatures::withMonsterRoom, // addMonsterRooms
          DefaultBiomeFeatures::withCommonOverworldBlocks, // addStoneVariants
          DefaultBiomeFeatures::withOverworldOres, // addOres
          DefaultBiomeFeatures::withClayDisks, // addSwampClayDisks
          DefaultBiomeFeatures::withJungleGrass, // addJungleGrass
          DefaultBiomeFeatures::withNormalMushroomGeneration, // addMushrooms
          DefaultBiomeFeatures::withLavaAndWaterSprings, // addSprings
          DefaultBiomeFeatures::withBadlandsVegetation, // func_222329_ae
          DefaultBiomeFeatures::withFossils, // addFossils
          DefaultBiomeFeatures::withFrozenTopLayer // addFreezeTopLayer
      )
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_NORMAL)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_DEAD_BUSH)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.BROWN_MUSHROOM_SWAMP)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.RED_MUSHROOM_SWAMP)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_SUGAR_CANE_SWAMP) // Not sure if this precisely equivalent
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_PUMPKIN)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_SWAMP)
      .addStructureFeature(StructureFeatures.RUINED_PORTAL_SWAMP)
      .addSpawnFunctions(DefaultBiomeFeatures::withPassiveMobs, // Sheep, pig, hchicken, cow
          DefaultBiomeFeatures::withBatsAndHostiles // Bats etc
      )
      .build();
}
