package ip.industrialProcessing.multiblock.utils;

import ip.industrialProcessing.multiblock.MultiBlockStructureBlockDescription;
import net.minecraft.block.Block;
import net.minecraft.world.World;


public class MultiblockLayout {
	protected MultiBlockStructureBlockDescription[][][] layout;
	protected int xCore;
	protected int yCore;
	protected int zCore;
	public MultiblockLayout(int blocksLeft, int blocksRight,int blocksFront, int blocksBack, int blocksUp, int blocksDown){
		layout = new MultiBlockStructureBlockDescription[blocksLeft+blocksRight+1][blocksUp + blocksDown + 1][blocksFront+blocksBack+1];
		xCore = blocksLeft;
		yCore = blocksDown;
		zCore = blocksFront;	
	}
	public void setCoreID(int blockID){
		layout[xCore][yCore][zCore] = new MultiBlockStructureBlockDescription(0,0,0,blockID);
	}
	public void addBlockIDRelative(int hor,int ver,int depth,int... blockIDs){
		
		layout[hor+xCore][ver+yCore][depth+zCore] = new MultiBlockStructureBlockDescription(hor,ver,depth,blockIDs);
	}

	public void addBlockID(int hor,int ver,int depth,int... blockIDs){
		layout[hor][ver][depth] = new MultiBlockStructureBlockDescription(hor-xCore,ver-yCore,depth-zCore,blockIDs); 
	}
	public void fillBlockID(int blockID) {
		for (int i = 0;i<layout.length;i++){
			for (int j = 0;j<layout[i].length;j++){
				for (int k = 0;k<layout[i][j].length;k++){
					if (layout[i][j][k] == null){
						addBlockID(i,j,k,blockID);
					}
				}
			}
		}	
	}
	public MultiBlockStructureBlockDescription getDescription(int i,int j,int k){
			return layout[i][j][k];
	}
	public MultiBlockStructureBlockDescription getRelativeDescription(int x,int y,int z){
		for(int i = 0;i<layout.length;i++){
			for(int j = 0;j<layout[0].length;j++){
				for(int k = 0;k<layout[0][0].length;k++){
					if (layout[i][j][k].getX() == x)
						if (layout[i][j][k].getY() == y)
							if (layout[i][j][k].getZ() == z)
								return layout[i][j][k];
				}
			}
		}
		return null;
	}
	public boolean hasDiscriptionBlockId(int i,int j,int k,int blockId,boolean relative){
		MultiBlockStructureBlockDescription desc = null;
		if (relative){desc = getRelativeDescription(i,j,k);}
		else{desc = getDescription(i,j,k);}
		if (desc==null)return false;
		return desc.containsBlock(blockId);
		
	}
	public boolean checkLayout(World world,int xCore,int yCore,int zCore){
		for(int i = 0;i<layout.length;i++){
			for(int j = 0;j<layout[0].length;j++){
				for(int k = 0;k<layout[0][0].length;k++){
					int blockId = world.getBlockId(xCore - this.xCore +i,yCore - this.yCore+j, zCore - this.zCore+k);
					if (!hasDiscriptionBlockId(i,j,k,blockId,false))
						return false;
				}
			}
		}
		return true;
	}
	public boolean hasDiscription(int x,int y, int z,int blockId){
		for(int i = 0;i<layout.length;i++){
			for(int j = 0;j<layout[0].length;j++){
				for(int k = 0;k<layout[0][0].length;k++){
					if (layout[i][j][k].getX() == x)
						if (layout[i][j][k].getY() == y)
							if (layout[i][j][k].getZ() == z)
								return true;
				}
			}
		}
		return false;
	}
}
