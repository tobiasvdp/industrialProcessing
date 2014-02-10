package ip.industrialProcessing.machines.plants.nonFerroProcessing.smelter;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui3.generating.GuiBuilderDefault;
import ip.industrialProcessing.gui3.generating.IGuiBlock;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.IRecipeBlock;
import ip.industrialProcessing.utils.IDescriptionBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSmelter extends BlockMachineRendered implements IRecipeBlock, IDescriptionBlock, IGuiBlock {
    public static String UNLOCALIZED_NAME = "IP.Machine.Smelter";
    private static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).addInputSlot(0).enableWorker().addOutputTank(0, 1, 2).enableThermometer();

    public BlockSmelter() {
	super(ConfigMachineBlocks.getBlockSmelterID(), Material.iron, 1f, Block.soundMetalFootstep, UNLOCALIZED_NAME, ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntitySmelter te = new TileEntitySmelter();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererSmelterId();
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntitySmelter.recipes;
    }

    @Override
    public IGuiBuilder getGui() { 
	return guiBuilder;
    }

    @Override
    public String getDescription() { 
	return "Smelts metals to their liquid forms.";
    }

}
