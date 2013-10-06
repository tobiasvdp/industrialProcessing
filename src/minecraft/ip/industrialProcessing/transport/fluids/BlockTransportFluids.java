package ip.industrialProcessing.transport.fluids;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidTankInfo;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ConfigTransportBlocks;
import ip.industrialProcessing.transport.BlockTransport;

public class BlockTransportFluids extends BlockTransport {

	public BlockTransportFluids() {
		super(ConfigTransportBlocks.getBlockTransportFluidsID(), Material.glass, 1F, Block.soundGlassFootstep, "Fluid Pipe", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public boolean recolourBlock(World world, int x, int y, int z, ForgeDirection side, int colour) {
        int meta = world.getBlockMetadata(x, y, z);
        if (meta != colour)
        {
            world.setBlockMetadataWithNotify(x, y, z, colour, 3);
            ((TileEntityTransportFluidsBase)world.getBlockTileEntity(x, y, z)).setConnectionGroup(colour);
            return true;
        }
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityTransportFluids();
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		TileEntityTransportFluidsBase entity = (TileEntityTransportFluidsBase) par1World.getBlockTileEntity(par2, par3, par4);
		if (BlockTransportFluids.cycleConnectionStatesOnActivated(entity, par5EntityPlayer))
			return true;
		return false;
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererTransportFluidsId();
	}

	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z) {

		TileEntityTransportFluidsBase entity = (TileEntityTransportFluidsBase) world.getBlockTileEntity(x, y, z);
		FluidTankInfo[] subTanks = entity.getTanks();

		int lum = 0;
		int tanks = 0;

		for (int i = 0; i < subTanks.length; i++) {
			FluidTankInfo tank = subTanks[i];
			if (tank.fluid != null) {
				lum += tank.fluid.getFluid().getLuminosity();
				tanks++;
			}
		}
		if (tanks > 0)
			return lum / tanks;
		return super.getLightValue(world, x, y, z);
	}

	public static boolean cycleConnectionStatesOnActivated(TileEntityTransportFluidsBase entity, EntityPlayer par5EntityPlayer) {
		if (par5EntityPlayer != null) {
			ItemStack item = par5EntityPlayer.inventory.getCurrentItem();
			if (item != null) {
				if (new ItemStack(Item.stick).isItemEqual(item)) {
					entity.cycleGroups(par5EntityPlayer.isSneaking());
					return true;
				}
			}
		}
		return false;
	}
	Icon[] icon = new Icon[16];
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		for(int i = 0;i<16;i++){
			icon[i] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "pipe"+i);
		}
	}
	@Override
	public Icon getIcon(int par1, int par2) {
		return icon[par2];
	}
}
