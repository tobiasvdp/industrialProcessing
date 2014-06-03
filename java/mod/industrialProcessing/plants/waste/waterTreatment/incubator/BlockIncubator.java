package ip.industrialProcessing.machines.plants.waste.waterTreatment.incubator;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui3.generating.GuiBuilderDefault;
import ip.industrialProcessing.gui3.generating.IGuiBlock;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;
import ip.industrialProcessing.recipes.IRecipeBlock;
import ip.industrialProcessing.utils.IDescriptionBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockIncubator extends BlockMachineRendered implements IRecipeBlock, IDescriptionBlock, IGuiBlock {

    public static String UNLOCALIZED_NAME = "IP.Machine.Incubator";
    private static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).addInputSlot(0).addOutputSlot(1).enableWorker().enablePower(2);

    public BlockIncubator() {
	super(ConfigMachineBlocks.getIncubatorID(), Material.iron, 1F, Block.soundMetalFootstep, UNLOCALIZED_NAME, ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityIncubator te = new TileEntityIncubator();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return 0;
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntityMixer.recipes;
    }

    @Override
    public IGuiBuilder getGui() {
	return guiBuilder;
    }

    @Override
    public String getDescription() {
	return "An incubator is a device used to grow and maintain microbiological cultures or cell cultures.";
    }
}
