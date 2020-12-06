package lykrast.voyage;

import net.minecraft.util.math.MathHelper;

public class ColorConstants {
	//Mountains, Plains, Desert
	public static final int STANDARD_WATER = 0x3F76E4;
	public static final int SWAMP_WATER = 0x617B64;
	public static final int OCEAN_WARM_WATER = 0x43D5EE;
	public static final int OCEAN_LUKEWARM_WATER = 0x45ADF2;
	public static final int OCEAN_COLD_WATER = 0x3D57D6;
	
	//Mountains, Cold Ocean, Plains, Desert
	public static final int STANDARD_WATERFOG = 0x050533;
	public static final int SWAMP_WATERFOG = 0x232317;
	public static final int OCEAN_WARM_WATERFOG = 0x041F33;
	public static final int OCEAN_LUKEWARM_WATERFOG = 0x041633;
	public static final int PLAINS_WATERFOG = 0x041633;
	
	private ColorConstants() {}

  public static int getSkyColor(float temperature) {
    float f = temperature / 3.0F;
    f = MathHelper.clamp(f, -1.0F, 1.0F);
    return MathHelper.hsvToRGB(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
  }
}
