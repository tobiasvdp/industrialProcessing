package mod.industrialProcessing.plants.todo.dummy.ironPole;

import javax.swing.Icon;

import mod.industrialProcessing.blockContainer.multiblock.dummy.BlockMultiblockDummy;
import mod.industrialProcessing.utils.INamepace;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockIronPole  extends BlockMultiblockDummy{

	public BlockIronPole() {
		super(1.0f,1.0f,Material.iron,Block.soundTypeMetal,"Iron","iron_block","powerOutlet");
		this.setBlockBounds(0.25f, 0.0f, 0.25f, 0.75f, 1.0f, 0.75f);
	}

}
