package mod.industrialProcessing.plants.todo.core.plants.oilRefinary.atmosphericDestilationTower;

import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;

import javax.swing.Icon;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockAtmosphericDestilationTower extends BlockMultiblockCore{
    Icon[] icons = new Icon[3];
	public BlockAtmosphericDestilationTower() {
		super(ConfigMachineBlocks.getBlockAtmosphericDestilationTowerID(), "BlockAtmosphericDestilationTower", ISetupCreativeTabs.tabMultiblocks);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityAtmosphericDestilationTower();
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererAtmosphericDestilationTower();
	}

    @Override
    public Icon getIcon(int par1, int par2) {
        par1 %= icons.length;        
        return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankSide");
        icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankFeatures");
        icons[2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "burnerGrill");
    }
}
