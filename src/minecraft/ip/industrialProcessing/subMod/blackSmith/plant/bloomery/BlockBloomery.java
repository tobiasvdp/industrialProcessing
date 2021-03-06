package ip.industrialProcessing.subMod.blackSmith.plant.bloomery;

import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.generating.GuiBuilderDefault;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;
import ip.industrialProcessing.gui3.generating.IGuiMultiblock;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.recipes.IRecipeBlock;
import ip.industrialProcessing.subMod.blackSmith.IPBlackSmith;
import ip.industrialProcessing.subMod.blackSmith.config.ConfigBlackSmith;
import ip.industrialProcessing.utils.IDescriptionBlock;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBloomery extends BlockMultiblockCore implements IRecipeBlock, IDescriptionBlock, IGuiMultiblock {

    public static IGuiBuilder[] guiBuilders = new IGuiBuilder[2];
    static {
	guiBuilders[0] = new GuiBuilderDefault("Bloomery").addInputSlot(0).addOutputSlot(1).enableBurner(-1, 3, -1).enableThermometer().enableDurability().enableWorker();
	guiBuilders[1] = new GuiBuilderDefault("Bloomery").addInputSlot(0).addOutputSlot(1).enableBurner(-1, 3, -1).addInputSlotCluster(4, 2, 1, Orientation.VERTICAL).enableThermometer().enableDurability().enableWorker();
    }

    private Icon[] icons = new Icon[1];

    public BlockBloomery() {
	super(ConfigBlackSmith.getBlockBloomeryID(), "BlockBloomery", IPBlackSmith.tabBlackSmith);
	this.setTickRandomly(true);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	TileEntityBloomery te = new TileEntityBloomery();
	return te;
    }

    @Override
    public int getRenderType() {
	return ConfigBlackSmith.getRendererBloomeryId();
    }

    @Override
    public Icon getIcon(int par1, int par2) {
	par1 %= icons.length;
	return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
	icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Bloomery");
    }

    @Override
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
	TileEntityBloomery te = (TileEntityBloomery) par1World.getBlockTileEntity(par2, par3, par4);
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
	TileEntityBloomery te = (TileEntityBloomery) world.getBlockTileEntity(x, y, z);
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
    public int idDropped(int par1, Random par2Random, int par3) {
	return 0;
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
	Random rand = new Random();
	ItemStack[] items = new ItemStack[] { new ItemStack(Item.brick, 3), new ItemStack(Block.sand, 2), new ItemStack(ISetupItems.itemHardenedSandDust), new ItemStack(Block.cobblestone) };
	for (int i = 0; i < items.length; i++) {
	    ItemStack item = items[i];
	    if (item != null && item.stackSize > 0) {
		float rx = rand.nextFloat() * 0.8F + 0.1F;
		float ry = rand.nextFloat() * 0.8F + 0.1F;
		float rz = rand.nextFloat() * 0.8F + 0.1F;

		EntityItem entityItem = new EntityItem(world, x + rx, y + ry, z + rz, new ItemStack(item.itemID, item.stackSize, item.getItemDamage()));

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
    public String getDescription() {
	return "A crappy furnace that can smelt your iron.";
    }

    @Override
    public IGuiBuilder getGui(Tiers tier) {
	return guiBuilders[tier.ordinal()];
    }
}
