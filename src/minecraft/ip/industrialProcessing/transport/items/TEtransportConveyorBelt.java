package ip.industrialProcessing.transport.items;

import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.IConnectedTile;
import ip.industrialProcessing.machines.TileEntitySynced;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TEtransportConveyorBelt extends TileEntitySynced implements IConnectedTile,IItemAcceptor{
	
	private ConnectionState[] connections = new ConnectionState[4];

	public TEtransportConveyorBelt() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ConnectionState getConnection(ForgeDirection direction) {
		return connections[direction.ordinal()-2];
	}

	public void searchForConnections() {
		connections = new ConnectionState[4];
		for(ForgeDirection dir:ForgeDirection.VALID_DIRECTIONS){
			if(dir.ordinal() >1){
				TileEntity te = worldObj.getBlockTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
				if(te instanceof IItemAcceptor){
					connections[dir.ordinal()-2] = ConnectionState.CONNECTED;
				}
			}
		}
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		for(int i =0;i<4;i++){
			System.out.println(connections[i]);
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		super.readFromNBT(par1nbtTagCompound);
		connections = new ConnectionState[4];
		for(int i = 0;i<4;i++){
			connections[i] = ConnectionState.values()[par1nbtTagCompound.getInteger("connection"+i)];	
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		super.writeToNBT(par1nbtTagCompound);
		for(int i = 0;i<4;i++){
			par1nbtTagCompound.setInteger("connection"+i, connections[i].ordinal());	
		}
	}

}
