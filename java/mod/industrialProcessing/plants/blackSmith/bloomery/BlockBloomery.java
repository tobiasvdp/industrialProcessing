package mod.industrialProcessing.plants.blackSmith.bloomery;

import java.util.ArrayList;
import java.util.Random;

import mod.industrialProcessing.blockContainer.multiblock.core.BlockMultiblockCore;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.gui.framework.panels.Orientation;
import mod.industrialProcessing.gui.generating.GuiBuilderDefault;
import mod.industrialProcessing.gui.generating.IGuiBuilder;
import mod.industrialProcessing.items.ISetupItems;
import mod.industrialProcessing.utils.block.IDescriptionBlock;
import mod.industrialProcessing.utils.block.IGuiMultiblock;
import mod.industrialProcessing.utils.block.IRecipeBlock;
import mod.industrialProcessing.work.recipe.RecipesMultiblock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBloomery extends BlockMultiblockCore implements IRecipeBlock, IDescriptionBlock, IGuiMultiblock {

	public static IGuiBuilder[] guiBuilders = new IGuiBuilder[2];
	static {
		guiBuilders[0] = new GuiBuilderDefault("Bloomery").addInputSlot(0).addOutputSlot(1).enableBurner(-1, 3, -1).enableThermometer().enableDurability().enableWorker();
		guiBuilders[1] = new GuiBuilderDefault("Bloomery").addInputSlot(0).addOutputSlot(1).enableBurner(-1, 3, -1).addInputSlotCluster(4, 2, 1, Orientation.VERTICAL).enableThermometer().enableDurability().enableWorker();
	}

	public BlockBloomery() {
		super(1.0f, 1.0f, Material.clay, Block.soundTypeGravel, "Bloomery");
		this.setTickRandomly(true);
	}

	@Override
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		TileEntityBloomery te = (TileEntityBloomery) par1World.getTileEntity(par2, par3, par4);
		if (te.getHeat() > 1538) {
			double d0 = par2 + 0.5F;
			double d1 = par3 + 0.1F;
			double b1 = par3 + 0.8F;
			double d2 = par4 + 0.5F;
			par1World.spawnParticle("smoke", d0, b1, d2, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("smoke", d0 - 0.1f, b1, d2, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("smoke", d0 + 0.1f, b1, d2, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("smoke", d0, b1, d2 + 0.1f, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("smoke", d0, b1, d2 - 0.1f, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("flame", d0, d1, d2, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("flame", d0 - 0.2f, d1, d2, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("flame", d0 + 0.2f, d1, d2, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("flame", d0, d1, d2 + 0.2f, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("flame", d0, d1, d2 - 0.2f, 0.0D, 0.0D, 0.0D);
		}
		super.randomDisplayTick(par1World, par2, par3, par4, par5Random);
	}

	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z) {
		TileEntityBloomery te = (TileEntityBloomery) world.getTileEntity(x, y, z);
		if (te.getHeat() > 1538) {
			return 10;
		}
		return 0;
	}

	@Override
	public RecipesMultiblock getRecipes() {
		return TileEntityBloomery.recipes;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block par5, int par6) {
		Random rand = new Random();
		ItemStack[] items = new ItemStack[] { new ItemStack(Items.brick, 3), new ItemStack(Blocks.sand, 2), new ItemStack(ISetupItems.itemHardenedSandDust), new ItemStack(Blocks.cobblestone) };
		for (int i = 0; i < items.length; i++) {
			ItemStack item = items[i];
			if (item != null && item.stackSize > 0) {
				float rx = rand.nextFloat() * 0.8F + 0.1F;
				float ry = rand.nextFloat() * 0.8F + 0.1F;
				float rz = rand.nextFloat() * 0.8F + 0.1F;

				EntityItem entityItem = new EntityItem(world, x + rx, y + ry, z + rz, new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));

				if (item.hasTagCompound()) {
					entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
				}

				float factor = 0.05F;
				entityItem.motionX = rand.nextGaussian() * factor;
				entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
				entityItem.motionZ = rand.nextGaussian() * factor;
				world.spawnEntityInWorld(entityItem);
				item.stackSize = 0;
			}
		}
		super.breakBlock(world, x, y, z, par5, par6);
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		return ret;
	}

	@Override
	public String getDescription() {
		return "A crappy furnace that can smelt your iron.";
	}

	@Override
	public IGuiBuilder getGui(Tiers tier) {
		return guiBuilders[tier.ordinal()];
	}
}
