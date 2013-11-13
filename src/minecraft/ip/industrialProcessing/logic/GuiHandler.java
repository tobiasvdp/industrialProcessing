package ip.industrialProcessing.logic;

import ip.industrialProcessing.logic.network.display.GuiLogicDisplay;
import ip.industrialProcessing.logic.network.display.TileEntityLogicDisplay;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.vacuumDestilationTower.GuiContainerVacuumDestilationTower;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.vacuumDestilationTower.TileEntityVacuumDestilationTower;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	TileEntity entity = world.getBlockTileEntity(x, y, z);
	if (ID == 0) {
	    if (entity instanceof TileEntityLogicDisplay)
		return new GuiLogicDisplay((TileEntityLogicDisplay)entity);
	}
	return null;
    }

}
