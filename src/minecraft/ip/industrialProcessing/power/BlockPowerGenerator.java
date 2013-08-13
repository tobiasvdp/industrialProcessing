package ip.industrialProcessing.power;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.BlockMachineRendered;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract class BlockPowerGenerator extends BlockMachineRendered {

    public BlockPowerGenerator(int par1, Material par2Material, float hardness, StepSound stepSound, String name, CreativeTabs tab) {
	super(par1, par2Material, hardness, stepSound, name, tab);
    }

    @Override
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
	TileEntityPowerGenerator generator = (TileEntityPowerGenerator) par1World.getBlockTileEntity(par2, par3, par4);
	generator.searchForPowerAcceptors();
	super.onNeighborBlockChange(par1World, par2, par3, par4, par5); 
    }
}
