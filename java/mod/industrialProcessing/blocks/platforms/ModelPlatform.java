package mod.industrialProcessing.blocks.platforms;

import javax.swing.Icon;

import mod.industrialProcessing.client.rendering.ModelBlock;
import mod.industrialProcessing.client.rendering.obj.connectedTile.ConnectionCompass;
import mod.industrialProcessing.client.rendering.obj.connectedTile.TileConnection;
import mod.industrialProcessing.client.rendering.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.obj.wavefront.WorldReference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

public class ModelPlatform extends ModelBlock {

	FloorCenterMesh meshCenter = new FloorCenterMesh();

	FloorConnectedSide meshConnectedSouth = new FloorConnectedSide();
	FloorUnconnectedSide meshUnconnectedSouth = new FloorUnconnectedSide();

	FloorConnectedSide meshConnectedNorth;
	FloorUnconnectedSide meshUnconnectedNorth;

	FloorConnectedSide meshConnectedEast;
	FloorUnconnectedSide meshUnconnectedEast;

	FloorConnectedSide meshConnectedWest;
	FloorUnconnectedSide meshUnconnectedWest;

	FloorCornerOutside meshCornerOutsideSouthWest;
	FloorCornerOutside meshCornerOutsideSouthEast = new FloorCornerOutside();
	FloorCornerOutside meshCornerOutsideNorthWest;
	FloorCornerOutside meshCornerOutsideNorthEast;

	FloorCornerInside meshCornerInsideSouthWest;
	FloorCornerInside meshCornerInsideSouthEast = new FloorCornerInside();
	FloorCornerInside meshCornerInsideNorthWest;
	FloorCornerInside meshCornerInsideNorthEast;

	FloorCornerFull meshCornerFullSouthWest;
	FloorCornerFull meshCornerFullSouthEast = new FloorCornerFull();
	FloorCornerFull meshCornerFullNorthWest;
	FloorCornerFull meshCornerFullNorthEast;

	FloorCornerStraight1 meshCornerStraight1SouthWest;
	FloorCornerStraight1 meshCornerStraight1SouthEast = new FloorCornerStraight1();
	FloorCornerStraight1 meshCornerStraight1NorthWest;
	FloorCornerStraight1 meshCornerStraight1NorthEast;

	FloorCornerStraight2 meshCornerStraight2SouthWest;
	FloorCornerStraight2 meshCornerStraight2SouthEast = new FloorCornerStraight2();
	FloorCornerStraight2 meshCornerStraight2NorthWest;
	FloorCornerStraight2 meshCornerStraight2NorthEast;

	HandRailCornerOutside meshHandRailCornerOutsideSouthWest;
	HandRailCornerOutside meshHandRailCornerOutsideSouthEast = new HandRailCornerOutside();
	HandRailCornerOutside meshHandRailCornerOutsideNorthWest;
	HandRailCornerOutside meshHandRailCornerOutsideNorthEast;

	HandRailCornerInside meshHandRailCornerInsideSouthWest;
	HandRailCornerInside meshHandRailCornerInsideSouthEast = new HandRailCornerInside();
	HandRailCornerInside meshHandRailCornerInsideNorthWest;
	HandRailCornerInside meshHandRailCornerInsideNorthEast;

	HandRailStraight meshHandRailStraightSouth = new HandRailStraight();
	HandRailStraight meshHandRailStraightEast;
	HandRailStraight meshHandRailStraightNorth;
	HandRailStraight meshHandRailStraightWest;

	HandRailCornerStraight1 meshHandRailCornerStraight1SouthWest;
	HandRailCornerStraight1 meshHandRailCornerStraight1SouthEast = new HandRailCornerStraight1();
	HandRailCornerStraight1 meshHandRailCornerStraight1NorthWest;
	HandRailCornerStraight1 meshHandRailCornerStraight1NorthEast;

	HandRailCornerStraight2 meshHandRailCornerStraight2SouthWest;
	HandRailCornerStraight2 meshHandRailCornerStraight2SouthEast = new HandRailCornerStraight2();
	HandRailCornerStraight2 meshHandRailCornerStraight2NorthWest;
	HandRailCornerStraight2 meshHandRailCornerStraight2NorthEast;

	HandRailCornerCap1 meshHandRailCornerCap1SouthWest;
	HandRailCornerCap1 meshHandRailCornerCap1SouthEast = new HandRailCornerCap1();
	HandRailCornerCap1 meshHandRailCornerCap1NorthWest;
	HandRailCornerCap1 meshHandRailCornerCap1NorthEast;

