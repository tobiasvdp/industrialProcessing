package ip.industrialProcessing.transport.fluids;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ConfigTransportBlocks;
import ip.industrialProcessing.machines.multiblock.MultiblockUtils;
import ip.industrialProcessing.transport.BlockTransport;

public class BlockTransportFluids extends BlockTransport {

    public BlockTransportFluids() {
	//super(ConfigTransportBlocks.BlockTransportFluidsID(), "BlockTransportFluids");
	super(ConfigTransportBlocks.BlockTransportFluidsID(), Material.glass, 1F, Block.soundGlassFootstep, "Fluid Transport Pipe", IndustrialProcessing.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	return new TileEntityTransportFluids();
    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererTransportFluidsId();
    } 
}
