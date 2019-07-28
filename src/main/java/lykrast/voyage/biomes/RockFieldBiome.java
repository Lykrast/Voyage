package lykrast.voyage.biomes;

import java.util.Arrays;

import lykrast.voyage.ColorConstants;
import lykrast.voyage.VoyageSurfaceBuilders;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.BlockBlobConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class RockFieldBiome extends Biome {

	public RockFieldBiome() {
		super((new Biome.Builder())
				.surfaceBuilder(VoyageSurfaceBuilders.ROCK_FIELD, SurfaceBuilder.STONE_STONE_GRAVEL_CONFIG)
				.precipitation(RainType.RAIN).category(Category.SAVANNA)
				.depth(0.1F).scale(0.2F).temperature(2.0F).downfall(0.0F)
				.waterColor(ColorConstants.STANDARD_WATER).waterFogColor(ColorConstants.STANDARD_WATERFOG));
		//Adapted from Badlands
		addStructure(Feature.MINESHAFT, new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL));
		addStructure(Feature.STRONGHOLD, IFeatureConfig.NO_FEATURE_CONFIG);
		DefaultBiomeFeatures.addCarvers(this);
		DefaultBiomeFeatures.addStructures(this);
		DefaultBiomeFeatures.addLakes(this);
		DefaultBiomeFeatures.addMonsterRooms(this);
		DefaultBiomeFeatures.addStoneVariants(this);
		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addSedimentDisks(this);
		{
			//Boulders
			BlockState cobble = Blocks.COBBLESTONE.getDefaultState();
			BlockState andesite = Blocks.ANDESITE.getDefaultState();
			BlockState diorite = Blocks.DIORITE.getDefaultState();
			BlockState granite = Blocks.GRANITE.getDefaultState();
			
			Feature<?>[] features = new Feature[8];
			Arrays.fill(features, Feature.FOREST_ROCK);
			
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
					Biome.createDecoratedFeature(Feature.RANDOM_SELECTOR,
							new MultipleRandomFeatureConfig(features,
									new IFeatureConfig[] { 
											new BlockBlobConfig(cobble, 1),
											new BlockBlobConfig(cobble, 2),
											new BlockBlobConfig(andesite, 0),
											new BlockBlobConfig(diorite, 0),
											new BlockBlobConfig(granite, 0), 
											new BlockBlobConfig(andesite, 1),
											new BlockBlobConfig(diorite, 1),
											new BlockBlobConfig(granite, 1)
											},
									new float[] { 0.15F, 0.05F, 0.1F, 0.1F, 0.1F, 0.05F, 0.05F, 0.05F }, Feature.FOREST_ROCK,
									new BlockBlobConfig(cobble, 0)),
							Placement.FOREST_ROCK, new FrequencyConfig(6)));
		}
		DefaultBiomeFeatures.func_222308_M(this);
		DefaultBiomeFeatures.addMushrooms(this);
		DefaultBiomeFeatures.addReedsPumpkinsCactus(this);
		DefaultBiomeFeatures.addSprings(this);
		DefaultBiomeFeatures.addFreezeTopLayer(this);
		addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
		addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
		addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
		addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
		addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
		addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
		addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
		addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
		addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public int getGrassColor(BlockPos pos) {
		return 0xFFEE96;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public int getFoliageColor(BlockPos pos) {
		return 0xFFEE96;
	}

}
