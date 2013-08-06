package ip.industrialProcessing.machines.multiblock;

import java.util.HashSet;

import ip.industrialProcessing.utils.Position;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class MultiblockUtils {

	public static IMultiblockTileEntityCore findCorePositionFromNeighbors(
			World world, int x, int y, int z) {
		HashSet<IMultiblockTileEntityFrame> processedFrames = new HashSet<IMultiblockTileEntityFrame>();

		IMultiblockTileEntityFrame frame = getFrameAt(world, x, y, z);
		processedFrames.add(frame);

		return findCorePositionFromNeighborsRecursive(world, x, y, z,
				processedFrames);
	}

	private static IMultiblockTileEntityCore findCorePositionFromNeighborsRecursive(
			World world, int x, int y, int z,
			HashSet<IMultiblockTileEntityFrame> processedFrames) {

		for (int ix = x - 1; ix <= x + 1; ix++) {
			for (int iy = y - 1; iy <= y + 1; iy++) {
				for (int iz = z - 1; iz <= z + 1; iz++) {
					if (ix == x && iy == y && iz == z)
						continue; // don't look at the frame in this spot;

					TileEntity tileEntity = world
							.getBlockTileEntity(ix, iy, iz);
					if (tileEntity instanceof IMultiblockTileEntityCore) {
						return (IMultiblockTileEntityCore) tileEntity;
					} else if (tileEntity instanceof IMultiblockTileEntityFrame) {

						IMultiblockTileEntityFrame frame = (IMultiblockTileEntityFrame) tileEntity;
						if (frame != null && !processedFrames.contains(frame)) {
							processedFrames.add(frame);
							if (frame.hasCore()) {
								return getCoreAt(world, frame.getCoreX(),
										frame.getCoreY(), frame.getCoreZ());
							} else {
								return findCorePositionFromNeighborsRecursive(
										world, x, y, z, processedFrames);
							}
						}
					}
				}
			}
		}
		return null;
	}

	/*
	 * Don't do this, let the core set the frame's pointers, so we don't go out
	 * of bounds public static void setCoreToNeighbors(World world, int x, int
	 * y, int z, IMultiblockTileEntityCore core) { for (int ix = x - 1; ix <= x
	 * + 1; ix++) { for (int iy = y - 1; iy <= y + 1; iy++) { for (int iz = z -
	 * 1; iz <= z + 1; iz++) { if (ix == x && iy == y && iz == z) continue; //
	 * don't look at the frame in this spot;
	 * 
	 * IMultiblockTileEntityFrame frame = getFrameAt(world, ix, iy, iz);
	 * if(frame != null && !frame.hasCore()) { frame.setCore(core); } } } }
	 * 
	 * }
	 */

	public static IMultiblockTileEntityFrame getFrameAt(World world, int x,
			int y, int z) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if (tileEntity instanceof IMultiblockTileEntityFrame) {
			return (IMultiblockTileEntityFrame) tileEntity;
		}
		return null;
	}

	public static IMultiblockTileEntityCore getCoreFromFrameAt(World world,
			int x, int y, int z) {
		IMultiblockTileEntityFrame frame = getFrameAt(world, x, y, z);
		if (frame != null && frame.hasCore()) {
			return getCoreAt(world, frame.getCoreX(), frame.getCoreY(),
					frame.getCoreZ());
		}
		return null;
	}

	public static IMultiblockTileEntityCore getCoreAt(World world, int x,
			int y, int z) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if (tileEntity instanceof IMultiblockTileEntityCore) {
			return (IMultiblockTileEntityCore) tileEntity;
		}
		return null;
	}

	public static void propagateCore(World world, int x, int y, int z,
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
	}

	public static void notifyFrameBreak(World world, int x, int y, int z) {
		IMultiblockTileEntityFrame frame = getFrameAt(world, x, y, z);
		if (frame != null && frame.hasCore()) {
			IMultiblockTileEntityCore core = getCoreAt(world, frame.getCoreX(),
					frame.getCoreX(), frame.getCoreZ());
			core.checkStructure();
		}
	}

	public static void frameNeighborUpdated(World world, int x, int y, int z) {
		IMultiblockTileEntityFrame frame = getFrameAt(world, x, y, z);
		if (frame != null) {
			IMultiblockTileEntityCore core = getCoreFromFrame(world, frame);
			if (core != null) {
				core.checkStructure();
			} else // a new connection might have been made
			{
				HashSet<IMultiblockTileEntityFrame> processedFrames = new HashSet<IMultiblockTileEntityFrame>();
				processedFrames.add(frame);
				core = findCorePositionFromNeighborsRecursive(world, x, y, z,
						processedFrames);
				if (core != null) {
					int blockId = world.getBlockId(x, y, z);
					if (core.isPartOfStructure(x, y, z, blockId)) {
						// this is part of the core!
						frame.setCore(core);
						core.checkStructure();
						propagateCore(world, x, y, z, core);
					}
				}
			}
		}
	}

	private static IMultiblockTileEntityCore getCoreFromFrame(World world,
			IMultiblockTileEntityFrame frame) {
		if (!frame.hasCore())
			return null;
		return getCoreAt(world, frame.getCoreX(), frame.getCoreY(),
				frame.getCoreZ());
	}

	public static void breakCore(World world, int x, int y, int z) {
		IMultiblockTileEntityCore core = getCoreAt(world, x, y, z);
		if (core != null) {
			if (core.isStructureComplete()) {
				core.breakEntireStructure();
			}
		}
	}

	public static void coreNeighborUpdate(World world, int x, int y, int z) {
		IMultiblockTileEntityCore core = getCoreAt(world, x, y, z);

		if (core != null) {
			core.checkStructure(); // neighbor might have been broken!
			propagateCore(world, x, y, z, core);
		}
	}
}
