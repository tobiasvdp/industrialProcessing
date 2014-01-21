package ip.industrialProcessing.machines.plants.storage.storageRack;

import java.io.ObjectOutputStream.PutField;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.IGuiLayout;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.machines.hydroCyclone.TileEntityHydroCyclone;
import ip.industrialProcessing.recipes.IRecipeBlock;
import ip.industrialProcessing.utils.IDescriptionBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class TileEntityStorageRack extends TileEntityMachine {

    public TileEntityStorageRack() {
	// conveyors/pipes can't pick up boxes from here!
	LocalDirection[] noDirection = new LocalDirection[0];
	addStack(null, noDirection, false, false);
	addStack(null, noDirection, false, false);
	addStack(null, noDirection, false, false);
	addStack(null, noDirection, false, false);
	addStack(null, noDirection, false, false);
	addStack(null, noDirection, false, false);
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
	return itemID == IndustrialProcessing.blockStorageBox.blockID;
    }

    public ItemStack popBox() {
	for (int i = 0; i < 6; i++) {
	    ItemStack stack = decrStackSize(i, 1);
	    if (stack != null)
		return stack;
	}
	return null;
    }

    public boolean pushBox(ItemStack itemStack) {

	if (itemStack == null)
	    return false; 
	if (itemStack.stackSize != 1)
	    return false;
	for (int i = 0; i < 6; i++) {
	    if (isValidInput(i, itemStack.itemID)) {
		ItemStack slot = getStackInSlot(i);
		if (slot == null) {
		    this.setInventorySlotContents(i, itemStack);
		    return true;
		}
	    }
	}
	return false;
    }

}
