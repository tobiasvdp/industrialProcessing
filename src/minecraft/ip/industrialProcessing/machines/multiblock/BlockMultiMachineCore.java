package ip.industrialProcessing.machines.multiblock;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.utils.inventories.InventoryUtils;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract class BlockMultiMachineCore extends BlockContainer {

	protected BlockMultiMachineCore(int par1, Material par2Material,
			float hardness, StepSound stepSound, String name, CreativeTabs tab) {
		super(par1, par2Material);
		setHardness(hardness);
		setStepSound(stepSound);
		setUnlocalizedName(name);
		setCreativeTab(tab);
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
		InventoryUtils.DropInventoryContents(world, x, y, z);
		breakUpdate(world, x, y, z, this.blockID);
		super.breakBlock(world, x, y, z, par5, par6);
	}

	static void breakUpdate(World world, int x, int y, int z, int blockId) {
		MultiblockUtils.breakCore(world, x, y, z);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int par5) {

		MultiblockUtils.coreNeighborUpdate(world, x, y, z); 
		super.onNeighborBlockChange(world, x, y, z, par5);

	}

}
