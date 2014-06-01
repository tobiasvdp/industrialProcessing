package mod.industrialProcessing.blockContainer.multiblock.core.block.plants.storage.container;

import mod.industrialProcessing.blockContainer.multiblock.core.BlockMultiblockCore;
import mod.industrialProcessing.gui.framework.panels.Orientation;
import mod.industrialProcessing.gui.generating.GuiBuilderDefault;
import mod.industrialProcessing.gui.generating.GuiBuilderInventory;
import mod.industrialProcessing.gui.generating.IGuiBuilder;
import mod.industrialProcessing.utils.block.IDescriptionBlock;
import mod.industrialProcessing.utils.block.IGuiBlock;
import net.minecraft.block.material.Material;

public class BlockContainer extends BlockMultiblockCore implements IDescriptionBlock, IGuiBlock{
	
	public static IGuiBuilder guiBuilder = new GuiBuilderInventory("Container").setMode(Orientation.VERTICAL).addInventoryHeaderRow(-1, 0, 98, 7);
	
	public BlockContainer() {
		super(1.0f,1.0f,Material.iron,soundTypeMetal,"red");
	}

	@Override
	public IGuiBuilder getGui() {
		return guiBuilder;
	}

	@Override
	public String getDescription() {
		return "A big ass chest";
	}
	
}
