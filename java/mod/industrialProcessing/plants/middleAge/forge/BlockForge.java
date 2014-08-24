package mod.industrialProcessing.plants.middleAge.forge;

import java.util.Random;
import java.util.Vector;

import javax.swing.Icon;

import mod.industrialProcessing.blockContainer.multiblock.IMultiblock;
import mod.industrialProcessing.blockContainer.multiblock.core.BlockMultiblockCore;
import mod.industrialProcessing.blockContainer.multiblock.coreAndDummy.BlockMultiblockSwitcher;
import mod.industrialProcessing.blockContainer.multiblock.coreAndDummy.ITileEntityMultiblockSwitcher;
import mod.industrialProcessing.blockContainer.multiblock.layout.StructureMultiblock;
import mod.industrialProcessing.blockContainer.multiblock.utils.MultiblockState;
import mod.industrialProcessing.plants.middleAge.forge.dummy.TileEntityForgeDummy;
import mod.industrialProcessing.utils.INamepace;
import mod.industrialProcessing.utils.block.IDescriptionMultiblock;
import mod.industrialProcessing.utils.block.IGuiMultiblock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockForge extends BlockMultiblockCore implements IDescriptionMultiblock {

	public BlockForge() {
		super(1.0f, 1.0f, Material.clay, Block.soundTypeGravel, "tile.IP.block.cobbleLimestone", "tile.IP.blacks.forge");
		this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
		setTickRandomly(true);
	}

	@Override
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		TileEntityForgeCore switcher = (TileEntityForgeCore) par1World.getTileEntity(par2, par3, par4);
		if (switcher.lightChanged){
			switcher.updateLight();
			switcher.lightChanged = false;
		}
		switcher.burn();
	}

	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z) {
		TileEntityForgeCore core = (TileEntityForgeCore) world.getTileEntity(x, y, z);
		if (core.burnTime > 1000)
			return 15;
		return 0;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
		TileEntityForgeCore te = (TileEntityForgeCore) world.getTileEntity(x, y, z);
		if (te.getState() != MultiblockState.COMPLETED) {
			return super.onBlockActivated(world, x, y, z, player, metadata, what, these, are);
		}
		if (player.getCurrentEquippedItem() != null) {
			te.handleRightClick(player);

		}
		return true;
	}

	@Override
	public String getDescription() {
		return "Heat your materials in here to a point where they can be shaped at will.";
	}

	@Override
	public StructureMultiblock getStructure() {
		return TileEntityForgeCore.structure;
	}

}
