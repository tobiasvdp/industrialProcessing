package ip.industrialProcessing.machines.oxygenFurnace;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui3.generating.GuiBuilderDefault;
import ip.industrialProcessing.gui3.generating.IGuiBlock;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.IRecipeBlock;
import ip.industrialProcessing.utils.IDescriptionBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockOxygenFurnace extends BlockMachine implements IRecipeBlock, IGuiBlock, IDescriptionBlock {

    private static final String UNLOCALIZED_NAME = "IP.OxygenFurnace";
    private static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).addInputTank(0, 0, 1).addInputTank(1).addOutputTank(2, 2, 3).enablePower(4);

    public BlockOxygenFurnace() {
	super(ConfigMachineBlocks.getOxygenFurnaceID(), Material.iron, 1F, Block.soundMetalFootstep, UNLOCALIZED_NAME, ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityOxygenFurnace te = new TileEntityOxygenFurnace();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntityOxygenFurnace.recipes;
    }

    @Override
    public String getDescription() {
	return "Production of steel from molten pig iron";
    }

    @Override
    public IGuiBuilder getGui() {
	return guiBuilder;
    }

}
