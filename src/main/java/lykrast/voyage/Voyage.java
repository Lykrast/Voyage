package lykrast.voyage;

import lykrast.voyage.config.ConfigManager;
import lykrast.voyage.init.ConfiguredFeatures;
import lykrast.voyage.init.VoyageSurfaceBuilders;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLPaths;
import noobanidus.libs.noobutil.registrate.CustomRegistrate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Voyage.MODID)
public class Voyage {
	public static final String MODID = "voyage";
	public static final Logger LOGGER = LogManager.getLogger();
	public static CustomRegistrate REGISTRATE;

	public Voyage() {
		//This bit is from the Traverse config system basically, nooby said it's cool (and MIT)
		//https://github.com/MysticMods/Traverse/blob/master/src/main/java/epicsquid/traverse/Traverse.java
		VoyageSurfaceBuilders.load();
		ConfiguredFeatures.load();
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigManager.COMMON_CONFIG);
		ConfigManager.loadConfig(ConfigManager.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(MODID + "-common.toml"));
	}

	public static ResourceLocation loc(String name) {
		return new ResourceLocation(MODID, name);
	}
}
