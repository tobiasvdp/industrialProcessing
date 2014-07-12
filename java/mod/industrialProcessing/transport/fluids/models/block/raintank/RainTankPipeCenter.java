package mod.industrialProcessing.transport.fluids.models.block.raintank;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class RainTankPipeCenter extends ObjMesh{
	public RainTankPipeCenter(){
		this.quads = new ObjQuad[9];
		this.quads[0] = new ObjQuad(new Vector3f(-0.2f, 0.6f, -0.2f),new Vector3f(-0.2f, 1.0f, -0.2f),new Vector3f(0.2f, 1.0f, -0.2f),new Vector3f(0.2f, 0.6f, -0.2f),new Vector2f(1.000256f, 0.374979f),new Vector2f(1.000256f, 0.624978f),new Vector2f(0.750256f, 0.624978f),new Vector2f(0.750256f, 0.374978f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.2f, 0.6f, 0.2f),new Vector3f(0.2f, 0.6f, 0.2f),new Vector3f(0.2f, 1.0f, 0.2f),new Vector3f(-0.2f, 1.0f, 0.2f),new Vector2f(0.750256f, 0.374979f),new Vector2f(1.000256f, 0.374978f),new Vector2f(1.000256f, 0.624978f),new Vector2f(0.750256f, 0.624978f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.2f, 0.6f, -0.2f),new Vector3f(0.2f, 0.6f, -0.2f),new Vector3f(0.2f, 0.6f, 0.2f),new Vector3f(-0.2f, 0.6f, 0.2f),new Vector2f(0.750256f, 0.374978f),new Vector2f(1.000256f, 0.374978f),new Vector2f(1.000256f, 0.624978f),new Vector2f(0.750256f, 0.624978f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.2f, 0.6f, -0.2f),new Vector3f(0.2f, 1.0f, -0.2f),new Vector3f(0.2f, 1.0f, 0.2f),new Vector3f(0.2f, 0.6f, 0.2f),new Vector2f(0.750256f, 0.374978f),new Vector2f(1.000256f, 0.374978f),new Vector2f(1.000256f, 0.624978f),new Vector2f(0.750256f, 0.624978f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.2f, 1.0f, -0.2f),new Vector3f(-0.2f, 0.6f, -0.2f),new Vector3f(-0.2f, 0.6f, 0.2f),new Vector3f(-0.2f, 1.0f, 0.2f),new Vector2f(0.750256f, 0.374978f),new Vector2f(1.000256f, 0.374978f),new Vector2f(1.000256f, 0.624978f),new Vector2f(0.750256f, 0.624978f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(0.2f, 1.0f, -0.2f),new Vector3f(-0.2f, 1.0f, -0.2f),new Vector3f(-0.2f, 1.1f, -0.2f),new Vector3f(0.2f, 1.1f, -0.2f),new Vector2f(0.750256f, 0.624978f),new Vector2f(1.000256f, 0.624978f),new Vector2f(1.000256f, 0.687478f),new Vector2f(0.750256f, 0.687478f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.2f, 1.0f, -0.2f),new Vector3f(-0.2f, 1.0f, 0.2f),new Vector3f(-0.2f, 1.1f, 0.2f),new Vector3f(-0.2f, 1.1f, -0.2f),new Vector2f(1.000256f, 0.374978f),new Vector2f(0.750256f, 0.374978f),new Vector2f(0.750256f, 0.312478f),new Vector2f(1.000256f, 0.312478f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.2f, 1.0f, 0.2f),new Vector3f(0.2f, 1.0f, 0.2f),new Vector3f(0.2f, 1.1f, 0.2f),new Vector3f(-0.2f, 1.1f, 0.2f),new Vector2f(0.750256f, 0.624978f),new Vector2f(1.000256f, 0.624978f),new Vector2f(1.000256f, 0.687478f),new Vector2f(0.750256f, 0.687478f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[8] = new ObjQuad(new Vector3f(0.2f, 1.0f, 0.2f),new Vector3f(0.2f, 1.0f, -0.2f),new Vector3f(0.2f, 1.1f, -0.2f),new Vector3f(0.2f, 1.1f, 0.2f),new Vector2f(0.750256f, 0.624978f),new Vector2f(1.000256f, 0.624978f),new Vector2f(1.000256f, 0.687478f),new Vector2f(0.750256f, 0.687478f),new Vector3f(4.0f, 0.0f, 0.0f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		RainTankPipeCenter other = new RainTankPipeCenter();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}
