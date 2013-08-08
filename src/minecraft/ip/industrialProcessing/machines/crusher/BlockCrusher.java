package ip.industrialProcessing.machines.crusher;

import java.io.Console;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
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
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockCrusher extends BlockMachine {

	public BlockCrusher() {
		super(ConfigMachineBlocks.getCrusherBlockID(), Material.iron, 1F,
				Block.soundMetalFootstep, "Ore Crusher",
				IndustrialProcessing.tabMachines);
		func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "crusher_top");
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityCrusher(world);
	}

	@SideOnly(Side.CLIENT)
	public Icon topIcon;
	public Icon bottomIcon;
	public Icon sideIcon; 

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		topIcon = par1IconRegister
				.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX
						+ "crusher_top");
		bottomIcon = par1IconRegister
				.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX
						+ "crusher_bottom");
		sideIcon = par1IconRegister
				.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX
						+ "crusher_side"); 
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		if (side == ForgeDirection.UP.ordinal())
			return topIcon;
		else if (side == ForgeDirection.DOWN.ordinal())
			return bottomIcon;
		else
			return sideIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getBlockTexture(IBlockAccess par1iBlockAccess, int par2,
			int par3, int par4, int side) {
 
		if (side == ForgeDirection.UP.ordinal())
			return topIcon;
		else if (side == ForgeDirection.DOWN.ordinal())
			return bottomIcon;
		else
			return  sideIcon;
	}

}
