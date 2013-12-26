package ip.industrialProcessing.multiblock.core.block.plants.blacksmith.bloomery;

import ip.industrialProcessing.multiblock.core.block.weldingStation.ContainerWeldingStation;
import ip.industrialProcessing.multiblock.core.block.weldingStation.TEmultiblockWeldingStation;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreTankWorker;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreTankWorkerPowered;
import ip.industrialProcessing.multiblock.gui.GUImultiblock;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

public class GuiContainerBloomery extends GUImultiblock{

	private static final Rectangle PROGRESSBAR_SOURCE = new Rectangle(198, 0, 22, 16);
	private static final Point PROGRESSBAR_LOCATION = new Point(104, 31);
	
	private static final Rectangle THERMO_SOURCE = new Rectangle(204, 22, 5, 35);
	private static final Point THERMO_LOCATION = new Point(13, 15);
	
	private static final Rectangle BURN_SOURCE = new Rectangle(198, 86, 14, 14);
	private static final Point BURN_LOCATION = new Point(27, 35);
	
	private TileEntityBloomery te;
	
	public GuiContainerBloomery(InventoryPlayer inventory, TEmultiblockCoreTankWorker entity) {
		super(inventory, entity, new ContainerBloomery(inventory, entity), "Bloomery", "textures/gui/Bloomery.png");
		te = (TileEntityBloomery) entity;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		super.drawGuiContainerForegroundLayer(param1, param2);
		fontRenderer.drawString("Durability: " + te.getScaledLiveTime(100) + "%", xSize - 100, ySize - 96 + 2 , 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);
		drawProgressBarWorker(PROGRESSBAR_SOURCE, PROGRESSBAR_LOCATION, true, 0);
		
	    int x = (width - xSize) / 2;
	    int y = (height - ySize) / 2;
		
		int burnScale = te.getScaledBurnTime(BURN_SOURCE.getHeight());
		this.drawTexturedModalRect(BURN_LOCATION.getX()+x, BURN_LOCATION.getY() + y + BURN_SOURCE.getHeight() - burnScale, BURN_SOURCE.getX(), BURN_SOURCE.getY()+(14-burnScale), BURN_SOURCE.getWidth(), burnScale);
		
		int tempScale = te.getScaledHeat(THERMO_SOURCE.getHeight());
		this.drawTexturedModalRect(THERMO_LOCATION.getX()+x, THERMO_LOCATION.getY() + y + THERMO_SOURCE.getHeight()-tempScale, THERMO_SOURCE.getX(), THERMO_SOURCE.getY() + THERMO_SOURCE.getHeight() - tempScale, THERMO_SOURCE.getWidth(), tempScale);
		
	}

}
