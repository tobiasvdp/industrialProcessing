package mod.industrialProcessing.plants.transport.conveyorInput;

import javax.swing.Icon;

import mod.industrialProcessing.gui.generating.GuiBuilderDefault;
import mod.industrialProcessing.gui.generating.IGuiBuilder;
import mod.industrialProcessing.transport.items.conveyorBelt.block.BlockConveyorMachineBase;
import mod.industrialProcessing.utils.block.IDescriptionBlock;
import mod.industrialProcessing.utils.block.IGuiBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockConveyorInput extends BlockConveyorMachineBase implements IDescriptionBlock, IGuiBlock {

	public static IGuiBuilder guiBuilder = new GuiBuilderDefault("BlockConveyorInput").addSpinner(0, "%.0f items", 1, 16 * 4);

	public BlockConveyorInput() {
		super(1.0f, 1.0f, Material.iron, Block.soundTypeMetal, "tankSide", "conveyorHopperFeatures", "packer");
	}

	@Override
	public String getDescription() {
		return "A machine that can take items from a nearby inventory and output it on the conveyor belt";
	}

	@Override
	public IGuiBuilder getGui() {
		return guiBuilder;
	}
}
