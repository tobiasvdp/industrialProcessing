package ip.industrialProcessing.power.plants;

import java.util.Iterator;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.MachineFluidTank;
import ip.industrialProcessing.machines.TileEntityFluidWorkerMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.utils.FluidTransfers;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidHandler;

public class TileEntityBoiler extends TileEntityFluidWorkerMachine implements IHeatable {

	private static RecipesBoiler recipes = new RecipesBoiler();
	private float heat = 0;

	public TileEntityBoiler() {
		addTank(10 * FluidContainerRegistry.BUCKET_VOLUME, LocalDirection.BACK, true, false);
		addTank(10 * FluidContainerRegistry.BUCKET_VOLUME, LocalDirection.UP, false, true);

		addStack(null, new LocalDirection[0], true, false);
		addStack(null, new LocalDirection[0], false, true);
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
		addBucketToTank(0, 1, 0);

		float COOLING_RATE = 0.001f;
		if (!this.worldObj.isRemote) {
			int ambientTemperature = (int) (this.worldObj.getBiomeGenForCoords(xCoord, zCoord).getFloatTemperature() * 20);
			// the hotter the boiler get,
			// the faster the heat dissipates to the environment:
			this.heat += COOLING_RATE * (ambientTemperature - this.heat);
			System.out.println("heat: " + this.heat + " -> " + ambientTemperature);
			
			IFluidHandler handler = getFluidHandler(xCoord, yCoord+1, zCoord);
			if(handler != null)
			{
				FluidTransfers.transfer(100, this.getTankInSlot(1), handler, ForgeDirection.DOWN);
			}
		}
		
		
	}

	private IFluidHandler getFluidHandler(int x, int y, int z) {
		TileEntity entityAbove = this.worldObj.getBlockTileEntity(x, y, z);
		if(entityAbove instanceof IFluidHandler)
			return (IFluidHandler)entityAbove;
		return null;
	}

	@Override
	protected void doWork() {
		if (heat > 0) {
			int done = work((int)((heat - 100) /10f));
			this.heat -= done / 50f;
		}
	}

	@Override
	protected boolean isTankValidForFluid(int slot, int fluidId) {
		return slot == 0 && fluidId == FluidRegistry.WATER.getID();
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		if (slot == 0) { // fluid input container input slot, only filled
			// containers with correct fluid (=water)
			FluidStack fluid = FluidContainerRegistry.getFluidForFilledItem(new ItemStack(itemID, 1, 0));
			if (fluid == null)
				return false;
			return recipes.isValidFluidInput(0, fluid.fluidID);
		}
		return false;
	}

	@Override
	public void addHeat(int heat) {
		this.heat += heat / 1.5f;
	}

	@Override
	public Iterator<Recipe> iterateRecipes() {
		return recipes.iterator();
	}

	public int getTemperature() { 
		return (int)this.heat;
	}

}
