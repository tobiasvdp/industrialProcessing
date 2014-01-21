package ip.industrialProcessing.power.motor;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.machines.BlockMachineRendered;

public class BlockElectroMotor extends BlockMachineRendered {

    public BlockElectroMotor() {
        super(ConfigMachineBlocks.getElectroMotorBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Electric Motor", ISetupCreativeTabs.tabPower);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityElectroMotor();
    }

    @Override
    public int getRenderType() {
        return ConfigRenderers.getRendererElectroMotorId();
    }

    Icon[] icons = new Icon[2];

    @Override
    public Icon getIcon(int par1, int par2) {
        par1 %= icons.length;
        return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankSide");
        icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "powerFeatures");
    }
}
