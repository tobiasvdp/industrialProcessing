package mod.industrialProcessing.plants.transport.fluids.grate;

import javax.swing.Icon;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.blockContainer.BlockContainerIPRendered;
import mod.industrialProcessing.utils.INamepace;
import mod.industrialProcessing.utils.creativeTab.ISetupCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockGrate extends BlockContainerIPRendered {
    public BlockGrate() {
        super(1.0f,1.0f, Material.iron, Block.soundTypeMetal, "grate","grateTop");
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    } 
}
