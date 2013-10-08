package ip.industrialProcessing.machines.treetap;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.IRotateableEntity;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockAutomaticTreeTap extends BlockMachineRendered {

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

}
