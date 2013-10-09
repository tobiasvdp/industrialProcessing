package ip.industrialProcessing.config;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.fluids.BlockFluid;
import ip.industrialProcessing.fluids.ContainerFluid;
import ip.industrialProcessing.fluids.ItemFluid;
import net.minecraft.block.material.Material;

public interface ISetupFluids {

    public final static ItemFluid itemFluidMicrobialWater = new ItemFluid("MicrobialWater", 1000, 1000);
    public final static BlockFluid blockFluidMicrobialWater = new BlockFluid(ConfigFluids.blockFluidBaseMicrobialWaterID(), itemFluidMicrobialWater, Material.water, true);
    public final static ContainerFluid bucketMicrobialWater = new ContainerFluid(ConfigFluids.BucketMicrobialWaterID(), itemFluidMicrobialWater, blockFluidMicrobialWater, "ContainerMicrobialWater");

    public final static ItemFluid itemFluidLatex = new ItemFluid("Latex", 1200, 100);
    public final static BlockFluid blockFluidLatex = new BlockFluid(ConfigFluids.getLatexFluidBlockID(), itemFluidLatex, Material.water, true);
    public final static ContainerFluid bucketFluidLatex = new ContainerFluid(ConfigFluids.getLatexFluidBucketID(), itemFluidLatex, blockFluidLatex, "ContainerLatex");

    public final static ItemFluid itemFluidDirtyWater = new ItemFluid("DirtyWater", 1000, 1000);
    public final static BlockFluid blockFluidDirtyWater = new BlockFluid(ConfigFluids.blockFluidBaseDirtyWaterID(), itemFluidDirtyWater, Material.water, true);
    public final static ContainerFluid bucketDirtyWater = new ContainerFluid(ConfigFluids.BucketDirtyWaterID(), itemFluidDirtyWater, blockFluidDirtyWater, "ContainerDirtyWater");

    public final static ItemFluid itemFluidOreSludgeIron = new ItemFluid("OreSludgeIron", 1000, 1000);
    public final static BlockFluid blockFluidOreSludgeIron = new BlockFluid(ConfigFluids.blockFluidBaseOreSludgeIronID(), itemFluidOreSludgeIron, Material.water, false);
    public final static ContainerFluid bucketOreSludgeIron = new ContainerFluid(ConfigFluids.BucketOreSludgeIronID(), itemFluidOreSludgeIron, blockFluidOreSludgeIron, "ContainerOreSludgeIron");

    public final static ItemFluid itemFluidOreSludgeChromite = new ItemFluid("OreSludgeChromite", 1000, 1000);
    public final static BlockFluid blockFluidOreSludgeChromite = new BlockFluid(ConfigFluids.blockFluidBaseOreSludgeChromiteID(), itemFluidOreSludgeChromite, Material.water, false);
    public final static ContainerFluid bucketOreSludgeChromite = new ContainerFluid(ConfigFluids.bucketOreSludgeChromiteID(), itemFluidOreSludgeChromite, blockFluidOreSludgeChromite, "ContainerOreSludgeChromite");

    public final static ItemFluid itemFluidOreSludgeGalena = new ItemFluid("OreSludgeGalena", 1000, 1000);
    public final static BlockFluid blockFluidOreSludgeGalena = new BlockFluid(ConfigFluids.blockFluidBaseOreSludgeGalenaID(), itemFluidOreSludgeGalena, Material.water, false);
    public final static ContainerFluid bucketOreSludgeGalena = new ContainerFluid(ConfigFluids.bucketOreSludgeGalenaID(), itemFluidOreSludgeGalena, blockFluidOreSludgeGalena, "ContainerOreSludgeGalena");

    public final static ItemFluid itemFluidOreSludgeGold = new ItemFluid("OreSludgeGold", 1000, 1000);
    public final static BlockFluid blockFluidOreSludgeGold = new BlockFluid(ConfigFluids.blockFluidBaseOreSludgeGoldID(), itemFluidOreSludgeGold, Material.water, false);
    public final static ContainerFluid bucketOreSludgeGold = new ContainerFluid(ConfigFluids.bucketOreSludgeGoldID(), itemFluidOreSludgeGold, blockFluidOreSludgeGold, "ContainerOreSludgeGold");

    public final static ItemFluid itemFluidOreSludgeTalia = new ItemFluid("OreSludgeTalia", 1000, 1000);
    public final static BlockFluid blockFluidOreSludgeTalia = new BlockFluid(ConfigFluids.blockFluidBaseOreSludgeTaliaID(), itemFluidOreSludgeTalia, Material.water, false);
    public final static ContainerFluid bucketOreSludgeTalia = new ContainerFluid(ConfigFluids.bucketOreSludgeTaliaID(), itemFluidOreSludgeTalia, blockFluidOreSludgeTalia, "ContainerOreSludgeTalia");

