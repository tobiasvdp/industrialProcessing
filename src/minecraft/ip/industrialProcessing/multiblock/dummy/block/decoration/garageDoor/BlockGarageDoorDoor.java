package ip.industrialProcessing.multiblock.dummy.block.decoration.garageDoor;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.dummy.BlockMultiblockDummy;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGarageDoorDoor extends BlockContainer {

	Icon[] icons = new Icon[1];

	public BlockGarageDoorDoor() {
		super(ConfigMachineBlocks.getBlockGarageDoorDoorID(), Material.iron);
		setHardness(1F);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName("BlockGarageDoorDoor");
		setCreativeTab(ISetupCreativeTabs.tabMultiblocks);
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
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityGarageDoorDoor();
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererGarageDoor();
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		par1 %= icons.length;
		return icons[par1];
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "blockGarage");
	}

}
