package timeKeeper.tileentities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.minecraft.command.CommandGameRule;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import timeKeeper.blocks.BlockInfo;
import timeKeeper.blocks.BlockTimeKeeper;

public class TileEntityTimeKeeper extends TileEntity {
	
	private static int counter = 6000;
	private static int time_counter = 10;
	private static int goal_time;
	
	public TileEntityTimeKeeper() {

	}
	
	public void updateEntity() {
		counter++;
		time_counter++;
		timeKeep(worldObj);
		if (counter == 6000) {
			counter = 0;
			weatherKeep(worldObj);
			System.out.println("Set weather");
		}
	}
	
	public static void timeKeep(World world) {
		if (time_counter > 5) {
			DateFormat dateFormat = new SimpleDateFormat("HH");
			Date date = new Date();
			String hour = dateFormat.format(date);
			
			DateFormat dateFormat1 = new SimpleDateFormat("mm");
			Date date1 = new Date();
			String minute = dateFormat1.format(date1);
			
			int hour_int = Integer.parseInt(hour);
			int minute_int = Integer.parseInt(minute);
			
			float total_sec = (hour_int*60*60)+(minute_int*60); //0 - 86400 seconds 0-24000 ticks
			
			goal_time = (int) ((total_sec/86400)*24000);
			time_counter = 0;
		}
		world.setWorldTime((Math.round(goal_time)+18000)+BlockInfo.TIME_OFFSET);
	}
	
	public static void weatherKeep(World worldObj) {
		
	}

}
