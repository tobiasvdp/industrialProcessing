package ip.industrialProcessing.decoration.light.hangingLamp;

import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.decoration.light.BlockLamp;

import javax.swing.Icon;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPetrolLamp extends BlockLamp {

	private Icon[] icons = new Icon[2];

	public BlockPetrolLamp() {
		super(ConfigMachineBlocks.getBlockPetrolLamp(), Material.glass, 1f, soundMetalFootstep, "Petrol Lamp", ISetupCreativeTabs.tabFluid);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityPetrolLamp();
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		par1 %= icons.length;
		return icons[par1];
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Stone");
		icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Iron");
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererPetrolLampId();
	}
}
