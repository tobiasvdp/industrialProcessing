package ip.industrialProcessing.multiblock.utils;

import ip.industrialProcessing.multiblock.MultiBlockStructureBlockDescription;
import ip.industrialProcessing.multiblock.MultiblockStructure;
import ip.industrialProcessing.multiblock.TileEntityMultiblockBlock;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class MultiblockLayout {
	protected MultiblockStructure[] layouts = new MultiblockStructure[4];
	protected int angle;

	public MultiblockLayout() {
		angle = 0;
	}
	
	public void setLayoutAngle(MultiblockStructure layout, int angle){
		layouts[angle] = layout;
	}
	public MultiBlockStructureBlockDescription getDescription(int i, int j, int k) {
		return layouts[angle].getDescription(i, j, k);
	}

	public MultiBlockStructureBlockDescription getRelativeDescription(int x, int y, int z) {
		return layouts[angle].getRelativeDescription(x, y, z);
	}

	public boolean hasDiscriptionBlockId(int i, int j, int k, int blockId, boolean relative) {
		boolean isValid;
		isValid = layouts[angle].hasDiscriptionBlockId(i, j, k, blockId, relative);
		if (!isValid) {
			if (angle != 3) {
				angle += 1;
				System.out.println("angle set to " + angle);
				isValid = hasDiscriptionBlockId(i, j, k, blockId, relative);
			}else{
				angle = 0;
				System.out.println("angle set to " + angle);
				isValid = false;
			}
		}
		return isValid;

	}

	public boolean checkLayout(World world, int xCore, int yCore, int zCore) {
		return layouts[angle].checkLayout(world, xCore, yCore, zCore);
	}

	public boolean hasDiscription(int x, int y, int z, int blockId) {
		return layouts[angle].hasDiscription(x, y, z, blockId);
	}

	public void setAngle(int angle2) {
		this.angle = angle2;
	}

	public void commit(MultiblockStructure layout) {
		setLayoutAngle(layout,0);
		layout = new MultiblockStructure(layout);
		setLayoutAngle(layout,1);
		layout = new MultiblockStructure(layout);
		setLayoutAngle(layout,2);
		layout = new MultiblockStructure(layout);
		setLayoutAngle(layout,3);
	}
}
