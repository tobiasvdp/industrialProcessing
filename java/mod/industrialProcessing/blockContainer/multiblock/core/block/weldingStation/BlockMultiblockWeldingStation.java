package ip.industrialProcessing.multiblock.core.block.weldingStation;

import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;
import ip.industrialProcessing.gui3.generating.GuiBuilderDefault;
import ip.industrialProcessing.gui3.generating.IGuiBlock;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.recipes.IRecipeBlock;
import ip.industrialProcessing.utils.IDescriptionBlock;

import javax.swing.Icon;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMultiblockWeldingStation extends BlockMultiblockCore implements IRecipeBlock, IDescriptionBlock, IGuiBlock {

    private static TextureReference WORKER_TEXTURE = TextureReference.createDefault("Welding Station.png", 21, 32);

    public static IGuiBuilder guiBuilder = new GuiBuilderDefault("Welding Station").addInputSlotCluster(0, 9, 3, Orientation.HORIZONTAL).addOutputSlot(9).enableThermometer().enableWorker(WORKER_TEXTURE).enableBurner(10, 11, -1);

    private Icon[] icons = new Icon[4];

    public BlockMultiblockWeldingStation() {
	super(ConfigMachineBlocks.getBLmultiblockWeldingStation(), "BLmultiblockWeldingStation", ISetupCreativeTabs.tabMultiblocks);
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
	icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Planks2");
	icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Stone");
	icons[2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Planks2");
	icons[3] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "crafting_table_front");
    }

    @Override
    public IGuiBuilder getGui() {
	return guiBuilder;
    }

    @Override
    public String getDescription() {
	return "Assembly time";
    }
}
