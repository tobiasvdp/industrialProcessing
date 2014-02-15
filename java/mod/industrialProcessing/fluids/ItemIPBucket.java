package mod.industrialProcessing.fluids;

import mod.industrialProcessing.creativeTab.ISetupCreativeTabs;
import mod.industrialProcessing.utils.INamepace;
import mod.industrialProcessing.utils.handlers.fluids.BucketHandler;
import mod.industrialProcessing.utils.registry.ItemRegistry;
import mod.industrialProcessing.utils.registry.ItemType;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;

public class ItemIPBucket extends ItemBucket {

    public ItemIPBucket(Block block) {
	super(block);
    } 
 
    @Override
    public boolean hasContainerItem() { 
        return true;
    }
    
    @Override
    public Item getContainerItem() { 
        return (Item) Item.itemRegistry.getObject("empty_bucket");
    }
    
    
    @Override
    public ItemStack getContainerItem(ItemStack itemStack) { 
        return new ItemStack(getContainerItem(),1);
    }
}
