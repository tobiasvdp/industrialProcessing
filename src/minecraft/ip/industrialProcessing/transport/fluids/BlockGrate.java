package ip.industrialProcessing.transport.fluids;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigTransportBlocks;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.machines.BlockMachine;

public class BlockGrate extends BlockMachine {
    public BlockGrate() {
        super(ConfigTransportBlocks.getBlockTransportFluidGrateID(), Material.iron, 1F, Block.soundMetalFootstep, "Grate", ISetupCreativeTabs.tabFluid);
        func_111022_d(INamepace.TEXTURE_NAME_PREFIX + "grate");
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityGrate();
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    } 
    private Icon[] icons = new Icon[2];

    @Override
    public Icon getIcon(int par1, int par2) {
        if (par1 == ForgeDirection.UP.ordinal())
            return icons[1];
        return icons[0];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "grate");
        icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "grateTop");
    }
}
