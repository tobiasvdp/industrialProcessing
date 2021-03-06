package ip.industrialProcessing.api.rendering.wavefront;

import org.lwjgl.util.vector.Matrix3f;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

public class ObjQuad {

	public Vector3f position1;
	public Vector3f position2;
	public Vector3f position3;
	public Vector3f position4;
	public Vector3f normal;
	public Vector2f uv1;
	public Vector2f uv2;
	public Vector2f uv3;
	public Vector2f uv4;

	public ObjQuad(Vector3f position1, Vector3f position2, Vector3f position3, Vector3f position4, Vector2f uv1, Vector2f uv2, Vector2f uv3, Vector2f uv4, Vector3f normal) {
		this.position1 = scalePosition(position1);
		this.position2 = scalePosition(position2);
		this.position3 = scalePosition(position3);
		this.position4 = scalePosition(position4);
		this.uv1 = roundUV(uv1);
		this.uv2 = roundUV(uv2);
		this.uv3 = roundUV(uv3);
		this.uv4 = roundUV(uv4);
		this.normal = normal;
	}

	// Enable use of triangles by adding a degenerate vertex
	public ObjQuad(Vector3f position1, Vector3f position2, Vector3f position3, Vector2f uv1, Vector2f uv2, Vector2f uv3, Vector3f normal) {
		this.position1 = scalePosition(position1);
		this.position2 = scalePosition(position2);
		this.position3 = scalePosition(position3);
		this.position4 = scalePosition(position3);
		this.uv1 = roundUV(uv1);
		this.uv2 = roundUV(uv2);
		this.uv3 = roundUV(uv3);
		this.uv4 = roundUV(uv3);
		this.normal = normal;
	}

	private Vector3f scalePosition(Vector3f position32) {
		float x = position32.x / 1.6f;
		float y = position32.y / 1.6f;
		float z = position32.z / 1.6f;
		return new Vector3f(x, y, z);
	}

	private Vector2f roundUV(Vector2f uv) {
		float u = Math.round(uv.x * 16f) / 16f;
		float v = Math.round(uv.y * 16f) / 16f;
		return new Vector2f(u, v);
	}

	public ObjQuad() {
	}

	public ObjQuad cloneTransformed(Matrix4f transform) {
		ObjQuad clone = new ObjQuad();

		clone.position1 = transform(this.position1, transform);
		clone.position2 = transform(this.position2, transform);
		clone.position3 = transform(this.position3, transform);
		clone.position4 = transform(this.position4, transform);

		clone.uv1 = this.uv1;
		clone.uv2 = this.uv2;
		clone.uv3 = this.uv3;
		clone.uv4 = this.uv4;

		clone.normal = transform(this.normal, transform);
		return clone;
	}

	private Vector3f transformNormal(Vector3f normal, Matrix4f transform) {
		Matrix3f rotation = new Matrix3f();
		rotation.m00 = transform.m00;
		rotation.m01 = transform.m01;
		rotation.m02 = transform.m02;
		rotation.m10 = transform.m10;
		rotation.m11 = transform.m11;
		rotation.m12 = transform.m12;
		rotation.m20 = transform.m20;
		rotation.m21 = transform.m21;
		rotation.m22 = transform.m22;

		return Matrix3f.transform(rotation, normal, null);
	}

	private Vector3f transform(Vector3f position12, Matrix4f transform) {
		Vector4f vector = new Vector4f(position12.x, position12.y, position12.z, 1);

		Vector4f dest = Matrix4f.transform(transform, vector, null);
		return new Vector3f(dest.x / dest.w, dest.y / dest.w, dest.z / dest.w);
	}
}
