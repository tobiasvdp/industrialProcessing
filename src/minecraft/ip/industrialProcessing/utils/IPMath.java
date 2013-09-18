package ip.industrialProcessing.utils;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class IPMath {

	public static float lerp(float p1, float p2, float blend) {
		return (p2 - p1) * blend + p1;
	}

	public static Vector2f lerp(Vector2f p1, Vector2f p2, float blend) {
		float x = (p2.x - p1.x) * blend + p1.x;
		float y = (p2.y - p1.y) * blend + p1.y;
		return new Vector2f(x, y);
	}

	public static Vector2f bezier(Vector2f p1, Vector2f p2, Vector2f p3, float blend) {
		float oneMinusT = 1 - blend;
		float oneMinusT2 = oneMinusT * oneMinusT;

		float a = oneMinusT2;
		float b = 2 * oneMinusT * blend;
		float c = blend * blend;
		float x = a * p1.x + b * p2.x + c * p3.x;
		float y = a * p1.y + b * p2.y + c * p3.y;
		return new Vector2f(x, y);
	}

	public static Vector3f bezier(Vector3f p1, Vector3f p2, Vector3f p3, float blend) {
		float oneMinusT = 1 - blend;
		float oneMinusT2 = oneMinusT * oneMinusT;

		float a = oneMinusT2;
		float b = 2 * oneMinusT * blend;
		float c = blend * blend;
		float x = a * p1.x + b * p2.x + c * p3.x;
		float y = a * p1.y + b * p2.y + c * p3.y;
		float z = a * p1.z + b * p2.z + c * p3.z;
		return new Vector3f(x, y, z);
	}
}
