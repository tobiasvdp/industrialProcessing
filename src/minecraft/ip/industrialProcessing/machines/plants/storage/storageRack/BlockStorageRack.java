package ip.industrialProcessing.machines.plants.storage.storageRack;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.generating.GuiBuilderInventory;
import ip.industrialProcessing.gui3.generating.IGuiBlock;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.utils.IDescriptionBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockStorageRack extends BlockMachineRendered implements IDescriptionBlock, IGuiBlock {
    public static String UNLOCALIZED_NAME = "IP.Machine.StorageRack";
    private static IGuiBuilder guiBuilder = new GuiBuilderInventory(UNLOCALIZED_NAME).setMode(Orientation.HORIZONTAL).addInventoryHeaderRow(0, 6, 9, 9).addInventoryHeaderRow(1, 6 + 9, 9, 9).addInventoryHeaderRow(2, 6 + 18, 9, 9).addInventoryHeaderRow(3, 6 + 27, 9, 9).addInventoryHeaderRow(4, 6 + 36, 9, 9).addInventoryHeaderRow(5, 6 + 45, 9, 9);

    private Icon[] icons = new Icon[4];

    public BlockStorageRack() {
	super(ConfigMachineBlocks.getBlockStorageRackID(), Material.iron, 1F, Block.soundMetalFootstep, UNLOCALIZED_NAME, ISetupCreativeTabs.tabOreProcessing);

    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityStorageRack te = new TileEntityStorageRack();
	te.setName(getLocalizedName());
	return te;
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererStorageRack();
    }

    @Override
    public Icon getIcon(int par1, int par2) {
	par1 %= icons.length;
	return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
	this.icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Iron");
	this.icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "orange");
	this.icons[2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "iron_block");
	this.icons[3] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "blockBox");
    }

    @Override
    public String getDescription() {
	return "Storage racks can store a few items.";
    }

    @Override
    public IGuiBuilder getGui() {
	return guiBuilder;
    }
}
