package mod.industrialProcessing.utils.handlers.packet.packets;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import mod.industrialProcessing.utils.handlers.numbers.IStateConfig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

public class StateConfigPacket extends PacketIP {
	int x, y, z;
	int index;
	int newValue;

	public StateConfigPacket() {
	}

	public StateConfigPacket(TileEntity tileEntity, int index, int newValue) {
		this.x = tileEntity.xCoord;
		this.y = tileEntity.yCoord;
		this.z = tileEntity.zCoord;

		this.index = index;
		this.newValue = newValue;

	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
		buffer.writeInt(index);
		buffer.writeInt(newValue);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		x = buffer.readInt();
		y = buffer.readInt();
		z = buffer.readInt();
		index = buffer.readInt();
		newValue = buffer.readInt();
	}

	@Override
	public void handleClientSide(EntityPlayer player) {

	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		TileEntity tileEntity;
		tileEntity = player.worldObj.getTileEntity(x, y, z);
		if (tileEntity instanceof IStateConfig) {
			IStateConfig syncable = (IStateConfig) tileEntity;
			syncable.setStateValue(index, newValue);
		}
	}

}
