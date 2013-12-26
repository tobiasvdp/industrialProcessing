package ip.industrialProcessing.machines.plants.blacksmith.grindingStone;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.crusher.TileEntityCrusher;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockGrindingStone extends BlockMachineRendered {

	private Icon[] icons = new Icon[1];
	
    public BlockGrindingStone() {
        super(ConfigMachineBlocks.getBlockGrindingStoneID(), Material.iron, 1F, Block.soundMetalFootstep, "GrindingStone", IndustrialProcessing.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        TileEntityGrindingStone te = new TileEntityGrindingStone();
        te.setName(this.getLocalizedName());
        return te;
    }

    @Override
    public int getRenderType() {
        return ConfigRenderers.getRendererGrindingStoneId();
    }
    @Override
    public Icon getIcon(int par1, int par2) {
        par1 %= icons.length;        
        return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        icons[0] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "GrindingStone");
    }
}
