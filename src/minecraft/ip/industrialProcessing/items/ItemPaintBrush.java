package ip.industrialProcessing.items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.utils.registry.ItemRegistry;
import ip.industrialProcessing.utils.registry.ItemType;

public class ItemPaintBrush extends ItemDamage {
	public int color;
	public ItemPaintBrush(int ID, int color) {
		super(ID, 16, "paintBrush" + color, ISetupCreativeTabs.tabOres);
		ItemRegistry.RegisterItem(this, ItemType.paintbrush);
		this.color = color;
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		int blockId = par3World.getBlockId(par4, par5, par6);
		if(blockId != 0){
			Block.blocksList[blockId].recolourBlock(par3World, par4, par5, par6, ForgeDirection.getOrientation(par7), color);
		}
		return super.onItemUse(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7, par8, par9, par10);
	}
}
