package mod.industrialProcessing.fluids;

import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBucket;

public class FluidIP {

	private ItemFluid item;
	private BlockFluid block;
	private ItemBucket bucket;

	public FluidIP(String name, int density, int viscosity, Material material, boolean doDamage, boolean hasBucket) {
		item = new ItemFluid(name, density, viscosity);
		block = new BlockFluid(item, material, doDamage);
		item.setFluidBlock(block);
		if (hasBucket)
			bucket = new ItemIPBucket(block);
	}

	public ItemFluid getItem() {
		return item;
	}

	public ItemBucket getBucket() {
		return bucket;
	}

	public BlockFluid getBlock() {
		return block;
	}
}
