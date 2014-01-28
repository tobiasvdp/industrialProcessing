package ip.industrialProcessing.gui3.generating;

import ip.industrialProcessing.gui3.containers.GuiLayoutContainer;
import ip.industrialProcessing.gui3.containers.LayoutContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;

public interface IGuiBuilder {
    GuiLayoutContainer getGuiContainer(LayoutContainer container); 
    LayoutContainer getContainer(InventoryPlayer player, TileEntity tileEntity);
}
