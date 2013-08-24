package timeKeeper;

import timeKeeper.blocks.BlockInfo;
import timeKeeper.blocks.Blocks;
import timeKeeper.config.ConfigHandler;
import timeKeeper.network.PacketHandler;
import timeKeeper.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;


@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION)
@NetworkMod(channels = {ModInformation.CHANNEL}, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class EzTimeKeeper {
	
	@Instance(ModInformation.ID)
	public static EzTimeKeeper instance;
	
	@SidedProxy(clientSide = "timeKeeper.proxies.ClientProxy", serverSide = "timeKeeper.proxies.CommonProxy")
	public static CommonProxy proxy;
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		Blocks.init();
		
		proxy.initSounts();
		proxy.initRenderers();
		
		if (BlockInfo.ZIP_CODE > 99999) {
			BlockInfo.ZIP_CODE = 99999;
			System.out.println("Your ZIP code was improperly set. It should be a five digit number. It has been decreased to the first available 5 digit number.");
			System.out.println("International users, please set your zip code to 0 until I have figured you out.");
		}
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		Blocks.addNames();
		Blocks.registerTileEntities();
		
	}
	
	@EventHandler
	public void modsLoaded(FMLPostInitializationEvent event) {
		
	}
	
}
