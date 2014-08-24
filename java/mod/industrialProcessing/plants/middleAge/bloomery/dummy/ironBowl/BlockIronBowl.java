package mod.industrialProcessing.plants.middleAge.bloomery.dummy.ironBowl;

import mod.industrialProcessing.blockContainer.multiblock.dummy.BlockMultiblockDummy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockIronBowl extends BlockMultiblockDummy{

	public BlockIronBowl() {
		super(1.0f,1.0f,Material.iron,Block.soundTypeMetal,"Wood","Canvas","Iron");
		this.setBlockBounds(0.2f, 0.0f, 0.2f, 0.8f, 0.4f, 0.8f);
	}

}
