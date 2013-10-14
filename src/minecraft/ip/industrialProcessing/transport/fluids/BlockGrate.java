package ip.industrialProcessing.transport.fluids;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigTransportBlocks;
import ip.industrialProcessing.machines.BlockMachine;

public class BlockGrate extends BlockMachine {
    public BlockGrate() {
        super(ConfigTransportBlocks.getBlockTransportFluidGrateID(), Material.iron, 1F, Block.soundMetalFootstep, "Grate", IndustrialProcessing.tabFluid);
        func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "grate");
    }
    @Override
    public TileEntity createNewTileEntity(World world) { 
        return new TileEntityGrate();
    }

}
