package ip.industrialProcessing.decoration.doors.emergency;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.config.ConfigBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.decoration.doors.BlockDoor;
import ip.industrialProcessing.utils.IDescriptionBlock;

public class BlockDoorEmergency extends BlockDoor implements IDescriptionBlock{

	 Icon[] icons = new Icon[4];
	
	public BlockDoorEmergency() {
		super(ConfigBlocks.getBlockDoorEmergencyID(), Material.iron, 1.0f, Block.soundMetalFootstep, "BlockDoorEmergency", IndustrialProcessing.tabPower);
	}
	
	@Override
    public int getRenderType() {
	return ConfigRenderers.getRendererDoorEmergency();
    }

	@Override
	public String getDescription() {
		return "A door for a quick getaway";
	}
	
	 @Override
	    public Icon getIcon(int par1, int par2) {
	        par1 %= icons.length;        
	        return icons[par1];
	    }

	    @Override
	    public void registerIcons(IconRegister par1IconRegister) {
	        icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Orange");
	        icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Iron");
	        icons[2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "iron_block");
	        icons[3] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "glass");
	    }

}
