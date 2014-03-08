package ip.industrialProcessing.power.wire;

import net.minecraftforge.common.util.ForgeDirection;

public class WireLocation {
    public WireLocation(int x, int y, int z) {
	this.x = x;
	this.y = y;
	this.z = z;
    }

    public int x;
    public int y;
    public int z;

    @Override
    public int hashCode() {
	return x ^ y ^ z;
    }

    public WireLocation moveBy(ForgeDirection direction) {
	return new WireLocation(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ);
    }

    @Override
    public boolean equals(Object obj) {
	if (obj instanceof WireLocation) {
	    WireLocation other = (WireLocation) obj;
	    return other.x == x && other.y == y && other.z == z;
	}
	return super.equals(obj);
    }
}
