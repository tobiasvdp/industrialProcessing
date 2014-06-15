package mod.industrialProcessing.plants.blackSmith.tripHammer.dummy.woodenHammer;

import mod.industrialProcessing.blockContainer.multiblock.dummy.BlockMultiblockDummy;
import mod.industrialProcessing.plants.blackSmith.tripHammer.TileEntityTripHammer;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockWoodenHammer  extends BlockMultiblockDummy{

	public BlockWoodenHammer() {
		super(1.0f,1.0f,Material.wood,Block.soundTypeWood,"Planks2");
		this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
		TileEntityWoodenHammer te = (TileEntityWoodenHammer) world.getTileEntity(x, y, z);
		if(te.getCore() != null){
			((TileEntityTripHammer)te.getCore()).handleRightClick(player);
		}
		return super.onBlockActivated(world, x, y, z, player, metadata, what, these, are);
	}



}
