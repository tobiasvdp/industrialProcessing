package ip.industrialProcessing.multiblock.core.block.weldingStation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import ip.industrialProcessing.machines.crusher.TileEntityCrusher;
import ip.industrialProcessing.multiblock.container.ContainerMultiblock;
import ip.industrialProcessing.multiblock.container.ContainerMultiblockTankWorkerPowered;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreInv;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreTankWorkerPowered;
import ip.industrialProcessing.multiblock.gui.CTmultiblock;
import ip.industrialProcessing.multiblock.gui.GUImultiblock;

public class GuiContainerWeldingStation extends GUImultiblock{

	private static final Rectangle PROGRESSBAR_SOURCE = new Rectangle(198, 0, 22, 16);
	private static final Point PROGRESSBAR_LOCATION = new Point(106, 31);
	
	public GuiContainerWeldingStation(InventoryPlayer inventory, TEmultiblockCoreTankWorkerPowered entity) {
		super(inventory, entity, new ContainerWeldingStation(inventory, entity), "Welding Table", "textures/gui/WeldingTable.png");
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		super.drawGuiContainerForegroundLayer(param1, param2);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);
		drawProgressBarWorker(PROGRESSBAR_SOURCE, PROGRESSBAR_LOCATION, true, 0);
	}
}