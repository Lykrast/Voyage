package lykrast.voyage.biomes;

import com.google.common.collect.ImmutableList;

import lykrast.voyage.ColorConstants;
import lykrast.voyage.VoyageSurfaceBuilders;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
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
		addStructure(Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.004D, MineshaftStructure.Type.MESA)));
		addStructure(Feature.STRONGHOLD.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
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
			
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
					Feature.RANDOM_SELECTOR.withConfiguration(
							new MultipleRandomFeatureConfig(
									ImmutableList.of(
											Feature.FOREST_ROCK.withConfiguration(new BlockBlobConfig(cobble, 1)).func_227227_a_(0.15F), 
											Feature.FOREST_ROCK.withConfiguration(new BlockBlobConfig(cobble, 2)).func_227227_a_(0.05F), 
											Feature.FOREST_ROCK.withConfiguration(new BlockBlobConfig(andesite, 0)).func_227227_a_(0.1F), 
											Feature.FOREST_ROCK.withConfiguration(new BlockBlobConfig(diorite, 0)).func_227227_a_(0.1F), 
											Feature.FOREST_ROCK.withConfiguration(new BlockBlobConfig(granite, 0)).func_227227_a_(0.1F), 
											Feature.FOREST_ROCK.withConfiguration(new BlockBlobConfig(andesite, 1)).func_227227_a_(0.05F), 
											Feature.FOREST_ROCK.withConfiguration(new BlockBlobConfig(diorite, 1)).func_227227_a_(0.05F), 
											Feature.FOREST_ROCK.withConfiguration(new BlockBlobConfig(granite, 1)).func_227227_a_(0.05F)), 
									Feature.FOREST_ROCK.withConfiguration(new BlockBlobConfig(cobble, 0)))
							).withPlacement(Placement.FOREST_ROCK.configure(new FrequencyConfig(6))));
		}
		DefaultBiomeFeatures.addGrassAndDeadBushes(this);
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
	public int getGrassColor(double posX, double posZ) {
		return 0xFFEE96;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public int getFoliageColor() {
		return 0xFFEE96;
	}

}
