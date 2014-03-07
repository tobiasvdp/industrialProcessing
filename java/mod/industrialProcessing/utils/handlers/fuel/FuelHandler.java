package mod.industrialProcessing.utils.handlers.fuel;

import mod.industrialProcessing.items.ISetupItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {

    @Override
    public int getBurnTime(ItemStack fuel) {
    Item item = fuel.getItem();

    
    //mc default
    if (item instanceof ItemBlock)
    {
        Block block = Block.getBlockFromItem(item);

        if (block.equals(Blocks.wooden_slab))
        {
            return 150;
        }

        if (block.getMaterial() == Material.wood)
        {
            return 300;
        }

        if (block.equals(Blocks.coal_block))
        {
            return 16000;
        }
        if (block.equals(Blocks.sapling))
        {
            return 100;
        }
    }

    if (item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("WOOD")) return 200;
    if (item instanceof ItemSword && ((ItemSword) item).getToolMaterialName().equals("WOOD")) return 200;
    if (item instanceof ItemHoe && ((ItemHoe) item).getToolMaterialName().equals("WOOD")) return 200;
    if (item.equals(Items.stick)) return 100;
    if (item.equals(Items.coal)) return 1600;
    if (item.equals(Items.lava_bucket)) return 20000;
    if (item.equals(Items.blaze_rod)) return 2400;
    
	//custom
	if(item.equals(ISetupItems.itemThickStick))
	    return 300;
	
	return 0;
    }

}
