package ip.industrialProcessing.subMod.logic.network.transport.wired.bus;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.microBlock.MicroBlockType;
import ip.industrialProcessing.subMod.logic.IPLogic;
import ip.industrialProcessing.subMod.logic.config.ConfigLogic;
import ip.industrialProcessing.subMod.logic.network.BlockLogicTransport;
import ip.industrialProcessing.subMod.logic.network.TileEntityLogicTransport;

public class BlockDataBus extends BlockLogicTransport{
	
	private Icon[] icons = new Icon[1];

	public BlockDataBus() {
		super(ConfigLogic.getBlockDataBusID(), Material.cloth, 10.0f, Block.soundClothFootstep, "BlockDataBus", IPLogic.tabLogic);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityDataBus();
	}

	@Override
	public MicroBlockType getMicroBlockType() {
		return MicroBlockType.wire;
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererDataBus();
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		par1 %= icons.length;
		return icons [par1];
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		this.icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "blockWire");
	}

}
