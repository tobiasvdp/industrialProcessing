package ip.industrialProcessing.transport.items.conveyorSorter;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.containers.ContainerMachine;
import ip.industrialProcessing.machines.containers.gui.GuiContainerMachine;

public class GuiContainerSorter extends GuiContainerMachine {

    public GuiContainerSorter(InventoryPlayer inventoryPlayer, TileEntityConveyorSorter tileEntity) {
	this(inventoryPlayer, tileEntity, new ContainerSorter(inventoryPlayer, tileEntity));
    }

    private ContainerMachine container;

    private GuiContainerSorter(InventoryPlayer inventoryPlayer, TileEntityConveyorSorter tileEntity, ContainerSorter container) {
	super(inventoryPlayer, tileEntity, container, "Conveyor Sorter", "textures/gui/ConveyorSorter.png");
	this.container = container;
    }

}
