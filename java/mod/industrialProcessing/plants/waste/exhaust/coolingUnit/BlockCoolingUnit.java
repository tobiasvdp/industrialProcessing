package ip.industrialProcessing.machines.plants.waste.exhaust.coolingUnit;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui3.generating.GuiBuilderDefault;
import ip.industrialProcessing.gui3.generating.IGuiBlock;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.recipes.IMachineRecipes;
import ip.industrialProcessing.recipes.IRecipeBlock;
import ip.industrialProcessing.utils.IDescriptionBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCoolingUnit extends BlockMachineRendered implements IDescriptionBlock, IRecipeBlock, IGuiBlock {
    public static String UNLOCALIZED_NAME = "IP.Machine.CoolingUnit";
    private static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).addInputTank(0).addInputTank(1).addOutputTank(2).enableWorker().enablePower(0);

    public BlockCoolingUnit() {
	super(ConfigMachineBlocks.getBlockCoolingUnitID(), Material.iron, 1f, Block.soundMetalFootstep, UNLOCALIZED_NAME, ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityCoolingUnit te = new TileEntityCoolingUnit();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererCoolingUnitId();
    }

    @Override
    public IGuiBuilder getGui() {
	return guiBuilder;
    }

    @Override
    public IMachineRecipes getRecipes() {
	return TileEntityCoolingUnit.recipes;
    }

    @Override
    public String getDescription() {
	return "Cools hot exhaust gasses";
    }

}
