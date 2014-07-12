package ip.industrialProcessing.machines.plants.metalProcessing.vacuumCaster;

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

public class BlockVacuumCaster extends BlockMachineRendered implements IRecipeBlock, IGuiBlock, IDescriptionBlock {
    public static String UNLOCALIZED_NAME = "IP.Machine.VacuumCaster";
    private static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).addInputTank(0, 1, 2).addOutputSlot(0).enableWorker().enablePower(3);

    public BlockVacuumCaster() {
	super(ConfigMachineBlocks.getBlockVacuumCasterID(), Material.iron, 1f, Block.soundMetalFootstep, UNLOCALIZED_NAME, ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityVacuumCaster te = new TileEntityVacuumCaster();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererVacuumCasterId();
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntityVacuumCaster.recipes;
    }

    @Override
    public String getDescription() {
	return "Upgraded version of the sandcaster, can use more durable casts.";
    }

    @Override
    public IGuiBuilder getGui() {
	return guiBuilder;
    }

}
