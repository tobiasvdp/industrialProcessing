package ip.industrialProcessing.items.solderingIron;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.items.ItemDamage;

public class ItemSolderingIron extends ItemDamage {

	public ItemSolderingIron(int ID, int maxDamage, String name, CreativeTabs tab) {
		super(ID, maxDamage, name, tab);
	}
	
	@Deprecated
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		par2EntityPlayer.openGui(IndustrialProcessing.instance,3, par3World, par4, par5, par6);
		return false;
	}
}
