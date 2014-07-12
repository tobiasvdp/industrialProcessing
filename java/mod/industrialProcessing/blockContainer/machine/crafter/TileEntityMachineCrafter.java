package mod.industrialProcessing.blockContainer.machine.crafter;

import java.util.Iterator;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.blockContainer.machine.TileEntityMachineInv;
import mod.industrialProcessing.utils.rotation.IRotateableEntity;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import mod.industrialProcessing.work.recipe.IMachineRecipe;
import mod.industrialProcessing.work.recipe.RecipesMachine;
import mod.industrialProcessing.work.recipe.Inputs.InputItem;
import mod.industrialProcessing.work.recipe.slots.RecipeInputInventorySlot;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TileEntityMachineCrafter extends TileEntityMachineInv {

	static RecipesMachine recipes;
	protected boolean needsToClose = false;
	protected boolean blockset = false;

	public TileEntityMachineCrafter(int inputs, int fillingSlot, Block fillingBlock, boolean blockset, RecipesMachine recipes) {
		this.recipes = recipes;
		this.blockset = blockset;
		addStack(null, LocalDirection.UNKNOWN, false, true);
		for (int i = 0; i < inputs; i++)
			addStack(null, LocalDirection.UNKNOWN, true, false);
		if (fillingSlot != -1)
			this.setInventorySlotContents(fillingSlot, new ItemStack(fillingBlock, 0));
	}

	public static ItemStack getOutputForInput(TileEntityMachineCrafter te) {
		Iterator<IMachineRecipe> it = recipes.getRecipes();
		while (it.hasNext()) {
			IMachineRecipe recipe = it.next();

			int offset = 0;
			boolean keepLooking = true;
			for (int i = 0; i < te.getSizeInventory() && keepLooking; i++) {
				if (te.getMachineStack(i).input) {
					offset = i;
					keepLooking = false;
				}
			}

			boolean notRecipe = false;
			for (int i = 0; i < te.getSizeInventory() && !notRecipe; i++) {
				if (te.getMachineStack(i).input) {
					if (te.getMachineStack(i).stack != null) {
						boolean found = false;
						for (RecipeInputInventorySlot input : recipe.getInventoryInputs()) {
							if (input.index == i - offset) {
								if (input.getItem() == null) {
									notRecipe = true;
								} else {
									InputItem item = input.getItem();
									
									if(!item.isValid(te.getMachineStack(i).stack)){
										notRecipe = true;
									}
								}
								found = true;
							}
						}
						if (!found) {
							notRecipe = true;
						}
					} else {
						for (RecipeInputInventorySlot input : recipe.getInventoryInputs()) {
							if (input.index == i - offset) {
								notRecipe = true;
							}
						}
					}
				}
			}
			if (!notRecipe) {
				return new ItemStack(recipe.getInventoryOutputs()[0].getItem(), recipe.getInventoryOutputs()[0].minAmount, recipe.getInventoryOutputs()[0].metadata);
			}
		}
		return null;
	}

	public static IMachineRecipe getRecipeForInput(TileEntityMachineCrafter te) {
		Iterator<IMachineRecipe> it = recipes.getRecipes();
		while (it.hasNext()) {
			IMachineRecipe recipe = it.next();

			int offset = getInputOffset(te);

			boolean notRecipe = false;
			for (int i = 0; i < te.getSizeInventory() && !notRecipe; i++) {
				if (te.getMachineStack(i).input) {
					if (te.getMachineStack(i).stack != null) {
						boolean found = false;
						for (RecipeInputInventorySlot input : recipe.getInventoryInputs()) {
							if (input.index == i - offset) {
								if (input.getItem() == null) {
									notRecipe = true;
								} else {
									if (!input.getItem().equals(te.getMachineStack(i).stack.getItem())) {
										notRecipe = true;
									}
								}
								found = true;
							}
						}
						if (!found) {
							notRecipe = true;
						}
					} else {
						for (RecipeInputInventorySlot input : recipe.getInventoryInputs()) {
							if (input.index == i - offset) {
								notRecipe = true;
							}
						}
					}
				}
			}
			if (!notRecipe) {
				return recipe;
			}
		}
		return null;
	}

	private static int getInputOffset(TileEntityMachineCrafter te) {
		int offset = 0;
		boolean keepLooking = true;
		for (int i = 0; i < te.getSizeInventory() && keepLooking; i++) {
			if (te.getMachineStack(i).input) {
				offset = i;
				keepLooking = false;
			}
		}
		return offset;
	}

	public static void onProduceOutput(TileEntityMachineCrafter te, EntityPlayer par4EntityPlayer) {
		if (te != null) {
			IMachineRecipe recipe = getRecipeForInput(te);
			int offset = getInputOffset(te);

			if (recipe != null) {
				for (RecipeInputInventorySlot input : recipe.getInventoryInputs()) {
					te.decrStackSize(input.index + offset, 1);
				}
				te.onProduce(recipe.getInventoryOutputs()[0].getItem(), par4EntityPlayer);
			}
		}
	}

	public boolean needsToClose() {
		return needsToClose;
	}

	public void onProduce(Item item, EntityPlayer par4EntityPlayer) {
		if (blockset) {
			this.getWorldObj().setBlock(xCoord, yCoord, zCoord, Block.getBlockFromItem(item));
			((IRotateableEntity) this.getWorldObj().getTileEntity(xCoord, yCoord, zCoord)).setForwardDirection(this.getForwardDirection());
			par4EntityPlayer.inventory.setItemStack(null);
			needsToClose = true;
		}
	}

}
