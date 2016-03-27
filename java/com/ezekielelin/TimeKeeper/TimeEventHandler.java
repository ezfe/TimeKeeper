package com.ezekielelin.TimeKeeper;

import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;

public class TimeEventHandler {
	
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=false)
	public void onEvent(WorldTickEvent event)
	{
		// Register extended entity properties
		if (event.phase == event.phase.END) {
			EzTimeKeeper.timeKeep(event.world);
		}
	}
}