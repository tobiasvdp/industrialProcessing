package ip.industrialProcessing.multiblock.layout;

import com.google.common.base.CaseFormat;

public final class LayoutTransformer {

	public static LayoutMultiblock transform(LayoutMultiblock layout, FacingDirection dir) {
		switch (dir) {
		case East: {
			return transformEast(layout);
		}
		case South: {
			return transformSouth(layout);
		}
		case West: {
			return transformWest(layout);
		}
		default:
			return layout;
		}
	}

	private static LayoutMultiblock transformEast(LayoutMultiblock layout) {
		LayoutMultiblock newLayout = new LayoutMultiblock(layout.getSizeFront(), layout.getSizeBack(), layout.getSizeRight(), layout.getSizeLeft(), layout.getSizeUp(), layout.getSizeDown());
		LayoutBlockDescription[][][] layoutArray = layout.getLayout();

		for (int i = 0; i < layoutArray.length; i++) {
			for (int j = 0; j < layoutArray[0].length; j++) {
				for (int k = 0; k < layoutArray[0][0].length; k++) {
					int x = i - layout.getxCore();
					int y = j - layout.getyCore();
					int z = k - layout.getzCore();
					int temp = x;
					x = -z;
					z = temp;
					temp = x;
					x = -z;
					z = temp;
					temp = x;
					x = -z;
					z = temp;
					if (layoutArray[i][j][k] != null)
						newLayout.setBlockIDwithGroup(x, y, -z, layoutArray[i][j][k].getID(), layoutArray[i][j][k].getModelID(), layoutArray[i][j][k].getModelConnection(),layoutArray[i][j][k].getGroupID(), layoutArray[i][j][k].getBlockID());
				}
			}
		}
		return newLayout;
	}

	private static LayoutMultiblock transformSouth(LayoutMultiblock layout) {
		LayoutMultiblock newLayout = new LayoutMultiblock(layout.getSizeRight(), layout.getSizeLeft(), layout.getSizeBack(), layout.getSizeFront(), layout.getSizeUp(), layout.getSizeDown());
		LayoutBlockDescription[][][] layoutArray = layout.getLayout();

		for (int i = 0; i < layoutArray.length; i++) {
			for (int j = 0; j < layoutArray[0].length; j++) {
				for (int k = 0; k < layoutArray[0][0].length; k++) {
					int x = i - layout.getxCore();
					int y = j - layout.getyCore();
					int z = k - layout.getzCore();
					int temp = x;
					x = -z;
					z = temp;
					temp = x;
					x = -z;
					z = temp;
					if (layoutArray[i][j][k] != null)
						newLayout.setBlockIDwithGroup(x, y, -z, layoutArray[i][j][k].getID(), layoutArray[i][j][k].getModelID(), layoutArray[i][j][k].getModelConnection(), layoutArray[i][j][k].getGroupID(), layoutArray[i][j][k].getBlockID());
				}
			}
		}
		return newLayout;
	}

	private static LayoutMultiblock transformWest(LayoutMultiblock layout) {
		LayoutMultiblock newLayout = new LayoutMultiblock(layout.getSizeBack(), layout.getSizeFront(), layout.getSizeLeft(), layout.getSizeRight(), layout.getSizeUp(), layout.getSizeDown());
		LayoutBlockDescription[][][] layoutArray = layout.getLayout();

		for (int i = 0; i < layoutArray.length; i++) {
			for (int j = 0; j < layoutArray[0].length; j++) {
				for (int k = 0; k < layoutArray[0][0].length; k++) {
					int x = i - layout.getxCore();
					int y = j - layout.getyCore();
					int z = k - layout.getzCore();
					int temp = x;
					x = -z;
					z = temp;
					if (layoutArray[i][j][k] != null)
						newLayout.setBlockIDwithGroup(x, y, -z, layoutArray[i][j][k].getID(), layoutArray[i][j][k].getModelID(), layoutArray[i][j][k].getModelConnection(), layoutArray[i][j][k].getGroupID(), layoutArray[i][j][k].getBlockID());
				}
			}
		}
		return newLayout;
	}
}
