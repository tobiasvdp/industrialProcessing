package mod.industrialProcessing.plants.power.motor.electroMotor;

import mod.industrialProcessing.blockContainer.BlockContainerIPRendered;
import mod.industrialProcessing.gui.framework.panels.Orientation;
import mod.industrialProcessing.gui.generating.GuiBuilderCrafting;
import mod.industrialProcessing.gui.generating.GuiBuilderDefault;
import mod.industrialProcessing.gui.generating.IGuiBuilder;
import mod.industrialProcessing.plants.power.generator.generator.RecipesUpgradeGenerator;
import mod.industrialProcessing.utils.block.IDescriptionBlock;
import mod.industrialProcessing.utils.block.IGuiBlock;
import mod.industrialProcessing.utils.block.IUpgradableBlock;
import mod.industrialProcessing.work.recipe.RecipesMachine;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockElectroMotor extends BlockContainerIPRendered implements IDescriptionBlock, IGuiBlock,IUpgradableBlock {

    private static IGuiBuilder guiBuilder = new GuiBuilderDefault("Motor").addLabeledGauge("Voltage", "%.2fV", 0).addLabeledGauge("Speed", "%.0fRPM", 1);
    private static RecipesUpgradeElectroMotor upgradeRecipes;  
    private static IGuiBuilder gui = new GuiBuilderCrafting("Machine Block").addInputSlotCluster(1, 9, 3, Orientation.HORIZONTAL).setFillingSlot(6);
    
    public BlockElectroMotor() {
        super(1f,1f,Material.iron, Block.soundTypeMetal,"powerFeatures","tankSide");
    }

    @Override
    public IGuiBuilder getGui() { 
	return guiBuilder;
    }

    @Override
    public String getDescription() { 
	return "Converts electricity into mechanical motion";
    }
    
    @Override
	public IGuiBuilder getUpgradeGui() {
		return gui;
	}

	@Override
	public RecipesMachine getUpgradeRecipes() {
		if(upgradeRecipes == null)
			upgradeRecipes = new RecipesUpgradeElectroMotor();
		return upgradeRecipes;
	}

	@Override
	public boolean isMachineUpgradable() {
		return true;
	}
}
