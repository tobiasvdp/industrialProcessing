package mod.industrialProcessing.block.crystals;

import mod.industrialProcessing.block.BlockIPRendered;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockCrystal extends BlockIPRendered {
	public BlockCrystal() {
		super(1.f, 1.0f, Material.glass, Block.soundTypeGlass);
		this.setBlockBounds(0, 0, 0, 1, 1, 1);
		setBlockBounds(0.25f, 0, 0.25f, 0.75f, 0.5f, 0.75f);
	}

	@Override
	public boolean canBlockStay(World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		System.out.println("can it stay");

		if (y <= 0)
			return false;
		Block block = world.getBlock(x, y - 1, z);
		if (block == null)
			return false;

		return (block.isSideSolid(world, x, y - 1, z, ForgeDirection.UP));
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return canBlockStay(world, x, y, z);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		// TODO Auto-generated method stub
		super.onNeighborBlockChange(world, x, y, z, block);
		if (!canBlockStay(world, x, y, z)) {
			world.setBlockToAir(x, y, z); 
		}
	}
}
