package ip.industrialProcessing.logic.network.interfaces.machine;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.logic.network.TileEntityLogicNetworkNode;
import ip.industrialProcessing.logic.utils.UTVariable;
import ip.industrialProcessing.logic.utils.UTVariableType;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.machines.TileEntityPoweredWorkerMachine;
import ip.industrialProcessing.power.IPoweredMachine;

public class TileEntityMachineInterface extends TileEntityLogicNetworkNode{
	
	TileEntityMachine machine = null;
	
	private TileEntityMachine getMachine(){
		if (machine == null) {
			connectMachine();
		}
		return machine;
	}

	private void connectMachine() {
		ForgeDirection dir = getExternalForgeDirection(ForgeDirection.DOWN);
		TileEntity te = worldObj.getBlockTileEntity(this.xCoord+dir.offsetX, this.yCoord+dir.offsetY, this.zCoord+dir.offsetZ);
		if (te != null && te instanceof TileEntityMachine)
			machine = (TileEntityMachine) te;
	}

	@Override
	public ForgeDirection[] setConnectableInputSides() {
		return null;
	}

	@Override
	public ForgeDirection[] setConnectableOutputSides() {
		return null;
	}

	@Override
	public void transition() {

	}

	@Override
	public void setData(UTVariable[] data) {
		if( getMachine() != null){
			
		}
	}

	@Override
	public UTVariable[] getData(UTVariableType type) {
		if( getMachine() != null){
			if( type == UTVariableType.power && machine instanceof IPoweredMachine){
				IPoweredMachine	powerMachine = (IPoweredMachine) machine;
				return new UTVariable[]{new UTVariable(0,UTVariableType.power,powerMachine.getMainPowerStorage())};
			}
		}
		return null;
	}

}
