package ip.industrialProcessing.transport.items.conveyorBelt;

public enum SlopeState {
	DOWN, FLAT, UP, NONE;
	public final static int[] OPPOSITES = new int[] { 2, 1, 0 };
	public final static SlopeState[] VALID_STATES = new SlopeState[] { SlopeState.DOWN, SlopeState.FLAT, SlopeState.UP };

	public SlopeState getOpposite() {
		if (this == NONE)
			return this;
		int index = this.ordinal();
		return VALID_STATES[OPPOSITES[index]];
	}

	public int getHeight() {
		if (this == NONE)
			return 0;
		return this.ordinal() - 1;
	}
}
