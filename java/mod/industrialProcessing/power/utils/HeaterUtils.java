package mod.industrialProcessing.power.utils;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class HeaterUtils {

    public static IHeatable getBoiler(TileEntity te, ForgeDirection dir) {
        TileEntity tile = te.getWorldObj().getTileEntity(te.xCoord + dir.offsetX, te.yCoord + dir.offsetY, te.zCoord + dir.offsetZ);
        if (tile instanceof IHeatable)
            return (IHeatable) tile;
        return null;
    }

    public static boolean increaseHeat(float heat, TileEntity te, ForgeDirection dir) {
        IHeatable boiler = getBoiler(te, dir);
        if (boiler != null) {
            boiler.addHeat(heat);
            return false;
        } else {
            return te.getWorldObj().isAirBlock(te.xCoord + dir.offsetX, te.yCoord + dir.offsetY, te.zCoord + dir.offsetZ);
        }
    }

    public static void ignite(TileEntity te, ForgeDirection dir) {
        te.getWorldObj().playSoundEffect(te.xCoord + 0.5D, te.yCoord + 1.5D, te.zCoord + 0.5D, "fire.ignite", 1.0F, 1);
        te.getWorldObj().setBlock(te.xCoord + dir.offsetX, te.yCoord + dir.offsetY, te.zCoord + dir.offsetZ, Blocks.fire);
    }
}
