package ip.industrialProcessing.multiblock.core.block.weldingStation;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.IGuiLayout;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;
import ip.industrialProcessing.multiblock.recipes.IRecipeMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.recipes.IRecipeBlock;
import ip.industrialProcessing.utils.IDescriptionBlock;

public class BlockMultiblockWeldingStation extends BlockMultiblockCore implements IRecipeMultiblock, IDescriptionBlock,IGuiLayout {

	public static GuiLayout guiLayout;
	static{
		guiLayout = new GuiLayout();
		guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsInput).setSlotLayout(SlotLayoutType.rectangle, 9);
		guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsOutput).setSlotLayout(SlotLayoutType.horizontal, 1);
		guiLayout.addLayoutPanel(GuiLayoutPanelType.heat);
		guiLayout.addLayoutPanel(GuiLayoutPanelType.worker);
	}
	private Icon[] icons = new Icon[4];

	public BlockMultiblockWeldingStation() {
		super(ConfigMachineBlocks.getBLmultiblockWeldingStation(), "BLmultiblockWeldingStation", IndustrialProcessing.tabMultiblocks);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityMultiblockWeldingStation();
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getBLmultiblockWeldingStation();
	}

	@Override
	public RecipesMultiblock getRecipes() {
		return TileEntityMultiblockWeldingStation.recipes;
	}
	
    @Override
    public Icon getIcon(int par1, int par2) {
        par1 %= icons.length;        
        return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        icons [0] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "Planks2");
        icons [1] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "Stone");
        icons [2] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "Planks2");
        icons [3] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "crafting_table_front");
    }

	@Override
	public GuiLayout getGuiLayout() {
		return guiLayout;
	}

	@Override
	public String getDescription() {
		return "Assembly time";
	}
}
