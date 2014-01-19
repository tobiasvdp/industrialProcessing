package ip.industrialProcessing.buildingBlock;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.transport.fluids.TileEntityTransportFluidsBase;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockPane extends net.minecraft.block.BlockPane{
	
    String name;
    
	public BlockPane(int par1, String par2Str, String par3Str, Material par4Material, boolean par5) {
		super(par1, INamepace.TEXTURE_NAME_PREFIX + par2Str + "1", INamepace.TEXTURE_NAME_PREFIX + par3Str + "1", par4Material, par5);
		name = par2Str;
		this.setCreativeTab(ISetupCreativeTabs.tabMachineParts);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	
	
    @Override
    public boolean recolourBlock(World world, int x, int y, int z, ForgeDirection side, int colour) {

        int meta = world.getBlockMetadata(x, y, z);
        if (meta != colour) {
            world.setBlockMetadataWithNotify(x, y, z, colour, 3);
            return true;
        }
        return false;
    }
    

    Icon[] icon = new Icon[16];

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        for (int i = 0; i < 16; i++) {
			icon[i] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + name + i);
        }
    }

    @Override
    public Icon getIcon(int par1, int par2) {
        return icon[par2];
    }
    
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getSideTextureIndex() {
		return icon[0];
	}
    
	
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		System.out.println(par1World.getBlockMetadata(par2, par3, par4));
		return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
	}

}
