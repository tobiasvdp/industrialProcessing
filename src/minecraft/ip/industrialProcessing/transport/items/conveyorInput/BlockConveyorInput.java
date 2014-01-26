package ip.industrialProcessing.transport.items.conveyorInput;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.IGuiLayout;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.transport.items.conveyorBelt.BlockConveyorMachineBase;
import ip.industrialProcessing.utils.IDescriptionBlock;

import java.awt.Rectangle;
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

public class BlockConveyorInput extends BlockConveyorMachineBase implements IDescriptionBlock, IGuiLayout {

    Icon[] icons = new Icon[3];
    public static GuiLayout guiLayout;
    static {
	guiLayout = new GuiLayout();
	guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsInput).setSlotLayout(SlotLayoutType.horizontal, 9);
	
	guiLayout.addLayoutPanel(GuiLayoutPanelType.spinnerButton, 10, 40);
    }

    public BlockConveyorInput() {
	super(ConfigMachineBlocks.getBLtransportConveyorBeltInput(), Material.iron, 5.0f, Block.soundMetalFootstep, "Conveyor Input", ISetupCreativeTabs.tabPower);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	return new TileEntityConveyorInput();
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererConveyorInputID();
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
	return "A machine that can take items from a nearby inventory and output it on the conveyor belt";
    }
}