	HandRailCornerCap2 meshHandRailCornerCap2SouthWest;
	HandRailCornerCap2 meshHandRailCornerCap2SouthEast = new HandRailCornerCap2();
	HandRailCornerCap2 meshHandRailCornerCap2NorthWest;
	HandRailCornerCap2 meshHandRailCornerCap2NorthEast;

	public ModelPlatform() {

		Matrix4f rotation = Matrix4f.rotate((float) Math.PI / 2, new Vector3f(0, 1, 0), new Matrix4f(), null);

		meshConnectedEast = (FloorConnectedSide) meshConnectedSouth.cloneTransformed(rotation);
		meshUnconnectedEast = (FloorUnconnectedSide) meshUnconnectedSouth.cloneTransformed(rotation);
		meshHandRailStraightEast = (HandRailStraight) meshHandRailStraightSouth.cloneTransformed(rotation);

		meshConnectedNorth = (FloorConnectedSide) meshConnectedEast.cloneTransformed(rotation);
		meshUnconnectedNorth = (FloorUnconnectedSide) meshUnconnectedEast.cloneTransformed(rotation);
		meshHandRailStraightNorth = (HandRailStraight) meshHandRailStraightEast.cloneTransformed(rotation);

		meshConnectedWest = (FloorConnectedSide) meshConnectedNorth.cloneTransformed(rotation);
		meshUnconnectedWest = (FloorUnconnectedSide) meshUnconnectedNorth.cloneTransformed(rotation);
		meshHandRailStraightWest = (HandRailStraight) meshHandRailStraightNorth.cloneTransformed(rotation);

		meshCornerOutsideNorthEast = (FloorCornerOutside) meshCornerOutsideSouthEast.cloneTransformed(rotation);
		meshCornerInsideNorthEast = (FloorCornerInside) meshCornerInsideSouthEast.cloneTransformed(rotation);
		meshCornerFullNorthEast = (FloorCornerFull) meshCornerFullSouthEast.cloneTransformed(rotation);
		meshCornerStraight1NorthEast = (FloorCornerStraight1) meshCornerStraight1SouthEast.cloneTransformed(rotation);
		meshCornerStraight2NorthEast = (FloorCornerStraight2) meshCornerStraight2SouthEast.cloneTransformed(rotation);
		meshHandRailCornerOutsideNorthEast = (HandRailCornerOutside) meshHandRailCornerOutsideSouthEast.cloneTransformed(rotation);
		meshHandRailCornerStraight1NorthEast = (HandRailCornerStraight1) meshHandRailCornerStraight1SouthEast.cloneTransformed(rotation);
		meshHandRailCornerStraight2NorthEast = (HandRailCornerStraight2) meshHandRailCornerStraight2SouthEast.cloneTransformed(rotation);
		meshHandRailCornerCap1NorthEast = (HandRailCornerCap1) meshHandRailCornerCap1SouthEast.cloneTransformed(rotation);
		meshHandRailCornerCap2NorthEast = (HandRailCornerCap2) meshHandRailCornerCap2SouthEast.cloneTransformed(rotation);
		meshHandRailCornerInsideNorthEast = (HandRailCornerInside) meshHandRailCornerInsideSouthEast.cloneTransformed(rotation);

		meshCornerOutsideNorthWest = (FloorCornerOutside) meshCornerOutsideNorthEast.cloneTransformed(rotation);
		meshCornerInsideNorthWest = (FloorCornerInside) meshCornerInsideNorthEast.cloneTransformed(rotation);
		meshCornerFullNorthWest = (FloorCornerFull) meshCornerFullNorthEast.cloneTransformed(rotation);
		meshCornerStraight1NorthWest = (FloorCornerStraight1) meshCornerStraight1NorthEast.cloneTransformed(rotation);
		meshCornerStraight2NorthWest = (FloorCornerStraight2) meshCornerStraight2NorthEast.cloneTransformed(rotation);
		meshHandRailCornerOutsideNorthWest = (HandRailCornerOutside) meshHandRailCornerOutsideNorthEast.cloneTransformed(rotation);
		meshHandRailCornerStraight1NorthWest = (HandRailCornerStraight1) meshHandRailCornerStraight1NorthEast.cloneTransformed(rotation);
		meshHandRailCornerStraight2NorthWest = (HandRailCornerStraight2) meshHandRailCornerStraight2NorthEast.cloneTransformed(rotation);
		meshHandRailCornerCap1NorthWest = (HandRailCornerCap1) meshHandRailCornerCap1NorthEast.cloneTransformed(rotation);
		meshHandRailCornerCap2NorthWest = (HandRailCornerCap2) meshHandRailCornerCap2NorthEast.cloneTransformed(rotation);
		meshHandRailCornerInsideNorthWest = (HandRailCornerInside) meshHandRailCornerInsideNorthEast.cloneTransformed(rotation);

		meshCornerOutsideSouthWest = (FloorCornerOutside) meshCornerOutsideNorthWest.cloneTransformed(rotation);
		meshCornerInsideSouthWest = (FloorCornerInside) meshCornerInsideNorthWest.cloneTransformed(rotation);
		meshCornerFullSouthWest = (FloorCornerFull) meshCornerFullNorthWest.cloneTransformed(rotation);
		meshCornerStraight1SouthWest = (FloorCornerStraight1) meshCornerStraight1NorthWest.cloneTransformed(rotation);
		meshCornerStraight2SouthWest = (FloorCornerStraight2) meshCornerStraight2NorthWest.cloneTransformed(rotation);
		meshHandRailCornerOutsideSouthWest = (HandRailCornerOutside) meshHandRailCornerOutsideNorthWest.cloneTransformed(rotation);
		meshHandRailCornerStraight1SouthWest = (HandRailCornerStraight1) meshHandRailCornerStraight1NorthWest.cloneTransformed(rotation);
		meshHandRailCornerStraight2SouthWest = (HandRailCornerStraight2) meshHandRailCornerStraight2NorthWest.cloneTransformed(rotation);
		meshHandRailCornerCap1SouthWest = (HandRailCornerCap1) meshHandRailCornerCap1NorthWest.cloneTransformed(rotation);
		meshHandRailCornerCap2SouthWest = (HandRailCornerCap2) meshHandRailCornerCap2NorthWest.cloneTransformed(rotation);
		meshHandRailCornerInsideSouthWest = (HandRailCornerInside) meshHandRailCornerInsideNorthWest.cloneTransformed(rotation);
	}

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

