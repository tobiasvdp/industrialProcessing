package ip.industrialProcessing.power.plants;

import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.gui3.framework.Alignment;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.Thickness;
import ip.industrialProcessing.gui3.framework.UIRoot;
import ip.industrialProcessing.gui3.framework.controls.Button;
import ip.industrialProcessing.gui3.framework.controls.Decorator;
import ip.industrialProcessing.gui3.framework.controls.ProgressBar;
import ip.industrialProcessing.gui3.framework.controls.SlotControl;
import ip.industrialProcessing.gui3.framework.controls.TankControl;
import ip.industrialProcessing.gui3.framework.controls.TextBlock;
import ip.industrialProcessing.gui3.framework.custom.CraftingGrid;
import ip.industrialProcessing.gui3.framework.custom.LabeledProgressBar;
import ip.industrialProcessing.gui3.framework.custom.PowerControl;
import ip.industrialProcessing.gui3.framework.custom.TankWithSlotsControl;
import ip.industrialProcessing.gui3.framework.panels.MouseButton;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;
import ip.industrialProcessing.machines.containers.gui.GuiContainerMachine;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.opengl.GL11;

public class GuiContainerGenerator extends GuiContainerMachine {

    private TileEntityGenerator generator;
    private ContainerGenerator container;
    private UIRoot layout;

    public GuiContainerGenerator(InventoryPlayer inventory, TileEntityGenerator entity) {
	this(inventory, entity, new ContainerGenerator(inventory, entity));
    }

    private GuiContainerGenerator(InventoryPlayer inventory, TileEntityGenerator entity, ContainerGenerator container) {
	super(inventory, entity, container, "Buildcraft Generator", "textures/gui/Generator.png");
	this.container = container;
	this.generator = entity;

	TextureReference texture = new TextureReference(new Size(256, 256), INamepace.TEXTURE_DOMAIN, "textures/gui/Generator.png");
	TextureReference worker = new TextureReference(new Size(24, 32), INamepace.TEXTURE_DOMAIN, "textures/gui/Worker.png");

	StackPanel stack = new StackPanel();

	stack.orientation = Orientation.VERTICAL;

	Decorator machinePanel = new Decorator(texture, 7);
	StackPanel stuff = new StackPanel();
	stuff.addChild(TankWithSlotsControl.createTankWithSlots());
	stuff.addChild(TankControl.createTank());
	stuff.addChild(ProgressBar.createTemperature());
	stuff.addChild(ProgressBar.createVertical1());
	stuff.addChild(ProgressBar.createVertical2());
	stuff.addChild(ProgressBar.createVertical3());

	StackPanel hor = new StackPanel();
	hor.orientation = Orientation.VERTICAL;
	hor.addChild(ProgressBar.createHorizontal1());
	hor.addChild(ProgressBar.createHorizontal2());
	hor.addChild(ProgressBar.createHorizontal3());
	hor.addChild(ProgressBar.createWorker(worker));
	stuff.addChild(hor);

	machinePanel.setChild(stuff);
	stack.addChild(machinePanel);
	Decorator inventoryPanel = new Decorator(texture, 7);
	stack.addChild(inventoryPanel);
	TextBlock label = new TextBlock("Hello World", 0xFFFFFF);
	StackPanel iStac = new StackPanel();
	iStac.orientation = Orientation.VERTICAL;

	iStac.addChild(label);
	iStac.addChild(PowerControl.createPowerWithSlots());
	iStac.addChild(CraftingGrid.createBigHorizontal());
	iStac.addChild(CraftingGrid.createSmallVertical());
	iStac.addChild(LabeledProgressBar.createProgressBar("Progress:", 0xFF686868));
	inventoryPanel.setChild(iStac);
	Decorator hotbarPanel = new Decorator(texture, 4);
	stack.addChild(hotbarPanel);
	StackPanel child = new StackPanel();
	child.orientation = Orientation.HORIZONTAL;
	for (int i = 0; i < 6; i++) {
	    SlotControl childPanel = SlotControl.createSlot();
	    child.addChild(childPanel);
	}
	child.addChild(SlotControl.createBucketSlot());
	child.addChild(SlotControl.createFuelSlot());
	child.addChild(SlotControl.createPowerSlot());

	TextBlock tb = new TextBlock("Button", 0xFFFFFFFF);
	tb.margin = new Thickness(5, 5, 5, 5);
	child.addChild(new Button(tb));
	hotbarPanel.setChild(child);
	stack.verticalAlign = Alignment.MIN;
	stack.horizontalAlign = Alignment.STRETCH;
	this.layout = new UIRoot(stack);
    }

    @Override
    protected void mouseMovedOrUp(int par1, int par2, int par3) {
	super.mouseMovedOrUp(par1, par2, par3);
	if (par3 >= 0) {
	    MouseButton button = MouseButton.getButton(par3);
	    if (button != null) {
		this.layout.mouseUp(par1, par2, button);
	    }
	} else
	    this.layout.mouseMoved(par1, par2);
    }

    @Override
    protected void mouseClicked(int par1, int par2, int par3) {

	super.mouseClicked(par1, par2, par3);
	MouseButton button = MouseButton.getButton(par3);
	if (button != null) {
	    this.layout.mouseDown(par1, par2, button);
	}
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

	int xSize = width - 5;
	int ySize = height - 5;

	int x = (width - xSize) / 2;
	int y = (height - ySize) / 2;
	this.layout.render(xSize, ySize, x, y, par2, par3);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) {
	super.drawGuiContainerForegroundLayer(param1, param2);
	this.layout.renderForeground(param1, param2);
    }
}
