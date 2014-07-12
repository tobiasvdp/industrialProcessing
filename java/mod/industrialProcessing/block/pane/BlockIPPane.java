package mod.industrialProcessing.block.pane;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mod.industrialProcessing.utils.INamepace;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockIPPane extends net.minecraft.block.BlockPane{
	
    String name;
    
	public BlockIPPane(String par2Str, String par3Str, Material par4Material, boolean par5) {
		super(INamepace.TEXTURE_NAME_PREFIX + par2Str + "1", INamepace.TEXTURE_NAME_PREFIX + par3Str + "1", par4Material, par5);
		name = par2Str;
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
    

    IIcon[] icon = new IIcon[16];
    
    @Override
    public void registerBlockIcons(IIconRegister p_149651_1_) {
        for (int i = 0; i < 16; i++) {
			icon[i] = p_149651_1_.registerIcon(INamepace.TEXTURE_NAME_PREFIX + name + i);
        }
    }

    @Override
    public IIcon getIcon(int par1, int par2) {
        return icon[par2];
    }   
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon func_150097_e()
    {
        return icon[0];
    }
	
}
