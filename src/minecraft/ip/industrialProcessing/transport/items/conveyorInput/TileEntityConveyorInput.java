package ip.industrialProcessing.transport.items.conveyorInput;

import java.util.Arrays;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntitySynced;
import ip.industrialProcessing.transport.items.conveyorBelt.ConnectionMode;
import ip.industrialProcessing.transport.items.conveyorBelt.MovingItemStack;
import ip.industrialProcessing.transport.items.conveyorBelt.SlopeState;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorBelt;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorInventoryBase;
import ip.industrialProcessing.transport.items.interfaces.IItemAcceptor;
import ip.industrialProcessing.transport.items.interfaces.IItemAcceptorInput;

public class TileEntityConveyorInput extends TileEntityConveyorInventoryBase {

	public TileEntityConveyorInput() {
		super();
		Arrays.fill(this.connections, ConnectionMode.INVENTORYINPUT);
		setConnectionMode(LocalDirection.BACK, ConnectionMode.OUTPUT);
	}
}
