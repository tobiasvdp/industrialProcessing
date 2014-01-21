package ip.industrialProcessing.transport.items.conveyorPacker;

import java.util.List;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.IGuiLayout;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.transport.items.conveyorBelt.BlockConveyorBase;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorInteractionBase;
import ip.industrialProcessing.utils.IDescriptionBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockConveyorPacker extends BlockConveyorBase implements IDescriptionBlock, IGuiLayout {
    Icon[] icons = new Icon[3];

    public static GuiLayout guiLayout;
    static {
	guiLayout = new GuiLayout();
	guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsInventory).setSlotLayout(SlotLayoutType.horizontal, 1);
	guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsInventory).setSlotLayout(SlotLayoutType.horizontal, 9); 
    }
    
    
    public BlockConveyorPacker() {
	super(ConfigMachineBlocks.getBLtransportConveyorBeltPacker(), Material.iron, 5.0f, Block.soundMetalFootstep, "Packer", ISetupCreativeTabs.tabPower);
	func_111022_d(null);
	setBlockBounds(0, 0, 0, 1, 1, 1);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	return new TileEntityConveyorPacker();
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererConveyorPackerID();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
	player.openGui(IndustrialProcessing.instance, 0, world, x, y, z);
	return true;
    }

    @Override
    public Icon getIcon(int par1, int par2) {
	par1 %= icons.length;
	return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
	this.icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankSide");
	this.icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "conveyorHopperFeatures");
	this.icons[2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "packer");
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess par1iBlockAccess, int par2, int par3, int par4) {
    }

    @Override
    public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {

	AxisAlignedBB axisalignedbb1 = this.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);

	if (axisalignedbb1 != null && par5AxisAlignedBB.intersectsWith(axisalignedbb1)) {
	    par6List.add(axisalignedbb1);
	}
    }

    @Override
    public GuiLayout getGuiLayout() { 
	return guiLayout;
    }

    @Override
    public String getDescription() { 
	return "Packs or Unpacks items to/from supplied Storage Boxes";
    }
}
