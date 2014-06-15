package mod.industrialProcessing.plants.construction.weldingStation;

import javax.swing.Icon;

import mod.industrialProcessing.blockContainer.multiblock.core.BlockMultiblockCore;
import mod.industrialProcessing.blockContainer.multiblock.layout.StructureMultiblock;
import mod.industrialProcessing.gui.framework.panels.Orientation;
import mod.industrialProcessing.gui.framework.rendering.TextureReference;
import mod.industrialProcessing.gui.generating.GuiBuilderDefault;
import mod.industrialProcessing.gui.generating.IGuiBuilder;
import mod.industrialProcessing.utils.INamepace;
import mod.industrialProcessing.utils.block.IDescriptionMultiblock;
import mod.industrialProcessing.utils.block.IGuiBlock;
import mod.industrialProcessing.utils.block.IRecipeBlock;
import mod.industrialProcessing.utils.creativeTab.ISetupCreativeTabs;
import mod.industrialProcessing.work.recipe.RecipesMultiblock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockWeldingStation extends BlockMultiblockCore implements IRecipeBlock, IDescriptionMultiblock, IGuiBlock {

    private static TextureReference WORKER_TEXTURE = TextureReference.createDefault("Welding Station.png", 21, 32);
    public static IGuiBuilder guiBuilder = new GuiBuilderDefault("Welding Station").addInputSlotCluster(0, 9, 3, Orientation.HORIZONTAL).addOutputSlot(9).enableThermometer().enableWorker(WORKER_TEXTURE).enableBurner(10, 11, -1);

    public BlockWeldingStation() {
	super(1.0f,1.0f,Material.wood,Block.soundTypeWood,"Planks2","Stone","Planks2","crafting_table_front");
    }

    @Override
    public RecipesMultiblock getRecipes() {
	return TileEntityWeldingStation.recipes;
    }

    @Override
    public IGuiBuilder getGui() {
	return guiBuilder;
    }

    @Override
    public String getDescription() {
	return "Assembly time";
    }

	@Override
	public StructureMultiblock getStructure() {
		return TileEntityWeldingStation.structure;
	}
}
