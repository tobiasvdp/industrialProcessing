package ip.industrialProcessing.subMod.logic.network.devices.interfaces.machineInterface;

import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.microBlock.MicroBlockType;
import ip.industrialProcessing.subMod.logic.IPLogic;
import ip.industrialProcessing.subMod.logic.config.ConfigLogic;
import ip.industrialProcessing.subMod.logic.network.devices.readout.displayPanel.TileEntityDisplayPanel;
import ip.industrialProcessing.subMod.logic.network.microblock.BlockLogicNode;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockMachineInterface extends BlockLogicNode{
	private Icon[] icons = new Icon[3];
	
	public BlockMachineInterface() {
		super(ConfigLogic.getBlockMachineInterfaceID(), Material.iron, 10.0f, Block.soundMetalFootstep, "BlockMachineInterface", IPLogic.tabLogic);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityMachineInterface();
	}

	@Override
	public MicroBlockType getMicroBlockType() {
		return MicroBlockType.device;
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererMachineInterface();
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		par1 %= icons.length;
		return icons [par1];
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		this.icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "blockWire");
		this.icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Orange");
		this.icons[2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "DataPanel");
	}
}
