package ip.industrialProcessing.subMod.mine.machines.mining;

import ip.industrialProcessing.subMod.mine.PacketHandler;
import ip.industrialProcessing.subMod.mine.machines.EntityWorker;
import ip.industrialProcessing.utils.BlockBreaker;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class EntityMiner extends EntityWorker {

	public EntityMiner(World par1World) {
		super(par1World);
	}

	public EntityMiner(World par1World, float x, float y, float z) {
		super(par1World, x, y, z);
	}

	public void sendDestroyPacketToServer(ArrayList<int[]> blocks) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
		DataOutputStream outputStream = new DataOutputStream(bos);
		try {
			Iterator<int[]> it = blocks.iterator();
			outputStream.writeInt(blocks.size());
			while (it.hasNext()) {
				int[] block = it.next();
				outputStream.writeInt(block[0]);
				outputStream.writeInt(block[1]);
				outputStream.writeInt(block[2]);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = PacketHandler.destroyBlock;
		packet.data = bos.toByteArray();
		packet.length = bos.size();

		PacketDispatcher.sendPacketToServer(packet);
	}

	private ArrayList<int[]> calculateBlocks(int leftC, int rightc, int upC, int offsetY) {
		ArrayList<int[]> blocks = new ArrayList<int[]>();
		int dir = MathHelper.floor_double((this.rotationYaw * 4F) / 360F + 0.5D) & 3;
		ForgeDirection forward = getForwardFromMetadata(dir).getOpposite();
		ForgeDirection left = forward.getRotation(ForgeDirection.UP);
		ForgeDirection right = forward.getRotation(ForgeDirection.DOWN);

		int x = (int) ((this.posX) - 0.5);
		int y = (int) (this.posY) + offsetY;
		int z = (int) ((this.posZ) - 0.5);

		if (forward == ForgeDirection.NORTH || ForgeDirection.SOUTH == forward) {
			x = (int) Math.round(((this.posX) - 0.5));
		}

		if (forward == ForgeDirection.EAST || ForgeDirection.WEST == forward) {
			z = (int) Math.round(((this.posZ) - 0.5));
		}

		for (int i = 0; i < upC; i++) {
			// front
			blocks.add(new int[] { x + forward.offsetX, y + forward.offsetY + i, z + forward.offsetZ });
			blocks.add(new int[] { x, y + i, z });

			// left
			for (int j = 1; j <= leftC; j++) {
				blocks.add(new int[] { x + j * left.offsetX, y + j * left.offsetY + i, z + j * left.offsetZ });
				blocks.add(new int[] { x + forward.offsetX + j * left.offsetX, y + forward.offsetY + j * left.offsetY + i, z + forward.offsetZ + j * left.offsetZ });
			}
			// right
			for (int j = 1; j <= rightc; j++) {
				blocks.add(new int[] { x + j * right.offsetX, y + j * right.offsetY + i, z + j * right.offsetZ });
				blocks.add(new int[] { x + forward.offsetX + j * right.offsetX, y + forward.offsetY + j * right.offsetY + i, z + forward.offsetZ + j * right.offsetZ });
			}
		}
		return blocks;
	}

	@Override
	public void otherUpdates() {
		super.otherUpdates();
		if (worldObj.isRemote) {
			if (riddenByEntity != null && riddenByEntity == mc.thePlayer) {
				if (canWork()) {
					if (isCollidedHorizontally) {
						ArrayList<int[]> blocks = calculateBlocks(mineLeft(), mineRight(), mineUp(), mineYOffset());
						sendDestroyPacketToServer(blocks);
						BlockBreaker.breakBlocks(worldObj, blocks);
					}
				}
			}

		} else {

		}
	}

	public abstract int mineLeft();

	public abstract int mineRight();

	public abstract int mineUp();

	public abstract int mineYOffset();

}
