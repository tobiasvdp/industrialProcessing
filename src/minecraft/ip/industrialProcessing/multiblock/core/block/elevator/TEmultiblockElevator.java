package ip.industrialProcessing.multiblock.core.block.elevator;

import java.util.ArrayList;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import ip.industrialProcessing.config.ISetupMachineBlocks;
import ip.industrialProcessing.multiblock.core.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.dummy.block.frame.ENmultiblockFrame;
import ip.industrialProcessing.multiblock.dummy.block.liftDoor.TEmultiblockLiftDoor;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.layout.LayoutMultiblock;
import ip.industrialProcessing.multiblock.layout.LayoutTransformer;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.tier.Tier;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.multiblock.tier.Tiers;

public class TEmultiblockElevator extends TileEntityMultiblockCore {
	static StructureMultiblock structure;
	static TierCollection tierRequirments;
	static {
		// set layout
		structure = new StructureMultiblock();

		LayoutMultiblock layout = new LayoutMultiblock(0, 3, 0, 3, 4, 0);

		int i = 7;
		for (int j = 0; j < 4; j++) {
			int model = 1;
			if (j == 1)
				model = 2;
			for (int k = 0; k < 4; k++) {
				layout.setBlockID(0, j, -k, i++, model, 0, ISetupMachineBlocks.BLmultiblockFrame.blockID);
				layout.setBlockID(3, j, -k, i++, model, 0, ISetupMachineBlocks.BLmultiblockFrame.blockID);
			}
			layout.setBlockID(1, j, 0, i++, model, 0, ISetupMachineBlocks.BLmultiblockFrame.blockID);
			layout.setBlockID(1, j, -3, i++, model, 0, ISetupMachineBlocks.BLmultiblockFrame.blockID);
			layout.setBlockID(2, j, 0, i++, model, 0, ISetupMachineBlocks.BLmultiblockFrame.blockID);
			layout.setBlockID(2, j, -3, i++, model, 0, ISetupMachineBlocks.BLmultiblockFrame.blockID);
		}
		layout.setBlockID(1, 1, 0, 3, 0, 0, ISetupMachineBlocks.BLmultiblockLiftDoor.blockID);
		layout.setBlockID(1, 2, 0, 4, 0, 0, ISetupMachineBlocks.BLmultiblockLiftDoor.blockID);
		layout.setBlockID(2, 1, 0, 5, 0, 1, ISetupMachineBlocks.BLmultiblockLiftDoor.blockID);
		layout.setBlockID(2, 2, 0, 6, 0, 1, ISetupMachineBlocks.BLmultiblockLiftDoor.blockID);

		layout.setCoreID(0, 0, 0, ISetupMachineBlocks.BLmultiblockElevator.blockID);
		layout.setBlockID(0, 2, -1, 1, 0, 0, ISetupMachineBlocks.BLmultiblockToggleButton.blockID);
		layout.setBlockID(0, 2, 0, 2, 0, 0, ISetupMachineBlocks.BLmultiblockToggleButton2.blockID);

		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);

		// set tiers
		tierRequirments = new TierCollection(1);

