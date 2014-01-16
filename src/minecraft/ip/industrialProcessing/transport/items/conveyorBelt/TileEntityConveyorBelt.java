package ip.industrialProcessing.transport.items.conveyorBelt;

import ip.industrialProcessing.LocalDirection;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityConveyorBelt extends TileEntityConveyorInteractionBase {

	public TileEntityConveyorBelt()
	{
		setConnectionMode(LocalDirection.BACK, ConnectionMode.OUTPUT);
		setConnectionMode(LocalDirection.UP, ConnectionMode.INPUT);
	}

	@Override
	protected ItemStack outputToTileEntity(MovingItemStack stack, TileEntity neighbor, ForgeDirection direction) {
		// can't output to tile entities!
		return stack.stack;
	}
}
