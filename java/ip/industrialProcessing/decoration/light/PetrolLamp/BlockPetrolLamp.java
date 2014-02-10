package ip.industrialProcessing.decoration.light.PetrolLamp;

import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.IRotateableEntity;

import java.util.Random;

import javax.swing.Icon;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockPetrolLamp extends BlockMachineRendered {

	private Icon[] icons = new Icon[2];

	public BlockPetrolLamp() {
		super(ConfigMachineBlocks.getBlockPetrolLamp(), Material.glass, 1f, soundMetalFootstep, "Petrol Lamp", ISetupCreativeTabs.tabFluid);
		// this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.8f);
		this.setTickRandomly(true);
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
		super.onBlockPlacedBy(world, x, y, z, entityLivingBase, itemStack);
		int dir = MathHelper.floor_double((entityLivingBase.rotationYaw * 4F) / 360F + 0.5D) & 3;
		IRotateableEntity machine = (IRotateableEntity) world.getBlockTileEntity(x, y, z);
		ForgeDirection forward = getForwardFromMetadata(dir);
		machine.setForwardDirection(forward);

	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityPetrolLamp();
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		par1 %= icons.length;
		return icons[par1];
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Stone");
		icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Iron");
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererPetrolLampId();
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
		if (par1World.getBlockMetadata(par2, par3, par4) == 0) {
			if (par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST, true)) {
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 2);
			} else if (par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST, true)) {
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
			} else if (par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH, true)) {
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
			} else if (par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH, true)) {
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
			}
		}
	}

	@Override
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
		return par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST, true) || par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST, true) || par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH, true) || par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH, true);
	}

	@Override
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		TileEntityPetrolLamp te = (TileEntityPetrolLamp) par1World.getBlockTileEntity(par2, par3, par4);

		if (te.lightChanged) {
			te.updateLight();
			te.lightChanged = false;
		}

		if (te.getForwardDirection() != null) {
			int l = te.getForwardDirection().ordinal();
			double d0 = par2 + 0.5F;
			double d1 = par3 + 0.18F;
			double d2 = par4 + 0.5F;
			double d3 = 0.18D;
			double d4 = 0.18D;

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
		TileEntityPetrolLamp te = (TileEntityPetrolLamp) world.getBlockTileEntity(x, y, z);
		return te.getLightLevel();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float clickX, float clickY, float clickZ) {
		TileEntityPetrolLamp te = (TileEntityPetrolLamp) world.getBlockTileEntity(x, y, z);
		if (te.getBurnTime() < 6000) {
			ItemStack item = player.getCurrentEquippedItem();
			if (item != null) {
				int val = GameRegistry.getFuelValue(item);
				if (val > 0) {
					te.increaseBurnTime(val * 10);
					if(item.itemID == Item.bucketLava.itemID)
						te.count = false;
					item.stackSize--;
					if (item == null || item.stackSize == 0) {
						item = null;
					}
					player.inventory.onInventoryChanged();
					System.out.println("Torch will burn for " + val * 10 + " ticks.");
				}
			}
		}
		return super.onBlockActivated(world, x, y, z, player, metadata, clickX, clickY, clickZ);
	}

}
