package ip.industrialProcessing.logic.network.display;

import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.logic.PacketHandler;
import ip.industrialProcessing.logic.api.network.interfaces.ILogicInterface;
import ip.industrialProcessing.logic.api.network.interfaces.InterfaceType;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.utils.UTVariable;
import ip.industrialProcessing.logic.utils.UTVariableType;
import ip.industrialProcessing.machines.IPowerStorage;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.common.network.PacketDispatcher;

public class GuiLogicDisplay extends GuiScreen {
	private static final int X_SIZE = 256;
	private static final int Y_SIZE = 202;
	private ResourceLocation textureLocation;
	private TileEntity entity;
	private ArrayList<ICommunicationNode> nodes;
	private ArrayList<int[]> drawMachines = new ArrayList<int[]>();

	public GuiLogicDisplay(TileEntityLogicDisplay entity) {
		this.textureLocation = new ResourceLocation(INamepace.TEXTURE_DOMAIN, "textures/gui/Guide.png");
		this.entity = entity;
		nodes = new ArrayList<ICommunicationNode>();
		requestNodes();
	}

	@Override
	public void setWorldAndResolution(Minecraft par1Minecraft, int par2, int par3) {
		super.setWorldAndResolution(par1Minecraft, par2, par3);
		drawTabbedNodes();
		buttonList.clear();
		int xAbs = (width - X_SIZE) / 2;
		int yAbs = (height - Y_SIZE - 23) / 2;
		buttonList.add(new GuiButton(0, xAbs + offset, yAbs + 170, widthTab, 20, "Prev"));
		buttonList.add(new GuiButton(1, xAbs + 2 * offset + widthTab, yAbs + 170, widthTab, 20, "Next"));
	}

	@Override
	public void drawDefaultBackground() {
		drawBackground(0);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float par3) {
		drawDefaultBackground();
		mc.renderEngine.func_110577_a(this.textureLocation);
		RenderHelper.disableStandardItemLighting();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glPushMatrix();
		GL11.glTranslatef(0, 0, 64f);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		int x = (width - X_SIZE) / 2;
		int y = (height - Y_SIZE - 23) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, X_SIZE, Y_SIZE);
		this.drawMachine();
		super.drawScreen(mouseX, mouseY, par3);
		GL11.glPopMatrix();
		RenderHelper.disableStandardItemLighting();

	}

	private void drawMachine() {
		for (int[] frame : drawMachines) {
			TileEntity te = (TileEntity) nodes.get(frame[6]);
			drawGradientRect(frame[0], frame[1], frame[2], frame[3], frame[4], frame[5]);
			fontRenderer.drawString(nodes.get(frame[6]).getName(), frame[0] + 5, frame[1] + 5, 4210752);
			fontRenderer.drawString("X:" + te.xCoord + " Y:" + te.yCoord + " Z:" + te.zCoord, frame[0] + 5, frame[1] + 15, 4210752);
			fontRenderer.drawString(drawMachineInfo(nodes.get(frame[6])), frame[0] + 5, frame[1] + 30, 4210752);
						
		}
	}

	private String drawMachineInfo(ICommunicationNode node) {
		switch (node.getLogicType()){
		case gate:
			break;
		case interfaces:
			ILogicInterface interfaces = (ILogicInterface) node;
			if(interfaces.isMachineCapable(InterfaceType.power)){
				String power = "";
				for(UTVariable var:interfaces.getData(UTVariableType.power)){
					IPowerStorage storage = (IPowerStorage) var.value;
					power = power + storage.getStoredPower()+"/"+storage.getPowerCapacity()+" "; 
				}
				return power;
			}
			
			break;
		case networkedNode:
			break;
		case node:
			break;
		case transport:
			break;
		default:
			break;
		}
		return "";
	}

	@Override
	public void drawBackground(int par1) {
		drawWorldBackground(par1);
	}

	public void requestNodes() {
		ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
		DataOutputStream outputStream = new DataOutputStream(bos);
		try {
			outputStream.writeInt(this.entity.xCoord);
			outputStream.writeInt(this.entity.yCoord);
			outputStream.writeInt(this.entity.zCoord);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = PacketHandler.DISPLAY_GET_NODES;
		packet.data = bos.toByteArray();
		packet.length = bos.size();

		PacketDispatcher.sendPacketToServer(packet);
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	public void addNode(ICommunicationNode te) {
		nodes.add(te);
	}

	int offsetDisplayedNodes = 0;
	int offset = 5;
	int widthTab = 120;
	int heightTab = 50;

	public void drawTabbedNodes() {
		drawMachines.clear();
		int xAbs = (width - X_SIZE) / 2;
		int yAbs = (height - Y_SIZE - 23) / 2;
		for (int i = 0; i < 6 && i + offsetDisplayedNodes < nodes.size(); i++) {
			int x = i % 2 * (widthTab + offset) + offset;
			int y = i / 2 * (heightTab + offset) + offset;
			Color color1 = new Color(227, 129, 63);
			Color color2 = new Color(210, 92, 13);
			drawMachines.add(new int[] { x + xAbs, y + yAbs, x + xAbs + widthTab, y + yAbs + heightTab, color1.getRGB(), color2.getRGB(), i + offsetDisplayedNodes });
		}
	}

	@Override
	public void initGui() {
		super.initGui();
		buttonList.clear();
		int xAbs = (width - X_SIZE) / 2;
		int yAbs = (height - Y_SIZE - 23) / 2;
		buttonList.add(new GuiButton(0, xAbs + offset, yAbs + 170, widthTab, 20, "Prev"));
		buttonList.add(new GuiButton(1, xAbs + 2 * offset + widthTab, yAbs + 170, widthTab, 20, "Next"));
	}

	@Override
	protected void actionPerformed(GuiButton par1GuiButton) {
		if (par1GuiButton.id == 0 && offsetDisplayedNodes >=6) {
			offsetDisplayedNodes = offsetDisplayedNodes - 6;
			drawTabbedNodes();
		}
		else if (par1GuiButton.id == 1 && offsetDisplayedNodes <= nodes.size()-6) {
			offsetDisplayedNodes = offsetDisplayedNodes + 6;
			drawTabbedNodes();
		}
		super.actionPerformed(par1GuiButton);
	}
}
