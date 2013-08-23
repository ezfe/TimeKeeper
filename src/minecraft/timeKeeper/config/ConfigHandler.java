package timeKeeper.config;

import java.io.File;

import net.minecraftforge.common.Configuration;
import timeKeeper.blocks.BlockInfo;

public class ConfigHandler {
	
	public static void init(File file) {
		Configuration config = new Configuration(file);
		
		config.load();
		
		BlockInfo.TIME_KEEPER_ID = config.getBlock(BlockInfo.TIME_KEEPER_KEY, BlockInfo.TIME_KEEPER_DEFAULT).getInt();
		
		BlockInfo.TIME_OFFSET = config.get("General Settings", "time-offset", 0).getInt();
		
		config.save();
	}
	
}