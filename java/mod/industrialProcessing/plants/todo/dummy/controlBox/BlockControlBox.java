package mod.industrialProcessing.plants.todo.dummy.controlBox;

import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.machines.IRotateableEntity;
import ip.industrialProcessing.multiblock.dummy.BlockMultiblockDummy;

import javax.swing.Icon;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

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
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Iron");
        icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Orange");
        icons[2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "up");
        icons[3] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "stop");
        icons[4] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "down");
    }
    
    @Override
	public MovingObjectPosition collisionRayTrace(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3)
    {
        int l = ((IRotateableEntity)par1World.getBlockTileEntity(par2, par3, par4)).getForwardDirection().ordinal();
        if (l == 2){
            this.setBlockBounds(0.4F, 0.25F, 0.0F, 0.6F, 0.75F, 0.1F );
        }else  if (l == 3){
            this.setBlockBounds(0.4F, 0.25F, 0.9F, 0.6F, 0.75F, 1.0F );
        }else if (l == 4){
            this.setBlockBounds(0.9F, 0.25F, 0.4F, 1.0F, 0.75F, 0.60F );
        }else  if (l == 5){
            this.setBlockBounds(0.0F, 0.25F, 0.4F, 0.10F, 0.75F, 0.6F );
        }

        return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3, par6Vec3);
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
    	TileEntityControlBox te = (TileEntityControlBox) world.getBlockTileEntity(x, y, z);
    	if(these < 0.7f && these > 0.6f){
    		te.triggerButton(0);
    	}else if(these < 0.53f && these > 0.43f){
    		te.triggerButton(1);
    	}else if(these < 0.37f && these > 0.26f){
    		te.triggerButton(2);
    	}
    	super.onBlockActivated(world, x, y, z, player, metadata, what, these, are);
    	if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().itemID == ISetupItems.itemRemote.itemID)
    		return false;
    	return true;
    }

}
