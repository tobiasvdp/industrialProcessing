package ip.industrialProcessing.transport.items.conveyorBelt;

import org.bouncycastle.util.Arrays;

import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.IConnectedTile;
import ip.industrialProcessing.machines.TileEntitySynced;
import ip.industrialProcessing.transport.items.interfaces.IItemAcceptor;
import ip.industrialProcessing.transport.items.interfaces.IItemTransport;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TEtransportConveyorBelt extends TileEntitySynced implements IConnectedTile, IItemAcceptor, IItemTransport{

	private ConnectionState[] connections = new ConnectionState[4];

	public TEtransportConveyorBelt() {
		resetConnections();
	}

	@Override
	public ConnectionState getConnection(ForgeDirection direction) {
		if (direction.ordinal() > 1)
			return connections[direction.ordinal() - 2];
		else
			return ConnectionState.DISCONNECTED;
	}

	public void searchForConnections() {
		resetConnections();
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			if (dir.ordinal() > 1) {
				TileEntity te = worldObj.getBlockTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
				if (te instanceof IItemAcceptor) {
					connections[dir.ordinal() - 2] = ConnectionState.CONNECTED;
				}
			}
		}
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		super.readFromNBT(par1nbtTagCompound);
		resetConnections();
		for (int i = 0; i < 4; i++) {
			connections[i] = ConnectionState.values()[par1nbtTagCompound.getInteger("connection" + i)];
		}
	}

	private void resetConnections() {
		for (int i = 0; i < 4; i++) {
			connections[i] = ConnectionState.DISCONNECTED;
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		super.writeToNBT(par1nbtTagCompound);
		if (connections[0] != null) {
			for (int i = 0; i < 4; i++) {
				par1nbtTagCompound.setInteger("connection" + i, connections[i].ordinal());
			}
		}
	}

	@Override
	public void setOutputDirection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setInputsDirection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ForgeDirection getOutputDirection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ForgeDirection[] getInputDirections() {
		// TODO Auto-generated method stub
		return null;
	}

}
