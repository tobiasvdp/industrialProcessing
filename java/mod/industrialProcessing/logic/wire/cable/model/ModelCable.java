package mod.industrialProcessing.logic.wire.cable.model;

import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.utils.registry.MicroBlockModelRegistry;

public class ModelCable {

	private static final  ObjMesh[][] dataBusCenter = new ObjMesh[][] { {new Down(), new Up(), new North(), new South(), new West(), new East() }};
    private static final  ObjMesh[][] dataBusInternal = new ObjMesh[][] { { new DownLeft(), new DownRight(), new DownTop(), new DownBottom() }, { new UpLeft(), new UpRight(), new UpTop(), new UpBottom() }, { new NorthLeft(), new NorthRight(), new NorthTop(), new NorthBottom() }, { new SouthLeft(), new SouthRight(), new SouthTop(), new SouthBottom() }, { new WestLeft(), new WestRight(), new WestTop(), new WestBottom() }, { new EastLeft(), new EastRight(), new EastTop(), new EastBottom() } };
    private static final  ObjMesh[][] dataBusCorners = new ObjMesh[][]{{new DownLeftCorner(),new DownRightCorner(),new DownTopCorner(),new DownBottomCorner()},{new UpLeftCorner(),new UpRightCorner(),new UpTopCorner(),new UpBottomCorner()},{null,new NorthRightCorner(),null,null},{null,new SouthRightCorner(),null,null},{null,new WestRightCorner(),null,null},{null,new EastRightCorner(),null,null}};
    private static final  String[][] dataBusCenterIcons = new String[][]{{"blockWire","blockWire","blockWire","blockWire","blockWire","blockWire"}};
    private static final  String[][] dataBusInternalIcons = new String[][]{{"blockWire","blockWire","blockWire","blockWire"},{"blockWire","blockWire","blockWire","blockWire"},{"blockWire","blockWire","blockWire","blockWire"},{"blockWire","blockWire","blockWire","blockWire"},{"blockWire","blockWire","blockWire","blockWire"},{"blockWire","blockWire","blockWire","blockWire"}};
    private static final  String[][] dataBusCornersIcons = new String[][]{{"blockWire","blockWire","blockWire","blockWire"},{"blockWire","blockWire","blockWire","blockWire"},{"blockWire","blockWire","blockWire","blockWire"},{"blockWire","blockWire","blockWire","blockWire"},{"blockWire","blockWire","blockWire","blockWire"},{"blockWire","blockWire","blockWire","blockWire"}};
	
	public void register(int id){
		MicroBlockModelRegistry.registerModel(id,dataBusCenter, dataBusInternal, dataBusCorners,dataBusCenterIcons,dataBusInternalIcons,dataBusCornersIcons);
	}
}
