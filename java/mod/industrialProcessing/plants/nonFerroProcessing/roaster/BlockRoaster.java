package ip.industrialProcessing.machines.plants.nonFerroProcessing.roaster;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui3.generating.GuiBuilderDefault;
import ip.industrialProcessing.gui3.generating.IGuiBlock;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.machines.plants.nonFerroProcessing.quenchTank.TileEntityQuenchTank;
import ip.industrialProcessing.recipes.IRecipeBlock;
import ip.industrialProcessing.utils.IDescriptionBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockRoaster extends BlockMachineRendered implements IRecipeBlock, IGuiBlock, IDescriptionBlock {
    public static String UNLOCALIZED_NAME = "IP.Machine.Roaster";
    private static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).addInputSlot(0).addOutputSlot(1).enableWorker().addInputTank(0).addOutputTank(1).enableThermometer();

    public BlockRoaster() {
	super(ConfigMachineBlocks.getBlockRoasterID(), Material.iron, 1f, Block.soundMetalFootstep, UNLOCALIZED_NAME, ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityRoaster te = new TileEntityRoaster();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererRoasterId();
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntityQuenchTank.recipes;
    }

    @Override
    public String getDescription() {
	return "Roasting is a metallurgical process involving gas–solid reactions at elevated temperatures with the goal of purifying the metal components.";
    }

    @Override
    public IGuiBuilder getGui() {
	return guiBuilder;
    }
}
