package ip.industrialProcessing.multiblock.dummy.block.blastFurnaceTower;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.multiblock.dummy.BLmultiblockDummy;

public class BLmultiblockBlastFurnaceTower extends BLmultiblockDummy {
    Icon[] icons = new Icon[5];
    
    public BLmultiblockBlastFurnaceTower() {
	super(ConfigMachineBlocks.getBLmultiblockBlastFurnaceTower(), "BLmultiblockBlastFurnaceTower", IndustrialProcessing.tabMultiblocks);
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getrendererMultiblockBlastFurnaceTowerID();
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	return new TEmultiblockBlastFurnaceTower();
    }

    @Override
    public Icon getIcon(int par1, int par2) {
	return icons[par1 % icons.length];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
	icons[0] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "MachineConnectorFiller");
	icons[1] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "tankSide");
	icons[2] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "conveyorHopperFeatures");
	icons[3] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "tankFeatures");
	icons[4] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "grill");
    }
}
