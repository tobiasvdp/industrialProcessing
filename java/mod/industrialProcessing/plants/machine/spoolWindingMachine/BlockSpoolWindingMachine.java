package ip.industrialProcessing.machines.spoolWindingMachine;

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

public class BlockSpoolWindingMachine extends BlockMachineRendered implements IRecipeBlock, IDescriptionBlock, IGuiBlock {

    public static final String UNLOCALIZED_NAME = "IP.Machine.SpoolWinder";
    private static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).addInputSlotCluster(0, 2, 2, Orientation.HORIZONTAL).addOutputSlot(2).enableWorker().enablePower(3);

    public BlockSpoolWindingMachine() {
	super(ConfigMachineBlocks.getSpoolWindingMachineBlockID(), Material.iron, 1F, Block.soundMetalFootstep, UNLOCALIZED_NAME, ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntitySpoolWindingMachine te = new TileEntitySpoolWindingMachine();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererSpoolWindingMachineID();
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntitySpoolWindingMachine.recipes;
    }

    @Override
    public IGuiBuilder getGui() {
	return guiBuilder;
    }

    @Override
    public String getDescription() {
	return "Automates the winding of coils and spools";
    }
}
