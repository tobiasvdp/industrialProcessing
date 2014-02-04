package ip.industrialProcessing.subMod.blackSmith.plant.grindingStone;

import ip.industrialProcessing.api.config.INamepace;
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
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockGrindingStone extends BlockMachineRendered implements IRecipeBlock, IDescriptionBlock, IGuiBlock {
    public static String UNLOCALIZED_NAME = "IP.Machine.Grindstone";
    private static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).addInputSlot(0).addOutputSlot(1).enableWorker();

    private Icon[] icons = new Icon[1];

    public BlockGrindingStone() {
	super(ConfigMachineBlocks.getBlockGrindingStoneID(), Material.iron, 1F, Block.soundMetalFootstep, UNLOCALIZED_NAME, ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityGrindingStone te = new TileEntityGrindingStone();
	te.setName(this.getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererGrindingStoneId();
    }

    @Override
    public Icon getIcon(int par1, int par2) {
	par1 %= icons.length;
	return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
	icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "GrindingStone");
    }

    @Override
    public RecipesMachine getRecipes() {
	return TileEntityGrindingStone.recipes;
    }

    @Override
    public IGuiBuilder getGui() {
	return guiBuilder;
    }

    @Override
    public String getDescription() {
	return "For taking the edge off things.";
    }
}
