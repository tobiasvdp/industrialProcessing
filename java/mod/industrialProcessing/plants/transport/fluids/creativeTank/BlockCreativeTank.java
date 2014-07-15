package mod.industrialProcessing.plants.transport.fluids.creativeTank;

import mod.industrialProcessing.blockContainer.BlockContainerIPRendered;
import mod.industrialProcessing.gui.generating.GuiBuilderDefault;
import mod.industrialProcessing.gui.generating.IGuiBuilder;
import mod.industrialProcessing.utils.block.IDescriptionBlock;
import mod.industrialProcessing.utils.block.IGuiBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCreativeTank extends BlockContainerIPRendered implements IGuiBlock, IDescriptionBlock {

    public static final String UNLOCALIZED_NAME = "IP.Machine.CreativeTank";
    public static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).addInputTank(0).addInputSlot(0);

    public BlockCreativeTank() {
        super(1.0f,1.0f, Material.iron, Block.soundTypeMetal, "tankSide","tankFeatures");
    }
 

    @Override
    public String getDescription() {
        return "A block that can contain infinite amounts of a fluid.";
    }

    @Override
    public IGuiBuilder getGui() {
        return guiBuilder;
    }
}
