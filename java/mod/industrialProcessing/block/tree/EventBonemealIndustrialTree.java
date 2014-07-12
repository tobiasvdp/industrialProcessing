package mod.industrialProcessing.block.tree;
 
import mod.industrialProcessing.block.ConfigBlocks;
import mod.industrialProcessing.block.ISetupBlocks;
import net.minecraftforge.event.entity.player.BonemealEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventBonemealIndustrialTree {

	/*
    private int BlockID;

    // Used to make the sapling grow the tree 
    @SubscribeEvent
    public void bonemealUsed(BonemealEvent event) {

        if (event.world.getBlockId(event.X, event.Y, event.Z) == ConfigBlocks.getSaplingID()) {
            ISetupBlocks.blockSapling.markOrGrowMarked(event.world, event.x, event.y, event.z, event.world.rand);
            event.setResult(Result.ALLOW);
        }

    }
    */
}
