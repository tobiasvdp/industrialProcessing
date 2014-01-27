package ip.industrialProcessing.multiblock.core.block.blastFurnace;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.IGuiLayout;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;
import ip.industrialProcessing.multiblock.recipes.IRecipeMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;

public class BLmultiblockBlastFurnace extends BlockMultiblockCore implements IRecipeMultiblock, IGuiLayout{
    Icon[] icons = new Icon[6];
    
    private static GuiLayout layout;
    static{
    	layout = new GuiLayout();
    	layout.addLayoutPanel(GuiLayoutPanelType.slotsInput).setSlotLayout(SlotLayoutType.vertical, 2);
    	layout.addLayoutPanel(GuiLayoutPanelType.tankInput);
    	layout.addLayoutPanel(GuiLayoutPanelType.tankOutput);
    	layout.addLayoutPanel(GuiLayoutPanelType.tankOutput);
    	layout.addLayoutPanel(GuiLayoutPanelType.tankOutput);
    	layout.addLayoutPanel(GuiLayoutPanelType.worker);
    }

    public BLmultiblockBlastFurnace() {
	super(ConfigMachineBlocks.getBLmultiblockBlastFurnace(), "BLmultiblockBlastFurnace", ISetupCreativeTabs.tabMultiblocks);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	return new TEmultiblockBlastFurnace();
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getrendererMultiblockBlastFurnaceID();
    }

    @Override
    public Icon getIcon(int par1, int par2) {
	return icons[par1 % icons.length];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "MachineConnectorFiller");
        icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankSide");
        icons[2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "conveyorHopperFeatures");
        icons[3] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "fluidFeatures");
        icons[4] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "grill");
        icons[5] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "generatorFeatures");
    }

	@Override
	public RecipesMultiblock getRecipes() {
		return TEmultiblockBlastFurnace.recipes;
	}

	@Override
	public GuiLayout getGuiLayout() {
		return layout;
	}
}
