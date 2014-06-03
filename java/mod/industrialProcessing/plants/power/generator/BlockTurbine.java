package mod.industrialProcessing.plants.power.generator;

import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui3.generating.GuiBuilderDefault;
import ip.industrialProcessing.gui3.generating.IGuiBlock;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.recipes.IMachineRecipes;
import ip.industrialProcessing.recipes.IRecipeBlock;
import ip.industrialProcessing.utils.IDescriptionBlock;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockTurbine extends BlockMachineRendered implements IDescriptionBlock, IGuiBlock, IRecipeBlock {
    public static final String UNLOCALIZED_NAME = "IP.Machine.Turbine";
    private static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).addInputTank(1).addGauge("RPM", "%.0fRPM", 0).addOutputTank(0, 0, 1);

    public BlockTurbine() {
	super(ConfigMachineBlocks.getSteamTurbineBlockID(), Material.iron, 1F, Block.soundMetalFootstep, UNLOCALIZED_NAME, ISetupCreativeTabs.tabPower);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	return new TileEntityTurbine();
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererTurbineId();
    }

    Icon[] icons = new Icon[2];

    @Override
    public Icon getIcon(int par1, int par2) {
	par1 %= icons.length;
	return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
	icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankSide");
	icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankFeatures");
    }

    @Override
    public IMachineRecipes getRecipes() {
	return TileEntityTurbine.recipes;
    }

    @Override
    public IGuiBuilder getGui() {
	return guiBuilder;
    }

    @Override
    public String getDescription() {
	return "A rotary mechanical device that extracts energy from a fluid flow and converts it into mechanical motion.";
    }
}
