package ip.industrialProcessing.multiblock.core.extend;

import java.util.ArrayList;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.tier.MultiblockTierRequirements;
import ip.industrialProcessing.multiblock.utils.MultiblockTank;
import ip.industrialProcessing.utils.fluids.ICoreTanks;
import ip.industrialProcessing.utils.fluids.Tanks;
import ip.industrialProcessing.utils.mapping.MappingIDtoSlot;

public class TEmultiblockCoreTank extends TEmultiblockCore implements ICoreTanks {

	protected ArrayList<MultiblockTank> fluidTanks = new ArrayList<MultiblockTank>();
	protected RecipesMachine recipe;
	protected MappingIDtoSlot mapping;
	
	public TEmultiblockCoreTank(StructureMultiblock structure,MultiblockTierRequirements tierRequirments) {
		super(structure, tierRequirments);
	}

	//Tank handler
	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		return this.fill(0, from, resource, doFill);
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
		return this.drain(0, from, resource, doDrain);
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		return this.drain(0, from, maxDrain, doDrain);
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		return this.canFill(0,from, fluid);
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		return this.canDrain(0, from, fluid);
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		return this.getTankInfo(0, from);
	}

	// Tank Core handler
	@Override
	public void readTanks(NBTTagCompound nbt) {
		Tanks.readTanks(nbt, fluidTanks);
	}

	@Override
	public void writeTanks(NBTTagCompound nbt) {
		Tanks.writeTanks(nbt, fluidTanks);
	}

	@Override
	public void addTank(int capacity, boolean input, boolean output) {
		Tanks.addTank(capacity, input, output, fluidTanks, this);
	}

	@Override
	public int fill(int ID, ForgeDirection from, FluidStack resource, boolean doFill) {
		return Tanks.fill(ID, from, resource, doFill, fluidTanks, this, mapping, recipe);
	}

	@Override
	public FluidStack drain(int ID, ForgeDirection from, FluidStack resource, boolean doDrain) {
		return Tanks.drain(ID, from, resource, doDrain, fluidTanks, this, mapping);
	}

	@Override
	public FluidStack drain(int ID, ForgeDirection from, int maxDrain, boolean doDrain) {
		return Tanks.drain(ID, from, maxDrain, doDrain, fluidTanks, this, mapping);
	}

	@Override
	public boolean canDrain(int ID,ForgeDirection from, Fluid fluid) {
		return Tanks.canDrain(ID,from, fluid, mapping,recipe);
	}

	@Override
	public boolean canFill(int ID,ForgeDirection from, Fluid fluid) {
		return Tanks.canFill(ID, from, fluid, mapping, recipe);
	}

	@Override
	public boolean isTankValidForFluid(int ID,ForgeDirection from, int fluidId) {
		return Tanks.isTankValidForFluid(ID, from, fluidId, mapping, recipe);
	}

	@Override
	public FluidTankInfo[] getTankInfo(int ID, ForgeDirection from) {
		return Tanks.getTankInfo(ID, from, fluidTanks, mapping);
	}
}
