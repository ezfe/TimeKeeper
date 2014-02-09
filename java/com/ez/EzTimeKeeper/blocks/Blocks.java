package com.ez.EzTimeKeeper.blocks;

import net.minecraft.block.Block;

import com.ez.EzTimeKeeper.tileentities.TileEntityTimeKeeper;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks {
	
	public static Block timeKeeper;
	
	public static void init() {
		timeKeeper = new BlockTimeKeeper();
		GameRegistry.registerBlock(timeKeeper, BlockInfo.TIME_KEEPER_KEY);
	}
	
	public static void addNames() {
		//TODO Add Name!
	}

	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityTimeKeeper.class, BlockInfo.TIME_KEEPER_TE_KEY);
	}
	
}
