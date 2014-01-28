package ip.industrialProcessing.subMod.logic.old.network.display;

import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.gui.container.syncing.info.InfoMachine;
import ip.industrialProcessing.gui.container.syncing.info.InfoSlot;
import ip.industrialProcessing.gui.container.syncing.info.InfoTank;
import ip.industrialProcessing.subMod.logic.PacketHandler;
import ip.industrialProcessing.subMod.logic.api.network.interfaces.InterfaceType;
import ip.industrialProcessing.subMod.logic.api.network.interfaces.StatusType;
import ip.industrialProcessing.subMod.logic.old.transport.ICommunicationNode;
import ip.industrialProcessing.subMod.logic.old.utils.UTBuffer;
import ip.industrialProcessing.subMod.logic.old.utils.UTBufferType;
import ip.industrialProcessing.subMod.logic.old.utils.UTVariableType;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.common.network.PacketDispatcher;

public class GuiLogicDisplay extends GuiScreen {
	private static final int X_SIZE = 256;
	private static final int Y_SIZE = 178;
	private ResourceLocation textureLocation;
	private TileEntity entity;
	private ArrayList<ICommunicationNode> nodes;
	UTBuffer buffer;
	private ArrayList<int[]> drawMachines = new ArrayList<int[]>();
	protected static RenderItem itemRenderer = new RenderItem();

	private int viewID = 0;
	private int activeNode;

	private int delaySyncData = 0;
	private int delayTicks = 5;

	// private FontRenderer fontLcd = new FontRenderer(mc.gameSettings,new
	// ResourceLocation(INamepace.TEXTURE_DOMAIN, "textures/font/lcd.png"),
	// mc.renderEngine, false);

	public int offsetDisplayedNodes = 0;

	int offset = 5;

	int widthTab = 120;

	int heightTab = 50;

	private Object draggedStack;

	public GuiLogicDisplay(TileEntityLogicDisplay entity) {
		this.textureLocation = new ResourceLocation(INamepace.TEXTURE_DOMAIN, "textures/gui/LogicGui.png");
		this.entity = entity;
		this.nodes = new ArrayList<ICommunicationNode>();
		this.buffer = new UTBuffer(UTBufferType.collection);
		this.requestNodes();
	}

	@Override
	protected void actionPerformed(GuiButton par1GuiButton) {
		if (par1GuiButton.id == 0 && this.offsetDisplayedNodes >= 6) {
			this.offsetDisplayedNodes = this.offsetDisplayedNodes - 6;
			this.drawTabbedNodes();
		} else if (par1GuiButton.id == 1 && this.offsetDisplayedNodes <= this.nodes.size() - 6) {
			this.offsetDisplayedNodes = this.offsetDisplayedNodes + 6;
			this.drawTabbedNodes();
		}
		super.actionPerformed(par1GuiButton);
	}

	public void addNode(ICommunicationNode te) {
		this.nodes.add(te);
		switch (te.getLogicType()) {
		case gate:
			break;
		case interfaces:
			this.buffer.add(0, UTVariableType.machine, new InfoMachine());
			break;
		case networkedNode:
			break;
		case node:
			break;
		case transport:
			break;
		default:
			this.buffer.add(0, UTVariableType.unknown, new UTBuffer(UTBufferType.Integer));
			break;

		}
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	@Override
	public void drawBackground(int par1) {
		this.drawWorldBackground(par1);
	}

	private void drawColoredTexturedModalRect(int par1, int par2, int par3, int par4, int par5, int par6, int r, int g, int b) {

		float f = 0.00390625F;
		float f1 = 0.00390625F;
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.setColorOpaque(r, g, b);
		tessellator.addVertexWithUV(par1 + 0, par2 + par6, this.zLevel, (par3 + 0) * f, (par4 + par6) * f1);
		tessellator.addVertexWithUV(par1 + par5, par2 + par6, this.zLevel, (par3 + par5) * f, (par4 + par6) * f1);
		tessellator.addVertexWithUV(par1 + par5, par2 + 0, this.zLevel, (par3 + par5) * f, (par4 + 0) * f1);
		tessellator.addVertexWithUV(par1 + 0, par2 + 0, this.zLevel, (par3 + 0) * f, (par4 + 0) * f1);
		tessellator.draw();
	}

	@Override
	public void drawDefaultBackground() {
		this.drawBackground(0);
	}

	private void drawItemStack(ItemStack par1ItemStack, int par2, int par3, String par4Str) {
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_LIGHTING);
		RenderHelper.enableStandardItemLighting();
		GL11.glTranslatef(0.0F, 0.0F, 32.0F);
		this.zLevel = 200.0F;
		itemRenderer.zLevel = 200.0F;
		FontRenderer font = null;
		if (par1ItemStack != null) {
			font = par1ItemStack.getItem().getFontRenderer(par1ItemStack);
		}
		if (font == null) {
			font = this.fontRenderer;
		}
		itemRenderer.renderItemAndEffectIntoGUI(font, this.mc.func_110434_K(), par1ItemStack, par2, par3);
		itemRenderer.renderItemOverlayIntoGUI(font, this.mc.func_110434_K(), par1ItemStack, par2, par3 - (this.draggedStack == null ? 0 : 8), par4Str);
		this.zLevel = 0.0F;
		itemRenderer.zLevel = 0.0F;
		RenderHelper.disableStandardItemLighting();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
	}

