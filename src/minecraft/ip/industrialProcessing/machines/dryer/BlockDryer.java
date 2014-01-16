package ip.industrialProcessing.machines.dryer;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
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

public class BlockDryer extends BlockMachineRendered implements IRecipeBlock, IDescriptionBlock,IGuiLayout{

	public static GuiLayout guiLayout;
	static{
		guiLayout = new GuiLayout();
		guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsOutput).setSlotLayout(SlotLayoutType.horizontal, 1);
		guiLayout.addLayoutPanel(GuiLayoutPanelType.tankInput);
		guiLayout.addLayoutPanel(GuiLayoutPanelType.tankOutput);
		guiLayout.addLayoutPanel(GuiLayoutPanelType.worker);
		guiLayout.addLayoutPanel(GuiLayoutPanelType.power);
	}
	
	public BlockDryer() {
		super(ConfigMachineBlocks.getDryerBlockID(), Material.iron, 1f, Block.soundMetalFootstep, "Dryer", ISetupCreativeTabs.tabOreProcessing); 
	}

	@Override
	public TileEntity createNewTileEntity(World world) { 
		TileEntityDryer te = new TileEntityDryer();
		te.setName(getLocalizedName());
		return te;
	}

	
	@Override
	public int getRenderType() { 
		return ConfigRenderers.getRendererDryerId();
	}

	@Override
	public RecipesMachine getRecipes() { 
	    return TileEntityDryer.recipes;
	}

	@Override
	public GuiLayout getGuiLayout() {
		return guiLayout;
	}

	@Override
	public String getDescription() {
		return "Dries the sludge to purified chunks.";
	}
}
