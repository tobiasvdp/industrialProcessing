package ip.industrialProcessing.machines.mixer;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.MachineFluidTank;
import ip.industrialProcessing.machines.TileEntityFluidMachine;
import ip.industrialProcessing.machines.TileEntityFluidWorkerMachine;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.recipes.Recipe;

import java.util.Iterator;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

public class TileEntityMixer extends TileEntityPoweredFluidWorkerMachine {

    private static RecipesMixer recipes = new RecipesMixer();

    public TileEntityMixer() {
	super(LocalDirection.LEFT, 10000);
	addStack(null, LocalDirection.UP, true, false); // Mixing ingredient

	LocalDirection[] nodirections = new LocalDirection[0];
	// buckets!
	addStack(null, nodirections, true, false); // Liquid Input Full
						   // Input
	addStack(null, nodirections, false, true); // Liquid Input Empty
						   // Output
	addStack(null, nodirections, true, false); // Liquid Output Empty
						   // Input
	addStack(null, nodirections, false, true); // Liquid Output Full
						   // Output

	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.LEFT, true, false);
	addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.DOWN, false, true);
    }

    @Override
    public void updateEntity() {
	addBucketToTank(1, 2, 0);
	getBucketFromTank(3, 4, 1);
	super.updateEntity();
    };

    @SideOnly(Side.SERVER)
    @Override
    public boolean hasWork() {
	return true;
    }

    @SideOnly(Side.SERVER)
    @Override
    public boolean canWork() {
	return true;
    }

    @Override
    public Iterator<Recipe> iterateRecipes() {
	return recipes.iterator();
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
	if (slot == 0) // 0 is the recipe slot, others are buckets for liquid
		       // containers
	    return recipes.isValidInput(slot, itemID);

	if (slot == 3) // fluid output container input slot, only empty
		       // container
	    return FluidContainerRegistry.isEmptyContainer(new ItemStack(itemID, 1, 0));

	if (slot == 1) { // fluid input container input slot, only filled
			 // containers with correct fluid
	    FluidStack fluid = FluidContainerRegistry.getFluidForFilledItem(new ItemStack(itemID, 1, 0));
	    if (fluid == null)
		return false;
	    return recipes.isValidFluidInput(0, fluid.fluidID);
	}
	return false;
    }

    @Override
    protected boolean isTankValidForFluid(int slot, int fluidId) {
	return recipes.isValidFluidInput(slot, fluidId);
    }

}
