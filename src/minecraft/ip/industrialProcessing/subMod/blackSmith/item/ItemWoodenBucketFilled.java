package ip.industrialProcessing.subMod.blackSmith.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import ip.industrialProcessing.fluids.BlockFluid;
import ip.industrialProcessing.items.ItemIPBucket;
import ip.industrialProcessing.subMod.blackSmith.config.ISetupBlackSmith;

public class ItemWoodenBucketFilled extends ItemIPBucket {

	public ItemWoodenBucketFilled(int itemId, Fluid fluid, Block waterstill,
			String texture) {
		super(itemId, fluid, waterstill, texture);
	}
	
    @Override
    public Item getContainerItem() { 
        return ISetupBlackSmith.itemWoodenBucket;
    }

}
