package ip.industrialProcessing.multiblock.core.block.decoration.garageDoor;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;
import ip.industrialProcessing.utils.IDescriptionBlock;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockGarageDoor extends BlockMultiblockCore implements IDescriptionBlock{
	private Icon[] icons = new Icon[4];

	public BlockGarageDoor() {
		super(ConfigMachineBlocks.getBlockGarageDoorID(), "BlockGarageDoor", ISetupCreativeTabs.tabMultiblocks);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityGarageDoor();
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererGarageDoorFrame();
	}
	
    @Override
    public Icon getIcon(int par1, int par2) {
        par1 %= icons.length;        
        return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        icons [0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "blockGarageFrame");
    }

	@Override
	public String getDescription() {
		return "Gearbox for the garage door.";
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
    	if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().itemID == IndustrialProcessing.itemRemote.itemID)
    		return false;
		return super.onBlockActivated(world, x, y, z, player, metadata, what, these, are);
	}
}
