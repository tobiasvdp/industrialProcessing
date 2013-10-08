package ip.industrialProcessing.machines.treetap;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.IRotateableEntity;
import ip.industrialProcessing.transport.fluids.BlockTank;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockAutomaticTreeTap extends BlockManualTreeTap {

    private Icon tapIcon;
    private Icon tankIcon;

    public BlockAutomaticTreeTap() {
        super(ConfigMachineBlocks.getAutomaticTreeTapBlockID(), Material.iron, 1.0f, soundMetalFootstep, "Automatic Tree Tap", IndustrialProcessing.tabOreProcessing);
        func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "automaticTreeTap");
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityAutomaticTreeTap();
    }

    @Override
    public int getRenderType() {
        return ConfigRenderers.getRendererAutomaticTreeTapID();
    }

    @Override
    public Icon getIcon(int par1, int par2) {
        if (par1 == 1)
            return tankIcon;
        return tapIcon;
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.tankIcon = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "tankSide");
        this.tapIcon = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "automaticTreeTap");
    }

}
