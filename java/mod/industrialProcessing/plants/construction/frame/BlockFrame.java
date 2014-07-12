package mod.industrialProcessing.plants.construction.frame;

import mod.industrialProcessing.blockContainer.multiblock.dummy.BlockMultiblockDummy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockFrame extends BlockMultiblockDummy{

	public BlockFrame() {
		super(1.0f,1.0f,Material.iron, Block.soundTypeAnvil,"flatIron");
	}

}
