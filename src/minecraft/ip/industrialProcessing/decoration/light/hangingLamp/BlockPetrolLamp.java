package ip.industrialProcessing.decoration.light.hangingLamp;

import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.WEST;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.decoration.light.BlockLamp;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.IRotateableEntity;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockPetrolLamp extends BlockLamp {

	private Icon[] icons = new Icon[2];

	public BlockPetrolLamp() {
		super(ConfigMachineBlocks.getBlockPetrolLamp(), Material.glass, 1f, soundMetalFootstep, "Petrol Lamp", ISetupCreativeTabs.tabFluid);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityPetrolLamp();
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		par1 %= icons.length;
		return icons[par1];
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Stone");
		icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Iron");
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererPetrolLampId();
	}
}
