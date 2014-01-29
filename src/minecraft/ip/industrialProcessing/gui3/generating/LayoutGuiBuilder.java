package ip.industrialProcessing.gui3.generating;

import ip.industrialProcessing.gui3.containers.LayoutContainer;
import net.minecraft.block.Block;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;

public class LayoutGuiBuilder {

    public static Object createContainer(InventoryPlayer player, TileEntity entity) {

	Block block = entity.getBlockType();
	if (block instanceof IGuiBlock) {
	    IGuiBlock guiBlock = (IGuiBlock) block;
	    IGuiBuilder builder = guiBlock.getGui();
	    if (builder != null) {
		return builder.getContainer(player, entity);
	    }
	}

	return null;
    }

    public static Object createGuiContainer(InventoryPlayer player, TileEntity entity) {

	Block block = entity.getBlockType();
	if (block instanceof IGuiBlock) {
	    IGuiBlock guiBlock = (IGuiBlock) block;
	    IGuiBuilder builder = guiBlock.getGui();
	    if (builder != null) {
		LayoutContainer container = builder.getContainer(player, entity);
		return builder.getGuiContainer(container);
	    }
	}
	return null;
    }

}
