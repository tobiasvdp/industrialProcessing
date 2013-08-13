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

public class TileEntityTransportFluids extends TileEntityTransport {

    FluidTank fluid = new FluidTank(2000);

    @Override
    protected TransportConnectionState getState(TileEntity entity, ForgeDirection direction) {
	ForgeDirection from = direction.getOpposite();
	if (entity instanceof TileEntityTransportFluids)
	    return TransportConnectionState.TRANSPORT; // TODO: check if
						       // connection should be
						       // made (lava pipe with
						       // water pipe ..)

	if (entity instanceof IFluidHandler) {
	    IFluidHandler handler = (IFluidHandler) entity;
	    return canInsertOrExtractFluid(handler, from);
	}
	return TransportConnectionState.NONE;
    }

    private TransportConnectionState canInsertOrExtractFluid(IFluidHandler handler, ForgeDirection from) {
	Map<String, Fluid> fluids = FluidRegistry.getRegisteredFluids();
	boolean canInsert = false;
	boolean canExtract = false;
	for (Entry<String, Fluid> fluidEntry : fluids.entrySet()) {
	    Fluid fluid = fluidEntry.getValue();
	    canExtract |= handler.canDrain(from, fluid);
	    canInsert |= handler.canFill(from, fluid);
	    if (canExtract && canInsert)
		break;
	}
	if (canInsert && canExtract)
	    return TransportConnectionState.DUAL;
	if (canInsert)
	    return TransportConnectionState.INPUT;
	if (canExtract)
	    return TransportConnectionState.OUTPUT;
	return TransportConnectionState.NONE;
    }

    @Override
    public void updateEntity() {
	super.updateEntity();
	if (this.worldObj.isRemote)
	    return;
	System.out.println("Pipe has " + this.fluid.getFluidAmount() + " milibuckets of fluid");
	int capacityLeft = this.fluid.getCapacity() / 2 - this.fluid.getFluidAmount();
	FluidStack fluid = this.fluid.getFluid();

	int totalInput = 0;
	int totalOutput = 0;
	int[] inputs = new int[6];
	int[] outputs = new int[6];
	TileEntityTransportFluids[] otherPipes = new TileEntityTransportFluids[6];
	IFluidHandler[] tanks = new IFluidHandler[6];

	for (int i = 0; i < states.length; i++) {
	    TransportConnectionState state = states[i];
	    ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
	    if (state == TransportConnectionState.TRANSPORT) {
		TileEntityTransportFluids other = getNeighborPipe(direction);
		otherPipes[i] = other;
		if (other != null) {
		    int diff = (other.fluid.getFluidAmount() - this.fluid.getFluidAmount()) / 2;
		    if (diff > 0) {
			inputs[i] = diff;
			totalInput += diff;
		    } else {
			outputs[i] = -diff;
			totalOutput -= diff;
		    }
		}
	    }
	    if (state == TransportConnectionState.OUTPUT || state == TransportConnectionState.DUAL) { // other
												      // entity
												      // can
												      // output,
												      // this
												      // means
												      // it's
												      // an
												      // input
												      // for
												      // us
		IFluidHandler handler = getNeighborFluidHandler(direction);
		tanks[i] = handler;
		if (handler != null) {
		    FluidStack inputStack = handler.drain(direction.getOpposite(), capacityLeft, false);
		    if (fluid == null) {
			fluid = inputStack;
			if (inputStack != null) {
			    inputs[i] = inputStack.amount;
			    totalInput += inputStack.amount;
			}
		    } else if (fluid.isFluidEqual(inputStack)) {
			inputs[i] = inputStack.amount;
			totalInput += inputStack.amount;
		    }
		}
	    }
	    if (state == TransportConnectionState.INPUT || state == TransportConnectionState.DUAL) {// other
												    // entity
												    // can
												    // input,
												    // this
												    // means
												    // it's
												    // an
												    // output
												    // for
												    // us
		IFluidHandler handler = getNeighborFluidHandler(direction);
		tanks[i] = handler;
		if (handler != null) {
		    int output = handler.fill(direction.getOpposite(), fluid, false);
		    outputs[i] = output;
		    totalOutput += output;
		}
	    }
	}

	int maxOutput = this.fluid.getFluidAmount();
	int maxInput = capacityLeft - Math.min(maxOutput, totalOutput);

	for (int i = 0; i < 6; i++) {
	    TransportConnectionState state = states[i];
	    ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
	    if (state == TransportConnectionState.TRANSPORT) {
		TileEntityTransportFluids other = otherPipes[i];
		if (totalOutput > 0) {
		    int output = outputs[i] * maxOutput / totalOutput;
		    if (output > 0)
			other.fluid.fill(this.fluid.drain(output, true), true);
		}
		if (totalInput > 0) {
		    int input = inputs[i] * maxInput / totalInput;
		    if (input > 0)
			this.fluid.fill(other.fluid.drain(input, true), true);
		}
	    } else if ((state == TransportConnectionState.OUTPUT || state == TransportConnectionState.DUAL) && totalInput > 0) {
		int input = inputs[i] * maxInput / totalInput;
		if (input > 0) {
		    IFluidHandler handler = tanks[i];
		    FluidStack stack = handler.drain(direction.getOpposite(), input, true);
		    this.fluid.fill(stack, true);
		}
	    } else if ((state == TransportConnectionState.INPUT || state == TransportConnectionState.DUAL) && totalOutput > 0) {
		int output = outputs[i] * maxOutput / totalOutput;
		if (output > 0) {
		    IFluidHandler handler = tanks[i];
		    FluidStack outputStack = this.fluid.drain(output, false);
		    int filled = handler.fill(direction.getOpposite(), outputStack, true);
		    this.fluid.drain(filled, true);
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
}
