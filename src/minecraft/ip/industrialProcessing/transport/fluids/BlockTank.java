package ip.industrialProcessing.transport.fluids;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ConfigTransportBlocks;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.BlockMachineRendered;

public class BlockTank extends BlockMachineRendered {

	private Icon tankIcon;
	private Icon tankFeaturesIcon;

	public BlockTank() {
		super(ConfigTransportBlocks.getBlockTransportFluidTankID(), Material.iron, 1F, Block.soundMetalFootstep, "Fluid Tank", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityTank();
	}

	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
		super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
		TileEntityTank tank = (TileEntityTank) par1World.getBlockTileEntity(par2, par3, par4);
		tank.searchForNeighbors();
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {

		this.tankIcon = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "tankSide");
		this.tankFeaturesIcon = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "tankFeatures");
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		if (par1 == 0)
			return tankIcon;
		if (par1 == 1)
			return tankFeaturesIcon;
		else
			return super.getIcon(par1, par2);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
		// no gui
		return false;
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererTankId();
	}
}
