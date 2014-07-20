package mod.industrialProcessing.microBlock;

import javax.swing.Icon;

import mod.industrialProcessing.microBlock.core.BlockMicroBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class MicroBlock extends BlockMicroBlock{
	private Icon[] icons = new Icon[1];

	public MicroBlock() {
		super(50.0f,50.0f, Material.iron, Block.soundTypeMetal);
	}

	@Override
	public MicroBlockType getMicroBlockType() {
		return MicroBlockType.wire;
	}
}
