package ip.industrialProcessing.subMod.logic.network.devices.interfaces.machineInterface.model;

import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.microBlock.connectionCorners.IMicroBlockConnectionCorner;
import ip.industrialProcessing.subMod.logic.network.devices.readout.displayPanel.model.Hull;
import ip.industrialProcessing.subMod.logic.network.devices.readout.displayPanel.model.Panel;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.DownBottom;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.DownBottomCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.DownLeft;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.DownLeftCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.DownRight;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.DownRightCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.DownTop;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.DownTopCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.EastBottom;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.EastLeft;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.EastRight;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.EastRightCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.EastTop;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.NorthBottom;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.NorthLeft;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.NorthRight;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.NorthRightCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.NorthTop;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.SouthBottom;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.SouthLeft;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.SouthRight;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.SouthRightCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.SouthTop;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.UpBottom;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.UpBottomCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.UpLeft;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.UpLeftCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.UpRight;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.UpRightCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.UpTop;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.UpTopCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.WestBottom;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.WestLeft;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.WestRight;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.WestRightCorner;
import ip.industrialProcessing.subMod.logic.network.transport.wired.bus.model.WestTop;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.Icon;

import org.lwjgl.util.vector.Vector3f;

public class ModelMachineInterface extends ModelBlock {

	ObjRotator box = new ObjRotator(new Box(), 0);
	ObjRotator frame = new ObjRotator(new Frame(), 0);
	ObjRotator label = new ObjRotator(new Label(), 0);
	ObjRotator lit = new ObjRotator(new Lit(), 0);
	
	ObjMesh[] models = new ObjMesh[]{ null, null, box.getRotated(0), box.getRotated(2), box.getRotated(1), box.getRotated(3) };
	ObjMesh[] models2 = new ObjMesh[]{ null, null, frame.getRotated(0), frame.getRotated(2), frame.getRotated(1), frame.getRotated(3) };
	ObjMesh[] models3 = new ObjMesh[]{ null, null, label.getRotated(0), label.getRotated(2), label.getRotated(1), label.getRotated(3) };
	ObjMesh[] models4 = new ObjMesh[]{ null, null, lit.getRotated(0), lit.getRotated(2), lit.getRotated(1), lit.getRotated(3) };
	ObjMesh[][] innerconnections = new ObjMesh[][] { { new DownLeft(), new DownRight(), new DownTop(), new DownBottom() }, { new UpLeft(), new UpRight(), new UpTop(), new UpBottom() }, { new NorthLeft(), new NorthRight(), new NorthTop(), new NorthBottom() }, { new SouthLeft(), new SouthRight(), new SouthTop(), new SouthBottom() }, { new WestLeft(), new WestRight(), new WestTop(), new WestBottom() }, { new EastLeft(), new EastRight(), new EastTop(), new EastBottom() } };
	ObjMesh[][] cornerConnections = new ObjMesh[][]{{new DownLeftCorner(),new DownRightCorner(),new DownTopCorner(),new DownBottomCorner()},{new UpLeftCorner(),new UpRightCorner(),new UpTopCorner(),new UpBottomCorner()},{null,new NorthRightCorner(),null,null},{null,new SouthRightCorner(),null,null},{null,new WestRightCorner(),null,null},{null,new EastRightCorner(),null,null}};
	
	
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

		int dir = 0;

		Vector3f position = new Vector3f(0, 0, 0);
		Icon iconWire = block.getIcon(0, 0);
		Icon iconOrange = block.getIcon(1, 0);
		Icon iconScreen = block.getIcon(2, 0);

		models[2].renderMesh(iconOrange);
		models2[2].renderMesh(iconScreen);
		models3[2].renderMesh(iconOrange);
		models4[2].renderMesh(iconScreen);
		innerconnections[2][0].renderMesh(iconWire);
	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

		IMicroBlockConnectionCorner te = (IMicroBlockConnectionCorner) reference.world.getBlockTileEntity(reference.x, reference.y, reference.z);
		int[] sides = te.getSides();
		
		Icon iconWire = reference.getIcon(0);
		Icon iconOrange = reference.getIcon(1);
		Icon iconScreen = reference.getIcon(2);

		for (int i = 0; i < sides.length; i++) {
			if (sides[i] != -1){
				boolean[] innercon = te.getInterConnections(i);
				boolean[] externCon = te.getExternalConnections(i);
				boolean[] externConCor = te.getExternalConnectionCorners(i);
				//models[i].renderMesh(false, iconOrange, reference);
				//models2[i].renderMesh(false, iconOrange, reference);
				//models3[i].renderMesh(false, iconScreen, reference);
				//models4[i].renderMesh(false, iconOrange, reference);
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
