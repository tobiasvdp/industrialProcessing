package mod.industrialProcessing.plants.power.meter;

import mod.industrialProcessing.blockContainer.BlockContainerIPRendered;
import mod.industrialProcessing.blockContainer.machine.power.generator.TileEntityPowerGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockVoltMeter extends BlockContainerIPRendered {

	public BlockVoltMeter() {
		super(1f, 1f, Material.iron, Block.soundTypeMetal);
	}
	
}
