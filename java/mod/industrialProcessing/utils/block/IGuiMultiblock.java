package mod.industrialProcessing.utils.block;

import mod.industrialProcessing.gui.generating.IGuiBuilder;


public interface IGuiMultiblock {
    IGuiBuilder getGui(Tiers tier);
}
