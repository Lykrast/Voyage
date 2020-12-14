package lykrast.voyage.init;

import lykrast.voyage.Voyage;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import noobanidus.libs.noobutil.world.gen.surfacebuilder.DualSurfaceBuilder;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(modid = Voyage.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class VoyageSurfaceBuilders {
  private static Set<SurfaceBuilder<SurfaceBuilderConfig>> BUILDERS = new HashSet<>();

  public static final SurfaceBuilder<SurfaceBuilderConfig> STEPPE = register("steppe", new DualSurfaceBuilder(SurfaceBuilderConfig.field_237203_a_, SurfaceBuilder.SAND_CONFIG, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG, 1));
  public static final SurfaceBuilder<SurfaceBuilderConfig> ROCKY_PEAKS = register("rocky_peaks", new DualSurfaceBuilder(SurfaceBuilderConfig.field_237203_a_, SurfaceBuilder.STONE_STONE_GRAVEL_CONFIG, SurfaceBuilder.GRAVEL_CONFIG, 1));
  public static final SurfaceBuilder<SurfaceBuilderConfig> DESERT_MIXED = register("desert_mixed", new DualSurfaceBuilder(SurfaceBuilderConfig.field_237203_a_, new SurfaceBuilderConfig(Blocks.RED_SAND.getDefaultState(), Blocks.RED_SAND.getDefaultState(), Blocks.GRAVEL.getDefaultState()), SurfaceBuilder.SAND_SAND_GRAVEL_CONFIG, 1));
  public static final SurfaceBuilder<SurfaceBuilderConfig> ROCK_FIELD = register("rock_field", new DualSurfaceBuilder(SurfaceBuilderConfig.field_237203_a_, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG, SurfaceBuilder.STONE_STONE_GRAVEL_CONFIG, 3));

  private static SurfaceBuilder<SurfaceBuilderConfig> register(String name, SurfaceBuilder<SurfaceBuilderConfig> builder) {
    ResourceLocation rl = Voyage.loc(name);
    builder.setRegistryName(rl);
    BUILDERS.add(builder);
    return builder;
  }

  @SubscribeEvent
  public static void register(RegistryEvent.Register<SurfaceBuilder<?>> event) {
    event.getRegistry().registerAll(BUILDERS.toArray(new SurfaceBuilder[0]));
  }

  public static void load() {
  }
}
