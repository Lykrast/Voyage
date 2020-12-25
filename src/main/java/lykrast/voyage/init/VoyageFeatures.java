package lykrast.voyage.init;

import lykrast.voyage.Voyage;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import noobanidus.libs.noobutil.world.gen.config.BlockStateRadiusFeatureConfig;
import noobanidus.libs.noobutil.world.gen.feature.RadiusBlockBlobFeature;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(modid = Voyage.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class VoyageFeatures {
  private static Set<Feature<?>> FEATURES = new HashSet<>();

  public static Feature<BlockStateRadiusFeatureConfig> BIG_ROCK = register("big_rock", new RadiusBlockBlobFeature(BlockStateRadiusFeatureConfig.CODEC));

  private static <T extends IFeatureConfig> Feature<T> register(String name, Feature<T> feature) {
    ResourceLocation rl = Voyage.loc(name);
    feature.setRegistryName(rl);
    FEATURES.add(feature);
    return feature;
  }

  @SubscribeEvent
  public static void eventRegister(RegistryEvent.Register<Feature<?>> event) {
    event.getRegistry().registerAll(FEATURES.toArray(new Feature[0]));
  }
}
