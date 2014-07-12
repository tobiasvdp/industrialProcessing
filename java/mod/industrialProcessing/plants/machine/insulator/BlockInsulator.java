package ip.industrialProcessing.machines.insulator;

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

public class BlockInsulator extends BlockMachineRendered implements IRecipeBlock, IDescriptionBlock, IGuiBlock {

    private static final TextureReference WORKER_TEXTURE = TextureReference.createDefault("Worker.png", 24, 32);
    private static IGuiBuilder guiBuilder = new GuiBuilderDefault("Insulator").addInputSlot(0).addOutputSlot(1).addInputTank(0, 2, 3).enablePower(4).enableWorker(WORKER_TEXTURE);

    public BlockInsulator() {
	super(ConfigMachineBlocks.getInsulatorBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Insulator", ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityInsulator te = new TileEntityInsulator();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererInsulatorID();
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntityInsulator.recipes;
    }

    @Override
    public IGuiBuilder getGui() {
	return guiBuilder;
    }

    @Override
    public String getDescription() {
	return "Applies a layer of rubber or plastic insulation to a wire";
    }
}
