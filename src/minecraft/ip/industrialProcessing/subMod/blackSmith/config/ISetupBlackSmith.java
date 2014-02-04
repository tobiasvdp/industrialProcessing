package ip.industrialProcessing.subMod.blackSmith.config;

import ip.industrialProcessing.items.ItemIP;
import ip.industrialProcessing.subMod.blackSmith.IPBlackSmith;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.BlockBloomery;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.dummy.bellows.BlockBellows;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.dummy.ironBowl.BlockIronBowl;

public interface ISetupBlackSmith {
	//items
	public final static ItemIP itemWroughtIron = new ItemIP(ConfigBlackSmith.getItemWroughtIronID(), "ItemWroughtIron",IPBlackSmith.tabBlackSmith);
	
	//blocks
    public final static BlockBloomery blockBloomery = new BlockBloomery();
    public final static BlockBellows blockBellows = new BlockBellows();
    public final static BlockIronBowl blockIronBowl = new BlockIronBowl();
}
