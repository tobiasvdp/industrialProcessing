package ip.industrialProcessing.machines.multiblock;

public interface IMultiblockTileEntityCore {

	boolean isStructureComplete();
	void checkStructure();
	void breakEntireStructure();
	boolean isPartOfStructure(int x, int y, int z, int blockId);

	int getCoreX();
	int getCoreY();
	int getCoreZ();
}
