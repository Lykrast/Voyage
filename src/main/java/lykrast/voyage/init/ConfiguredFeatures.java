package lykrast.voyage.init;

import com.google.common.collect.ImmutableList;
import lykrast.voyage.Voyage;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.Placement;

public class ConfiguredFeatures {
  public static ConfiguredFeature<?, ?> ROCK_BOULDERS = register("rock_boulders", Feature.RANDOM_SELECTOR.withConfiguration(
      new MultipleRandomFeatureConfig(
          ImmutableList.of(
              Feature.FOREST_ROCK.withConfiguration(new BlockStateFeatureConfig(Blocks.COBBLESTONE.getDefaultState())).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withChance(0.1f),
              Feature.FOREST_ROCK.withConfiguration(new BlockStateFeatureConfig(Blocks.ANDESITE.getDefaultState())).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withChance(0.1f),
              Feature.FOREST_ROCK.withConfiguration(new BlockStateFeatureConfig(Blocks.GRANITE.getDefaultState())).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withChance(0.1f))
          ,
          Feature.FOREST_ROCK.withConfiguration(new BlockStateFeatureConfig(Blocks.COBBLESTONE.getDefaultState())).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242732_c(2))
  ).withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(6))));

  private static ConfiguredFeature<?, ?> register(String id, ConfiguredFeature<?, ?> feature) {
    return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(Voyage.MODID, id), feature);
  }

  public static void load() {
  }
}
