package ip.industrialProcessing.machines.filter;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.IGuiLayout;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.IRecipeBlock;
import ip.industrialProcessing.utils.IDescriptionBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockFilter extends BlockMachineRendered implements IRecipeBlock, IDescriptionBlock,IGuiLayout {

    private Icon[] textures;
    
	public static GuiLayout guiLayout;
	static{
		guiLayout = new GuiLayout();
		guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsInput).setSlotLayout(SlotLayoutType.horizontal, 1);
		guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsOutput).setSlotLayout(SlotLayoutType.vertical, 2);
		guiLayout.addLayoutPanel(GuiLayoutPanelType.worker);
		guiLayout.addLayoutPanel(GuiLayoutPanelType.power);
	}

    public BlockFilter() {
	super(ConfigMachineBlocks.getFilterBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Ore Filter", ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererFilterId();
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityFilter te = new TileEntityFilter();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public RecipesMachine getRecipes() { 
	return TileEntityFilter.recipes;
    }

	@Override
	public GuiLayout getGuiLayout() {
		return guiLayout;
	}

	@Override
	public String getDescription() {
		return "This machine seperates small and larger chunks from materials.";
	}
}
