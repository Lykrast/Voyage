package lykrast.voyage.config;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigManager {
	//This is basically the Voyage config system, nooby said it's cool (and MIT)
	//https://github.com/MysticMods/Voyage/blob/master/src/main/java/epicsquid/traverse/config/ConfigManager.java

	public static final List<BiomeConfig> BIOMES = new ArrayList<>();

	private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

	public static final BiomeConfig MOUNT = new BiomeConfig("mount", 2);
	public static final BiomeConfig BOG = new BiomeConfig("bog", 5);
	public static final BiomeConfig LAGOON_WARM = new BiomeConfig("lagoon_warm", 4);
	public static final BiomeConfig LAGOON_LUKEWARM = new BiomeConfig("lagoon_lukewarm", 4);
	public static final BiomeConfig LAGOON_COLD = new BiomeConfig("lagoon_cold", 4);
	public static final BiomeConfig STEPPE = new BiomeConfig("steppe", 5);
	public static final BiomeConfig ROCKY_PEAKS = new BiomeConfig("rocky_peaks", 1);
	public static final BiomeConfig DESERT_MIXED = new BiomeConfig("desert_mixed", 4);
	public static final BiomeConfig DESERT_MIXED_HILLS = new BiomeConfig("desert_mixed_hills", 2);
	public static final BiomeConfig FLOWER_PLAINS = new BiomeConfig("flower_plains", 4);
	public static final BiomeConfig DESERT_MOUNTAINS = new BiomeConfig("desert_mountains", 3);
	public static final BiomeConfig DESERT_POLAR = new BiomeConfig("desert_polar", 2);
	public static final BiomeConfig FOREST_LUSH = new BiomeConfig("forest_lush", 3);
	public static final BiomeConfig ROCK_FIELD = new BiomeConfig("rock_field", 3);

	public static final ForgeConfigSpec COMMON_CONFIG;

	static {
		BIOMES.forEach(b -> b.apply(COMMON_BUILDER));
		COMMON_CONFIG = COMMON_BUILDER.build();
	}

	public static void loadConfig(ForgeConfigSpec spec, Path path) {
		CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
		configData.load();
		spec.setConfig(configData);
	}
}
