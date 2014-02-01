package ip.industrialProcessing.machines.wireMill;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui3.generating.GuiBuilderDefault;
import ip.industrialProcessing.gui3.generating.IGuiBlock;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.IRecipeBlock;
import ip.industrialProcessing.utils.IDescriptionBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockWireMill extends BlockMachineRendered implements IRecipeBlock, IDescriptionBlock, IGuiBlock {

    public static final String UNLOCALIZED_NAME = "IP.Machine.WireMill";
    private static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).addOutputTank(0, 0, 1);

    public BlockWireMill() {
	super(ConfigMachineBlocks.getWireMillBlockID(), Material.iron, 1F, Block.soundMetalFootstep, UNLOCALIZED_NAME, ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityWireMill te = new TileEntityWireMill();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererWireMillId();
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntityWireMill.recipes;
    }

    @Override
    public IGuiBuilder getGui() {
	return guiBuilder;
    }

    @Override
    public String getDescription() {
	return "Automates the process of drawing wires";
    }
}
