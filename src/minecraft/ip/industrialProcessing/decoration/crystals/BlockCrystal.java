package ip.industrialProcessing.decoration.crystals;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.decoration.BlockDecoration;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockCrystal extends BlockDecoration {
	public BlockCrystal(int id, String name, CreativeTabs tab, String texture) {
		super(id, Material.glass, 1f, Block.soundGlassFootstep, name, IndustrialProcessing.tabOreProcessing);
		this.setBlockBounds(0, 0, 0, 1, 1, 1);
		func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + texture);
		setBlockBounds(0.25f, 0, 0.25f, 0.75f, 0.5f, 0.75f);
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererCrystalId();
	}
}
