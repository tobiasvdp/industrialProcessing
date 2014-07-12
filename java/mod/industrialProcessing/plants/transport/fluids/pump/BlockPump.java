package mod.industrialProcessing.plants.transport.fluids.pump;

import mod.industrialProcessing.blockContainer.BlockContainerIPRendered;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockPump extends BlockContainerIPRendered {

    public BlockPump() {
        super(1.0f,1.0f, Material.iron, Block.soundTypeMetal, "tankFeatures","tankSide");
    }
}
