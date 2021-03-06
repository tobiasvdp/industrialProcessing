package ip.industrialProcessing.transport.fluids;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ConfigTransportBlocks;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.machines.BlockMachineRendered;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockRainTank extends BlockMachineRendered {

    public BlockRainTank() {
        super(ConfigTransportBlocks.getBlockRainTankID(), Material.iron, 1F, Block.soundMetalFootstep, "Rain Collector", ISetupCreativeTabs.tabFluid);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityRainTank();
    }

    @Override
    public int getRenderType() {
        return ConfigRenderers.getRendererRainTankId();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
        // no gui
        return false;
    }

    @Override
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
        super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
        TileEntityRainTank rainTank = (TileEntityRainTank) par1World.getBlockTileEntity(par2, par3, par4);
        rainTank.searchForConnections();
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        super.onBlockPlacedBy(world, x, y, z, entityLivingBase, itemStack);
        TileEntityRainTank rainTank = (TileEntityRainTank) world.getBlockTileEntity(x, y, z);
        rainTank.searchForConnections();
    }

    Icon[] icons = new Icon[3];

    @Override
    public Icon getIcon(int par1, int par2) {
        par1 %= icons.length;
        return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankFeatures");
        icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankSide");
        icons[2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "fullPipe");
    }
}
