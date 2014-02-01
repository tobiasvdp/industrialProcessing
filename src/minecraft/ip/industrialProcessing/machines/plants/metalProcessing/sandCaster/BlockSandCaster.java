package ip.industrialProcessing.machines.plants.metalProcessing.sandCaster;

import ip.industrialProcessing.api.rendering.IModelBlock;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui3.generating.GuiBuilderDefault;
import ip.industrialProcessing.gui3.generating.IGuiBlock;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.machines.kiln.model.ModelKilnBlock;
import ip.industrialProcessing.machines.plants.metalProcessing.sandCaster.model.ModelSandCasterBlock;
import ip.industrialProcessing.recipes.IRecipeBlock;
import ip.industrialProcessing.utils.IDescriptionBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSandCaster extends BlockMachineRendered implements IRecipeBlock, IGuiBlock, IDescriptionBlock, IModelBlock {
    public static String UNLOCALIZED_NAME = "IP.Machine.SandCaster";
    private static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).addInputSlot(0).addInputTank(0, 2, 3).addOutputSlot(1).enableWorker().enablePower(4);

    Icon[] icons = new Icon[4];

    public BlockSandCaster() {
	super(ConfigMachineBlocks.getBlockSandCasterID(), Material.iron, 1f, Block.soundMetalFootstep, UNLOCALIZED_NAME, ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	return new TileEntitySandCaster();
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererInterface();
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntitySandCaster.recipes;
    }

    @Override
    public Icon getIcon(int par1, int par2) {
	par1 %= icons.length;
	return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
	this.icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankFeatures");
	this.icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankSide");
	this.icons[2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "conveyorHopperFeatures");
	this.icons[3] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "powerFeatures");
    }

    @Override
    public String getDescription() {
	return "Cast metal objects in pre-formed sand casts.";
    }

    @Override
    public IGuiBuilder getGui() {
	return guiBuilder;
    }

    @SideOnly(Side.CLIENT)
    private static ModelSandCasterBlock model;

    @SideOnly(Side.CLIENT)
    @Override
    public ModelBlock getModel() {
	if (model == null)
	    model = new ModelSandCasterBlock();
	return model;
    }
}
