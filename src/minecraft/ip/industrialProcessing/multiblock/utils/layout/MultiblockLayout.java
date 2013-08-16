package ip.industrialProcessing.multiblock.utils.layout;

import ip.industrialProcessing.multiblock.TileEntityMultiblockBlock;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class MultiblockLayout {
	protected MultiblockStructure[] layouts = new MultiblockStructure[4];

	public MultiblockLayout() {
	}
	public void setLayoutAngle(MultiblockStructure layout, int angle) {
		layouts[angle] = layout;
	}

	public MultiBlockStructureBlockDescription getDescription(int i, int j, int k,int angle) {
		return layouts[angle].getDescription(i, j, k);
	}

	public boolean hasDiscriptionBlockId(int i, int j, int k, int blockId, boolean locked, int[] angle) {
		boolean isValid;
		isValid = layouts[angle[0]].hasDiscriptionBlockId(i+layouts[angle[0]].getxCore(), j+layouts[angle[0]].getyCore(), k+layouts[angle[0]].getzCore(), blockId);
		if (!locked) {
			if (!isValid) {
				angle[0] = 0;
				while(!isValid){
					angle[0] += 1;
					if (angle[0] == 4){
						angle[0] = 0;
						return false;
					}
					isValid = layouts[angle[0]].hasDiscriptionBlockId(i+layouts[angle[0]].getxCore(), j+layouts[angle[0]].getyCore(), k+layouts[angle[0]].getzCore(), blockId);
				}
			}
		}
		return isValid;

	}

	public boolean checkLayout(World world, int xCore, int yCore, int zCore, int[] angle) {
		boolean isValid;
		isValid = layouts[angle[0]].checkLayout(world, xCore, yCore, zCore);
		if (!isValid) {
			angle[0] = 0;
			while(!isValid){
				angle[0] += 1;
				if (angle[0] == 4){
					angle[0] = 0;
					return false;
				}
				isValid = layouts[angle[0]].checkLayout(world, xCore, yCore, zCore);
			}
		}
		return isValid;
	}

	public boolean hasDiscription(int x, int y, int z, int blockId, int[] angle) {
		return layouts[angle[0]].hasDiscription(x, y, z);
	}

	public void commit(MultiblockStructure layout) {
		setLayoutAngle(layout, 0);
		layout = new MultiblockStructure(layout);
		setLayoutAngle(layout, 1);
		layout = new MultiblockStructure(layout);
		setLayoutAngle(layout, 2);
		layout = new MultiblockStructure(layout);
		setLayoutAngle(layout, 3);
	}
}
