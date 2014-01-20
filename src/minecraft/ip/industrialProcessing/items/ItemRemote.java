package ip.industrialProcessing.items;

import java.util.List;

import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.fluids.BucketHandler;
import ip.industrialProcessing.utils.IReceiver;
import ip.industrialProcessing.utils.IRemote;
import ip.industrialProcessing.utils.ISender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemRemote extends Item implements IRemote{

	public ItemRemote(int par1) {
		super(par1);
		setUnlocalizedName("RemoteIP");
		setMaxStackSize(1);
		setCreativeTab(ISetupCreativeTabs.tabMultiblocks);
		func_111206_d(INamepace.TEXTURE_NAME_PREFIX + "itemRemote");
	}
	
	@Override
	public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		super.onCreated(par1ItemStack, par2World, par3EntityPlayer);
		par1ItemStack.stackTagCompound = new NBTTagCompound();
		par1ItemStack.stackTagCompound.setIntArray("te", new int[]{});
	}
	
	
	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		TileEntity tileEntity = par3World.getBlockTileEntity(par4, par5, par6);
		if (tileEntity != null){
			if (tileEntity instanceof ISender){
			ISender sender = (ISender) tileEntity;
			sender.sendTileEntity(this,par1ItemStack);
		}
		if (tileEntity instanceof IReceiver){
			IReceiver receiver = (IReceiver) tileEntity;
			receiver.receiveTileEntity(this,par1ItemStack);
		}
		}
		return super.onItemUse(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7, par8, par9, par10);
	}

	@Override
	public void setTileEntity(ISender sender,ItemStack itemStack, int teX, int teY, int teZ) {
		itemStack.stackTagCompound.setIntArray("te", new int[]{teX,teY,teZ});
	}

	@Override
	public int[] getTileEntity(IReceiver receiver,ItemStack itemStack) {
		return itemStack.stackTagCompound.getIntArray("te");
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
    if (itemStack.stackTagCompound != null) {
            int[] te = itemStack.stackTagCompound.getIntArray("te");
            if (te.length == 3) {
                    list.add(EnumChatFormatting.GREEN + "te X:" + te[0]+" Y:"+te[1]+" Z:"+te[3]);
            } else {
                    list.add(EnumChatFormatting.RED + "te");
            }
    }
}

}