	private void drawMachine(int x, int y) {
		new Color(227, 129, 63);
		new Color(210, 92, 13);

		this.drawColoredTexturedModalRect(x, y, 0, 78, GuiLogicDisplay.X_SIZE, 178, 255, 255, 255);
		/*
		 * this.drawColoredTexturedModalRect(x + 15, y + 15, 0, 0, 15, 15, 255,
		 * 255, 255); this.drawColoredTexturedModalRect(x + 15, y + Y_SIZE - 30,
		 * 0, 0, 15, 15, 255, 255, 255); this.drawColoredTexturedModalRect(x +
		 * X_SIZE - 30, y + 15, 0, 0, 15, 15, 255, 255, 255);
		 * this.drawColoredTexturedModalRect(x + X_SIZE - 30, y + Y_SIZE - 30,
		 * 0, 0, 15, 15, 255, 255, 255);
		 */

		switch (this.nodes.get(this.activeNode).getLogicType()) {
		case gate:
			break;
		case interfaces:
			InfoMachine machine = (InfoMachine) this.buffer.get(this.activeNode).value;
			this.drawPane(10, 10, 130, 60);
			this.fontRenderer.drawString(this.drawMachineName(this.activeNode), x + 20, y + 20, 4210752);
			this.fontRenderer.drawString("Status: ", x + 20, y + 35, 4210752);
			this.fontRenderer.drawString(this.drawMachineInfo(this.activeNode), x + 60, y + 35, 4210752);
			if (machine.interfaceTypes == null) {
				this.requestData(this.activeNode, UTVariableType.interfaceTypes);
			} else {
				for (InterfaceType type : machine.interfaceTypes) {
					switch (type) {
					case inventory:
						this.requestData(this.activeNode, UTVariableType.slot);
						this.mc.renderEngine.func_110577_a(this.textureLocation);
						for (int i = 0; i < machine.slots.size(); i++) {
							InfoSlot slot = machine.slots.get(i);
							if (slot.input) {
								int xpos = x + 40 + i % 2 * 20;
								int ypos = y + 140 + i / 2 * 20;
								this.drawColoredTexturedModalRect(xpos, ypos, 74, 0, 18, 18, 255, 255, 255);
								this.drawItemStack(new ItemStack(slot.id, slot.amount, slot.damage), x + 40 + i % 2 * 20, y + 140 + i / 2 * 20, null);
							}
							if (slot.output) {
								this.drawItemStack(new ItemStack(slot.id, slot.amount, slot.damage), x + 140 + i % 2 * 20, y + 140 + i / 2 * 20, null);
							}
						}
						break;
					case power:
						this.requestData(this.activeNode, UTVariableType.power);
						// drawGradientRect(x + 170, y + 35, x + 190, y + 115,
						// color3.getRGB(), color4.getRGB());
						// drawGradientRect(x + 172, y + 40, x + 188, y + 110,
						// color5.getRGB(), color6.getRGB());
						int size = machine.power.storedPower * 70 / machine.power.powerCapacity;
						this.mc.renderEngine.func_110577_a(this.textureLocation);
						this.drawColoredTexturedModalRect(x + 172, y + 110 - size, 15, 70 - size, 15, size, 255, 255, 255);
						this.fontRenderer.drawString("Power: ", x + 20, y + 45, 4210752);
						this.fontRenderer.drawString(machine.power.storedPower + "", x + 60, y + 45, 4210752);
						this.fontRenderer.drawString("/" + machine.power.powerCapacity, x + 90, y + 45, 4210752);
						break;
					case tank:
						this.requestData(this.activeNode, UTVariableType.tank);
						for (int i = 0; i < machine.tanks.size(); i++) {
							this.fontRenderer.drawString("tank " + i + ":(" + machine.tanks.get(i).fluidId + ") " + machine.tanks.get(i).amount + "/" + machine.tanks.get(i).capacity, x + 40, y + 125 + i * 15, 4210752);
						}
						break;
					case worker:
						this.requestData(this.activeNode, UTVariableType.work);
						this.fontRenderer.drawString("Work: ", x + 20, y + 55, 4210752);
						this.fontRenderer.drawString(machine.worker.workDone + "", x + 60, y + 55, 4210752);
						this.fontRenderer.drawString("/" + machine.worker.totalWork, x + 90, y + 55, 4210752);
						this.mc.renderEngine.func_110577_a(this.textureLocation);
						Tessellator.instance.setColorOpaque(255, 0, 0);
						this.drawColoredTexturedModalRect(this.width / 2 - 22, y + 140, 30, 0, 44, 25, 255, 255, 255);
						this.drawColoredTexturedModalRect(this.width / 2 - 22, y + 140, 30, 25, 44 * machine.worker.workDone / machine.worker.totalWork, 25, 255, 255, 255);
						break;
					default:
						break;
					}
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

	private String drawMachineCoordinates(int frame) {
		InfoMachine machine = (InfoMachine) this.buffer.get(frame).value;
		if (machine.x == 0 && machine.y == 0 && machine.z == 0) {
			this.requestData(frame, UTVariableType.coord);
		}
		return "X:" + machine.x + " Y:" + machine.y + " Z:" + machine.z;
	}

	private String drawMachineInfo(int node) {
		switch (this.nodes.get(node).getLogicType()) {
		case gate:
			break;
		case interfaces:
			this.requestData(node, UTVariableType.status);
			return ((InfoMachine) this.buffer.get(node).value).status.toString();
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

	private String drawMachineName(int frame) {
		InfoMachine machine = (InfoMachine) this.buffer.get(frame).value;
		if (machine.name.equals("")) {
			this.requestData(frame, UTVariableType.name);
		}
		return machine.name;
	}

	private void drawOverview() {
		for (int[] frame : this.drawMachines) {
			this.nodes.get(frame[6]);
			this.drawGradientRect(frame[0], frame[1], frame[2], frame[3], frame[4], frame[5]);
			this.fontRenderer.drawString(this.drawMachineName(frame[6]), frame[0] + 5, frame[1] + 5, 4210752);
			this.fontRenderer.drawString(this.drawMachineCoordinates(frame[6]), frame[0] + 5, frame[1] + 15, 4210752);
			this.fontRenderer.drawString(this.drawMachineInfo(frame[6]), frame[0] + 5, frame[1] + 30, 4210752);
		}
	}

	private void drawPane(int x, int y, int width, int height) {
		int xAbs = (this.width - X_SIZE) / 2;
		int yAbs = (this.height - Y_SIZE - 23) / 2;
		Color color3 = new Color(180, 180, 180);
		Color color4 = new Color(220, 220, 220);
		Color color5 = new Color(0, 0, 0);
		Color color6 = new Color(20, 20, 20);
		this.drawGradientRect(xAbs + x, yAbs + y, xAbs + x + width, yAbs + y + height, color3.getRGB(), color4.getRGB());
		this.drawGradientRect(xAbs + x + 5, yAbs + y + 5, xAbs + x + width - 5, yAbs + y + height - 5, color5.getRGB(), color6.getRGB());
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float par3) {
		this.delaySyncData++;
		if (this.delaySyncData == this.delayTicks) {
			this.delaySyncData = 0;
		}
		this.drawDefaultBackground();
		this.mc.renderEngine.func_110577_a(this.textureLocation);
		RenderHelper.disableStandardItemLighting();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glPushMatrix();
		GL11.glTranslatef(0, 0, 64f);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		int x = (this.width - X_SIZE) / 2;
		int y = (this.height - Y_SIZE - 23) / 2;
		// this.drawTexturedModalRect(x, y, 0, 0, X_SIZE, Y_SIZE);
		if (this.viewID == 0) {
			this.drawOverview();
			GuiButton guibutton = (GuiButton) this.buttonList.get(0);
			guibutton.drawButton(this.mc, mouseX, mouseY);
			guibutton = (GuiButton) this.buttonList.get(1);
			guibutton.drawButton(this.mc, mouseX, mouseY);
		}
		if (this.viewID == 1) {
			this.drawMachine(x, y);
		}
		GL11.glPopMatrix();
		RenderHelper.disableStandardItemLighting();

	}

	public void drawTabbedNodes() {
		this.drawMachines.clear();
		int xAbs = (this.width - X_SIZE) / 2;
		int yAbs = (this.height - Y_SIZE - 23) / 2;
		for (int i = 0; i < 6 && i + this.offsetDisplayedNodes < this.nodes.size(); i++) {
			int x = i % 2 * (this.widthTab + this.offset) + this.offset;
			int y = i / 2 * (this.heightTab + this.offset) + this.offset;
			Color color1 = new Color(227, 129, 63);
			Color color2 = new Color(210, 92, 13);
			this.drawMachines.add(new int[] { x + xAbs, y + yAbs, x + xAbs + this.widthTab, y + yAbs + this.heightTab, color1.getRGB(), color2.getRGB(), i + this.offsetDisplayedNodes });
		}
	}

	public void drawTank() {

	}

	@Override
	public void initGui() {
		super.initGui();
		this.buttonList.clear();
		int xAbs = (this.width - X_SIZE) / 2;
		int yAbs = (this.height - Y_SIZE - 23) / 2;
		this.buttonList.add(new GuiButton(0, xAbs + this.offset, yAbs + 170, this.widthTab, 20, "Prev"));
		this.buttonList.add(new GuiButton(1, xAbs + 2 * this.offset + this.widthTab, yAbs + 170, this.widthTab, 20, "Next"));
	}

	@Override
	protected void mouseClicked(int par1, int par2, int par3) {
		if (this.viewID == 0) {
			super.mouseClicked(par1, par2, par3);
			for (int[] frame : this.drawMachines) {
				if (par1 > frame[0] && par1 < frame[2]) {
					if (par2 > frame[1] && par2 < frame[3]) {
						this.activeNode = frame[6];
						this.viewID = 1;
					}
				}
			}
		}
	}

	public void requestData(int nodeIndex, UTVariableType type) {
		if (this.delaySyncData == 0) {
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

	public void setData(int node, UTVariableType type, int[] value) {
		int j;
		switch (this.nodes.get(node).getLogicType()) {
		case gate:
			break;
		case interfaces:
			switch (type) {
			case status:
				((InfoMachine) this.buffer.get(node).value).status = StatusType.values()[value[0]];
				break;
			case power:
				((InfoMachine) this.buffer.get(node).value).power.powerCapacity = value[0];
				((InfoMachine) this.buffer.get(node).value).power.storedPower = value[1];
				break;
			case work:
				((InfoMachine) this.buffer.get(node).value).worker.totalWork = value[0];
				((InfoMachine) this.buffer.get(node).value).worker.workDone = value[1];
				break;
			case tank:
				j = 0;
				for (int i = 0; i < value.length;) {
					InfoTank tank = ((InfoMachine) this.buffer.get(node).value).getOrSetTank(j++);
					tank.amount = value[i++];
					tank.capacity = value[i++];
					tank.fluidId = value[i++];
				}
				break;
			case slot:
				j = 0;
				for (int i = 0; i < value.length;) {
					InfoSlot slot = ((InfoMachine) this.buffer.get(node).value).getOrSetSlot(j++);
					slot.amount = value[i++];
					slot.damage = value[i++];
					slot.id = value[i++];
					if (value[i++] == 1) {
						slot.input = true;
					} else {
						slot.input = false;
					}
					if (value[i++] == 1) {
						slot.output = true;
					} else {
						slot.output = false;
					}
				}
				break;
			case name:
				String name = "";
				for (int element : value) {
					name = name + (char) element;
				}
				((InfoMachine) this.buffer.get(node).value).name = name;
				break;
			case coord:
				((InfoMachine) this.buffer.get(node).value).x = value[0];
				((InfoMachine) this.buffer.get(node).value).y = value[1];
				((InfoMachine) this.buffer.get(node).value).z = value[2];
				break;
			case interfaceTypes:
				InfoMachine machine = (InfoMachine) this.buffer.get(node).value;
				if (value.length != 0) {
					machine.interfaceTypes = new InterfaceType[value.length];
					for (int i = 0; i < value.length; i++) {
						machine.interfaceTypes[i] = InterfaceType.values()[value[i]];
					}
				}
				break;
			default:
				break;
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
	}

	@Override
	public void setWorldAndResolution(Minecraft par1Minecraft, int par2, int par3) {
		super.setWorldAndResolution(par1Minecraft, par2, par3);
		this.drawTabbedNodes();
		this.buttonList.clear();
		int xAbs = (this.width - X_SIZE) / 2;
		int yAbs = (this.height - Y_SIZE - 23) / 2;
		this.buttonList.add(new GuiButton(0, xAbs + this.offset, yAbs + 170, this.widthTab, 20, "Prev"));
		this.buttonList.add(new GuiButton(1, xAbs + 2 * this.offset + this.widthTab, yAbs + 170, this.widthTab, 20, "Next"));
	}

}
