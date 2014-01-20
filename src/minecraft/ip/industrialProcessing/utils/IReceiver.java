package ip.industrialProcessing.utils;

import net.minecraft.item.ItemStack;

public interface IReceiver {
boolean receiveTileEntity(IRemote remote,ItemStack itemStack);
}
