package lykrast.voyage.biomes;

import lykrast.voyage.ColorConstants;
import lykrast.voyage.VoyageBiomes;
import lykrast.voyage.biomebuilder.DefaultFeature;
import lykrast.voyage.init.ConfiguredSurfaceBuilders;
import lykrast.voyage.init.ModFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;

public class RockFieldBiome {
  public static Biome ROCK_FIELD = VoyageBiomes.BIOME_TEMPLATE.builder()
      .surfaceBuilder(ConfiguredSurfaceBuilders.CONFIGURED_ROCKY)
      .precipitation(Biome.RainType.RAIN)
      .category(Biome.Category.SAVANNA)
      .depth(0.1F)
      .scale(0.2F)
      .temperature(2.0F)
      .downfall(0.0F)
      .effects(VoyageBiomes.createDefaultBiomeAmbience()
          .withGrassColor(0xFFEE96)
          .withFoliageColor(0xFFEE96)
          .setWaterColor(ColorConstants.STANDARD_WATER)
          .setWaterFogColor(ColorConstants.STANDARD_WATERFOG))
      .addDefaultFeatures(DefaultFeature.BADLANDS_UNDERGROUND_STRUCTURES, DefaultFeature.LAND_CARVERS, DefaultFeature.LAKES, DefaultFeature.DUNGEONS, DefaultFeature.DISKS, DefaultFeature.DEFAULT_MUSHROOMS, DefaultFeature.SPRINGS, DefaultFeature.DEFAULT_VEGETATION, DefaultFeature.FROZEN_TOP_LAYER, DefaultFeature.BADLANDS_GRASS)
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
