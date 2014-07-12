package mod.industrialProcessing.plants.blackSmith.anvil;

import javax.swing.Icon;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.block.BlockIPRendered;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockAnvil extends BlockIPRendered {

	private Icon[] icons = new Icon[1];

	public BlockAnvil() {
		super(1.0f,1.0f, Material.iron,Block.soundTypeMetal,"Anvil");
		this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.8f, 1.0f);

	}
	
	@Override
	public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
		return false;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float clickX, float clickY, float clickZ) {
		if (player.isSneaking()) {
			return false;
		} else {
			player.openGui(IndustrialProcessing.instance,2, world, x, y, z);
			return true;
		}
	}

}
