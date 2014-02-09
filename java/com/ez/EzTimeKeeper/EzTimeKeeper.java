package com.ez.EzTimeKeeper;

import com.ez.EzTimeKeeper.blocks.Blocks;
import com.ez.EzTimeKeeper.config.ConfigHandler;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = ModInformation.ID, name = ModInformation.NAME)
public class EzTimeKeeper {
	
	@Instance(ModInformation.ID)
	public static EzTimeKeeper instance;
		
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		Blocks.init();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		Blocks.addNames();
		Blocks.registerTileEntities();
	}
}
