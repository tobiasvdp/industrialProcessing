package ip.industrialProcessing.transport.items.conveyorBelt.util;

import ip.industrialProcessing.transport.items.conveyorBelt.SlopeState;

public class SlopeUtils {


	public static SlopeState getSlopeFromMask(int mask) {
		if (isInMask(SlopeState.UP, mask))
			return SlopeState.UP;
		if (isInMask(SlopeState.DOWN, mask))
			return SlopeState.DOWN;

		return SlopeState.FLAT;
	}

	public static boolean isInMask(SlopeState slope, int mask) {

		int maskBit = 1 << slope.ordinal();

		return (maskBit & mask) == maskBit;
	}

}
