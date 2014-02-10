package ip.industrialProcessing.machines.plants.nonFerroProcessing.magneticSeparator;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
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

public class BlockMagneticSeparator extends BlockMachineRendered implements IRecipeBlock, IDescriptionBlock, IGuiBlock {
    public static String UNLOCALIZED_NAME = "IP.Machine.MagneticSeparator";
    private static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).addInputSlot(0).addOutputSlotCluster(1, 4, 4, Orientation.HORIZONTAL).enableWorker().enablePower(5);

    public BlockMagneticSeparator() {
	super(ConfigMachineBlocks.getMagneticSeparatorBlockID(), Material.iron, 1F, Block.soundMetalFootstep, UNLOCALIZED_NAME, ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityMagneticSeparator te = new TileEntityMagneticSeparator();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererMagneticSeperatorId();
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntityMagneticSeparator.recipes;
    }

    @Override
    public IGuiBuilder getGui() {
	return guiBuilder;
    }

    @Override
    public String getDescription() {
	return "Susceptible materials are extracted from a mixture using a magnetic force.";
    }
}
