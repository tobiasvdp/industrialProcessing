package mod.industrialProcessing.plants.power.wire;

import mod.industrialProcessing.blockContainer.transport.BlockTransport;
import mod.industrialProcessing.utils.INamepace;
import mod.industrialProcessing.utils.creativeTab.ISetupCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockWire extends BlockTransport {

    public BlockWire() {
        super(1.0f,1.0f, Material.cloth, Block.soundTypeCloth);
    }

    @Override
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5) {
        super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
        TileEntityWire wire = (TileEntityWire) par1World.getTileEntity(par2, par3, par4);
        wire.searchForConnections();
    }
}
