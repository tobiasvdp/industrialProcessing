package ip.industrialProcessing.gui3.generating;

import ip.industrialProcessing.gui3.containers.LayoutContainer;
import ip.industrialProcessing.multiblock.ITEmultiblock;
import ip.industrialProcessing.multiblock.tier.Tiers;
import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;

public class LayoutGuiBuilder {

    public static Container createContainer(InventoryPlayer player, TileEntity entity) {
	Block block = entity.getBlockType();
	if (block instanceof IGuiBlock) {
	    IGuiBlock guiBlock = (IGuiBlock) block;
	    IGuiBuilder builder = guiBlock.getGui();
	    if (builder != null) {
		return builder.getContainer(player, entity);
	    }
	}
	if (block instanceof IGuiMultiblock && entity instanceof ITEmultiblock) {
	    IGuiMultiblock guiMultiBlock = (IGuiMultiblock) block;
	    ITEmultiblock guiTileEntity = (ITEmultiblock) entity;
	    Tiers tier = guiTileEntity.getTier();
	    IGuiBuilder multiBuilder = guiMultiBlock.getGui(tier);
	    if (multiBuilder != null) {
		return multiBuilder.getContainer(player, entity);
	    }
	}
	return null;
    }

    public static GuiContainer createGuiContainer(InventoryPlayer player, TileEntity entity) {
	Block block = entity.getBlockType();
	if (block instanceof IGuiBlock) {
	    IGuiBlock guiBlock = (IGuiBlock) block;
	    IGuiBuilder builder = guiBlock.getGui();
	    if (builder != null) {
		LayoutContainer container = builder.getContainer(player, entity);
		return builder.getGuiContainer(container, entity);
	    }
	}
	if (block instanceof IGuiMultiblock && entity instanceof ITEmultiblock) {
	    IGuiMultiblock guiMultiBlock = (IGuiMultiblock) block;
	    ITEmultiblock guiTileEntity = (ITEmultiblock) entity;
	    Tiers tier = guiTileEntity.getTier();
	    IGuiBuilder multiBuilder = guiMultiBlock.getGui(tier);
	    if (multiBuilder != null) {
		LayoutContainer container = multiBuilder.getContainer(player, entity);
		return multiBuilder.getGuiContainer(container, entity);
	    }
	}
	return null;
    }
}
