package ip.industrialProcessing.subMod.logic.network.display;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.subMod.logic.IPLogic;
import ip.industrialProcessing.subMod.logic.config.ConfigLogic;
import ip.industrialProcessing.subMod.logic.network.TileEntityLogicNetworkNode;
import ip.industrialProcessing.subMod.logic.transport.ICommunicationNode;
import ip.industrialProcessing.subMod.logic.transport.blockLogic;

public class BlockLogicDisplay extends blockLogic{

    public BlockLogicDisplay() {
	super(ConfigLogic.getBlockLogicDisplay(), Material.iron, 1.0f, Block.soundMetalFootstep, "BlockLogicDisplay", IPLogic.tabLogic);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	return new TileEntityLogicDisplay();
    }

    @Override
    public int getRenderType() {
	return 0;
    }
    
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float clickX, float clickY, float clickZ) {
	    	TileEntityLogicNetworkNode com = (TileEntityLogicNetworkNode) world.getBlockTileEntity(x, y, z);
	    	if (player.isSneaking()){
			com.sendToAll();   
	    	}else{
	    	    player.openGui(IPLogic.instance, 0, world, x, y, z);
	    	    return true;
	    	}
	    	
		return super.onBlockActivated(world, x, y, z, player, metadata, clickX, clickY, clickZ);
	}

}