		Tessellator tessellator = Tessellator.instance;
		// tessellator.setColorOpaque(255, 255, 255);
		IIcon icon = block.getIcon(0, 0);
		Vector3f position = new Vector3f(0, 0, 0);
		meshCenter.renderMesh(icon);
		meshUnconnectedSouth.renderMesh(icon);
		meshUnconnectedEast.renderMesh(icon);
		meshUnconnectedNorth.renderMesh(icon);
		meshUnconnectedWest.renderMesh(icon);
		meshHandRailStraightEast.renderMesh(icon);
		meshHandRailStraightWest.renderMesh(icon);
		meshHandRailStraightNorth.renderMesh(icon);
		meshHandRailStraightSouth.renderMesh(icon);
		meshHandRailCornerOutsideNorthEast.renderMesh(icon);
		meshHandRailCornerOutsideNorthWest.renderMesh(icon);
		meshHandRailCornerOutsideSouthEast.renderMesh(icon);
		meshHandRailCornerOutsideSouthWest.renderMesh(icon);

		meshCornerOutsideNorthEast.renderMesh(icon);
		meshCornerOutsideNorthWest.renderMesh(icon);

		meshCornerOutsideSouthEast.renderMesh(icon);
		meshCornerOutsideSouthWest.renderMesh(icon);
	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

		ConnectionCompass compass = new ConnectionCompass();

		if (reference.block instanceof BlockPlatform)
			compass = ((BlockPlatform) reference.block).getConnections(reference.world, reference.x, reference.y, reference.z);

		Tessellator tessellator = Tessellator.instance;
		tessellator.setColorOpaque(255, 255, 255);
		IIcon icon = reference.getIcon(0); 
		meshCenter.renderMesh(false, icon, reference);

		renderConnection(icon, reference, compass.connectionS, meshConnectedSouth, meshUnconnectedSouth, meshHandRailStraightSouth);
		renderConnection(icon, reference, compass.connectionN, meshConnectedNorth, meshUnconnectedNorth, meshHandRailStraightNorth);
		renderConnection(icon, reference, compass.connectionE, meshConnectedEast, meshUnconnectedEast, meshHandRailStraightEast);
		renderConnection(icon, reference, compass.connectionW, meshConnectedWest, meshUnconnectedWest, meshHandRailStraightWest);

