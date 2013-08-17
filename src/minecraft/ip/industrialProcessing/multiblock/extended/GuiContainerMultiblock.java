package ip.industrialProcessing.multiblock.extended;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.PacketHandler;
import ip.industrialProcessing.machines.ContainerMachine;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.multiblock.extended.inventory.ContainerMultiblockInv;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockCoreInv;
import ip.industrialProcessing.utils.working.IWorker;
import ip.industrialProcessing.utils.working.IWorkingEntity;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.mco.McoServer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.ForgeDirection;

public class GuiContainerMultiblock  extends GuiContainer{

    public TileEntityMultiblockCoreInv tileEntity;
    protected String name;
    protected ResourceLocation textureLocation;
    protected int progressBarX = 70;
    protected int progressBarY = 34;
    protected int progressBarWidth = 22;
    protected int progressBarHeight = 16;
    protected ForgeDirection progressBarSide = ForgeDirection.WEST;

    public GuiContainerMultiblock(InventoryPlayer inventoryPlayer, TileEntityMultiblockCoreInv tileEntity, ContainerMultiblockInv container, String name, String textureLocation) {
	super(container);
	this.tileEntity = tileEntity;
	this.name = name;
	this.textureLocation = new ResourceLocation(IndustrialProcessing.TEXTURE_DOMAIN, textureLocation);
    }

    private void requestServerUpdate() {
    	ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
		DataOutputStream outputStream = new DataOutputStream(bos);
		try {
			outputStream.writeInt(tileEntity.xCoord);
			outputStream.writeInt(tileEntity.yCoord);
			outputStream.writeInt(tileEntity.zCoord);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = PacketHandler.SYNC_CLIENT;
		packet.data = bos.toByteArray();
		packet.length = bos.size();
		PacketDispatcher.sendPacketToServer(packet);
	}

	@Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) {
	fontRenderer.drawString(name, 8, 6, 4210752);
	fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
	mc.renderEngine.func_110577_a(this.textureLocation);
	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	int x = (width - xSize) / 2;
	int y = (height - ySize) / 2;
	this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

	// progress indicator
	if (tileEntity instanceof IWorkingEntity) {
	    IWorkingEntity workingEntity = (IWorkingEntity) tileEntity;
	    IWorker worker = workingEntity.getWorker();
	    	if (progressBarSide == ForgeDirection.WEST){
	    		int scale = worker.getScaledProgress(progressBarWidth);
	    		if (scale > 0)
	    		this.drawTexturedModalRect(x + progressBarX, y + progressBarY, 176, 0, scale, progressBarHeight);
	    	}else{
	    		int scale = worker.getScaledProgress(progressBarHeight);
	    		if (scale > 0)
	    		this.drawTexturedModalRect(x + progressBarX, y + progressBarY, 176, 0, progressBarWidth, scale);
	    	}
	}
    }

    protected void setProgressBarLocation(int x, int y, int w, int h) {
	progressBarX = x;
	progressBarY = y;
	progressBarWidth = w;
	progressBarHeight = h;
    }
    protected void setProgresBarDropside(ForgeDirection o){
    	progressBarSide = o; 
    }

}
