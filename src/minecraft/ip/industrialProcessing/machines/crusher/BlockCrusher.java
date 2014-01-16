package ip.industrialProcessing.machines.crusher;

import java.util.Random;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.IGuiLayout;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.IRecipeBlock;
import ip.industrialProcessing.utils.IDescriptionBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCrusher extends BlockMachineRendered implements IRecipeBlock, IDescriptionBlock,IGuiLayout {

	public static GuiLayout guiLayout;
	static{
		guiLayout = new GuiLayout();
		guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsInput).setSlotLayout(SlotLayoutType.horizontal, 1);
		guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsOutput).setSlotLayout(SlotLayoutType.horizontal, 1);
		guiLayout.addLayoutPanel(GuiLayoutPanelType.worker);
		guiLayout.addLayoutPanel(GuiLayoutPanelType.power);
	}
	
    public BlockCrusher() {
        super(ConfigMachineBlocks.getCrusherBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Ore Crusher", ISetupCreativeTabs.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        TileEntityCrusher te = new TileEntityCrusher();
        te.setName(this.getLocalizedName());
        return te;
    }

    @Override
    public int getRenderType() {
        return ConfigRenderers.getRendererCrusherId();
    }

    Random rnd = new Random();

    @Override
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        super.randomDisplayTick(par1World, par2, par3, par4, par5Random);
        TileEntityCrusher crusher = (TileEntityCrusher) par1World.getBlockTileEntity(par2, par3, par4);
        if (crusher.getWorker().isWorking()) {
            for (int i = 0; i < 5; i++) {
                int x = 0;
                int z = 0;
                float offsetX = (2 * rnd.nextFloat() - 1f) * 0.25f;
                float offsetZ = (2 * rnd.nextFloat() - 1f) * 0.25f;
                par1World.spawnParticle("smoke", par2 + 0.5f + offsetX, par3 + 0.5f + offsetZ, par4 + 0.5f, x, -0.001f, z);
            }
        }
    }

    @Override
    public RecipesMachine getRecipes() { 
	return TileEntityCrusher.recipes;
    }

	@Override
	public String getDescription() {
		return "The crusher can grind ores into finer pieces.";
	}

	@Override
	public GuiLayout getGuiLayout() {
		return guiLayout;
	}

}
