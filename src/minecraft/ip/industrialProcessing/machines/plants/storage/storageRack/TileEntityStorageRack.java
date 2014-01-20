package ip.industrialProcessing.machines.plants.storage.storageRack;

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
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class TileEntityStorageRack  extends TileEntityMachine{

	public TileEntityStorageRack() {
		addStack(null, LocalDirection.BACK, true, false);
		addStack(null, LocalDirection.BACK, true, false);
		addStack(null, LocalDirection.BACK, true, false);
		addStack(null, LocalDirection.BACK, true, false);
		addStack(null, LocalDirection.BACK, true, false);
		addStack(null, LocalDirection.BACK, true, false);
	}
	
	@Override
	protected boolean isValidInput(int slot, int itemID) {
		return itemID == IndustrialProcessing.blockStorageBox.blockID;
	}
	
	
}
