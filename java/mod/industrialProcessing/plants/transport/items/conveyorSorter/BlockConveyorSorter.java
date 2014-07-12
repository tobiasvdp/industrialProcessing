package mod.industrialProcessing.plants.transport.items.conveyorSorter;

import mod.industrialProcessing.gui.framework.panels.Orientation;
import mod.industrialProcessing.gui.generating.GuiBuilderDefault;
import mod.industrialProcessing.gui.generating.IGuiBuilder;
import mod.industrialProcessing.transport.items.conveyorBelt.block.BlockConveyorMachineBase;
import mod.industrialProcessing.utils.block.IDescriptionBlock;
import mod.industrialProcessing.utils.block.IGuiBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockConveyorSorter extends BlockConveyorMachineBase implements IDescriptionBlock, IGuiBlock {

	public static IGuiBuilder guiBuilder = new GuiBuilderDefault("Conveyor Sorter").addInputSlot(0).addInputSlotCluster(1, 9, 3, Orientation.HORIZONTAL).addInputSlotCluster(0, 9, 3, Orientation.HORIZONTAL).addInputSlotCluster(10, 9, 3, Orientation.HORIZONTAL);

	public BlockConveyorSorter() {
		// super(ConfigMachineBlocks.getBLtransportConveyorBeltSorter(), Material.iron, 5.0f, Block.soundTypeMetal, "Conveyor Sorter", ISetupCreativeTabs.tabPower);

		super(5.0f, 5.0f, Material.iron, Block.soundTypeMetal, "conveyorSorter");
	}

	@Override
	public IGuiBuilder getGui() {
		return guiBuilder;
	}

	@Override
	public String getDescription() {
		return "A conveyor that can send items to the sides when they match a configured filter.";
	}
}
