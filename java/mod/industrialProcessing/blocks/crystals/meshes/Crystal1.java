package mod.industrialProcessing.blocks.crystals.meshes;

import mod.industrialProcessing.client.rendering.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class Crystal1 extends ObjMesh {

	public Crystal1() {
		this.quads = new ObjQuad[6];
		this.quads[0] = new ObjQuad(new Vector3f(-0.138762f, 0.783996f, 0.079622f), new Vector3f(0.060367f, 0.795076f, 0.064632f), new Vector3f(-0.052295f, 0.885445f, -0.030974f), new Vector3f(-0.153336f, 0.776272f, -0.119697f), new Vector2f(0.875f, 0.5f), new Vector2f(1.0f, 0.5f), new Vector2f(0.9375f, 0.5625f), new Vector2f(0.875f, 0.625f), new Vector3f(-0.577157f, 3.434764f, 0.31873798f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.092278f, -0.014178f, 0.107154f), new Vector3f(0.106852f, -0.003098f, 0.092165f), new Vector3f(0.060367f, 0.795076f, 0.064632f), new Vector3f(-0.138762f, 0.783996f, 0.079622f), new Vector2f(0.5f, 0.5f), new Vector2f(0.625f, 0.5f), new Vector2f(0.625f, 1.0f), new Vector2f(0.5f, 1.0f), new Vector3f(0.291476f, 0.154484f, 3.986376f));
		this.quads[2] = new ObjQuad(new Vector3f(0.106852f, -0.003098f, 0.092165f), new Vector3f(0.092278f, -0.010822f, -0.107154f), new Vector3f(0.045794f, 0.787352f, -0.134686f), new Vector3f(0.060367f, 0.795076f, 0.064632f), new Vector2f(0.875f, 0.5f), new Vector2f(1.0f, 0.5f), new Vector2f(1.0f, 1.0f), new Vector2f(0.875f, 1.0f), new Vector3f(3.982592f, 0.2216f, -0.299784f));
		this.quads[3] = new ObjQuad(new Vector3f(0.092278f, -0.010822f, -0.107154f), new Vector3f(-0.106852f, -0.021902f, -0.092165f), new Vector3f(-0.153336f, 0.776272f, -0.119697f), new Vector3f(0.045794f, 0.787352f, -0.134686f), new Vector2f(0.75f, 0.5f), new Vector2f(0.875f, 0.5f), new Vector2f(0.875f, 1.0f), new Vector2f(0.75f, 1.0f), new Vector3f(-0.291476f, -0.154484f, -3.986376f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.106852f, -0.021902f, -0.092165f), new Vector3f(-0.092278f, -0.014178f, 0.107154f), new Vector3f(-0.138762f, 0.783996f, 0.079622f), new Vector3f(-0.153336f, 0.776272f, -0.119697f), new Vector2f(0.625f, 0.5f), new Vector2f(0.75f, 0.5f), new Vector2f(0.75f, 1.0f), new Vector2f(0.625f, 1.0f), new Vector3f(-3.982592f, -0.2216f, 0.299784f));
		this.quads[5] = new ObjQuad(new Vector3f(0.045794f, 0.787352f, -0.134686f), new Vector3f(-0.153336f, 0.776272f, -0.119697f), new Vector3f(-0.052295f, 0.885445f, -0.030974f), new Vector3f(0.060367f, 0.795076f, 0.064632f), new Vector2f(1.0f, 0.625f), new Vector2f(0.875f, 0.625f), new Vector2f(0.9375f, 0.5625f), new Vector2f(1.0f, 0.5f), new Vector3f(0.17628899f, 3.4484649f, -0.55617106f));
	}

	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Crystal1 other = new Crystal1();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}

}
