package ip.industrialProcessing.multiblock;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.multiblock.interfaces.ITileEntityMultiblockBlock;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockMultiblockBlock extends BlockContainer {

	private Icon completedIcon;
	private Icon connectedIcon;
	private Icon disconnectedIcon;

	public BlockMultiblockBlock(int par1, String name, CreativeTabs tab) {
		super(par1, Material.iron);
		setHardness(1F);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName(name);
		setCreativeTab(tab);
	}

	@Override
	public Icon getBlockTexture(IBlockAccess par1iBlockAccess, int par2, int par3, int par4, int side) {
		TileEntity tileEntity = par1iBlockAccess.getBlockTileEntity(par2, par3, par4);
		if (tileEntity instanceof ITileEntityMultiblockBlock) {
			ITileEntityMultiblockBlock frame = (ITileEntityMultiblockBlock) tileEntity;
			if (frame != null) {

				// TODO: get state from frame, sub-todo: sync frame from server
				// to client!
				MultiblockState state = frame.getState();
				// state =
				// MultiblockState.values()[par1iBlockAccess.getBlockMetadata(par2,
				// par3, par4)];
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
		return completedIcon;
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		return disconnectedIcon;
	}

	@Override
	public void onSetBlockIDWithMetaData(World par1World, int par2, int par3, int par4, int par5) {
		// TODO Auto-generated method stub
		super.onSetBlockIDWithMetaData(par1World, par2, par3, par4, par5);
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		this.completedIcon = registerIcon(par1IconRegister, MultiblockState.COMPLETED);
		this.connectedIcon = registerIcon(par1IconRegister, MultiblockState.CONNECTED);
		this.disconnectedIcon = registerIcon(par1IconRegister, MultiblockState.DISCONNECTED);
	}

	protected abstract Icon registerIcon(IconRegister iconRegister, MultiblockState state);

	@Override
	public boolean removeBlockByPlayer(World world, EntityPlayer player, int x, int y, int z) {
		ITileEntityMultiblockBlock entity = (ITileEntityMultiblockBlock) world.getBlockTileEntity(x, y, z);
		world.setBlockToAir(x, y, z);
		entity.destroyBlock();
		return true;
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int par5) {
		ITileEntityMultiblockBlock entity = (ITileEntityMultiblockBlock) world.getBlockTileEntity(x, y, z);
		entity.neighbourChanged();
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if (tileEntity == null || player.isSneaking() || (((ITileEntityMultiblockBlock) tileEntity).getState() != MultiblockState.COMPLETED)) {
			return false;
		}
		player.openGui(IndustrialProcessing.instance, 0, world, ((ITileEntityMultiblockBlock) tileEntity).getCoreX(), ((ITileEntityMultiblockBlock) tileEntity).getCoreY(), ((ITileEntityMultiblockBlock) tileEntity).getCoreZ());
		return true;
	}
}
