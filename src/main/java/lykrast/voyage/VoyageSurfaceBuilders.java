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

	
	@SubscribeEvent
	public static void registerBiomes(final RegistryEvent.Register<SurfaceBuilder<?>> event) {
		IForgeRegistry<SurfaceBuilder<?>> reg = event.getRegistry();
		builders.forEach(reg::register);
		builders = null;
	}
	
	//Sigh... setRegistryName makes generic not happy
	private static SurfaceBuilder<SurfaceBuilderConfig> make(SurfaceBuilder<SurfaceBuilderConfig> sb, String name) {
		sb.setRegistryName(Voyage.loc(name));
		builders.add(sb);
		return sb;
	}
}
