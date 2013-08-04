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
				inventoryPlayer, tileEntity), "Magnetic Ore Separator", "textures/gui/MagneticSeparator.png");
		this.tileEntity = tileEntity;
	}
	@Override
	public void extendedDraw(){
		int scale = tileEntity.getScaledProgress(22);
		if (scale != 0){
		    int x = (width - xSize) / 2;
		    int y = (height - ySize) / 2;
			this.drawTexturedModalRect(x+70, y+34, 176, 0, scale, 16);
		}
	}

}
