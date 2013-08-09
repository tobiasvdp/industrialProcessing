package ip.industrialProcessing.fluids;

import ip.industrialProcessing.IndustrialProcessing;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.terraingen.BiomeEvent.CreateDecorator;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidBlock;

public class BlockFluid extends BlockFluidClassic implements IFluidBlock{

	public BlockFluid(int id, Fluid fluid, Material material, CreativeTabs tab) {
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
	public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
		if (world.getBlockMaterial(x,  y,  z).isLiquid()) return false;
		return super.canDisplace(world, x, y, z);
	}


	@Override
	public boolean displaceIfPossible(World world, int x, int y, int z) {
		if (world.getBlockMaterial(x,  y,  z).isLiquid()) return false;
		return super.displaceIfPossible(world, x, y, z);
	}


}
