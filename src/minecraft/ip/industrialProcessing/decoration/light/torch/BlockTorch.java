package ip.industrialProcessing.decoration.light.torch;

import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.WEST;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.decoration.light.BlockLamp;
import ip.industrialProcessing.decoration.light.TileEntityLamp;
import ip.industrialProcessing.machines.IRotateableEntity;

public class BlockTorch extends BlockLamp {

	private Icon[] icons = new Icon[2];

	public BlockTorch() {
		super(ConfigMachineBlocks.getBlockTorchID(), Material.wood, 0.5f, Block.soundWoodFootstep, "BlockTorch", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityTorch();
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		return icons[par2/6];
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "torch_on");
		icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "torch_off");
	}

	@Override
	public int getRenderType() {
		return 2;
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return Item.stick.itemID;
	}

	@Override
	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {

	}

	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
		int j1 = par9;

		if (par5 == 1 && this.canPlaceTorchOn(par1World, par2, par3 - 1, par4)) {
			j1 = 5;
		}

		if (par5 == 2 && par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH, true)) {
			j1 = 4;
		}

		if (par5 == 3 && par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH, true)) {
			j1 = 3;
		}

		if (par5 == 4 && par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST, true)) {
			j1 = 2;
		}

		if (par5 == 5 && par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST, true)) {
			j1 = 1;
		}

		return j1;
	}

	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
		this.func_94397_d(par1World, par2, par3, par4, par5);
	}

	protected boolean func_94397_d(World par1World, int par2, int par3, int par4, int par5) {
		if (this.dropTorchIfCantStay(par1World, par2, par3, par4)) {
			int i1 = par1World.getBlockMetadata(par2, par3, par4)%6;
			boolean flag = false;

			if (!par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST, true) && i1 == 1) {
				flag = true;
			}

			if (!par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST, true) && i1 == 2) {
				flag = true;
			}

			if (!par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH, true) && i1 == 3) {
				flag = true;
			}

			if (!par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH, true) && i1 == 4) {
				flag = true;
			}

			if (!this.canPlaceTorchOn(par1World, par2, par3 - 1, par4) && i1 == 5) {
				flag = true;
			}

			if (flag) {
				this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4)%6, 0);
				par1World.setBlockToAir(par2, par3, par4);
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	/**
	 * Tests if the block can remain at its current location and will drop as an
	 * item if it is unable to stay. Returns True if it can stay and False if it
	 * drops. Args: world, x, y, z
	 */
	protected boolean dropTorchIfCantStay(World par1World, int par2, int par3, int par4) {
		if (!this.canPlaceBlockAt(par1World, par2, par3, par4)) {
			if (par1World.getBlockId(par2, par3, par4) == this.blockID) {
				this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4)%6, 0);
				par1World.setBlockToAir(par2, par3, par4);
			}

			return false;
		} else {
			return true;
		}
	}

	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		if (par1World.getBlockMetadata(par2, par3, par4) == 0) {
			if (par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST, true)) {
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 2);
			} else if (par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST, true)) {
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
			} else if (par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH, true)) {
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
			} else if (par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH, true)) {
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
			} else if (this.canPlaceTorchOn(par1World, par2, par3 - 1, par4)) {
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
			}
		}

		this.dropTorchIfCantStay(par1World, par2, par3, par4);
	}
	
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		super.updateTick(par1World, par2, par3, par4, par5Random);

		if (par1World.getBlockMetadata(par2, par3, par4)%6 == 0) {
			this.onBlockAdded(par1World, par2, par3, par4);
		}
	}

	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
		return par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST, true) || par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST, true) || par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH, true) || par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH, true) || canPlaceTorchOn(par1World, par2, par3 - 1, par4);
	}

	private boolean canPlaceTorchOn(World par1World, int par2, int par3, int par4) {
		if (par1World.doesBlockHaveSolidTopSurface(par2, par3, par4)) {
			return true;
		} else {
			int l = par1World.getBlockId(par2, par3, par4);
			return (Block.blocksList[l] != null && Block.blocksList[l].canPlaceTorchOnTop(par1World, par2, par3, par4));
		}
	}

	public MovingObjectPosition collisionRayTrace(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3) {
		int l = par1World.getBlockMetadata(par2, par3, par4)%6 & 7;
		float f = 0.15F;

		if (l == 1) {
			this.setBlockBounds(0.0F, 0.2F, 0.5F - f, f * 2.0F, 0.8F, 0.5F + f);
		} else if (l == 2) {
			this.setBlockBounds(1.0F - f * 2.0F, 0.2F, 0.5F - f, 1.0F, 0.8F, 0.5F + f);
		} else if (l == 3) {
			this.setBlockBounds(0.5F - f, 0.2F, 0.0F, 0.5F + f, 0.8F, f * 2.0F);
		} else if (l == 4) {
			this.setBlockBounds(0.5F - f, 0.2F, 1.0F - f * 2.0F, 0.5F + f, 0.8F, 1.0F);
		} else {
			f = 0.1F;
			this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.6F, 0.5F + f);
		}

		return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3, par6Vec3);
	}

	@SideOnly(Side.CLIENT)
	/**
	 * A randomly called display update to be able to add particles or other items for display
	 */
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {

		TileEntityLamp te = (TileEntityLamp) par1World.getBlockTileEntity(par2, par3, par4);

		if (te.lightChanged) {
			te.updateLight();
			te.lightChanged = false;
		}

		int l = par1World.getBlockMetadata(par2, par3, par4)%6;
		double d0 = (double) ((float) par2 + 0.5F);
		double d1 = (double) ((float) par3 + 0.7F);
		double d2 = (double) ((float) par4 + 0.5F);
		double d3 = 0.2199999988079071D;
		double d4 = 0.27000001072883606D;

		if (te.getLightLevel() > 8) {
			if (l == 1) {
				par1World.spawnParticle("smoke", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
			} else if (l == 2) {
				par1World.spawnParticle("smoke", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
			} else if (l == 3) {
				par1World.spawnParticle("smoke", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
			} else if (l == 4) {
				par1World.spawnParticle("smoke", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
			} else {
				par1World.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", d0, d1, d2, 0.0D, 0.0D, 0.0D);
			}
		} else if (te.getLightLevel() > 0) {
			if (l == 1) {
				par1World.spawnParticle("smoke", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
			} else if (l == 2) {
				par1World.spawnParticle("smoke", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
			} else if (l == 3) {
				par1World.spawnParticle("smoke", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
			} else if (l == 4) {
				par1World.spawnParticle("smoke", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
			} else {
				par1World.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
			}
		}
	}
}
