package lykrast.voyage.biomes;

import lykrast.voyage.VoyageRegistry;
import lykrast.voyage.init.ConfiguredFeatures;
import lykrast.voyage.init.ConfiguredSurfaceBuilders;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import noobanidus.libs.noobutil.world.gen.BiomeBuilder;
import noobanidus.libs.noobutil.world.gen.ColorConstants;

public class ForestLushBiome {
	public static Biome FOREST_LUSH = BiomeBuilder.BIOME_TEMPLATE.builder()
			.surfaceBuilder(ConfiguredSurfaceBuilders.CONFIGURED_DEFAULT_GRASS)
			.precipitation(Biome.RainType.RAIN)
			.category(Biome.Category.FOREST)
			.depth(0.1F)
			.scale(0.2F)
			.temperature(0.7F)
			.downfall(0.8F)
			.effects(VoyageRegistry.createDefaultBiomeAmbience()
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
					DefaultBiomeFeatures::withFrozenTopLayer)
			.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ConfiguredFeatures.LUSH_TREES)
			.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.FLOWER_FOREST) // addExtraDefaultFlowers
			.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_MELON)
			.addStructureFeature(StructureFeatures.RUINED_PORTAL)
			.addSpawnFunctions(
					DefaultBiomeFeatures::withPassiveMobs, // Sheep, pig, chicken, cow
					DefaultBiomeFeatures::withBatsAndHostiles) // Bats etc
			.build();
}
