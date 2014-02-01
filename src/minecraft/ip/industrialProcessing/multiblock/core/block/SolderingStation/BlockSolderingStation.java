package ip.industrialProcessing.multiblock.core.block.SolderingStation;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.IGuiLayoutMultiblock;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.recipes.IRecipeBlock;
import ip.industrialProcessing.utils.IDescriptionBlock;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockSolderingStation extends BlockMultiblockCore implements IRecipeBlock, IDescriptionBlock, IGuiLayoutMultiblock {

    public static GuiLayout[] guiLayout = new GuiLayout[1];
    static {
	guiLayout[0] = new GuiLayout();
	guiLayout[0].addLayoutPanel(GuiLayoutPanelType.slotsInput).setSlotLayout(SlotLayoutType.vertical, 3);
	guiLayout[0].addLayoutPanel(GuiLayoutPanelType.slotsInput).setSlotLayout(SlotLayoutType.horizontal, 1);
	guiLayout[0].addLayoutPanel(GuiLayoutPanelType.slotsOutput).setSlotLayout(SlotLayoutType.horizontal, 1);
	guiLayout[0].addLayoutPanel(GuiLayoutPanelType.heat);
	guiLayout[0].addLayoutPanel(GuiLayoutPanelType.worker);
    }
    private Icon[] icons = new Icon[5];

    public BlockSolderingStation() {
	super(ConfigMachineBlocks.getBlockSolderingStationID(), "BlockSolderingStation", ISetupCreativeTabs.tabMultiblocks);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	return new TileEntitySolderingStation();
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererSolderingStation();
    }

    @Override
    public Icon getIcon(int par1, int par2) {
	par1 %= icons.length;
	return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
	icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Planks2");
	icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Stone");
	icons[2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Iron");
	icons[3] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Canvas");
	icons[4] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "blockLimestone");
    }

    @Override
    public String getDescription() {
	return "Solder away";
    }

    @Override
    public RecipesMultiblock getRecipes() {
	return TileEntitySolderingStation.recipes;
    }

    @Override
    public GuiLayout getGuiLayout(Tiers tier) {
	return guiLayout[tier.ordinal()];
    }

    @Override
    public GuiLayout[] getGuiLayouts() {
	return guiLayout;
    }

    @Override
    public StructureMultiblock getMultiblockLayouts() {
	return null;
    }

}
