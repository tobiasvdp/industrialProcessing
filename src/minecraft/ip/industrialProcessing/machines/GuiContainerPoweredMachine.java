package ip.industrialProcessing.machines;

import net.minecraft.entity.player.InventoryPlayer;

public class GuiContainerPoweredMachine extends GuiContainerMachine {

    private TileEntityPoweredWorkerMachine powerMachine;

    public GuiContainerPoweredMachine(InventoryPlayer inventoryPlayer, TileEntityPoweredWorkerMachine tileEntity, ContainerMachine container, String name, String textureLocation) {
	super(inventoryPlayer, tileEntity, container, name, textureLocation);
	this.powerMachine = tileEntity;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) { 
        super.drawGuiContainerForegroundLayer(param1, param2); 
	fontRenderer.drawString(this.powerMachine.getStoredPower()+" Joules", 8, 16, 4210752);
    }
}
