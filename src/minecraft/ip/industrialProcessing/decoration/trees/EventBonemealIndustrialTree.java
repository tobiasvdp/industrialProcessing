package ip.industrialProcessing.decoration.trees;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigBlocks;
import ip.industrialProcessing.config.ISetupBlocks;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class EventBonemealIndustrialTree {

    private int BlockID;

    /** Used to make the sapling grow the tree **/
    @ForgeSubscribe
    public void bonemealUsed(BonemealEvent event) {

        if (event.world.getBlockId(event.X, event.Y, event.Z) == ConfigBlocks.getSaplingID()) {
            ISetupBlocks.blockSapling.markOrGrowMarked(event.world, event.X, event.Y, event.Z, event.world.rand);
            event.setResult(Result.ALLOW);
        }

    }
}
