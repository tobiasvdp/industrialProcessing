package ip.industrialProcessing.machines.plants.metalProcessing.extruder;

import ip.industrialProcessing.api.rendering.IModelBlock;
import ip.industrialProcessing.client.render.ModelBlock;
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
import ip.industrialProcessing.machines.plants.metalProcessing.extruder.model.ModelExtruderBlock;
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

public class BlockExtruder extends BlockMachineRendered implements IRecipeBlock, IModelBlock, IDescriptionBlock, IGuiLayout {
    private static GuiLayout guiLayout;
    private Icon[] icons = new Icon[4];
    static {
	guiLayout = new GuiLayout();
	guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsOutput).setSlotLayout(SlotLayoutType.horizontal, 1);
	guiLayout.addLayoutPanel(GuiLayoutPanelType.tankInput);
	guiLayout.addLayoutPanel(GuiLayoutPanelType.worker);
	guiLayout.addLayoutPanel(GuiLayoutPanelType.power);
    }
    
    public BlockExtruder() {
	super(ConfigMachineBlocks.getExtruderID(), Material.iron, 1f, Block.soundMetalFootstep, "Extruder", ISetupCreativeTabs.tabOreProcessing);
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
    public GuiLayout getGuiLayout() {
	return guiLayout;
    }
    
    @SideOnly(Side.CLIENT)
    private static ModelExtruderBlock model = new ModelExtruderBlock();

    @SideOnly(Side.CLIENT)
    @Override
    public ModelBlock getModel() {
	return model;
    }
}
