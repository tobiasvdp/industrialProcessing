package ip.industrialProcessing.machines.plants.storage.storageBox;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.IGuiLayout;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.IRotateableEntity;
import ip.industrialProcessing.machines.plants.storage.storageRack.TileEntityStorageRack;
import ip.industrialProcessing.utils.IDescriptionBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockStorageBox extends BlockMachineRendered implements IDescriptionBlock, IGuiLayout {
	public static GuiLayout guiLayout;
	static {
		guiLayout = new GuiLayout();
		guiLayout.addLayoutPanel(GuiLayoutPanelType.slotsInput).setSlotLayout(SlotLayoutType.vertical, 9);
	}
	private Icon[] icons = new Icon[1];

	public BlockStorageBox() {
		super(ConfigMachineBlocks.getBlockStorageBoxID(), Material.iron, 1F, Block.soundMetalFootstep, "BlockStorageBox", ISetupCreativeTabs.tabOreProcessing);

	}

	@Override
	public boolean canPlaceBlockAt(World par1World, int x, int y, int z) {
		if (par1World.isBlockSolidOnSide(x, y - 1, z, ForgeDirection.UP))
			return super.canPlaceBlockAt(par1World, x, y, z);
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		TileEntityStorageBox te = new TileEntityStorageBox();
		te.setName(getLocalizedName());
		return te;
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererStorageBox();
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		par1 %= icons.length;
		return icons[par1];
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		this.icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "blockBox");
	}

	@Override
	public String getDescription() {
		return "Storage boxes can be stored in racks.";
	}

	@Override
	public GuiLayout getGuiLayout() {
		return guiLayout;
	}

	@Override
	public MovingObjectPosition collisionRayTrace(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3) {
		int l = ((IRotateableEntity) par1World.getBlockTileEntity(par2, par3, par4)).getForwardDirection().ordinal();
		if (l == 2) {
			this.setBlockBounds(0.17F, 0.0F, 0.32F, 0.83F, 0.23F, 0.68F);
		} else if (l == 3) {
			this.setBlockBounds(0.17F, 0.0F, 0.32F, 0.83F, 0.23F, 0.68F);
		} else if (l == 4) {
			this.setBlockBounds(0.32F, 0.0F, 0.17F, 0.68F, 0.23F, 0.83F);
		} else if (l == 5) {
			this.setBlockBounds(0.32F, 0.0F, 0.17F, 0.68F, 0.23F, 0.83F);
		}

		return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3, par6Vec3);
	}
}
