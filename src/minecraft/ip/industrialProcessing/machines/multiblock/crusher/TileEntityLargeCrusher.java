package ip.industrialProcessing.machines.multiblock.crusher;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.multiblock.MultiBlockStructure;
import ip.industrialProcessing.machines.multiblock.MultiBlockStructureBlockDescription;
import ip.industrialProcessing.machines.multiblock.TileEntityMultiMachineCore;

public class TileEntityLargeCrusher extends TileEntityMultiMachineCore {

	private static MultiBlockStructure crusherStructure;

	static {

		// workaround for blocks that change id depending on their state
		int frameId1 = IndustrialProcessing.blockMachineFrame.blockID;
		int frameId2 = IndustrialProcessing.blockMachineFrameCompleted.blockID;
		int frameId3 = IndustrialProcessing.blockMachineFrameConnected.blockID;
		MultiBlockStructureBlockDescription topSide = new MultiBlockStructureBlockDescription(
				0, 1, 0, frameId1, frameId2, frameId3);
		MultiBlockStructureBlockDescription bottomSide = new MultiBlockStructureBlockDescription(
				0, -1, 0, frameId1, frameId2, frameId3);
		MultiBlockStructureBlockDescription side1 = new MultiBlockStructureBlockDescription(
				1, 0, 0, frameId1, frameId2, frameId3);
		MultiBlockStructureBlockDescription side2 = new MultiBlockStructureBlockDescription(
				-1, 0, 0, frameId1, frameId2, frameId3);
		MultiBlockStructureBlockDescription side3 = new MultiBlockStructureBlockDescription(
				0, 0, 1, frameId1, frameId2, frameId3);
		MultiBlockStructureBlockDescription side4 = new MultiBlockStructureBlockDescription(
				0, 0, -1, frameId1, frameId2, frameId3);
		crusherStructure = new MultiBlockStructure(topSide, bottomSide, side1,
				side2, side3, side4);
	}

	public TileEntityLargeCrusher() {
		super(crusherStructure);
	}

}
