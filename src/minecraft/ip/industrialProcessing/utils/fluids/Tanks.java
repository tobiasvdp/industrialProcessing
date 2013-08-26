package ip.industrialProcessing.utils.fluids;

import java.util.ArrayList;

import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.multiblock.utils.tank.MultiblockTank;
import ip.industrialProcessing.recipes.RecipeFluidWorker;
import ip.industrialProcessing.utils.mapping.MappingIDtoSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public final class Tanks{

	public static void readTanks(NBTTagCompound nbt, ArrayList<MultiblockTank> fluidTanks) {
		NBTTagList nbttaglist = nbt.getTagList("Tanks");
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");

			if (b0 >= 0 && b0 < fluidTanks.size()) {
				MultiblockTank machineTank = fluidTanks.get(b0);
				machineTank.readFromNBT(nbttagcompound1);
			}
		}
	}
	
	public static void writeTanks(NBTTagCompound nbt, ArrayList<MultiblockTank> fluidTanks) {
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < fluidTanks.size(); ++i) {
			MultiblockTank tank = fluidTanks.get(i);
			NBTTagCompound nbttagcompound1 = new NBTTagCompound();
			nbttagcompound1.setByte("Slot", (byte) i);
			tank.writeToNBT(nbttagcompound1);
			nbttaglist.appendTag(nbttagcompound1);
		}
		nbt.setTag("Tanks", nbttaglist);
	}
	 
	public static void addTank(int capacity, boolean input, boolean output, ArrayList<MultiblockTank> fluidTanks, TileEntity te) {
		fluidTanks.add(new MultiblockTank(te, capacity, input, output));
	}
	
	public static int fill(int ID,ForgeDirection from, FluidStack resource, boolean doFill, ArrayList<MultiblockTank> fluidTanks, TileEntity te, MappingIDtoSlot mapping, RecipesMachine recipe) {
		int tankSlot = mapping.getSlot(ID, from);
		FluidTank tank = fluidTanks.get(tankSlot);
		if (tank == null)
			return 0;
		if (!isTankValidForFluid(ID, from, resource.fluidID,mapping,recipe))
			return 0;
		int amount = tank.fill(resource, doFill);
		if (doFill)
			onTanksChanged(te);
		return amount;
	}

	public static FluidStack drain(int ID,ForgeDirection from, FluidStack resource, boolean doDrain, ArrayList<MultiblockTank> fluidTanks, TileEntity te, MappingIDtoSlot mapping) {
		int tankSlot = mapping.getSlot(ID, from);
		FluidTank tank = fluidTanks.get(tankSlot);
		if (tank == null)
			return null;
		FluidStack amount = tank.drain(resource.amount, doDrain);
		if (doDrain)
			onTanksChanged(te);
		return amount;
	}

	public static FluidStack drain(int ID, ForgeDirection from, int maxDrain, boolean doDrain, ArrayList<MultiblockTank> fluidTanks, TileEntity te, MappingIDtoSlot mapping) {
		FluidTank tank = fluidTanks.get(mapping.getSlot(ID, from));
		if (tank == null)
			return null;
		FluidStack amount = tank.drain(maxDrain, doDrain);
		if (doDrain)
			onTanksChanged(te);
		return amount;
	}

	public static boolean canDrain(int ID, ForgeDirection from, Fluid fluid,  MappingIDtoSlot mapping, RecipesMachine recipe) {
		return  isTankValidForFluid(ID, from, fluid.getBlockID(),mapping, recipe);
	}

	public static boolean canFill(int ID, ForgeDirection from, Fluid fluid,  MappingIDtoSlot mapping, RecipesMachine recipe) {
		return isTankValidForFluid(ID, from, fluid.getBlockID(), mapping,recipe);
	}
	
	public static boolean isTankValidForFluid(int ID, ForgeDirection from, int fluidId,  MappingIDtoSlot mapping,RecipesMachine recipe){
		return recipe.isValidFluidInput(mapping.getSlot(ID, from), fluidId);
	}

	public static FluidTankInfo[] getTankInfo(int ID, ForgeDirection from, ArrayList<MultiblockTank> fluidTanks, MappingIDtoSlot mapping) {
		int tank = mapping.getSlot(ID, from);
		FluidTankInfo[] info = new FluidTankInfo[1];
		info[0] = fluidTanks.get(tank).getInfo();
		return info;
	}
	protected static void onTanksChanged(TileEntity te) {
		te.onInventoryChanged();
	}

}