    public final static ItemFluid itemFluidOreSludgeCopper = new ItemFluid("OreSludgeCopper", 1000, 1000);
    public final static BlockFluid blockFluidOreSludgeCopper = new BlockFluid(ConfigFluids.blockFluidBaseOreSludgeCopperID(), itemFluidOreSludgeCopper, Material.water, false);
    public final static ContainerFluid bucketOreSludgeCopper = new ContainerFluid(ConfigFluids.BucketOreSludgeCopperID(), itemFluidOreSludgeCopper, blockFluidOreSludgeCopper, "ContainerOreSludgeCopper");

    public final static ItemFluid itemFluidOreSludgeTin = new ItemFluid("OreSludgeTin", 1000, 1000);
    public final static BlockFluid blockFluidOreSludgeTin = new BlockFluid(ConfigFluids.blockFluidBaseOreSludgeTinID(), itemFluidOreSludgeTin, Material.water, false);
    public final static ContainerFluid bucketOreSludgeTin = new ContainerFluid(ConfigFluids.BucketOreSludgeTinID(), itemFluidOreSludgeTin, blockFluidOreSludgeTin, "ContainerOreSludgeTin");

    public final static ItemFluid itemFluidHotSlag = new ItemFluid("IP.fluid.hotSlag", 3000, 3000);
    public final static BlockFluid blockFluidHotSlag = new BlockFluid(ConfigFluids.blockFluidBaseHotSlagID(), itemFluidHotSlag, Material.fire, false);
    public final static ContainerFluid bucketHotSlag = new ContainerFluid(ConfigFluids.BucketHotSlagID(), itemFluidHotSlag, blockFluidHotSlag, "ContainerHotSlag");

    public final static ItemFluid itemFluidPigIron = new ItemFluid("IP.fluid.pigIron", 2000, 2000);
    public final static BlockFluid blockFluidPigIron = new BlockFluid(ConfigFluids.blockFluidBasePigIronID(), itemFluidPigIron, Material.fire, false);
    public final static ContainerFluid bucketPigIron = new ContainerFluid(ConfigFluids.BucketPigIronID(), itemFluidPigIron, blockFluidPigIron, "ContainerPigIron");

    public final static ItemFluid itemFluidHotSteel = new ItemFluid("IP.fluid.hotSteel", 2000, 2000);
    public final static BlockFluid blockFluidHotSteel = new BlockFluid(ConfigFluids.blockFluidBaseHotSteelID(), itemFluidHotSteel, Material.fire, false);
    public final static ContainerFluid bucketHotSteel = new ContainerFluid(ConfigFluids.BucketHotSteelID(), itemFluidHotSteel, blockFluidHotSteel, "ContainerHotSteel");

    public final static ItemFluid itemFluidExhaustGas = new ItemFluid("IP.fluid.exhaustGas", 1000, 1000);
    public final static BlockFluid blockFluidExhaustGas = new BlockFluid(ConfigFluids.blockFluidBaseExhaustGasID(), itemFluidExhaustGas, Material.water, false);

    public final static ItemFluid itemFluidSteam = new ItemFluid("Steam", 1000, 1000);
    public final static BlockFluid blockFluidSteam = new BlockFluid(ConfigFluids.blockFluidBaseSteamID(), itemFluidSteam, Material.water, false);

    public final static ItemFluid itemFluidfiltyWater = new ItemFluid("filtyWater", 2000, 2000);
    public final static BlockFluid blockFluidfiltyWater = new BlockFluid(ConfigFluids.blockFluidBasefiltyWaterID(), itemFluidfiltyWater, Material.water, false);
    public final static ContainerFluid bucketfiltyWater = new ContainerFluid(ConfigFluids.BucketfiltyWaterID(), itemFluidfiltyWater, blockFluidfiltyWater, "ContainerfiltyWater");

    public final static ItemFluid itemFluidGritSludge = new ItemFluid("gritSludge", 2000, 2000);
    public final static BlockFluid blockFluidGritSludge = new BlockFluid(ConfigFluids.blockFluidBaseGritSludgeID(), itemFluidGritSludge, Material.water, false);
    public final static ContainerFluid bucketGritSludge = new ContainerFluid(ConfigFluids.BucketGritSludgeID(), itemFluidGritSludge, blockFluidGritSludge, "ContainerGritSludge");

    public final static ItemFluid itemFluidUncleanWater = new ItemFluid("uncleanWater", 2000, 2000);
    public final static BlockFluid blockFluidUncleanWater = new BlockFluid(ConfigFluids.blockFluidBaseUncleanWaterID(), itemFluidUncleanWater, Material.water, false);
    public final static ContainerFluid bucketUncleanWater = new ContainerFluid(ConfigFluids.BucketUncleanWaterID(), itemFluidUncleanWater, blockFluidUncleanWater, "ContainerUncleanWater");

    public final static ItemFluid itemFluidResidu = new ItemFluid("residu", 2000, 2000);
    public final static BlockFluid blockFluidResidu = new BlockFluid(ConfigFluids.blockFluidBaseResiduID(), itemFluidResidu, Material.water, false);
    public final static ContainerFluid bucketResidu = new ContainerFluid(ConfigFluids.BucketResiduID(), itemFluidResidu, blockFluidResidu, "ContainerResidu");

}
