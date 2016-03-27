package com.ezekielelin.TimeKeeper;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	
	public static void init(File file) {
		Configuration config = new Configuration(file);
		
		config.load();
		
		EzTimeKeeper.LATITUDE = config.get("General Settings", "lat", EzTimeKeeper.LATITUDE).getDouble();
		EzTimeKeeper.LONGITUDE = config.get("General Settings", "lon", EzTimeKeeper.LONGITUDE).getDouble();
		EzTimeKeeper.ENABLED = config.get("General Settings", "enabled", EzTimeKeeper.ENABLED).getBoolean();
		
		config.save();
	}
	
}