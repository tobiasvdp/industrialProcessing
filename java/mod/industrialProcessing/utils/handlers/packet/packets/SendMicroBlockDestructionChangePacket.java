package mod.industrialProcessing.utils.handlers.packet.packets;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import mod.industrialProcessing.microBlock.core.BlockMicroBlock;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class SendMicroBlockDestructionChangePacket extends PacketIP {

	boolean isDestroying;
	int blockID;

	public SendMicroBlockDestructionChangePacket() {
	}

	public SendMicroBlockDestructionChangePacket(Block block, boolean isDestroying) {
		this.isDestroying = isDestroying;
		this.blockID = Block.getIdFromBlock(block);
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf dataoutput) {
		dataoutput.writeBoolean(isDestroying);
		dataoutput.writeInt(blockID);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf datainput) {
		isDestroying = datainput.readBoolean();
		blockID = datainput.readInt();
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		World world = ((Entity) player).worldObj;
		if (world != null && world.isRemote) {
			BlockMicroBlock.isDestroying = isDestroying;
		}
	}

	@Override
	public void handleServerSide(EntityPlayer player) {

	}

}
