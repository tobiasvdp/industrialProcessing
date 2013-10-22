package ip.industrialProcessing.machines.electrolyser;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.containers.ContainerPoweredFluidWorkerMachine;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotLiquid;
import ip.industrialProcessing.slots.SlotLiquidOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;

public class ContainerElectrolyser extends ContainerPoweredFluidWorkerMachine{
	public ContainerElectrolyser(InventoryPlayer inventoryPlayer, TileEntityElectrolyser tileEntity) {
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
