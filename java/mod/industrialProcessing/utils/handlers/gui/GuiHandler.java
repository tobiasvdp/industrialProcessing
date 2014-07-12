package mod.industrialProcessing.utils.handlers.gui;

import mod.industrialProcessing.gui.generating.LayoutGuiBuilder;
import mod.industrialProcessing.gui.guide.GuideScreen;
import mod.industrialProcessing.plants.blackSmith.anvil.ContainerAnvil;
import mod.industrialProcessing.plants.blackSmith.anvil.GuiContainerAnvil;
import mod.industrialProcessing.utils.block.IGuiBlock;
import mod.industrialProcessing.utils.block.IGuiMultiblock;
import mod.industrialProcessing.utils.block.IUpgradableBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    public static final int GUIDE_ID = 1;
    public static final int ANVIL_ID = 2;
    public static final int SOLDERINGIRON_ID = 3;
    public static final int UPGRADE_ID = 4;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        TileEntity entity = world.getTileEntity(x, y, z);
        if (ID == 0) {
            if (entity.getBlockType() != null && (entity.getBlockType() instanceof IGuiBlock || entity.getBlockType() instanceof IGuiMultiblock)) {
                return LayoutGuiBuilder.createContainer(player.inventory, entity);
            }
        } else if (ID == GUIDE_ID) {
            return null;
        } else if (ID == ANVIL_ID) {
        	return new ContainerAnvil(player.inventory, world, x, y, z);
        } else if(ID == UPGRADE_ID){
        	 if (entity.getBlockType() != null && (entity.getBlockType() instanceof IUpgradableBlock)) {
                 return LayoutGuiBuilder.createContainer(player.inventory, (IUpgradableBlock)entity.getBlockType(),world,x, y, z);
             }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        TileEntity entity = world.getTileEntity(x, y, z);
        if (ID == 0) {
            if (entity.getBlockType() != null && (entity.getBlockType() instanceof IGuiBlock || entity.getBlockType() instanceof IGuiMultiblock)) {
                return LayoutGuiBuilder.createGuiContainer(player.inventory, entity);
            }
        } else if (ID == GUIDE_ID) {
            return new GuideScreen(player);
            // return new GuiGuide(player);
        } else if (ID == ANVIL_ID) {
            return new GuiContainerAnvil(player.inventory, world, x, y, z);
        } else if(ID == UPGRADE_ID){
       	 if (entity.getBlockType() != null && (entity.getBlockType() instanceof IUpgradableBlock)) {
             return LayoutGuiBuilder.createGuiContainer(player.inventory, (IUpgradableBlock)entity.getBlockType(),world,x, y, z);
         }
    }
        return null;
    }
}
