package ip.industrialProcessing;

import ip.industrialProcessing.machines.filter.TileEntityFilter;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.Entity;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {
	
	public PacketHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onPacketData(INetworkManager manager,
			Packet250CustomPayload packet, Player player) {
        if (packet.channel.equals("IPTileSync")) {
            Entity playerEntity = (Entity)player;
            TileEntity thisTileEntity;
            TileEntityFilter thisTileEntityFilter;
            int xcoord;
            int ycoord;
            int zcoord;
        	int totalWork;
        	int workDone;
            
            DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
            
            try {
                	xcoord = inputStream.readInt();
                	ycoord = inputStream.readInt();
                	zcoord = inputStream.readInt();
                	totalWork = inputStream.readInt();
                	workDone = inputStream.readInt();
            } catch (IOException e) {
                    e.printStackTrace();
                    return;
            }    
            
            thisTileEntity =playerEntity.worldObj.getBlockTileEntity(xcoord, ycoord, zcoord);
            if (thisTileEntity != null) {
        	try{
        		thisTileEntityFilter=(TileEntityFilter)thisTileEntity;
        		thisTileEntityFilter.syncWorker(totalWork, workDone);
        		
        	}catch(Exception e){
        		System.out.println("Cold not cast");
        		System.out.println(xcoord + " " + ycoord + " " + zcoord);
        		
        	}        
            }	

        }

	}
}
