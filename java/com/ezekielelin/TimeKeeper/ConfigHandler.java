package com.ezekielelin.TimeKeeper;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	
	public static void init(File file) {
		Configuration config = new Configuration(file);
		
		config.load();
		
		EzTimeKeeper.LATITUDE = config.get("General Settings", "lat", 43.70437929822373).getDouble();
		EzTimeKeeper.LONGITUDE = config.get("General Settings", "lon", -72.27336766415073).getDouble();
		
		config.save();
	}
	
}