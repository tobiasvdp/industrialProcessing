package ip.industrialProcessing.multiblock.core.block.plants.storage.container;

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
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.multiblock.core.BLmultiblockCore;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.core.block.plants.blacksmith.bloomery.TileEntityBloomery;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import ip.industrialProcessing.recipes.IRecipeBlock;

public class BlockContainer extends BLmultiblockCore{
	private Icon[] icons = new Icon[1];

	public BlockContainer() {
		super(ConfigMachineBlocks.getBlockContainerID(), "BlockContainer", IndustrialProcessing.tabMultiblocks);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		TileEntityContainer te = new TileEntityContainer();
		return te;
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererContainer();
	}
	
	@Override
	public Icon getIcon(int par1, int par2) {
		par1 %= icons.length;
		return icons[par1];
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		icons[0] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "red");
	}
}
