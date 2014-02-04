package ip.industrialProcessing.decoration.crystals;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.decoration.BlockDecoration;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockCrystal extends BlockDecoration {
	public BlockCrystal(int id, String name, CreativeTabs tab, String texture) {
		super(id, Material.glass, 1f, Block.soundGlassFootstep, name, ISetupCreativeTabs.tabOreProcessing);
		this.setBlockBounds(0, 0, 0, 1, 1, 1);
		setTextureName(INamepace.TEXTURE_NAME_PREFIX + texture);
		setBlockBounds(0.25f, 0, 0.25f, 0.75f, 0.5f, 0.75f);
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererCrystalId();
	}
}
