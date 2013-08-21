package timeKeeper.blocks;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import timeKeeper.tileentities.TileEntityTimeKeeper;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTimeKeeper extends BlockContainer {

	public BlockTimeKeeper(int id) {
		super(id, Material.iron);
		setCreativeTab(CreativeTabs.tabRedstone);
		setHardness(-1F);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName(BlockInfo.TIME_KEEPER_UNLOCALIZED_NAME);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.TIME_KEEPER_TEXTURE);
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int id) {
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z)) {
			timeKeep(world);
		} else {
		}
	}

	public static void timeKeep(World world) {
		DateFormat dateFormat = new SimpleDateFormat("HH");
		Date date = new Date();
		String hour = dateFormat.format(date);
		
		DateFormat dateFormat1 = new SimpleDateFormat("mm");
		Date date1 = new Date();
		String minute = dateFormat1.format(date1);
		
		int hour_int = Integer.parseInt(hour);
		int minute_int = Integer.parseInt(minute);
		
		float total_sec = (hour_int*60*60)+(minute_int*60); //0 - 86400 seconds 0-24000 ticks
		
		float goal_time = ((total_sec/86400)*24000);

		world.setWorldTime((Math.round(goal_time)+24000)-6000);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityTimeKeeper();
	}
}