package ip.industrialProcessing.machines.plants.waste.waterTreatment.tricklingFilter;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.IGuiLayout;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.IRecipeBlock;
import ip.industrialProcessing.utils.IDescriptionBlock;

public class BlockTricklingFilter extends BlockMachineRendered  implements IRecipeBlock, IDescriptionBlock,IGuiLayout{

	public static GuiLayout guiLayout;
	static{
		guiLayout = new GuiLayout();
		guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsInput).setSlotLayout(SlotLayoutType.horizontal, 1);
		guiLayout.addLayoutPanel(GuiLayoutPanelType.tankInput);
		guiLayout.addLayoutPanel(GuiLayoutPanelType.tankOutput);
		guiLayout.addLayoutPanel(GuiLayoutPanelType.worker);
		guiLayout.addLayoutPanel(GuiLayoutPanelType.power);
	}
    public BlockTricklingFilter() {
	super(ConfigMachineBlocks.getTricklingFilterID(), Material.iron, 1F, Block.soundMetalFootstep, "TricklingFilter", ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityTricklingFilter te = new TileEntityTricklingFilter();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return 0;
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntityTricklingFilter.recipes;
    }

	@Override
	public GuiLayout getGuiLayout() {
		return guiLayout;
	}

	@Override
	public String getDescription() {
		return "Drip drip drip";
	}
}
