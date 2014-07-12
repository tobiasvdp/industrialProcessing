package mod.industrialProcessing.plants.blackSmith.bloomery.dummy.bellows;

import javax.swing.Icon;

import mod.industrialProcessing.blockContainer.multiblock.dummy.BlockMultiblockDummy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBellows extends BlockMultiblockDummy{

    Icon[] icons = new Icon[3];
	public BlockBellows() {
		super(1.0f,1.0f,Material.wood,Block.soundTypeWood,"Wood","Canvas");
		this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.4f, 1.0f);
	}


}
