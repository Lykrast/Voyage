package lykrast.voyage.biomes;

import lykrast.voyage.ColorConstants;
import lykrast.voyage.VoyageBiomes;
import lykrast.voyage.biomebuilder.DefaultFeature;
import lykrast.voyage.init.ConfiguredSurfaceBuilders;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;

public class SteppeBiome {
  public static Biome STEPPE = VoyageBiomes.BIOME_TEMPLATE.builder()
      .surfaceBuilder(ConfiguredSurfaceBuilders.CONFIGURED_STEPPE)
      .effects(VoyageBiomes.createDefaultBiomeAmbience()
          .setWaterColor(ColorConstants.STANDARD_WATER)
          .setWaterFogColor(ColorConstants.STANDARD_WATERFOG))
      .precipitation(Biome.RainType.RAIN)
      .category(Biome.Category.PLAINS)
      .depth(0.125F)
      .scale(0.05F)
      .temperature(1.2F)
      .downfall(0.0F)
      .addDefaultFeatures(DefaultFeature.DEFAULT_UNDERGROUND_STRUCTURES, DefaultFeature.LAND_CARVERS, DefaultFeature.DUNGEONS, DefaultFeature.PLAINS_TALL_GRASS, DefaultFeature.DISKS, DefaultFeature.DEFAULT_MUSHROOMS, DefaultFeature.BADLANDS_GRASS, DefaultFeature.SPRINGS, DefaultFeature.FROZEN_TOP_LAYER)
      .addStructureFeature(StructureFeatures.VILLAGE_SAVANNA)
      .addStructureFeature(StructureFeatures.PILLAGER_OUTPOST)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_PLAIN)
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SHEEP, 12, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.PIG, 10, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.CHICKEN, 10, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.COW, 8, 4, 4))
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
