package ip.industrialProcessing.items.guide;

import ip.industrialProcessing.GuiHandler;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.items.ItemIP;
import ip.industrialProcessing.utils.registry.ItemRegistry;
import ip.industrialProcessing.utils.registry.ItemType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGuide extends ItemIP {

    public ItemGuide(int ID, String name, CreativeTabs tab) {
	super(ID, name, tab); 
	ItemRegistry.RegisterItem(this, ItemType.tool);
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) { 

	par3EntityPlayer.openGui(IndustrialProcessing.instance, GuiHandler.GUIDE_ID, par2World, 0, 0, 0);
        return super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
    }

}
