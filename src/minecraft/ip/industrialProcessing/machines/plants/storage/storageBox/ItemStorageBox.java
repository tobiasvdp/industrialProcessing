package ip.industrialProcessing.machines.plants.storage.storageBox;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.items.ItemIP;

public class ItemStorageBox extends ItemBlock {

    public ItemStorageBox(int par1) {
	super(par1);
    }

    @Override
    public int getItemStackLimit() { 
        return 1;
    }
    
    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
	super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
	if (par1ItemStack != null && par1ItemStack.stackTagCompound != null) {
	    for (int j = 0; j < 9; j++) {
		ItemStack stack = IndustrialProcessing.blockStorageBox.peekStackFromBox(par1ItemStack, j);
		if (stack != null)
		    par3List.add(EnumChatFormatting.WHITE + "" + stack.stackSize + "x " + EnumChatFormatting.GRAY + stack.getDisplayName());
	    }
	}
    }
}
