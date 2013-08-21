package timeKeeper.blocks;

import timeKeeper.tileentities.TileEntityTimeKeeper;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks {
	
	public static Block timeKeeper;
	
	public static void init() {
		timeKeeper = new BlockTimeKeeper(BlockInfo.TIME_KEEPER_ID);
		GameRegistry.registerBlock(timeKeeper, BlockInfo.TIME_KEEPER_KEY);
	}
	
	public static void addNames() {
		LanguageRegistry.addName(timeKeeper, BlockInfo.TIME_KEEPER_NAME);
	}

	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityTimeKeeper.class, BlockInfo.TIME_KEEPER_TE_KEY);
	}
	
}
