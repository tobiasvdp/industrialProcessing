package mod.industrialProcessing.plants.construction.craftomatic;

import mod.industrialProcessing.blockContainer.BlockContainerIPRendered;
import mod.industrialProcessing.gui.framework.panels.Orientation;
import mod.industrialProcessing.gui.framework.rendering.TextureReference;
import mod.industrialProcessing.gui.generating.GuiBuilderDefault;
import mod.industrialProcessing.gui.generating.IGuiBuilder;
import mod.industrialProcessing.utils.block.IDescriptionBlock;
import mod.industrialProcessing.utils.block.IGuiBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCraftomatic extends BlockContainerIPRendered implements IDescriptionBlock, IGuiBlock {

	private static final TextureReference WORKER_TEXTURE = TextureReference.createDefault("Craftomatic", 24, 32);
	public static IGuiBuilder guiBuilder;
	static {
		GuiBuilderDefault builder = new GuiBuilderDefault("Craftomatic").addInputSlotCluster(0, 9, 3, Orientation.HORIZONTAL).addOutputSlot(4 * 9).enableWorker().enablePower(4 * 9 + 1);

		for (int i = 0; i < 9; i++) {
			builder.addBufferSlotCluster(9 + i * 3, 3, 3, Orientation.HORIZONTAL);
		}
		
		guiBuilder = builder;
	}

	public BlockCraftomatic() {
		super(1F, 1F, Material.iron, Block.soundTypeMetal);
	}

	@Override
	public IGuiBuilder getGui() {
		return guiBuilder;
	}

	@Override
	public String getDescription() {
		return "This machine can craft recipes when provided with power and a recipe";
	}

}
