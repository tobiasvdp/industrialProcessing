package ip.industrialProcessing.transport;

import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.ClientProxy;
import ip.industrialProcessing.utils.inventories.InventoryUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public abstract class BlockTransport extends BlockContainer {

    public BlockTransport(int blockId, Material material, float hardness, StepSound sound, String name, CreativeTabs tab) {
	super(blockId, material);
	setHardness(hardness);
	setStepSound(sound);
	setUnlocalizedName(name);
	setCreativeTab(tab);
    }

    @Override
    public boolean isOpaqueCube() {
	return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
	return false;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l) {
	return false;
    }

    @Override
    public int getRenderBlockPass() {
	return 1;
    }

    @Override
    public boolean canRenderInPass(int pass) {
	// this looks weird??????
	// Set the static var in the client proxy
	ClientProxy.renderPass = pass;
	// the block can render in both passes, so return true always
	return true;
    }

    @Override
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
	super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
	TileEntityTransport transport = (TileEntityTransport) par1World.getBlockTileEntity(par2, par3, par4);
	transport.searchForConnections();
	System.out.println("Transport changed at " + par2 + ", " + par3 + ", " + par4);
    }

}
