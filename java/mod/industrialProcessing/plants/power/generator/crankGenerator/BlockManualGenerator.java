package mod.industrialProcessing.plants.power.generator.crankGenerator;

import mod.industrialProcessing.blockContainer.machine.power.generator.BlockPowerGenerator;
import mod.industrialProcessing.utils.creativeTab.ISetupCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockManualGenerator extends BlockPowerGenerator {

    public BlockManualGenerator() {
	super(1.0f,1.0f, Material.iron, Block.soundTypeMetal);
    }
    
    @Override
    public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) { 
        super.onBlockClicked(par1World, par2, par3, par4, par5EntityPlayer);
        TileEntityManualGenerator generator = (TileEntityManualGenerator)par1World.getTileEntity(par2, par3, par4);
        generator.playerPushed();
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
        TileEntityManualGenerator generator = (TileEntityManualGenerator)world.getTileEntity(x, y, z);
        generator.playerPushed();
        return super.onBlockActivated(world, x, y, z, player, metadata, what, these, are);
    }
    
}
