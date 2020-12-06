package lykrast.voyage;

import lykrast.voyage.config.ConfigManager;
import lykrast.voyage.init.ModFeatures;
import lykrast.voyage.init.ModSurfaceBuilders;
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
    //This bit is from the Voyage config system basically, nooby said it's cool (and MIT)
    //https://github.com/MysticMods/Voyage/blob/master/src/main/java/epicsquid/traverse/Voyage.java
    ModSurfaceBuilders.load();
    ModFeatures.load();
    ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigManager.COMMON_CONFIG);
    ConfigManager.loadConfig(ConfigManager.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(MODID + "-common.toml"));
  }

  public static ResourceLocation loc(String name) {
    return new ResourceLocation(MODID, name);
  }
}
