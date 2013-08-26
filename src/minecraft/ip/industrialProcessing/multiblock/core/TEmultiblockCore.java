package ip.industrialProcessing.multiblock.core;

import java.util.ArrayList;

import ip.industrialProcessing.multiblock.dummy.TEmultiblockDummy;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Facing;

public class TEmultiblockCore extends TileEntity {

	private StructureMultiblock structure;
	private ArrayList<TEmultiblockDummy> dummy = new ArrayList<TEmultiblockDummy>();
	private FacingDirection side = FacingDirection.North;
	private MultiblockState state = MultiblockState.CONNECTED;

	public TEmultiblockCore(StructureMultiblock structure) {
		this.structure = structure;
	}

	public void registerDummy(TEmultiblockDummy te) {
		dummy.add(te);
		System.out.println("dummy registered");
	}

	public void unregisterDummy(TEmultiblockDummy temultiblockDummy) {
		dummy.remove(temultiblockDummy);
		System.out.println("dummy unregistered");
	}
	
	public boolean isDummyValidForStructure(TEmultiblockDummy te) {
		FacingDirection dir = structure.isBlockValid(te.xCoord - xCoord, te.yCoord - yCoord, te.zCoord - zCoord, te.worldObj.getBlockId(te.xCoord, te.yCoord, te.zCoord), side, false);
		if (dir == FacingDirection.Invalid) {
			return false;
		} else {
			if (dir != side){
				System.out.println("Side changed to "+dir);
				side=dir;
				checkIfRegisteredDummiesAreValid();
			}
			return true;
		}
	}
	
	public void checkIfRegisteredDummiesAreValid(){
		ArrayList<TEmultiblockDummy> dummiesToBeEreased = new ArrayList<TEmultiblockDummy>();
		for(TEmultiblockDummy te:dummy){
			FacingDirection dir = structure.isBlockValid(te.xCoord - xCoord, te.yCoord - yCoord, te.zCoord - zCoord, te.worldObj.getBlockId(te.xCoord, te.yCoord, te.zCoord), side, true);
			if(dir == FacingDirection.Invalid)
				dummiesToBeEreased.add(te);
		}
		for(TEmultiblockDummy te:dummiesToBeEreased){
			te.delCore();
		}
	}
	
	public void destroyMultiblock(){
		for(TEmultiblockDummy te:dummy){
			worldObj.destroyBlock(te.xCoord, te.yCoord, te.zCoord, true);
		}
	}

	public void onStateChange(){
		for(TEmultiblockDummy te:dummy){
			te.setState(state);
		}
	}
	public void onLayoutChange(){
		MultiblockState state = structure.isLayoutValid(worldObj, xCoord, yCoord, zCoord, this.side);
		if (state != this.state){
			this.state = state;
			System.out.println("State changed to "+state);
			onStateChange();
		}
	}

}
