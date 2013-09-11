package ip.industrialProcessing;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;

public interface ISubPacketHandler {
	public void handle(NBTTagCompound data, EntityPlayerMP player);

}