		renderCorner(icon, reference, compass.connectionW, compass.connectionSW, compass.connectionS, meshCornerOutsideSouthWest, meshCornerFullSouthWest, meshCornerInsideSouthWest, meshCornerStraight1SouthWest, meshCornerStraight2SouthWest, meshHandRailCornerOutsideSouthWest, meshHandRailCornerStraight1SouthWest, meshHandRailCornerStraight2SouthWest, meshHandRailCornerCap1SouthWest, meshHandRailCornerCap2SouthWest, meshHandRailCornerInsideSouthWest);

		renderCorner(icon, reference, compass.connectionS, compass.connectionSE, compass.connectionE, meshCornerOutsideSouthEast, meshCornerFullSouthEast, meshCornerInsideSouthEast, meshCornerStraight1SouthEast, meshCornerStraight2SouthEast, meshHandRailCornerOutsideSouthEast, meshHandRailCornerStraight1SouthEast, meshHandRailCornerStraight2SouthEast, meshHandRailCornerCap1SouthEast, meshHandRailCornerCap2SouthEast, meshHandRailCornerInsideSouthEast);

		renderCorner(icon, reference, compass.connectionE, compass.connectionNE, compass.connectionN, meshCornerOutsideNorthEast, meshCornerFullNorthEast, meshCornerInsideNorthEast, meshCornerStraight1NorthEast, meshCornerStraight2NorthEast, meshHandRailCornerOutsideNorthEast, meshHandRailCornerStraight1NorthEast, meshHandRailCornerStraight2NorthEast, meshHandRailCornerCap1NorthEast, meshHandRailCornerCap2NorthEast, meshHandRailCornerInsideNorthEast);

		renderCorner(icon, reference, compass.connectionN, compass.connectionNW, compass.connectionW, meshCornerOutsideNorthWest, meshCornerFullNorthWest, meshCornerInsideNorthWest, meshCornerStraight1NorthWest, meshCornerStraight2NorthWest, meshHandRailCornerOutsideNorthWest, meshHandRailCornerStraight1NorthWest, meshHandRailCornerStraight2NorthWest, meshHandRailCornerCap1NorthWest, meshHandRailCornerCap2NorthWest, meshHandRailCornerInsideNorthWest);

