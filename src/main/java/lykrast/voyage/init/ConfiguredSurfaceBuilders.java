package lykrast.voyage.init;

import lykrast.voyage.Voyage;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ConfiguredSurfaceBuilders {
	public static final ConfiguredSurfaceBuilder<?> CONFIGURED_DEFAULT_GRASS = register("default_grass", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG));
	public static final ConfiguredSurfaceBuilder<?> CONFIGURED_GRASSY_SWAMP = register("grassy_swamp", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.SWAMP, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG));
	public static final ConfiguredSurfaceBuilder<?> CONFIGURED_DESERT_MIXED = register("desert_mixed", new ConfiguredSurfaceBuilder<>(VoyageSurfaceBuilders.DESERT_MIXED, SurfaceBuilder.SAND_SAND_GRAVEL_CONFIG));
	public static final ConfiguredSurfaceBuilder<?> CONFIGURED_DESERT = register("desert", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, SurfaceBuilder.SAND_SAND_GRAVEL_CONFIG));
	public static final ConfiguredSurfaceBuilder<?> CONFIGURED_POLAR_DESERT = register("polar_desert", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.SNOW_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.GRAVEL.getDefaultState())));
	public static final ConfiguredSurfaceBuilder<?> CONFIGURED_MOUNTAIN = register("mountain", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.MOUNTAIN, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG));
	public static final ConfiguredSurfaceBuilder<?> CONFIGURED_ROCKY = register("rocky", new ConfiguredSurfaceBuilder<>(VoyageSurfaceBuilders.ROCK_FIELD, SurfaceBuilder.STONE_STONE_GRAVEL_CONFIG));
	public static final ConfiguredSurfaceBuilder<?> CONFIGURED_PEAKS = register("peaks", new ConfiguredSurfaceBuilder<>(VoyageSurfaceBuilders.ROCKY_PEAKS, SurfaceBuilder.STONE_STONE_GRAVEL_CONFIG));
	public static final ConfiguredSurfaceBuilder<?> CONFIGURED_STEPPE = register("steppe", new ConfiguredSurfaceBuilder<>(VoyageSurfaceBuilders.STEPPE, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG));
	public static final ConfiguredSurfaceBuilder<?> CONFIGURED_GRASS_SAND = register("grass_sand", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_SAND_CONFIG));
	public static final ConfiguredSurfaceBuilder<?> CONFIGURED_SAND_SAND = register("sand_sans", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, SurfaceBuilder.SAND_CONFIG));

	private static ConfiguredSurfaceBuilder<?> register(String id, ConfiguredSurfaceBuilder<?> feature) {
		return Registry.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(Voyage.MODID, id), feature);
	}
}
