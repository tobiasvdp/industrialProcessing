package mod.industrialProcessing.utils.handlers.packet.packets;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.io.DataInputStream;
import java.io.IOException;

import mod.industrialProcessing.client.rendering.tileEntity.animation.conveyors.IConveyor;
import mod.industrialProcessing.client.rendering.tileEntity.animation.conveyors.IConveyorStack;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ConveyorPacket extends PacketIP {

	int x, y, z;
	IConveyor handler;
	ByteBuf buffer;

	public ConveyorPacket() {

	}

	public ConveyorPacket(TileEntity te, IConveyor handler) {
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
		try {
			writeSpeed(buffer, handler);
			writeConveyorHandler(buffer, handler);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		if (te instanceof IConveyor) {
			try {
				readSpeed(buffer, ((IConveyor) te));
				readConveyorHandler(buffer, ((IConveyor) te));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void handleServerSide(EntityPlayer player) {

	}

	protected static void writeConveyorHandler(ByteBuf outputStream, IConveyor handler) throws IOException {

		int stackCount = handler.getStackCount();
		outputStream.writeInt(stackCount);
		for (int i = 0; i < stackCount; i++) {
			IConveyorStack movingStack = handler.getStack(i);
			ItemStack stack = movingStack.getItemStack();

			int amount = stack.stackSize;
			int itemId = Item.getIdFromItem(stack.getItem());
			int damage = stack.getItemDamage();

			byte destination = (byte) movingStack.getDestination().ordinal();
			byte source = (byte) movingStack.getSource().ordinal();
			short progress = (short) (movingStack.getProgress() * Short.MAX_VALUE);

			outputStream.writeInt(amount);
			outputStream.writeInt(itemId);
			outputStream.writeInt(damage);
			outputStream.writeByte(destination);
			outputStream.writeByte(source);
			outputStream.writeShort(progress);
		}
	}

	protected static void writeSpeed(ByteBuf buffer2, IConveyor handler) throws IOException {
		float speed = handler.getSpeed();
		buffer2.writeFloat(speed);
	}

	protected static void readConveyorHandler(ByteBuf inputStream, IConveyor handler) throws IOException {
		int stackCount = inputStream.readInt();
		handler.clearStacks();
		for (int i = 0; i < stackCount; i++) {
			int amount = inputStream.readInt();
			int itemId = inputStream.readInt();
			int damage = inputStream.readInt();

			LocalDirection[] directions = LocalDirection.values();
			LocalDirection destination = directions[inputStream.readByte()];
			LocalDirection source = directions[inputStream.readByte()];
			float progress = inputStream.readShort() / (float) Short.MAX_VALUE;

			ItemStack stack = new ItemStack(Item.getItemById(itemId), amount, damage);

			handler.addStack(stack, destination, source, progress);
		}
	}

	protected static void readSpeed(ByteBuf buffer2, IConveyor handler) throws IOException {
		float speed = buffer2.readFloat();
		handler.setSpeed(speed);
	}

}
