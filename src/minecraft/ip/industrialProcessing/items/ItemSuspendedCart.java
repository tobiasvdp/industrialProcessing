package ip.industrialProcessing.items;

import org.apache.commons.lang3.RandomStringUtils;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupTransportBlocks;
import ip.industrialProcessing.transport.steve.railway.suspended.cart.EntityFloatingCart;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSuspendedCart extends Item{

	public ItemSuspendedCart(int ID,String name,int stackSize,CreativeTabs tab) {
		super(ID);
		this.maxStackSize = stackSize;
		setCreativeTab(tab);
		setUnlocalizedName(name);
		func_111206_d(INamepace.TEXTURE_NAME_PREFIX + name);
	}
	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if(par3World.getBlockId(par4, par5, par6) == ISetupTransportBlocks.blockSuspendedRail.blockID ){
			
			par3World.spawnEntityInWorld(new EntityFloatingCart(par3World, par4+0.5, par5-0.5, par6+0.5,RandomStringUtils.randomAscii(16)));
		}
		return super.onItemUse(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7, par8, par9, par10);
	}

}
