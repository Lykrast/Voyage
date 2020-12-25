package lykrast.voyage.init;

import lykrast.voyage.Voyage;
import lykrast.voyage.biomes.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = Voyage.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class VoyageBiomes {
	private static Set<Biome> BIOMES = new HashSet<>();

	public static Biome MOUNT = register("mount", () -> MountBiome.MOUNT);
	public static Biome BOG = register("bog", () -> BogBiome.BOG_BIOME);
	public static Biome LAGOON_WARM = register("lagoon_warm", () -> LagoonBiome.LAGOON_WARM);
	public static Biome LAGOON_LUKEWARM = register("lagoon_lukewarm", () -> LagoonBiome.LAGOON_LUKEWARM);
	public static Biome LAGOON_COLD = register("lagoon_cold", () -> LagoonBiome.LAGOON_COLD);
	public static Biome STEPPE = register("steppe", () -> SteppeBiome.STEPPE);
	public static Biome ROCKY_PEAKS = register("rocky_peaks", () -> RockyPeaksBiome.ROCKY_PEAKS);
	public static Biome DESERT_MIXED = register("desert_mixed", () -> DesertBiome.DESERT_MIXED);
	public static Biome DESERT_MIXED_HILLS = register("desert_mixed_hills", () -> DesertBiome.DESERT_MIXED_HILLS);
	public static Biome FLOWER_PLAINS = register("flower_plains", () -> FlowerPlainsBiome.FLOWER_PLAINS);
	public static Biome DESERT_MOUNTAINS = register("desert_mountains", () -> DesertBiome.DESERT_MOUNTAINS);
	public static Biome DESERT_POLAR = register("desert_polar", () -> DesertPolarBiome.DESERT_POLAR);
	public static Biome FOREST_LUSH = register("forest_lush", () -> ForestLushBiome.FOREST_LUSH);
	public static Biome ROCK_FIELD = register("rock_field", () -> RockFieldBiome.ROCK_FIELD);

	private static Biome register(String name, Supplier<Biome> builder) {
		ResourceLocation rl = Voyage.loc(name);
		Biome biome = builder.get();
		biome.setRegistryName(rl);
		BIOMES.add(biome);
		return biome;
	}

	@SubscribeEvent
	public static void eventRegister(RegistryEvent.Register<Biome> event) {
		event.getRegistry().registerAll(BIOMES.toArray(new Biome[0]));
	}
}
