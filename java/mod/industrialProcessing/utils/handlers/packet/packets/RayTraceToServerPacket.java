package mod.industrialProcessing.utils.handlers.packet.packets;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.utils.handlers.numbers.IStateConfig;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class RayTraceToServerPacket extends PacketIP {

	int hitType;
	int entityID;
	MovingObjectPosition hit;

	public RayTraceToServerPacket() {
	}

	public RayTraceToServerPacket(MovingObjectPosition hit, int hitType) {
		this.hitType = hitType;
		this.hit = hit;
	}
	
	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf dataoutput) {
		dataoutput.writeInt(hitType);
		dataoutput.writeInt(hit.blockX);
		dataoutput.writeInt(hit.blockY);
		dataoutput.writeInt(hit.blockZ);
		dataoutput.writeInt(hit.sideHit);
		dataoutput.writeInt(hit.subHit);
		if (hit.entityHit != null)
			dataoutput.writeInt(hit.entityHit.getEntityId());
		else
			dataoutput.writeInt(-1);
		dataoutput.writeInt(hit.typeOfHit.ordinal());
		dataoutput.writeDouble(hit.hitVec.xCoord);
		dataoutput.writeDouble(hit.hitVec.yCoord);
		dataoutput.writeDouble(hit.hitVec.zCoord);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf datainput) {
		hitType = datainput.readInt();
		int blockX = datainput.readInt();
		int blockY = datainput.readInt();
		int blockZ = datainput.readInt();
		int sideHit = datainput.readInt();
		int subHit = datainput.readInt();
		entityID = datainput.readInt();
		MovingObjectType typeOfHit = MovingObjectType.values()[datainput.readInt()];
		Vec3 hitVec = Vec3.createVectorHelper(datainput.readDouble(), datainput.readDouble(), datainput.readDouble());
		hit = new MovingObjectPosition(blockX, blockY, blockZ, sideHit, hitVec);
		hit.subHit = subHit;
		hit.typeOfHit = typeOfHit;
	}

	@Override
	public void handleClientSide(EntityPlayer player) {

	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		World world = ((Entity) player).worldObj;
		if (world != null && !world.isRemote) {
			IndustrialProcessing.microBlock.handleSideBlock(world, (EntityPlayer) player, hit, hitType);
		}
	}

}
