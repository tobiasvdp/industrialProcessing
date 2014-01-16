package ip.industrialProcessing.machines.plants.blacksmith.grindingStone;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
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
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockGrindingStone extends BlockMachineRendered implements IRecipeBlock, IDescriptionBlock,IGuiLayout {
	
	public static GuiLayout guiLayout;
	static{
		guiLayout = new GuiLayout();
		guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsInput).setSlotLayout(SlotLayoutType.horizontal, 1);
		guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsOutput).setSlotLayout(SlotLayoutType.horizontal, 1);
		guiLayout.addLayoutPanel(GuiLayoutPanelType.worker);
	}

	private Icon[] icons = new Icon[1];
	
    public BlockGrindingStone() {
        super(ConfigMachineBlocks.getBlockGrindingStoneID(), Material.iron, 1F, Block.soundMetalFootstep, "GrindingStone", ISetupCreativeTabs.tabOreProcessing);
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
	public GuiLayout getGuiLayout() {
		return guiLayout;
	}

	@Override
	public String getDescription() {
		return "For taking the edge off things.";
	}
}
