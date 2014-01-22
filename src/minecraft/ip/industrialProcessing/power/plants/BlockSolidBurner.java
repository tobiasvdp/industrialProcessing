package ip.industrialProcessing.power.plants;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.IGuiLayout;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.utils.IDescriptionBlock;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSolidBurner extends BlockMachineRendered implements IDescriptionBlock, IGuiLayout {

    private static GuiLayout guiLayout;
    static {
	guiLayout = new GuiLayout();
	guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsInput).setSlotLayout(SlotLayoutType.horizontal, 1);
	guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsOutput).setSlotLayout(SlotLayoutType.horizontal, 1); 
	guiLayout.addLayoutPanel(GuiLayoutPanelType.worker);
    }
    private Icon[] icons = new Icon[3];

    public BlockSolidBurner() {
	super(ConfigMachineBlocks.getSolidBurnerBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Solid Burner", ISetupCreativeTabs.tabPower);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	return new TileEntitySolidBurner();
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererSolidBurnerId();
    }

    @Override
    public boolean isOpaqueCube() {
	return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
	TileEntitySolidBurner burner = (TileEntitySolidBurner) par1World.getBlockTileEntity(par2, par3, par4);
	if (burner.isBurning()) {
	    float f = par2 + 0.5F;
	    float f1 = par3 + 0.0F + par5Random.nextFloat() * 6.0F / 16.0F;
	    float f2 = par4 + 0.5F;

	    float x = par2 + par5Random.nextFloat() / 2 + 0.25f;
	    float y = par3 + 1;
	    float z = par4 + par5Random.nextFloat() / 2 + 0.25f;

	    par1World.spawnParticle("smoke", x, y, z, 0.0D, 0.0D, 0.0D);
	    par1World.spawnParticle("flame", x, y, z, 0.0D, 0.0D, 0.0D);
	}
    }

    @Override
    public Icon getIcon(int par1, int par2) {
	par1 %= icons.length;
	return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
	icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankSide");
	icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "conveyorHopperFeatures");
	icons[2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "burnerGrill");
    }

    @Override
    public GuiLayout getGuiLayout() {
	return guiLayout;
    }

    @Override
    public String getDescription() {
	return "Provides a heatsource for the machine above it using solid fuels.";
    }
}
