package lykrast.voyage;

import java.util.ArrayList;
import java.util.List;

import lykrast.voyage.surfacebuilders.DualSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class VoyageSurfaceBuilders {
	private static List<SurfaceBuilder<?>> builders = new ArrayList<>();
	//This registry fires AFTER Biomes, so have to build them before
	public static final SurfaceBuilder<SurfaceBuilderConfig> STEPPE = make(new DualSurfaceBuilder(SurfaceBuilder.SAND_CONFIG, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG, 1), "steppe");
	public static final SurfaceBuilder<SurfaceBuilderConfig> ROCKY_PEAKS = make(new DualSurfaceBuilder(SurfaceBuilder.STONE_STONE_GRAVEL_CONFIG, SurfaceBuilder.GRAVEL_CONFIG, 1), "rocky_peaks");
	public static final SurfaceBuilder<SurfaceBuilderConfig> DESERT_MIXED = make(new DualSurfaceBuilder(new SurfaceBuilderConfig(SurfaceBuilder.RED_SAND, SurfaceBuilder.RED_SAND, SurfaceBuilder.GRAVEL), SurfaceBuilder.SAND_SAND_GRAVEL_CONFIG, 1), "desert_mixed");
	public static final SurfaceBuilder<SurfaceBuilderConfig> ROCK_FIELD = make(new DualSurfaceBuilder(SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG, SurfaceBuilder.STONE_STONE_GRAVEL_CONFIG, 3), "rock_field");
	
	@SubscribeEvent
	public static void registerBiomes(final RegistryEvent.Register<SurfaceBuilder<?>> event) {
		IForgeRegistry<SurfaceBuilder<?>> reg = event.getRegistry();
		builders.forEach(reg::register);
		builders.forEach(Voyage.LOGGER::info);
		builders = null;
	}
	
	//Sigh... setRegistryName makes generic not happy
	private static SurfaceBuilder<SurfaceBuilderConfig> make(SurfaceBuilder<SurfaceBuilderConfig> sb, String name) {
		sb.setRegistryName(Voyage.loc(name));
		builders.add(sb);
		return sb;
	}
}
