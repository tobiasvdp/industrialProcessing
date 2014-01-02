package ip.industrialProcessing.utils.heat;

import ip.industrialProcessing.config.ISetupItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;

public class HeatHandler implements IHeatHandler{
	@Override
    public int getHeatOfItem(ItemStack fuel) {
	int i = fuel.itemID;
    Item item = fuel.getItem();

    
    //mc default
    if (item instanceof ItemBlock && Block.blocksList[i] != null)
    {
        Block block = Block.blocksList[i];

        if (block == Block.woodSingleSlab)
        {
            return 600 ;
        }

        if (block.blockMaterial == Material.wood)
        {
            return 600 ;
        }

        if (block == Block.field_111034_cE)
        {
            return 2700;
        }
    }

    if (item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("WOOD")) return 600 ;
    if (item instanceof ItemSword && ((ItemSword) item).getToolMaterialName().equals("WOOD")) return 600 ;
    if (item instanceof ItemHoe && ((ItemHoe) item).getMaterialName().equals("WOOD")) return 600 ;
    if (i == Item.stick.itemID) return 600 ;
    if (i == Item.coal.itemID) return 2700;
    if (i == Item.bucketLava.itemID) return 1200;
    if (i == Block.sapling.blockID) return 600;
    if (i == Item.blazeRod.itemID) return 1200;
    
	//custom
	if(i == ISetupItems.itemThickStick.itemID)
	    return 600;
	
	return 0;
    }
}
