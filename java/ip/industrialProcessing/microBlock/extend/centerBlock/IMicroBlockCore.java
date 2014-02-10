package ip.industrialProcessing.microBlock.extend.centerBlock;

import net.minecraft.entity.player.EntityPlayer;
import ip.industrialProcessing.microBlock.extend.connectionCorners.IMicroBlockConnectionCorner;

public interface IMicroBlockCore extends IMicroBlockConnectionCorner{

	public void setCore(int id);
	public void destroyBlock(EntityPlayer player);
	public boolean hasCore();
	
}
