package ip.industrialProcessing.machines.flotationCell.model;
import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
public class FlotationCellHull extends ObjMesh{
	public FlotationCellHull(){
		this.quads = new ObjQuad[63];
		this.quads[0] = new ObjQuad(new Vector3f(-0.5f, 0.2f, 0.488636f),new Vector3f(-0.5f, 0.2f, -0.488708f),new Vector3f(-0.6f, 0.2f, -0.389334f),new Vector3f(-0.6f, 0.2f, 0.388006f),new Vector2f(0.187459f, 0.194602f),new Vector2f(0.18746f, 0.805442f),new Vector2f(0.12496f, 0.743334f),new Vector2f(0.124959f, 0.257497f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[1] = new ObjQuad(new Vector3f(-0.5f, 0.2f, 0.6f),new Vector3f(-0.5f, 0.1f, 0.6f),new Vector3f(-0.5f, 0.1f, -0.6f),new Vector3f(-0.5f, 0.2f, 0.488636f),new Vector2f(0.125f, 0.125f),new Vector2f(0.125f, 0.0625f),new Vector2f(0.875f, 0.0625f),new Vector2f(0.194602f, 0.125f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[2] = new ObjQuad(new Vector3f(-0.5f, 0.1f, -0.6f),new Vector3f(-0.5f, 0.2f, -0.6f),new Vector3f(-0.5f, 0.2f, -0.488708f),new Vector3f(-0.5f, 0.2f, 0.488636f),new Vector2f(0.875f, 0.0625f),new Vector2f(0.875f, 0.125f),new Vector2f(0.805442f, 0.125f),new Vector2f(0.194602f, 0.125f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[3] = new ObjQuad(new Vector3f(0.5f, 0.2f, 0.6f),new Vector3f(-0.389334f, 0.2f, 0.6f),new Vector3f(0.388006f, 0.2f, 0.6f),new Vector2f(0.125f, 0.125f),new Vector2f(0.125f, 0.125f),new Vector2f(0.125f, 0.125f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[4] = new ObjQuad(new Vector3f(-0.6f, 0.2f, 0.388006f),new Vector3f(-0.7f, 0.2f, 0.287375f),new Vector3f(-0.69818f, 0.2f, -0.29177f),new Vector3f(-0.6f, 0.2f, -0.389334f),new Vector2f(0.875041f, 0.257497f),new Vector2f(0.937541f, 0.320391f),new Vector2f(0.936403f, 0.682356f),new Vector2f(0.87504f, 0.743334f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[5] = new ObjQuad(new Vector3f(-0.29177f, 0.2f, 0.69818f),new Vector3f(-0.29177f, 1.3f, 0.69818f),new Vector3f(-0.7f, 1.3f, 0.287375f),new Vector3f(-0.389334f, 0.2f, 0.6f),new Vector2f(0.936362f, 0.125f),new Vector2f(0.936362f, 0.8125f),new Vector2f(0.679609f, 0.8125f),new Vector2f(0.875f, 0.125f),new Vector3f(-2.837304f, 0.0f, 2.819524f));
		this.quads[6] = new ObjQuad(new Vector3f(-0.5f, 0.2f, 0.488636f),new Vector3f(-0.389334f, 0.2f, 0.6f),new Vector3f(-0.7f, 1.3f, 0.287375f),new Vector3f(-0.6f, 0.2f, 0.388006f),new Vector2f(0.805398f, 0.125f),new Vector2f(0.875f, 0.125f),new Vector2f(0.679609f, 0.8125f),new Vector2f(0.742504f, 0.125f),new Vector3f(-2.837304f, 0.0f, 2.819524f));
		this.quads[7] = new ObjQuad(new Vector3f(-0.6f, 0.2f, 0.388006f),new Vector3f(-0.7f, 1.3f, 0.287375f),new Vector3f(-0.7f, 0.2f, 0.287375f),new Vector2f(0.742504f, 0.125f),new Vector2f(0.679609f, 0.8125f),new Vector2f(0.679609f, 0.125f),new Vector3f(-2.127978f, 0.0f, 2.114643f));
		this.quads[8] = new ObjQuad(new Vector3f(-0.29177f, 0.2f, 0.69818f),new Vector3f(0.287375f, 0.2f, 0.7f),new Vector3f(0.287375f, 1.3f, 0.7f),new Vector3f(-0.29177f, 1.3f, 0.69818f),new Vector2f(0.317603f, 0.125f),new Vector2f(0.679569f, 0.125f),new Vector2f(0.679569f, 0.8125f),new Vector2f(0.317603f, 0.8125f),new Vector3f(-0.012572f, 0.0f, 3.99998f));
		this.quads[9] = new ObjQuad(new Vector3f(0.6f, 0.2f, 0.389334f),new Vector3f(0.69818f, 0.2f, 0.29177f),new Vector3f(0.69818f, 1.3f, 0.29177f),new Vector3f(0.5f, 0.2f, 0.488708f),new Vector2f(0.874959f, 0.125f),new Vector2f(0.936322f, 0.125f),new Vector2f(0.936322f, 0.8125f),new Vector2f(0.812459f, 0.125f),new Vector3f(2.819524f, 0.0f, 2.837304f));
		this.quads[10] = new ObjQuad(new Vector3f(0.388006f, 0.2f, 0.6f),new Vector3f(0.5f, 0.2f, 0.488708f),new Vector3f(0.69818f, 1.3f, 0.29177f),new Vector3f(0.287375f, 0.2f, 0.7f),new Vector2f(0.742463f, 0.125f),new Vector2f(0.812459f, 0.125f),new Vector2f(0.936322f, 0.8125f),new Vector2f(0.679569f, 0.125f),new Vector3f(2.819524f, 0.0f, 2.837304f));
		this.quads[11] = new ObjQuad(new Vector3f(0.287375f, 0.2f, 0.7f),new Vector3f(0.69818f, 1.3f, 0.29177f),new Vector3f(0.287375f, 1.3f, 0.7f),new Vector2f(0.679569f, 0.125f),new Vector2f(0.936322f, 0.8125f),new Vector2f(0.679569f, 0.8125f),new Vector3f(2.114643f, 0.0f, 2.127978f));
		this.quads[12] = new ObjQuad(new Vector3f(0.6f, 0.2f, 0.389334f),new Vector3f(0.6f, 0.2f, -0.388006f),new Vector3f(0.7f, 0.2f, -0.287375f),new Vector3f(0.69818f, 0.2f, 0.29177f),new Vector2f(0.125041f, 0.256666f),new Vector2f(0.12504f, 0.742504f),new Vector2f(0.06254f, 0.679609f),new Vector2f(0.063678f, 0.317644f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[13] = new ObjQuad(new Vector3f(0.5f, 0.2f, -0.488636f),new Vector3f(0.5f, 0.2f, 0.488708f),new Vector3f(0.6f, 0.2f, 0.389334f),new Vector3f(0.6f, 0.2f, -0.388006f),new Vector2f(0.81246f, 0.805398f),new Vector2f(0.812459f, 0.194558f),new Vector2f(0.874959f, 0.256666f),new Vector2f(0.87496f, 0.742504f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[14] = new ObjQuad(new Vector3f(-0.6f, 0.1f, -0.6f),new Vector3f(0.5f, 0.1f, -0.6f),new Vector3f(-0.5f, 0.1f, -0.6f),new Vector2f(0.875f, 0.0625f),new Vector2f(0.875f, 0.0625f),new Vector2f(0.875f, 0.0625f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[15] = new ObjQuad(new Vector3f(-0.6f, 0.1f, -0.6f),new Vector3f(0.6f, 0.1f, -0.6f),new Vector3f(0.5f, 0.1f, -0.6f),new Vector2f(0.875f, 0.0625f),new Vector2f(0.875f, 0.0625f),new Vector2f(0.875f, 0.0625f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[16] = new ObjQuad(new Vector3f(0.69818f, 1.3f, 0.29177f),new Vector3f(0.69818f, 0.2f, 0.29177f),new Vector3f(0.7f, 0.2f, -0.287375f),new Vector3f(0.7f, 1.3f, -0.287375f),new Vector2f(0.317644f, 0.8125f),new Vector2f(0.317644f, 0.125f),new Vector2f(0.679609f, 0.125f),new Vector2f(0.679609f, 0.8125f),new Vector3f(3.99998f, 0.0f, 0.012572f));
		this.quads[17] = new ObjQuad(new Vector3f(-0.69818f, 1.3f, -0.29177f),new Vector3f(-0.69818f, 0.2f, -0.29177f),new Vector3f(-0.7f, 0.2f, 0.287375f),new Vector3f(-0.7f, 1.3f, 0.287375f),new Vector2f(0.317644f, 0.8125f),new Vector2f(0.317644f, 0.125f),new Vector2f(0.679609f, 0.125f),new Vector2f(0.679609f, 0.8125f),new Vector3f(-3.99998f, 0.0f, -0.012572f));
		this.quads[18] = new ObjQuad(new Vector3f(-0.437905f, 1.5f, 0.179776f),new Vector3f(-0.436767f, 1.5f, -0.182525f),new Vector3f(-0.59831f, 1.4f, -0.250034f),new Vector3f(-0.59987f, 1.4f, 0.246268f),new Vector2f(0.226269f, 0.38764f),new Vector2f(0.22698f, 0.614078f),new Vector2f(0.126016f, 0.656272f),new Vector2f(0.125041f, 0.346082f),new Vector3f(-2.103368f, 3.402324f, -0.006612f));
		this.quads[19] = new ObjQuad(new Vector3f(-0.437905f, 1.5f, 0.179776f),new Vector3f(-0.59987f, 1.4f, 0.246268f),new Vector3f(-0.250034f, 1.4f, 0.59831f),new Vector3f(-0.182525f, 1.5f, 0.436767f),new Vector2f(0.226269f, 0.38764f),new Vector2f(0.125041f, 0.346082f),new Vector2f(0.343688f, 0.126056f),new Vector2f(0.385881f, 0.227021f),new Vector3f(-1.49198f, 3.402324f, 1.482632f));
		this.quads[20] = new ObjQuad(new Vector3f(0.246268f, 1.4f, 0.59987f),new Vector3f(0.179776f, 1.5f, 0.437905f),new Vector3f(-0.182525f, 1.5f, 0.436767f),new Vector3f(-0.250034f, 1.4f, 0.59831f),new Vector2f(0.653877f, 0.125081f),new Vector2f(0.612319f, 0.226309f),new Vector2f(0.385881f, 0.227021f),new Vector2f(0.343688f, 0.126056f),new Vector3f(-0.006612f, 3.402324f, 2.103368f));
		this.quads[21] = new ObjQuad(new Vector3f(0.246268f, 1.4f, 0.59987f),new Vector3f(0.59831f, 1.4f, 0.250034f),new Vector3f(0.436767f, 1.5f, 0.182525f),new Vector3f(0.179776f, 1.5f, 0.437905f),new Vector2f(0.653877f, 0.125081f),new Vector2f(0.873903f, 0.343728f),new Vector2f(0.772939f, 0.385922f),new Vector2f(0.612319f, 0.226309f),new Vector3f(1.482632f, 3.402324f, 1.49198f));
		this.quads[22] = new ObjQuad(new Vector3f(0.59831f, 1.4f, 0.250034f),new Vector3f(0.59987f, 1.4f, -0.246268f),new Vector3f(0.437905f, 1.5f, -0.179776f),new Vector3f(0.436767f, 1.5f, 0.182525f),new Vector2f(0.873903f, 0.343728f),new Vector2f(0.874878f, 0.653918f),new Vector2f(0.77365f, 0.61236f),new Vector2f(0.772939f, 0.385922f),new Vector3f(2.103368f, 3.402324f, 0.006612f));
		this.quads[23] = new ObjQuad(new Vector3f(0.250034f, 1.4f, -0.59831f),new Vector3f(0.182525f, 1.5f, -0.436767f),new Vector3f(0.437905f, 1.5f, -0.179776f),new Vector3f(0.59987f, 1.4f, -0.246268f),new Vector2f(0.656231f, 0.873944f),new Vector2f(0.614038f, 0.772979f),new Vector2f(0.77365f, 0.61236f),new Vector2f(0.874878f, 0.653918f),new Vector3f(1.49198f, 3.402324f, -1.482632f));
		this.quads[24] = new ObjQuad(new Vector3f(0.250034f, 1.4f, -0.59831f),new Vector3f(-0.246268f, 1.4f, -0.59987f),new Vector3f(-0.179776f, 1.5f, -0.437905f),new Vector3f(0.182525f, 1.5f, -0.436767f),new Vector2f(0.656231f, 0.873944f),new Vector2f(0.346042f, 0.874919f),new Vector2f(0.3876f, 0.773691f),new Vector2f(0.614038f, 0.772979f),new Vector3f(0.006612f, 3.402324f, -2.103368f));
		this.quads[25] = new ObjQuad(new Vector3f(-0.246268f, 1.4f, -0.59987f),new Vector3f(-0.59831f, 1.4f, -0.250034f),new Vector3f(-0.436767f, 1.5f, -0.182525f),new Vector3f(-0.179776f, 1.5f, -0.437905f),new Vector2f(0.346042f, 0.874919f),new Vector2f(0.126016f, 0.656272f),new Vector2f(0.22698f, 0.614078f),new Vector2f(0.3876f, 0.773691f),new Vector3f(-1.482632f, 3.402324f, -1.49198f));
		this.quads[26] = new ObjQuad(new Vector3f(0.182525f, 1.5f, -0.436767f),new Vector3f(-0.179776f, 1.5f, -0.437905f),new Vector3f(-0.301375f, 1.5f, -0.301375f),new Vector3f(0.298625f, 1.5f, -0.301375f),new Vector2f(0.614038f, 0.772979f),new Vector2f(0.3876f, 0.773691f),new Vector2f(0.3116f, 0.688359f),new Vector2f(0.6866f, 0.688359f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[27] = new ObjQuad(new Vector3f(0.437905f, 1.5f, -0.179776f),new Vector3f(0.182525f, 1.5f, -0.436767f),new Vector3f(0.298625f, 1.5f, -0.301375f),new Vector3f(0.436767f, 1.5f, 0.182525f),new Vector2f(0.77365f, 0.61236f),new Vector2f(0.614038f, 0.772979f),new Vector2f(-4.1E-5f, 0.705301f),new Vector2f(0.772939f, 0.385922f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[28] = new ObjQuad(new Vector3f(0.436767f, 1.5f, 0.182525f),new Vector3f(0.298625f, 1.5f, -0.301375f),new Vector3f(0.298625f, 1.5f, 0.298625f),new Vector3f(0.179776f, 1.5f, 0.437905f),new Vector2f(0.772939f, 0.385922f),new Vector2f(-4.1E-5f, 0.705301f),new Vector2f(0.6866f, 0.313359f),new Vector2f(0.612319f, 0.226309f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[29] = new ObjQuad(new Vector3f(-0.182525f, 1.5f, 0.436767f),new Vector3f(0.179776f, 1.5f, 0.437905f),new Vector3f(0.298625f, 1.5f, 0.298625f),new Vector3f(-0.301375f, 1.5f, 0.298625f),new Vector2f(0.385881f, 0.227021f),new Vector2f(0.612319f, 0.226309f),new Vector2f(0.6866f, 0.313359f),new Vector2f(0.3116f, 0.313359f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[30] = new ObjQuad(new Vector3f(-0.437905f, 1.5f, 0.179776f),new Vector3f(-0.182525f, 1.5f, 0.436767f),new Vector3f(-0.301375f, 1.5f, 0.298625f),new Vector3f(-0.436767f, 1.5f, -0.182525f),new Vector2f(0.226269f, 0.38764f),new Vector2f(0.385881f, 0.227021f),new Vector2f(0.3116f, 0.313359f),new Vector2f(0.22698f, 0.614078f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[31] = new ObjQuad(new Vector3f(-0.436767f, 1.5f, -0.182525f),new Vector3f(-0.301375f, 1.5f, 0.298625f),new Vector3f(-0.301375f, 1.5f, -0.301375f),new Vector3f(-0.179776f, 1.5f, -0.437905f),new Vector2f(0.22698f, 0.614078f),new Vector2f(0.3116f, 0.313359f),new Vector2f(0.3116f, 0.688359f),new Vector2f(0.3876f, 0.773691f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[32] = new ObjQuad(new Vector3f(-0.6f, 0.2f, -0.389334f),new Vector3f(-0.69818f, 0.2f, -0.29177f),new Vector3f(-0.69818f, 1.3f, -0.29177f),new Vector3f(-0.5f, 0.2f, -0.488708f),new Vector2f(0.87504f, 0.125f),new Vector2f(0.936403f, 0.125f),new Vector2f(0.936403f, 0.8125f),new Vector2f(0.81254f, 0.125f),new Vector3f(-2.819524f, 0.0f, -2.837304f));
		this.quads[33] = new ObjQuad(new Vector3f(-0.388006f, 0.2f, -0.6f),new Vector3f(-0.5f, 0.2f, -0.488708f),new Vector3f(-0.69818f, 1.3f, -0.29177f),new Vector3f(-0.287375f, 0.2f, -0.7f),new Vector2f(0.742544f, 0.125f),new Vector2f(0.81254f, 0.125f),new Vector2f(0.936403f, 0.8125f),new Vector2f(0.67965f, 0.125f),new Vector3f(-2.819524f, 0.0f, -2.837304f));
		this.quads[34] = new ObjQuad(new Vector3f(-0.287375f, 0.5f, -0.7f),new Vector3f(-0.287375f, 0.2f, -0.7f),new Vector3f(-0.69818f, 1.3f, -0.29177f),new Vector3f(-0.287375f, 1.1f, -0.7f),new Vector2f(0.67965f, 0.3125f),new Vector2f(0.67965f, 0.125f),new Vector2f(0.936403f, 0.8125f),new Vector2f(0.67965f, 0.6875f),new Vector3f(-2.819524f, 0.0f, -2.837304f));
		this.quads[35] = new ObjQuad(new Vector3f(-0.287375f, 1.1f, -0.7f),new Vector3f(-0.69818f, 1.3f, -0.29177f),new Vector3f(-0.287375f, 1.3f, -0.7f),new Vector2f(0.67965f, 0.6875f),new Vector2f(0.936403f, 0.8125f),new Vector2f(0.67965f, 0.8125f),new Vector3f(-2.114643f, 0.0f, -2.127978f));
		this.quads[36] = new ObjQuad(new Vector3f(0.7f, 1.3f, -0.287375f),new Vector3f(0.7f, 0.2f, -0.287375f),new Vector3f(0.6f, 0.2f, -0.388006f),new Vector3f(0.29177f, 1.3f, -0.69818f),new Vector2f(0.679609f, 0.8125f),new Vector2f(0.679609f, 0.125f),new Vector2f(0.742504f, 0.125f),new Vector2f(0.936362f, 0.8125f),new Vector3f(2.837304f, 0.0f, -2.819524f));
		this.quads[37] = new ObjQuad(new Vector3f(0.29177f, 1.3f, -0.69818f),new Vector3f(0.6f, 0.2f, -0.388006f),new Vector3f(0.5f, 0.2f, -0.488636f),new Vector3f(0.389334f, 0.2f, -0.6f),new Vector2f(0.936362f, 0.8125f),new Vector2f(0.742504f, 0.125f),new Vector2f(0.805398f, 0.125f),new Vector2f(0.875f, 0.125f),new Vector3f(2.837304f, 0.0f, -2.819524f));
		this.quads[38] = new ObjQuad(new Vector3f(0.29177f, 1.3f, -0.69818f),new Vector3f(0.389334f, 0.2f, -0.6f),new Vector3f(0.29177f, 0.2f, -0.69818f),new Vector2f(0.936362f, 0.8125f),new Vector2f(0.875f, 0.125f),new Vector2f(0.936362f, 0.125f),new Vector3f(2.127978f, 0.0f, -2.114643f));
		this.quads[39] = new ObjQuad(new Vector3f(0.388006f, 0.2f, 0.6f),new Vector3f(-0.2f, 0.2f, 0.2f),new Vector3f(0.0f, 0.2f, 0.2f),new Vector3f(0.2f, 0.2f, 0.2f),new Vector2f(0.257537f, 0.125f),new Vector2f(0.625041f, 0.375f),new Vector2f(0.500041f, 0.375f),new Vector2f(0.375041f, 0.375f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[40] = new ObjQuad(new Vector3f(-0.2f, 0.2f, 0.2f),new Vector3f(0.388006f, 0.2f, 0.6f),new Vector3f(-0.389334f, 0.2f, 0.6f),new Vector3f(-0.388006f, 0.2f, -0.6f),new Vector2f(0.625041f, 0.375f),new Vector2f(0.257537f, 0.125f),new Vector2f(0.743374f, 0.125f),new Vector2f(0.742544f, 0.875f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[41] = new ObjQuad(new Vector3f(-0.5f, 0.2f, 0.488636f),new Vector3f(-0.5f, 0.2f, -0.488708f),new Vector3f(-0.388006f, 0.2f, -0.6f),new Vector3f(-0.389334f, 0.2f, 0.6f),new Vector2f(0.812541f, 0.194602f),new Vector2f(0.81254f, 0.805442f),new Vector2f(0.742544f, 0.875f),new Vector2f(0.743374f, 0.125f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[42] = new ObjQuad(new Vector3f(-0.2f, 0.2f, -0.2f),new Vector3f(-0.2f, 0.2f, 0.2f),new Vector3f(-0.388006f, 0.2f, -0.6f),new Vector3f(0.389334f, 0.2f, -0.6f),new Vector2f(0.62504f, 0.625f),new Vector2f(0.625041f, 0.375f),new Vector2f(0.742544f, 0.875f),new Vector2f(0.256706f, 0.875f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[43] = new ObjQuad(new Vector3f(0.0f, 0.2f, -0.2f),new Vector3f(-0.2f, 0.2f, -0.2f),new Vector3f(0.389334f, 0.2f, -0.6f),new Vector3f(0.2f, 0.2f, -0.2f),new Vector2f(0.50004f, 0.625f),new Vector2f(0.62504f, 0.625f),new Vector2f(0.256706f, 0.875f),new Vector2f(0.37504f, 0.625f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[44] = new ObjQuad(new Vector3f(0.2f, 0.2f, -0.0f),new Vector3f(0.2f, 0.2f, -0.2f),new Vector3f(0.389334f, 0.2f, -0.6f),new Vector3f(0.2f, 0.2f, 0.2f),new Vector2f(0.37504f, 0.5f),new Vector2f(0.37504f, 0.625f),new Vector2f(0.256706f, 0.875f),new Vector2f(0.375041f, 0.375f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[45] = new ObjQuad(new Vector3f(0.388006f, 0.2f, 0.6f),new Vector3f(0.2f, 0.2f, 0.2f),new Vector3f(0.389334f, 0.2f, -0.6f),new Vector3f(0.5f, 0.2f, 0.488708f),new Vector2f(0.257537f, 0.125f),new Vector2f(0.375041f, 0.375f),new Vector2f(0.256706f, 0.875f),new Vector2f(0.187541f, 0.194558f),new Vector3f(0.0f, -4.0f, 0.0f));
		this.quads[46] = new ObjQuad(new Vector3f(0.5f, 0.2f, 0.488708f),new Vector3f(0.389334f, 0.2f, -0.6f),new Vector3f(0.5f, 0.2f, -0.488636f),new Vector2f(0.187541f, 0.194558f),new Vector2f(0.256706f, 0.875f),new Vector2f(0.18754f, 0.805398f),new Vector3f(0.0f, -3.0f, 0.0f));
		this.quads[47] = new ObjQuad(new Vector3f(-0.2f, 0.2f, 0.2f),new Vector3f(-0.2f, 0.2f, -0.2f),new Vector3f(-0.2f, 0.2f, -0.0f),new Vector2f(0.375f, 0.125f),new Vector2f(0.625f, 0.125f),new Vector2f(0.5f, 0.125f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[48] = new ObjQuad(new Vector3f(-0.2f, 0.1f, 0.2f),new Vector3f(-0.2f, 0.2f, 0.2f),new Vector3f(-0.2f, 0.2f, -0.0f),new Vector3f(-0.2f, 0.1f, -0.2f),new Vector2f(0.625f, 0.0625f),new Vector2f(0.625f, 0.125f),new Vector2f(0.5f, 0.125f),new Vector2f(0.375f, 0.0625f),new Vector3f(-4.0f, 0.0f, 0.0f));
		this.quads[49] = new ObjQuad(new Vector3f(-0.2f, 0.1f, -0.2f),new Vector3f(-0.2f, 0.2f, -0.0f),new Vector3f(-0.2f, 0.2f, -0.2f),new Vector2f(0.375f, 0.0625f),new Vector2f(0.5f, 0.125f),new Vector2f(0.375f, 0.125f),new Vector3f(-3.0f, 0.0f, 0.0f));
		this.quads[50] = new ObjQuad(new Vector3f(-0.2f, 0.1f, 0.2f),new Vector3f(0.2f, 0.1f, 0.2f),new Vector3f(0.2f, 0.2f, 0.2f),new Vector3f(-0.2f, 0.2f, 0.2f),new Vector2f(0.374959f, 0.0625f),new Vector2f(0.624959f, 0.0625f),new Vector2f(0.624959f, 0.125f),new Vector2f(0.374959f, 0.125f),new Vector3f(0.0f, 0.0f, 4.0f));
		this.quads[51] = new ObjQuad(new Vector3f(0.2f, 0.1f, -0.2f),new Vector3f(0.2f, 0.1f, 0.2f),new Vector3f(0.3f, 0.1f, 0.3f),new Vector3f(0.3f, 0.1f, -0.3f),new Vector2f(0.62496f, 0.625f),new Vector2f(0.166626f, 0.636867f),new Vector2f(-4.1E-5f, 0.705301f),new Vector2f(0.68746f, 0.6875f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[52] = new ObjQuad(new Vector3f(-0.2f, 0.1f, -0.2f),new Vector3f(0.2f, 0.1f, -0.2f),new Vector3f(0.3f, 0.1f, -0.3f),new Vector3f(-0.3f, 0.1f, -0.3f),new Vector2f(0.37496f, 0.625f),new Vector2f(0.62496f, 0.625f),new Vector2f(0.68746f, 0.6875f),new Vector2f(0.31246f, 0.6875f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[53] = new ObjQuad(new Vector3f(-0.2f, 0.1f, 0.2f),new Vector3f(-0.2f, 0.1f, -0.2f),new Vector3f(-0.3f, 0.1f, -0.3f),new Vector3f(-0.3f, 0.1f, 0.3f),new Vector2f(0.374959f, 0.375f),new Vector2f(0.37496f, 0.625f),new Vector2f(0.31246f, 0.6875f),new Vector2f(0.312459f, 0.3125f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[54] = new ObjQuad(new Vector3f(-0.2f, 0.1f, 0.2f),new Vector3f(-0.3f, 0.1f, 0.3f),new Vector3f(0.3f, 0.1f, 0.3f),new Vector3f(0.2f, 0.1f, 0.2f),new Vector2f(0.374959f, 0.375f),new Vector2f(0.312459f, 0.3125f),new Vector2f(0.687459f, 0.3125f),new Vector2f(0.624959f, 0.375f),new Vector3f(0.0f, 4.0f, 0.0f));
		this.quads[55] = new ObjQuad(new Vector3f(-0.2f, 0.2f, -0.2f),new Vector3f(0.2f, 0.2f, -0.2f),new Vector3f(0.2f, 0.1f, -0.2f),new Vector3f(-0.2f, 0.1f, -0.2f),new Vector2f(0.62504f, 0.125f),new Vector2f(0.37504f, 0.125f),new Vector2f(0.37504f, 0.0625f),new Vector2f(0.62504f, 0.0625f),new Vector3f(0.0f, 0.0f, -4.0f));
		this.quads[56] = new ObjQuad(new Vector3f(0.2f, 0.2f, -0.2f),new Vector3f(-0.2f, 0.2f, -0.2f),new Vector3f(0.0f, 0.2f, -0.2f),new Vector2f(0.625f, 0.125f),new Vector2f(0.625f, 0.125f),new Vector2f(0.625f, 0.125f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[57] = new ObjQuad(new Vector3f(0.2f, 0.2f, 0.2f),new Vector3f(0.2f, 0.1f, 0.2f),new Vector3f(0.2f, 0.1f, -0.2f),new Vector3f(0.2f, 0.2f, -0.0f),new Vector2f(0.375f, 0.125f),new Vector2f(0.375f, 0.0625f),new Vector2f(0.625f, 0.0625f),new Vector2f(0.5f, 0.125f),new Vector3f(4.0f, 0.0f, 0.0f));
		this.quads[58] = new ObjQuad(new Vector3f(0.2f, 0.2f, -0.0f),new Vector3f(0.2f, 0.1f, -0.2f),new Vector3f(0.2f, 0.2f, -0.2f),new Vector2f(0.5f, 0.125f),new Vector2f(0.625f, 0.0625f),new Vector2f(0.625f, 0.125f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[59] = new ObjQuad(new Vector3f(0.3f, 0.0f, 0.3f),new Vector3f(0.3f, 0.0f, -0.3f),new Vector3f(0.3f, 0.0f, -0.0f),new Vector2f(0.3125f, 0.0f),new Vector2f(0.6875f, 0.0f),new Vector2f(0.5f, 0.0f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[60] = new ObjQuad(new Vector3f(-0.2f, 0.2f, 0.2f),new Vector3f(0.2f, 0.2f, 0.2f),new Vector3f(0.0f, 0.2f, 0.2f),new Vector2f(0.375f, 0.125f),new Vector2f(0.375f, 0.125f),new Vector2f(0.375f, 0.125f),new Vector3f(3.0f, 0.0f, 0.0f));
		this.quads[61] = new ObjQuad(new Vector3f(0.29177f, 0.2f, -0.69818f),new Vector3f(-0.287375f, 0.2f, -0.7f),new Vector3f(-0.287375f, 0.5f, -0.7f),new Vector3f(0.29177f, 1.3f, -0.69818f),new Vector2f(0.317684f, 0.125f),new Vector2f(0.67965f, 0.125f),new Vector2f(0.67965f, 0.3125f),new Vector2f(0.317684f, 0.8125f),new Vector3f(0.012572f, 0.0f, -3.99998f));
		this.quads[62] = new ObjQuad(new Vector3f(-0.287375f, 1.1f, -0.7f),new Vector3f(-0.287375f, 1.3f, -0.7f),new Vector3f(0.29177f, 1.3f, -0.69818f),new Vector3f(-0.287375f, 0.5f, -0.7f),new Vector2f(0.67965f, 0.6875f),new Vector2f(0.67965f, 0.8125f),new Vector2f(0.317684f, 0.8125f),new Vector2f(0.67965f, 0.3125f),new Vector3f(0.012572f, 0.0f, -3.99998f));
	}
	@Override
	public ObjMesh cloneTransformed(Matrix4f transform) {
		FlotationCellHull other = new FlotationCellHull();
		other.quads = cloneQuads(this.quads, transform);
		return other;
	}
}
