package mod.industrialProcessing.plants.blackSmith.tripHammer.dummy.woodenWheel;

import mod.industrialProcessing.blockContainer.multiblock.dummy.BlockMultiblockDummy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockWoodenWheel  extends BlockMultiblockDummy{

	public BlockWoodenWheel() {
		super(1.0f,1.0f,Material.wood,Block.soundTypeWood,"Planks2");
		this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
	}

}
