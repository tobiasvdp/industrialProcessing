package  mod.industrialProcessing.plants.industrialAge.windMill.model;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class Box015 extends ObjMesh{
	public Box015(){
		this.quads = new ObjQuad[16];
		this.quads[0] = new ObjQuad(new Vector3f(0.5353f, 0.7651f, -0.4951f),new Vector3f(0.4813f, 0.7116f, -0.5215f),new Vector3f(-0.5353f, 1.2349f, 0.4951f),new Vector3f(-0.4813f, 1.2884f, 0.5215f),new Vector2f(1.0278f, 0.4845f),new Vector2f(1.0278f, 0.54f),new Vector2f(-0.0278f, 0.54f),new Vector2f(-0.0278f, 0.4845f),new Vector3f(-1.316f, 2.658f, -2.684f));
		this.quads[1] = new ObjQuad(new Vector3f(0.5618f, 0.7116f, -0.441f),new Vector3f(-0.4548f, 1.2349f, 0.5756f),new Vector3f(-0.5088f, 1.1814f, 0.5491f),new Vector3f(0.5078f, 0.6581f, -0.4675f),new Vector2f(-0.0278f, 0.4845f),new Vector2f(1.0278f, 0.4845f),new Vector2f(1.0278f, 0.54f),new Vector2f(-0.0278f, 0.54f),new Vector3f(1.316f, -2.658f, 2.684f));
		this.quads[2] = new ObjQuad(new Vector3f(0.5353f, 0.7651f, -0.4951f),new Vector3f(-0.4813f, 1.2884f, 0.5215f),new Vector3f(-0.4548f, 1.2349f, 0.5756f),new Vector3f(0.5618f, 0.7116f, -0.441f),new Vector2f(-0.0278f, 0.4972f),new Vector2f(1.0278f, 0.4972f),new Vector2f(1.0278f, 0.5528f),new Vector2f(-0.0278f, 0.5528f),new Vector3f(2.684f, 2.658f, 1.316f));
		this.quads[3] = new ObjQuad(new Vector3f(-0.5353f, 1.2349f, 0.4951f),new Vector3f(0.4813f, 0.7116f, -0.5215f),new Vector3f(0.5078f, 0.6581f, -0.4675f),new Vector3f(-0.5088f, 1.1814f, 0.5491f),new Vector2f(-0.0278f, 0.4972f),new Vector2f(1.0278f, 0.4972f),new Vector2f(1.0278f, 0.5528f),new Vector2f(-0.0278f, 0.5528f),new Vector3f(-2.684f, -2.658f, -1.316f));
		this.quads[4] = new ObjQuad(new Vector3f(0.5353f, 0.7651f, 0.4951f),new Vector3f(-0.4813f, 1.2884f, -0.5215f),new Vector3f(-0.5353f, 1.2349f, -0.4951f),new Vector3f(0.4813f, 0.7116f, 0.5215f),new Vector2f(0.2598f, 0.9556f),new Vector2f(0.7212f, 0.0143f),new Vector2f(0.7648f, 0.0389f),new Vector2f(0.3033f, 0.9801f),new Vector3f(-1.316f, 2.658f, 2.684f));
		this.quads[5] = new ObjQuad(new Vector3f(0.5618f, 0.7116f, 0.441f),new Vector3f(0.5078f, 0.6581f, 0.4675f),new Vector3f(-0.5088f, 1.1814f, -0.5491f),new Vector3f(-0.4548f, 1.2349f, -0.5756f),new Vector2f(0.7157f, 0.9611f),new Vector2f(0.6722f, 0.9857f),new Vector2f(0.2107f, 0.0444f),new Vector2f(0.2542f, 0.0199f),new Vector3f(1.316f, -2.658f, -2.684f));
		this.quads[6] = new ObjQuad(new Vector3f(0.5353f, 0.7651f, 0.4951f),new Vector3f(0.5618f, 0.7116f, 0.441f),new Vector3f(-0.4548f, 1.2349f, -0.5756f),new Vector3f(-0.4813f, 1.2884f, -0.5215f),new Vector2f(0.4261f, 0.9556f),new Vector2f(0.3766f, 0.9611f),new Vector2f(0.5001f, 0.0199f),new Vector2f(0.5496f, 0.0143f),new Vector3f(2.684f, 2.658f, -1.316f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.5353f, 1.2349f, -0.4951f),new Vector3f(-0.5088f, 1.1814f, -0.5491f),new Vector3f(0.5078f, 0.6581f, 0.4675f),new Vector3f(0.4813f, 0.7116f, 0.5215f),new Vector2f(0.4261f, 0.0389f),new Vector2f(0.4757f, 0.0444f),new Vector2f(0.5991f, 0.9857f),new Vector2f(0.5496f, 0.9801f),new Vector3f(-2.684f, -2.658f, 1.316f));
		this.quads[8] = new ObjQuad(new Vector3f(0.5353f, 1.2349f, -0.4951f),new Vector3f(-0.4813f, 0.7116f, 0.5215f),new Vector3f(-0.5353f, 0.7651f, 0.4951f),new Vector3f(0.4813f, 1.2884f, -0.5215f),new Vector2f(0.9169f, 0.2819f),new Vector2f(0.1083f, 0.7616f),new Vector2f(0.0831f, 0.7126f),new Vector2f(0.8917f, 0.2328f),new Vector3f(-1.316f, -2.658f, -2.684f));
		this.quads[9] = new ObjQuad(new Vector3f(0.5618f, 1.2884f, -0.441f),new Vector3f(0.5078f, 1.3419f, -0.4675f),new Vector3f(-0.5088f, 0.8186f, 0.5491f),new Vector3f(-0.4548f, 0.7651f, 0.5756f),new Vector2f(0.1083f, 0.2884f),new Vector2f(0.1336f, 0.2393f),new Vector2f(0.9422f, 0.7191f),new Vector2f(0.9169f, 0.7681f),new Vector3f(1.316f, 2.658f, 2.684f));
		this.quads[10] = new ObjQuad(new Vector3f(0.5353f, 1.2349f, -0.4951f),new Vector3f(0.5618f, 1.2884f, -0.441f),new Vector3f(-0.4548f, 0.7651f, 0.5756f),new Vector3f(-0.4813f, 0.7116f, 0.5215f),new Vector2f(0.0831f, 0.2691f),new Vector2f(0.1083f, 0.2201f),new Vector2f(0.9169f, 0.6998f),new Vector2f(0.8917f, 0.7489f),new Vector3f(2.684f, -2.658f, 1.316f));
		this.quads[11] = new ObjQuad(new Vector3f(-0.5353f, 0.7651f, 0.4951f),new Vector3f(-0.5088f, 0.8186f, 0.5491f),new Vector3f(0.5078f, 1.3419f, -0.4675f),new Vector3f(0.4813f, 1.2884f, -0.5215f),new Vector2f(0.0831f, 0.7554f),new Vector2f(0.0578f, 0.7063f),new Vector2f(0.8664f, 0.2266f),new Vector2f(0.8917f, 0.2756f),new Vector3f(-2.684f, 2.658f, -1.316f));
		this.quads[12] = new ObjQuad(new Vector3f(0.5353f, 1.2349f, 0.4951f),new Vector3f(0.4813f, 1.2884f, 0.5215f),new Vector3f(-0.5353f, 0.7651f, -0.4951f),new Vector3f(-0.4813f, 0.7116f, -0.5215f),new Vector2f(0.537f, 0.0444f),new Vector2f(0.5865f, 0.0389f),new Vector2f(0.463f, 0.9801f),new Vector2f(0.4135f, 0.9857f),new Vector3f(-1.316f, -2.658f, 2.684f));
		this.quads[13] = new ObjQuad(new Vector3f(0.5618f, 1.2884f, 0.441f),new Vector3f(-0.4548f, 0.7651f, -0.5756f),new Vector3f(-0.5088f, 0.8186f, -0.5491f),new Vector3f(0.5078f, 1.3419f, 0.4675f),new Vector2f(0.4873f, 0.0199f),new Vector2f(0.6108f, 0.9611f),new Vector2f(0.5613f, 0.9556f),new Vector2f(0.4378f, 0.0143f),new Vector3f(1.316f, 2.658f, -2.684f));
		this.quads[14] = new ObjQuad(new Vector3f(0.5353f, 1.2349f, 0.4951f),new Vector3f(-0.4813f, 0.7116f, -0.5215f),new Vector3f(-0.4548f, 0.7651f, -0.5756f),new Vector3f(0.5618f, 1.2884f, 0.441f),new Vector2f(0.9556f, 0.7402f),new Vector2f(0.0143f, 0.2788f),new Vector2f(0.0389f, 0.2352f),new Vector2f(0.9801f, 0.6967f),new Vector3f(2.684f, -2.658f, -1.316f));
		this.quads[15] = new ObjQuad(new Vector3f(-0.5353f, 0.7651f, -0.4951f),new Vector3f(0.4813f, 1.2884f, 0.5215f),new Vector3f(0.5078f, 1.3419f, 0.4675f),new Vector3f(-0.5088f, 0.8186f, -0.5491f),new Vector2f(0.9801f, 0.2542f),new Vector2f(0.0389f, 0.7157f),new Vector2f(0.0143f, 0.6722f),new Vector2f(0.9556f, 0.2107f),new Vector3f(-2.684f, 2.658f, 1.316f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		Box015 other = new Box015();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}
