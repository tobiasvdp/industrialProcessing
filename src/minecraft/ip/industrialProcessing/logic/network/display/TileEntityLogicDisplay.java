package ip.industrialProcessing.logic.network.display;

import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.logic.network.TileEntityLogicNetworkNode;
import ip.industrialProcessing.logic.utils.UTVariable;
import ip.industrialProcessing.logic.utils.UTVariableType;
import ip.industrialProcessing.machines.IPowerStorage;

public class TileEntityLogicDisplay extends TileEntityLogicNetworkNode{

    @Override
    public ForgeDirection[] setConnectableInputSides() {
	return new ForgeDirection[]{ForgeDirection.NORTH,ForgeDirection.EAST,ForgeDirection.WEST};
    }

    @Override
    public ForgeDirection[] setConnectableOutputSides() {
	return new ForgeDirection[]{ForgeDirection.NORTH,ForgeDirection.EAST,ForgeDirection.WEST};
    }

    @Override
    public void transition() {

    }

    @Override
    public void setData(UTVariable[] data) {
	for(UTVariable var:data){
	    if(var.ID == UTVariableType.power){
		IPowerStorage power = (IPowerStorage) var.value;
		System.out.println(power.getStoredPower()+"/"+power.getPowerCapacity());
	    }
	}
    }

    @Override
    public UTVariable[] getData(UTVariableType type) {
	return null;
    }

	@Override
	public String getName() {
		return "Display";
	}

}
