package ip.industrialProcessing.machines.flotationCell;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.IRecipeBlock;

public class BlockFlotationCell extends BlockMachineRendered implements IRecipeBlock {

    private Icon[] icons = new Icon[2];

    public BlockFlotationCell() {
        super(ConfigMachineBlocks.getFlotationCellBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Flotation Cell", IndustrialProcessing.tabOreProcessing);

    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        TileEntityFlotationCell te = new TileEntityFlotationCell();
        te.setName(getLocalizedName());
        return te;
    }

    @Override
    public int getRenderType() {
        return ConfigRenderers.getRendererFlotationCellId();
    }

    @Override
    public Icon getIcon(int par1, int par2) {
        par1 %= icons.length;
        return icons[par1];
    }
    
    @Override
    public void registerIcons(IconRegister par1IconRegister) { 
        this.icons[1] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "tankSide");
        this.icons[0] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "tankFeatures");
    }

    @Override
    public RecipesMachine getRecipes() { 
	return TileEntityFlotationCell.recipes;
    }

}
