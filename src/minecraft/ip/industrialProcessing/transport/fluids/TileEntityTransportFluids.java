package ip.industrialProcessing.transport.fluids;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import buildcraft.api.transport.IPipe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.IMachineTanks;
import ip.industrialProcessing.machines.MachineFluidTank;
import ip.industrialProcessing.transport.TileEntityTransport;
import ip.industrialProcessing.transport.TransportConnectionState;
import ip.industrialProcessing.utils.FluidTransfers;

public class TileEntityTransportFluids extends TileEntityTransport {

    FluidTank fluid = new FluidTank(1000);
    int pressure = 0;
    private static int tileID;
    private int id;

    public TileEntityTransportFluids() {
	this.id = tileID++;
    }

    public FluidTankInfo getTankInfo() {
	return fluid.getInfo();
    }

    @Override
    protected TransportConnectionState getState(TileEntity entity, ForgeDirection direction) {
	ForgeDirection from = direction.getOpposite();
	if (entity instanceof TileEntityTransportFluids)
	    return TransportConnectionState.TRANSPORT; // TODO: check if
						       // connection should be
						       // made (lava pipe with
						       // water pipe ..)

	if (entity instanceof TileEntityPump) {
	    TileEntityPump pump = (TileEntityPump) entity;
	    if (pump.isFluidOuptut(from))
		return TransportConnectionState.OUTPUT;
	    if (pump.isFluidInput(from))
		return TransportConnectionState.INPUT;
	}
	if (entity instanceof IFluidHandler) {
	    IFluidHandler handler = (IFluidHandler) entity;
	    return canInsertOrExtractFluid(handler, from);
	}
	return TransportConnectionState.NONE;
    }

    private TransportConnectionState canInsertOrExtractFluid(IFluidHandler handler, ForgeDirection from) {
	FluidTankInfo[] info = handler.getTankInfo(from);
	if (info != null && info.length > 0)
	    return TransportConnectionState.DUAL; // can't decide if input only
						  // or input/output
	return TransportConnectionState.NONE;
    }

    @Override
    public void updateEntity() {
	super.updateEntity();
	if (this.worldObj.isRemote)
	    return;
	handlePumps();
	outputToInputs();
	inputFromOutputs();
	equalizeToOtherPipes();
	leakPressure();
    }

    private void leakPressure() {
	if (this.pressure > 0)
	    this.pressure--;
	if (this.pressure < 0)
	    this.pressure++;
    }

    private void handlePumps() {
	for (int i = 0; i < states.length; i++) {
	    TransportConnectionState state = this.states[i];
	    ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
	    if (state == TransportConnectionState.INPUT || state == TransportConnectionState.OUTPUT) {
		TileEntityPump pump = getNeighborPump(direction);
		if (pump != null) {
		    int lastPressure = this.pressure;
		    if (pump.isFluidInput(direction.getOpposite())) {
			int pumpPressure = pump.getInputPressure();

			int flow = pumpPressure - this.pressure;
			if (flow < 0) {

			    pumpPressure -= flow / 4;
			    this.pressure += flow / 4;

			    FluidTransfers.transfer(-flow / 2, this.fluid, pump.getTank()); 
			}
			pump.setInputPressure(pumpPressure);

		    } else if (pump.isFluidOuptut(direction.getOpposite())) {
			int pumpPressure = pump.getOutputPressure();

			int flow = pumpPressure - this.pressure;
			if (flow > 0) {

			    pumpPressure -= flow / 4;
			    this.pressure += flow / 4;

 
			    FluidTransfers.transfer(flow / 2, pump.getTank(), this.fluid); 
			}
			pump.setOutputPressure(pumpPressure);
		    }
		}
	    }
	}
    }

    private void equalizeToOtherPipes() {
	for (int i = 0; i < states.length; i++) {
	    TransportConnectionState state = this.states[i];
	    ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
	    if (state == TransportConnectionState.TRANSPORT) {
		TileEntityTransportFluids other = getNeighborPipe(direction);
		if (other != null) {
		    int flow = other.pressure - this.pressure;
		    if (flow > 0) {
			System.out.println(String.format("transfer from %s %s to %s %s by %s", other.id, other.pressure, this.id, this.pressure, flow / 4));
			other.pressure -= flow / 4;
			this.pressure += flow / 4; 

			FluidTransfers.transfer(flow / 2, other.fluid, this.fluid); 
		    }
		}
	    }
	}
    }

    private void inputFromOutputs() {
	if (pressure < 0) {
	    for (int i = 0; i < states.length; i++) {
		TransportConnectionState state = this.states[i];
		ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
		ForgeDirection from = direction.getOpposite();
		if (state == TransportConnectionState.DUAL) {
		    IFluidHandler other = getNeighborFluidHandler(direction);
		    if (other != null) {
			int flow = 0 - this.pressure;
			if (flow > 0) {
			    // other.pressure -= flow / 4;
			    this.pressure += flow / 4; 

			    FluidTransfers.transfer(flow / 2, other, from, this.fluid); 
			}
		    }
		}
	    }
	}
    }

    private void outputToInputs() {
	if (this.pressure > 0) {
	    for (int i = 0; i < states.length; i++) {
		TransportConnectionState state = this.states[i];
		ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
		ForgeDirection from = direction.getOpposite();
		if (state == TransportConnectionState.DUAL) {
		    IFluidHandler other = getNeighborFluidHandler(direction);
		    if (other != null) {
			int flow = 0 - this.pressure;
			if (flow < 0) {
			    // other.pressure -= flow / 4;
			    this.pressure += flow / 4;

			    FluidTransfers.transfer(-flow / 2, this.fluid, other, from);
			}
		    }
		}
	    }
	}
    }

    private IFluidHandler getNeighborFluidHandler(ForgeDirection direction) {
	TileEntity ent = this.worldObj.getBlockTileEntity(this.xCoord + direction.offsetX, this.yCoord + direction.offsetY, this.zCoord + direction.offsetZ);
	if (ent instanceof IFluidHandler)
	    return (IFluidHandler) ent;
	return null;
    }

    private TileEntityTransportFluids getNeighborPipe(ForgeDirection direction) {
	TileEntity ent = this.worldObj.getBlockTileEntity(this.xCoord + direction.offsetX, this.yCoord + direction.offsetY, this.zCoord + direction.offsetZ);
	if (ent instanceof TileEntityTransportFluids)
	    return (TileEntityTransportFluids) ent;
	return null;
    }

    private TileEntityPump getNeighborPump(ForgeDirection direction) {
	TileEntity ent = this.worldObj.getBlockTileEntity(this.xCoord + direction.offsetX, this.yCoord + direction.offsetY, this.zCoord + direction.offsetZ);
	if (ent instanceof TileEntityPump)
	    return (TileEntityPump) ent;
	return null;
    }
}
