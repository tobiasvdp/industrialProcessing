package mod.industrialProcessing.plants.machine.treetap;

import mod.industrialProcessing.block.ISetupBlocks;
import mod.industrialProcessing.block.tree.BlockRubberLog;
import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.blockContainer.BlockContainerIPRendered;
import mod.industrialProcessing.gui.generating.GuiBuilderDefault;
import mod.industrialProcessing.gui.generating.IGuiBuilder;
import mod.industrialProcessing.utils.block.IDescriptionBlock;
import mod.industrialProcessing.utils.block.IGuiBlock;
import mod.industrialProcessing.utils.rotation.IRotateableEntity;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockManualTreeTap extends BlockContainerIPRendered implements IDescriptionBlock, IGuiBlock {
	public static final String UNLOCALIZED_NAME = "IP.Machine.ManualTreetap";
	private static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).addInputSlot(0).addOutputSlot(1).enableWorker();

	public BlockManualTreeTap() {
		super(1.0f, 1.0f, Material.iron, Block.soundTypeMetal, "manualTreeTap");
	}

	@Override
	public boolean canPlaceBlockOnSide(World par1World, int par2, int par3, int par4, int par5) {

		ForgeDirection side = ForgeDirection.getOrientation(par5).getOpposite();
		Block id = par1World.getBlock(par2 + side.offsetX, par3 + side.offsetY, par4 + side.offsetZ);
		if (id.equals(ISetupBlocks.blockPineLog) || id.equals(ISetupBlocks.blockRubberLog)) {
			return BlockRubberLog.isCarved(par1World, par2 + side.offsetX, par3 + side.offsetY, par4 + side.offsetZ, par5);
		} else
			return false;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
		// super.onBlockPlacedBy(world, x, y, z, entityLivingBase, itemStack);

		TileEntity entity = world.getTileEntity(x, y, z);
		if (entity instanceof IRotateableEntity) {

			int dir = MathHelper.floor_double((entityLivingBase.rotationYaw * 4F) / 360F + 0.5D) & 3;
			for (int i = dir; i < dir + 4; i++) {
				int d = i % 4;
				ForgeDirection direction = BlockContainerIP.getForwardFromMetadata(d);

				boolean isConnected = canStayAt(world, x, y, z, direction);
				if (isConnected) {
					((IRotateableEntity) entity).setForwardDirection(direction);
					break;
				}
			}

		}
	}

	private static boolean canStayAt(World world, int x, int y, int z, ForgeDirection direction) {
		Block id = world.getBlock(x - direction.offsetX, y - direction.offsetY, z - direction.offsetZ);
		if (id.equals(ISetupBlocks.blockRubberLog) || id.equals(ISetupBlocks.blockPineLog)) {
			if (BlockRubberLog.isCarved(world, x - direction.offsetX, y - direction.offsetY, z - direction.offsetZ, direction.ordinal())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5) {
		super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
		if (!canBlockStay(par1World, par2, par3, par4))
			par1World.func_147480_a(par2, par3, par4, true);
	}

	@Override
	public boolean canBlockStay(World par1World, int par2, int par3, int par4) {
		TileEntity entity = par1World.getTileEntity(par2, par3, par4);
		ForgeDirection dir = BlockContainerIP.getForwardFromEntity(entity);
		return canStayAt(par1World, par2, par3, par4, dir);
	}

	/**
	 * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z,
	 * side, hitX, hitY, hitZ, block metadata
	 */
	@Override
	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {

		return super.onBlockPlaced(par1World, par2, par3, par4, par5, par6, par7, par8, par9);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1iBlockAccess, int par2, int par3, int par4) {
		ForgeDirection direction = BlockContainerIP.getForwardFromEntity(par1iBlockAccess.getTileEntity(par2, par3, par4));
		switch (direction) {
		case NORTH:
			setBlockBounds(2 / 16f, 2 / 16f, 12 / 16f, 8 / 16f, 6 / 16f, 1f);
			break;
		case EAST:
			setBlockBounds(0, 2 / 16f, 2 / 16f, 4 / 16f, 6 / 16f, 8 / 16f);
			break;
		case SOUTH:
			setBlockBounds(8 / 16f, 2 / 16f, 0, 14 / 16f, 6 / 16f, 4 / 16f);
			break;
		case WEST:
			setBlockBounds(12 / 16f, 2 / 16f, 8 / 16f, 1f, 6 / 16f, 14 / 16f);
			break;
		default:
			break;
		}

		super.setBlockBoundsBasedOnState(par1iBlockAccess, par2, par3, par4);
	}

	@Override
	public IGuiBuilder getGui() {
		return guiBuilder;
	}

	@Override
	public String getDescription() {
		return "Collects secretion fluids from trees in buckets";
	}
}
