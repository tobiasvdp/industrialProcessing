package ip.industrialProcessing.machines.plants.oilRefinary.AlkylationUnit;

import ip.industrialProcessing.machines.containers.ContainerPoweredFluidWorkerMachine;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerAlkylationUnit  extends ContainerPoweredFluidWorkerMachine{
	
	public ContainerAlkylationUnit(InventoryPlayer inventoryPlayer, TileEntityAlkylationUnit tileEntity) {
		super(inventoryPlayer, tileEntity);
		
		ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
		
		addTankToContainer(0);
		addTankToContainer(1);
		addTankToContainer(2);
		addTankToContainer(3);

		addWorkerToContainer(tileEntity.getWorker());
        addPowerToContainer(tileEntity.getMainPowerStorage());
	}
	
	@Override
	public int getSizeInventory() {
		return 0;
	}

}
