package ip.industrialProcessing.machines.filter;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.IndustrialProcessingConfig;
import ip.industrialProcessing.utils.inventories.InventoryUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockFilter extends BlockContainer {

	public BlockFilter() {
		super(IndustrialProcessingConfig.getFilterBlockID(), Material.iron);
		setHardness(1F);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName("Ore Filter");
		setCreativeTab(IndustrialProcessing.tabMachines);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int metadata, float what, float these,
			float are) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if (tileEntity == null || player.isSneaking()) {
			return false;
		}
		player.openGui(IndustrialProcessing.instance, 0, world, x, y, z);
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityFilter();
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
		InventoryUtils.DropInventoryContents(world, x, y, z);
		super.breakBlock(world, x, y, z, par5, par6);
	}

}
