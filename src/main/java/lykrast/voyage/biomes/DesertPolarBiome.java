package lykrast.voyage.biomes;

import lykrast.voyage.ColorConstants;
import lykrast.voyage.VoyageBiomes;
import lykrast.voyage.biomebuilder.DefaultFeature;
import lykrast.voyage.init.ConfiguredSurfaceBuilders;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;

public class DesertPolarBiome {
  public static Biome DESERT_POLAR = VoyageBiomes.BIOME_TEMPLATE.builder()
      .surfaceBuilder(ConfiguredSurfaceBuilders.CONFIGURED_POLAR_DESERT)
      .precipitation(Biome.RainType.SNOW)
      .category(Biome.Category.ICY)
      .depth(0.05F)
      .scale(0.0F)
      .temperature(0.0F)
      .downfall(0.0F)
      .effects(VoyageBiomes.createDefaultBiomeAmbience()
          .setWaterColor(ColorConstants.STANDARD_WATER)
          .setWaterFogColor(ColorConstants.STANDARD_WATERFOG))
      .addDefaultFeatures(DefaultFeature.LAND_CARVERS, DefaultFeature.DEFAULT_UNDERGROUND_STRUCTURES, DefaultFeature.LAKES, DefaultFeature.DUNGEONS, DefaultFeature.DISKS, DefaultFeature.DEFAULT_MUSHROOMS, DefaultFeature.SPRINGS, DefaultFeature.FROZEN_TOP_LAYER)
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.BAT, 10, 8, 8))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SPIDER, 100, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 95, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.ZOMBIE_VILLAGER, 5, 1, 1))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.CREEPER, 100, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SLIME, 100, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 10, 1, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.WITCH, 5, 1, 1))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SKELETON, 20, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.STRAY, 80, 4, 4))
      .build();
}
