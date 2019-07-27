package lykrast.voyage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Voyage.MODID)
public class Voyage {
	public static final String MODID = "voyage";
	public static final Logger LOGGER = LogManager.getLogger();
	
	public static ResourceLocation loc(String name) {
		return new ResourceLocation(MODID, name);
	}
}
