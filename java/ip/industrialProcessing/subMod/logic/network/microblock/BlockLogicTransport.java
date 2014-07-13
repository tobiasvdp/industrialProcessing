package ip.industrialProcessing.subMod.logic.network.microblock;

import ip.industrialProcessing.microBlock.core.BlockMicroBlock;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public abstract class BlockLogicTransport extends BlockMicroBlock {

	protected BlockLogicTransport(int par1, Material par2Material, float hardness, StepSound stepSound, String name, CreativeTabs tab) {
		super(par1, par2Material, hardness, stepSound, name);
	}
	
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		TileEntityLogicTransport te = (TileEntityLogicTransport) par1World.getBlockTileEntity(par2, par3, par4);
		for(int i = 0;i<6;i++)
		System.out.println(i+" "+te.getLineID(i));
		return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
	}

}
