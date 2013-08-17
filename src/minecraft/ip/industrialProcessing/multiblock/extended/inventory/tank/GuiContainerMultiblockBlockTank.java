package ip.industrialProcessing.multiblock.extended.inventory.tank;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;
import ip.industrialProcessing.PacketHandler;
import ip.industrialProcessing.multiblock.extended.inventory.GuiContainerMultiblockBlockInv;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockBlockInv;

public class GuiContainerMultiblockBlockTank extends GuiContainerMultiblockBlockInv{
	TileEntityMultiblockBlockTank tileEntity;
	public GuiContainerMultiblockBlockTank(InventoryPlayer inventoryPlayer, TileEntityMultiblockBlockTank tileEntity, int type) {
		super(inventoryPlayer, tileEntity, type);
		this.tileEntity = tileEntity;
	}
	@Override
	protected void actionPerformed(GuiButton guibutton) {
		// id is the id you give your button
		int newID = -1;
		switch (guibutton.id) {
		case 1:
			newID = tileEntity.nextValidID();
			break;
		case 2:
			newID = tileEntity.prevValidID();
			break;
		}
		
		if (newID != -1) {
			tileEntity.inventoryID = newID;
			ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
			DataOutputStream outputStream = new DataOutputStream(bos);
			try {
				outputStream.writeInt(newID);
				outputStream.writeInt(tileEntity.xCoord);
				outputStream.writeInt(tileEntity.yCoord);
				outputStream.writeInt(tileEntity.zCoord);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			Packet250CustomPayload packet = new Packet250CustomPayload();
			packet.channel = PacketHandler.BUTTON_PRESSED;
			packet.data = bos.toByteArray();
			packet.length = bos.size();
			PacketDispatcher.sendPacketToServer(packet);
		}
	}
}
