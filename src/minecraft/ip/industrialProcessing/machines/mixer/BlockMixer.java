package ip.industrialProcessing.machines.mixer;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;
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

public class BlockMixer extends BlockMachineRendered implements IRecipeBlock, IDescriptionBlock, IGuiBlock {

    private static final TextureReference WORKER_TEXTURE = TextureReference.createDefault("Mixer.png", 16, 36);
    public static IGuiBuilder guiBuilder = new GuiBuilderDefault("Mixer").addInputSlot(0).addInputTank(0, 1, 2).addOutputTank(1, 3, 4).enablePower(5).enableWorker(WORKER_TEXTURE);

    public BlockMixer() {
	super(ConfigMachineBlocks.getMixerBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Mixer", ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityMixer te = new TileEntityMixer();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererMixerId();
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
	return "Mixes liquids and solids together to form a slurry.";
    }

}
