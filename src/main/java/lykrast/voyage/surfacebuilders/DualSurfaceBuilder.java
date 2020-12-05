package lykrast.voyage.surfacebuilders;

import java.util.Random;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class DualSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
	// TODO: Properly convert to a surface builder
	private SurfaceBuilderConfig one, two;
	private double treshold;
	
	public DualSurfaceBuilder(Codec<SurfaceBuilderConfig> codec, SurfaceBuilderConfig one, SurfaceBuilderConfig two, double treshold) {
		super(codec);
		this.one = one;
		this.two = two;
		this.treshold = treshold;
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		if (noise > treshold) SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, one);
		else SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, two);

	}

}
