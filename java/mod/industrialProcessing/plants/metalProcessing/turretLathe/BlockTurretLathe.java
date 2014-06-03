package ip.industrialProcessing.machines.plants.metalProcessing.turretLathe;

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

public class BlockTurretLathe extends BlockMachineRendered implements IRecipeBlock, IDescriptionBlock, IGuiBlock {
    public static String UNLOCALIZED_NAME = "IP.Machine.SandCaster";
    private static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).addInputSlot(0).addOutputSlot(1).enableWorker().enablePower(2);

    public BlockTurretLathe() {
	super(ConfigMachineBlocks.getBlockTurretLatheID(), Material.iron, 1f, Block.soundMetalFootstep, "TurretLathe", ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityTurretLathe te = new TileEntityTurretLathe();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererTurretLatheId();
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntityTurretLathe.recipes;
    }

    @Override
    public IGuiBuilder getGui() { 
	return guiBuilder;
    }

    @Override
    public String getDescription() { 
	return "Lathe for precisely machining relatively hard materials.";
    }

}
