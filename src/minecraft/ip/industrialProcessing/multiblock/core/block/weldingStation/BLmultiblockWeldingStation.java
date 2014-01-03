package ip.industrialProcessing.multiblock.core.block.weldingStation;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;
import ip.industrialProcessing.recipes.IRecipeBlock;

public class BLmultiblockWeldingStation extends BlockMultiblockCore implements IRecipeBlock{

	public BLmultiblockWeldingStation() {
		super(ConfigMachineBlocks.getBLmultiblockWeldingStation(), "BLmultiblockWeldingStation", IndustrialProcessing.tabMultiblocks);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEmultiblockWeldingStation();
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getBLmultiblockWeldingStation();
	}

	@Override
	public RecipesMachine getRecipes() {
		return TEmultiblockWeldingStation.recipes;
	}
}
