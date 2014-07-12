package mod.industrialProcessing.blockContainer;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.fluids.FluidTransfers;
import mod.industrialProcessing.items.ISetupItems;
import mod.industrialProcessing.plants.grinding.crusher.TileEntityCrusher;
import mod.industrialProcessing.utils.block.IUpgradableBlock;
import mod.industrialProcessing.utils.inventory.InventoryUtils;
import mod.industrialProcessing.utils.registry.TileEntityRegistry;
import mod.industrialProcessing.utils.rotation.IRotateableEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.IFluidHandler;

public abstract class BlockContainerIP extends BlockContainer {
	public BlockContainerIP(float hardness, float resistance, Material material, SoundType soundtype) {
		super(material);
		setHardness(hardness);
		setResistance(resistance);
		setStepSound(stepSound);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int var) {
		TileEntity te = TileEntityRegistry.createNewTileEntity(this);
		return te;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float clickX, float clickY, float clickZ) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (tileEntity == null || player.isSneaking()) {
			return false;
		}
		ItemStack stack = player.inventory.getCurrentItem();
		if (stack != null) {
			if (stack.getItem() == ISetupItems.itemWrench)
				return false;
			if (stack.getItem() == ISetupItems.itemBlowingTorch){
				if(this instanceof IUpgradableBlock){
					player.openGui(IndustrialProcessing.instance, 4, world, x, y, z);
				}
				return false;
			}	
		}

		TileEntity te = world.getTileEntity(x, y, z);
		if (te instanceof IFluidHandler) {
			if (FluidTransfers.handleRightClick(player, (IFluidHandler) te, clickX, clickY, clickZ))
				return true;
		}
		player.openGui(IndustrialProcessing.instance, 0, world, x, y, z);
		return true;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block par5, int par6) {
		InventoryUtils.DropInventoryContents(world, x, y, z);
		super.breakBlock(world, x, y, z, par5, par6);
	}

	@Override
	public boolean canPlaceBlockAt(World par1World, int x, int y, int z) {
		boolean canPlace = true;
		Block block = par1World.getBlock(x, y, z);
		if (block != null) {
			if (!block.isReplaceable(par1World, x, y, z))
				canPlace = false;
		}
		return canPlace;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
		BlockContainerIP.setRotation(world, x, y, z, entityLivingBase);
		super.onBlockPlacedBy(world, x, y, z, entityLivingBase, itemStack);
	}

	public static void setRotation(World world, int x, int y, int z, EntityLivingBase entityLivingBase) {
		TileEntity entity = world.getTileEntity(x, y, z);
		if (entity instanceof IRotateableEntity) {
			setRotation((IRotateableEntity) entity, entityLivingBase);
		}
	}

	public static void setRotation(IRotateableEntity entity, EntityLivingBase entityLivingBase) {
		int dir = MathHelper.floor_double((entityLivingBase.rotationYaw * 4F) / 360F + 0.5D) & 3;
		IRotateableEntity machine = entity;
		ForgeDirection forward = getForwardFromMetadata(dir);
		if (entityLivingBase.isSneaking())
			forward = forward.getOpposite();
		machine.setForwardDirection(forward);
	}

	public static ForgeDirection getForwardFromMetadata(int metadata) {
		switch (metadata) {
		case 0:
			return ForgeDirection.NORTH;
		case 1:
			return ForgeDirection.EAST;
		case 2:
			return ForgeDirection.SOUTH;
		case 3:
			return ForgeDirection.WEST;
		}
		return null;
	}

	public static int getMetadataFromForward(ForgeDirection dir) {
		if (dir == null)
			return 0;
		switch (dir) {
		case NORTH:
			return 0;
		case EAST:
			return 1;
		case SOUTH:
			return 2;
		case WEST:
			return 3;
		default:
			return 0;
		}
	}

	public static ForgeDirection getForwardFromEntity(TileEntity tl) {
		if (tl instanceof IRotateableEntity) {
			IRotateableEntity rotated = (IRotateableEntity) tl;
			return rotated.getForwardDirection();
		}
		return ForgeDirection.NORTH;
	}

}
