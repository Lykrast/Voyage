package lykrast.voyage.biomes;

import lykrast.voyage.VoyageBiomes;
import lykrast.voyage.biomebuilder.DefaultFeature;
import lykrast.voyage.init.ConfiguredSurfaceBuilders;
import lykrast.voyage.init.ModFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;

public class RockyPeaksBiome {
  public static Biome ROCKY_PEAKS = VoyageBiomes.BIOME_TEMPLATE.builder()
      .surfaceBuilder(ConfiguredSurfaceBuilders.CONFIGURED_PEAKS)
      .precipitation(Biome.RainType.RAIN)
      .category(Biome.Category.EXTREME_HILLS)
      .depth(1.0F)
      .scale(1.1F)
      .temperature(0.7F)
      .downfall(0.8F)
      .addDefaultFeatures(DefaultFeature.DEFAULT_UNDERGROUND_STRUCTURES, DefaultFeature.LAND_CARVERS, DefaultFeature.LAKES, DefaultFeature.DUNGEONS, DefaultFeature.DISKS, DefaultFeature.SPRINGS, DefaultFeature.DEFAULT_MUSHROOMS, DefaultFeature.EMERALD_ORE, DefaultFeature.INFECTED_STONE, DefaultFeature.FROZEN_TOP_LAYER)
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.BAT, 10, 8, 8))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SPIDER, 100, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 95, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.ZOMBIE_VILLAGER, 5, 1, 1))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SKELETON, 100, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.CREEPER, 100, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SLIME, 100, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 10, 1, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.WITCH, 5, 1, 1))
      .addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, ModFeatures.ROCK_BOULDERS)
      .build();
}
