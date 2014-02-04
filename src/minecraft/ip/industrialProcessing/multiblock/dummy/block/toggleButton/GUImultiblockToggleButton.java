package ip.industrialProcessing.multiblock.dummy.block.toggleButton;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.network.PacketDispatcher;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.multiblock.core.block.elevator.TEmultiblockElevator;
import ip.industrialProcessing.utils.handler.packets.PacketHandler;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.ResourceLocation;

public class GUImultiblockToggleButton extends GuiScreen {
	public TEmultiblockToggleButton tileEntity;
	protected EntityPlayer player;
	protected String name;
	protected ResourceLocation textureLocation;
	protected int xSize = 176;
	protected int ySize = 166;

	public GUImultiblockToggleButton(TEmultiblockToggleButton tileEntity, EntityPlayer player) {
		this.tileEntity = tileEntity;
		this.name = "Control panel";
		this.textureLocation = new ResourceLocation(INamepace.TEXTURE_DOMAIN, "textures/gui/ToggleButton.png");
		this.player = player;
	}

	@Override
	public void drawBackground(int par1) {
		super.drawBackground(par1);		
	}
	
	@Override
	public void initGui() {
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.buttonList.clear();
		((TEmultiblockElevator) this.tileEntity.getCore()).findLevels();
		ArrayList<Integer> levels = ((TEmultiblockElevator) this.tileEntity.getCore()).getLevels();
		for(int i = levels.size()-1;i>=0;i--){
			this.buttonList.add(new GuiButton(i, x + xSize/2 - 40, y + ySize - 30 - i*25, 80, 20, "Floor "+i));
		}
	}

	@Override
	public void drawScreen(int par1, int par2, float par3) {
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		mc.renderEngine.bindTexture(this.textureLocation);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		
		fontRenderer.drawString(name, x+8, y+6, 4210752);
		
		super.drawScreen(par1, par2, par3);
	}
	
	@Override
	public void actionPerformed(GuiButton button) {
		
		((TEmultiblockElevator) this.tileEntity.getCore()).gotoFloor(button.id);
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
		DataOutputStream outputStream = new DataOutputStream(bos);
		try {
				outputStream.writeInt(this.tileEntity.xCoord);
				outputStream.writeInt(this.tileEntity.yCoord);
				outputStream.writeInt(this.tileEntity.zCoord);
		        outputStream.writeInt(button.id);
		} catch (Exception ex) {
		        ex.printStackTrace();
		}

		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = PacketHandler.IP_ELEVATOR_BUTTON;
		packet.data = bos.toByteArray();
		packet.length = bos.size();
		
		PacketDispatcher.sendPacketToServer(packet);
		
		player.closeScreen();
	} 

}
