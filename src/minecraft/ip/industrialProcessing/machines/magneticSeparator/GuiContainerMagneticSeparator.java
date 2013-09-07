package ip.industrialProcessing.machines.magneticSeparator;

import ip.industrialProcessing.machines.containers.gui.GuiContainerMachine;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiContainerMagneticSeparator extends GuiContainerMachine {

	private TileEntityMagneticSeparator tileEntity;

	public GuiContainerMagneticSeparator(InventoryPlayer inventoryPlayer,
			TileEntityMagneticSeparator tileEntity) {
		super(inventoryPlayer, tileEntity, new ContainerMagneticSeparator(
				inventoryPlayer, tileEntity), "Magnetic Ore Separator", "textures/gui/MagneticSeparator.png");
		this.tileEntity = tileEntity;
	}

}
