package ip.industrialProcessing.transport;

import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.transport.fluids.TileEntityTransportFluids;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityTransport extends TileEntity {

    private boolean[] connectedSides = new boolean[6];
    
    public TileEntityTransport(){
    }
    
	protected void notifyBlockChange() {
	if (!this.worldObj.isRemote)
	    this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    } 
    protected ForgeDirection getForwardDirection(){
	 int meta = this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
	 return BlockMachine.getForwardFromMetadata(meta);
    }
    public void senseSides(World world){
		for (ForgeDirection o : ForgeDirection.VALID_DIRECTIONS) {
			if (senseSide(world, o)){connectedSides [o.ordinal()] = true;}
			else{connectedSides[o.ordinal()] = false;}
		}
	}
	protected boolean senseSide(World world, ForgeDirection dir){
		TileEntity entity =  world.getBlockTileEntity(this.xCoord + dir.offsetX,this.yCoord + dir.offsetY,this.zCoord + dir.offsetZ);
		if (entity == null) return false;
		if (entity instanceof TileEntityTransport) {return true;}
		return false;
	}
	public boolean isSideConnected(ForgeDirection dir){
		return connectedSides[dir.ordinal()];
		
	}
   
    public ForgeDirection getForward()
    {
	int metadata = this.getBlockMetadata();
	return getForwardFromMetadata(metadata);
    }

    public static ForgeDirection getForwardFromMetadata(int metadata) { 
	switch(metadata)
	{
	case 0:
	    return ForgeDirection.NORTH;
	case 1:
	    return ForgeDirection.EAST;
	case 2:
	    return ForgeDirection.SOUTH; 
	case 3:
	    return ForgeDirection.WEST;
	}
	return null;
    }

}
