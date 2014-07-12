package mod.industrialProcessing.blockContainer.multiblock.coreAndDummy;

import java.util.ArrayList;
import java.util.Iterator;

import mod.industrialProcessing.blockContainer.multiblock.core.TileEntityMultiblockCore;
import mod.industrialProcessing.blockContainer.multiblock.layout.FacingDirection;
import mod.industrialProcessing.blockContainer.multiblock.layout.StructureMultiblock;
import mod.industrialProcessing.blockContainer.multiblock.utils.MultiblockState;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class MultiblockMass {

	ArrayList<TileEntityMultiblockSwitcherCore> cores;
	ArrayList<TileEntityMultiblockSwitcherDummy> dummies;
	boolean hasCore = false;

	public MultiblockMass(TileEntityMultiblockSwitcherDummy tileEntityMultiblockSwitcherDummy) {
		dummies = new ArrayList<TileEntityMultiblockSwitcherDummy>();
		cores = new ArrayList<TileEntityMultiblockSwitcherCore>();
		dummies.add(tileEntityMultiblockSwitcherDummy);
		mapMass(tileEntityMultiblockSwitcherDummy.getWorldObj(), tileEntityMultiblockSwitcherDummy.xCoord, tileEntityMultiblockSwitcherDummy.yCoord, tileEntityMultiblockSwitcherDummy.zCoord, tileEntityMultiblockSwitcherDummy.getBlockType());
		hasCore = convertCoresToDummies(tileEntityMultiblockSwitcherDummy.getWorldObj());
		System.out.println("dummie count: " + dummies.size());
		System.out.println("core count: " + cores.size());
	}

	private boolean convertCoresToDummies(World world) {
		Iterator<TileEntityMultiblockSwitcherCore> it = cores.iterator();
		while (it.hasNext()) {
			TileEntityMultiblockSwitcherCore te = it.next();
			if (te.getState() != MultiblockState.COMPLETED)
				cores.remove(te);
			te.switchToDummy();
			dummies.add((TileEntityMultiblockSwitcherDummy) world.getTileEntity(te.xCoord, te.yCoord, te.zCoord));
		}
		if (cores.size() > 0) {
			return true;
		}
		return false;
	}

	private void mapMass(World worldObj, int xCoord, int yCoord, int zCoord, Block blockType) {
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			TileEntity te = worldObj.getTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
			if (te != null && te.getBlockType().equals(blockType)) {
				if (te instanceof TileEntityMultiblockSwitcherDummy) {
					if (!dummies.contains(te) && ((TileEntityMultiblockSwitcherDummy) te).getCore() == null) {
						dummies.add((TileEntityMultiblockSwitcherDummy) te);
						mapMass(worldObj, te.xCoord, te.yCoord, te.zCoord, blockType);
					}
				}
				if (te instanceof TileEntityMultiblockSwitcherCore) {
					if (!cores.contains(te)) {
						cores.add((TileEntityMultiblockSwitcherCore) te);
						mapMass(worldObj, te.xCoord, te.yCoord, te.zCoord, blockType);
					}
				}
			}
		}
	}

	public boolean hasCore() {
		return hasCore;
	}

	public void fitMultiblock(StructureMultiblock structure) {
		if (hasCore) {

		} else {
			int[] core = analyseBestCore(structure);
			TileEntityMultiblockSwitcherDummy te = dummies.get(core[0]);
			System.out.println("best ["+te.xCoord+","+te.yCoord+","+te.zCoord+"]");
			
			if(structure.couldLayoutBeValid(te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord, FacingDirection.values()[core[1]]) == MultiblockState.COMPLETED)
				createCore(structure,te,FacingDirection.values()[core[1]]);
		}
	}
	
	private void createCore(StructureMultiblock structure, TileEntityMultiblockSwitcherDummy te, FacingDirection facingDirection) {
		World world = te.getWorldObj();
		dummies.remove(te);
		te.switchToCore();
		TileEntityMultiblockSwitcherCore teCore = (TileEntityMultiblockSwitcherCore) world.getTileEntity(te.xCoord, te.yCoord, te.zCoord);
		teCore.setForwardDirection(teCore.FacingDirectionToForge(facingDirection));
		structure.registerAllValidDummies(world, teCore.xCoord, teCore.yCoord, teCore.zCoord, facingDirection);	
		Iterator<TileEntityMultiblockSwitcherDummy> it = dummies.iterator();
		while(it.hasNext()){
			TileEntityMultiblockSwitcherDummy dummie = it.next();
			if(dummie.getCore() == null){
				world.func_147480_a(dummie.xCoord, dummie.yCoord, dummie.zCoord, true);
			}
		}
		teCore.onLayoutChange();
	}

	public int[]  analyseBestCore(StructureMultiblock structure) {
		int[][] size = new int[dummies.size()][4];
		for (int i = 0; i < dummies.size(); i++) {
			TileEntityMultiblockSwitcherDummy dummy = (TileEntityMultiblockSwitcherDummy) dummies.get(i);
			size[i][0] = structure.getLayoutValidCount(dummy.getWorldObj(), dummy.xCoord, dummy.yCoord, dummy.zCoord, FacingDirection.North);
			size[i][1] = structure.getLayoutValidCount(dummy.getWorldObj(), dummy.xCoord, dummy.yCoord, dummy.zCoord, FacingDirection.East);
			size[i][2] = structure.getLayoutValidCount(dummy.getWorldObj(), dummy.xCoord, dummy.yCoord, dummy.zCoord, FacingDirection.South);
			size[i][3] = structure.getLayoutValidCount(dummy.getWorldObj(), dummy.xCoord, dummy.yCoord, dummy.zCoord, FacingDirection.West);
		}

		int[] best = getBestSuitedCore(size);
		return best;
	}
	
	private int[] getBestSuitedCore(int[][] size) {
		int[] best = new int[3];
		int hightest = 0;
		for (int i = 0; i < size.length; i++) {
			for (int j = 0; j < 4; j++) {
				if (size[i][j] > hightest) {
					best[0] = i;
					best[1] = j;
					hightest = size[i][j];
					best[2] = hightest;

				}
			}
		}
		return best;
	}

}
