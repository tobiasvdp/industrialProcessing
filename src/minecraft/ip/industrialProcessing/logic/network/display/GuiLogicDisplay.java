package ip.industrialProcessing.logic.network.display;

import ip.industrialProcessing.api.info.InfoMachine;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.logic.PacketHandler;
import ip.industrialProcessing.logic.api.network.interfaces.ILogicInterface;
import ip.industrialProcessing.logic.api.network.interfaces.InterfaceType;
import ip.industrialProcessing.logic.api.network.interfaces.StatusType;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.utils.UTBuffer;
import ip.industrialProcessing.logic.utils.UTBufferType;
import ip.industrialProcessing.logic.utils.UTVariable;
import ip.industrialProcessing.logic.utils.UTVariableType;
import ip.industrialProcessing.machines.IPowerStorage;
import ip.industrialProcessing.utils.working.IWorker;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
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
	UTBuffer buffer;
	private ArrayList<int[]> drawMachines = new ArrayList<int[]>();

	private int viewID = 0;
	private int activeNode;

	private int delaySyncData = 0;

	// private FontRenderer fontLcd = new FontRenderer(mc.gameSettings,new
	// ResourceLocation(INamepace.TEXTURE_DOMAIN, "textures/font/lcd.png"),
	// mc.renderEngine, false);

	public GuiLogicDisplay(TileEntityLogicDisplay entity) {
		this.textureLocation = new ResourceLocation(INamepace.TEXTURE_DOMAIN, "textures/gui/LogicGui.png");
		this.entity = entity;
		nodes = new ArrayList<ICommunicationNode>();
		buffer = new UTBuffer(UTBufferType.collection);
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
		delaySyncData++;
		if (delaySyncData == 20) {
			delaySyncData = 0;
		}
		drawDefaultBackground();
		mc.renderEngine.func_110577_a(this.textureLocation);
		RenderHelper.disableStandardItemLighting();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glPushMatrix();
		GL11.glTranslatef(0, 0, 64f);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		int x = (width - X_SIZE) / 2;
		int y = (height - Y_SIZE - 23) / 2;
		// this.drawTexturedModalRect(x, y, 0, 0, X_SIZE, Y_SIZE);
		if (viewID == 0) {
			this.drawOverview();
			GuiButton guibutton = (GuiButton) this.buttonList.get(0);
			guibutton.drawButton(this.mc, mouseX, mouseY);
			guibutton = (GuiButton) this.buttonList.get(1);
			guibutton.drawButton(this.mc, mouseX, mouseY);
		}
		if (viewID == 1) {
			this.drawMachine(x, y);
		}
		GL11.glPopMatrix();
		RenderHelper.disableStandardItemLighting();

	}

	private void drawMachine(int x, int y) {
		Color color1 = new Color(227, 129, 63);
		Color color2 = new Color(210, 92, 13);
		Color color3 = new Color(180, 180, 180);
		Color color4 = new Color(220, 220, 220);
		Color color5 = new Color(0, 0, 0);
		Color color6 = new Color(20, 20, 20);
		drawGradientRect(x + 10, y + 10, x + X_SIZE - 10, y + Y_SIZE - 10, color1.getRGB(), color2.getRGB());
		drawGradientRect(x + 30, y + 50, x + X_SIZE - 30, y + Y_SIZE - 50, color3.getRGB(), color4.getRGB());
		drawGradientRect(x + 40, y + 60, x + X_SIZE - 40, y + Y_SIZE - 60, color5.getRGB(), color6.getRGB());
		this.drawTexturedModalRect(x + 15, y + 15, 0, 0, 15, 15);
		this.drawTexturedModalRect(x + 15, y + Y_SIZE - 30, 0, 0, 15, 15);
		this.drawTexturedModalRect(x + X_SIZE - 30, y + 15, 0, 0, 15, 15);
		this.drawTexturedModalRect(x + X_SIZE - 30, y + Y_SIZE - 30, 0, 0, 15, 15);

		switch (nodes.get(activeNode).getLogicType()) {
		case gate:
			break;
		case interfaces:
			ILogicInterface interfaces = (ILogicInterface) nodes.get(activeNode);
			fontRenderer.drawString(interfaces.getMachine().getName(), x + 45, y + 65, 4210752);
			fontRenderer.drawString("Status: " + interfaces.getMachine().getStatus().toString(), x + 45, y + 80, 4210752);
			for (InterfaceType type : interfaces.getMachine().getConnectionTypes()) {
				switch (type) {
				case inventory:
					break;
				case multi:
					break;
				case power:
					IPowerStorage storage = (IPowerStorage) ((UTVariable[]) interfaces.getData(UTVariableType.power))[0].value;
					fontRenderer.drawString("Power: " + storage.getStoredPower() + "/" + storage.getPowerCapacity(), x + 45, y + 95, 4210752);
					break;
				case single:
					break;
				case tank:
					break;
				case worker:
					IWorker worker = (IWorker) ((UTVariable[]) interfaces.getData(UTVariableType.work))[0].value;
					fontRenderer.drawString("Work progress: " + worker.getWorkDone() + "/" + worker.getTotalWork(), x + 45, y + 110, 4210752);
					break;
				default:
					break;
				}
			}
		case networkedNode:
			break;
		case node:
			break;
		case transport:
			break;
		default:
			break;
		}
	}

	private void drawOverview() {
		for (int[] frame : drawMachines) {
			TileEntity te = (TileEntity) nodes.get(frame[6]);
			drawGradientRect(frame[0], frame[1], frame[2], frame[3], frame[4], frame[5]);
			fontRenderer.drawString(nodes.get(frame[6]).getName(), frame[0] + 5, frame[1] + 5, 4210752);
			fontRenderer.drawString("X:" + te.xCoord + " Y:" + te.yCoord + " Z:" + te.zCoord, frame[0] + 5, frame[1] + 15, 4210752);
			fontRenderer.drawString(drawMachineInfo(frame[6]), frame[0] + 5, frame[1] + 30, 4210752);
		}
	}

	private String drawMachineInfo(int node) {
		switch (nodes.get(node).getLogicType()) {
		case gate:
			break;
		case interfaces:
			requestData(node, UTVariableType.status);
			return ((InfoMachine) buffer.get(node).value).status.toString();
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

	public void requestData(int nodeIndex, UTVariableType type) {
		if (delaySyncData == 0) {
			ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
			DataOutputStream outputStream = new DataOutputStream(bos);
			try {
				outputStream.writeInt(this.entity.xCoord);
				outputStream.writeInt(this.entity.yCoord);
				outputStream.writeInt(this.entity.zCoord);
				outputStream.writeInt(nodeIndex);
				outputStream.writeInt(type.ordinal());
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			Packet250CustomPayload packet = new Packet250CustomPayload();
			packet.channel = PacketHandler.DISPLAY_GET_DATA;
			packet.data = bos.toByteArray();
			packet.length = bos.size();

			PacketDispatcher.sendPacketToServer(packet);
		}
	}
	
	public void setData(int node,UTVariableType type, int[] value){
		switch(nodes.get(node).getLogicType()){
		case gate:
			break;
		case interfaces:
			switch(type){
			case status:
				((InfoMachine)buffer.get(node).value).status = StatusType.values()[value[0]];
				break;
			default:
				break;}
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
	} 

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	public void addNode(ICommunicationNode te) {
		nodes.add(te);
		switch(te.getLogicType()){
		case gate:
			break;
		case interfaces:
			buffer.add(0, UTVariableType.machine, new InfoMachine());
			break;
		case networkedNode:
			break;
		case node:
			break;
		case transport:
			break;
		default:
			buffer.add(0, UTVariableType.unknown, new UTBuffer(UTBufferType.Integer));
			break;
		
		}
	}

	public int offsetDisplayedNodes = 0;
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
		if (par1GuiButton.id == 0 && offsetDisplayedNodes >= 6) {
			offsetDisplayedNodes = offsetDisplayedNodes - 6;
			drawTabbedNodes();
		} else if (par1GuiButton.id == 1 && offsetDisplayedNodes <= nodes.size() - 6) {
			offsetDisplayedNodes = offsetDisplayedNodes + 6;
			drawTabbedNodes();
		}
		super.actionPerformed(par1GuiButton);
	}

	@Override
	protected void mouseClicked(int par1, int par2, int par3) {
		if (viewID == 0) {
			super.mouseClicked(par1, par2, par3);
			for (int[] frame : drawMachines) {
				if (par1 > frame[0] && par1 < frame[2]) {
					if (par2 > frame[1] && par2 < frame[3]) {
						activeNode = frame[6];
						viewID = 1;
					}
				}
			}
		}
	}
}
