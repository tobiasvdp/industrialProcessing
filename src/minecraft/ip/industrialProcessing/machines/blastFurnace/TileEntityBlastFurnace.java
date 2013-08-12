package ip.industrialProcessing.machines.blastFurnace;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.machines.crusher.RecipesCrusher;
import ip.industrialProcessing.recipes.Recipe;

import java.util.Iterator;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

public class TileEntityBlastFurnace extends TileEntityPoweredFluidWorkerMachine {

	public static RecipesBlastFurnace recipes = new RecipesBlastFurnace();

	public TileEntityBlastFurnace(World world) {
		super(LocalDirection.LEFT, 10000);
		this.addStack(null, LocalDirection.UP, true, false);
		this.addStack(null, LocalDirection.DOWN, false, true);

		addTank(FluidContainerRegistry.BUCKET_VOLUME * 50, LocalDirection.RIGHT, true, false);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 50, LocalDirection.RIGHT, true, false);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 50, LocalDirection.RIGHT, true, false);
	}

	@Override
	public void updateEntity() {
		getBucketFromTank(3, 4, 0);
		getBucketFromTank(5, 6, 1);
		getBucketFromTank(7, 8, 1);
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
	protected boolean isValidInput(int slot, int itemID) {
		if (slot == 0)return recipes.isValidInput(slot, itemID);
		if (slot == 1)return recipes.isValidInput(slot, itemID);
		if (slot == 2)return recipes.isValidInput(slot, itemID);

		if (slot == 3 || slot == 5 || slot == 7) // fluid output container input
													// slot, only empty
													// container
			return FluidContainerRegistry.isEmptyContainer(new ItemStack(itemID, 1, 0));
		return false;
	}

	@Override
	public Iterator<Recipe> iterateRecipes() {
		return recipes.iterator();
	}

	@Override
	protected boolean isTankValidForFluid(int slot, int fluidId) {
		return recipes.isValidFluidInput(slot, fluidId);
	}

}
