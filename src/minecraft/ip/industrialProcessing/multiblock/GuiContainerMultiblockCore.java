package ip.industrialProcessing.multiblock;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import ip.industrialProcessing.PacketHandler;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.multiblock.extended.inventory.ContainerMultiblockCoreInv;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockCoreInv;
import ip.industrialProcessing.utils.working.IWorker;
import ip.industrialProcessing.utils.working.IWorkingEntity;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.ForgeDirection;

public class GuiContainerMultiblockCore  extends GuiContainer{

    public TileEntityMultiblockCoreInv tileEntity;
    protected String name;
    protected ResourceLocation textureLocation;
    protected int progressBarX = 70;
    protected int progressBarY = 34;
    protected int progressBarWidth = 22;
    protected int progressBarHeight = 16;
    protected int progressBarOriginx = 176;
    protected int progressBarOriginy = 0;
    protected ForgeDirection progressBarSide = ForgeDirection.WEST;

    public GuiContainerMultiblockCore(InventoryPlayer inventoryPlayer, TileEntityMultiblockCoreInv tileEntity, ContainerMultiblockCoreInv container, String name, String textureLocation) {
	super(container);
	this.tileEntity = tileEntity;
	this.name = name;
	this.textureLocation = new ResourceLocation(INamepace.TEXTURE_DOMAIN, textureLocation);
	
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
	    		this.drawTexturedModalRect(x + progressBarX, y + progressBarY, progressBarOriginx, progressBarOriginy, scale, progressBarHeight);
	    	}else{
	    		int scale = worker.getScaledProgress(progressBarHeight);
	    		if (scale > 0)
	    		this.drawTexturedModalRect(x + progressBarX, y + progressBarY, progressBarOriginx, progressBarOriginy, progressBarWidth, scale);
	    	}
	}
    }

    protected void setProgressBarLocation(int x, int y, int w, int h) {
	progressBarX = x;
	progressBarY = y;
	progressBarWidth = w;
	progressBarHeight = h;
    }
    protected void setProgressBarOrigin(int x,int y){
    	progressBarOriginx = x;
    	progressBarOriginy = y;
    }
    protected void setProgresBarDropside(ForgeDirection o){
    	progressBarSide = o; 
    }

}
