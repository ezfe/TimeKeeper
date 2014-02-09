package com.ez.EzTimeKeeper.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import com.ez.EzTimeKeeper.blocks.BlockInfo;

public class ConfigHandler {
	
	public static void init(File file) {
		Configuration config = new Configuration(file);
		
		config.load();
		
		BlockInfo.TIME_OFFSET = config.get("General Settings", "time-offset", 0).getInt();
		
		config.save();
	}
	
}