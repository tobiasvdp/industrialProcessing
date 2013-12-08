package ip.industrialProcessing.machines.crusher;

import java.io.Console;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.transport.steve.railway.suspended.cart.EntityFloatingCart;
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

public class BlockCrusher extends BlockMachineRendered {

    public BlockCrusher() {
        super(ConfigMachineBlocks.getCrusherBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Ore Crusher", IndustrialProcessing.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        TileEntityCrusher te = new TileEntityCrusher();
        te.setName(this.getLocalizedName());
        return te;
    }

    @Override
    public int getRenderType() {
        return ConfigRenderers.getRendererCrusherId();
    }

    Random rnd = new Random();

    @Override
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        super.randomDisplayTick(par1World, par2, par3, par4, par5Random);
        TileEntityCrusher crusher = (TileEntityCrusher) par1World.getBlockTileEntity(par2, par3, par4);
        if (crusher.getWorker().isWorking()) {
            for (int i = 0; i < 5; i++) {
                int x = 0;
                int z = 0;
                float offsetX = (2 * rnd.nextFloat() - 1f) * 0.25f;
                float offsetZ = (2 * rnd.nextFloat() - 1f) * 0.25f;
                par1World.spawnParticle("smoke", par2 + 0.5f + offsetX, par3 + 0.5f + offsetZ, par4 + 0.5f, x, -0.001f, z);
            }
        }
    }

}
