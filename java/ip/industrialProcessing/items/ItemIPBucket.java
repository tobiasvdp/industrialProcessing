package ip.industrialProcessing.items;

import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.utils.handler.fluids.BucketHandler;
import ip.industrialProcessing.utils.registry.ItemRegistry;
import ip.industrialProcessing.utils.registry.ItemType;
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
	setCreativeTab(ISetupCreativeTabs.tabFluid);
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
