package ip.industrialProcessing.subMod.logic.network.devices.readout.displayPost.model;

import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.microBlock.extend.centerBlock.IMicroBlockCore;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.Down;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.DownBottom;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.DownBottomCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.DownLeft;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.DownLeftCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.DownRight;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.DownRightCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.DownTop;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.DownTopCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.East;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.EastBottom;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.EastLeft;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.EastRight;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.EastRightCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.EastTop;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.North;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.NorthBottom;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.NorthLeft;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.NorthRight;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.NorthRightCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.NorthTop;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.South;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.SouthBottom;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.SouthLeft;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.SouthRight;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.SouthRightCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.SouthTop;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.Up;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.UpBottom;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.UpBottomCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.UpLeft;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.UpLeftCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.UpRight;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.UpRightCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.UpTop;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.UpTopCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.West;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.WestBottom;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.WestLeft;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.WestRight;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.WestRightCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.WestTop;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;

import org.lwjgl.util.vector.Vector3f;

public class ModelDisplayPost  extends ModelBlock {

	ObjMesh foot = new Foot();
	ObjMesh frame = new Frame();
	ObjMesh pole = new Pole();
	ObjMesh screen = new Screen();
	
	ObjMesh[] models = new ObjMesh[] { new Down(), new Up(), new North(), new South(), new West(), new East() };
	ObjMesh[][] innerconnections = new ObjMesh[][] { { new DownLeft(), new DownRight(), new DownTop(), new DownBottom() }, { new UpLeft(), new UpRight(), new UpTop(), new UpBottom() }, { new NorthLeft(), new NorthRight(), new NorthTop(), new NorthBottom() }, { new SouthLeft(), new SouthRight(), new SouthTop(), new SouthBottom() }, { new WestLeft(), new WestRight(), new WestTop(), new WestBottom() }, { new EastLeft(), new EastRight(), new EastTop(), new EastBottom() } };
	ObjMesh[][] cornerConnections = new ObjMesh[][]{{new DownLeftCorner(),new DownRightCorner(),new DownTopCorner(),new DownBottomCorner()},{new UpLeftCorner(),new UpRightCorner(),new UpTopCorner(),new UpBottomCorner()},{null,new NorthRightCorner(),null,null},{null,new SouthRightCorner(),null,null},{null,new WestRightCorner(),null,null},{null,new EastRightCorner(),null,null}};
	
	
	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

		int dir = 0;

		Vector3f position = new Vector3f(0, 0, 0);
		Icon iconWire = block.getIcon(0, 0);

		foot.renderMesh(iconWire);
		frame.renderMesh(iconWire);
		pole.renderMesh(iconWire);
		screen.renderMesh(iconWire);
	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

		IMicroBlockCore te = (IMicroBlockCore) reference.world.getBlockTileEntity(reference.x, reference.y, reference.z);
		int[] sides = te.getSides();
		
		Icon iconWire = reference.getIcon(0);

		if(te.hasCore()){
			foot.renderMesh(false, iconWire, reference);
			frame.renderMesh(false, iconWire, reference);
			pole.renderMesh(false, iconWire, reference);
			screen.renderMesh(false, iconWire, reference);
		}
		
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
				}
			}
		}

		return true;
	}
}
