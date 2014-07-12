package mod.industrialProcessing.plants.construction.solderingStation;

import mod.industrialProcessing.blockContainer.multiblock.core.BlockMultiblockCore;
import mod.industrialProcessing.blockContainer.multiblock.layout.StructureMultiblock;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.gui.framework.panels.Orientation;
import mod.industrialProcessing.gui.generating.GuiBuilderDefault;
import mod.industrialProcessing.gui.generating.IGuiBuilder;
import mod.industrialProcessing.utils.block.IDescriptionMultiblock;
import mod.industrialProcessing.utils.block.IGuiMultiblock;
import mod.industrialProcessing.utils.block.IRecipeBlock;
import mod.industrialProcessing.work.recipe.RecipesMultiblock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockSolderingStation extends BlockMultiblockCore implements IRecipeBlock, IDescriptionMultiblock, IGuiMultiblock {

	static IGuiBuilder gui = new GuiBuilderDefault("Soldering Station").addInputSlotCluster(0, 3, 1, Orientation.VERTICAL).addInputSlot(3).addOutputSlot(4).enableWorker().enableBurner(5, 6, -1).enableThermometer();

    public BlockSolderingStation() {
	super(1.0f,1.0f,Material.wood,Block.soundTypeWood,"Planks2","Stone","Iron","Canvas","tile.IP.block.limestone");
    }


    @Override
    public String getDescription() {
	return "Solder away";
    }

    @Override
    public RecipesMultiblock getRecipes() {
	return TileEntitySolderingStation.recipes;
    }

	@Override
	public IGuiBuilder getGui(Tiers tier) {
		return gui;
	}

	@Override
	public StructureMultiblock getStructure() {
		return TileEntitySolderingStation.structure;
	}

}
