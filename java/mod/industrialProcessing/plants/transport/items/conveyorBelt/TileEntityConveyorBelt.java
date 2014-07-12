package mod.industrialProcessing.plants.transport.items.conveyorBelt;

import mod.industrialProcessing.transport.items.conveyorBelt.tileEntity.TileEntityConveyorPowerTranslation;
import mod.industrialProcessing.transport.items.conveyorBelt.util.ConnectionMode;
import mod.industrialProcessing.transport.items.conveyorBelt.util.MovingItemStack;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityConveyorBelt extends TileEntityConveyorPowerTranslation {

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
