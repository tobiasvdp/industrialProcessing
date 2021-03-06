package ip.industrialProcessing.subMod.logic.network.devices.readout.displayPanel.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Hull extends ObjMesh{
	public Hull(){
		this.quads = new ObjQuad[20];
		this.quads[0] = new ObjQuad(new Vector3f(-0.6f, 0.4f, -0.5f),new Vector3f(-0.6f, 0.4f, -0.8f),new Vector3f(0.6f, 0.4f, -0.8f),new Vector3f(0.6f, 0.4f, -0.5f),new Vector2f(0.875f, 0.8125f),new Vector2f(0.875f, 1.0f),new Vector2f(0.125f, 1.0f),new Vector2f(0.125f, 0.8125f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.6f, 1.2f, -0.5f),new Vector3f(0.6f, 1.2f, -0.5f),new Vector3f(0.6f, 1.2f, -0.8f),new Vector3f(-0.6f, 1.2f, -0.8f),new Vector2f(0.125f, 0.8125f),new Vector2f(0.875f, 0.8125f),new Vector2f(0.875f, 1.0f),new Vector2f(0.125f, 1.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(0.6f, 0.4f, -0.5f),new Vector3f(0.6f, 0.4f, -0.8f),new Vector3f(0.6f, 1.2f, -0.8f),new Vector3f(0.6f, 1.2f, -0.5f),new Vector2f(0.8125f, 0.25f),new Vector2f(1.0f, 0.25f),new Vector2f(1.0f, 0.75f),new Vector2f(0.8125f, 0.75f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.6f, 0.4f, -0.8f),new Vector3f(-0.6f, 0.4f, -0.5f),new Vector3f(-0.6f, 1.2f, -0.5f),new Vector3f(-0.6f, 1.2f, -0.8f),new Vector2f(-0.0f, 0.25f),new Vector2f(0.1875f, 0.25f),new Vector2f(0.1875f, 0.75f),new Vector2f(-0.0f, 0.75f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.5354f, 0.4646f, -0.4f),new Vector3f(0.5354f, 0.4646f, -0.4f),new Vector3f(0.5354f, 0.4646f, -0.4f),new Vector3f(-0.5354f, 0.4646f, -0.4f),new Vector2f(0.75f, 0.2904f),new Vector2f(0.75f, 0.2904f),new Vector2f(0.75f, 0.2904f),new Vector2f(0.75f, 0.2904f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.5354f, 0.4646f, -0.4f),new Vector3f(0.5354f, 1.1354f, -0.4f),new Vector3f(0.5354f, 1.1354f, -0.4f),new Vector3f(0.5354f, 0.4646f, -0.4f),new Vector2f(0.75f, 0.2904f),new Vector2f(0.75f, 0.7096f),new Vector2f(0.75f, 0.7096f),new Vector2f(0.75f, 0.2904f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(0.5354f, 1.1354f, -0.4f),new Vector3f(-0.5354f, 1.1354f, -0.4f),new Vector3f(-0.5354f, 1.1354f, -0.4f),new Vector3f(0.5354f, 1.1354f, -0.4f),new Vector2f(0.75f, 0.7096f),new Vector2f(0.75f, 0.7096f),new Vector2f(0.75f, 0.7096f),new Vector2f(0.75f, 0.7096f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.5354f, 1.1354f, -0.4f),new Vector3f(-0.5354f, 0.4646f, -0.4f),new Vector3f(-0.5354f, 0.4646f, -0.4f),new Vector3f(-0.5354f, 1.1354f, -0.4f),new Vector2f(0.75f, 0.7096f),new Vector2f(0.75f, 0.2904f),new Vector2f(0.75f, 0.2904f),new Vector2f(0.75f, 0.7096f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.5f, 0.5f, -0.45f),new Vector3f(0.5f, 0.5f, -0.45f),new Vector3f(0.5f, 0.5f, -0.5f),new Vector3f(-0.5f, 0.5f, -0.5f),new Vector2f(0.1875f, 0.7813f),new Vector2f(0.8125f, 0.7812f),new Vector2f(0.8125f, 0.8125f),new Vector2f(0.1875f, 0.8125f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(0.5f, 0.5f, -0.45f),new Vector3f(0.5f, 1.1f, -0.45f),new Vector3f(0.5f, 1.1f, -0.5f),new Vector3f(0.5f, 0.5f, -0.5f),new Vector2f(0.2188f, 0.3125f),new Vector2f(0.2188f, 0.6875f),new Vector2f(0.1875f, 0.6875f),new Vector2f(0.1875f, 0.3125f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[10] = new ObjQuad(new Vector3f(0.5f, 1.1f, -0.45f),new Vector3f(-0.5f, 1.1f, -0.45f),new Vector3f(-0.5f, 1.1f, -0.5f),new Vector3f(0.5f, 1.1f, -0.5f),new Vector2f(0.1875f, 0.7812f),new Vector2f(0.8125f, 0.7813f),new Vector2f(0.8125f, 0.8125f),new Vector2f(0.1875f, 0.8125f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.5f, 1.1f, -0.45f),new Vector3f(-0.5f, 0.5f, -0.45f),new Vector3f(-0.5f, 0.5f, -0.5f),new Vector3f(-0.5f, 1.1f, -0.5f),new Vector2f(0.7813f, 0.6875f),new Vector2f(0.7813f, 0.3125f),new Vector2f(0.8125f, 0.3125f),new Vector2f(0.8125f, 0.6875f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[12] = new ObjQuad(new Vector3f(-0.5f, 0.5f, -0.45f),new Vector3f(-0.5354f, 0.4646f, -0.4f),new Vector3f(0.5354f, 0.4646f, -0.4f),new Vector3f(0.5f, 0.5f, -0.45f),new Vector2f(0.1875f, 0.7813f),new Vector2f(0.1654f, 0.75f),new Vector2f(0.8346f, 0.75f),new Vector2f(0.8125f, 0.7812f),new Vector3f(0.0f, 3.266f, 2.3096f));
		this.quads[13] = new ObjQuad(new Vector3f(0.5f, 0.5f, -0.45f),new Vector3f(0.5354f, 0.4646f, -0.4f),new Vector3f(0.5354f, 1.1354f, -0.4f),new Vector3f(0.5f, 1.1f, -0.45f),new Vector2f(0.2188f, 0.3125f),new Vector2f(0.25f, 0.2904f),new Vector2f(0.25f, 0.7096f),new Vector2f(0.2188f, 0.6875f),new Vector3f(-3.266f, 0.0f, 2.3096f));
		this.quads[14] = new ObjQuad(new Vector3f(0.5f, 1.1f, -0.45f),new Vector3f(0.5354f, 1.1354f, -0.4f),new Vector3f(-0.5354f, 1.1354f, -0.4f),new Vector3f(-0.5f, 1.1f, -0.45f),new Vector2f(0.1875f, 0.7812f),new Vector2f(0.1654f, 0.75f),new Vector2f(0.8346f, 0.75f),new Vector2f(0.8125f, 0.7813f),new Vector3f(0.0f, -3.266f, 2.3096f));
		this.quads[15] = new ObjQuad(new Vector3f(-0.5f, 1.1f, -0.45f),new Vector3f(-0.5354f, 1.1354f, -0.4f),new Vector3f(-0.5354f, 0.4646f, -0.4f),new Vector3f(-0.5f, 0.5f, -0.45f),new Vector2f(0.7813f, 0.6875f),new Vector2f(0.75f, 0.7096f),new Vector2f(0.75f, 0.2904f),new Vector2f(0.7813f, 0.3125f),new Vector3f(3.266f, 0.0f, 2.3096f));
		this.quads[16] = new ObjQuad(new Vector3f(-0.5354f, 0.4646f, -0.4f),new Vector3f(-0.6f, 0.4f, -0.5f),new Vector3f(0.6f, 0.4f, -0.5f),new Vector3f(0.5354f, 0.4646f, -0.4f),new Vector2f(0.8346f, 0.75f),new Vector2f(0.875f, 0.8125f),new Vector2f(0.125f, 0.8125f),new Vector2f(0.1654f, 0.75f),new Vector3f(0.0f, -3.3592f, 2.1716f));
		this.quads[17] = new ObjQuad(new Vector3f(0.5354f, 1.1354f, -0.4f),new Vector3f(0.6f, 1.2f, -0.5f),new Vector3f(-0.6f, 1.2f, -0.5f),new Vector3f(-0.5354f, 1.1354f, -0.4f),new Vector2f(0.8346f, 0.75f),new Vector2f(0.875f, 0.8125f),new Vector2f(0.125f, 0.8125f),new Vector2f(0.1654f, 0.75f),new Vector3f(0.0f, 3.3592f, 2.1716f));
		this.quads[18] = new ObjQuad(new Vector3f(0.5354f, 0.4646f, -0.4f),new Vector3f(0.6f, 0.4f, -0.5f),new Vector3f(0.6f, 1.2f, -0.5f),new Vector3f(0.5354f, 1.1354f, -0.4f),new Vector2f(0.75f, 0.2904f),new Vector2f(0.8125f, 0.25f),new Vector2f(0.8125f, 0.75f),new Vector2f(0.75f, 0.7096f),new Vector3f(3.3592f, 0.0f, 2.1716f));
		this.quads[19] = new ObjQuad(new Vector3f(-0.5354f, 1.1354f, -0.4f),new Vector3f(-0.6f, 1.2f, -0.5f),new Vector3f(-0.6f, 0.4f, -0.5f),new Vector3f(-0.5354f, 0.4646f, -0.4f),new Vector2f(0.25f, 0.7096f),new Vector2f(0.1875f, 0.75f),new Vector2f(0.1875f, 0.25f),new Vector2f(0.25f, 0.2904f),new Vector3f(-3.3592f, 0.0f, 2.1716f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Hull other = new Hull();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}
