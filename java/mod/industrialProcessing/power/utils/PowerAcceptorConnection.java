package mod.industrialProcessing.power.utils;

import net.minecraftforge.common.util.ForgeDirection;

public class PowerAcceptorConnection {
    public PowerAcceptorConnection(int x, int y, int z, ForgeDirection direction) {
	this.x = x;
	this.y = y;
	this.z = z;
	this.connectedFrom = direction;
    }

    public int x, y, z;
    public ForgeDirection connectedFrom;
}
