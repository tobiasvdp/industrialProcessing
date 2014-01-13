package ip.industrialProcessing.gui;

import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.tier.Tiers;

public interface IGuiLayoutMultiblock {
	public GuiLayout getGuiLayout(Tiers tier);
	public GuiLayout[] getGuiLayouts();
	public StructureMultiblock getMultiblockLayouts();
}
