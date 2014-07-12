package ip.industrialProcessing.machines.pelletExtruder;

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
import ip.industrialProcessing.machines.pelletExtruder.model.ModelPelletExtruderBlock;
import ip.industrialProcessing.recipes.IRecipeBlock;
import ip.industrialProcessing.utils.IDescriptionBlock;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPelletExtruder extends BlockMachineRendered implements IRecipeBlock, IGuiBlock, IDescriptionBlock, IModelBlock {
    Icon[] icons = new Icon[3];
    public static final String UNLOCALIZED_NAME = "IP.Machine.PelletExtruder";
    private static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).addInputSlot(0).addOutputSlot(1).enableWorker().enablePower(2);

    public BlockPelletExtruder() {
	super(ConfigMachineBlocks.getPelletExtruderID(), Material.iron, 1F, Block.soundMetalFootstep, UNLOCALIZED_NAME, ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityPelletExtruder te = new TileEntityPelletExtruder();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntityPelletExtruder.recipes;
    }

    @Override
    public Icon getIcon(int par1, int par2) {
	par1 %= icons.length;
	return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
	this.icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "conveyorHopperFeatures");
	this.icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankSide");
	this.icons[2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "powerFeatures");
    }

    @Override
    public String getDescription() {
	return "Extrudes various materials into pellets";
    }

    @Override
    public IGuiBuilder getGui() {
	return guiBuilder;
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererInterface();
    }

    @SideOnly(Side.CLIENT)
    private static ModelPelletExtruderBlock model;

    @SideOnly(Side.CLIENT)
    @Override
    public ModelBlock getModel() {
	if (model == null)
	    model = new ModelPelletExtruderBlock();
	return model;
    }
}
