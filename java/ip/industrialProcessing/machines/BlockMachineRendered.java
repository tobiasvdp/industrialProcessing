package ip.industrialProcessing.machines;

import ip.industrialProcessing.client.ClientProxy;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

public abstract class BlockMachineRendered extends BlockMachine {

	public BlockMachineRendered(int par1, Material par2Material, float hardness, StepSound stepSound, String name, CreativeTabs tab) {
		super(par1, par2Material, hardness, stepSound, name, tab);
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
	
	@Override
	public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return false;//super.canPlaceTorchOnTop(world, x, y, z);
	}
}
