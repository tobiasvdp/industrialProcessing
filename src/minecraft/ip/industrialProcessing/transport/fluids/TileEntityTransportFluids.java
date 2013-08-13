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

    @Override
    protected TransportConnectionState getState(TileEntity entity, ForgeDirection direction) { 
	ForgeDirection from = direction.getOpposite();
	if(entity instanceof TileEntityTransportFluids)
	    return TransportConnectionState.TRANSPORT; // TODO: check if connection should be made (lava pipe with water pipe ..)
	
	if(entity instanceof IFluidHandler)
	{
	    IFluidHandler handler = (IFluidHandler)entity;
	    return canInsertOrExtractFluid(handler, from);
	}
	return TransportConnectionState.NONE;
    }

    private TransportConnectionState canInsertOrExtractFluid(IFluidHandler handler, ForgeDirection from) {
	Map<String, Fluid> fluids = FluidRegistry.getRegisteredFluids();
	boolean canInsert = false;
	boolean canExtract = false; 
	for(Entry<String,Fluid> fluidEntry : fluids.entrySet())
	{
	    Fluid fluid = fluidEntry.getValue();
	    canExtract |= handler.canDrain(from, fluid);
	    canInsert |= handler.canFill(from, fluid);
	    if(canExtract && canInsert) break;
	}
	if(canInsert && canExtract) return TransportConnectionState.DUAL;
	if(canInsert) return TransportConnectionState.INPUT;
	if(canExtract) return TransportConnectionState.OUTPUT;
	return TransportConnectionState.NONE;
    }

}
