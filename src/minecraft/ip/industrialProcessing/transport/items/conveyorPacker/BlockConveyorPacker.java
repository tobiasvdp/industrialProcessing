package ip.industrialProcessing.transport.items.conveyorPacker;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.IGuiLayout;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.machines.plants.storage.storageBox.BlockStorageBox;
import ip.industrialProcessing.transport.items.conveyorBelt.BlockConveyorMachineBase;
import ip.industrialProcessing.utils.IDescriptionBlock;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockConveyorPacker extends BlockConveyorMachineBase implements IDescriptionBlock, IGuiLayout {
    Icon[] icons = new Icon[3];

    public static GuiLayout guiLayout;
    static {
	guiLayout = new GuiLayout();
	guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsInput).setSlotLayout(SlotLayoutType.horizontal, 1);
	guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsInput).setSlotLayout(SlotLayoutType.horizontal, BlockStorageBox.STORAGE_SIZE);
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
    public GuiLayout getGuiLayout() {
	return guiLayout;
    }

    @Override
    public String getDescription() {
	return "Packs or Unpacks items to/from supplied Storage Boxes";
    }
}
