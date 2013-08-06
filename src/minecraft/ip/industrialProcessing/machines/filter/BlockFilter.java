package ip.industrialProcessing.machines.filter;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.IndustrialProcessingConfig;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.utils.inventories.InventoryUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFilter extends BlockMachine {

	public BlockFilter() {
		super(IndustrialProcessingConfig.getFilterBlockID(), Material.iron, 1F,
				Block.soundMetalFootstep, "Ore Filter",
				IndustrialProcessing.tabMachines);
				setBlockBounds(-1F, 0F, -1F, 2F, 3F, 2F);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityFilter();
	}
	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
	{
	   return false;
	}
	@Override
	public boolean isOpaqueCube()
	{
	   return false;
	}
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack){
        int offsetX1 = -1;
        int offsetX2 = 1;
        int offsetZ1 = -1;
        int offsetZ2 = 1;
        int offsetY1 = 0;
        int offsetY2 = 3;
        
        for (int i = offsetX1;i<=offsetX2;i++){
            for (int j = offsetZ1;j<=offsetZ2;j++){
                for (int k = offsetY1;k<=offsetY2;k++){
                	int l = world.getBlockId(x+i, y+k, z+j);
                	Block block = Block.blocksList[l];
                	if (block != null){
                		if(i==0 && k==0 && j==0){}
                		else{
                			world.setBlock(x+i, y+k, z+j,0);
                		}
                	}
                }
            }
        }
		
		int dir = MathHelper.floor_double((double)((entityLivingBase.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, dir, 0);
        
        addCollisionBoxesToList(world, x, y, z, null, null, entityLivingBase);
	}
	@Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        float f = 0F;
        
        return AxisAlignedBB.getAABBPool().getAABB((double)((float)par2 + f), (double)par3, (double)((float)par4 + f), (double)((float)(par2 + 1) - f), (double)((float)(par3 + 1) - f), (double)((float)(par4 + 1) - f));
    }
	@Override
    public boolean renderAsNormalBlock(){                
		return false;        
	}
	
	@Override
    public boolean canPlaceBlockAt(World par1World, int x, int y, int z)
    {
        boolean canPlace = true;
        int offsetX1 = -1;
        int offsetX2 = 1;
        int offsetZ1 = -1;
        int offsetZ2 = 1;
        int offsetY1 = 0;
        int offsetY2 = 3;
        
        for (int i = offsetX1;i<=offsetX2;i++){
            for (int j = offsetZ1;j<=offsetZ2;j++){
                for (int k = offsetY1;k<=offsetY2;k++){
                	int l = par1World.getBlockId(x+i, y+k, z+j);
                	Block block = Block.blocksList[l];
                	if (block != null){
                		if (!block.isBlockReplaceable(par1World, x+i, y+k, z+j))
                		canPlace = false;
                	}
                }
            }
        }
        return canPlace;
    }
}
