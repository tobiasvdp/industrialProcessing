package ip.industrialProcessing.logic.transport;

import ip.industrialProcessing.logic.utils.UTBuffer;
import ip.industrialProcessing.logic.utils.UTBufferType;
import ip.industrialProcessing.logic.utils.UTBusType;
import ip.industrialProcessing.logic.utils.UTlogicNodeContainer;
import ip.industrialProcessing.logic.utils.UTpacket;
import ip.industrialProcessing.logic.utils.UTpacketType;
import ip.industrialProcessing.utils.ISidedRotation;

import java.util.ArrayList;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public abstract class TElogicNode extends TileEntity implements ICommunicationNode, ISidedRotation{
	
	private ForgeDirection orientationSide;
	private ForgeDirection orientationRotation;
	
	private UTlogicNodeContainer[] nodeCollection = new UTlogicNodeContainer[6];
	private UTBuffer[] buffer = new UTBuffer[6];
	private ForgeDirection[] conectableInputSides;
	private ForgeDirection[] conectableOutputSides;
	
	private ArrayList<UTpacket> packets = new ArrayList<UTpacket>();

	public TElogicNode() {
		conectableInputSides = setConnectableInputSides();
		conectableOutputSides = setConnectableInputSides();
		for (int i = 0; i < 6; i++) {
			nodeCollection[i] = new UTlogicNodeContainer();
			buffer[i] = new UTBuffer(UTBusType.bus);
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
	
	public ForgeDirection[] getConnectableInputSides(){
		return conectableInputSides;
	}
	public ForgeDirection[] getConnectableOutputSides(){
		return conectableOutputSides;
	}

	/*
	 * start of rotation implementation
	 */
	
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
		if(packet.getType() == UTpacketType.discovery){
			this.registerNode(((ForgeDirection)packet.getData(0)), (ICommunicationNode) packet.getData(2), ((ForgeDirection)packet.getData(3)));
			((ICommunicationNode) packet.getData(2)).registerNode(((ForgeDirection)packet.getData(3)), this, (ForgeDirection) (packet.getData(0)));
		}
		ExtendedReceive(packet);
	}

	@Override
	public abstract void ExtendedReceive(UTpacket packet);

	@Override
	public void scheduleSend() {
		this.worldObj.scheduleBlockUpdateWithPriority(xCoord, yCoord, zCoord, worldObj.getBlockId(xCoord, yCoord, zCoord), 1, -1);
	}

	@Override
	public void Send() {
		for(UTpacket packet:packets){
			if(packet.getType() == UTpacketType.discovery){
				ForgeDirection sendingSide = (ForgeDirection) packet.getData(0);
				nodeCollection[sendingSide.ordinal()].clear();
				TileEntity te = worldObj.getBlockTileEntity(xCoord + sendingSide.offsetX, yCoord + sendingSide.offsetY, zCoord + sendingSide.offsetZ);
				if (te instanceof ICommunication) {
					ICommunication com = (ICommunication) te;
					buffer[sendingSide.ordinal()] = new UTBuffer(com.getBusType());
					com.Receive(packet);
				}
			}
		}
		packets.clear();
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
			System.out.println("Registered node");
			this.nodeCollection[side.ordinal()].add(node);
			this.nodeCollection[side.ordinal()].addSide(originSide);
			this.buffer[side.ordinal()] = new UTBuffer(getBusType(side));
		}
	}

	@Override
	public void removeNode(ICommunicationNode node) {
		System.out.println("Unregistered node ");
		for (UTlogicNodeContainer sideContainer : this.nodeCollection) {
			sideContainer.remove(node);
		}
	}

	@Override
	public UTBuffer getBuffer(ForgeDirection dir) {
		return buffer[dir.ordinal()];
	}
	
	public void createDiscoveryPacket(){
		for(ForgeDirection sendingSide: ForgeDirection.VALID_DIRECTIONS)
			packets.add(new UTpacket(UTpacketType.discovery, sendingSide.getOpposite(), new ArrayList<ICommunicationTransport>(), this, sendingSide));
		this.scheduleSend();
	}
	public void createDestructionPacket(){
		
	}
	public void createDataPacket(){
		
	}
}