package mod.industrialProcessing.plants.transport.conveyorPacker;

import javax.swing.Icon;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.gui.framework.Size;
import mod.industrialProcessing.gui.framework.panels.Orientation;
import mod.industrialProcessing.gui.framework.rendering.TextureReference;
import mod.industrialProcessing.gui.generating.GuiBuilderDefault;
import mod.industrialProcessing.gui.generating.IGuiBuilder;
import mod.industrialProcessing.transport.items.conveyorBelt.block.BlockConveyorMachineBase;
import mod.industrialProcessing.utils.INamepace;
import mod.industrialProcessing.utils.block.IDescriptionBlock;
import mod.industrialProcessing.utils.block.IGuiBlock;
import mod.industrialProcessing.utils.creativeTab.ISetupCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockConveyorPacker extends BlockConveyorMachineBase implements IDescriptionBlock, IGuiBlock {
    private static final TextureReference STATE_TEXTURE = new TextureReference(new Size(72, 16), IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/Conveyor packing machine.png");
    private static final TextureReference BOOL_TEXTURE = new TextureReference(new Size(32, 16), IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/ConveyorBoxesOnBelt.png");

    public static IGuiBuilder guiBuilder = new GuiBuilderDefault("Packaging Machine").addInputSlot(0).addInputSlotCluster(1, 9, 3, Orientation.HORIZONTAL).addStateButton(0, STATE_TEXTURE, 1, 4, "Pack Full", "Pack any", "Passthrough", "Unpack").addStateButton(1, BOOL_TEXTURE, 1, 2, "Deny boxes on conveyor", "Allow boxes on conveyor");

    public BlockConveyorPacker() {
	super(5.0f,5.0f, Material.iron, Block.soundTypeMetal,"tankSide","conveyorHopperFeatures","packer");
	setBlockBounds(0, 0, 0, 1, 1, 1);
    }

    @Override
    public IGuiBuilder getGui() {
	return guiBuilder;
    }

    @Override
    public String getDescription() {
	return "Packs or Unpacks items to/from supplied Storage Boxes";
    }
}
