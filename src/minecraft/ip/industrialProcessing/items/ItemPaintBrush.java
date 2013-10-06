package ip.industrialProcessing.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;

public class ItemPaintBrush extends ItemDamage {
	public int color;
	public ItemPaintBrush(int ID, int color) {
		super(ID, 16, "paintBrush" + color, IndustrialProcessing.tabOres);
		this.color = color;
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		System.out.println("Item used " + color);
		return super.onItemUse(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7, par8, par9, par10);
	}
}
