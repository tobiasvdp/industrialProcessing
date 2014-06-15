package mod.industrialProcessing.utils.handlers.packet.packets;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import mod.industrialProcessing.utils.handlers.packet.IProgressSync;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class SyncValuesPacket extends PacketIP {

	int x;
	int y;
	int z;
	int[] val;
	
	public SyncValuesPacket() {

	}
	
	public SyncValuesPacket(int x,int y,int z, int[] val) {

		this.x = x;
		this.y = y;
		this.z = z;
		this.val = val;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
		buffer.writeInt(val.length);
		for(int i =0;i<val.length;i++){
			buffer.writeInt(val[i]);
		}
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		int length = buffer.readInt();
		this.val = new int[length];
		for(int i =0;i<val.length;i++){
			val[i] = buffer.readInt();
		}
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		World world = ((Entity) player).worldObj;
		if (world != null && world.isRemote) {
			TileEntity te = world.getTileEntity(x, y, z);
			if(te != null && te instanceof IProgressSync){
				((IProgressSync)te).setValues(val);
			}
		}
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		
	}

}
