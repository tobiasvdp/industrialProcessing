package ip.industrialProcessing.machines.multiblock;

import ip.industrialProcessing.utils.Position;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.BiomeEvent.CreateDecorator;

public class BlockMultiMachineFrame extends BlockContainer {

	public BlockMultiMachineFrame(int blockId, CreativeTabs tab) {
		super(blockId, Material.iron);
		setCreativeTab(tab);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityMultiMachineFrame();
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
		super.breakBlock(world, x, y, z, par5, par6);
		MultiblockUtils.notifyFrameBreak(world, x, y, z);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int par5) {
		MultiblockUtils.frameNeighborUpdated(world, x, y, z);
	}

	/*
	 * @Override public int onBlockPlaced(World world, int x, int y, int z, int
	 * par5, float par6, float par7, float par8, int par9) {
	 * 
	 * IMultiblockTileEntityCore core =
	 * MultiblockUtils.findCorePositionFromNeighbors(world, x, y, z); if (core
	 * != null) { IMultiblockTileEntityFrame frame = MultiblockUtils.getFrameAt(
	 * world, x, y, z); frame.setCore(core);
	 * System.out.println("Found the core!"); } return super
	 * .onBlockPlaced(world, x, y, z, par5, par6, par7, par8, par9); }
	 */
}
