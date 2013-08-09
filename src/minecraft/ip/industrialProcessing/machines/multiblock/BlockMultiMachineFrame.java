package ip.industrialProcessing.machines.multiblock;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.utils.Position;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.BiomeEvent.CreateDecorator;

public abstract class BlockMultiMachineFrame extends BlockContainer {

	private Icon completedIcon;
	private Icon connectedIcon;
	private Icon disconnectedIcon;

	public BlockMultiMachineFrame(int par1, String name, CreativeTabs tab) {
		super(par1, Material.iron);
		setHardness(1F);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName(name);
		setCreativeTab(tab); 
	}

	public Icon getBlockTexture(IBlockAccess par1iBlockAccess, int par2,
			int par3, int par4, int side) {
		TileEntity tileEntity = par1iBlockAccess.getBlockTileEntity(par2, par3,
				par4);
		if (tileEntity instanceof IMultiblockTileEntityFrame) {
			IMultiblockTileEntityFrame frame = (IMultiblockTileEntityFrame) tileEntity;
			if (frame != null) {

				// TODO: get state from frame, sub-todo: sync frame from server
				// to client!
				MachineFrameState state = frame.getState();

				state = MachineFrameState.values()[par1iBlockAccess
						.getBlockMetadata(par2, par3, par4)];
				System.out.println("Getting icon for state " + state
						+ " of frame @ " + frame.getFrameX() + ", "
						+ frame.getFrameY() + ", " + frame.getFrameZ());
				switch (state) {
				case COMPLETED:
					return completedIcon;
				case CONNECTED:
					return connectedIcon;
				case DISCONNECTED:
					return disconnectedIcon;
				}
			}
		}
		return disconnectedIcon;
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		return disconnectedIcon;
	}

	@Override
	public void onSetBlockIDWithMetaData(World par1World, int par2, int par3,
			int par4, int par5) {
		// TODO Auto-generated method stub
		super.onSetBlockIDWithMetaData(par1World, par2, par3, par4, par5);
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		this.completedIcon = registerIcon(par1IconRegister,
				MachineFrameState.COMPLETED);
		this.connectedIcon = registerIcon(par1IconRegister,
				MachineFrameState.CONNECTED);
		this.disconnectedIcon = registerIcon(par1IconRegister,
				MachineFrameState.DISCONNECTED);
	}

	protected abstract Icon registerIcon(IconRegister iconRegister,
			MachineFrameState state);

	@Override
	public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
		super.breakBlock(world, x, y, z, par5, par6);
		MultiblockUtils.notifyFrameBreak(world, x, y, z);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int par5) {
		MultiblockUtils.frameNeighborUpdated(world, x, y, z);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
}
