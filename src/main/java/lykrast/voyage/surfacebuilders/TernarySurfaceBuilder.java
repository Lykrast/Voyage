package lykrast.voyage.surfacebuilders;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class TernarySurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
	private SurfaceBuilderConfig one, two, three;
	
	public TernarySurfaceBuilder(SurfaceBuilderConfig one, SurfaceBuilderConfig two, SurfaceBuilderConfig three) {
		super(SurfaceBuilderConfig::deserialize);
		this.one = one;
		this.two = two;
		this.three = three;
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		if (!(noise < -1.0D) && !(noise > 2.0D)) {
			if (noise > 1.0D) SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, one);
			else SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, two);
		}
		else SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, three);

	}

}
