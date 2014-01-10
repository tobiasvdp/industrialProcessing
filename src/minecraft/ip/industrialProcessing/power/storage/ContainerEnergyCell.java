package ip.industrialProcessing.power.storage;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import ip.industrialProcessing.machines.containers.ContainerMachine;
import ip.industrialProcessing.machines.containers.IProgressBarHandler;
import ip.industrialProcessing.machines.containers.ProgressBarHandlerInfo;
import ip.industrialProcessing.utils.containers.ContainerUtils;

public class ContainerEnergyCell extends ContainerMachine {

    private TileEntityEnergyCell energyCell;
    private ProgressBarHandlerInfo chargeInfo;

    public ContainerEnergyCell(InventoryPlayer inventoryPlayer, TileEntityEnergyCell tileEntity) {
	super(inventoryPlayer, tileEntity);
	this.energyCell = tileEntity;

	this.chargeInfo = addProgressBar(new IProgressBarHandler() {

	    @Override
	    public int getValueCount() {
		return 3;
	    }

	    @Override
	    public int getValue(int i) {
		if (i == 0)
		    return (int) (energyCell.getStoredJoules() * 100);
		if (i == 1)
		    return (int) (energyCell.getTotalJouleCapacity() * 100);
		if (i == 2)
		    return (int) (energyCell.getVoltage() * 100);
		return 0;
	    }
	});
	
	ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
    }

    public float getStoredJoules() {
	return this.chargeInfo.getValueStorage()[0] / 100f;
    }

    public float getTotalJouleCapacity() {
	return this.chargeInfo.getValueStorage()[1] / 100f;
    }

    public float getVoltage() {
	return this.chargeInfo.getValueStorage()[2] / 100f;
    }

}
