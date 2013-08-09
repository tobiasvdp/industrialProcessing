package ip.industrialProcessing.fluids;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.BiomeEvent.CreateDecorator;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class BlockFluidBaseDirtyWater extends BlockFluidBase {

	public BlockFluidBaseDirtyWater(int id, Fluid fluid, Material material, CreativeTabs tab) {
		super(id, fluid, material);
		setUnlocalizedName("Block"+fluid.getUnlocalizedName());
		setCreativeTab(tab);
		this.disableStats();
	}

	@Override
	public FluidStack drain(World world, int x, int y, int z, boolean doDrain) {
		return null;
	}

	@Override
	public boolean canDrain(World world, int x, int y, int z) {
		return true;
	}

	@Override
	public int getQuantaValue(IBlockAccess world, int x, int y, int z) {
		return 0;
	}

	@Override
	public boolean canCollideCheck(int meta, boolean fullHit) {
		return false;
	}

	@Override
	public int getMaxRenderHeightMeta() {
		return 0;
	}

}
