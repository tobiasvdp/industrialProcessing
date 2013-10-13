package ip.industrialProcessing.transport.fluids;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.BitSet;

public class FluidTree {

    public FluidTree(int x, int y, int z) {
	this.centerX = x;
	this.centerY = y;
	this.centerZ = z;

	tree = new BitSet[33][33];
    }

    BitSet[][] tree;
    int centerX;
    int centerZ;
    int centerY;

    public boolean isCandidate(int x, int y, int z) {
	x -= centerX-16;
	z -= centerZ-16; 
	if (x < 0)
	    return false;
	if (z < 0)
	    return false;
	if (x >= 33)
	    return false;
	if (z >= 33)
	    return false;
	if (y > centerY)
	    return false;
	if (y < 0)
	    return false;

	BitSet column = tree[x][z];
	
	return column.get(y);
    }
}
