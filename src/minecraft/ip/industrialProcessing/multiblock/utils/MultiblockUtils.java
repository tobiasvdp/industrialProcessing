package ip.industrialProcessing.multiblock.utils;

import java.util.HashSet;

import org.lwjgl.Sys;

import ip.industrialProcessing.multiblock.ITileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.ITileEntityMultiblockBlock;
import ip.industrialProcessing.utils.Position;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class MultiblockUtils {

	private static ITileEntityMultiblockCore findCorePositionFromNeighborsRecursive(
			World world, int x, int y, int z,
			ITileEntityMultiblockBlock sourceFrame,
			HashSet<ITileEntityMultiblockBlock> processedFrames) {

		for (int ix = x - 1; ix <= x + 1; ix++) {
			for (int iy = y - 1; iy <= y + 1; iy++) {
				for (int iz = z - 1; iz <= z + 1; iz++) {
					if (ix == x && iy == y && iz == z)
						continue; // don't look at the frame in this spot;
					{
						TileEntity tileEntity = world.getBlockTileEntity(ix,
								iy, iz);
						if (tileEntity instanceof ITileEntityMultiblockCore) {
							ITileEntityMultiblockCore core = (ITileEntityMultiblockCore) tileEntity;
							if (isFrameForCore(sourceFrame, core, world))
								return core;
							// else: this is not the core we're looking for!
						} else if (tileEntity instanceof ITileEntityMultiblockBlock) {
							ITileEntityMultiblockBlock frame = (ITileEntityMultiblockBlock) tileEntity;
							if (!processedFrames.contains(frame)) {
								processedFrames.add(frame);
								if (frame.hasCore()) {
									ITileEntityMultiblockCore core = getCoreFromFrame(
											world, frame);
									if (core != null
											&& isFrameForCore(sourceFrame,
													core, world))
										return core; // this is the core we're
														// looking for
								} else {
									ITileEntityMultiblockCore core = findCorePositionFromNeighborsRecursive(
											world, ix, iy, iz, sourceFrame,
											processedFrames);
									if (core != null)
										return core;
								}
							}
						}
					}
				}
			}
		}

		return null;
	}

	public static boolean isFrameForCore(
			ITileEntityMultiblockBlock sourceFrame,
			ITileEntityMultiblockCore core, World world) {

		int x = sourceFrame.getFrameX();
		int y = sourceFrame.getFrameY();
		int z = sourceFrame.getFrameZ();
		int blockId = world.getBlockId(x, y, z);

		return (core.isPartOfStructure(x, y, z, blockId));
	}

	public static boolean isFramePointingToCore(
			ITileEntityMultiblockBlock sourceFrame,
			ITileEntityMultiblockCore core) {
		return sourceFrame.getCoreX() == core.getCoreX()
				&& sourceFrame.getCoreY() == core.getCoreY()
				&& sourceFrame.getCoreZ() == core.getCoreZ();
	}

	public static ITileEntityMultiblockBlock getFrameAt(World world, int x,
			int y, int z) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if (tileEntity instanceof ITileEntityMultiblockBlock) {
			return (ITileEntityMultiblockBlock) tileEntity;
		}
		return null;
	}

	public static ITileEntityMultiblockCore getCoreFromFrameAt(World world,
			int x, int y, int z) {
		ITileEntityMultiblockBlock frame = getFrameAt(world, x, y, z);
		if (frame != null && frame.hasCore()) {
			return getCoreAt(world, frame.getCoreX(), frame.getCoreY(),
					frame.getCoreZ());
		}
		return null;
	}

	public static ITileEntityMultiblockCore getCoreAt(World world, int x,
			int y, int z) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if (tileEntity instanceof ITileEntityMultiblockCore) {
			return (ITileEntityMultiblockCore) tileEntity;
		}
		return null;
	}

	/*public static void propagateCore(World world, int x, int y, int z,
			IMultiblockTileEntityCore core) {

		for (int ix = x - 1; ix <= x + 1; ix++) {
			for (int iy = y - 1; iy <= y + 1; iy++) {
				for (int iz = z - 1; iz <= z + 1; iz++) {
					if (ix == x && iy == y && iz == z)
						continue; // don't look at the frame in this spot;

					IMultiblockTileEntityFrame frame = getFrameAt(world, ix,
							iy, iz);
					if (frame != null && !frame.hasCore()) {
						int blockId = world.getBlockId(ix, iy, iz);
						if (core.isPartOfStructure(ix, iy, iz, blockId)) {
							frame.setCore(core);
							core.checkStructure();
							propagateCore(world, ix, iy, iz, core);
						}
					}

				}
			}
		}
	}*/





	private static ITileEntityMultiblockCore getCoreFromFrame(World world,
			ITileEntityMultiblockBlock frame) {
		if (!frame.hasCore())
			return null;
		return getCoreAt(world, frame.getCoreX(), frame.getCoreY(),
				frame.getCoreZ());
	}

	public static void breakCore(World world, int x, int y, int z) {
		System.out.println("Core @ " + x + ", " + y + ", " + z + " was broken");
		ITileEntityMultiblockCore core = getCoreAt(world, x, y, z);
		if (core != null) {
			core.breakEntireStructure();
		}
	}


	
	
	/* North: 	-z ->back
	 * South: 	+z ->front
	 * Down: 	-Y ->down
	 * Up: 		+y ->up
	 * West: 	-x ->right
	 * East: 	+x ->left
	 */
	public static void addToStructure(int blockID, int x,int y,int z){
		
	}
}
