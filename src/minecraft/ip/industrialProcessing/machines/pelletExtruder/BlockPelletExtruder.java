package ip.industrialProcessing.machines.pelletExtruder;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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
import ip.industrialProcessing.machines.pelletExtruder.model.ModelPelletExtruderBlock;
import ip.industrialProcessing.recipes.IRecipeBlock;
import ip.industrialProcessing.utils.IDescriptionBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockPelletExtruder extends BlockMachineRendered implements IRecipeBlock, IGuiLayout, IDescriptionBlock, IModelBlock {
    Icon[] icons = new Icon[3];
    private static GuiLayout guiLayout;
    static {
	guiLayout = new GuiLayout();
	guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsInput).setSlotLayout(SlotLayoutType.horizontal, 1);
	guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsOutput).setSlotLayout(SlotLayoutType.horizontal, 1);
	guiLayout.addLayoutPanel(GuiLayoutPanelType.worker);
	guiLayout.addLayoutPanel(GuiLayoutPanelType.power);
    }

    public BlockPelletExtruder() {
	super(ConfigMachineBlocks.getPelletExtruderID(), Material.iron, 1F, Block.soundMetalFootstep, "Pellet Extruder", ISetupCreativeTabs.tabOreProcessing);
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
    public GuiLayout getGuiLayout() {
	return guiLayout;
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererInterface();
    }

    @SideOnly(Side.CLIENT)
    private static ModelPelletExtruderBlock model = new ModelPelletExtruderBlock();

    @SideOnly(Side.CLIENT)
    @Override
    public ModelBlock getModel() {
	return model;
    }
}
