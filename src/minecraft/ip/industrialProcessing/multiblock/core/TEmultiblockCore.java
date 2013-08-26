package ip.industrialProcessing.multiblock.core;

import java.util.ArrayList;

import ip.industrialProcessing.multiblock.dummy.TEmultiblockDummy;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Facing;

public class TEmultiblockCore extends TileEntity {

	private StructureMultiblock structure;
	private ArrayList<TEmultiblockDummy> dummy = new ArrayList<TEmultiblockDummy>();
	private FacingDirection side = FacingDirection.North;

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
	
	public boolean isDummyValidForstructure(TEmultiblockDummy te) {
		FacingDirection dir = structure.isBlockValid(te.xCoord - xCoord, te.yCoord - yCoord, te.zCoord - zCoord, te.worldObj.getBlockId(te.xCoord, te.yCoord, te.zCoord), side, false);
		if (dir == FacingDirection.Invalid) {
			return false;
		} else {
			if (dir != side){
				System.out.println("Side changed to "+dir);
				checkIfRegisteredDummiesValid();
			}
			side = dir;
			return true;
		}
	}
	
	public void checkIfRegisteredDummiesValid(){
		for(TEmultiblockDummy te:dummy){
			FacingDirection dir = structure.isBlockValid(te.xCoord - xCoord, te.yCoord - yCoord, te.zCoord - zCoord, te.worldObj.getBlockId(te.xCoord, te.yCoord, te.zCoord), side, true);
			if(dir == FacingDirection.Invalid)
				te.delCore();
		}
	}



}
