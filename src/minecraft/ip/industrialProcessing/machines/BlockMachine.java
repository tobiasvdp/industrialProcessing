package ip.industrialProcessing.machines;

import cpw.mods.fml.common.Loader;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.subMod.logic.config.ISetupLogic;
import ip.industrialProcessing.utils.FluidTransfers;
import ip.industrialProcessing.utils.inventories.InventoryUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.IFluidHandler;

public abstract class BlockMachine extends BlockContainer {
    public BlockMachine(int par1, Material par2Material, float hardness, StepSound stepSound, String name, CreativeTabs tab) {
	super(par1, par2Material);
	setHardness(hardness);
	setStepSound(stepSound);
	setUnlocalizedName(name);
	setCreativeTab(tab);
	func_111022_d(INamepace.TEXTURE_NAME_PREFIX + "inputTop");
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float clickX, float clickY, float clickZ) {
	TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
	if (tileEntity == null || player.isSneaking()){
	    return false;
	}
	if(Loader.isModLoaded("IPLogic")){
	    if(checkIfEquiped(player)){
		return false;
	    }
	}
	ItemStack stack = player.inventory.getCurrentItem();
	if (stack != null) {
	    if (stack.itemID == ISetupItems.itemWrench.itemID)
		return false;
	}

        TileEntity te = world.getBlockTileEntity(x, y, z);
        if (te instanceof IFluidHandler) {
            if (FluidTransfers.handleRightClick(player, (IFluidHandler) te, clickX, clickY, clickZ))
                return true;
        }
	player.openGui(IndustrialProcessing.instance, 0, world, x, y, z);
	return true;
    }

    private boolean checkIfEquiped(EntityPlayer player) {
	//if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().itemID == ISetupLogic.BlockMachineInterface.blockID)
	  //  return true;
	return false;
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
	InventoryUtils.DropInventoryContents(world, x, y, z);
	super.breakBlock(world, x, y, z, par5, par6);
    }

    @Override
    public boolean canPlaceBlockAt(World par1World, int x, int y, int z) {
	boolean canPlace = true;
	int l = par1World.getBlockId(x, y, z);
	Block block = Block.blocksList[l];
	if (block != null) {
	    if (!block.isBlockReplaceable(par1World, x, y, z))
		canPlace = false;
	}
	return canPlace;
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
	BlockMachine.setRotation(world, x, y, z, entityLivingBase);
	super.onBlockPlacedBy(world, x, y, z, entityLivingBase, itemStack);
    }

    public static void setRotation(World world, int x, int y, int z, EntityLivingBase entityLivingBase) {
	TileEntity entity = world.getBlockTileEntity(x, y, z);
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

    @Deprecated
    public ForgeDirection getForwardFromMetadata(World world, int x, int y, int z) {
	int metadata = world.getBlockMetadata(x, y, z);
	return getForwardFromMetadata(metadata);
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
