package lykrast.voyage.init;

import com.google.common.collect.ImmutableList;
import lykrast.voyage.Voyage;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FancyFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import noobanidus.libs.noobutil.world.gen.config.BlockStateRadiusFeatureConfig;

import java.util.OptionalInt;

public class ConfiguredFeatures {
  private static final BlockState cobble = Blocks.COBBLESTONE.getDefaultState();
  private static final BlockState andesite = Blocks.ANDESITE.getDefaultState();
  private static final BlockState diorite = Blocks.DIORITE.getDefaultState();
  private static final BlockState granite = Blocks.GRANITE.getDefaultState();

  public static ConfiguredFeature<?, ?> ROCK_BOULDERS = register("rock_boulders", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
      register("rock_boulders_cobble_1", VoyageFeatures.BIG_ROCK.withConfiguration(new BlockStateRadiusFeatureConfig(cobble, 1))).withChance(0.15F),
      register("rock_boulders_cobble_2", VoyageFeatures.BIG_ROCK.withConfiguration(new BlockStateRadiusFeatureConfig(cobble, 2))).withChance(0.05F),
      register("rock_boulders_andesite_0", VoyageFeatures.BIG_ROCK.withConfiguration(new BlockStateRadiusFeatureConfig(andesite, 0))).withChance(0.1F),
      register("rock_boulders_diorite_0", VoyageFeatures.BIG_ROCK.withConfiguration(new BlockStateRadiusFeatureConfig(diorite, 0))).withChance(0.1F),
      register("rock_boulders_granite_1", VoyageFeatures.BIG_ROCK.withConfiguration(new BlockStateRadiusFeatureConfig(granite, 0))).withChance(0.1F),
      register("rock_boulders_andesite_1", VoyageFeatures.BIG_ROCK.withConfiguration(new BlockStateRadiusFeatureConfig(andesite, 1))).withChance(0.05F),
      register("rock_boulders_diorite_1", VoyageFeatures.BIG_ROCK.withConfiguration(new BlockStateRadiusFeatureConfig(diorite, 1))).withChance(0.05F),
      register("rock_boulders_granite_1", VoyageFeatures.BIG_ROCK.withConfiguration(new BlockStateRadiusFeatureConfig(granite, 1))).withChance(0.05F)),
      register("rock_boulders_cobble_0", VoyageFeatures.BIG_ROCK.withConfiguration(new BlockStateRadiusFeatureConfig(cobble, 0))))
  ).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242732_c(6));

  public static ConfiguredFeature<?, ?> ROCKY_PEAKS_BOULDER = register("rocky_peaks_boulder", VoyageFeatures.BIG_ROCK.withConfiguration(new BlockStateRadiusFeatureConfig(Blocks.COBBLESTONE.getDefaultState(), 1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242732_c(4));

  public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> SUPER_BIRCH = register("super_birch", Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.BIRCH_LOG.getDefaultState()), new SimpleBlockStateProvider(Blocks.BIRCH_LEAVES.getDefaultState()), new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), new StraightTrunkPlacer(5, 2, 6), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));

  public static ConfiguredFeature<BaseTreeFeatureConfig, ?> SUPER_OAK = register("super_oak", Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()), new FancyFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(4), 4), new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).setIgnoreVines().func_236702_a_(Heightmap.Type.MOTION_BLOCKING).build()));

  public static ConfiguredFeature<?, ?> SUPER_BIRCH_BEES_0002 = register("super_birch_bees_0002", Feature.TREE.withConfiguration(SUPER_OAK.getConfig().func_236685_a_(ImmutableList.of(Features.Placements.BEES_0002_PLACEMENT))));

  public static ConfiguredFeature<?, ?> SUPER_OAK_BEES_0002 = register("super_oak_bees_0002", Feature.TREE.withConfiguration(SUPER_BIRCH.getConfig().func_236685_a_(ImmutableList.of(Features.Placements.BEES_0002_PLACEMENT))));

  public static ConfiguredFeature<?, ?> LUSH_TREES = register("lush_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(SUPER_BIRCH_BEES_0002.withChance(0.01f), SUPER_BIRCH.withChance(0.01f), SUPER_OAK_BEES_0002.withChance(0.2f), SUPER_OAK.withChance(0.78f)), SUPER_OAK)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(15, 0.1F, 1))));

  private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<FC, ?> feature) {
    return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(Voyage.MODID, id), feature);
  }

  public static void load() {
  }
}
