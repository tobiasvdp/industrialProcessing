package ip.industrialProcessing.logic.transport;

import ip.industrialProcessing.logic.network.display.TileEntityLogicDisplay;
import ip.industrialProcessing.logic.utils.UTBuffer;
import ip.industrialProcessing.logic.utils.UTBufferType;
import ip.industrialProcessing.logic.utils.UTBusType;
import ip.industrialProcessing.logic.utils.UTVariable;
import ip.industrialProcessing.logic.utils.UTlogicNodeContainer;
import ip.industrialProcessing.logic.utils.UTpacket;
import ip.industrialProcessing.logic.utils.UTpacketType;
import ip.industrialProcessing.machines.TileEntitySynced;
import ip.industrialProcessing.utils.rotation.ISidedRotation;

import java.util.ArrayList;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public abstract class TElogicNode extends TileEntity implements ICommunicationNode, ISidedRotation {

	private ForgeDirection orientationSide;
	private ForgeDirection orientationRotation;

	protected UTlogicNodeContainer[] nodeCollection = new UTlogicNodeContainer[6];
	protected UTBuffer[] buffer = new UTBuffer[6];
	private ForgeDirection[] conectableInputSides;
	private ForgeDirection[] conectableOutputSides;

	protected ArrayList<UTpacket> packets = new ArrayList<UTpacket>();

	public TElogicNode() {
		conectableInputSides = setConnectableInputSides();
		conectableOutputSides = setConnectableOutputSides();
		for (int i = 0; i < 6; i++) {
			nodeCollection[i] = new UTlogicNodeContainer(this);
			buffer[i] = new UTBuffer(UTBufferType.Bit, 1);
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

	public ForgeDirection[] getConnectableInputSides() {
		return conectableInputSides;
	}

	public ForgeDirection[] getConnectableOutputSides() {
		return conectableOutputSides;
	}

	@Override
	public void setOrientationSide(ForgeDirection side) {
		orientationSide = side;
	}

	@Override
	public void setOrientationSide(int metadata) {
		orientationSide = SIDEDTRANSFORMER.transformMetaToForgeDirection(metadata);
	}

	@Override
	public ForgeDirection getOrientationSide() {
		return orientationSide;
	}

	@Override
	public ForgeDirection getOrientationRotation() {
		return orientationRotation;
	}

	@Override
	public float getGLrotationX() {
		return SIDEDTRANSFORMER.getGLrotationX(getOrientationSide(), getOrientationRotation());
	}

	@Override
	public float getGLrotationY() {
		return SIDEDTRANSFORMER.getGLrotationY(getOrientationSide(), getOrientationRotation());
	}

	@Override
	public float getGLrotationZ() {
		return SIDEDTRANSFORMER.getGLrotationZ(getOrientationSide(), getOrientationRotation());
	}

	@Override
	public void setOrientationRotation(float rotationYaw, float rotationPitch) {
		orientationRotation = SIDEDTRANSFORMER.transformSideAndLookToForgeDirection(orientationSide, rotationYaw, rotationPitch);
	}

	@Override
	public void setOrientationRotation(ForgeDirection dir) {
		orientationRotation = dir;
	}

	@Override
	public ForgeDirection getExternalForgeDirection(ForgeDirection side) {
		return SIDEDTRANSFORMER.InternalToExternalDirection(this, side);
	}

	@Override
	public float getGLsideX() {
		return SIDEDTRANSFORMER.getGLsideX(getOrientationSide());
	}

	@Override
	public float getGLsideY() {
		return SIDEDTRANSFORMER.getGLsideY(getOrientationSide());
	}

	@Override
	public float getGLsideZ() {
		return SIDEDTRANSFORMER.getGLsideZ(getOrientationSide());
	}

	@Override
	public float getGLsideAngle() {
		return SIDEDTRANSFORMER.getGLsideAngle(getOrientationSide());
	}

	@Override
	public float getGLrotationAngle() {
		return SIDEDTRANSFORMER.getGLrotationAngle(getOrientationSide(), getOrientationRotation());
	}

	@Override
	public void Receive(UTpacket packet) {
		if (packet.getType() == UTpacketType.discovery) {
			this.registerNode(((ForgeDirection) packet.getData(0)), (ICommunicationNode) packet.getData(2), ((ForgeDirection) packet.getData(3)));
			((ICommunicationNode) packet.getData(2)).registerNode(((ForgeDirection) packet.getData(3)), this, (ForgeDirection) (packet.getData(0)));
		}
		if (packet.getType() == UTpacketType.recheck) {
			nodeCollection[((ForgeDirection) packet.getData(0)).ordinal()].clear();
			createDiscoveryPacket();
		}
		if (packet.getType() == UTpacketType.destroy) {
			this.removeNode((ICommunicationNode) packet.getData(2));
		}
		if (packet.getType() == UTpacketType.data) {
			if (isValidInput((ForgeDirection) packet.getData(0))) {
				ForgeDirection receivingSide = (ForgeDirection) packet.getData(0);
				UTVariable[] array = (UTVariable[]) packet.getData(1);
				for (UTVariable item : array) {
					buffer[receivingSide.ordinal()].put(item);
				}
				transition();
			}
		}
		ExtendedReceive(packet);
	}

	@Override
	public void ExtendedReceive(UTpacket packet) {
	}

	@Override
	public void scheduleSend() {
		this.worldObj.scheduleBlockUpdateWithPriority(xCoord, yCoord, zCoord, worldObj.getBlockId(xCoord, yCoord, zCoord), 1, -1);
	}

	@Override
	public void Send() {
		for (UTpacket packet : packets) {
			if (packet.getType() == UTpacketType.data) {
				if (isValidOutput((ForgeDirection) packet.getData(0))) {
					ForgeDirection sendingSide = (ForgeDirection) packet.getData(0);
					for (int i = 0; i < nodeCollection[sendingSide.ordinal()].getSize(); i++) {
						ICommunicationNode com = nodeCollection[sendingSide.ordinal()].getNode(i);
						packet.setData(0, nodeCollection[sendingSide.ordinal()].getSide(i));
						com.Receive(packet);
					}
				}
			}
			if (packet.getType() == UTpacketType.destroy) {
				ForgeDirection sendingSide = (ForgeDirection) packet.getData(0);
				for (int i = 0; i < nodeCollection[sendingSide.ordinal()].getSize(); i++) {
					ICommunicationNode com = nodeCollection[sendingSide.ordinal()].getNode(i);
					packet.setData(0, nodeCollection[sendingSide.ordinal()].getSide(i));
					com.Receive(packet);
				}
			}
			if (packet.getType() == UTpacketType.discovery) {
				ForgeDirection sendingSide = (ForgeDirection) packet.getData(0);
				nodeCollection[sendingSide.ordinal()].clear();
				TileEntity te = worldObj.getBlockTileEntity(xCoord + sendingSide.offsetX, yCoord + sendingSide.offsetY, zCoord + sendingSide.offsetZ);
				if (te instanceof ICommunication) {
					ICommunication com = (ICommunication) te;
					initiateBuffer(buffer[sendingSide.ordinal()], getBusType(sendingSide));
					packet.setData(0, sendingSide.getOpposite());
					com.Receive(packet);

				}
			}
			ExtendedSend(packet);
		}
		packets.clear();
	}

	@Override
	public void ExtendedSend(UTpacket packet) {
	}

	private void initiateBuffer(UTBuffer utBuffer, UTBusType busType) {
		if (busType == UTBusType.cable) {
			utBuffer = new UTBuffer(UTBufferType.Bit, 1);
		}
		if (busType == UTBusType.bundle) {
			utBuffer = new UTBuffer(UTBufferType.Bit, 16);
		}
	}

	@Override
	public UTBusType getBusType() {
		return UTBusType.bus;
	}

	@Override
	public UTBusType getBusType(ForgeDirection side) {
		TileEntity te = worldObj.getBlockTileEntity(xCoord + side.offsetX, yCoord + side.offsetY, zCoord + side.offsetZ);
		if (te instanceof ICommunication) {
			return ((ICommunication) te).getBusType();
		}
		return UTBusType.invalid;
	}

	@Override
	public UTlogicNodeContainer getConnectionsOnSide(ForgeDirection side) {
		return this.nodeCollection[side.ordinal()];
	}

	@Override
	public void registerNode(ForgeDirection side, ICommunicationNode node, ForgeDirection originSide) {
		if (!this.nodeCollection[side.ordinal()].contains(node)) {
			this.nodeCollection[side.ordinal()].add(node);
			this.nodeCollection[side.ordinal()].addSide(originSide);
			initiateBuffer(this.buffer[side.ordinal()], getBusType(side));
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
		nodeCollection[dir.ordinal()].remove(node);
	}

	@Override
	public UTBuffer getBuffer(ForgeDirection dir) {
		return buffer[SIDEDTRANSFORMER.InternalToExternalDirection(this, dir).ordinal()];
	}

	@Override
	public void createDiscoveryPacket() {
		for (ForgeDirection sendingSide : ForgeDirection.VALID_DIRECTIONS)
			packets.add(new UTpacket(UTpacketType.discovery, sendingSide, new ArrayList<ICommunicationTransport>(), this, sendingSide));
		this.scheduleSend();
	}

	@Override
	public void createDiscoveryPacket(ForgeDirection dir) {
		packets.add(new UTpacket(UTpacketType.discovery, dir, new ArrayList<ICommunicationTransport>(), this, dir));
		this.scheduleSend();
	}

	@Override
	public void createDestructionPacket() {
		for (ForgeDirection sendingSide : ForgeDirection.VALID_DIRECTIONS)
			packets.add(new UTpacket(UTpacketType.destroy, sendingSide, new ArrayList<ICommunicationTransport>(), this, sendingSide));
		this.Send();
	}

	@Override
	public void createDataPacket(UTVariable... data) {
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			createDataPacket(dir, data);
		}
	}

	@Override
	public void createDataPacket(ForgeDirection dir, UTVariable... data) {
		packets.add(new UTpacket(UTpacketType.data, SIDEDTRANSFORMER.InternalToExternalDirection(this, dir), data));
		this.scheduleSend();
		for (UTVariable item : data) {
			buffer[SIDEDTRANSFORMER.InternalToExternalDirection(this, dir).ordinal()].put(item);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		super.writeToNBT(par1nbtTagCompound);
		par1nbtTagCompound.setInteger("orientationSide", orientationSide.ordinal());
		par1nbtTagCompound.setInteger("orientationRotation", orientationRotation.ordinal());

		int i = 0;
		for (UTlogicNodeContainer container : nodeCollection) {
			NBTTagList list = container.writeToNBT();
			if (list != null)
				par1nbtTagCompound.setTag("nodes" + i, list);
			i++;
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		super.readFromNBT(par1nbtTagCompound);
		orientationSide = ForgeDirection.getOrientation(par1nbtTagCompound.getInteger("orientationSide"));
		orientationRotation = ForgeDirection.getOrientation(par1nbtTagCompound.getInteger("orientationRotation"));

		int i = 0;
		for (UTlogicNodeContainer container : nodeCollection) {
			NBTTagList list = par1nbtTagCompound.getTagList("nodes" + i);
			if(list.tagCount() != 0)
				container.readFromNBT(list);
			i++;
		}
	}

	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public boolean isValidInput(ForgeDirection dir) {
		for (ForgeDirection d : conectableInputSides) {
			if (getExternalForgeDirection(d) == dir) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isValidOutput(ForgeDirection dir) {
		for (ForgeDirection d : conectableOutputSides) {
			if (getExternalForgeDirection(d) == dir) {
				return true;
			}
		}
		return false;
	}
	
    @Override
    public Packet getDescriptionPacket() {
	NBTTagCompound nbtTag = new NBTTagCompound();
	this.writeToNBT(nbtTag);
	return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
    }

    @Override
    public void onDataPacket(INetworkManager net, Packet132TileEntityData packet) {
	readFromNBT(packet.customParam1);
	this.worldObj.markBlockForRenderUpdate(xCoord, yCoord, zCoord);
    }

    public void notifyBlockChange() {
	if (!this.worldObj.isRemote) {
	    this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);

	    StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	    StackTraceElement e = stacktrace[2];// maybe this number needs to be
						// corrected
	    String methodName = e.getMethodName();
	    String className = e.getClassName();
	}

    }
    int k =0;
    @Override
    public void updateEntity() {
    	super.updateEntity();
    	if(k ==20){
    		notifyBlockChange();
    		k=0;
    	}
    	k++;
    }
}