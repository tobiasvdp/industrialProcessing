package mod.industrialProcessing.plants.transport.items.conveyorSorter;

import mod.industrialProcessing.blockContainer.transport.ConnectionState;
import mod.industrialProcessing.transport.items.conveyorBelt.rendering.ModelConveyorBeltTile;
import mod.industrialProcessing.transport.items.conveyorBelt.rendering.comonModels.tileEntity.ConveyorSorterLeftTileEntity;
import mod.industrialProcessing.transport.items.conveyorBelt.rendering.comonModels.tileEntity.ConveyorSorterRightTileEntity;
import net.minecraft.tileentity.TileEntity;

public class ModelConveyorSorter extends ModelConveyorBeltTile {

	ConveyorSorterLeftTileEntity sortLeft = new ConveyorSorterLeftTileEntity();
	ConveyorSorterRightTileEntity sortRight = new ConveyorSorterRightTileEntity();

	@Override
	protected void drawSides(TileEntity tl, float f, ConnectionState left, ConnectionState right) {
		if (left.isConnected())
			drawPath(sortLeft, tl, f, 0);
		if (right.isConnected())
			drawPath(sortRight, tl, f, 0);
	}
}
