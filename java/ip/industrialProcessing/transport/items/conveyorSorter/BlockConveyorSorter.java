package ip.industrialProcessing.transport.items.conveyorSorter;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.IGuiLayout;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.transport.items.conveyorBelt.BlockConveyorBase;
import ip.industrialProcessing.utils.IDescriptionBlock;

import java.awt.Rectangle;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockConveyorSorter extends BlockConveyorBase implements IDescriptionBlock, IGuiLayout {

    public static GuiLayout guiLayout;
    static {
	guiLayout = new GuiLayout();
	guiLayout.setSortingOrderByPanelID(1,3,2);
	guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsInput).setSlotLayout(SlotLayoutType.horizontal, 9);
	guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsInput).setSlotLayout(SlotLayoutType.horizontal, 9);
	guiLayout.addLayoutPanel(GuiLayoutPanelType.image).setImageLocation(new Rectangle(0,0,36,54));
    }

    public BlockConveyorSorter() {
	super(ConfigMachineBlocks.getBLtransportConveyorBeltSorter(), Material.iron, 5.0f, Block.soundMetalFootstep, "Conveyor Sorter", ISetupCreativeTabs.tabPower);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	return new TileEntityConveyorSorter();
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererConveyorSorterID();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
	player.openGui(IndustrialProcessing.instance, 0, world, x, y, z);
	return true;
    }

    @Override
    public GuiLayout getGuiLayout() {
	return guiLayout;
    }

    @Override
    public String getDescription() {
	return "A conveyor that can send items to the sides when they match a configured filter.";
    }
}
