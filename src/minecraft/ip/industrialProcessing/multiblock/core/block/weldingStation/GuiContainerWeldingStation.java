package ip.industrialProcessing.multiblock.core.block.weldingStation;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.StatCollector;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.PacketHandler;
import ip.industrialProcessing.machines.crusher.TileEntityCrusher;
import ip.industrialProcessing.multiblock.container.ContainerMultiblock;
import ip.industrialProcessing.multiblock.container.ContainerMultiblockTankWorkerPowered;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreInv;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreTankWorkerPowered;
import ip.industrialProcessing.multiblock.gui.CTmultiblock;
import ip.industrialProcessing.multiblock.gui.GUImultiblock;
import ip.industrialProcessing.utils.gui.IPButton;

public class GuiContainerWeldingStation extends GUImultiblock {

	private static final Rectangle PROGRESSBAR_SOURCE = new Rectangle(198, 0, 22, 16);
	private static final Point PROGRESSBAR_LOCATION = new Point(120, 31);

	private static final Rectangle THERMO_SOURCE = new Rectangle(204, 22, 5, 35);
	private static final Point THERMO_LOCATION = new Point(13, 15);

	private static final Rectangle BURN_SOURCE = new Rectangle(198, 86, 14, 14);
	private static final Point BURN_LOCATION = new Point(27, 35);

	private static final IPButton BUTTON_WELDING = new IPButton(176, 108, 21, 28);
	private static final IPButton BUTTON_SOLDERING = new IPButton(176, 137, 21, 28);

	private TEmultiblockWeldingStation te;
	private EntityPlayer player;

	public GuiContainerWeldingStation(EntityPlayer player, TEmultiblockCoreTankWorkerPowered entity) {
		super(player.inventory, entity, new ContainerWeldingStation(player, entity), "Welding Table", "textures/gui/WeldingTable.png");
		te = (TEmultiblockWeldingStation) entity;
		this.player = player;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		super.drawGuiContainerForegroundLayer(param1, param2);
		fontRenderer.drawString("Welding", xSize - 70, ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);
		drawProgressBarWorker(PROGRESSBAR_SOURCE, PROGRESSBAR_LOCATION, true, 0);

		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		int burnScale = te.getScaledBurnTime(BURN_SOURCE.getHeight());
		this.drawTexturedModalRect(BURN_LOCATION.getX() + x, BURN_LOCATION.getY() + y + BURN_SOURCE.getHeight() - burnScale, BURN_SOURCE.getX(), BURN_SOURCE.getY() + (14 - burnScale), BURN_SOURCE.getWidth(), burnScale);

		int tempScale = te.getScaledHeat(THERMO_SOURCE.getHeight());
		this.drawTexturedModalRect(THERMO_LOCATION.getX() + x, THERMO_LOCATION.getY() + y + THERMO_SOURCE.getHeight() - tempScale, THERMO_SOURCE.getX(), THERMO_SOURCE.getY() + THERMO_SOURCE.getHeight() - tempScale, THERMO_SOURCE.getWidth(), tempScale);

	}

	@Override
	protected void mouseClicked(int par1, int par2, int par3) {
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		if (BUTTON_SOLDERING.clickedInside(par1 - x, par2 - y))
			openGuiOnServer(3);
			//player.openGui(IndustrialProcessing.instance, 3, te.worldObj, te.xCoord, te.yCoord, te.zCoord);
		super.mouseClicked(par1, par2, par3);
	}

	public void openGuiOnServer(int index) {

		ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
		DataOutputStream outputStream = new DataOutputStream(bos);
		try {
			outputStream.writeInt(index);
			outputStream.writeInt(te.xCoord);
			outputStream.writeInt(te.yCoord);
			outputStream.writeInt(te.zCoord);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = PacketHandler.SCREEN_PRESSED;
		packet.data = bos.toByteArray();
		packet.length = bos.size();

		PacketDispatcher.sendPacketToServer(packet);
	}
}
