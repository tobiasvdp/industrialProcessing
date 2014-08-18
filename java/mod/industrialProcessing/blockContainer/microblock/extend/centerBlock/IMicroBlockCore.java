package mod.industrialProcessing.blockContainer.microblock.extend.centerBlock;

import ip.industrialProcessing.microBlock.extend.connectionCorners.IMicroBlockConnectionCorner;
import net.minecraft.entity.player.EntityPlayer;

public interface IMicroBlockCore extends IMicroBlockConnectionCorner{

	public void setCore(int id);
	public void destroyBlock(EntityPlayer player);
	public boolean hasCore();
	
}
