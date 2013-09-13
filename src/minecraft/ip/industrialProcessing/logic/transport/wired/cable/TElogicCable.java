package ip.industrialProcessing.logic.transport.wired.cable;

import ip.industrialProcessing.PacketHandler;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.transport.ICommunicationTransport;
import ip.industrialProcessing.logic.utils.UTBusType;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;

import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TElogicCable extends TileEntity implements ICommunicationTransport {
	public boolean isEnabled = true;
	private boolean init = true;;
	private boolean[] placedSide = new boolean[6];
	private boolean multipleSides;

	public TElogicCable() {
		for (int i = 0; i < 6; i++) {
			placedSide[i] = false;
		}
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
		if (init) {
			placedSide[transformToForgeDirection(worldObj.getBlockMetadata(xCoord, yCoord, zCoord))] = true;
			System.out.println(transformToForgeDirection(worldObj.getBlockMetadata(xCoord, yCoord, zCoord)));
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
	public void sendDiscoveryPacket(ForgeDirection receivingSide, ForgeDirection sendingSide, ArrayList<ICommunicationTransport> path, ICommunicationNode node, ForgeDirection side) {
		TileEntity te = worldObj.getBlockTileEntity(xCoord + sendingSide.offsetX, yCoord + sendingSide.offsetY, zCoord + sendingSide.offsetZ);
		if (te instanceof ICommunicationNode) {
			ICommunicationNode com = (ICommunicationNode) te;
			com.ReceiveDiscoveryPacket(sendingSide.getOpposite(), path, node, side);
		}
		if (te instanceof ICommunicationTransport) {
			ICommunicationTransport com = (ICommunicationTransport) te;
			if (com.getBusType() == getBusType())
				com.ReceiveDiscoveryPacket(sendingSide.getOpposite(), path, node, side);
		}
	}

	@Override
	public void ReceiveDiscoveryPacket(ForgeDirection receivedSide, ArrayList<ICommunicationTransport> path, ICommunicationNode node, ForgeDirection side) {
		if (!ContainsThis(path) && this.isEnabled) {
			path.add(this);
			for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
				if (dir != receivedSide) {
					this.sendDiscoveryPacket(receivedSide, dir, path, node, side);
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
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			this.sendDiscoveryPacket(null, dir, new ArrayList<ICommunicationTransport>(), null, null);
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
		return 6;
	}

	@Override
	public boolean getPlacedSide(int i) {
		return placedSide[i];
	}

	@Override
	public void addToConnectedSides(int side) {
		placedSide[transformToForgeDirection(side)] = true;
		sendSidesToServer(placedSide);
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

}
