package ip.industrialProcessing.transport.items.conveyorOutput;

import java.util.List;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.transport.items.conveyorBelt.BlockConveyorBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockConveyorOutput extends BlockConveyorBase {

    private Icon[] icons = new Icon[3];
	public BlockConveyorOutput() {
		super(ConfigMachineBlocks.getBLtransportConveyorBeltOutput(), Material.iron, 5.0f, Block.soundMetalFootstep, "Conveyor Output", IndustrialProcessing.tabPower);
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererConveyorOutputID();
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityConveyorOutput();
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
	    icons[1] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "tankSide");
	    icons[2] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "conveyorHopperFeatures");
	}
}