		return true;
	}

	private void renderCorner(IIcon icon, WorldReference position, TileConnection connectionE, TileConnection connectionSE, TileConnection connectionS, ObjMesh meshCornerOutside, ObjMesh meshCornerFull, ObjMesh meshCornerInside, ObjMesh straight1, ObjMesh straight2, ObjMesh meshHandRailOutside, ObjMesh meshHandRailStraight1, ObjMesh meshHandRailStraight2, ObjMesh meshHandRailCap1, ObjMesh meshHandRailCap2, ObjMesh meshHandRailCornerInside) {

		boolean airStateE = connectionE == TileConnection.AIR || connectionE == TileConnection.STAIRSTOP || connectionE == TileConnection.STAIRSSIDE;
		boolean airStateSE = connectionSE == TileConnection.AIR || connectionSE == TileConnection.STAIRSTOP || connectionSE == TileConnection.STAIRSSIDE;
		boolean airStateS = connectionS == TileConnection.AIR || connectionS == TileConnection.STAIRSTOP || connectionS == TileConnection.STAIRSSIDE;

		boolean stateE = (airStateE || connectionE == TileConnection.GROUND || connectionE == TileConnection.MACHINE);
		boolean stateSE = (airStateSE || connectionSE == TileConnection.GROUND || connectionSE == TileConnection.MACHINE);
		boolean stateS = (airStateS || connectionS == TileConnection.GROUND || connectionS == TileConnection.MACHINE);

		boolean wallE = connectionE == TileConnection.WALL;
		boolean wallS = connectionS == TileConnection.WALL;
		boolean wallSE = connectionSE == TileConnection.WALL;

		boolean groundSE = connectionSE == TileConnection.GROUND || connectionSE == TileConnection.MACHINE;
		boolean stairsE = connectionE == TileConnection.STAIRS;
		boolean stairsS = connectionS == TileConnection.STAIRS;
		boolean stairsSE = connectionSE == TileConnection.STAIRS;

		boolean stairsSideE = connectionE == TileConnection.STAIRSSIDE;
		boolean stairsSideS = connectionS == TileConnection.STAIRSSIDE;

		boolean stairTopE = connectionE == TileConnection.STAIRSTOP;
		boolean stairTopS = connectionS == TileConnection.STAIRSTOP;

		boolean connectedSE = connectionSE == TileConnection.CONNECTED;
		boolean connectedS = connectionS == TileConnection.CONNECTED;
		boolean connectedE = connectionE == TileConnection.CONNECTED;

		boolean connectedStairsS = connectionS == TileConnection.CONNECTEDSTAIRS;
		boolean connectedStairsE = connectionE == TileConnection.CONNECTEDSTAIRS;
		boolean connectedStairsSE = connectionSE == TileConnection.CONNECTEDSTAIRS;

		boolean floorStateE = stateE || stairsE;
		boolean floorStateS = stateS || stairsS;
		boolean floorStateSE = stateSE || stairsSE;

		if (floorStateE && floorStateS) {
			meshCornerOutside.renderMesh(false, icon, position);
		} else if (floorStateE && !floorStateS) {
			straight2.renderMesh(false, icon, position);
		} else if (floorStateS && !floorStateE) {
			straight1.renderMesh(false, icon, position);
		} else { // !S, !E
			if (floorStateSE) {
				meshCornerInside.renderMesh(false, icon, position);
			} else {
				if (connectedStairsSE ^ (connectedStairsE ^ connectedStairsS)) {
					meshCornerInside.renderMesh(false, icon, position);
				} else {
					meshCornerFull.renderMesh(false, icon, position);
				}
			}
		}

		boolean railStateE = stateE && connectionE != TileConnection.GROUND && connectionE != TileConnection.MACHINE;
		boolean railStateS = stateS && connectionS != TileConnection.GROUND && connectionS != TileConnection.MACHINE;
		boolean railStateSE = stateSE && connectionSE != TileConnection.GROUND && connectionSE != TileConnection.MACHINE;

		if (railStateE && railStateS) {
			meshHandRailOutside.renderMesh(false, icon, position);
		} else if (railStateE && !railStateS) {
			if (!wallS && !connectedStairsS && !stairsS && !stairsSE && !connectedStairsSE) {
				if (!railStateSE && !connectedSE) {
					meshHandRailCap2.renderMesh(false, icon, position);
				} else if (railStateE && !connectedS) {
					meshHandRailCap2.renderMesh(false, icon, position);
				} else
					meshHandRailStraight2.renderMesh(false, icon, position);
			} else {
				meshHandRailStraight2.renderMesh(false, icon, position);
			}
		} else if (railStateS && !railStateE) {
			if (!wallE && !connectedStairsE && !stairsE && !stairsSE && !connectedStairsSE) {
				if (!railStateSE && !connectedSE) {
					meshHandRailCap1.renderMesh(false, icon, position);
				} else if (railStateS && !connectedE) {
					meshHandRailCap1.renderMesh(false, icon, position);
				} else {
					meshHandRailStraight1.renderMesh(false, icon, position);
				}
			} else {
				meshHandRailStraight1.renderMesh(false, icon, position);
			}
		} else { // !S, !E
			if (!connectedStairsSE) {
				if (!stairsSE) {
					if ((stairsE && stairsS) || (connectedStairsS && connectedStairsE)) {
						meshHandRailCornerInside.renderMesh(false, icon, position);
					} else if ((railStateSE || connectedSE) && ((connectedS && connectedStairsE) || (connectedE && connectedStairsS))) {
						meshHandRailCornerInside.renderMesh(false, icon, position);
					} else if ((railStateSE || connectedSE) && ((connectedS && stairsE) || (connectedE && stairsS))) {
						meshHandRailCornerInside.renderMesh(false, icon, position);
					}
				} else if (!(stairsS || stairsE) && (connectedE && connectedS)) {
					meshHandRailCornerInside.renderMesh(false, icon, position);
				}
			} else if (!(connectedStairsS || connectedStairsE) && (connectedE && connectedS)) {
				meshHandRailCornerInside.renderMesh(false, icon, position);
			}
			if (railStateSE && connectedE && connectedS) {
				meshHandRailCornerInside.renderMesh(false, icon, position);
			}
		}

	}

	private void renderConnection(IIcon icon, WorldReference position, TileConnection connection, ObjMesh meshConnected, ObjMesh meshUnconnected, ObjMesh handrail) {

		if (connection == TileConnection.AIR || connection == TileConnection.GROUND || connection == TileConnection.MACHINE || connection == TileConnection.STAIRSTOP || connection == TileConnection.STAIRS || connection == TileConnection.STAIRSSIDE) {
			meshUnconnected.renderMesh(false, icon, position);
		} else
			meshConnected.renderMesh(false, icon, position);

		if (connection == TileConnection.AIR || connection == TileConnection.STAIRSTOP || connection == TileConnection.STAIRSSIDE)
			handrail.renderMesh(false, icon, position);

	}
}
