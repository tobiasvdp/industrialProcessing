package ip.industrialProcessing.utils.handler.packets;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.gui.IGuiLayoutTriggerAcceptor;
import ip.industrialProcessing.gui3.binding.reply.StateConfigSetter;
import ip.industrialProcessing.machines.animation.TileAnimationSyncHandler;
import ip.industrialProcessing.machines.animation.conveyors.TileConveyorSyncHandler;
import ip.industrialProcessing.machines.animation.tanks.TileTankSyncHandler;
import ip.industrialProcessing.multiblock.core.block.decoration.garageDoor.TileEntityGarageDoor;
import ip.industrialProcessing.multiblock.core.block.elevator.TEmultiblockElevator;
import ip.industrialProcessing.multiblock.dummy.block.decoration.garageDoor.TileEntityGarageDoorDoor;
import ip.industrialProcessing.multiblock.dummy.block.decoration.garageDoor.TileEntityGarageDoorFrame;
import ip.industrialProcessing.multiblock.dummy.block.decoration.garageDoor.entity.EntityGarageDoor;
import ip.industrialProcessing.multiblock.dummy.block.toggleButton.TEmultiblockToggleButton;
import ip.industrialProcessing.subMod.logic.transport.ICommunicationTransport;
import ip.industrialProcessing.transport.steve.railway.suspended.cart.EntityFloatingCart;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {

    public static final String ANIMATION_SYNC = "IP.AniSync";
    public static final String CONVEYOR_SYNC = "IP.ConvSync";
    public static final String TANK_SYNC = "IP.TankSync";
    public static final String BUTTON_PRESSED = "IP.ButtonPressed";
    public static final String SYNC_CLIENT = "IP.clientSync";
    public static final String GUI_STATECONF = "IP.Gui.sConf";
    public static final String SEND_INFO = "IP.sendInfo";
    public static final String SCREEN_PRESSED = "IP.ScreenPressed";
    public static final String IP_ELEVATOR_BUTTON = "IP.MB.EL.Button";
    public static final String IP_LOGIC_SYNCSIDE = "IP.Lg.SyncSide";
    public static final String IP_ENTITY_INTERACT = "IP.En.Int";
    public static final String IP_ENTITY_SPAWNGARAGEDOOR = "IP.En.GDS";
    public static final String IP_ENTITY_SPAWNGARAGEDOORBLOCK = "IP.En.GDB";

    @Override
    public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
	if (packet.channel.equals(GUI_STATECONF)) {
	    StateConfigSetter.handleIncomingPacket(manager, packet, player);
	} else if (packet.channel.equals(ANIMATION_SYNC)) {
	    TileAnimationSyncHandler.handleAnimationSync(manager, packet, player);
	} else if (packet.channel.equals(TANK_SYNC)) {
	    TileTankSyncHandler.handleTankSync(manager, packet, player);
	} else if (packet.channel.equals(BUTTON_PRESSED)) {
	    DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
	    int teX = 0;
	    int teY = 0;
	    int teZ = 0;
	    int id = 0;
	    try {
		teX = inputStream.readInt();
		teY = inputStream.readInt();
		teZ = inputStream.readInt();
		id = inputStream.readInt();

	    } catch (IOException e) {
		e.printStackTrace();
		return;
	    }

	    EntityPlayer playerMP = (EntityPlayer) player;
	    if (!playerMP.worldObj.isRemote) {
		TileEntity te = playerMP.worldObj.getBlockTileEntity(teX, teY, teZ);
		if (te instanceof IGuiLayoutTriggerAcceptor) {
		    ((IGuiLayoutTriggerAcceptor) te).triggerButton(id);
		}
	    }

	} else if (packet.channel.equals(CONVEYOR_SYNC)) {
	    TileConveyorSyncHandler.handleConveyorSync(manager, packet, player);
	} else if (packet.channel.equals(IP_ENTITY_INTERACT)) {
	    DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
	    String name = "";
	    try {
		while (inputStream.available() > 0)
		    name += inputStream.readChar();
	    } catch (IOException e) {
		e.printStackTrace();
		return;
	    }
	    System.out.println(name);
	    EntityPlayer playerMP = (EntityPlayer) player;
	    for (Object ent : playerMP.worldObj.loadedEntityList.toArray()) {
		if (ent != null && ent instanceof EntityFloatingCart) {
		    if (name.equals(((Entity) ent).getEntityName()))
			((EntityFloatingCart) ent).interact(playerMP);
		}
	    }
	}

	if (packet.channel.equals(IP_ENTITY_SPAWNGARAGEDOOR)) {
	    DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
	    double x;
	    double y;
	    double z;
	    int yMax = 0;
	    boolean direction = false;
	    int teX = 0;
	    int teY = 0;
	    int teZ = 0;
	    try {
		x = inputStream.readInt() / (double) 1000;
		y = inputStream.readInt() / (double) 1000;
		z = inputStream.readInt() / (double) 1000;
		yMax = inputStream.readInt();
		direction = inputStream.readBoolean();
		teX = inputStream.readInt();
		teY = inputStream.readInt();
		teZ = inputStream.readInt();
	    } catch (IOException e) {
		e.printStackTrace();
		return;
	    }

	    EntityPlayer playerMP = (EntityPlayer) player;
	    if (playerMP.worldObj.isRemote && (playerMP.worldObj.getBlockTileEntity(teX, teY, teZ)) instanceof TileEntityGarageDoorFrame) {
		EntityGarageDoor en = new EntityGarageDoor(playerMP.worldObj, x, y, z, yMax, direction, ((TileEntityGarageDoorFrame) (playerMP.worldObj.getBlockTileEntity(teX, teY, teZ))));
		playerMP.worldObj.spawnEntityInWorld(en);
	    }
	    if (playerMP.worldObj.isRemote && (playerMP.worldObj.getBlockTileEntity(teX, teY, teZ)) instanceof TileEntityGarageDoor) {
		EntityGarageDoor en = new EntityGarageDoor(playerMP.worldObj, x, y, z, yMax, direction, ((TileEntityGarageDoor) (playerMP.worldObj.getBlockTileEntity(teX, teY, teZ))));
		playerMP.worldObj.spawnEntityInWorld(en);
	    }
	}

	if (packet.channel.equals(IP_ENTITY_SPAWNGARAGEDOORBLOCK)) {
	    DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
	    int x = 0;
	    int y = 0;
	    int z = 0;
	    int id = 0;
	    int teX = 0;
	    int teY = 0;
	    int teZ = 0;
	    int direction = 0;
	    try {
		x = inputStream.readInt();
		y = inputStream.readInt();
		z = inputStream.readInt();
		id = inputStream.readInt();
		direction = inputStream.readInt();
		teX = inputStream.readInt();
		teY = inputStream.readInt();
		teZ = inputStream.readInt();

	    } catch (IOException e) {
		e.printStackTrace();
		return;
	    }

	    EntityPlayer playerMP = (EntityPlayer) player;
	    if (!playerMP.worldObj.isRemote) {
		if (playerMP.worldObj.getBlockId(x, y, z) == IndustrialProcessing.blockGarageDoorDoor.blockID) {
		    ((TileEntityGarageDoorDoor) playerMP.worldObj.getBlockTileEntity(x, y, z)).hide = false;
		    ((TileEntityGarageDoorDoor) playerMP.worldObj.getBlockTileEntity(x, y, z)).setForwardDirection(ForgeDirection.values()[direction]);
		    playerMP.worldObj.markBlockForUpdate(x, y, z);
		    if ((playerMP.worldObj.getBlockTileEntity(teX, teY, teZ)) instanceof TileEntityGarageDoorFrame)
			((TileEntityGarageDoorFrame) playerMP.worldObj.getBlockTileEntity(teX, teY, teZ)).addToDoors(new int[] { x, y, z });
		    if ((playerMP.worldObj.getBlockTileEntity(teX, teY, teZ)) instanceof TileEntityGarageDoor)
			((TileEntityGarageDoor) playerMP.worldObj.getBlockTileEntity(teX, teY, teZ)).addToDoors(new int[] { x, y, z });
		}
	    }

	}

	// TODO: move this away from here, please!
	if (packet.channel.equals(IP_ELEVATOR_BUTTON)) {
	    DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
	    int x;
	    int y;
	    int z;
	    int id;
	    try {
		x = inputStream.readInt();
		y = inputStream.readInt();
		z = inputStream.readInt();
		id = inputStream.readInt();
	    } catch (IOException e) {
		e.printStackTrace();
		return;
	    }
	    EntityPlayerMP playerMP = (EntityPlayerMP) player;
	    TEmultiblockToggleButton te = (TEmultiblockToggleButton) playerMP.worldObj.getBlockTileEntity(x, y, z);
	    ((TEmultiblockElevator) te.getCore()).gotoFloor(id);
	}
	if (packet.channel.equals(SYNC_CLIENT)) {
	    DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
	    int x;
	    int y;
	    int z;

	    try {
		x = inputStream.readInt();
		y = inputStream.readInt();
		z = inputStream.readInt();
	    } catch (IOException e) {
		e.printStackTrace();
		return;
	    }
	    EntityPlayer playerMP = (EntityPlayer) player;
	    TileEntity te = playerMP.worldObj.getBlockTileEntity(x, y, z);
	    if (te != null)
		te.worldObj.markBlockForUpdate(x, y, z);
	}
	if (packet.channel.equals(SCREEN_PRESSED)) {
	    DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
	    int screenID;
	    int x;
	    int y;
	    int z;

	    try {
		screenID = inputStream.readInt();
		x = inputStream.readInt();
		y = inputStream.readInt();
		z = inputStream.readInt();
	    } catch (IOException e) {
		e.printStackTrace();
		return;
	    }
	    EntityPlayer playerMP = (EntityPlayer) player;
	    playerMP.openGui(IndustrialProcessing.instance, screenID, playerMP.worldObj, x, y, z);
	}

	if (packet.channel.equals(IP_LOGIC_SYNCSIDE)) {
	    DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
	    int x;
	    int y;
	    int z;
	    boolean sides[] = new boolean[6];
	    try {
		x = inputStream.readInt();
		y = inputStream.readInt();
		z = inputStream.readInt();
		for (int i = 0; i < sides.length; i++) {
		    sides[i] = inputStream.readBoolean();
		}
	    } catch (IOException e) {
		e.printStackTrace();
		return;
	    }
	    EntityPlayer playerMP = (EntityPlayer) player;
	    ICommunicationTransport com = (ICommunicationTransport) playerMP.worldObj.getBlockTileEntity(x, y, z);
	    int count = 0;
	    /*
	     * for(int i = 0;i<sides.length;i++){ if(sides[i]){ count++;
	     * com.addToConnectedSides(i,false); }else{
	     * com.removeConnectedSides(i, false); } } if (count>1)
	     * com.setMultipleSides(true); else com.setMultipleSides(false);
	     */
	}
    }

}
