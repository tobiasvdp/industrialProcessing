package ip.industrialProcessing.machines.kiln;

import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.api.rendering.IModelBlock;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.IGuiLayout;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;
import ip.industrialProcessing.gui3.generating.GuiBuilderDefault;
import ip.industrialProcessing.gui3.generating.IGuiBlock;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.machines.kiln.model.ModelKilnBlock;
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

public class BlockKiln extends BlockMachineRendered implements IRecipeBlock, IDescriptionBlock, IGuiBlock, IModelBlock {

    private static final TextureReference WORKER_TEXTURE = TextureReference.createDefault("Kiln.png", 24, 32);
    private Icon[] icons = new Icon[3];
    private static IGuiBuilder guiBuilder = new GuiBuilderDefault("Kiln").addInputSlot(0).addOutputSlot(1).enableThermometer().enableWorker(WORKER_TEXTURE);

    public BlockKiln() {
	super(ConfigMachineBlocks.getKilnBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Kiln", ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityKiln te = new TileEntityKiln();
	te.setName(this.getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererInterface();
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntityKiln.recipes;
    }

    @Override
    public Icon getIcon(int par1, int par2) {
	par1 %= icons.length;
	return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
	icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "conveyorHopperFeatures");
	icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankSide");
	icons[2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "burnerGrill");
    }

    @Override
    public String getDescription() {
	return "Boils water to steam.";
    }

    @Override
    public IGuiBuilder getGui() {
	return guiBuilder;
    }

    @SideOnly(Side.CLIENT)
    private static ModelKilnBlock model;

    @SideOnly(Side.CLIENT)
    @Override
    public ModelBlock getModel() {
	if(model == null) model = new ModelKilnBlock();
	return model;
    }
}
