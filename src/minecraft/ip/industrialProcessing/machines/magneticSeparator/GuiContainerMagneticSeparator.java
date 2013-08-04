package ip.industrialProcessing.machines.magneticSeparator;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import ip.industrialProcessing.machines.ContainerMachine;
import ip.industrialProcessing.machines.GuiContainerMachine;
import ip.industrialProcessing.machines.filter.ContainerFilter;
import ip.industrialProcessing.machines.filter.TileEntityFilter;

public class GuiContainerMagneticSeparator extends GuiContainerMachine {

	private TileEntityMagneticSeparator tileEntity;

	public GuiContainerMagneticSeparator(InventoryPlayer inventoryPlayer,
			TileEntityMagneticSeparator tileEntity) {
		super(inventoryPlayer, tileEntity, new ContainerMagneticSeparator(
				inventoryPlayer, tileEntity), "Ore Filter", "none");
		this.tileEntity = tileEntity;
	}

}
