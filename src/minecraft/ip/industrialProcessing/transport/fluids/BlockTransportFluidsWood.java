package ip.industrialProcessing.transport.fluids;

import ip.industrialProcessing.config.ConfigTransportBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockTransportFluidsWood extends BlockTransportFluids {

    public BlockTransportFluidsWood() {
	super(ConfigTransportBlocks.getBlockTransportFluidsWoodID(), Material.wood, Block.soundWoodFootstep, "Wood-embedded Fluid Pipe");
    }
}
