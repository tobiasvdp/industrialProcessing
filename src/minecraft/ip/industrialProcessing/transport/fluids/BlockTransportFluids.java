package ip.industrialProcessing.transport.fluids;

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
		super(ConfigTransportBlocks.BlockTransportFluidsID(), "BlockTransportFluids");
	}
    @Override
    public TileEntity createNewTileEntity(World world) {
    	return new TileEntityTransportFluids();
    }
    @Override
    public int getRenderType() {
    	return ConfigRenderers.getRendererTransportFluidsId();
    }
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int par5) {
		TileEntityTransportFluids entity = (TileEntityTransportFluids) world.getBlockTileEntity(x, y, z);
		entity.senseSides(world);
		world.markBlockForUpdate(x, y, z);
	}
	@Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
	int dir = MathHelper.floor_double((double) ((entityLivingBase.rotationYaw * 4F) / 360F) + 0.5D) & 3;
	world.setBlockMetadataWithNotify(x, y, z, dir, 0);
	TileEntityTransportFluids entity = (TileEntityTransportFluids) world.getBlockTileEntity(x, y, z);
	entity.senseSides(world);
    }

}
