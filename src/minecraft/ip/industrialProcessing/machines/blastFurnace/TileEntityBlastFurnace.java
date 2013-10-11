package ip.industrialProcessing.machines.blastFurnace;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.MachineItemStack;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.machines.crusher.RecipesCrusher;
import ip.industrialProcessing.recipes.Recipe;

import java.util.Iterator;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

public class TileEntityBlastFurnace extends TileEntityPoweredFluidWorkerMachine {

	public static RecipesBlastFurnace recipes = new RecipesBlastFurnace();
	private boolean init = true;

	public TileEntityBlastFurnace() {
		super(LocalDirection.LEFT, 10000, 20);
	}

	@Override
	public void updateEntity() {
		if (init) {
			if (!isDummyBlock(worldObj, xCoord, yCoord, zCoord)) {
				LocalDirection[] nodirections = new LocalDirection[0];

				this.addStack(null, LocalDirection.UP, true, false);
				this.addStack(null, LocalDirection.UP, true, false);
				this.addStack(null, LocalDirection.UP, true, false);

				addStack(null, nodirections, true, false);
				addStack(null, nodirections, false, true);
				addStack(null, nodirections, true, false);
				addStack(null, nodirections, false, true);

				addTank(FluidContainerRegistry.BUCKET_VOLUME * 50, LocalDirection.RIGHT, false, true);
				addTank(FluidContainerRegistry.BUCKET_VOLUME * 50, LocalDirection.DOWN, false, true);
				addTank(FluidContainerRegistry.BUCKET_VOLUME * 50, LocalDirection.BACK, false, true);

			} else {
				int meta = worldObj.getBlockMetadata(xCoord, yCoord - 1, zCoord);
				worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, meta, 0);

				LocalDirection[] nodirections = new LocalDirection[0];

				this.addStack(null, LocalDirection.BACK, true, false);
				this.addStack(null, LocalDirection.RIGHT, true, false);
				this.addStack(null, LocalDirection.LEFT, true, false);

				addStack(null, nodirections, true, false);
				addStack(null, nodirections, false, true);
				addStack(null, nodirections, true, false);
				addStack(null, nodirections, false, true);
			}
			worldObj.notifyBlocksOfNeighborChange(xCoord, yCoord, zCoord, IndustrialProcessing.blockBlastFurnace.blockID);
			init = false;
		}
		if (!isDummyBlock) {
			getBucketFromTank(3, 4, 0);
			getBucketFromTank(5, 6, 1);
			super.updateEntity();
		} else {
			pushStackDown(0);
			pushStackDown(1);
			pushStackDown(2);
		}
	};

	private boolean pushStackDown(int slot) {
		ItemStack stack = getStackInSlot(slot);
		if (stack == null)
			return false;
		TileEntityBlastFurnace te = (TileEntityBlastFurnace) worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord);
		int[] slots = te.getAccessibleSlotsFromSide(ForgeDirection.UP.ordinal());
		for (int i = 0; i < slots.length; i++) {
			if (te.canInsertItem(slots[i], stack, stack.stackSize)) {
				if (te.getStackInSlot(slots[i]) != null) {
						te.setInventorySlotContents(slots[i], new ItemStack(stack.getItem(), stack.stackSize + te.getStackInSlot(slots[i]).stackSize));
						te.onInventoryChanged();
						decrStackSize(slot, stack.stackSize);
						onInventoryChanged();
				} else {
					te.setInventorySlotContents(slots[i], new ItemStack(stack.getItem(), stack.stackSize));
					te.onInventoryChanged();
					decrStackSize(slot, stack.stackSize);
					onInventoryChanged();
				}
			}
		}
		return false;
	}

	@Override
	public boolean hasWork() {
		return true;
	}

	@Override
	public boolean canWork() {
		return true;
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		if (slot == 0)
			return recipes.isValidInput(slot, itemID);
		if (slot == 1)
			return recipes.isValidInput(slot, itemID);
		if (slot == 2)
			return recipes.isValidInput(slot, itemID);

		if (slot == 3 || slot == 5) // fluid output container input
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

	public boolean isDummyBlock(World world, int x, int y, int z) {
		TileEntity entity = world.getBlockTileEntity(x, y - 1, z);
		if (entity != null && entity instanceof TileEntityBlastFurnace && !((TileEntityBlastFurnace) entity).isDummyBlock(world, x, y - 1, z)) {
			isDummyBlock = true;
			return true;
		}
		return false;
	}

	public boolean hasDummyBlock(World world, int x, int y, int z) {
		TileEntity entity = world.getBlockTileEntity(x, y + 1, z);
		if (entity != null && entity instanceof TileEntityBlastFurnace && ((TileEntityBlastFurnace) entity).isDummyBlock(world, x, y + 1, z)) {
			return true;
		}
		return false;
	}
    @Override
    public boolean canInsertItem(int slotIndex, ItemStack itemstack, int amount) {
    if (isDummyBlock){
    	if (!((TileEntityMachine) worldObj.getBlockTileEntity(xCoord, yCoord-1, zCoord)).canInsertItem(slotIndex,itemstack,amount))
    		return false;
    	else
    		return true;
    }else{
		MachineItemStack machineStack = getMachineStack(slotIndex);
		if (machineStack != null && machineStack.input) {
			if (machineStack.stack == null) {
				return isItemValidForSlot(slotIndex, itemstack);
			} else if(machineStack.stack.stackSize + amount <= 64){
				return isItemValidForSlot(slotIndex, itemstack);
			}
		}
		return false;
    }}

    @Override
    public void addPressure(ForgeDirection from, float pressure) { 
    }
}
