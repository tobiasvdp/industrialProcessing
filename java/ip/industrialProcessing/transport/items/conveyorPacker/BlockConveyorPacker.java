package ip.industrialProcessing.transport.items.conveyorPacker;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui3.framework.Size;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;
import ip.industrialProcessing.gui3.generating.GuiBuilderDefault;
import ip.industrialProcessing.gui3.generating.IGuiBlock;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;
import ip.industrialProcessing.transport.items.conveyorBelt.BlockConveyorMachineBase;
import ip.industrialProcessing.utils.IDescriptionBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockConveyorPacker extends BlockConveyorMachineBase implements IDescriptionBlock, IGuiBlock {
    private static final TextureReference STATE_TEXTURE = new TextureReference(new Size(72, 16), IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/Conveyor packing machine.png");
    private static final TextureReference BOOL_TEXTURE = new TextureReference(new Size(32, 16), IndustrialProcessing.TEXTURE_DOMAIN, "textures/gui/ConveyorBoxesOnBelt.png");

    Icon[] icons = new Icon[3];

    public static IGuiBuilder guiBuilder = new GuiBuilderDefault("Packaging Machine").addInputSlot(0).addInputSlotCluster(1, 9, 3, Orientation.HORIZONTAL).addStateButton(0, STATE_TEXTURE, 1, 4, "Pack Full", "Pack any", "Passthrough", "Unpack").addStateButton(1, BOOL_TEXTURE, 1, 2, "Deny boxes on conveyor", "Allow boxes on conveyor");

    public BlockConveyorPacker() {
	super(ConfigMachineBlocks.getBLtransportConveyorBeltPacker(), Material.iron, 5.0f, Block.soundMetalFootstep, "Packer", ISetupCreativeTabs.tabPower);
	setTextureName(null);
	setBlockBounds(0, 0, 0, 1, 1, 1);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	return new TileEntityConveyorPacker();
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererConveyorPackerID();
    }

    @Override
    public Icon getIcon(int par1, int par2) {
	par1 %= icons.length;
	return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
	this.icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankSide");
	this.icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "conveyorHopperFeatures");
	this.icons[2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "packer");
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
