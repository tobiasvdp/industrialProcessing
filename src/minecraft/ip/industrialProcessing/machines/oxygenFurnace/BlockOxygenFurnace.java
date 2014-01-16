package ip.industrialProcessing.machines.oxygenFurnace;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.IRecipeBlock;

public class BlockOxygenFurnace extends BlockMachine implements IRecipeBlock{

	public BlockOxygenFurnace() {
		super(ConfigMachineBlocks.getOxygenFurnaceID(), Material.iron, 1F, Block.soundMetalFootstep, "Oxygen Furnace", ISetupCreativeTabs.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		TileEntityOxygenFurnace te = new TileEntityOxygenFurnace();
		te.setName(getLocalizedName());
		return te;
	}

	@Override
	public RecipesMachine getRecipes() { 
	    return TileEntityOxygenFurnace.recipes;
	}

}
