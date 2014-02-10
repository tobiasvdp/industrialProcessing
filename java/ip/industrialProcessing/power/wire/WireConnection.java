package ip.industrialProcessing.power.wire;

import net.minecraftforge.common.util.ForgeDirection;

public class WireConnection extends WireLocation {

    public ForgeDirection direction;

    public WireConnection(int x, int y, int z, ForgeDirection direction) {
	super(x, y, z);
	this.direction = direction;
    }

    public WireConnection(WireLocation location, ForgeDirection direction) {
	this(location.x, location.y, location.z, direction);
    }

    @Override
    public int hashCode() {
	return super.hashCode() ^ direction.ordinal();
    }

    @Override
    public boolean equals(Object obj) {
	if (obj instanceof WireConnection) {
	    WireConnection other = (WireConnection) obj;
	    return other.x == x && other.y == y && other.z == z && other.direction == direction;
	}
	return super.equals(obj);
    }
}
