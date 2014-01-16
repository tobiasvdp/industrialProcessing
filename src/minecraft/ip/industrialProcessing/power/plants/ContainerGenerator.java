package ip.industrialProcessing.power.plants;

import ip.industrialProcessing.machines.containers.ContainerMachine;
import ip.industrialProcessing.machines.containers.ProgressBarHandlerInfo;
import ip.industrialProcessing.power.GeneratorProgress;
import ip.industrialProcessing.power.GeneratorProgressHandler;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerGenerator extends ContainerMachine {

	private ProgressBarHandlerInfo generatorInfo;

	public ContainerGenerator(InventoryPlayer inventoryPlayer, TileEntityGenerator tileEntity) {
		super(inventoryPlayer, tileEntity);
		ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);

		this.generatorInfo = addProgressBar(new GeneratorProgressHandler(tileEntity));
	}

	public GeneratorProgress getProgress() {
		return GeneratorProgressHandler.getInfo(this.generatorInfo);
	}
}
