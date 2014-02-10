package ip.industrialProcessing.subMod.power.plant.solar.standingSolarPanel;

import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;
import ip.industrialProcessing.subMod.power.IPPower;
import ip.industrialProcessing.subMod.power.config.ConfigPower;
import ip.industrialProcessing.utils.IDescriptionBlock;

import javax.swing.Icon;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockStandingSolarPanel extends BlockMultiblockCore implements IDescriptionBlock{
	
	private Icon[] icons = new Icon[3];

	public BlockStandingSolarPanel() {
		super(ConfigPower.getStandingSolarPanelID(), "BlockStandingSolarPanel",IPPower.tabPower);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityStandingSolarPanel();
	}
	
	@Override
	public int getRenderType() {
		return ConfigPower.getRendererStandingSolarPanel();
	}
	@Override
    public Icon getIcon(int par1, int par2) {
        par1 %= icons.length;        
        return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        icons [0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "iron_block");
        icons [1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Iron");
        icons [2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "blockSolarPanel");
    }
    
	@Override
	public String getDescription() {
		return "next gen solar panels.";
	}
}
