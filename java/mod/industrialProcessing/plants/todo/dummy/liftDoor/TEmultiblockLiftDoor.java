package mod.industrialProcessing.plants.todo.dummy.liftDoor;

import ip.industrialProcessing.multiblock.core.block.elevator.TEmultiblockElevator;
import ip.industrialProcessing.multiblock.dummy.TileEntityMultiblockDummy;

public class TEmultiblockLiftDoor extends TileEntityMultiblockDummy {
	boolean init = true;
	ENmultiblockLiftDoor door;

	public TEmultiblockLiftDoor() {

	}

	@Override
	public void updateEntity() {
		if (init) {
			if (!worldObj.isRemote) {
				door = new ENmultiblockLiftDoor(worldObj, xCoord + 0.5, yCoord, zCoord + 0.5, getModelConnection(), (TEmultiblockElevator) getCore());
				worldObj.spawnEntityInWorld(door);
			}
			init = false;
		}
	}

	public void openDoor(int i) {
		if (door != null) {
			door.setDir(1);
			System.out.println("opening");
		}
	}

	public void closeDoor(int i) {
		if (door != null) {
			door.setDir(2);
			System.out.println("Closing");
		}
	}
}
