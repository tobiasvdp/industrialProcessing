package ip.industrialProcessing.items;

import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.fluids.BlockFluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import ip.industrialProcessing.fluids.BucketHandler;
import ip.industrialProcessing.utils.registry.ItemRegistry;
import ip.industrialProcessing.utils.registry.ItemType;

public class ItemIPBucket extends ItemBucket {

    public ItemIPBucket(int itemId, Fluid fluid, BlockFluid block, String texture) {
	super(itemId, block.blockID);
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
        return Item.bucketEmpty;
    }
    
    
    @Override
    public ItemStack getContainerItemStack(ItemStack itemStack) { 
        return new ItemStack(getContainerItem(),1);
    }
}
