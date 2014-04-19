package mod.industrialProcessing.utils.handlers.packet.packets;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.io.DataInputStream;

import mod.industrialProcessing.client.rendering.tileEntity.animation.tanks.ITankSyncable;
import mod.industrialProcessing.client.rendering.tileEntity.animation.tanks.TankHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TankAnimationPacket extends PacketIP {
	int x, y, z;
	TankHandler handler;
	ByteBuf buffer;
	
	public TankAnimationPacket(){
		
	}

	public TankAnimationPacket(TileEntity te, TankHandler handler) {
		x = te.xCoord;
		y = te.yCoord;
		z = te.zCoord;
		this.handler = handler;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
		buffer.writeInt(handler.getTankCount());
		writeTankHandler(buffer,handler);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		x = buffer.readInt();
		y = buffer.readInt();
		z = buffer.readInt();
		this.buffer = buffer;
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		World world = player.worldObj;
		TileEntity te = world.getTileEntity(x, y, z);
		if(te instanceof ITankSyncable){
			TankHandler handler = ((ITankSyncable)te).getTankHandler();
			readTankHandler(buffer,handler);
		}
		
	}

	@Override
	public void handleServerSide(EntityPlayer player) {

	}
	
	protected static void writeTankHandler(ByteBuf buffer, TankHandler handler){

		int tanks = handler.getTankCount();
		for (int i = 0; i < tanks; i++) {
			int amount = handler.getAmount(i);
			int fluidId = handler.getFluidID(i);
			buffer.writeInt(amount);
			buffer.writeInt(fluidId);
		}
	}

	protected static void readTankHandler(ByteBuf buffer, TankHandler handler){
		int tanks = handler.getTankCount();
		for (int i = 0; i < tanks; i++) {
			int amount = buffer.readInt();
			int fluidId = buffer.readInt();
			handler.setAmount(i, amount);
			handler.setFluidId(i, fluidId);
		}
	}
}
