package mod.industrialProcessing.utils.block;

import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.gui.generating.IGuiBuilder;


public interface IGuiMultiblock {
    IGuiBuilder getGui(Tiers tier);
}
