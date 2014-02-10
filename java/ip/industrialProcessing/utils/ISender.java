package ip.industrialProcessing.utils;

import net.minecraft.item.ItemStack;

public interface ISender {
	boolean sendTileEntity(IRemote remote,ItemStack itemStack);
}
