package ip.industrialProcessing.multiblock;

import ip.industrialProcessing.client.ClientProxy;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockMultiblockBlockRendered extends BlockMultiblockBlock {

	public BlockMultiblockBlockRendered(int par1, String name, CreativeTabs tab){
		super(par1, name, tab);
	}

	@Override
	protected Icon registerIcon(IconRegister iconRegister, MultiblockState state) {
		return null;
	}
	
    @Override
    public boolean isOpaqueCube() {
	return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
	return false;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l) {
	return false;
    }

    @Override
    public int getRenderBlockPass() {
	return 1;
    }

    @Override
    public boolean canRenderInPass(int pass) {
	// this looks weird??????
	// Set the static var in the client proxy
	ClientProxy.renderPass = pass;
	// the block can render in both passes, so return true always
	return true;
    }

}