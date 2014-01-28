package ip.industrialProcessing.subMod.logic.network;


import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class BlockLogicTransport extends BlockContainer {

	public BlockLogicTransport(int par1, Material par2Material) {
		super(par1, par2Material);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityLogicTransport();
	}
@Override
public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
if(par5EntityPlayer.getCurrentEquippedItem() != null){
	if(par5EntityPlayer.getCurrentEquippedItem().getItem() instanceof ItemBlock || par5EntityPlayer.getCurrentEquippedItem().getItem() instanceof ItemBlockWithMetadata){
		if(Block.blocksList[par5EntityPlayer.getCurrentEquippedItem().itemID] instanceof BlockLogicTransport){
			int side = rayTroughBlock(par6,par7,par8,par9,par5EntityPlayer.posX,par5EntityPlayer.posY,par5EntityPlayer.posZ, par5EntityPlayer.getEyeHeight(),par5EntityPlayer.yOffset,par5EntityPlayer.cameraPitch,par5EntityPlayer.cameraYaw);
		}
	}
}
	return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
}

private int rayTroughBlock(int side,float sideX, float sideU, float sideZ, double playerX, double playerY, double playerZ, float eyeHeight,float yOffset, float cameraPitch, float cameraYaw) {
	 Vec3 vec3d = Vec3.createVectorHelper(playerX, (playerY + eyeHeight) - yOffset, playerZ);
	return 0;
}
}
