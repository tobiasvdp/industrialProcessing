package mod.industrialProcessing.plants.blackSmith.forge.dummy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import mod.industrialProcessing.blockContainer.multiblock.core.TileEntityMultiblockCore;
import mod.industrialProcessing.blockContainer.multiblock.dummy.BlockMultiblockDummy;
import mod.industrialProcessing.blockContainer.multiblock.utils.MultiblockState;
import mod.industrialProcessing.plants.blackSmith.forge.TileEntityForgeCore;

public class BlockForgeDummy extends BlockMultiblockDummy {

	public BlockForgeDummy() {
		super(1.0f,1.0f,Material.clay,Block.soundTypeGravel,"tile.IP.block.cobbleLimestone");
		this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
		TileEntityMultiblockCore te = ((TileEntityForgeDummy) world.getTileEntity(x, y, z)).getCore();
		if(te == null || te.getState() != MultiblockState.COMPLETED){
			return super.onBlockActivated(world, x, y, z, player, metadata, what, these, are);
		}
		if (player.getCurrentEquippedItem() != null && te != null) {
			((TileEntityForgeCore) te).handleRightClick(player);
				
		}
		return true;
	}

}
