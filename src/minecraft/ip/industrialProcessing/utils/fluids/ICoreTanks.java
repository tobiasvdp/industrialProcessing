package ip.industrialProcessing.utils.fluids;

import ip.industrialProcessing.client.render.IFluidInfo;
import ip.industrialProcessing.machines.IMachineTanks;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.multiblock.utils.MultiblockTank;
import ip.industrialProcessing.transport.fluids.IPressuredTank;
import ip.industrialProcessing.utils.mapping.MappingIDtoSlot;

import java.util.ArrayList;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public interface ICoreTanks extends IFluidHandler,IMachineTanks, IFluidInfo, IPressuredTank {
	public void readTanks(NBTTagCompound nbt);

	public void writeTanks(NBTTagCompound nbt);

	public void addTank(int capacity, boolean input, boolean output);

	public int fill(int ID, ForgeDirection from, FluidStack resource, boolean doFill);

	public FluidStack drain(int ID, ForgeDirection from, FluidStack resource, boolean doDrain);

	public FluidStack drain(int ID, ForgeDirection from, int maxDrain, boolean doDrain);

	public boolean canDrain(int ID, ForgeDirection from, Fluid fluid);

	public boolean canFill(int ID, ForgeDirection from, Fluid fluid);

	public boolean isTankValidForFluid(int ID,ForgeDirection from, int fluidId);

	public FluidTankInfo[] getTankInfo(int ID, ForgeDirection from);
}
