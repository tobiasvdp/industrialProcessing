package ip.industrialProcessing.utils.handler.fuel;

import ip.industrialProcessing.config.ISetupItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class FuelHandler implements IFuelHandler {

    @Override
    public int getBurnTime(ItemStack fuel) {
	int i = fuel.itemID;
    Item item = fuel.getItem();

    
    //mc default
    if (item instanceof ItemBlock && Block.blocksList[i] != null)
    {
        Block block = Block.blocksList[i];

        if (block == Block.woodSingleSlab)
        {
            return 150;
        }

        if (block.blockMaterial == Material.wood)
        {
            return 300;
        }

        if (block == Block.field_111034_cE)
        {
            return 16000;
        }
    }

    if (item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("WOOD")) return 200;
    if (item instanceof ItemSword && ((ItemSword) item).getToolMaterialName().equals("WOOD")) return 200;
    if (item instanceof ItemHoe && ((ItemHoe) item).getMaterialName().equals("WOOD")) return 200;
    if (i == Item.stick.itemID) return 100;
    if (i == Item.coal.itemID) return 1600;
    if (i == Item.bucketLava.itemID) return 20000;
    if (i == Block.sapling.blockID) return 100;
    if (i == Item.blazeRod.itemID) return 2400;
    
	//custom
	if(i == ISetupItems.itemThickStick.itemID)
	    return 300;
	
	return 0;
    }

}