		Tier tier = new Tier();
		tierRequirments.addTier(tier, Tiers.Tier0);
	}
	private boolean toggled = false;
	private boolean toggleLock = false;
	private int liftHeight = 0;
	private boolean liftCreated = false;
	private ArrayList<ENmultiblockFrame> lift = new ArrayList<ENmultiblockFrame>();

	public int getLiftHeight() {
		return liftHeight;
	}

	public void setLiftHeight(int liftHeight) {
		this.liftHeight = liftHeight;
	}

	private ArrayList<Integer> levels = new ArrayList<Integer>();

	public TEmultiblockElevator() {
		super(structure, tierRequirments);
	}

	public void toggle(int ID) {
		findLevels();
		int level = 0;
		for (int i = 0; i < levels.size(); i++) {
			if (levels.get(i) == this.yCoord)
				level = i;
		}
		if (this.yCoord != liftHeight || !liftCreated) {
			gotoFloor(level);
			System.out.println("Going to floor " + level);
		}
	}

	private void setElevatorToLevel(int level) {
		boolean upOrDown = false;
		if (levels.get(level) < this.getLiftHeight())
			upOrDown = true;
		for(int y:levels){
			((TEmultiblockElevator) worldObj.getBlockTileEntity(xCoord, y, zCoord)).closeDoors();
		}
		if (!liftCreated) {
			createPlatform(level, upOrDown);
		} else {
			updatePlatform(level, upOrDown);
		}
	}

	private void updatePlatform(int level, boolean upOrDown) {
		for (ENmultiblockFrame en : lift) {
			en.setNewLevel(levels.get(level), upOrDown);
		}
	}

	public void createPlatform(int level, boolean upOrDown) {
		if (liftHeight == 0)
			liftHeight = this.yCoord;
		if (!worldObj.isRemote) {
			spawn(level, upOrDown);
		}

		notifyLevels(liftHeight);
		notifyLiftCreated();
	}

	@Override
	public void updateEntity() {
		if (lift.size() != 0)
			liftHeight = (int) Math.round(lift.get(0).posY);
	}

	private void notifyLiftCreated() {
		for (Integer i : levels) {
			TEmultiblockElevator te = (TEmultiblockElevator) worldObj.getBlockTileEntity(this.xCoord, i, this.zCoord);
			te.liftCreated = true;
			te.lift = lift;
		}
	}

	private void spawn(int level, boolean upOrDown) {
		switch (this.side) {
		case North:
			lift.add(new ENmultiblockFrame(worldObj, xCoord + 1.5, liftHeight, zCoord - 0.5, levels.get(level), upOrDown, this));
			lift.add(new ENmultiblockFrame(worldObj, xCoord + 2.5, liftHeight, zCoord - 0.5, levels.get(level), upOrDown, this));
			lift.add(new ENmultiblockFrame(worldObj, xCoord + 1.5, liftHeight, zCoord - 1.5, levels.get(level), upOrDown, this));
			lift.add(new ENmultiblockFrame(worldObj, xCoord + 2.5, liftHeight, zCoord - 1.5, levels.get(level), upOrDown, this));
			for (int i = 0; i < 4; i++) {
				worldObj.spawnEntityInWorld(lift.get(i));
			}
			break;
		case South:
			lift.add(new ENmultiblockFrame(worldObj, xCoord - 1.5, liftHeight, zCoord + 0.5, levels.get(level), upOrDown, this));
			lift.add(new ENmultiblockFrame(worldObj, xCoord - 2.5, liftHeight, zCoord + 0.5, levels.get(level), upOrDown, this));
			lift.add(new ENmultiblockFrame(worldObj, xCoord - 1.5, liftHeight, zCoord + 1.5, levels.get(level), upOrDown, this));
			lift.add(new ENmultiblockFrame(worldObj, xCoord - 2.5, liftHeight, zCoord + 1.5, levels.get(level), upOrDown, this));
			for (int i = 0; i < 4; i++) {
				worldObj.spawnEntityInWorld(lift.get(i));
			}
			break;
		case East:
			lift.add(new ENmultiblockFrame(worldObj, xCoord - 0.5, liftHeight, zCoord + 1.5, levels.get(level), upOrDown, this));
			lift.add(new ENmultiblockFrame(worldObj, xCoord - 0.5, liftHeight, zCoord + 2.5, levels.get(level), upOrDown, this));
			lift.add(new ENmultiblockFrame(worldObj, xCoord - 1.5, liftHeight, zCoord + 1.5, levels.get(level), upOrDown, this));
			lift.add(new ENmultiblockFrame(worldObj, xCoord - 1.5, liftHeight, zCoord + 2.5, levels.get(level), upOrDown, this));
			for (int i = 0; i < 4; i++) {
				worldObj.spawnEntityInWorld(lift.get(i));
			}
			break;
		case West:
			lift.add(new ENmultiblockFrame(worldObj, xCoord - 0.5, liftHeight, zCoord - 0.5, levels.get(level), upOrDown, this));
			lift.add(new ENmultiblockFrame(worldObj, xCoord - 0.5, liftHeight, zCoord - 1.5, levels.get(level), upOrDown, this));
			lift.add(new ENmultiblockFrame(worldObj, xCoord - 1.5, liftHeight, zCoord - 0.5, levels.get(level), upOrDown, this));
			lift.add(new ENmultiblockFrame(worldObj, xCoord - 1.5, liftHeight, zCoord - 1.5, levels.get(level), upOrDown, this));
			for (int i = 0; i < 4; i++) {
				worldObj.spawnEntityInWorld(lift.get(i));
			}
			break;
		default:
			break;
		}
	}

	public void findLevels() {
		levels.clear();
		for (int i = 0; i < 256; i++) {
			TileEntity te = worldObj.getBlockTileEntity(this.xCoord, i, this.zCoord);
			if (te != null && te instanceof TEmultiblockElevator) {
				levels.add(te.yCoord);
			}
		}
	}

	public ArrayList<Integer> getLevels() {
		return levels;
	}

	public void gotoFloor(int floor) {
		findLevels();
		setElevatorToLevel(floor);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		writeData(nbt);
	}

	private void writeData(NBTTagCompound nbt) {
		nbt.setInteger("liftHeight", liftHeight);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		readData(nbt);
	};

	private void readData(NBTTagCompound nbt) {
		liftHeight = nbt.getInteger("liftHeight");
	}

	public void notifyLevels(int liftHeight) {
		for (Integer i : levels) {
			TEmultiblockElevator te = (TEmultiblockElevator) worldObj.getBlockTileEntity(this.xCoord, i, this.zCoord);
			te.setLiftHeight(liftHeight);
		}
	}

	public void openValidDoors() {
		for (Integer i : levels) {
			TEmultiblockElevator te = (TEmultiblockElevator) worldObj.getBlockTileEntity(this.xCoord, i, this.zCoord);
			if (te.yCoord == liftHeight) {
				te.openDoors();
			}
		}
	}

	private void openDoors() {
		((TEmultiblockLiftDoor) getDummyByID(3)).openDoor(0);
		((TEmultiblockLiftDoor) getDummyByID(4)).openDoor(0);
		((TEmultiblockLiftDoor) getDummyByID(5)).openDoor(1);
		((TEmultiblockLiftDoor) getDummyByID(6)).openDoor(1);
	}

	private void closeDoors() {
		((TEmultiblockLiftDoor) getDummyByID(3)).closeDoor(0);
		((TEmultiblockLiftDoor) getDummyByID(4)).closeDoor(0);
		((TEmultiblockLiftDoor) getDummyByID(5)).closeDoor(1);
		((TEmultiblockLiftDoor) getDummyByID(6)).closeDoor(1);
	}

}
