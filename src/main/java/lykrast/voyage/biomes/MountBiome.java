package lykrast.voyage.biomes;

import lykrast.voyage.ColorConstants;
import lykrast.voyage.VoyageBiomes;
import lykrast.voyage.biomebuilder.DefaultFeature;
import lykrast.voyage.init.ConfiguredSurfaceBuilders;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;

public class MountBiome {
  public static Biome MOUNT = VoyageBiomes.BIOME_TEMPLATE.builder()
      .surfaceBuilder(ConfiguredSurfaceBuilders.CONFIGURED_MOUNTAIN)
      .effects(VoyageBiomes.createDefaultBiomeAmbience()
          .setWaterColor(ColorConstants.STANDARD_WATER)
          .setWaterFogColor(ColorConstants.STANDARD_WATERFOG))
      .precipitation(Biome.RainType.RAIN)
      .category(Biome.Category.EXTREME_HILLS)
      .depth(4.0F)
      .scale(0.5F)
      .temperature(0.2F)
      .downfall(0.3F)
      .addDefaultFeatures(DefaultFeature.DEFAULT_UNDERGROUND_STRUCTURES, DefaultFeature.LAND_CARVERS, DefaultFeature.LAKES, DefaultFeature.DUNGEONS, DefaultFeature.DISKS, DefaultFeature.DEFAULT_FLOWERS, DefaultFeature.DEFAULT_GRASS, DefaultFeature.DEFAULT_MUSHROOMS, DefaultFeature.DEFAULT_VEGETATION, DefaultFeature.SPRINGS, DefaultFeature.INFECTED_STONE, DefaultFeature.FROZEN_TOP_LAYER, DefaultFeature.EMERALD_ORE)
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SHEEP, 12, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.PIG, 10, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.CHICKEN, 10, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.COW, 8, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.LLAMA, 5, 4, 6))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.BAT, 10, 8, 8))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SPIDER, 100, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 95, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.ZOMBIE_VILLAGER, 5, 1, 1))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SKELETON, 100, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.CREEPER, 100, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SLIME, 100, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 10, 1, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.WITCH, 5, 1, 1))
      .build();

}
