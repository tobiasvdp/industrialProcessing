package ip.industrialProcessing.transport.items.conveyorChute;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.transport.items.conveyorBelt.BlockConveyorBase;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockConveyorChute extends BlockConveyorBase {


    private Icon[] icons = new Icon[3];
    public BlockConveyorChute() {
        super(ConfigMachineBlocks.getBLtransportConveyorShute(), Material.iron, 5.0f, Block.soundMetalFootstep, "Conveyor Shute", IndustrialProcessing.tabPower);
    }

    @Override
    public int getRenderType() {
        return ConfigRenderers.getRendererConveyorChuteID();
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityConveyorChute();
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess par1iBlockAccess, int par2, int par3, int par4) {
        setBlockBounds(0, 0, 0, 1, 1, 1);       
    }
    
    @Override
    public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {
         
        super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
    }
    
    @Override
    public Icon getIcon(int par1, int par2) {
        par1 %= icons.length;
        return icons[par1];
    }
    
    @Override
    public void registerIcons(IconRegister par1IconRegister) { 
        
        icons[0] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "conveyor");
        icons[1] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "conveyorHopperFeatures");
        icons[2] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "chute");
    }

}
