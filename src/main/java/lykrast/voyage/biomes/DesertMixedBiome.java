package lykrast.voyage.biomes;

import lykrast.voyage.ColorConstants;
import lykrast.voyage.VoyageBiomes;
import lykrast.voyage.biomebuilder.BiomeTemplate;
import lykrast.voyage.biomebuilder.DefaultFeature;
import lykrast.voyage.init.ConfiguredSurfaceBuilders;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.feature.structure.StructureFeatures;

public class DesertMixedBiome {
  public static final BiomeTemplate DESERT_TEMPLATE = new BiomeTemplate(VoyageBiomes.BIOME_TEMPLATE.builder()
      .surfaceBuilder(ConfiguredSurfaceBuilders.CONFIGURED_DESERT_MIXED)
      .precipitation(Biome.RainType.NONE)
      .category(Biome.Category.DESERT)
      .effects(VoyageBiomes.createDefaultBiomeAmbience()
          .setWaterColor(ColorConstants.STANDARD_WATER)
          .setWaterFogColor(ColorConstants.STANDARD_WATERFOG))
      .addStructureFeature(StructureFeatures.VILLAGE_DESERT)
      .addStructureFeature(StructureFeatures.DESERT_PYRAMID)
      .addDefaultFeatures(DefaultFeature.LAND_CARVERS, DefaultFeature.DEFAULT_UNDERGROUND_STRUCTURES, DefaultFeature.DESERT_LAKES, DefaultFeature.DUNGEONS, DefaultFeature.DEFAULT_FLOWERS, DefaultFeature.BADLANDS_GRASS, DefaultFeature.DISKS, DefaultFeature.DESERT_DEAD_BUSHES, DefaultFeature.DEFAULT_MUSHROOMS, DefaultFeature.SPRINGS, DefaultFeature.DESERT_FEATURES, DefaultFeature.FROZEN_TOP_LAYER, DefaultFeature.BADLANDS_VEGETATION)
      .addStructureFeature(StructureFeatures.RUINED_PORTAL_DESERT)
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.RABBIT, 4, 2, 3))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.BAT, 10, 8, 8))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SPIDER, 100, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SKELETON, 100, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.CREEPER, 100, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SLIME, 100, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 10, 1, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.WITCH, 5, 1, 1))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 19, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.ZOMBIE_VILLAGER, 1, 1, 1))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.HUSK, 80, 4, 4))
      .temperature(2.0F)
      .downfall(0.0F));

  public static Biome DESERT_MIXED = DESERT_TEMPLATE.builder()
      .addStructureFeature(StructureFeatures.PILLAGER_OUTPOST)
      .depth(0.125F)
      .scale(0.05F).build();


  public static Biome DESERT_MIXED_HILLS = DESERT_TEMPLATE.builder()
      .depth(0.45F)
      .scale(0.3F).build();
}
