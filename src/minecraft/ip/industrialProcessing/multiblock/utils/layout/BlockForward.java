package ip.industrialProcessing.multiblock.utils.layout;

public enum BlockForward {
	NORTH, EAST, SOUTH, WEST, INVALID;
	public static final BlockForward[] VALID_FORWARDS = new BlockForward[] { BlockForward.NORTH, BlockForward.EAST, BlockForward.SOUTH, BlockForward.WEST };
}
