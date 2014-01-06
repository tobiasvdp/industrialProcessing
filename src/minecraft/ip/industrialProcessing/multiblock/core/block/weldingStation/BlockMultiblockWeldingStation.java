package ip.industrialProcessing.multiblock.core.block.weldingStation;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;
import ip.industrialProcessing.multiblock.recipes.IRecipeMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.recipes.IRecipeBlock;

public class BlockMultiblockWeldingStation extends BlockMultiblockCore implements IRecipeMultiblock{

	private Icon[] icons = new Icon[4];

	public BlockMultiblockWeldingStation() {
		super(ConfigMachineBlocks.getBLmultiblockWeldingStation(), "BLmultiblockWeldingStation", IndustrialProcessing.tabMultiblocks);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityMultiblockWeldingStation();
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getBLmultiblockWeldingStation();
	}

	@Override
	public RecipesMultiblock getRecipes() {
		return TileEntityMultiblockWeldingStation.recipes;
	}
	
    @Override
    public Icon getIcon(int par1, int par2) {
        par1 %= icons.length;        
        return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        icons [0] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "Planks2");
        icons [1] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "Stone");
        icons [2] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "Planks2");
        icons [3] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "crafting_table_front");
    }
}
