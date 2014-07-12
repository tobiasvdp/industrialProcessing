package mod.industrialProcessing.plants.power.generator.generator;

import mod.industrialProcessing.blockContainer.machine.power.generator.BlockPowerGenerator;
import mod.industrialProcessing.gui.framework.panels.Orientation;
import mod.industrialProcessing.gui.generating.GuiBuilderCrafting;
import mod.industrialProcessing.gui.generating.GuiBuilderDefault;
import mod.industrialProcessing.gui.generating.IGuiBuilder;
import mod.industrialProcessing.plants.construction.machineBlock.RecipesUpgradeMachineBlock;
import mod.industrialProcessing.utils.block.IDescriptionBlock;
import mod.industrialProcessing.utils.block.IGuiBlock;
import mod.industrialProcessing.utils.block.IUpgradableBlock;
import mod.industrialProcessing.work.recipe.RecipesMachine;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockGenerator extends BlockPowerGenerator implements IGuiBlock, IDescriptionBlock,IUpgradableBlock {

    public static final String UNLOCALIZED_NAME = "IP.Machine.Generator";
    private static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).addLabeledGauge("Voltage", "%.2fV", 0).addLabeledGauge("Current", "%.2fA", 1).addLabeledGauge("Power", "%.2fW", 2);
    private static RecipesUpgradeGenerator upgradeRecipes;  
    private static IGuiBuilder gui = new GuiBuilderCrafting("Machine Block").addInputSlotCluster(1, 9, 3, Orientation.HORIZONTAL).setFillingSlot(5);

    public BlockGenerator() {
        super(1.0f,1.0f, Material.iron, Block.soundTypeMetal,"generatorFeatures", "tankSide");
    }

    @Override
    public String getDescription() {
        return "Convertes mechanical motion to electricity";
    }

    @Override
    public IGuiBuilder getGui() {
        return guiBuilder;
    }

	@Override
	public IGuiBuilder getUpgradeGui() {
		return gui;
	}

	@Override
	public RecipesMachine getUpgradeRecipes() {
		if(upgradeRecipes == null)
			upgradeRecipes = new RecipesUpgradeGenerator();
		return upgradeRecipes;
	}

	@Override
	public boolean isMachineUpgradable() {
		return true;
	}
}
