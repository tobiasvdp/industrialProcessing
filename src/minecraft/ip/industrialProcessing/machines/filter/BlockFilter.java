package ip.industrialProcessing.machines.filter;

import java.util.List;

import javax.jws.Oneway;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.client.ClientProxy;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.utils.inventories.InventoryUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFilter extends BlockMachineRendered {

	private Icon[] textures;
	
	public BlockFilter() {
		super(ConfigMachineBlocks.getFilterBlockID(), Material.iron, 1F,
		Block.soundMetalFootstep, "Ore Filter",
		IndustrialProcessing.tabOreProcessing);
	}			

    @Override
    public int getRenderType()
    {
        return ConfigRenderers.getRendererFilterId();
    }

	@Override
	public TileEntity createNewTileEntity(World world) {
		TileEntityFilter te = new TileEntityFilter();
		te.setName(getLocalizedName());
		return te;
	}
}
