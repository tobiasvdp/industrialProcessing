package ip.industrialProcessing.multiblock;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.multiblock.interfaces.ITileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import ip.industrialProcessing.utils.inventories.InventoryUtils;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract class BlockMultiblockCore extends BlockContainer {

	protected BlockMultiblockCore(int par1, Material par2Material, float hardness, StepSound stepSound, String name, CreativeTabs tab) {
		super(par1, par2Material);
		setHardness(hardness);
		setStepSound(stepSound);
		setUnlocalizedName(name);
		setCreativeTab(tab);
		func_111022_d(INamepace.TEXTURE_NAME_PREFIX + "frame_full");
	}

	@Override
	public boolean removeBlockByPlayer(World world, EntityPlayer player, int x, int y, int z) {
		InventoryUtils.DropInventoryContents(world, x, y, z);
		ITileEntityMultiblockCore core = (ITileEntityMultiblockCore) world.getBlockTileEntity(x, y, z);
		if (core != null) {
			core.breakEntireStructure();
			world.setBlockToAir(x, y, z);
		}
		return true;
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int par5) {
		ITileEntityMultiblockCore core = (ITileEntityMultiblockCore) world.getBlockTileEntity(x, y, z);
		if (core != null) {
			// if (core.getState())
			// if (!core.checkStructure())
			world.notifyBlocksOfNeighborChange(x, y, z, world.getBlockId(x, y, z));
		}
		super.onNeighborBlockChange(world, x, y, z, par5);

	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if (tileEntity == null || player.isSneaking() || (((ITileEntityMultiblockCore) tileEntity).getState() != MultiblockState.COMPLETED)) {
			return false;
		}
		player.openGui(IndustrialProcessing.instance, 0, world, x, y, z);
		return true;
	}
}
