package ip.industrialProcessing.utils;

public interface IBlockInBlock {
	public void addToBlockside(int par5);
	public void removeFromBlockside(int par5);
	public boolean hasBlockSide(int side);
	public boolean hasMultipleBlockSides();
	public void setMultipleBlockSides(boolean sides);
	public int getBlockSidesCount();
}
