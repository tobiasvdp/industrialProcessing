package mod.industrialProcessing.plants.power.generator.solar.standingSolarPanel;

import javax.swing.Icon;

import mod.industrialProcessing.blockContainer.multiblock.core.BlockMultiblockCore;
import mod.industrialProcessing.utils.block.IDescriptionBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockStandingSolarPanel extends BlockMultiblockCore implements IDescriptionBlock{
	
	private Icon[] icons = new Icon[3];

	public BlockStandingSolarPanel() {
		super(1.0f,1.0f,Material.iron,Block.soundTypeMetal, "iron_block","Iron","blockSolarPanel");
	}
    
	@Override
	public String getDescription() {
		return "next gen solar panels.";
	}
}
