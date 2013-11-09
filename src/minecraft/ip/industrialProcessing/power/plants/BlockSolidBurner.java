package ip.industrialProcessing.power.plants;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.BlockMachineRendered;

public class BlockSolidBurner extends BlockMachineRendered {

	private Icon[] icons = new Icon[3];

    public BlockSolidBurner() {
		super(ConfigMachineBlocks.getSolidBurnerBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Solid Burner", IndustrialProcessing.tabPower);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntitySolidBurner();
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererSolidBurnerId();
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * A randomly called display update to be able to add particles or other items for display
	 */
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		TileEntitySolidBurner burner = (TileEntitySolidBurner) par1World.getBlockTileEntity(par2, par3, par4);
		if (burner.isBurning()) {
			float f = (float) par2 + 0.5F;
			float f1 = (float) par3 + 0.0F + par5Random.nextFloat() * 6.0F / 16.0F;
			float f2 = (float) par4 + 0.5F;

			float x = par2 + par5Random.nextFloat()/2+0.25f;
			float y = par3 + 1;
			float z = par4 + par5Random.nextFloat()/2+0.25f;

			par1World.spawnParticle("smoke", x, y, z, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("flame", x, y, z, 0.0D, 0.0D, 0.0D);
		}
	}

    @Override
    public Icon getIcon(int par1, int par2) {
        par1 %= icons.length;        
        return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        icons[1] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "tankSide");
        icons[0] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "conveyorHopperFeatures");
        icons[2] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "burnerGrill");
    }
}
