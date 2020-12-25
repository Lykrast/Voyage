package lykrast.voyage.biomes;

import lykrast.voyage.VoyageRegistry;
import lykrast.voyage.init.ConfiguredSurfaceBuilders;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import noobanidus.libs.noobutil.world.gen.BiomeBuilder;
import noobanidus.libs.noobutil.world.gen.ColorConstants;

public class FlowerPlainsBiome {
	public static Biome FLOWER_PLAINS = BiomeBuilder.BIOME_TEMPLATE.builder()
			.surfaceBuilder(ConfiguredSurfaceBuilders.CONFIGURED_DEFAULT_GRASS)
			.precipitation(Biome.RainType.RAIN)
			.category(Biome.Category.PLAINS)
			.depth(0.125F)
			.scale(0.025F)
			.temperature(0.7F)
			.downfall(0.8F)
			.effects(VoyageRegistry.createDefaultBiomeAmbience()
					.setWaterColor(ColorConstants.STANDARD_WATER)
					.setWaterFogColor(ColorConstants.PLAINS_WATERFOG))
			.addDefaultFeatureFunctions(
					DefaultBiomeFeatures::withCavesAndCanyons, // addCarvers
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
					DefaultBiomeFeatures::withAllForestFlowerGeneration, // addDoubleFlowers
					DefaultBiomeFeatures::withFrozenTopLayer)
			.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.FLOWER_FOREST) // addExtraDefaultFlowers
			.addStructureFeature(StructureFeatures.RUINED_PORTAL)
			.addSpawnFunction(DefaultBiomeFeatures::withSpawnsWithHorseAndDonkey)
			.build();
}
