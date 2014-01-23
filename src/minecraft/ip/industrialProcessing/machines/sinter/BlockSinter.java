package ip.industrialProcessing.machines.sinter;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.IGuiLayout;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.IRecipeBlock;
import ip.industrialProcessing.utils.IDescriptionBlock;

public class BlockSinter extends BlockMachineRendered implements IRecipeBlock, IDescriptionBlock, IGuiLayout {
    private Icon[] icons = new Icon[4];

    private static GuiLayout guiLayout;
    static 
    {
	guiLayout = new GuiLayout();
	guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsInput).setSlotLayout(SlotLayoutType.horizontal, 2);
	guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsOutput).setSlotLayout(SlotLayoutType.horizontal, 1);
	guiLayout.addLayoutPanel(GuiLayoutPanelType.worker);
	guiLayout.addLayoutPanel(GuiLayoutPanelType.power);
    }
    
    public BlockSinter() {
	super(ConfigMachineBlocks.getSinterBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Sinter", ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	return new TileEntitySinter();
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererSinterId();
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntitySinter.recipes;
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
	this.icons[2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "machineControls");
	this.icons[3] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "powerFeatures");
    }

    @Override
    public GuiLayout getGuiLayout() { 
	return guiLayout;
    }

    @Override
    public String getDescription() { 
	return "Agglomerates iron dust with fine calcious materials at high temperature, to create a product that can be used in a blast furnace.";
    }
}
