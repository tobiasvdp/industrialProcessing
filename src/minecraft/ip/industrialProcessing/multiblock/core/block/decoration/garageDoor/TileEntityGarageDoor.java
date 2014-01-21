package ip.industrialProcessing.multiblock.core.block.decoration.garageDoor;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;

import org.bouncycastle.util.Arrays;

import cpw.mods.fml.common.network.PacketDispatcher;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ISetupMachineBlocks;
import ip.industrialProcessing.multiblock.core.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.core.block.weldingStation.RecipesWeldingStation;
import ip.industrialProcessing.multiblock.dummy.TileEntityMultiblockDummy;
import ip.industrialProcessing.multiblock.dummy.block.controlBox.IControlBoxReceiver;
import ip.industrialProcessing.multiblock.dummy.block.decoration.garageDoor.TileEntityGarageDoorDoor;
import ip.industrialProcessing.multiblock.dummy.block.decoration.garageDoor.TileEntityGarageDoorFrame;
import ip.industrialProcessing.multiblock.dummy.block.decoration.garageDoor.entity.EntityGarageDoor;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.layout.LayoutMultiblock;
import ip.industrialProcessing.multiblock.layout.LayoutTransformer;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.multiblock.tier.Tier;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.utils.IRemote;
import ip.industrialProcessing.utils.ISender;
import ip.industrialProcessing.utils.handler.packets.PacketHandler;

public class TileEntityGarageDoor extends TileEntityMultiblockCore implements ISender,IControlBoxReceiver {
	static StructureMultiblock structure;
	static TierCollection tierRequirments;
	boolean isCreated = true;
	
	static {
		// set layout
		structure = new StructureMultiblock();

		LayoutMultiblock layout = new LayoutMultiblock(0, 10,0, 0, 0, 0);

		int i = 0;
		layout.setCoreID(i++, 0, 1, ISetupMachineBlocks.blockGarageDoor.blockID);

		layout.setBlockID(1, 0, 0, i++, 0, 1, ISetupMachineBlocks.blockGarageDoorFrame.blockID);
		for (int j = 2; j <= 10; j++)
			layout.setBlockID(j, 0, 0, i++, 0, 1, ISetupMachineBlocks.blockGarageDoorFrame.blockID, -1);

		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);

		// set tiers
		tierRequirments = new TierCollection(1);

