package ip.industrialProcessing.multiblock;

import java.util.HashSet;

import javax.jws.Oneway;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import ip.industrialProcessing.multiblock.utils.MultiblockUtils;
import ip.industrialProcessing.utils.Position;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.event.terraingen.BiomeEvent.CreateDecorator;

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
		return disconnectedIcon;
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
		ITileEntityMultiblockBlock block = (ITileEntityMultiblockBlock) world.getBlockTileEntity(x, y, z);
		if (block != null) {
			ITileEntityMultiblockCore core = block.getCore(world);
			if (core != null) {
				world.setBlockToAir(x, y, z);
				core.checkStructure();
				world.notifyBlocksOfNeighborChange(x, y, z, 0);
				world.markBlockForUpdate(x, y, z);
			} else {
				world.setBlockToAir(x, y, z);
			}
		}
		return true;
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int par5) {
		ITileEntityMultiblockBlock block = (ITileEntityMultiblockBlock) world.getBlockTileEntity(x, y, z);
		if (block != null) {
			ITileEntityMultiblockCore core = block.getCore(world);
			if (core != null) {
				if (block.getState() != core.getState()) {
					block.setState(core.getState());
					if (block.getState() == MultiblockState.DISCONNECTED) {
						block.setCore(null);
					}
					world.notifyBlocksOfNeighborChange(x, y, z, world.getBlockId(x, y, z));
					world.markBlockForUpdate(x, y, z);
				}
			} else {
				for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
					TileEntity neighbour = world.getBlockTileEntity(x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ);
					if (neighbour instanceof ITileEntityMultiblockBlock) {
						if (!block.hasCore()) {
							if (((ITileEntityMultiblockBlock) neighbour).hasCore()) {
								if (((ITileEntityMultiblockBlock) neighbour).getCore(world) != null) {
									ITileEntityMultiblockCore neighbourCore = ((ITileEntityMultiblockBlock) neighbour).getCore(world);
									if (neighbourCore.isPartOfStructure(x, y, z, world.getBlockId(x, y, z))) {
										block.setCore(((ITileEntityMultiblockCore) neighbourCore));
										((ITileEntityMultiblockCore) neighbourCore).checkStructure();
										if (block.getState() != neighbourCore.getState()) {
											block.setState(((ITileEntityMultiblockCore) neighbourCore).getState());
											world.markBlockForUpdate(x, y, z);
											world.notifyBlocksOfNeighborChange(x, y, z, world.getBlockId(x, y, z));
										}
									}
								}
							}
						}
					} else if (neighbour instanceof ITileEntityMultiblockCore) {
						if (!block.hasCore()) {
							if (((ITileEntityMultiblockCore) neighbour).isPartOfStructure(x, y, z, world.getBlockId(x, y, z))) {
								block.setCore(((ITileEntityMultiblockCore) neighbour));
								((ITileEntityMultiblockCore) neighbour).checkStructure();
								if (block.getState() != ((ITileEntityMultiblockCore) neighbour).getState()) {
									block.setState(((ITileEntityMultiblockCore) neighbour).getState());
									world.notifyBlocksOfNeighborChange(x, y, z, world.getBlockId(x, y, z));
								}
							}
						}
					}
				}
			}
		}
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
