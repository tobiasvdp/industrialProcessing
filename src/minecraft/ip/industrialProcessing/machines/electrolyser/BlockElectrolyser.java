package ip.industrialProcessing.machines.electrolyser;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;
import ip.industrialProcessing.gui3.generating.GuiBuilderDefault;
import ip.industrialProcessing.gui3.generating.IGuiBlock;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.IRecipeBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockElectrolyser extends BlockMachineRendered implements IRecipeBlock, IGuiBlock {

    private static final TextureReference WORKER_TEXTURE = new TextureReference(new Size(24, 32), IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/Worker.png");
    private static IGuiBuilder guiBuilder = new GuiBuilderDefault("Electrolyser").enablePower(0).addInputTank(0).addInputTank(1).enableWorker(WORKER_TEXTURE).addOutputTank(2).addOutputTank(3).addOutputSlot(0);

    public BlockElectrolyser() {
	super(ConfigMachineBlocks.getElectrolyserBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Electrolyser", ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityElectrolyser te = new TileEntityElectrolyser();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererElectrolyserId();
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntityElectrolyser.recipes;
    }

    @Override
    public IGuiBuilder getGui() { 
	return guiBuilder;
    }
}