		Tier tier = new Tier();
		tierRequirments.addTier(tier, Tiers.Tier0);
	}

	int height = 0;
	int[] heights = new int[11];

	public TileEntityGarageDoor() {
		super(structure, tierRequirments);
		Arrays.fill(heights, -1);
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height, int id, boolean generate) {
		heights[id] = height;
		if (generate) {
			int newHeight = 7;
			for (int i = 0; i < heights.length; i++) {
				if (heights[i] != -1) {
					newHeight = Math.min(newHeight, heights[i]);
				}
			}
			if (newHeight != this.height) {
				this.height = newHeight;
				onHeightChange();
			}
		}
	}

	private void onHeightChange() {
		ArrayList<TileEntityMultiblockDummy> dummies = getDummies();
		for (int i = 0; i < dummies.size(); i++) {
			if (dummies.get(i) instanceof TileEntityGarageDoorFrame) {
				((TileEntityGarageDoorFrame) dummies.get(i)).generateGarageDoor();
			}
		}
	}

	private boolean open = false;
	private boolean isWorking = false;

	private void orderDummiesToRise() {
		ArrayList<TileEntityMultiblockDummy> dummies = getDummies();
		for (int i = 0; i < dummies.size(); i++) {
			if (dummies.get(i) instanceof TileEntityGarageDoorFrame) {
				((TileEntityGarageDoorFrame) dummies.get(i)).rise();
			}
		}
		this.rise();
	}

	private void orderDummiesToFall() {
		ArrayList<TileEntityMultiblockDummy> dummies = getDummies();
		for (int i = 0; i < dummies.size(); i++) {
			if (dummies.get(i) instanceof TileEntityGarageDoorFrame) {
				((TileEntityGarageDoorFrame) dummies.get(i)).fall();
			}
		}
		this.fall();
	}
	
	public void doneWorking(){
		isWorking = false;
		System.out.println("Done");
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		open = nbt.getBoolean("open");
		super.readFromNBT(nbt);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setBoolean("open", open);
		super.writeToNBT(nbt);
	}
	
	public boolean isOpen(){
		return open;
	}

	@Override
	public boolean sendTileEntity(IRemote remote,ItemStack itemStack) {
		remote.setTileEntity(this, itemStack, this.xCoord, this.yCoord, this.zCoord);
		return true;
	}

	@Override
	public void buttonPressed(int i) {
		if(i == 0){
			open();
		}
		if(i == 2){
			Close();
		}
	}

	private void Close() {
		if (!isWorking) {
			if (open) {
				open = false;
				isWorking = true;
				orderDummiesToFall();
			}
		}
	}

	private void open() {
		if (!isWorking) {
			if (!open) {
				open = true;
				isWorking = true;
				orderDummiesToRise();
			}
		}
	}
	
	//dummy
	
	@Override
	public void updateEntity() {
		super.updateEntity();
		if(isCreated){
			giveHeightToCore();
			generateGarageDoor();
			isCreated = false;
		}
	}

	private void giveHeightToCore() {
		int height = 0;
		boolean cont = true;
		while (cont) {
			height++;
			if (this.worldObj.getBlockId(xCoord, yCoord - height, zCoord) != 0 && this.worldObj.getBlockId(xCoord, yCoord - height, zCoord) != IndustrialProcessing.blockGarageDoorDoor.blockID) {
				height--;
				cont = false;
			}
		}
			setHeight(height, 0, true);
	}

	private ArrayList<int[]> doors = new ArrayList<int[]>();
	private boolean isDestroying = false;

	public void generateGarageDoor() {
		if (!isDestroying && !isOpen()) {
			clearOldGarageDoor();
			int height = getHeight();
			if (height > 0) {
				for (int i = 1; i <= height; i++) {
					this.worldObj.setBlock(xCoord, yCoord - i, zCoord, IndustrialProcessing.blockGarageDoorDoor.blockID);
					((TileEntityGarageDoorDoor)this.worldObj.getBlockTileEntity(xCoord, yCoord - i, zCoord)).setForwardDirection(getForwardDirection());
					doors.add(new int[] { xCoord, yCoord - i, zCoord });
				}
			}
		}
	}

	private void clearOldGarageDoor() {
		for (int i = 0; i < doors.size(); i++) {
			int[] xyz = doors.get(i);
			int x = xyz[0];
			int y = xyz[1];
			int z = xyz[2];
			int id = this.worldObj.getBlockId(x, y, z);
			if (id == IndustrialProcessing.blockGarageDoorDoor.blockID) {
				this.worldObj.setBlockToAir(x, y, z);
			}
		}
		doors.clear();
	}

	@Override
	public void onDestroy() {
		isDestroying = true;
		clearOldGarageDoor();
			setHeight(-1, 0, true);
		super.onDestroy();
	}

	public void rise() {
		convertAllToEntity();
		doneWorking();
	}

	public void convertAllToEntity() {
		ArrayList<int[]> doors = new ArrayList<int[]>();
		doors.addAll(this.doors);
		hideGarageDoor(doors);
		this.doors.clear();
		for (int i = 0; i < doors.size(); i++) {
			EntityGarageDoor en = new EntityGarageDoor(worldObj, (doors.get(i)[0] + 0.5), (doors.get(i)[1]), (doors.get(i)[2] + 0.5),this.yCoord,true,this);
			if (!worldObj.isRemote) {
				sendSpawnPackets((doors.get(i)[0] + 0.5), (doors.get(i)[1]), (doors.get(i)[2] + 0.5),this.yCoord,true,this);
			}
		}
	}
	
	public void fall() {
		int height = getHeight();
		for (int i = height; i >= 1; i--) {
			if (!worldObj.isRemote) {
				sendSpawnPackets((xCoord + 0.5), (yCoord-i+height), (zCoord + 0.5),this.yCoord-i,false,this);
			}
		}
	}
	
	private void sendSpawnPackets(double d, int i, double e, int j, boolean b, TileEntity tileEntityGarageDoorFrame) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
		DataOutputStream outputStream = new DataOutputStream(bos);
		try {
		        outputStream.writeInt((int)(d*1000));
		        outputStream.writeInt((int)(i*1000));
		        outputStream.writeInt((int)(e*1000));
		        outputStream.writeInt(j);
		        outputStream.writeBoolean(b);
		        outputStream.writeInt(tileEntityGarageDoorFrame.xCoord);
		        outputStream.writeInt(tileEntityGarageDoorFrame.yCoord);
		        outputStream.writeInt(tileEntityGarageDoorFrame.zCoord);
		} catch (Exception ex) {
		        ex.printStackTrace();
		}

		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = PacketHandler.IP_ENTITY_SPAWNGARAGEDOOR;
		packet.data = bos.toByteArray();
		packet.length = bos.size();
		
		PacketDispatcher.sendPacketToAllAround(this.xCoord, this.yCoord,this.zCoord, 30, this.worldObj.provider.dimensionId, packet);
	}

	public void addToDoors(int... ints){
		int height = getHeight();
		doors.add(ints);
		if(doors.size() == height){
			doneWorking();
		}
	}
	
	private void hideGarageDoor(ArrayList<int[]> doors2) {
		for (int i = 0; i < doors2.size(); i++) {
			if (worldObj.getBlockTileEntity(doors2.get(i)[0], doors2.get(i)[1], doors2.get(i)[2]) != null) {
				TileEntityGarageDoorDoor te = (TileEntityGarageDoorDoor) worldObj.getBlockTileEntity(doors2.get(i)[0], doors2.get(i)[1], doors2.get(i)[2]);
				te.hide();
			}
		}
	}

}
