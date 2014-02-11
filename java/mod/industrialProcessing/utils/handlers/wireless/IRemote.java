package mod.industrialProcessing.utils.handlers.wireless;

import net.minecraft.item.ItemStack;

public interface IRemote {
	void setTileEntity(ISender sender,ItemStack itemStack, int teX, int teY,int teZ);
	int[] getTileEntity(IReceiver receiver,ItemStack itemStack);
}
