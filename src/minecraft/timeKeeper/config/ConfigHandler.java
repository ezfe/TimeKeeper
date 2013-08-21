package timeKeeper.config;

import java.io.File;

import net.minecraftforge.common.Configuration;
import obsidianGlass.blocks.BlockInfo;

public class ConfigHandler {
	
	public static void init(File file) {
		Configuration config = new Configuration(file);
		
		config.load();
		
		BlockInfo.TIME_KEEPER_ID = config.getBlock(BlockInfo.TIME_KEEPER_KEY, BlockInfo.TIME_KEEPER_DEFAULT).getInt();
		
		config.save();
	}
	
}