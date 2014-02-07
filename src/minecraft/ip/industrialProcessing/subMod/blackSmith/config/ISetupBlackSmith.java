package ip.industrialProcessing.subMod.blackSmith.config;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBucket;
import net.minecraftforge.fluids.FluidRegistry;
import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.items.ItemIP;
import ip.industrialProcessing.subMod.blackSmith.IPBlackSmith;
import ip.industrialProcessing.subMod.blackSmith.item.ItemWoodenBucket;
import ip.industrialProcessing.subMod.blackSmith.item.ItemWoodenBucketFilled;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.BlockBloomery;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.dummy.bellows.BlockBellows;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.dummy.ironBowl.BlockIronBowl;
import ip.industrialProcessing.subMod.blackSmith.plant.forge.BlockForge;
import ip.industrialProcessing.subMod.blackSmith.plant.tripHammer.BlockTripHammer;
import ip.industrialProcessing.subMod.blackSmith.plant.tripHammer.dummy.woodenBar.BlockWoodenBar;
import ip.industrialProcessing.subMod.blackSmith.plant.tripHammer.dummy.woodenHammer.BlockWoodenHammer;
import ip.industrialProcessing.subMod.blackSmith.plant.tripHammer.dummy.woodenWheel.BlockWoodenWheel;
import ip.industrialProcessing.subMod.blackSmith.plant.waterBasin.BlockWaterBasin;

public interface ISetupBlackSmith {
	//items
	public final static ItemIP itemWroughtIron = new ItemIP(ConfigBlackSmith.getItemWroughtIronID(), "ItemWroughtIron",IPBlackSmith.tabBlackSmith);
	public final static ItemWoodenBucket itemWoodenBucket = (ItemWoodenBucket) new ItemWoodenBucket(ConfigBlackSmith.getItemWoodenBucketID(),0).setTextureName(INamepace.TEXTURE_NAME_PREFIX +"ItemWoodenBucket").setCreativeTab(IPBlackSmith.tabBlackSmith);
	public final static ItemWoodenBucketFilled itemWoodenBucketWater = new ItemWoodenBucketFilled(ConfigBlackSmith.getItemWoodenBucketWaterID(), FluidRegistry.WATER, Block.waterStill, "ItemWoodenBucketWater");
	
	
	//blocks
    public final static BlockBloomery blockBloomery = new BlockBloomery();
    public final static BlockBellows blockBellows = new BlockBellows();
    public final static BlockIronBowl blockIronBowl = new BlockIronBowl();
    public final static BlockWaterBasin blockWaterBasin = new BlockWaterBasin();
    public final static BlockTripHammer blockTripHammer = new BlockTripHammer();
    public final static BlockWoodenBar blockWoodenBar = new BlockWoodenBar();
    public final static BlockWoodenHammer blockWoodenHammer = new BlockWoodenHammer();
    public final static BlockWoodenWheel blockWoodenWheel = new BlockWoodenWheel();
    public final static BlockForge blockForge = new BlockForge();
}
