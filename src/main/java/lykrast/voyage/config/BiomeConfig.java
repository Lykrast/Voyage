package lykrast.voyage.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class BiomeConfig {
	//This is basically the Traverse config system, nooby said it's cool (and MIT)
	//https://github.com/MysticMods/Traverse/blob/master/src/main/java/epicsquid/traverse/config/BiomeConfig.java
	
	private String name;
	private int weight;
	
	private ForgeConfigSpec.IntValue configWeight;
	
	public BiomeConfig(String name, int weight) {
		this.name = name;
		this.weight = weight;
		ConfigManager.BIOMES.add(this);
	}
	
	public String name() {
		return name;
	}
	
	public int weight() {
		return configWeight.get();
	}
	
	public boolean shouldSpawn() {
		return weight() > 0;
	}
	
	public void apply(ForgeConfigSpec.Builder builder) {
		builder.comment(name + " biome generation").push(name + "_biome");
		configWeight = builder.comment("spawn weight of the biome (0 to disable generation)").defineInRange("weight", weight, 0, 255);
		builder.pop();
	}
}
