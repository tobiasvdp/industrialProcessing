package mod.industrialProcessing.plants.blackSmith.forge;

import java.util.Random;

import javax.swing.Icon;

import mod.industrialProcessing.blockContainer.multiblock.IMultiblock;
import mod.industrialProcessing.blockContainer.multiblock.coreAndDummy.BlockMultiblockSwitcher;
import mod.industrialProcessing.blockContainer.multiblock.coreAndDummy.ITileEntityMultiblockSwitcher;
import mod.industrialProcessing.blockContainer.multiblock.layout.StructureMultiblock;
import mod.industrialProcessing.utils.INamepace;
import mod.industrialProcessing.utils.block.IDescriptionMultiblock;
import mod.industrialProcessing.utils.block.IGuiMultiblock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockForge  extends BlockMultiblockSwitcher  implements IDescriptionMultiblock{
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block par5, int par6) {
		// TODO Auto-generated method stub
		super.breakBlock(world, x, y, z, par5, par6);
	}

	public BlockForge() {
		super(1.0f,1.0f,Material.clay,Block.soundTypeGravel,"tile.IP.block.cobbleLimestone");
		this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
		setTickRandomly(true);
	}

	@Override
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		ITileEntityMultiblockSwitcher switcher = (ITileEntityMultiblockSwitcher) par1World.getTileEntity(par2, par3, par4);
		if(switcher.isCore() && switcher instanceof TileEntityForgeCore){
			((TileEntityForgeCore) switcher).burn();
		}
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block par5) {
		ITileEntityMultiblockSwitcher switcher = (ITileEntityMultiblockSwitcher) world.getTileEntity(x, y, z);
		if(switcher.isCore()){
			((TileEntityForgeCore) switcher).canBurnBlock();
		}
		super.onNeighborBlockChange(world, x, y, z, par5);
	}
	
	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z) {
		return 10;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
		ITileEntityMultiblockSwitcher switcher = (ITileEntityMultiblockSwitcher) world.getTileEntity(x, y, z);
		if (switcher.isCore()) {
			TileEntityForgeCore te = (TileEntityForgeCore) world.getTileEntity(x, y, z);
			if (player.getCurrentEquippedItem() != null) {
				te.handleRightClick(player);
			}
		} else {
			TileEntityForgeDummy te = (TileEntityForgeDummy) world.getTileEntity(x, y, z);
			if (player.getCurrentEquippedItem() != null) {
				te.handleRightClick(player);
			}
		}
		return super.onBlockActivated(world, x, y, z, player, metadata, what, these, are);
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
