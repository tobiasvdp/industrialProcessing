package ip.industrialProcessing.machines.multiblock.crusher;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.multiblock.MultiBlockStructure;
import ip.industrialProcessing.machines.multiblock.MultiBlockStructureBlockDescription;
import ip.industrialProcessing.machines.multiblock.TileEntityMultiMachineCore;

public class TileEntityLargeCrusher extends TileEntityMultiMachineCore {

	private static MultiBlockStructure crusherStructure;

	static
	{
		MultiBlockStructureBlockDescription topSide = new MultiBlockStructureBlockDescription(0,1,0, IndustrialProcessing.blockMachineFrame.blockID);
		MultiBlockStructureBlockDescription bottomSide = new MultiBlockStructureBlockDescription(0,-1,0, IndustrialProcessing.blockMachineFrame.blockID);
		crusherStructure = new MultiBlockStructure(topSide, bottomSide);
	}
	public TileEntityLargeCrusher() { 
		super(crusherStructure); 
	}

}
