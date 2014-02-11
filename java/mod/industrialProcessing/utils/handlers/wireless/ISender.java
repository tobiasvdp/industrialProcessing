package mod.industrialProcessing.utils.handlers.wireless;

import net.minecraft.item.ItemStack;

public interface ISender {
	boolean sendTileEntity(IRemote remote,ItemStack itemStack);
}
