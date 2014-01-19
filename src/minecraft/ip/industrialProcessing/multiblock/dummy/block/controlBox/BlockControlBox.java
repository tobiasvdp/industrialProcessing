package ip.industrialProcessing.multiblock.dummy.block.controlBox;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.machines.IRotateableEntity;
import ip.industrialProcessing.multiblock.dummy.BlockMultiblockDummy;
import ip.industrialProcessing.multiblock.dummy.block.bellows.TileEntityBellows;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockControlBox extends BlockMultiblockDummy{

    Icon[] icons = new Icon[5];
	public BlockControlBox() {
		super(ConfigMachineBlocks.getBlockControlBoxID(), "BlockControlBox", ISetupCreativeTabs.tabMultiblocks);
		this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityControlBox();
	}
	
	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererControlBox();
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
        icons[2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Canvas");
        icons[3] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Canvas");
        icons[4] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Canvas");
    }

}
