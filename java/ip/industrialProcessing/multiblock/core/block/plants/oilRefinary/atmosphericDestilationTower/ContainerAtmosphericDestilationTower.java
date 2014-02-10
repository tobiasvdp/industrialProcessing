package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.atmosphericDestilationTower;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.multiblock.container.ContainerMultiblockTankWorkerPowered;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreTankWorkerPowered;
import ip.industrialProcessing.slots.SlotLiquid;
import ip.industrialProcessing.slots.SlotLiquidOutput;

public class ContainerAtmosphericDestilationTower  extends ContainerMultiblockTankWorkerPowered{
	private SlotLiquid inputWaterFullInput;
	private SlotLiquidOutput inputWaterEmptyOutput;
	
	public ContainerAtmosphericDestilationTower(InventoryPlayer inventory, TileEntityMultiblockCoreTankWorkerPowered core){
		super(inventory, core);
		
		inputWaterFullInput = new SlotLiquid(core, 0, 8, 19);
		inputWaterEmptyOutput = new SlotLiquidOutput(core, 1, 8, 53);
		
		addSlotToContainer(inputWaterFullInput);
		addSlotToContainer(inputWaterEmptyOutput);
		
		BindPlayerInventory(inventory, this, 0,0,0);
		
		addTankToContainer(0);
		addTankToContainer(1);
		addTankToContainer(2);
		addTankToContainer(3);
		addTankToContainer(4);
		addTankToContainer(5);
		addTankToContainer(6);
		addTankToContainer(7);
		
		addPowerToContainer(core.getMainPowerStorage());
		addWorkerToContainer(core.getWorker());
	}
	
	@Override
	public int getSizeInventory() {
		return 2;
	}

}
