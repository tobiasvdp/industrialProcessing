package ip.industrialProcessing.decoration;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockPlatform extends BlockDecoration {

    public BlockPlatform() {
	super(ConfigBlocks.getPlatformBlockID(), Material.iron, 1f, Block.soundMetalFootstep, "Walkway", IndustrialProcessing.tabPower);
    }

}
