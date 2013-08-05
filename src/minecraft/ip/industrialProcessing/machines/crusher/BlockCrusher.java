package ip.industrialProcessing.machines.crusher;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.IndustrialProcessingConfig;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.utils.Position;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockCrusher extends BlockMachine {

	public BlockCrusher() {
		super(IndustrialProcessingConfig.getCrusherBlockID(), Material.iron,
				1F, Block.soundMetalFootstep, "Ore Crusher",
				IndustrialProcessing.tabMachines);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityCrusher();
	}

	@SideOnly(Side.CLIENT)
	public static Icon topIcon;
	public static Icon bottomIcon;
	public static Icon sideIcon;
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister icon) {
		topIcon = icon.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX
				+ "crusher_top");
		bottomIcon = icon.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX
				+ "crusher_bottom");
		sideIcon = icon.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX
				+ "crusher_side");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta) {
		if(side == ForgeDirection.UP.ordinal())
			return topIcon;
		else if(side == ForgeDirection.DOWN.ordinal())
			return bottomIcon;
		else
			return sideIcon;
	}
	
	
    @Override
    public void onBlockAdded(World world, int x, int y, int z){                
    	super.onBlockAdded(world, x, y, z);                
    }
	@Override
	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase entityliving, ItemStack stack) {
		super.onBlockPlacedBy(world, i, j, k, entityliving, stack);


		ForgeDirection orientation = get2dOrientation(new Position(entityliving.posX, entityliving.posY, entityliving.posZ), new Position(i, j, k));

		world.setBlockMetadataWithNotify(i, j, k, orientation.getOpposite().ordinal(),1);
		if (entityliving instanceof EntityPlayer) {
			TileEntityCrusher tq = (TileEntityCrusher) world.getBlockTileEntity(i, j, k);
			tq.placedBy = (EntityPlayer) entityliving;
		}
	}


	public static ForgeDirection get2dOrientation(Position pos1, Position pos2) {
		double Dx = pos1.x - pos2.x;
		double Dz = pos1.z - pos2.z;
		double angle = Math.atan2(Dz, Dx) / Math.PI * 180 + 180;


		if (angle < 45 || angle > 315) {
			return ForgeDirection.EAST;
		} else if (angle < 135) {
			return ForgeDirection.SOUTH;
		} else if (angle < 225) {
			return ForgeDirection.WEST;
		} else {
			return ForgeDirection.NORTH;
		}
	}


}
