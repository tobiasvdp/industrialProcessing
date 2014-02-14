package mod.industrialProcessing.blocks;

import javax.swing.Icon;

import mod.industrialProcessing.utils.INamepace;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockIPRendered extends BlockIP {

	int renderID;
	 IIcon[] icons;
	 String[] iconNames;
	 boolean multipleIcons = false;

	public BlockIPRendered(float hardness, float resistance, Material material, SoundType soundtype, String... iconNames) {
		super(hardness, resistance, material, soundtype);
		if(iconNames != null && iconNames.length > 0){
			this.iconNames = iconNames;
			icons = new IIcon[iconNames.length];
			multipleIcons = true;
		}
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

	public void setRenderID(int id) {
		renderID = id;
	}

	@Override
	public int getRenderType() {
		return renderID;
	}
	
	 @Override
	    public IIcon getIcon(int par1, int par2) {
		 if(multipleIcons){
	        par1 %= icons.length;        
	        return icons[par1];
		 }else{
			 return super.getIcon(par1, par2);
		 }
	    }

	    @Override
	    public void registerBlockIcons(IIconRegister par1IconRegister) {
	    	if(multipleIcons){
	    		for(int i = 0;i<iconNames.length;i++){
	    			icons[i] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + iconNames[i]);
	    		}
	    	}else{
	    		super.registerBlockIcons(par1IconRegister);
	    	}
	    }
}
