package ip.industrialProcessing.machines.crusher;

import java.util.Iterator;

import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.recipes.Recipe;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityCrusher extends TileEntityMachine {

	public static RecipesCrusher recipes = new RecipesCrusher();
	private int speed;

	public TileEntityCrusher() {
		super();
		this.addStack(null, ForgeDirection.UP, true, false);
		this.addStack(null, new ForgeDirection[] { ForgeDirection.SOUTH,
				ForgeDirection.NORTH, ForgeDirection.EAST, ForgeDirection.WEST,
				ForgeDirection.DOWN }, false, true);
		this.speed = 10;
	}

	@Override
	protected void work() {
		worker.doWork(this.speed / 10, this.getWorldObj().isRemote);
	};

	@Override
	public boolean hasWork() {
		return true;
	}

	@Override
	public boolean canWork() {
		return true;
	}

	@Override
	public void workCancelled(boolean remote) {
		this.speed = 10; // reset speed
		// TODO: stop sound
	}

	@Override
	public void workDone(boolean remote) { // example on how to speed up!
		if (worker.hasWork()) {
			this.speed += 1;
			if (this.speed > 50) // max speed
				this.speed = 50;
		} else {
			this.speed = 10;
			// TODO: stop sound
		}
	}

	@Override
	public void beginWork(boolean remote) {
		// TODO: start sound
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		return recipes.isValidInput(slot, itemID);
	}

	@Override
	public Iterator<Recipe> iterateRecipes() {
		return recipes.iterator();
	}

}
