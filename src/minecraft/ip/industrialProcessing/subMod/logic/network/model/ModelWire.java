package ip.industrialProcessing.subMod.logic.network.model;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.microBlock.IMicroBlock;
import ip.industrialProcessing.microBlock.connectingSides.IMicroBlockInterconnection;
import ip.industrialProcessing.microBlock.connectionCorners.IMicroBlockConnectionCorner;
import ip.industrialProcessing.microBlock.connections.IMicroBlockConnection;

public class ModelWire extends ModelBlock {

	ObjMesh[] models = new ObjMesh[] { new Down(), new Up(), new North(), new South(), new West(), new East() };
	ObjMesh[][] innerconnections = new ObjMesh[][] { { new DownLeft(), new DownRight(), new DownTop(), new DownBottom() }, { new UpLeft(), new UpRight(), new UpTop(), new UpBottom() }, { new NorthLeft(), new NorthRight(), new NorthTop(), new NorthBottom() }, { new SouthLeft(), new SouthRight(), new SouthTop(), new SouthBottom() }, { new WestLeft(), new WestRight(), new WestTop(), new WestBottom() }, { new EastLeft(), new EastRight(), new EastTop(), new EastBottom() } };
	ObjMesh[][] cornerConnections = new ObjMesh[][]{{new DownLeftCorner(),new DownRightCorner(),new DownTopCorner(),new DownBottomCorner()},{new UpLeftCorner(),new UpRightCorner(),new UpTopCorner(),new UpBottomCorner()},{null,new NorthRightCorner(),null,null},{null,new SouthRightCorner(),null,null},{null,new WestRightCorner(),null,null},{null,new EastRightCorner(),null,null}};
	
	
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

		int dir = 0;

		Vector3f position = new Vector3f(0, 0, 0);
		Icon iconWire = block.getIcon(0, 0);

		models[0].renderMesh(iconWire);
		innerconnections[0][2].renderMesh(iconWire);
		innerconnections[0][3].renderMesh(iconWire);
	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

		IMicroBlockConnectionCorner te = (IMicroBlockConnectionCorner) reference.world.getBlockTileEntity(reference.x, reference.y, reference.z);
		int[] sides = te.getSides();
		
		Icon iconWire = reference.getIcon(0);

		for (int i = 0; i < sides.length; i++) {
			if (sides[i] != -1){
				boolean[] innercon = te.getInterConnections(i);
				boolean[] externCon = te.getExternalConnections(i);
				boolean[] externConCor = te.getExternalConnectionCorners(i);
				models[i].renderMesh(false, iconWire, reference);
				for(int j = 0;j<innercon.length;j++){
					if(innercon[j] || externCon[j])
						innerconnections[i][j].renderMesh(false, iconWire, reference);
					if(externConCor[j]){
						if(cornerConnections[i][j] != null)
							cornerConnections[i][j].renderMesh(false, iconWire, reference);
					}
					System.out.println(i + " " + j +" "+externConCor[j]);
				}
			}
		}

		return true;
	}
}
