package ip.industrialProcessing.power.manualGenerator;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.power.BlockPowerGenerator;

public class BlockManualGenerator extends BlockPowerGenerator {

    public BlockManualGenerator() {
	super(ConfigMachineBlocks.getManualGeneratorBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Crank Generator", IndustrialProcessing.tabPower);
    }

    @Override
    public TileEntity createNewTileEntity(World world) { 
	return new TileEntityManualGenerator();
    }

    @Override
    public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) { 
        super.onBlockClicked(par1World, par2, par3, par4, par5EntityPlayer);
        TileEntityManualGenerator generator = (TileEntityManualGenerator)par1World.getBlockTileEntity(par2, par3, par4);
        generator.playerPushed();
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
        TileEntityManualGenerator generator = (TileEntityManualGenerator)world.getBlockTileEntity(x, y, z);
        generator.playerPushed();
        return super.onBlockActivated(world, x, y, z, player, metadata, what, these, are);
    }
    
}
