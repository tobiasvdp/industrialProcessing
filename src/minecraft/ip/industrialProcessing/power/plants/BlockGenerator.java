package ip.industrialProcessing.power.plants;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.power.BlockPowerGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockGenerator extends BlockPowerGenerator {

    public BlockGenerator() {
        super(ConfigMachineBlocks.getGeneratorBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Generator", ISetupCreativeTabs.tabPower);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityGenerator();
    }

    @Override
    public int getRenderType() {
        return ConfigRenderers.getRendererGeneratorId();
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
        icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "generatorFeatures");
    }
}
