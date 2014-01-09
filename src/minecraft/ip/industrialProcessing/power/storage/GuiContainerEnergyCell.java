package ip.industrialProcessing.power.storage;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import ip.industrialProcessing.machines.containers.ContainerMachine;
import ip.industrialProcessing.machines.containers.gui.GuiContainerMachine;
import ip.industrialProcessing.power.GeneratorProgress;
import ip.industrialProcessing.power.plants.ContainerSolidBurner;
import ip.industrialProcessing.power.plants.TileEntitySolidBurner;

public class GuiContainerEnergyCell extends GuiContainerMachine {

    private ContainerEnergyCell container;

    public GuiContainerEnergyCell(InventoryPlayer inventoryPlayer, TileEntityEnergyCell tileEntity) {
	this(inventoryPlayer, tileEntity, new ContainerEnergyCell(inventoryPlayer, tileEntity));
    }

    private GuiContainerEnergyCell(InventoryPlayer inventoryPlayer, TileEntityEnergyCell tileEntity, ContainerEnergyCell container) {
	super(inventoryPlayer, tileEntity, container, "Energy Cell", "textures/gui/EnergyCell.png");
	this.container = container;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
	// TODO Auto-generated method stub
	super.drawGuiContainerBackgroundLayer(par1, par2, par3);

	float stored = this.container.getStoredJoules();
	float total = this.container.getTotalJouleCapacity();

	drawHorizontalProgressBar(62, 41, 176, 0, 52, 7, (int) stored, (int) total, false);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) {
	super.drawGuiContainerForegroundLayer(param1, param2);
	fontRenderer.drawString("  Storage:", 8, 40, 4210752);
	fontRenderer.drawString("    Output:", 8, 52, 4210752);

	float stored = this.container.getStoredJoules() / 1000f;
	float voltage = this.container.getVoltage();
	
	fontRenderer.drawString(String.format("%.2fkJ", stored), 120, 40, 4210752);
	fontRenderer.drawString(String.format("%.2fV", voltage), 120, 52, 4210752);
    }
}
