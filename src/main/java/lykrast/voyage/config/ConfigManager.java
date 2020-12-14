package lykrast.voyage.config;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
import noobanidus.libs.noobutil.config.BiomeConfig;

public class ConfigManager {
	//This is basically the Voyage config system, nooby said it's cool (and MIT)
	//https://github.com/MysticMods/Voyage/blob/master/src/main/java/epicsquid/traverse/config/ConfigManager.java

	public static final List<BiomeConfig> BIOMES = new ArrayList<>();

	private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
	private static final BiomeConfig.Builder config = new BiomeConfig.Builder(BIOMES);

	public static final BiomeConfig MOUNT = config.build("mount", 2);
	public static final BiomeConfig BOG = config.build("bog", 5);
	public static final BiomeConfig LAGOON_WARM = config.build("lagoon_warm", 4);
	public static final BiomeConfig LAGOON_LUKEWARM = config.build("lagoon_lukewarm", 4);
	public static final BiomeConfig LAGOON_COLD = config.build("lagoon_cold", 4);
	public static final BiomeConfig STEPPE = config.build("steppe", 5);
	public static final BiomeConfig ROCKY_PEAKS = config.build("rocky_peaks", 1);
	public static final BiomeConfig DESERT_MIXED = config.build("desert_mixed", 4);
	public static final BiomeConfig DESERT_MIXED_HILLS = config.build("desert_mixed_hills", 2);
	public static final BiomeConfig FLOWER_PLAINS = config.build("flower_plains", 4);
	public static final BiomeConfig DESERT_MOUNTAINS = config.build("desert_mountains", 3);
	public static final BiomeConfig DESERT_POLAR = config.build("desert_polar", 2);
	public static final BiomeConfig FOREST_LUSH = config.build("forest_lush", 3);
	public static final BiomeConfig ROCK_FIELD = config.build("rock_field", 3);

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
