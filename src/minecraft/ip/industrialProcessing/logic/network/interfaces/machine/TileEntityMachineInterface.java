package ip.industrialProcessing.logic.network.interfaces.machine;

import java.util.Iterator;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidTankInfo;
import ip.industrialProcessing.api.info.IExpirable;
import ip.industrialProcessing.client.render.IFluidInfo;
import ip.industrialProcessing.logic.api.network.interfaces.ILogicInterface;
import ip.industrialProcessing.logic.api.network.interfaces.IMachineInterface;
import ip.industrialProcessing.logic.api.network.interfaces.InterfaceType;
import ip.industrialProcessing.logic.network.TileEntityLogicNetworkNode;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.utils.UTBuffer;
import ip.industrialProcessing.logic.utils.UTLogicType;
import ip.industrialProcessing.logic.utils.UTVariable;
import ip.industrialProcessing.logic.utils.UTVariableType;
import ip.industrialProcessing.machines.IMachineSlots;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.machines.TileEntityPoweredWorkerMachine;
import ip.industrialProcessing.power.IPoweredMachine;
import ip.industrialProcessing.utils.working.IWorker;
import ip.industrialProcessing.utils.working.IWorkingEntity;

public class TileEntityMachineInterface extends TileEntityLogicNetworkNode implements ILogicInterface {

	IMachineInterface machine = null;

	public IMachineInterface getMachine() {
		if (machine == null || ((TileEntity) machine).isInvalid()) {
			connectMachine();
		}
		return machine;
	}

	public boolean isMachineCapable(InterfaceType type) {
		IMachineInterface machine = getMachine();
		if (machine != null) {
			for (InterfaceType cap : machine.getConnectionTypes()) {
				if (type == cap)
					return true;
			}
			return false;
		} else
			return false;
	}

	private void connectMachine() {
		ForgeDirection dir = getExternalForgeDirection(ForgeDirection.DOWN);
		TileEntity te = worldObj.getBlockTileEntity(this.xCoord + dir.offsetX, this.yCoord + dir.offsetY, this.zCoord + dir.offsetZ);
		if (te != null && te instanceof IMachineInterface)
			machine = (IMachineInterface) te;
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
	public void setData(UTVariable[] data, ICommunicationNode node) {
		if (getMachine() != null) {

		}
	}

	@Override
	public UTVariable[] getData(UTVariableType type) {
		if (getMachine() != null) {
			switch (type) {
			case bit:
				break;
			case power:
				if (machine instanceof IPoweredMachine) {
					IPoweredMachine powerMachine = (IPoweredMachine) machine;
					return new UTVariable[] { new UTVariable(0, UTVariableType.power, powerMachine.getMainPowerStorage()) };
				}
				break;
			case slot:
				if (machine instanceof IMachineSlots) {
					IMachineSlots inv = ((IMachineSlots)machine);
				UTVariable[] vars = new UTVariable[inv.getSizeInventory()];
				for(int i=0;i<inv.getSizeInventory();i++){
				    vars[i] = new UTVariable(0, UTVariableType.slot, inv.getMachineStack(i));
				}
				return vars;
			}
				break;
			case tank:
				if (machine instanceof IFluidInfo) {
				    	FluidTankInfo[] info = ((IFluidInfo)machine).getTanks();
					UTVariable[] vars = new UTVariable[info.length];
					for(int i=0;i<info.length;i++){
					    vars[i] = new UTVariable(0, UTVariableType.tank, info[i]);
					}
					return vars;
				}
				break;
			case unknown:
				break;
			case work:
				if (machine instanceof IWorkingEntity) {
					IWorker worker = ((IWorkingEntity) machine).getWorker();
					return new UTVariable[] { new UTVariable(0, UTVariableType.work, worker) };
				}
				break;
			case status:
				return new UTVariable[] { new UTVariable(0, UTVariableType.status, machine.getStatus()) };
			case coord:
				TileEntity te = (TileEntity) machine;
				return new UTVariable[] { new UTVariable(0, UTVariableType.coord, te.xCoord),new UTVariable(0, UTVariableType.coord, te.yCoord),new UTVariable(0, UTVariableType.coord, te.zCoord) };
			case name:
				return new UTVariable[] {new UTVariable(0, UTVariableType.name, machine.getName())};
			case interfaceTypes:
				return new UTVariable[] {new UTVariable(0,UTVariableType.interfaceTypes,machine.getConnectionTypes())};
			default:
				break;
			}
		}
		return null;
	}

	@Override
	public String getName() {
		IMachineInterface machine = getMachine();
		if (machine != null) {
			return machine.getName();
		}
		return "Machine interface";
	}

	@Override
	public UTLogicType getLogicType() {
		return UTLogicType.interfaces;
	}

}
