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
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityTimeKeeper();
	}
}
