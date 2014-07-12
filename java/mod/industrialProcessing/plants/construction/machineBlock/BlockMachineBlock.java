package mod.industrialProcessing.plants.construction.machineBlock;

import java.util.Random;

import mod.industrialProcessing.blockContainer.BlockContainerIPRendered;
import mod.industrialProcessing.gui.framework.panels.Orientation;
import mod.industrialProcessing.gui.generating.GuiBuilderCrafting;
import mod.industrialProcessing.gui.generating.IGuiBuilder;
import mod.industrialProcessing.utils.block.IGuiBlock;
import mod.industrialProcessing.utils.block.IUpgradableBlock;
import mod.industrialProcessing.work.recipe.RecipesMachine;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMachineBlock extends BlockContainerIPRendered implements IUpgradableBlock{
	
	private static RecipesUpgradeMachineBlock upgradeRecipes;  
	private static IGuiBuilder gui = new GuiBuilderCrafting("Machine Block").addInputSlotCluster(1, 9, 3, Orientation.HORIZONTAL).setFillingSlot(5);
	
	public BlockMachineBlock() {
		super(1f,1f, Material.iron,Block.soundTypeMetal,"Orange","Iron");
		
	}
		
	@Override
	public int quantityDropped(Random p_149745_1_) {
		return 0;
	}

	@Override
	public IGuiBuilder getUpgradeGui() {
		return gui;
	}

	@Override
	public RecipesMachine getUpgradeRecipes() {
		if(upgradeRecipes == null)
			upgradeRecipes = new RecipesUpgradeMachineBlock();
		return upgradeRecipes;
	}

	@Override
	public boolean isMachineUpgradable() {
		return true;
	}
}
