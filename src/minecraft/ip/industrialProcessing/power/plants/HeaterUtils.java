package ip.industrialProcessing.power.plants;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class HeaterUtils {

    public static IHeatable getBoiler(TileEntity te, ForgeDirection dir) {
        TileEntity tile = te.worldObj.getBlockTileEntity(te.xCoord + dir.offsetX, te.yCoord + dir.offsetY, te.zCoord + dir.offsetZ);
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
            return te.worldObj.isAirBlock(te.xCoord + dir.offsetX, te.yCoord + dir.offsetY, te.zCoord + dir.offsetZ);
        }
    }

    public static void ignite(TileEntity te, ForgeDirection dir) {
        te.worldObj.playSoundEffect(te.xCoord + 0.5D, te.yCoord + 1.5D, te.zCoord + 0.5D, "fire.ignite", 1.0F, 1);
        te.worldObj.setBlock(te.xCoord + dir.offsetX, te.yCoord + dir.offsetY, te.zCoord + dir.offsetZ, Block.fire.blockID);
    }
}
