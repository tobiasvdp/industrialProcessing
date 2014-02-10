package ip.industrialProcessing.decoration.light;

import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.WEST;
import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.decoration.light.hangingLamp.TileEntityPetrolLamp;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.IRotateableEntity;

import java.util.Random;

import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.common.registry.GameRegistry;

public abstract class BlockLamp extends BlockMachineRendered {

    public BlockLamp(int par1, Material par2Material, float hardness, StepSound stepSound, String name, CreativeTabs tab) {
	super(par1, par2Material, hardness, stepSound, name, tab);
	this.setTickRandomly(true);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
	super.onBlockPlacedBy(world, x, y, z, entityLivingBase, itemStack);
	IRotateableEntity machine = (IRotateableEntity) world.getBlockTileEntity(x, y, z);
	ForgeDirection forward = getForwardFromMetadata(world.getBlockMetadata(x, y, z));
	machine.setForwardDirection(forward);

    }

    @Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
	super.updateTick(par1World, par2, par3, par4, par5Random);

	if (par1World.getBlockMetadata(par2, par3, par4) == 0) {
	    this.onBlockAdded(par1World, par2, par3, par4);
	}
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    @Override
    public void onBlockAdded(World par1World, int par2, int par3, int par4) {
	IRotateableEntity machine = (IRotateableEntity) par1World.getBlockTileEntity(par2, par3, par4);
	if (par1World.getBlockMetadata(par2, par3, par4) == 0) {
	    if (par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST, true)) {
		par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 2);
		ForgeDirection forward = getForwardFromMetadata(1);
		machine.setForwardDirection(forward);
	    } else if (par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST, true)) {
		par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
		ForgeDirection forward = getForwardFromMetadata(3);
		machine.setForwardDirection(forward);
	    } else if (par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH, true)) {
		par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
		ForgeDirection forward = getForwardFromMetadata(2);
		machine.setForwardDirection(forward);
	    } else if (par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH, true)) {
		par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
		ForgeDirection forward = getForwardFromMetadata(4);
		machine.setForwardDirection(forward);
	    }
	}
    }

    @Override
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
	return par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST, true) || par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST, true) || par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH, true) || par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH, true);
    }

    @Override
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
	TileEntityLamp te = (TileEntityLamp) par1World.getBlockTileEntity(par2, par3, par4);

	if (te.lightChanged) {
	    te.updateLight();
	    te.lightChanged = false;
	}

	if (te.getForwardDirection() != null) {
	    int l = te.getForwardDirection().ordinal();
	    double d0 = par2 + 0.5F;
	    double d1 = par3 + te.yOffset();
	    double d2 = par4 + 0.5F;
	    double d3 = te.xzOffset();
	    double d4 = te.xzOffset();

	    if (te.getLightLevel() > 8) {
		if (l == 1) {
		    par1World.spawnParticle("smoke", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
		    par1World.spawnParticle("flame", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
		} else if (l == 2) {
		    par1World.spawnParticle("smoke", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
		    par1World.spawnParticle("flame", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
		} else if (l == 3) {
		    par1World.spawnParticle("smoke", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
		    par1World.spawnParticle("flame", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
		} else if (l == 4) {
		    par1World.spawnParticle("smoke", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
		    par1World.spawnParticle("flame", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
		} else if (l == 5) {
		    par1World.spawnParticle("smoke", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
		    par1World.spawnParticle("flame", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
		}
	    } else if (te.getLightLevel() > 0) {
		if (l == 1) {
		    par1World.spawnParticle("smoke", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
		} else if (l == 2) {
		    par1World.spawnParticle("smoke", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
		} else if (l == 3) {
		    par1World.spawnParticle("smoke", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
		} else if (l == 4) {
		    par1World.spawnParticle("smoke", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
		} else if (l == 5) {
		    par1World.spawnParticle("smoke", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
		}
	    }
	}
    }

    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {
	TileEntityLamp te = (TileEntityLamp) world.getBlockTileEntity(x, y, z);
	return te.getLightLevel();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float clickX, float clickY, float clickZ) {
	TileEntityLamp te = (TileEntityLamp) world.getBlockTileEntity(x, y, z);
	if (te.getBurnTime() < 6000) {
	    te.addTo(player);
	}
	return super.onBlockActivated(world, x, y, z, player, metadata, clickX, clickY, clickZ);
    }
}
