package ip.industrialProcessing.machines.plants.waste.waterTreatment.waterTreatmentStation;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.IRecipeBlock;

public class BlockWaterTreatmentStation extends BlockMachineRendered implements IRecipeBlock {

    public BlockWaterTreatmentStation() {
	super(ConfigMachineBlocks.getWaterTreatmentStationID(), Material.iron, 1F, Block.soundMetalFootstep, "WaterTreatmentStation", IndustrialProcessing.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityWaterTreatmentStation te = new TileEntityWaterTreatmentStation();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return 0;
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntityWaterTreatmentStation.recipes;
    }
}
