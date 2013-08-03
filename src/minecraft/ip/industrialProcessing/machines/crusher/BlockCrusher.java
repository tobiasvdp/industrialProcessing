package ip.industrialProcessing.machines.crusher;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.IndustrialProcessingConfig;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCrusher extends BlockContainer {

	public BlockCrusher() {
		super(IndustrialProcessingConfig.getCrusherBlockID(), Material.iron);
		setHardness(1F);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName("Ore Crusher");
		setCreativeTab(IndustrialProcessing.tabMachines);
	}

	@Override
	 public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int par6, float par7, float par8, float par9)
	    {
	        if (world.isRemote)
	        {
	            return true;
	        }
	        else
	        {
	        	TileEntityCrusher tileEntityCrusher = (TileEntityCrusher)world.getBlockTileEntity(x, y, z);

	            if (tileEntityCrusher != null)
	            {
	            	//entityPlayer.openGui(industrialProcessing.instance, 0, world, x, y, z);
	            }

	            return true;
	        }
	    }
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityCrusher();
	}

}
