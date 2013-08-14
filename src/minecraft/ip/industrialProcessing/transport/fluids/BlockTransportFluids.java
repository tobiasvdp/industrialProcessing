package ip.industrialProcessing.transport.fluids;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidTankInfo;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ConfigTransportBlocks;
import ip.industrialProcessing.multiblock.utils.MultiblockUtils;
import ip.industrialProcessing.transport.BlockTransport;

public class BlockTransportFluids extends BlockTransport {

    public BlockTransportFluids() {
	// super(ConfigTransportBlocks.BlockTransportFluidsID(),
	// "BlockTransportFluids");
	super(ConfigTransportBlocks.BlockTransportFluidsID(), Material.glass, 1F, Block.soundGlassFootstep, "Fluid Transport Pipe", IndustrialProcessing.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	return new TileEntityTransportFluids();
    }

    @Override
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
	TileEntityTransportFluids entity = (TileEntityTransportFluids) par1World.getBlockTileEntity(par2, par3, par4);
	FluidTankInfo info = entity.getTankInfo();
	int level = info.fluid == null ? 0 : info.fluid.amount;
	String name = info.fluid == null ? "" : info.fluid.getFluid().getName();
	String side = par1World.isRemote ? "client" : "server";
	par5EntityPlayer.addChatMessage(side + " " + name + " level: " + level + "mB");
	return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);

    }

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererTransportFluidsId();
    }
}
