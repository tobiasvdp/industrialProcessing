package ip.industrialProcessing.logic.network.interfaces.machine;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.logic.IPLogic;
import ip.industrialProcessing.logic.config.ConfigLogic;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.transport.blockLogic;

public class BlockMachineInterface extends blockLogic{

    public BlockMachineInterface() {
	super(ConfigLogic.getBlockMachineInterface(), Material.iron, 1.0f, Block.soundMetalFootstep, "BlockMachineInterface", IPLogic.tabLogic);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	return new TileEntityMachineInterface();
    }

    @Override
    public int getRenderType() {
	return 0;
    }
   

}
