package ip.industrialProcessing.power;

import ip.industrialProcessing.IndustrialProcessing;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract class BlockPowerGenerator extends BlockContainer {

    protected BlockPowerGenerator(int par1, Material par2Material, float hardness, StepSound stepSound, String name, CreativeTabs tab) {
	super(par1, par2Material);
	setHardness(hardness);
	setStepSound(stepSound);
	setUnlocalizedName(name);
	setCreativeTab(tab);
	func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "inputTop");
    }
 
@Override
public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) { 
    super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
    TileEntityPowerGenerator generator =(TileEntityPowerGenerator)par1World.getBlockTileEntity(par2, par3, par4);
    if(generator != null)
	generator.searchPowerAcceptors();
    
}
}
