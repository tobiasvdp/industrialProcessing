package mod.industrialProcessing.transport.fluids.utils;

import mod.industrialProcessing.fluids.BlockFluid;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidBlock;

public class FluidUtils {

    public static boolean isFullFluidBlock(Block blockId, World world, int x, int y, int z) {
        Block block = blockId;
        if (block instanceof BlockFluid || block instanceof IFluidBlock)
            return world.getBlockMetadata(x, y, z) == 0;
        return false;
    }
    
    public static FluidStack drainBlock(Block blockId, World world, int x, int y, int z, boolean doDrain) {
        if (blockId instanceof IFluidBlock) { 
            IFluidBlock fluidBlock = (IFluidBlock) blockId;
            if (fluidBlock.canDrain(world, x, y, z))  { 
                return fluidBlock.drain(world, x, y, z, doDrain);
            }
        } else if (blockId.equals(Blocks.water)){
            int meta = world.getBlockMetadata(x, y, z);
            if (meta != 0)
                return null;
            if (doDrain)
                world.setBlockToAir(x, y, z);
            return new FluidStack(FluidRegistry.WATER, FluidContainerRegistry.BUCKET_VOLUME);
        } else if (blockId.equals(Blocks.lava)) {
            int meta = world.getBlockMetadata(x, y, z);
            if (meta != 0)
                return null;
            if (doDrain)
                world.setBlockToAir(x, y, z);
            return new FluidStack(FluidRegistry.LAVA, FluidContainerRegistry.BUCKET_VOLUME);
        }
        return null;
    }
    
    public static boolean canDrainBlock(Block blockId, World world, int x, int y, int z)
    {
        FluidStack stack = drainBlock(blockId, world, x, y, z, false); 
        if(stack == null) return false;
        if(stack.amount == 0) return false;
        return true;
    }
}
