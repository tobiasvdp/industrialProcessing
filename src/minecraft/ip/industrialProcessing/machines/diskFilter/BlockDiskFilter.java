package ip.industrialProcessing.machines.diskFilter;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.IRecipeBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockDiskFilter extends BlockMachineRendered implements IRecipeBlock {

    Icon[] icons = new Icon[5];
	public BlockDiskFilter() {
		super(ConfigMachineBlocks.getDiskFilterBlockID(), Material.iron, 1f, Block.soundMetalFootstep, "Disk Filter", IndustrialProcessing.tabOreProcessing); 
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		TileEntityDiskFilter te =  new TileEntityDiskFilter();
		te.setName(getLocalizedName());
		return te;
	}
	
    @Override
    public int getRenderType() {
    	return ConfigRenderers.getRendererDiskFilterId();
    }

    @Override
    public Icon getIcon(int par1, int par2) {
	return icons[par1 % icons.length];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        icons[0] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "generatorFeatures");
        icons[1] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "tankSide");
        icons[2] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "conveyorHopperFeatures");
        icons[3] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "tankFeatures");
        icons[4] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "DiskFilterRings"); 
    }

    @Override
    public RecipesMachine getRecipes() { 
	return TileEntityDiskFilter.recipes;
    }

}
