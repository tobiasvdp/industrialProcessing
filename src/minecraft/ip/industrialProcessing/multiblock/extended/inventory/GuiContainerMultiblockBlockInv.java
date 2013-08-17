package ip.industrialProcessing.multiblock.extended.inventory;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.PacketHandler;
import ip.industrialProcessing.machines.ContainerMachine;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.multiblock.machine.crusher.ContainerMultiblockCrusher;
import ip.industrialProcessing.utils.working.IWorker;
import ip.industrialProcessing.utils.working.IWorkingEntity;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.multiplayer.NetClientHandler;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;

public class GuiContainerMultiblockBlockInv extends GuiContainer {

	public TileEntityMultiblockBlockInv tileEntity;
	protected String name;
	/*
	 * 0 = input 1 = output 2 = input tank 3 = output tank
	 */
	protected int type;
	protected ResourceLocation textureLocation = new ResourceLocation(IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/MultiblockIO.png");

	// private ArrayList<GuiButton> controlList = new ArrayList<GuiButton>();

	public GuiContainerMultiblockBlockInv(InventoryPlayer inventoryPlayer, TileEntityMultiblockBlockInv tileEntity, int type) {
		super(new ContainerMultiblockBlockInv(inventoryPlayer, tileEntity));
		this.tileEntity = tileEntity;
		switch(type){
		case 0: this.name = "Input interface";break;
		case 1: this.name = "Output interface";break;
		case 2: this.name = "Input interface Tank";break;
		case 3: this.name = "Output interface Tank";break;
		default: this.name = "Fruitbasket";
		}
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		fontRenderer.drawString(name, 8, 6, 4210752);
		fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);

		int number = tileEntity.getInventorySlot();
		fontRenderer.drawString(Integer.toString(number), 50, 39, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		mc.renderEngine.func_110577_a(this.textureLocation);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}

	@Override
	public void initGui() {
		super.initGui();
		buttonList.clear();
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		// make buttons
		// id, x, y, width, height, text
		buttonList.add(new GuiButton(1, 20 + x, 23 + y, 20, 20, "+"));
		buttonList.add(new GuiButton(2, 20 + x, 43 + y, 20, 20, "-"));

	}

	@Override
	protected void actionPerformed(GuiButton guibutton) {
		// id is the id you give your button
		int newID = -1;
		switch (guibutton.id) {
		case 1:
			newID = tileEntity.nextValidID();
			break;
		case 2:
			newID = tileEntity.prevValidID();
			break;
		}
		
		if (newID != -1) {
			tileEntity.inventoryID = newID;
			ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
			DataOutputStream outputStream = new DataOutputStream(bos);
			try {
				outputStream.writeInt(newID);
				outputStream.writeInt(tileEntity.xCoord);
				outputStream.writeInt(tileEntity.yCoord);
				outputStream.writeInt(tileEntity.zCoord);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			Packet250CustomPayload packet = new Packet250CustomPayload();
			packet.channel = PacketHandler.BUTTON_PRESSED;
			packet.data = bos.toByteArray();
			packet.length = bos.size();
			PacketDispatcher.sendPacketToServer(packet);
		}
	}
}
