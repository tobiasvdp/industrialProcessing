package ip.industrialProcessing.transport.items.conveyorBelt;

import org.bouncycastle.util.Arrays;

import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.IConnectedTile;
import ip.industrialProcessing.machines.TileEntitySynced;
import ip.industrialProcessing.transport.items.interfaces.IItemAcceptor;
import ip.industrialProcessing.transport.items.interfaces.IItemAcceptorInput;
import ip.industrialProcessing.transport.items.interfaces.IItemAcceptoroutput;
import ip.industrialProcessing.transport.items.interfaces.IItemTransport;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TEtransportConveyorBelt extends TileEntitySynced implements IConnectedTile, IItemAcceptor, IItemTransport {

	private ConnectionState[] connections = new ConnectionState[6];
	private ConnectionState[] inputs = new ConnectionState[6];
	private ConnectionState[] outputs = new ConnectionState[6];

	public TEtransportConveyorBelt() {
		resetConnections();
	}

	@Override
	public ConnectionState getConnection(ForgeDirection direction) {
		return connections[direction.ordinal()];
	}

	public void searchForConnections() {
		resetConnections();
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			TileEntity te = worldObj.getBlockTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
			if (te instanceof IItemAcceptor) {
				connections[dir.ordinal()] = ConnectionState.CONNECTED;
			}
		}
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		super.readFromNBT(par1nbtTagCompound);
		resetConnections();
		for (int i = 0; i < 6; i++) {
			connections[i] = ConnectionState.values()[par1nbtTagCompound.getInteger("connection" + i)];
		}
	}

	private void resetConnections() {
		for (int i = 0; i < 6; i++) {
			connections[i] = ConnectionState.DISCONNECTED;
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		super.writeToNBT(par1nbtTagCompound);
		if (connections[0] != null) {
			for (int i = 0; i < 6; i++) {
				par1nbtTagCompound.setInteger("connection" + i, connections[i].ordinal());
			}
		}
	}

	@Override
	public void setOutputDirection(ForgeDirection dir, boolean isValid) {
		if(isValid){
			outputs[dir.ordinal()] = ConnectionState.CONNECTED;
		}else{
			outputs[dir.ordinal()] = ConnectionState.DISCONNECTED;
		}
	}

	/*private void findOutputs() {
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			if (connections[dir.ordinal()] == ConnectionState.CONNECTED) {
				if (dir.ordinal() > 1) {
					TileEntity te = worldObj.getBlockTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
					if (te instanceof IItemAcceptoroutput) {
						outputs[dir.ordinal()] = ConnectionState.CONNECTED;
					} else if (te instanceof IItemTransport) {
						IItemTransport trans = (IItemTransport) te;
						for (ForgeDirection dir2 : trans.getInputDirections()) {
							if (dir2 == dir.getOpposite())
								outputs[dir.ordinal()] = ConnectionState.CONNECTED;
						}
					} else {
						outputs[dir.ordinal()] = ConnectionState.DISCONNECTED;
					}
				}
			}
		}
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}*/

	@Override
	public void setInputDirection(ForgeDirection dir, boolean isValid) {
		if(isValid){
			inputs[dir.ordinal()] = ConnectionState.CONNECTED;
		}else{
			inputs[dir.ordinal()] = ConnectionState.DISCONNECTED;
		}
	}

	/*private void findInputs() {
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			if (connections[dir.ordinal()] == ConnectionState.CONNECTED) {
				if (dir.ordinal() > 1) {
					TileEntity te = worldObj.getBlockTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
					if (te instanceof IItemAcceptorInput) {
						inputs[dir.ordinal()] = ConnectionState.CONNECTED;
					} else if (te instanceof IItemTransport) {
						IItemTransport trans = (IItemTransport) te;
						for (ForgeDirection dir2 : trans.getOutputDirections()) {
							if (dir2 == dir.getOpposite())
								inputs[dir.ordinal()] = ConnectionState.CONNECTED;
						}
					} else {
						inputs[dir.ordinal()] = ConnectionState.DISCONNECTED;
					}
				}
			}
		}
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}*/

	@Override
	public ForgeDirection[] getOutputDirections() {
		int size = 0;
		for (ConnectionState con : outputs) {
			if (con == ConnectionState.CONNECTED)
				size++;
		}
		ForgeDirection[] dir = new ForgeDirection[size];
		size = 0;
		for (int i = 0;i<6;i++) {
			if (outputs[i] == ConnectionState.CONNECTED) {
				dir[size] = ForgeDirection.values()[i];
				size++;
			}
		}
		return dir;
	}

	@Override
	public ForgeDirection[] getInputDirections() {
		int size = 0;
		for (ConnectionState con : inputs) {
			if (con == ConnectionState.CONNECTED)
				size++;
		}
		ForgeDirection[] dir = new ForgeDirection[size];
		size = 0;
		for (int i = 0;i<6;i++) {
			if (inputs[i] == ConnectionState.CONNECTED) {
				dir[size] = ForgeDirection.values()[i];
				size++;
			}
		}
		return dir;
	}

	@Override
	public void updatePath() {

	}

}
