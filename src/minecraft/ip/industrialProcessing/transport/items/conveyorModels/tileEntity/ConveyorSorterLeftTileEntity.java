package ip.industrialProcessing.transport.items.conveyorModels.tileEntity;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class ConveyorSorterLeftTileEntity extends ObjMesh{
	public ConveyorSorterLeftTileEntity(){
		this.quads = new ObjQuad[22];
		this.quads[0] = new ObjQuad(new Vector3f(0.3005f, 0.9f, -0.8f),new Vector3f(0.2005f, 0.95f, -0.8f),new Vector3f(0.1798f, 0.95f, -0.6051f),new Vector3f(0.2784f, 0.9f, -0.5855f),new Vector2f(0.4375f, 0.0f),new Vector2f(0.375f, 0.0f),new Vector2f(0.375f, 0.125f),new Vector2f(0.4375f, 0.125f),new Vector3f(1.7664f, 3.5777001f, 0.2692f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.6828f, 0.95f, -0.2106f),new Vector3f(-0.6807f, 0.95f, -0.2f),new Vector3f(-0.5515f, 0.95f, -0.2f),new Vector3f(-0.57f, 0.95f, -0.2448f),new Vector2f(0.125f, 0.875f),new Vector2f(0.1318f, 0.875f),new Vector2f(0.1554f, 0.75f),new Vector2f(0.125f, 0.75f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.7024f, 0.9f, -0.3091f),new Vector3f(-0.6828f, 0.95f, -0.2106f),new Vector3f(-0.57f, 0.95f, -0.2448f),new Vector3f(-0.6085f, 0.9f, -0.3376f),new Vector2f(0.0625f, 0.875f),new Vector2f(0.125f, 0.875f),new Vector2f(0.125f, 0.75f),new Vector2f(0.0625f, 0.75f),new Vector3f(-0.5148f, 3.5812f, -1.6969999f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.57f, 0.95f, -0.2448f),new Vector3f(-0.5515f, 0.95f, -0.2f),new Vector3f(-0.3991f, 0.95f, -0.2f),new Vector3f(-0.4661f, 0.95f, -0.3003f),new Vector2f(0.125f, 0.75f),new Vector2f(0.1554f, 0.75f),new Vector2f(0.2008f, 0.625f),new Vector2f(0.125f, 0.625f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.6085f, 0.9f, -0.3376f),new Vector3f(-0.57f, 0.95f, -0.2448f),new Vector3f(-0.4661f, 0.95f, -0.3003f),new Vector3f(-0.5219f, 0.9f, -0.3839f),new Vector2f(0.0625f, 0.75f),new Vector2f(0.125f, 0.75f),new Vector2f(0.125f, 0.625f),new Vector2f(0.0625f, 0.625f),new Vector3f(-0.836f, 3.5812f, -1.5639999f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.4661f, 0.95f, -0.3003f),new Vector3f(-0.3991f, 0.95f, -0.2f),new Vector3f(-0.2f, 0.95f, -0.2f),new Vector3f(-0.3751f, 0.95f, -0.3751f),new Vector2f(0.125f, 0.625f),new Vector2f(0.2008f, 0.625f),new Vector2f(0.2805f, 0.5f),new Vector2f(0.125f, 0.5f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.5219f, 0.9f, -0.3839f),new Vector3f(-0.4661f, 0.95f, -0.3003f),new Vector3f(-0.3751f, 0.95f, -0.3751f),new Vector3f(-0.4461f, 0.9f, -0.4461f),new Vector2f(0.0625f, 0.625f),new Vector2f(0.125f, 0.625f),new Vector2f(0.125f, 0.5f),new Vector2f(0.0625f, 0.5f),new Vector3f(-1.125f, 3.5812f, -1.3708f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.3003f, 0.95f, -0.4661f),new Vector3f(-0.2f, 0.95f, -0.2f),new Vector3f(-0.0062f, 0.95f, -0.2f),new Vector3f(0.0307f, 0.95f, -0.245f),new Vector2f(0.125f, 0.375f),new Vector2f(0.2805f, 0.5f),new Vector2f(0.375f, 0.4121f),new Vector2f(0.375f, 0.375f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.2f, 0.95f, -0.2f),new Vector3f(-0.3003f, 0.95f, -0.4661f),new Vector3f(-0.3751f, 0.95f, -0.3751f),new Vector2f(0.2805f, 0.5f),new Vector2f(0.125f, 0.375f),new Vector2f(0.125f, 0.5f),new Vector3f(0.0f, 3.0f, 0.0f));
		this.quads[9] = new ObjQuad(new Vector3f(-0.4461f, 0.9f, -0.4461f),new Vector3f(-0.3751f, 0.95f, -0.3751f),new Vector3f(-0.3003f, 0.95f, -0.4661f),new Vector3f(-0.3839f, 0.9f, -0.5219f),new Vector2f(0.0625f, 0.5f),new Vector2f(0.125f, 0.5f),new Vector2f(0.125f, 0.375f),new Vector2f(0.0625f, 0.375f),new Vector3f(-1.3708f, 3.5812f, -1.125f));
		this.quads[10] = new ObjQuad(new Vector3f(-0.3003f, 0.95f, -0.4661f),new Vector3f(0.0307f, 0.95f, -0.245f),new Vector3f(0.123f, 0.95f, -0.4177f),new Vector3f(-0.2448f, 0.95f, -0.57f),new Vector2f(0.125f, 0.375f),new Vector2f(0.375f, 0.375f),new Vector2f(0.375f, 0.25f),new Vector2f(0.125f, 0.25f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.3839f, 0.9f, -0.5219f),new Vector3f(-0.3003f, 0.95f, -0.4661f),new Vector3f(-0.2448f, 0.95f, -0.57f),new Vector3f(-0.3376f, 0.9f, -0.6085f),new Vector2f(0.0625f, 0.375f),new Vector2f(0.125f, 0.375f),new Vector2f(0.125f, 0.25f),new Vector2f(0.0625f, 0.25f),new Vector3f(-1.564f, 3.5812f, -0.83599997f));
		this.quads[12] = new ObjQuad(new Vector3f(0.123f, 0.95f, -0.4177f),new Vector3f(0.0307f, 0.95f, -0.245f),new Vector3f(0.0548f, 0.9356f, -0.2289f),new Vector3f(0.1735f, 0.9f, -0.3f),new Vector2f(0.375f, 0.25f),new Vector2f(0.375f, 0.375f),new Vector2f(0.393f, 0.375f),new Vector2f(0.4375f, 0.3021f),new Vector3f(1.5553f, 3.5802002f, 0.86349994f));
		this.quads[13] = new ObjQuad(new Vector3f(0.123f, 0.95f, -0.4177f),new Vector3f(0.1735f, 0.9f, -0.3f),new Vector3f(0.2158f, 0.9f, -0.3792f),new Vector2f(0.375f, 0.25f),new Vector2f(0.4375f, 0.3021f),new Vector2f(0.4375f, 0.25f),new Vector3f(1.2176f, 2.685f, 0.5518f));
		this.quads[14] = new ObjQuad(new Vector3f(-0.2448f, 0.95f, -0.57f),new Vector3f(0.123f, 0.95f, -0.4177f),new Vector3f(0.1798f, 0.95f, -0.6051f),new Vector3f(-0.2106f, 0.95f, -0.6828f),new Vector2f(0.125f, 0.25f),new Vector2f(0.375f, 0.25f),new Vector2f(0.375f, 0.125f),new Vector2f(0.125f, 0.125f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(-0.3376f, 0.9f, -0.6085f),new Vector3f(-0.2448f, 0.95f, -0.57f),new Vector3f(-0.2106f, 0.95f, -0.6828f),new Vector3f(-0.3091f, 0.9f, -0.7024f),new Vector2f(0.0625f, 0.25f),new Vector2f(0.125f, 0.25f),new Vector2f(0.125f, 0.125f),new Vector2f(0.0625f, 0.125f),new Vector3f(-1.6975f, 3.5809999f, -0.5144f));
		this.quads[16] = new ObjQuad(new Vector3f(0.2784f, 0.9f, -0.5855f),new Vector3f(0.1798f, 0.95f, -0.6051f),new Vector3f(0.123f, 0.95f, -0.4177f),new Vector3f(0.2158f, 0.9f, -0.3792f),new Vector2f(0.4375f, 0.125f),new Vector2f(0.375f, 0.125f),new Vector2f(0.375f, 0.25f),new Vector2f(0.4375f, 0.25f),new Vector3f(1.6968f, 3.5809999f, 0.5179f));
		this.quads[17] = new ObjQuad(new Vector3f(-0.2106f, 0.95f, -0.6828f),new Vector3f(0.1798f, 0.95f, -0.6051f),new Vector3f(0.2005f, 0.95f, -0.8f),new Vector3f(-0.1995f, 0.95f, -0.8f),new Vector2f(0.125f, 0.125f),new Vector2f(0.375f, 0.125f),new Vector2f(0.375f, 0.0f),new Vector2f(0.125f, 0.0f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[18] = new ObjQuad(new Vector3f(-0.3091f, 0.9f, -0.7024f),new Vector3f(-0.2106f, 0.95f, -0.6828f),new Vector3f(-0.1995f, 0.95f, -0.8f),new Vector3f(-0.2995f, 0.9f, -0.8f),new Vector2f(0.0625f, 0.125f),new Vector2f(0.125f, 0.125f),new Vector2f(0.125f, 0.0f),new Vector2f(0.0625f, 0.0f),new Vector3f(-1.7671f, 3.578f, -0.2586f));
		this.quads[19] = new ObjQuad(new Vector3f(-0.6807f, 0.95f, -0.2f),new Vector3f(-0.6828f, 0.95f, -0.2106f),new Vector3f(-0.7902f, 0.95f, -0.2f),new Vector2f(0.1318f, 0.875f),new Vector2f(0.125f, 0.875f),new Vector2f(0.125f, 0.9895f),new Vector3f(0.0f, 3.0f, 0.0f));
		this.quads[20] = new ObjQuad(new Vector3f(-0.7951f, 0.9f, -0.3f),new Vector3f(-0.7902f, 0.95f, -0.2f),new Vector3f(-0.6828f, 0.95f, -0.2106f),new Vector3f(-0.7024f, 0.9f, -0.3091f),new Vector2f(0.0625f, 0.9937f),new Vector2f(0.125f, 0.9895f),new Vector2f(0.125f, 0.875f),new Vector2f(0.0625f, 0.875f),new Vector3f(-0.2614f, 3.5793998f, -1.764f));
		this.quads[21] = new ObjQuad(new Vector3f(0.0548f, 0.9356f, -0.2289f),new Vector3f(0.0307f, 0.95f, -0.245f),new Vector3f(-0.0062f, 0.95f, -0.2f),new Vector2f(0.393f, 0.375f),new Vector2f(0.375f, 0.375f),new Vector2f(0.375f, 0.4121f),new Vector3f(1.095f, 2.6848998f, 0.7659f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		ConveyorSorterLeftTileEntity other = new ConveyorSorterLeftTileEntity();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}
