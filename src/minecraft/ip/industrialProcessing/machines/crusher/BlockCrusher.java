package ip.industrialProcessing.machines.crusher;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.IndustrialProcessingConfig;
import ip.industrialProcessing.machines.BlockMachine;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
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
	@SideOnly(Side.CLIENT)
	public static Icon bottomIcon;
	@SideOnly(Side.CLIENT)
	public static Icon sideIcon;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		topIcon = icon.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX
				+ "inputTop");
		bottomIcon = icon.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX
				+ "outputDown");
		sideIcon = icon.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX
				+ "crusherSide");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		if(side == ForgeDirection.UP.ordinal())
			return topIcon;
		else if(side == ForgeDirection.DOWN.ordinal())
			return bottomIcon;
		else
			return sideIcon;
	}
}
