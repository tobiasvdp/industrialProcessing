package ip.industrialProcessing.subMod.blackSmith.config;

import ip.industrialProcessing.items.ItemIP;
import ip.industrialProcessing.subMod.blackSmith.IPBlackSmith;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.BlockBloomery;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.dummy.bellows.BlockBellows;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.dummy.ironBowl.BlockIronBowl;
import ip.industrialProcessing.subMod.blackSmith.plant.tripHammer.BlockTripHammer;
import ip.industrialProcessing.subMod.blackSmith.plant.tripHammer.dummy.woodenBar.BlockWoodenBar;
import ip.industrialProcessing.subMod.blackSmith.plant.tripHammer.dummy.woodenHammer.BlockWoodenHammer;
import ip.industrialProcessing.subMod.blackSmith.plant.tripHammer.dummy.woodenWheel.BlockWoodenWheel;
import ip.industrialProcessing.subMod.blackSmith.plant.waterBasin.BlockWaterBasin;

public interface ISetupBlackSmith {
	//items
	public final static ItemIP itemWroughtIron = new ItemIP(ConfigBlackSmith.getItemWroughtIronID(), "ItemWroughtIron",IPBlackSmith.tabBlackSmith);
	
	//blocks
    public final static BlockBloomery blockBloomery = new BlockBloomery();
    public final static BlockBellows blockBellows = new BlockBellows();
    public final static BlockIronBowl blockIronBowl = new BlockIronBowl();
    public final static BlockWaterBasin blockWaterBasin = new BlockWaterBasin();
    public final static BlockTripHammer blockTripHammer = new BlockTripHammer();
    public final static BlockWoodenBar blockWoodenBar = new BlockWoodenBar();
    public final static BlockWoodenHammer blockWoodenHammer = new BlockWoodenHammer();
    public final static BlockWoodenWheel blockWoodenWheel = new BlockWoodenWheel();
}
