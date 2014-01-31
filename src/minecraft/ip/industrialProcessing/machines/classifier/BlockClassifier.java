package ip.industrialProcessing.machines.classifier;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui3.framework.Size;
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
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockClassifier extends BlockMachineRendered implements IRecipeBlock, IDescriptionBlock, IGuiBlock {
    private static final TextureReference WORKER_TEXTURE = TextureReference.createDefault("Classifier.png", 24, 32);
    private Icon[] icons = new Icon[4];
    public static IGuiBuilder guiBuilder = new GuiBuilderDefault("Spiral Classifier").addInputSlot(0).addOutputSlot(1).addInputTank(0, 2, 3).addOutputTank(1, 4, 5).enableWorker(WORKER_TEXTURE).enablePower(6);

    public BlockClassifier() {
	super(ConfigMachineBlocks.getClassifierBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Spiral Classifier", ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	return new TileEntityClassifier();
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererClassifierId();
    }

    @Override
    public Icon getIcon(int par1, int par2) {
	par1 %= icons.length;
	return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
	this.icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankSide");
	this.icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "conveyorHopperFeatures");
	this.icons[2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "powerFeatures");
	this.icons[3] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankFeatures");
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntityClassifier.recipes;
    }

    @Override
    public IGuiBuilder getGui() {
	return guiBuilder;
    }

    @Override
    public String getDescription() {
	return "Separate some solid components from a slurry, based upon a combination of the solid particle density.d";
    }
}
