package ip.industrialProcessing.gui3.generating;

import ip.industrialProcessing.multiblock.tier.Tiers;

public interface IGuiMultiblock {
    IGuiBuilder getGui(Tiers tier);
}
