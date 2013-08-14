package ip.industrialProcessing.transport.fluids;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ConfigTransportBlocks;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.BlockMachineRendered;

public class BlockTank extends BlockMachineRendered {

    public BlockTank() {
	super(ConfigTransportBlocks.getBlockTransportFluidTankID(), Material.iron, 1F, Block.soundMetalFootstep, "Fluid Tank", IndustrialProcessing.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) { 
	return new TileEntityTank();
    }
    
    @Override
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) { 
        super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
        TileEntityTank tank = (TileEntityTank)par1World.getBlockTileEntity(par2, par3, par4);
        tank.searchForNeighbors();
    }

    @Override
    public int getRenderType() { 
        return ConfigRenderers.getRendererTankId();
    }
}
