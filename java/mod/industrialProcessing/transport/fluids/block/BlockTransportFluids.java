package mod.industrialProcessing.transport.fluids.block;

import mod.industrialProcessing.blockContainer.transport.BlockTransport;
import mod.industrialProcessing.transport.fluids.tileEntity.TileEntityTransportFluidsBase;
import mod.industrialProcessing.utils.creativeTab.ISetupCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidTankInfo;

public class BlockTransportFluids extends BlockTransport {

	public BlockTransportFluids() {
		this(1.0f,1.0f, Material.glass, Block.soundTypeGlass, "pipe0","pipe1","pipe2","pipe3","pipe4","pipe5","pipe6","pipe7","pipe8","pipe9","pipe10","pipe11","pipe12","pipe13","pipe14","pipe15");
	}

	protected BlockTransportFluids(float hardness, float resistance, Material material, SoundType soundtype, String... iconNames) {
		super(hardness, resistance, material, soundtype,  iconNames);
	}

	@Override
	public boolean recolourBlock(World world, int x, int y, int z, ForgeDirection side, int colour) {

		int meta = world.getBlockMetadata(x, y, z);
		if (meta != colour) {
			world.setBlockMetadataWithNotify(x, y, z, colour, 3);
			TileEntity entity = world.getTileEntity(x, y, z);
			if (entity instanceof TileEntityTransportFluidsBase) {
				TileEntityTransportFluidsBase pipe = (TileEntityTransportFluidsBase) entity;
				pipe.setConnectionGroup(colour);
			}
			return true;
		}
		return false;
	}

	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z) {

		TileEntity entity = world.getTileEntity(x, y, z);
		if (entity instanceof TileEntityTransportFluidsBase) {
			TileEntityTransportFluidsBase fluidBase = (TileEntityTransportFluidsBase) entity;
			FluidTankInfo[] subTanks = fluidBase.getTanks();

			if (subTanks != null) {
				int lum = 0;
				int tanks = 0;

				for (int i = 0; i < subTanks.length; i++) {
					FluidTankInfo tank = subTanks[i];
					if (tank.fluid != null) {
						lum += tank.fluid.getFluid().getLuminosity();
						tanks++;
					}
				}
				if (tanks > 0)
					return lum / tanks;
			}
		}
		return super.getLightValue(world, x, y, z);
	}

	@Override
	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
		return 1;
	}
}
