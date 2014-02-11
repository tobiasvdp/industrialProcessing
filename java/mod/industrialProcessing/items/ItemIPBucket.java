package mod.industrialProcessing.items;

import mod.industrialProcessing.creativeTab.ISetupCreativeTabs;
import mod.industrialProcessing.utils.INamepace;
import mod.industrialProcessing.utils.registry.ItemRegistry;
import mod.industrialProcessing.utils.registry.ItemType;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;

public class ItemIPBucket extends ItemBucket {

    public ItemIPBucket(Fluid fluid, Block block, String texture) {
	super(block);
	setUnlocalizedName("Container" + fluid.getName());
	setMaxStackSize(1);
	setCreativeTab(ISetupCreativeTabs.tabItems);
	ItemRegistry.RegisterItem(this, ItemType.fluid);
	BucketHandler.INSTANCE.put(block, this);
	setTextureName(INamepace.TEXTURE_NAME_PREFIX + texture);
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
