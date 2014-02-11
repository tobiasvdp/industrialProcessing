package mod.industrialProcessing.utils.handlers.wireless;

import net.minecraft.item.ItemStack;

public interface IReceiver {
boolean receiveTileEntity(IRemote remote,ItemStack itemStack);
}
