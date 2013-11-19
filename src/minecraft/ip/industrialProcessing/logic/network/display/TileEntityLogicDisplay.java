package ip.industrialProcessing.logic.network.display;

import org.apache.commons.lang3.text.WordUtils;

import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import ip.industrialProcessing.api.info.IExpirable;
import ip.industrialProcessing.api.info.InfoMachine;
import ip.industrialProcessing.api.info.InfoTank;
import ip.industrialProcessing.logic.api.network.interfaces.StatusType;
import ip.industrialProcessing.logic.network.TileEntityLogicNetworkNode;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.utils.UTBuffer;
import ip.industrialProcessing.logic.utils.UTVariable;
import ip.industrialProcessing.logic.utils.UTVariableType;
import ip.industrialProcessing.logic.utils.UTlogicNodeContainer;
import ip.industrialProcessing.machines.IPowerStorage;
import ip.industrialProcessing.utils.working.IWorker;

public class TileEntityLogicDisplay extends TileEntityLogicNetworkNode {
    boolean tick = true;
    int suspendCount = 0;

    @Override
    public ForgeDirection[] setConnectableInputSides() {
	return new ForgeDirection[] { ForgeDirection.NORTH };
    }

    @Override
    public ForgeDirection[] setConnectableOutputSides() {
	return new ForgeDirection[] { ForgeDirection.NORTH };
    }

    @Override
    public void transition() {

    }

    @Override
    public void setData(UTVariable[] data, ICommunicationNode node) {
	for (ForgeDirection dir : getConnectableInputSides()) {
	    UTlogicNodeContainer container = getConnectionsOnSide(getExternalForgeDirection(dir));
	    int index = container.getIndex(node);
	    if (index != -1) {
		UTBuffer buffer = getBuffer(dir);
		for (UTVariable var : data) {
		    System.out.println("got data " + var.ID);
		    if (var.ID == UTVariableType.power) {
			if (buffer.get(index).ID == UTVariableType.machine) {
			    InfoMachine machine = (InfoMachine) buffer.get(index).value;
			    IPowerStorage storage = (IPowerStorage) data[0].value;
			    machine.power.powerCapacity = storage.getPowerCapacity();
			    machine.power.storedPower = storage.getStoredPower();
			    machine.power.ttl = 10;
			}
		    } else if (var.ID == UTVariableType.status) {
			if (buffer.get(index).ID == UTVariableType.machine) {
			    InfoMachine machine = (InfoMachine) buffer.get(index).value;
			    machine.status = (StatusType) data[0].value;
			    machine.ttl = 40;
			}
		    } else if (var.ID == UTVariableType.work) {
			if (buffer.get(index).ID == UTVariableType.machine) {
			    InfoMachine machine = (InfoMachine) buffer.get(index).value;
			    IWorker worker = (IWorker) data[0].value;
			    machine.worker.totalWork = worker.getTotalWork();
			    machine.worker.workDone = worker.getWorkDone();
			    machine.power.ttl = 10;
			}
		    } else if (var.ID == UTVariableType.tank) {
			if (buffer.get(index).ID == UTVariableType.machine) {
			    InfoMachine machine = (InfoMachine) buffer.get(index).value;
			    for (int i = 0; i < data.length; i++) {
				FluidTankInfo info = (FluidTankInfo) data[i].value;
				InfoTank tank = machine.getOrSetTank(i);
				if (info.fluid != null) {
				    tank.amount = info.fluid.amount;
				    tank.fluidId = info.fluid.fluidID;
				}else{
				    tank.amount = 0;
				    tank.fluidId = 0;
				}
				tank.capacity = info.capacity;
				tank.ttl = 20;
			    }
			}
		    }
		}
	    }
	}
	this.tick = true;
    }

    @Override
    public void updateEntity() {
	super.updateEntity();
	if (!worldObj.isRemote) {
	    if (this.tick) {
		boolean tick = false;
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
		    UTBuffer buffer = getBuffer(dir);
		    for (int i = 0; i < buffer.size(); i++) {
			UTVariable var = buffer.get(i);
			if (var.tick())
			    tick = true;
			if (var.value != null && var.value instanceof IExpirable) {
			    if (((IExpirable) var.value).tick())
				tick = true;
			}
		    }
		}
		if (!tick) {
		    suspendCount++;
		    if (suspendCount == 100) {
			suspendCount = 0;
			this.tick = false;
			System.out.println("suspended");
		    }

		}
		System.out.println("Ticked");
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
