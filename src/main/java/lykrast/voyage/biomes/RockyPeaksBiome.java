package lykrast.voyage.biomes;

import lykrast.voyage.VoyageRegistry;
import lykrast.voyage.init.ConfiguredFeatures;
import lykrast.voyage.init.ConfiguredSurfaceBuilders;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import noobanidus.libs.noobutil.world.gen.BiomeBuilder;
import noobanidus.libs.noobutil.world.gen.ColorConstants;

public class RockyPeaksBiome {
	public static Biome ROCKY_PEAKS = BiomeBuilder.BIOME_TEMPLATE.builder()
			.effects(VoyageRegistry.createDefaultBiomeAmbience()
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
					DefaultBiomeFeatures::withNormalMushroomGeneration, 
					DefaultBiomeFeatures::withEmeraldOre, 
					DefaultBiomeFeatures::withInfestedStone, 
					DefaultBiomeFeatures::withFrozenTopLayer)
			.addSpawnFunctions(
					DefaultBiomeFeatures::withBatsAndHostiles, 
					(o) -> o.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.LLAMA, 5, 4, 6)))
			.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, ConfiguredFeatures.ROCKY_PEAKS_BOULDER)
			.addStructureFeature(StructureFeatures.RUINED_PORTAL_MOUNTAIN)
			.build();
}
