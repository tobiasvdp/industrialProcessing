package ip.industrialProcessing.machines.multiblock;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.utils.Position;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.BiomeEvent.CreateDecorator;

public abstract class BlockMultiMachineFrame extends BlockContainer {

	public BlockMultiMachineFrame(int blockId, CreativeTabs tab) {
		super(blockId, Material.iron);
		setCreativeTab(tab); 
	}
  
	@Override
	public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
		super.breakBlock(world, x, y, z, par5, par6);
		MultiblockUtils.notifyFrameBreak(world, x, y, z);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int par5) {
		MultiblockUtils.frameNeighborUpdated(world, x, y, z);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	} 

	@Override
    public boolean renderAsNormalBlock(){                
		return false;        
	}
	
	protected abstract int getIdForState(MachineFrameState state);
}
