package ip.industrialProcessing.subMod.blackSmith.plant.bloomery.dummy.ironBowl;

import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.multiblock.dummy.BlockMultiblockDummy;
import ip.industrialProcessing.subMod.blackSmith.IPBlackSmith;
import ip.industrialProcessing.subMod.blackSmith.config.ConfigBlackSmith;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockIronBowl extends BlockMultiblockDummy{

    Icon[] icons = new Icon[3];
	public BlockIronBowl() {
		super(ConfigBlackSmith.getBlockIronBowlID(), "BlockIronBowl", IPBlackSmith.tabBlackSmith);
		this.setBlockBounds(0.2f, 0.0f, 0.2f, 0.8f, 0.4f, 0.8f);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityIronBowl();
	}
	
	@Override
	public int getRenderType() {
		return ConfigBlackSmith.getRendererIronBowlId();
	}

    @Override
    public Icon getIcon(int par1, int par2) {
        par1 %= icons.length;        
        return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Wood");
        icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Canvas");
        icons[2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Iron");
    }

}
