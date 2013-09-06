package ip.industrialProcessing.machines.containers;

import ip.industrialProcessing.machines.TileEntityFluidMachine;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;

public class GuiContainerFluidMachine extends GuiContainerMachine {

	private TileEntityFluidMachine tileEntityFluidMachine;

	public GuiContainerFluidMachine(InventoryPlayer inventoryPlayer,
			TileEntityFluidMachine tileEntity, ContainerFluidMachine container, String name,
			String textureLocation) {
		super(inventoryPlayer, tileEntity, container, name, textureLocation);
		this.tileEntityFluidMachine = tileEntity;
	}

	public void drawTank(int slot, int x, int y)
	{
		drawTank(slot, x, y, 16, 50);
	}
	
	public void drawTank(int slot, int x, int y, int width, int height)
	{
		drawTank(slot, x, y, width, height, 176,17);
	}
	
	public void drawTank(int slot, int x, int y, int width, int height, int sourceX, int sourceY)
	{
	    int x0 = (this.width - this.xSize) / 2;
	    int y0 = (this.height - this.ySize) / 2;
		FluidTankInfo tank = tileEntityFluidMachine.getFluidTankInfoForSlot(slot);
		if(tank != null)
		{
			FluidStack fluidStack = tank.fluid;
			if(fluidStack != null)
			{
				Fluid fluid = fluidStack.getFluid(); 
				mc.renderEngine.func_110577_a(TextureMap.field_110575_b);				
				
				int size = fluidStack.amount * height / tank.capacity;
				
				int targetX = x0+x;
				int targetY = y0+y+height-size;

				Icon icon = fluid.getIcon(); 
				
				drawTexturedModelRectFromIcon(targetX, targetY, icon, width, size);
		        mc.renderEngine.func_110577_a(this.textureLocation);
				drawTexturedModalRect(targetX, y0+y, sourceX, sourceY, width, height);
		        
			}
		}
	}
}
