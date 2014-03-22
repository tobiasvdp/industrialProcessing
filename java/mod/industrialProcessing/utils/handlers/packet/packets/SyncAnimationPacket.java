package mod.industrialProcessing.utils.handlers.packet.packets;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import mod.industrialProcessing.client.rendering.tileEntity.animation.AnimationHandler;
import mod.industrialProcessing.client.rendering.tileEntity.animation.IAnimationSyncable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class SyncAnimationPacket extends PacketIP {

	int x, y, z;
	int index;
	float progress;
	float speed;
	
	public SyncAnimationPacket(){
		
	}

	public SyncAnimationPacket(TileEntity te, int index, float progress, float speed) {
		x = te.xCoord;
		y = te.yCoord;
		z = te.zCoord;
		this.index = index;
		this.progress = progress;
		this.speed = speed;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
		buffer.writeInt(index);
		buffer.writeFloat(progress);
		buffer.writeFloat(speed);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		x = buffer.readInt();
		y = buffer.readInt();
		z = buffer.readInt();
		index = buffer.readInt();
		progress = buffer.readFloat();
		speed = buffer.readFloat();
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		World world = player.worldObj;
		TileEntity te = world.getTileEntity(x, y, z);
		if(te instanceof IAnimationSyncable){
			AnimationHandler handler = ((IAnimationSyncable)te).getAnimationHandler(index);
			handler.setProgress(progress);
			handler.setSpeed(speed);
		}
	}

	@Override
	public void handleServerSide(EntityPlayer player) {

	}

}
