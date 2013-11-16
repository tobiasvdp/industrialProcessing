package ip.industrialProcessing.machines.blastFurnace;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.MachineItemStack;

public class BlockBlastFurnace extends BlockMachineRendered {

	public BlockBlastFurnace() {
		super(ConfigMachineBlocks.getBlastFurnaceID(), Material.iron, 1F, Block.soundMetalFootstep, "Blast Furnace", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		TileEntityBlastFurnace te = new TileEntityBlastFurnace();
		te.setName(getLocalizedName());
		return te;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if (tileEntity == null || player.isSneaking()) {
			return false;
		}
		if (((TileEntityBlastFurnace) tileEntity).isDummyBlock(world, x, y, z))
			player.openGui(IndustrialProcessing.instance, 0, world, x, y - 1, z);
		else
			// if (((TileEntityBlastFurnace)
			// tileEntity).hasDummyBlock(world,x,y,z))
			player.openGui(IndustrialProcessing.instance, 0, world, x, y, z);
		return true;
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int par5) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if (((TileEntityBlastFurnace) tileEntity).isDummyBlock(world, x, y, z) != ((TileEntityBlastFurnace) tileEntity).isDummyBlock) {
			world.destroyBlock(x, y, z, false);
			world.setBlock(x, y, z, ConfigMachineBlocks.getBlastFurnaceID());
		}

	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererBlastFurnaceId();
	}

}
