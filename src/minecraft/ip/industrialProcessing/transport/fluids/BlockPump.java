package ip.industrialProcessing.transport.fluids;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ConfigTransportBlocks;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.machines.BlockMachineRendered;

public class BlockPump extends BlockMachineRendered {

    public BlockPump() {
        super(ConfigTransportBlocks.getBlockTransportFluidPumpID(), Material.iron, 1F, Block.soundMetalFootstep, "Fluid Pump", ISetupCreativeTabs.tabFluid);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityPump();
    }

    @Override
    public int getRenderType() {
        return ConfigRenderers.getRendererPumpId();
    }

    private Icon[] icons = new Icon[2];

    @Override
    public Icon getIcon(int par1, int par2) {
        par1 %= icons.length;
        return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankFeatures");
        icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankSide");
    }
}
