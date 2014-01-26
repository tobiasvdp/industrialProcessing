package ip.industrialProcessing.machines.plants.nonFerroProcessing.magneticSeparator;

import org.apache.commons.io.filefilter.MagicNumberFileFilter;

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
import net.minecraft.world.World;

public class BlockMagneticSeparator extends BlockMachineRendered implements IRecipeBlock, IDescriptionBlock, IGuiLayout {

    private static GuiLayout guiLayout;

    static {
	guiLayout = new GuiLayout();
	guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsInput).setSlotLayout(SlotLayoutType.horizontal, 1); 
	guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsOutput).setSlotLayout(SlotLayoutType.vertical, 4); 
	guiLayout.addLayoutPanel(GuiLayoutPanelType.worker);
	guiLayout.addLayoutPanel(GuiLayoutPanelType.power);
    }
    public BlockMagneticSeparator() {
	super(ConfigMachineBlocks.getMagneticSeparatorBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Magnetic Ore Separator", ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityMagneticSeparator te = new TileEntityMagneticSeparator();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererMagneticSeperatorId();
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntityMagneticSeparator.recipes;
    }

    @Override
    public GuiLayout getGuiLayout() { 
	return guiLayout;
    }

    @Override
    public String getDescription() { 
	return "Seperates components from dusts";
    }
}
