package ip.industrialProcessing.machines.blastFurnace;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

import ip.industrialProcessing.machines.containers.gui.GuiContainerFluidMachine;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiContainerBlastFurnace extends GuiContainerFluidMachine {

	private static final Rectangle TANK_SOURCE = new Rectangle(176, 17, 16, 50);
	public GuiContainerBlastFurnace(InventoryPlayer inventoryPlayer, TileEntityBlastFurnace tileEntity) {
		super(inventoryPlayer, tileEntity, new ContainerBlastFurnace(inventoryPlayer, tileEntity), "Blast furnace", "textures/gui/BlastFurnace.png");
		// setProgressBarLocation(77, 35, 24, 17);
		// setProgresBarDropside(ForgeDirection.NORTH);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);
		
		drawProgressBarTank(TANK_SOURCE, new Point(116, 19),  0);
		drawProgressBarTank(TANK_SOURCE, new Point(134, 19),  1);
		drawProgressBarTank(TANK_SOURCE, new Point(152, 19),  2);
	}
}
