package ip.industrialProcessing.worldGen;

import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable;

public class OreGenHandler {

    @ForgeSubscribe
    public void generateMineable(GenerateMinable event) {
            switch(event.type) {
                    case DIAMOND:
                    case LAPIS:
                    case IRON:
                    case GOLD:
                    case REDSTONE:
                    case COAL:
                    case DIRT:
                    case GRAVEL:
                            event.setResult(Result.DENY);
                            break;
                    default: 
                        break;
            }
    }
}
