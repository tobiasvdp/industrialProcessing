package ip.industrialProcessing.subMod.logic.old.transport;

import ip.industrialProcessing.subMod.logic.old.utils.UTBuffer;
import ip.industrialProcessing.subMod.logic.old.utils.UTBufferType;
import ip.industrialProcessing.subMod.logic.old.utils.UTBusType;
import ip.industrialProcessing.subMod.logic.old.utils.UTLogicType;
import ip.industrialProcessing.subMod.logic.old.utils.UTVariable;
import ip.industrialProcessing.subMod.logic.old.utils.UTlogicNodeContainer;
import ip.industrialProcessing.subMod.logic.old.utils.UTpacket;
import ip.industrialProcessing.subMod.logic.old.utils.UTpacketType;
import ip.industrialProcessing.utils.rotation.ISidedRotation;
import ip.industrialProcessing.utils.rotation.SidedRotationTransformer;

import java.util.ArrayList;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class TElogicNode extends TileEntity implements ICommunicationNode, ISidedRotation {

	private ForgeDirection orientationSide;
	private ForgeDirection orientationRotation;

	protected UTlogicNodeContainer[] nodeCollection = new UTlogicNodeContainer[6];
	protected UTBuffer[] buffer = new UTBuffer[6];
	private ForgeDirection[] conectableInputSides;
	private ForgeDirection[] conectableOutputSides;

	protected ArrayList<UTpacket> packets = new ArrayList<UTpacket>();

	public TElogicNode() {
		this.conectableInputSides = this.setConnectableInputSides();
		this.conectableOutputSides = this.setConnectableOutputSides();
		for (int i = 0; i < 6; i++) {
			this.nodeCollection[i] = new UTlogicNodeContainer(this);
			this.buffer[i] = new UTBuffer(UTBufferType.Bit);
		}
	}

	@Override
	public void createDataPacket(ForgeDirection dir, UTVariable... data) {
		this.packets.add(new UTpacket(UTpacketType.data, SidedRotationTransformer.InternalToExternalDirection(this, dir), data));
		this.scheduleSend();
		for (UTVariable item : data) {
			this.buffer[SidedRotationTransformer.InternalToExternalDirection(this, dir).ordinal()].put(item);
		}
	}

	@Override
	public void createDataPacket(UTVariable... data) {
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			this.createDataPacket(dir, data);
		}
	}

	@Override
	public void createDestructionPacket() {
		for (ForgeDirection sendingSide : ForgeDirection.VALID_DIRECTIONS) {
			this.packets.add(new UTpacket(UTpacketType.destroy, sendingSide, new ArrayList<ICommunicationTransport>(), this, sendingSide));
		}
		this.Send();
	}

	@Override
	public void createDiscoveryPacket() {
		for (ForgeDirection sendingSide : ForgeDirection.VALID_DIRECTIONS) {
			this.packets.add(new UTpacket(UTpacketType.discovery, sendingSide, new ArrayList<ICommunicationTransport>(), this, sendingSide));
		}
		this.scheduleSend();
	}

	@Override
	public void createDiscoveryPacket(ForgeDirection dir) {
		this.packets.add(new UTpacket(UTpacketType.discovery, dir, new ArrayList<ICommunicationTransport>(), this, dir));
		this.scheduleSend();
	}

	@Override
	public void ExtendedReceive(UTpacket packet) {
	}

	@Override
	public void ExtendedSend(UTpacket packet) {
	}

	@Override
	public UTBuffer getBuffer(ForgeDirection dir) {
		return this.buffer[this.getExternalForgeDirection(dir).ordinal()];
	}

	@Override
	public UTBusType getBusType() {
		return UTBusType.bus;
	}

	@Override
	public UTBusType getBusType(ForgeDirection side) {
		TileEntity te = this.worldObj.getBlockTileEntity(this.xCoord + side.offsetX, this.yCoord + side.offsetY, this.zCoord + side.offsetZ);
		if (te instanceof ICommunication) {
			return ((ICommunication) te).getBusType();
		}
		return UTBusType.invalid;
	}

	public ForgeDirection[] getConnectableInputSides() {
		return this.conectableInputSides;
	}

	public ForgeDirection[] getConnectableOutputSides() {
		return this.conectableOutputSides;
	}

	@Override
	public UTlogicNodeContainer getConnectionsOnSide(ForgeDirection side) {
		return this.nodeCollection[side.ordinal()];
	}

	@Override
	public ForgeDirection getExternalForgeDirection(ForgeDirection side) {
		return SidedRotationTransformer.InternalToExternalDirection(this, side);
	}

	@Override
	public float getGLrotationAngle() {
		return SIDEDTRANSFORMER.getGLrotationAngle(this.getOrientationSide(), this.getOrientationRotation());
	}

	@Override
	public float getGLrotationX() {
		return SidedRotationTransformer.getGLrotationX(this.getOrientationSide(), this.getOrientationRotation());
	}

	@Override
	public float getGLrotationY() {
		return SidedRotationTransformer.getGLrotationY(this.getOrientationSide(), this.getOrientationRotation());
	}

	@Override
	public float getGLrotationZ() {
		return SidedRotationTransformer.getGLrotationZ(this.getOrientationSide(), this.getOrientationRotation());
	}

	@Override
	public float getGLsideAngle() {
		return SIDEDTRANSFORMER.getGLsideAngle(this.getOrientationSide());
	}

	@Override
	public float getGLsideX() {
		return SidedRotationTransformer.getGLsideX(this.getOrientationSide());
	}

	@Override
	public float getGLsideY() {
		return SidedRotationTransformer.getGLsideY(this.getOrientationSide());
	}

	@Override
	public float getGLsideZ() {
		return SidedRotationTransformer.getGLsideZ(this.getOrientationSide());
	}

	/*
	 * @Override public Packet getDescriptionPacket() { NBTTagCompound nbtTag =
	 * new NBTTagCompound(); this.writeToNBT(nbtTag); return new
	 * Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1,
	 * nbtTag); }
	 * 
	 * @Override public void onDataPacket(INetworkManager net,
	 * Packet132TileEntityData packet) { readFromNBT(packet.customParam1);
	 * this.worldObj.markBlockForRenderUpdate(xCoord, yCoord, zCoord); }
	 * 
	 * public void notifyBlockChange() { if (!this.worldObj.isRemote) {
	 * this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	 * 
	 * StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	 * StackTraceElement e = stacktrace[2];// maybe this number needs to be //
	 * corrected String methodName = e.getMethodName(); String className =
	 * e.getClassName(); }
	 * 
	 * }
	 */
	@Override
	public UTLogicType getLogicType() {
		return UTLogicType.node;
	}

	@Override
	public ForgeDirection getOrientationRotation() {
		return this.orientationRotation;
	}

	@Override
	public ForgeDirection getOrientationSide() {
		return this.orientationSide;
	}

	public void initiateBuffer(UTBuffer utBuffer, UTBusType busType) {
		if (busType == UTBusType.cable) {
			utBuffer = new UTBuffer(UTBufferType.Bit);
		}
		if (busType == UTBusType.bundle) {
			utBuffer = new UTBuffer(UTBufferType.Bit);
		}
	}

	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public boolean isValidInput(ForgeDirection dir) {
		for (ForgeDirection d : this.conectableInputSides) {
			if (this.getExternalForgeDirection(d) == dir) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isValidOutput(ForgeDirection dir) {
		for (ForgeDirection d : this.conectableOutputSides) {
			if (this.getExternalForgeDirection(d) == dir) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		super.readFromNBT(par1nbtTagCompound);
		this.orientationSide = ForgeDirection.getOrientation(par1nbtTagCompound.getInteger("orientationSide"));
		this.orientationRotation = ForgeDirection.getOrientation(par1nbtTagCompound.getInteger("orientationRotation"));

		int i = 0;
		for (UTlogicNodeContainer container : this.nodeCollection) {
			NBTTagList list = par1nbtTagCompound.getTagList("nodes" + i);
			if (list.tagCount() != 0) {
				container.readFromNBT(list);
			}
			i++;
		}
	}

	@Override
	public void Receive(UTpacket packet) {
		if (packet.getType() == UTpacketType.discovery) {
			this.registerNode((ForgeDirection) packet.getData(0), (ICommunicationNode) packet.getData(2), (ForgeDirection) packet.getData(3));
			((ICommunicationNode) packet.getData(2)).registerNode((ForgeDirection) packet.getData(3), this, (ForgeDirection) packet.getData(0));
		}
		if (packet.getType() == UTpacketType.recheck) {
			this.nodeCollection[((ForgeDirection) packet.getData(0)).ordinal()].clear();
			this.createDiscoveryPacket();
		}
		if (packet.getType() == UTpacketType.destroy) {
			this.removeNode((ICommunicationNode) packet.getData(2));
		}
		if (packet.getType() == UTpacketType.data) {
			if (this.isValidInput((ForgeDirection) packet.getData(0))) {
				ForgeDirection receivingSide = (ForgeDirection) packet.getData(0);
				UTVariable[] array = (UTVariable[]) packet.getData(1);
				for (UTVariable item : array) {
					this.buffer[receivingSide.ordinal()].put(item);
				}
				this.transition();
			}
		}
		this.ExtendedReceive(packet);
	}

	@Override
	public void registerNode(ForgeDirection side, ICommunicationNode node, ForgeDirection originSide) {
		if (!this.nodeCollection[side.ordinal()].contains(node)) {
			this.nodeCollection[side.ordinal()].add(node);
			this.nodeCollection[side.ordinal()].addSide(originSide);
			this.initiateBuffer(this.buffer[side.ordinal()], this.getBusType(side));
		}
	}

	@Override
	public void removeNode(ICommunicationNode node) {
		for (UTlogicNodeContainer sideContainer : this.nodeCollection) {
			sideContainer.remove(node);
		}
	}

	@Override
	public void removeNode(ICommunicationNode node, ForgeDirection dir) {
		this.nodeCollection[dir.ordinal()].remove(node);
	}

	@Override
	public void scheduleSend() {
		this.worldObj.scheduleBlockUpdateWithPriority(this.xCoord, this.yCoord, this.zCoord, this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord), 1, -1);
	}

	@Override
	public void Send() {
		for (UTpacket packet : this.packets) {
			if (packet.getType() == UTpacketType.data) {
				if (this.isValidOutput((ForgeDirection) packet.getData(0))) {
					ForgeDirection sendingSide = (ForgeDirection) packet.getData(0);
					for (int i = 0; i < this.nodeCollection[sendingSide.ordinal()].getSize(); i++) {
						ICommunicationNode com = this.nodeCollection[sendingSide.ordinal()].getNode(i);
						packet.setData(0, this.nodeCollection[sendingSide.ordinal()].getSide(i));
						com.Receive(packet);
					}
				}
			}
			if (packet.getType() == UTpacketType.destroy) {
				ForgeDirection sendingSide = (ForgeDirection) packet.getData(0);
				for (int i = 0; i < this.nodeCollection[sendingSide.ordinal()].getSize(); i++) {
					ICommunicationNode com = this.nodeCollection[sendingSide.ordinal()].getNode(i);
					packet.setData(0, this.nodeCollection[sendingSide.ordinal()].getSide(i));
					com.Receive(packet);
				}
			}
			if (packet.getType() == UTpacketType.discovery) {
				ForgeDirection sendingSide = (ForgeDirection) packet.getData(0);
				this.nodeCollection[sendingSide.ordinal()].clear();
				TileEntity te = this.worldObj.getBlockTileEntity(this.xCoord + sendingSide.offsetX, this.yCoord + sendingSide.offsetY, this.zCoord + sendingSide.offsetZ);
				if (te instanceof ICommunication) {
					ICommunication com = (ICommunication) te;
					// initiateBuffer(buffer[sendingSide.ordinal()],
					// getBusType(sendingSide));
					packet.setData(0, sendingSide.getOpposite());
					com.Receive(packet);

				}
			}
			this.ExtendedSend(packet);
		}
		this.packets.clear();
	}

	@Override
	public void setOrientationRotation(float rotationYaw, float rotationPitch) {
		this.orientationRotation = SidedRotationTransformer.transformSideAndLookToForgeDirection(this.orientationSide, rotationYaw, rotationPitch);
	}

	@Override
	public void setOrientationRotation(ForgeDirection dir) {
		this.orientationRotation = dir;
	}

	@Override
	public void setOrientationSide(ForgeDirection side) {
		this.orientationSide = side;
	}

	@Override
	public void setOrientationSide(int metadata) {
		this.orientationSide = SidedRotationTransformer.transformMetaToForgeDirection(metadata);
	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		super.writeToNBT(par1nbtTagCompound);
		par1nbtTagCompound.setInteger("orientationSide", this.orientationSide.ordinal());
		par1nbtTagCompound.setInteger("orientationRotation", this.orientationRotation.ordinal());

		int i = 0;
		for (UTlogicNodeContainer container : this.nodeCollection) {
			NBTTagList list = container.writeToNBT();
			if (list != null) {
				par1nbtTagCompound.setTag("nodes" + i, list);
			}
			i++;
		}
	}
}