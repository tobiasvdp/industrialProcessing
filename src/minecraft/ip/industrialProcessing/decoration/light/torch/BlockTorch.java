package ip.industrialProcessing.decoration.light.torch;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.decoration.light.BlockLamp;

public class BlockTorch extends BlockLamp {

    private Icon[] icons = new Icon[1];

    public BlockTorch() {
	super(ConfigMachineBlocks.getBlockTorchID(), Material.wood, 0.5f, Block.soundWoodFootstep, "BlockTorch", IndustrialProcessing.tabOreProcessing);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	return new TileEntityTorch();
    }

    @Override
    public Icon getIcon(int par1, int par2) {
	par1 %= icons.length;
	return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
	icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "torch_on");
    }

    @Override
    public int getRenderType() {
	return 2;
    }

    @Override
    public int idDropped(int par1, Random par2Random, int par3) {
	return Item.stick.itemID;
    }

    @Override
    public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {

    }

}
