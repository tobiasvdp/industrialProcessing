package ip.industrialProcessing.machines.multiblock;

import java.util.HashSet;

import org.lwjgl.Sys;

import ip.industrialProcessing.utils.Position;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class MultiblockUtils {

	/*
	 * public static IMultiblockTileEntityCore findCorePositionFromNeighbors(
	 * World world, int x, int y, int z) { HashSet<IMultiblockTileEntityFrame>
	 * processedFrames = new HashSet<IMultiblockTileEntityFrame>();
	 * 
	 * IMultiblockTileEntityFrame frame = getFrameAt(world, x, y, z);
	 * processedFrames.add(frame);
	 * 
	 * return findCorePositionFromNeighborsRecursive(world, x, y, z, frame,
	 * processedFrames); }
	 */
	private static IMultiblockTileEntityCore findCorePositionFromNeighborsRecursive(
			World world, int x, int y, int z,
			IMultiblockTileEntityFrame sourceFrame,
			HashSet<IMultiblockTileEntityFrame> processedFrames) {

		for (int ix = x - 1; ix <= x + 1; ix++) {
			for (int iy = y - 1; iy <= y + 1; iy++) {
				for (int iz = z - 1; iz <= z + 1; iz++) {
					if (ix == x && iy == y && iz == z)
						continue; // don't look at the frame in this spot;
					{
						TileEntity tileEntity = world.getBlockTileEntity(ix,
								iy, iz);
						if (tileEntity instanceof IMultiblockTileEntityCore) {
							IMultiblockTileEntityCore core = (IMultiblockTileEntityCore) tileEntity;
							if (isFrameForCore(sourceFrame, core, world))
								return core;
							// else: this is not the core we're looking for!
						} else if (tileEntity instanceof IMultiblockTileEntityFrame) {
							IMultiblockTileEntityFrame frame = (IMultiblockTileEntityFrame) tileEntity;
							if (!processedFrames.contains(frame)) {
								processedFrames.add(frame);
								if (frame.hasCore()) {
									IMultiblockTileEntityCore core = getCoreFromFrame(
											world, frame);
									if (core != null
											&& isFrameForCore(sourceFrame,
													core, world))
										return core; // this is the core we're
														// looking for
								} else {
									IMultiblockTileEntityCore core = findCorePositionFromNeighborsRecursive(
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
			IMultiblockTileEntityFrame sourceFrame,
			IMultiblockTileEntityCore core, World world) {

		int x = sourceFrame.getFrameX();
		int y = sourceFrame.getFrameY();
		int z = sourceFrame.getFrameZ();
		int blockId = world.getBlockId(x, y, z);

		return (core.isPartOfStructure(x, y, z, blockId));
	}

	public static boolean isFramePointingToCore(
			IMultiblockTileEntityFrame sourceFrame,
			IMultiblockTileEntityCore core) {
		return sourceFrame.getCoreX() == core.getCoreX()
				&& sourceFrame.getCoreY() == core.getCoreY()
				&& sourceFrame.getCoreZ() == core.getCoreZ();
	}

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
		System.out.println("Breaking frame @ " + x + ", " + y + ", " + z);
		IMultiblockTileEntityFrame frame = getFrameAt(world, x, y, z);
		if (frame != null && frame.hasCore()) {
			IMultiblockTileEntityCore core = getCoreAt(world, frame.getCoreX(),
					frame.getCoreX(), frame.getCoreZ());
			core.checkStructure();
		}
	}

	public static void frameNeighborUpdated(World world, int x, int y, int z) {
		System.out.println("Frame @ " + x + ", " + y + ", " + z
				+ " noticed neighbor update ");
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
						frame, processedFrames);
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
		System.out.println("Core @ " + x + ", " + y + ", " + z + " was broken");
		IMultiblockTileEntityCore core = getCoreAt(world, x, y, z);
		if (core != null) {
			core.breakEntireStructure();
		}
	}

	public static void coreNeighborUpdate(World world, int x, int y, int z) {
		System.out.println("Core @ " + x + ", " + y + ", " + z
				+ " noticed neighbor update ");
		IMultiblockTileEntityCore core = getCoreAt(world, x, y, z);

		if (core != null) {
			core.checkStructure(); // neighbor might have been broken!
			propagateCore(world, x, y, z, core);
		}
	}
}
