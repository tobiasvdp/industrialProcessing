package ip.industrialProcessing.power.plants;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.gui3.framework.Alignment;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.Thickness;
import ip.industrialProcessing.gui3.framework.UIRoot;
import ip.industrialProcessing.gui3.framework.controls.Button;
import ip.industrialProcessing.gui3.framework.controls.Decorator;
import ip.industrialProcessing.gui3.framework.controls.GaugeControl;
import ip.industrialProcessing.gui3.framework.controls.ProgressBar;
import ip.industrialProcessing.gui3.framework.controls.SlotControl;
import ip.industrialProcessing.gui3.framework.controls.TankControl;
import ip.industrialProcessing.gui3.framework.controls.TextBlock;
import ip.industrialProcessing.gui3.framework.custom.CraftingGrid;
import ip.industrialProcessing.gui3.framework.custom.LabeledGauge;
import ip.industrialProcessing.gui3.framework.custom.LabeledProgressBar;
import ip.industrialProcessing.gui3.framework.custom.NumericSpinner;
import ip.industrialProcessing.gui3.framework.custom.PlayerInventory;
import ip.industrialProcessing.gui3.framework.custom.PowerControl;
import ip.industrialProcessing.gui3.framework.custom.StateButton;
import ip.industrialProcessing.gui3.framework.custom.TankWithSlotsControl;
import ip.industrialProcessing.gui3.framework.panels.MouseButton;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;
import ip.industrialProcessing.machines.containers.gui.GuiContainerMachine;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

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
	this.ySize = 300;
	TextureReference texture = new TextureReference(new Size(256, 256), INamepace.TEXTURE_DOMAIN, "textures/gui/Generator.png");

	Decorator panel = new Decorator(texture, 7);

	for (int i = 0; i < 27 + 9; i++) {
	    container.getSlot(i).xDisplayPosition = -18;
	    container.getSlot(i).yDisplayPosition = -18;
	}

	StackPanel generatorPanel = new StackPanel();
	generatorPanel.orientation = Orientation.HORIZONTAL;

	generatorPanel.addChild(LabeledGauge.createLabeledGauge("Voltage", "%2.2fV", 1f, 4210752));
	generatorPanel.addChild(LabeledGauge.createLabeledGauge("Current", "%2.2fA", 1f, 4210752));
	generatorPanel.addChild(LabeledGauge.createLabeledGauge("Power", "%2.2fW", 1f, 4210752));

	generatorPanel.margin = new Thickness(7, 0, 7, 0);
	StackPanel stack = new StackPanel();
	stack.orientation = Orientation.VERTICAL;
	stack.horizontalAlign = Alignment.MIN;
	stack.verticalAlign = Alignment.MIN;
	TextBlock title = new TextBlock(this.name, 4210752);
	stack.addChild(title);
	stack.addChild(generatorPanel);

	stack.addChild(PlayerInventory.createInventory(container, 0));
	panel.setChild(stack);
	panel.verticalAlign = Alignment.CENTER;
	this.layout = new UIRoot(panel);
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
