package ip.industrialProcessing.transport.fluids;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidTankInfo;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ConfigTransportBlocks;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.transport.BlockTransport;

public class BlockTransportFluids extends BlockTransport {

	public BlockTransportFluids() {
		this(ConfigTransportBlocks.getBlockTransportFluidsID(), Material.glass, Block.soundGlassFootstep, "Fluid Pipe");
	}

	protected BlockTransportFluids(int id, Material material, StepSound sound, String name) {
		super(id, material, 1F, sound, name, ISetupCreativeTabs.tabFluid);
	}

	@Override
	public boolean recolourBlock(World world, int x, int y, int z, ForgeDirection side, int colour) {

		int meta = world.getBlockMetadata(x, y, z);
		if (meta != colour) {
			world.setBlockMetadataWithNotify(x, y, z, colour, 3);
			TileEntity entity = world.getBlockTileEntity(x, y, z);
			if (entity instanceof TileEntityTransportFluidsBase) {
				TileEntityTransportFluidsBase pipe = (TileEntityTransportFluidsBase) entity;
				pipe.setConnectionGroup(colour);
			}
			return true;
		}
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityTransportFluids();
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererTransportFluidsId();
	}

	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z) {

		TileEntity entity = world.getBlockTileEntity(x, y, z);
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

	Icon[] icon = new Icon[16];

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		for (int i = 0; i < 16; i++) {
			icon[i] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "pipe" + i);
		}
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		return icon[par2];
	}

	@Override
	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
		return 1;
	}
}
