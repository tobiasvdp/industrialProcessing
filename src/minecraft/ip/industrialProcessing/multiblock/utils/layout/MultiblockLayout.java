package ip.industrialProcessing.multiblock.utils.layout;

import java.util.Iterator;

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

	public MultiBlockStructureBlockDescription getDescription(int i, int j, int k, int angle) {
		return layouts[angle].getDescription(i, j, k);
	}

	public BlockForward hasDiscriptionBlockId(int i, int j, int k, int blockId, boolean locked, BlockForward angle) {
		if (angle != BlockForward.INVALID && layouts[angle.ordinal()].hasDiscriptionBlockId(i, j, k, blockId))
			return angle;
		for (BlockForward forward : BlockForward.VALID_FORWARDS) {
			if (forward != angle) {
				MultiblockStructure layout = layouts[forward.ordinal()];
				if (layout.hasDiscriptionBlockId(i + layout.getxCore(), j + layout.getyCore(), k + layout.getzCore(), blockId))
					return forward;
			}
		}
		return BlockForward.INVALID;
	}

	public BlockForward getLayoutForward(World world, int xCore, int yCore, int zCore, BlockForward angle) {
		if (angle != BlockForward.INVALID && layouts[angle.ordinal()].checkLayout(world, xCore, yCore, zCore))
			return angle;
		for (BlockForward forward : BlockForward.VALID_FORWARDS) {
			if (forward != angle)
				if (layouts[forward.ordinal()].checkLayout(world, xCore, yCore, zCore))
					return forward;
		}
		return BlockForward.INVALID;
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

	public int getModelID(int i, int j, int k, BlockForward angle) {
		MultiblockStructure layout = layouts[angle.ordinal()];
		return layout.getModelID(i + layout.getxCore(), j + layout.getyCore(), k + layout.getzCore());
	}
}
