package ip.industrialProcessing.machines.multiblock.crusher;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.multiblock.MultiBlockStructure;
import ip.industrialProcessing.machines.multiblock.MultiBlockStructureBlockDescription;
import ip.industrialProcessing.machines.multiblock.TileEntityMultiMachineCore;

public class TileEntityLargeCrusher extends TileEntityMultiMachineCore {

	private static MultiBlockStructure crusherStructure;

	static {

		// workaround for blocks that change id depending on their state
		
		/*
		int frameId1 = IndustrialProcessing.blockMachineFrame.blockID; 
		MultiBlockStructureBlockDescription topSide = new MultiBlockStructureBlockDescription(
				0, 1, 0, frameId1 );
		MultiBlockStructureBlockDescription bottomSide = new MultiBlockStructureBlockDescription(
				0, -1, 0, frameId1);
		MultiBlockStructureBlockDescription side1 = new MultiBlockStructureBlockDescription(
				1, 0, 0, frameId1);
		MultiBlockStructureBlockDescription side2 = new MultiBlockStructureBlockDescription(
				-1, 0, 0, frameId1);
		MultiBlockStructureBlockDescription side3 = new MultiBlockStructureBlockDescription(
				0, 0, 1, frameId1);
		MultiBlockStructureBlockDescription side4 = new MultiBlockStructureBlockDescription(
				0, 0, -1, frameId1);
		crusherStructure = new MultiBlockStructure(topSide, bottomSide, side1,
				side2, side3, side4);*/
	
		
	}

	public TileEntityLargeCrusher() {
		super(generateMultiStructure());
	}
	
	private static MultiBlockStructure generateMultiStructure(){
	int frameId1 = IndustrialProcessing.blockMachineFrame.blockID; 
	int blockId[][][] = new int[3][3][3];
	
	for (int i = 0;i<3;i++){
		for (int j = 0;j<3;j++){
			for (int k = 0;k<3;k++){
				if (blockId[i][j][k] != -1){
					blockId[i][j][k] = -1;
				}
			}
		}
	}
	
	blockId[0][0][0]=frameId1;
	blockId[0][0][2]=frameId1;
	blockId[0][2][0]=frameId1;
	blockId[0][2][2]=frameId1;
	blockId[2][0][0]=frameId1;
	blockId[2][0][2]=frameId1;
	blockId[2][2][0]=frameId1;
	blockId[2][2][2]=frameId1;
	
	crusherStructure = new MultiBlockStructure();
	
	for (int i = 0;i<3;i++){
		for (int j = 0;j<3;j++){
			for (int k = 0;k<3;k++){
				if (blockId[i][j][k] != -1){
					crusherStructure.addStructure(new MultiBlockStructureBlockDescription(i-1,j-1,k-1,blockId[i][j][k]));
				}
			}
		}
	}
	return crusherStructure;
	}

}
