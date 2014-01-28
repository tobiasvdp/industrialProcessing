package ip.industrialProcessing.subMod.logic.network;

import ip.industrialProcessing.microBlock.BlockMicroBlock;
import ip.industrialProcessing.microBlock.MicroBlockType;
import ip.industrialProcessing.multiblock.IMicroBlock;
import ip.industrialProcessing.subMod.logic.IPLogic;
import ip.industrialProcessing.subMod.logic.config.ConfigLogic;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockLogicTransport extends BlockMicroBlock {

	public BlockLogicTransport() {
		super(ConfigLogic.getBLlogicCable(), Material.cloth);
		setCreativeTab(IPLogic.tabLogic);
		setUnlocalizedName("BlockLogicTransport");
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityLogicTransport();
	}

	@Override
	public MicroBlockType getMicroBlockType() {
		return MicroBlockType.wire;
	}

}
