package ip.industrialProcessing.machines.thickener;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.IGuiLayout;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.IRecipeBlock;
import ip.industrialProcessing.utils.IDescriptionBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockThickener extends BlockMachineRendered implements IRecipeBlock, IDescriptionBlock,IGuiLayout{

	public static GuiLayout guiLayout;
	static{
		guiLayout = new GuiLayout();
		guiLayout.addLayoutPanel(GuiLayoutPanelType.tankInput);
		guiLayout.addLayoutPanel(GuiLayoutPanelType.tankOutput);
		guiLayout.addLayoutPanel(GuiLayoutPanelType.tankOutput);
		guiLayout.addLayoutPanel(GuiLayoutPanelType.worker);
		guiLayout.addLayoutPanel(GuiLayoutPanelType.power);
	}
	public BlockThickener() {
		super(ConfigMachineBlocks.getThickenerBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Thickener", ISetupCreativeTabs.tabOreProcessing);

	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		TileEntityThickener te = new TileEntityThickener();
		te.setName(getLocalizedName());
		return te;
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererThickenerId();
	}

	@Override
	public RecipesMachine getRecipes() { 
	    return TileEntityThickener.recipes;
	}

	@Override
	public GuiLayout getGuiLayout() {
		return guiLayout;
	}

	@Override
	public String getDescription() {
		return "Thickens or something";
	}
}
