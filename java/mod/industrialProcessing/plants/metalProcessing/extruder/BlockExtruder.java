package ip.industrialProcessing.machines.plants.metalProcessing.extruder;

import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.api.rendering.IModelBlock;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui3.generating.GuiBuilderDefault;
import ip.industrialProcessing.gui3.generating.IGuiBlock;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.machines.plants.metalProcessing.extruder.model.ModelExtruderBlock;
import ip.industrialProcessing.recipes.IRecipeBlock;
import ip.industrialProcessing.utils.IDescriptionBlock;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockExtruder extends BlockMachineRendered implements IRecipeBlock, IModelBlock, IDescriptionBlock, IGuiBlock {
    public static String UNLOCALIZED_NAME = "IP.Machine.Extruder";
    private static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).addInputTank(0, 1, 2).addOutputSlot(0).enableWorker().enablePower(3);

    private Icon[] icons = new Icon[4];

    public BlockExtruder() {
	super(ConfigMachineBlocks.getExtruderID(), Material.iron, 1f, Block.soundMetalFootstep, UNLOCALIZED_NAME, ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityExtruder te = new TileEntityExtruder();
	te.setName(getLocalizedName());
	return te;
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
    public int getRenderType() {
	return ConfigRenderers.getRendererInterface();
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntityExtruder.recipes;
    }

    @Override
    public String getDescription() {
	return "Extrudes various materials into bars, rods, beams, ...";
    }

    @Override
    public IGuiBuilder getGui() {
	return guiBuilder;
    }

    @SideOnly(Side.CLIENT)
    private static ModelExtruderBlock model;

    @SideOnly(Side.CLIENT)
    @Override
    public ModelBlock getModel() {
	if (model == null)
	    model = new ModelExtruderBlock();
	return model;
    }
}
