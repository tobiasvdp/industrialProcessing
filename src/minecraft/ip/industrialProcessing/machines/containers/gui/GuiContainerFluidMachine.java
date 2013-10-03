package ip.industrialProcessing.machines.containers.gui;

import org.lwjgl.util.Point;
import org.lwjgl.util.ReadablePoint;
import org.lwjgl.util.Rectangle;
import org.lwjgl.util.WritablePoint;

import cpw.mods.fml.common.registry.LanguageRegistry;
import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.machines.TileEntityFluidMachine;
import ip.industrialProcessing.machines.containers.ContainerFluidMachine;
import ip.industrialProcessing.machines.containers.ProgressInfoTank;
import ip.industrialProcessing.machines.containers.ProgressInfoWorker;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;

public class GuiContainerFluidMachine extends GuiContainerMachine {

    private TileEntityFluidMachine tileEntityFluidMachine;
    private ContainerFluidMachine fluidContainer;

    public GuiContainerFluidMachine(InventoryPlayer inventoryPlayer, TileEntityFluidMachine tileEntity, ContainerFluidMachine container, String name, String textureLocation) {
	super(inventoryPlayer, tileEntity, container, name, textureLocation);
	this.tileEntityFluidMachine = tileEntity;
	this.fluidContainer = container;

    }

    protected void drawProgressBarTank(Rectangle source, Point location, int containerTankSlot) {
	ProgressInfoTank tank = this.fluidContainer.getProgressInfoTank(containerTankSlot);
	if (tank.amount > 0) {

	    Fluid fluid = FluidRegistry.getFluid(tank.fluidId);
	    if (fluid != null) {

		Icon icon = fluid.getIcon();
		int x0 = (this.width - this.xSize) / 2;
		int y0 = (this.height - this.ySize) / 2;

		mc.renderEngine.func_110577_a(TextureMap.field_110575_b);

		int size = tank.amount * source.getHeight() / tank.capacity;

		int targetX = location.getX() + x0;
		int targetY0 = location.getY() + y0;
		int targetY = targetY0 + source.getHeight() - size;
		// TODO: use tesselator to make this texture tile instead of
		// stretch.
		drawTexturedModelRectFromIcon(targetX, targetY, icon, source.getWidth(), size);
		mc.renderEngine.func_110577_a(this.textureLocation);
		drawTexturedModalRect(targetX, targetY0, source.getX(), source.getY(), source.getWidth(), source.getHeight());

		Rectangle target = new Rectangle(targetX, targetY0, source.getWidth(), source.getHeight());

		if (target.contains(this.mouseX, this.mouseY)) {

		    String name = fluid.getLocalizedName();
		    if (name.equals(fluid.getUnlocalizedName())) {
			int blockID = fluid.getBlockID();
			name = Block.blocksList[blockID].getLocalizedName();
		    }
		    this.toolTip = new ToolTip(name, "\u00a77" +tank.amount + "mB");
		}
	    }
	}
    }

    /*
     * public void drawTank(int slot, int x, int y) { drawTank(slot, x, y, 16,
     * 50); }
     * 
     * public void drawTank(int slot, int x, int y, int width, int height) {
     * drawTank(slot, x, y, width, height, 176, 17); }
     * 
     * protected void drawTank(int slot, int x, int y, int width, int height,
     * int sourceX, int sourceY) { int x0 = (this.width - this.xSize) / 2; int
     * y0 = (this.height - this.ySize) / 2; FluidTankInfo tank =
     * tileEntityFluidMachine.getFluidTankInfoForSlot(slot); if (tank != null) {
     * FluidStack fluidStack = tank.fluid; if (fluidStack != null) { Fluid fluid
     * = fluidStack.getFluid();
     * mc.renderEngine.func_110577_a(TextureMap.field_110575_b);
     * 
     * int size = fluidStack.amount * height / tank.capacity;
     * 
     * int targetX = x0 + x; int targetY = y0 + y + height - size;
     * 
     * Icon icon = fluid.getIcon();
     * 
     * drawTexturedModelRectFromIcon(targetX, targetY, icon, width, size);
     * mc.renderEngine.func_110577_a(this.textureLocation);
     * drawTexturedModalRect(targetX, y0 + y, sourceX, sourceY, width, height);
     * 
     * } } }
     */
}
