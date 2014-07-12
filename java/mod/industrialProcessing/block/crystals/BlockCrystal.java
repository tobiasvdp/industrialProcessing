package mod.industrialProcessing.block.crystals;

import mod.industrialProcessing.block.BlockIPRendered;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCrystal extends BlockIPRendered {
	public BlockCrystal() {
		super(1.f,1.0f, Material.glass, Block.soundTypeGlass);
		this.setBlockBounds(0, 0, 0, 1, 1, 1);
		setBlockBounds(0.25f, 0, 0.25f, 0.75f, 0.5f, 0.75f);
	}
}
