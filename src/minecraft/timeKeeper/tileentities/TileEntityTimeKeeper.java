package timeKeeper.tileentities;

import net.minecraft.command.CommandGameRule;
import net.minecraft.tileentity.TileEntity;
import timeKeeper.blocks.BlockTimeKeeper;

public class TileEntityTimeKeeper extends TileEntity {
	
	private static int anvils;
	private static int side;
	
	public TileEntityTimeKeeper() {
	}
	
	public void updateEntity() {
		BlockTimeKeeper.timeKeep(worldObj);
	}
}
