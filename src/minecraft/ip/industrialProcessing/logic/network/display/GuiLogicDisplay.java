package ip.industrialProcessing.logic.network.display;

import ip.industrialProcessing.api.info.InfoMachine;
import ip.industrialProcessing.api.info.InfoSlot;
import ip.industrialProcessing.api.info.InfoTank;
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
import java.util.Iterator;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
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
    protected static RenderItem itemRenderer = new RenderItem();

    private int viewID = 0;
    private int activeNode;

    private int delaySyncData = 0;
    private int delayTicks = 5;

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
	if (delaySyncData == delayTicks) {
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
	
	this.drawColoredTexturedModalRect(x, y, 0, 80, this.X_SIZE, this.Y_SIZE, 255, 255, 255);
	drawGradientRect(x + 30, y + 35, x + 160, y + 115, color3.getRGB(), color4.getRGB());
	drawGradientRect(x + 35, y + 40, x + 155, y + 110, color5.getRGB(), color6.getRGB());
	this.drawColoredTexturedModalRect(x + 15, y + 15, 0, 0, 15, 15, 255, 255, 255);
	this.drawColoredTexturedModalRect(x + 15, y + Y_SIZE - 30, 0, 0, 15, 15, 255, 255, 255);
	this.drawColoredTexturedModalRect(x + X_SIZE - 30, y + 15, 0, 0, 15, 15, 255, 255, 255);
	this.drawColoredTexturedModalRect(x + X_SIZE - 30, y + Y_SIZE - 30, 0, 0, 15, 15, 255, 255, 255);

	switch (nodes.get(activeNode).getLogicType()) {
	case gate:
	    break;
	case interfaces:
	    InfoMachine machine = ((InfoMachine) buffer.get(activeNode).value);
	    fontRenderer.drawString(drawMachineName(activeNode), x + 40, y + 45, 4210752);
	    fontRenderer.drawString("Status: " + drawMachineInfo(activeNode), x + 40, y + 70, 4210752);
	    if (machine.interfaceTypes == null) {
		requestData(activeNode, UTVariableType.interfaceTypes);
	    } else {
		for (InterfaceType type : machine.interfaceTypes) {
		    switch (type) {
		    case inventory:
			requestData(activeNode, UTVariableType.slot);
			fontRenderer.drawString("Inventory", x + 40, y + 125, 4210752);
			for (int i = 0; i < machine.slots.size(); i++) {
			    InfoSlot slot = machine.slots.get(i);
			    if (slot.input) {
				drawGradientRect(x-1 + 40 + (i % 2) * 20, y-1 + 140 + (i / 2) * 20, x + 40 + (i % 2) * 20+19, y + 140 + (i / 2) * 20+19, color3.getRGB(), color4.getRGB());
				drawItemStack(new ItemStack(slot.id, slot.amount, slot.damage), x + 40 + (i % 2) * 20, y + 140 + (i / 2) * 20, null);
			    }
			    if (slot.output) {
				drawGradientRect(x-1 + 140 + (i % 2) * 20, y-1 + 140 + (i / 2) * 20, x + 140 + (i % 2) * 20+19, y + 140 + (i / 2) * 20+19, color3.getRGB(), color4.getRGB());
				drawItemStack(new ItemStack(slot.id, slot.amount, slot.damage), x + 140 + (i % 2) * 20, y + 140 + (i / 2) * 20, null);
			    }
			}
			break;
		    case power:
			requestData(activeNode, UTVariableType.power);
			drawGradientRect(x + 170, y + 35, x + 190, y + 115, color3.getRGB(), color4.getRGB());
			drawGradientRect(x + 172, y + 40, x + 188, y + 110, color5.getRGB(), color6.getRGB());
			int size = machine.power.storedPower * 70 / machine.power.powerCapacity;
			mc.renderEngine.func_110577_a(this.textureLocation);
			this.drawColoredTexturedModalRect(x + 172, y + 110 - size, 15, 70 - size, 15, size, 255, 255, 255);
			fontRenderer.drawString("Power: " + machine.power.storedPower + "/" + machine.power.powerCapacity, x + 40, y + 80, 4210752);
			break;
		    case tank:
			requestData(activeNode, UTVariableType.tank);
			for (int i = 0; i < machine.tanks.size(); i++) {
			    fontRenderer.drawString("tank " + i + ":(" + machine.tanks.get(i).fluidId + ") " + machine.tanks.get(i).amount + "/" + machine.tanks.get(i).capacity, x + 40, y + 125 + i * 15, 4210752);
			}
			break;
		    case worker:
			requestData(activeNode, UTVariableType.work);
			fontRenderer.drawString("Work: " + machine.worker.workDone + "/" + machine.worker.totalWork, x + 40, y + 90, 4210752);
			mc.renderEngine.func_110577_a(this.textureLocation);
			Tessellator.instance.setColorOpaque(255, 0, 0);
			drawColoredTexturedModalRect(width / 2 - 22, y + 140, 30, 0, 44, 25, 255, 255, 255);
			drawColoredTexturedModalRect(width / 2 - 22, y + 140, 30, 25, 44 * machine.worker.workDone / machine.worker.totalWork, 25, 255, 255, 255);
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

    private void drawColoredTexturedModalRect(int par1, int par2, int par3, int par4, int par5, int par6, int r, int g, int b) {

	float f = 0.00390625F;
	float f1 = 0.00390625F;
	Tessellator tessellator = Tessellator.instance;
	tessellator.startDrawingQuads();
	tessellator.setColorOpaque(r, g, b);
	tessellator.addVertexWithUV((double) (par1 + 0), (double) (par2 + par6), (double) this.zLevel, (double) ((float) (par3 + 0) * f), (double) ((float) (par4 + par6) * f1));
	tessellator.addVertexWithUV((double) (par1 + par5), (double) (par2 + par6), (double) this.zLevel, (double) ((float) (par3 + par5) * f), (double) ((float) (par4 + par6) * f1));
	tessellator.addVertexWithUV((double) (par1 + par5), (double) (par2 + 0), (double) this.zLevel, (double) ((float) (par3 + par5) * f), (double) ((float) (par4 + 0) * f1));
	tessellator.addVertexWithUV((double) (par1 + 0), (double) (par2 + 0), (double) this.zLevel, (double) ((float) (par3 + 0) * f), (double) ((float) (par4 + 0) * f1));
	tessellator.draw();
    }

    public void drawTank() {

    }

    private void drawOverview() {
	for (int[] frame : drawMachines) {
	    TileEntity te = (TileEntity) nodes.get(frame[6]);
	    drawGradientRect(frame[0], frame[1], frame[2], frame[3], frame[4], frame[5]);
	    fontRenderer.drawString(drawMachineName(frame[6]), frame[0] + 5, frame[1] + 5, 4210752);
	    fontRenderer.drawString(drawMachineCoordinates(frame[6]), frame[0] + 5, frame[1] + 15, 4210752);
	    fontRenderer.drawString(drawMachineInfo(frame[6]), frame[0] + 5, frame[1] + 30, 4210752);
	}
    }

    private String drawMachineCoordinates(int frame) {
	InfoMachine machine = ((InfoMachine) buffer.get(frame).value);
	if (machine.x == 0 && machine.y == 0 && machine.z == 0) {
	    requestData(frame, UTVariableType.coord);
	}
	return "X:" + machine.x + " Y:" + machine.y + " Z:" + machine.z;
    }

    private String drawMachineName(int frame) {
	InfoMachine machine = ((InfoMachine) buffer.get(frame).value);
	if (machine.name.equals("")) {
	    requestData(frame, UTVariableType.name);
	}
	return machine.name;
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

    public void setData(int node, UTVariableType type, int[] value) {
	int j;
	switch (nodes.get(node).getLogicType()) {
	case gate:
	    break;
	case interfaces:
	    switch (type) {
	    case status:
		((InfoMachine) buffer.get(node).value).status = StatusType.values()[value[0]];
		break;
	    case power:
		((InfoMachine) buffer.get(node).value).power.powerCapacity = value[0];
		((InfoMachine) buffer.get(node).value).power.storedPower = value[1];
		break;
	    case work:
		((InfoMachine) buffer.get(node).value).worker.totalWork = value[0];
		((InfoMachine) buffer.get(node).value).worker.workDone = value[1];
		break;
	    case tank:
		j = 0;
		for (int i = 0; i < value.length;) {
		    InfoTank tank = ((InfoMachine) buffer.get(node).value).getOrSetTank(j++);
		    tank.amount = value[i++];
		    tank.capacity = value[i++];
		    tank.fluidId = value[i++];
		}
		break;
	    case slot:
		j = 0;
		for (int i = 0; i < value.length;) {
		    InfoSlot slot = ((InfoMachine) buffer.get(node).value).getOrSetSlot(j++);
		    slot.amount = value[i++];
		    slot.damage = value[i++];
		    slot.id = value[i++];
		    if (value[i++] == 1)
			slot.input = true;
		    else
			slot.input = false;
		    if (value[i++] == 1)
			slot.output = true;
		    else
			slot.output = false;
		}
		break;
	    case name:
		String name = "";
		for (int i = 0; i < value.length; i++)
		    name = name + ((char) value[i]);
		((InfoMachine) buffer.get(node).value).name = name;
		break;
	    case coord:
		((InfoMachine) buffer.get(node).value).x = value[0];
		((InfoMachine) buffer.get(node).value).y = value[1];
		((InfoMachine) buffer.get(node).value).z = value[2];
		break;
	    case interfaceTypes:
		InfoMachine machine = ((InfoMachine) buffer.get(node).value);
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
    public boolean doesGuiPauseGame() {
	return false;
    }

    public void addNode(ICommunicationNode te) {
	nodes.add(te);
	switch (te.getLogicType()) {
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
    private Object draggedStack;

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

    private void drawItemStack(ItemStack par1ItemStack, int par2, int par3, String par4Str) {
	GL11.glPushMatrix();
	GL11.glEnable(GL11.GL_LIGHTING);
	RenderHelper.enableStandardItemLighting();
	GL11.glTranslatef(0.0F, 0.0F, 32.0F);
	this.zLevel = 200.0F;
	itemRenderer.zLevel = 200.0F;
	FontRenderer font = null;
	if (par1ItemStack != null)
	    font = par1ItemStack.getItem().getFontRenderer(par1ItemStack);
	if (font == null)
	    font = fontRenderer;
	itemRenderer.renderItemAndEffectIntoGUI(font, this.mc.func_110434_K(), par1ItemStack, par2, par3);
	itemRenderer.renderItemOverlayIntoGUI(font, this.mc.func_110434_K(), par1ItemStack, par2, par3 - (this.draggedStack == null ? 0 : 8), par4Str);
	this.zLevel = 0.0F;
	itemRenderer.zLevel = 0.0F;
	RenderHelper.disableStandardItemLighting();
	GL11.glDisable(GL11.GL_LIGHTING);
	GL11.glPopMatrix();
    }

}
