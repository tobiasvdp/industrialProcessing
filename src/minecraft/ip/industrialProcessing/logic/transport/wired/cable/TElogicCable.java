package ip.industrialProcessing.logic.transport.wired.cable;

import ip.industrialProcessing.PacketHandler;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.transport.ICommunicationTransport;
import ip.industrialProcessing.logic.utils.UTBusType;
import ip.industrialProcessing.logic.utils.UTsendDiscoveryPacket;
import ip.industrialProcessing.machines.TileEntitySynced;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;

import cpw.mods.fml.common.asm.transformers.MarkerTransformer;
import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TElogicCable extends TileEntitySynced implements ICommunicationTransport {
	public boolean isEnabled = true;
	private boolean init = true;;
	private boolean[] placedSide = new boolean[6];
	private boolean multipleSides;
	private ArrayList<UTsendDiscoveryPacket> sendDiscoveryBuffer = new ArrayList<UTsendDiscoveryPacket>();

	public TElogicCable() {
		for (int i = 0; i < 6; i++) {
			placedSide[i] = false;
		}
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
		if (init) {
			addToConnectedSides(worldObj.getBlockMetadata(xCoord, yCoord, zCoord), true);
			init = false;
		}
	}

	private int transformToForgeDirection(int blockMetadata) {
		switch (blockMetadata) {
		case 0:
			return 0;
		case 1:
			return 1;
		case 2:
			return 3;
		case 3:
			return 2;
		case 4:
			return 5;
		case 5:
			return 4;
		}
		return 0;
	}

	@Override
	public void sendDiscoveryPackets() {
		for (UTsendDiscoveryPacket packet : sendDiscoveryBuffer) {
			TileEntity te = worldObj.getBlockTileEntity(xCoord + packet.getSendingSide().offsetX, yCoord + packet.getSendingSide().offsetY, zCoord + packet.getSendingSide().offsetZ);
			if (te instanceof ICommunicationNode) {
				ICommunicationNode com = (ICommunicationNode) te;
				System.out.println("Connecting to node");
				com.ReceiveDiscoveryPacket(packet.getSendingSide().getOpposite(), packet.getPath(), packet.getNode(), packet.getSide());
			}
			if (te instanceof ICommunicationTransport) {
				ICommunicationTransport com = (ICommunicationTransport) te;
				if (com.getBusType() == getBusType())
					System.out.println("Connecting to wire");
					com.ReceiveDiscoveryPacket(packet.getSendingSide().getOpposite(), packet.getPath(), packet.getNode(), packet.getSide());
			}
		}
		sendDiscoveryBuffer.clear();
	}

	@Override
	public void ReceiveDiscoveryPacket(ForgeDirection receivedSide, ArrayList<ICommunicationTransport> path, ICommunicationNode node, ForgeDirection side) {
		if (!ContainsThis(path) && this.isEnabled) {
			path.add(this);
			for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
				if (dir != receivedSide) {
					this.ScheduleSendDiscoveryPacket(receivedSide, dir, path, node, side);
				}
			}
		}
	}

	@Override
	public boolean ContainsThis(ArrayList<ICommunicationTransport> path) {
		for (ICommunicationTransport trans : path) {
			if (trans == this)
				return true;
		}
		return false;
	}

	@Override
	public void requestRecheck() {
		System.out.println("recheck");
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			sendDiscoveryBuffer.add(new UTsendDiscoveryPacket(null, dir, new ArrayList<ICommunicationTransport>(), null, null));
			this.sendDiscoveryPackets();
		}
	}

	@Override
	public boolean isEnabled() {
		return isEnabled;
	}

	@Override
	public void isEnabled(boolean enabled) {
		isEnabled = enabled;
	}

	@Override
	public UTBusType getBusType() {
		return UTBusType.cable;
	}

	@Override
	public boolean isSideConnected(ForgeDirection side) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSideValid(ForgeDirection side) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasSideActivity(ForgeDirection side) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getPlacedSidesSize() {
		int count = 0;
		for (int i = 0; i < 6; i++) {
			if (placedSide[i])
				count++;
		}
		return count;
	}

	@Override
	public boolean getPlacedSide(int i) {
		return placedSide[i];
	}

	@Override
	public void addToConnectedSides(int side, boolean transform) {
		if (transform) {
			placedSide[transformToForgeDirection(side)] = true;
			sendSidesToServer(placedSide);
		} else {
			placedSide[side] = true;
		}
	}

	private void sendSidesToServer(boolean[] placedSide) {
		if (worldObj.isRemote) {
			ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
			DataOutputStream outputStream = new DataOutputStream(bos);
			try {
				outputStream.writeInt(xCoord);
				outputStream.writeInt(yCoord);
				outputStream.writeInt(zCoord);
				for (int i = 0; i < placedSide.length; i++) {
					outputStream.writeBoolean(placedSide[i]);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			Packet250CustomPayload packet = new Packet250CustomPayload();
			packet.channel = PacketHandler.IP_LOGIC_SYNCSIDE;
			packet.data = bos.toByteArray();
			packet.length = bos.size();

			PacketDispatcher.sendPacketToServer(packet);
		}
	}

	@Override
	public boolean[] getPlacedSides() {
		return placedSide;
	}

	public void setMultipleSides(boolean b) {
		multipleSides = b;
	}

	public boolean getMultipleSides() {
		return multipleSides;
	}

	public boolean sidePresent(int par5) {
		int side = transformToForgeDirection(par5);
		return placedSide[side];
	}

	@Override
	public void removeConnectedSides(int side, boolean transform) {
		if (transform) {
			placedSide[transformToForgeDirection(side)] = false;
			sendSidesToServer(placedSide);
		} else {
			placedSide[side] = false;
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		for (int i = 0; i < 6; i++) {
			par1nbtTagCompound.setBoolean("Sides" + i, placedSide[i]);
		}
		super.writeToNBT(par1nbtTagCompound);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		for (int i = 0; i < 6; i++) {
			placedSide[i] = par1nbtTagCompound.getBoolean("Sides" + i);
		}
		super.readFromNBT(par1nbtTagCompound);
	}

	@Override
	public void ScheduleSendDiscoveryPacket(ForgeDirection receivingSide, ForgeDirection sendingSide, ArrayList<ICommunicationTransport> path, ICommunicationNode node, ForgeDirection side) {
		sendDiscoveryBuffer.add(new UTsendDiscoveryPacket(receivingSide, sendingSide, path, node, side));
		this.worldObj.scheduleBlockUpdateWithPriority(xCoord, yCoord, zCoord, worldObj.getBlockId(xCoord, yCoord, zCoord), 1, -1);
	}

}
