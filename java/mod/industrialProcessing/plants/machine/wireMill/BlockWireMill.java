package mod.industrialProcessing.plants.machine.wireMill;

import mod.industrialProcessing.gui.generating.GuiBuilderDefault;
import mod.industrialProcessing.gui.generating.IGuiBuilder;
import mod.industrialProcessing.utils.block.IDescriptionBlock;
import mod.industrialProcessing.utils.block.IGuiBlock;
import mod.industrialProcessing.utils.block.IRecipeBlock;
import mod.industrialProcessing.utils.creativeTab.ISetupCreativeTabs;
import mod.industrialProcessing.work.recipe.RecipesMachine;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockWireMill extends BlockMachineRendered implements IRecipeBlock, IDescriptionBlock, IGuiBlock {

	public static final String UNLOCALIZED_NAME = "IP.Machine.WireMill";
	public static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).addInputSlot(0).addOutputSlot(1).enablePower(2).enableWorker();

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
