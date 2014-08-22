package mod.industrialProcessing.transport.motion;

import mod.industrialProcessing.blockContainer.BlockContainerIPRendered;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMotion extends BlockContainerIPRendered {

	public BlockMotion(float hardness, float resistance, Material material, SoundType soundtype, String... iconNames) {
		super(hardness, resistance, material, soundtype, iconNames);
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block par5, int par6) {
		if (!world.isRemote) {
			TileEntity entity = world.getTileEntity(x, y, z);
			if (entity instanceof ClusterTileEntityMotion) {
				ClusterTileEntityMotion motionEntity = (ClusterTileEntityMotion) entity;
				ClusterManagerMotion.manager(world).remove(motionEntity);
				motionEntity.setClusterItem(null);
			}
		}
		super.breakBlock(world, x, y, z, par5, par6);
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
		super.onBlockPlacedBy(world, x, y, z, entityLivingBase, itemStack);
		if (!world.isRemote) {
			TileEntity entity = world.getTileEntity(x, y, z);
			if (entity instanceof ClusterTileEntityMotion) {
				ClusterTileEntityMotion motionEntity = (ClusterTileEntityMotion) entity;
				ClusterItemMotion item = ClusterManagerMotion.manager(world).add(motionEntity);
				motionEntity.setClusterItem(item);
				motionEntity.onPlaced();
			}
		}
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float clickX, float clickY, float clickZ) {

		TileEntity entity = world.getTileEntity(x, y, z);
		if (entity instanceof ClusterTileEntityMotion) {
			ClusterTileEntityMotion motionEntity = (ClusterTileEntityMotion) entity;
			System.out.println(world.isRemote + " Cluster:" + motionEntity.getClusterId());
			player.addChatMessage(new ChatComponentText(world.isRemote + " Cluster:" + motionEntity.getClusterId()));
			ClusterItemMotion clusterItem = motionEntity.getClusterItem();
			if (clusterItem != null)
				System.out.println("ClusterItem " + clusterItem.getClusterID());
		}
		return super.onBlockActivated(world, x, y, z, player, metadata, clickX, clickY, clickZ);
	}

	@Override
	public void onNeighborChange(IBlockAccess world, int x, int y, int z, int tileX, int tileY, int tileZ) {
		super.onNeighborChange(world, x, y, z, tileX, tileY, tileZ);
		TileEntity entity = world.getTileEntity(x, y, z);
		if (entity instanceof ClusterTileEntityMotion) {
			ClusterTileEntityMotion tem = (ClusterTileEntityMotion) entity;
			tem.neighborChange(tileX, tileY, tileZ);
		} 
	}
}
