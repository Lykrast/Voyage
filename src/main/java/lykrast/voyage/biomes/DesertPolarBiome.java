package lykrast.voyage.biomes;

import lykrast.voyage.VoyageRegistry;
import lykrast.voyage.init.ConfiguredSurfaceBuilders;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import noobanidus.libs.noobutil.world.gen.BiomeBuilder;
import noobanidus.libs.noobutil.world.gen.ColorConstants;

public class DesertPolarBiome {
	public static Biome DESERT_POLAR = BiomeBuilder.BIOME_TEMPLATE.builder()
			.surfaceBuilder(ConfiguredSurfaceBuilders.CONFIGURED_POLAR_DESERT)
			.precipitation(Biome.RainType.SNOW)
			.category(Biome.Category.ICY)
			.depth(0.05F)
			.scale(0.0F)
			.temperature(0.0F)
			.downfall(0.0F)
			.effects(VoyageRegistry.createDefaultBiomeAmbience()
					.setWaterColor(ColorConstants.STANDARD_WATER)
					.setWaterFogColor(ColorConstants.STANDARD_WATERFOG))
			.addDefaultFeatureFunctions(
					DefaultBiomeFeatures::withCavesAndCanyons, // addCarvers
					DefaultBiomeFeatures::withStrongholdAndMineshaft, // not equivalent to add structures
					DefaultBiomeFeatures::withLavaLakes, // addDesertLakes
					DefaultBiomeFeatures::withMonsterRoom, // addMonsterRooms
					DefaultBiomeFeatures::withCommonOverworldBlocks, // addStoneVariants
					DefaultBiomeFeatures::withOverworldOres, // addOres
					DefaultBiomeFeatures::withDisks, // addSedimentDisks
					DefaultBiomeFeatures::withNormalMushroomGeneration, // addMushrooms
					DefaultBiomeFeatures::withLavaAndWaterSprings, // addSprings
					DefaultBiomeFeatures::withFrozenTopLayer)
			.addStructureFeature(StructureFeatures.RUINED_PORTAL)
			.addStructureFeature(StructureFeatures.IGLOO)
			.addSpawnFunction(DefaultBiomeFeatures::withSnowyBiomeMobs)
			.temperatureModifier(Biome.TemperatureModifier.FROZEN)
			.build();
}
