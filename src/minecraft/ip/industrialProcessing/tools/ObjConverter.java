package ip.industrialProcessing.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class ObjConverter {

    public static void main(String[] args) {
	ObjConverter cv = new ObjConverter();
	try {
	    cv.parseObjFile("C:\\Users\\Stijn\\Documents\\3dsMax\\export\\floorTile.obj");
	    // cv.parseObjFile("C:\\Users\\Tobias\\Documents\\3dsMax\\export\\IronPole.obj");
	} catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    // Tokens for parsing.
    private final static String OBJ_VERTEX_TEXTURE = "vt";
    private final static String OBJ_VERTEX_NORMAL = "vn";
    private final static String OBJ_VERTEX = "v";
    private final static String OBJ_FACE = "f";
    private final static String OBJ_GROUP_NAME = "g";
    private final static String OBJ_OBJECT_NAME = "o";
    private final static String OBJ_SMOOTHING_GROUP = "s";
    private final static String OBJ_POINT = "p";
    private final static String OBJ_LINE = "l";
    private final static String OBJ_MAPLIB = "maplib";
    private final static String OBJ_USEMAP = "maplib";
    private final static String OBJ_MTLLIB = "mtllib";
    private final static String OBJ_USEMTL = "usemtl";
    File objFile = null;

    ObjMeshFile file = null;
    ArrayList<Vector3f> pos = new ArrayList<Vector3f>();
    ArrayList<Vector3f> normal = new ArrayList<Vector3f>();
    ArrayList<Vector2f> uv = new ArrayList<Vector2f>();
    private String group;
    private int index;

    private void parseObjFile(String objFilename) throws FileNotFoundException, IOException {
	int lineCount = 0;
	FileReader fileReader = null;
	BufferedReader bufferedReader = null;

	objFile = new File(objFilename);
	fileReader = new FileReader(objFile);
	bufferedReader = new BufferedReader(fileReader);

	String line = null;

	while (true) {
	    line = bufferedReader.readLine();
	    if (null == line) {
		break;
	    }

	    line = line.trim();

	    if (line.length() == 0) {
		continue;
	    }

	    // NOTE: we don't check for the space after the char
	    // because sometimes it's not there - most notably in the
	    // grouupname, we seem to get a lot of times where we have
	    // "g\n", i.e. setting the group name to blank (or
	    // default?)
	    if (line.startsWith("#")) // comment
	    {
		continue;
	    } else if (line.startsWith(OBJ_VERTEX_TEXTURE)) {
		processVertexTexture(line);
	    } else if (line.startsWith(OBJ_VERTEX_NORMAL)) {
		processVertexNormal(line);
	    } else if (line.startsWith(OBJ_VERTEX)) {
		processVertex(line);
	    } else if (line.startsWith(OBJ_FACE)) {
		processFace(line);
	    } else if (line.startsWith(OBJ_GROUP_NAME)) {
		processGroupName(line);
	    } else {
	    }
	    lineCount++;
	}
	bufferedReader.close();

	processGroupName("g ");
    }

    // @TODO: processVertex calls parseFloatList with params expecting
    // only three floats on the line. If there are more than three
    // floats in line then any extra values will be ignored by
    // parseFloatList. For the 'v' (geometric vertex) lines, there
    // may be three values (x,y,z) or there may be four (x,y,z and w
    // i.e. weight). Currently we're ignoring w if it is present.
    //
    // ------------------------------------------------------
    // From the wavefront OBJ file spec;
    // ------------------------------------------------------
    //
    // > v x y z w
    // >
    // > Polygonal and free-form geometry statement.
    // >
    // > Specifies a geometric vertex and its x y z coordinates. Rational
    // > curves and surfaces require a fourth homogeneous coordinate, also
    // > called the weight.
    // >
    // > x y z are the x, y, and z coordinates for the vertex. These are
    // > floating point numbers that define the position of the vertex in
    // > three dimensions.
    // >
    // > w is the weight required for rational curves and surfaces. It is
    // > not required for non-rational curves and surfaces. If you do not
    // > specify a value for w, the default is 1.0.
    // >
    // > NOTE: A positive weight value is recommended. Using zero or
    // > negative values may result in an undefined point in a curve or
    // > surface.
    private void processVertex(String line) {
	float[] values = StringUtils.parseFloatList(3, line, OBJ_VERTEX.length());
	pos.add(new Vector3f(values[0], values[1], values[2]));
    }

    // ------------------------------------------------------
    // From the wavefront OBJ file spec;
    // ------------------------------------------------------
    //
    // vt u v w
    //
    // Vertex statement for both polygonal and free-form geometry.
    //
    // Specifies a texture vertex and its coordinates. A 1D texture
    // requires only u texture coordinates, a 2D texture requires both u
    // and v texture coordinates, and a 3D texture requires all three
    // coordinates.
    //
    // u is the value for the horizontal direction of the texture.
    //
    // v is an optional argument.
    //
    // v is the value for the vertical direction of the texture. The
    // default is 0.
    //
    // w is an optional argument.
    //
    // w is a value for the depth of the texture. The default is 0.
    private void processVertexTexture(String line) {
	float[] values = StringUtils.parseFloatList(2, line, OBJ_VERTEX_TEXTURE.length());
	this.uv.add(new Vector2f(values[0], values[1]));
    }

    // ------------------------------------------------------
    // From the wavefront OBJ file spec;
    // ------------------------------------------------------
    //
    // vt u v w
    //
    // Vertex statement for both polygonal and free-form geometry.
    //
    // Specifies a texture vertex and its coordinates. A 1D texture
    // requires only u texture coordinates, a 2D texture requires both u
    // and v texture coordinates, and a 3D texture requires all three
    // coordinates.
    //
    // u is the value for the horizontal direction of the texture.
    //
    // v is an optional argument.
    //
    // v is the value for the vertical direction of the texture. The
    // default is 0.
    //
    // w is an optional argument.
    //
    // w is a value for the depth of the texture. The default is 0.
    private void processVertexNormal(String line) {
	float[] values = StringUtils.parseFloatList(3, line, OBJ_VERTEX_NORMAL.length());
	this.normal.add(new Vector3f(values[0], values[1], values[2]));
    }

    // ------------------------------------------------------
    // From the wavefront OBJ file spec;
    // ------------------------------------------------------
    //
    // Referencing groups of vertices
    //
    // Some elements, such as faces and surfaces, may have a triplet of
    // numbers that reference vertex data.These numbers are the reference
    // numbers for a geometric vertex, a texture vertex, and a vertex normal.
    //
    // Each triplet of numbers specifies a geometric vertex, texture vertex,
    // and vertex normal. The reference numbers must be in order and must
    // separated by slashes (/).
    //
    // o The first reference number is the geometric vertex.
    //
    // o The second reference number is the texture vertex. It follows
    // the first slash.
    //
    // o The third reference number is the vertex normal. It follows the
    // second slash.
    //
    // There is no space between numbers and the slashes. There may be more
    // than one series of geometric vertex/texture vertex/vertex normal
    // numbers on a line.
    //
    // The following is a portion of a sample file for a four-sided face
    // element:
    //
    // f 1/1/1 2/2/2 3/3/3 4/4/4
    //
    // Using v, vt, and vn to represent geometric vertices, texture vertices,
    // and vertex normals, the statement would read:
    //
    // f v/vt/vn v/vt/vn v/vt/vn v/vt/vn
    //
    // If there are only vertices and vertex normals for a face element (no
    // texture vertices), you would enter two slashes (//). For example, to
    // specify only the vertex and vertex normal reference numbers, you would
    // enter:
    //
    // f 1//1 2//2 3//3 4//4
    //
    // When you are using a series of triplets, you must be consistent in the
    // way you reference the vertex data. For example, it is illegal to give
    // vertex normals for some vertices, but not all.
    //
    // The following is an example of an illegal statement.
    //
    // f 1/1/1 2/2/2 3//3 4//4
    //
    // ...
    //
    // f v1/vt1/vn1 v2/vt2/vn2 v3/vt3/vn3 . . .
    //
    // Polygonal geometry statement.
    //
    // Specifies a face element and its vertex reference number. You can
    // optionally include the texture vertex and vertex normal reference
    // numbers.
    //
    // The reference numbers for the vertices, texture vertices, and
    // vertex normals must be separated by slashes (/). There is no space
    // between the number and the slash.
    //
    // v is the reference number for a vertex in the face element. A
    // minimum of three vertices are required.
    //
    // vt is an optional argument.
    //
    // vt is the reference number for a texture vertex in the face
    // element. It always follows the first slash.
    //
    // vn is an optional argument.
    //
    // vn is the reference number for a vertex normal in the face element.
    // It must always follow the second slash.
    //
    // Face elements use surface normals to indicate their orientation. If
    // vertices are ordered counterclockwise around the face, both the
    // face and the normal will point toward the viewer. If the vertex
    // ordering is clockwise, both will point away from the viewer. If
    // vertex normals are assigned, they should point in the general
    // direction of the surface normal, otherwise unpredictable results
    // may occur.
    //
    // If a face has a texture map assigned to it and no texture vertices
    // are assigned in the f statement, the texture map is ignored when
    // the element is rendered.
    //
    // NOTE: Any references to fo (face outline) are no longer valid as of
    // version 2.11. You can use f (face) to get the same results.
    // References to fo in existing .obj files will still be read,
    // however, they will be written out as f when the file is saved.
    private void processFace(String line) {
	line = line.substring(OBJ_FACE.length()).trim();
	int[] verticeIndexAry = StringUtils.parseListVerticeNTuples(line, 3);
	int loopi = 0;

	this.file.constructorBody += "		this.quads[" + index++ + "] = new ObjQuad(";
	while (loopi < verticeIndexAry.length) {
	    Vector3f v = pos.get(getIndex(verticeIndexAry[loopi], pos.size()));
	    this.file.constructorBody += ("new Vector3f(" + v.x + "f, " + v.y + "f, " + v.z + "f),");
	    loopi += 3;
	}
	loopi = 0;
	while (loopi < verticeIndexAry.length) {
	    Vector2f v = uv.get(getIndex(verticeIndexAry[loopi + 1], uv.size()));
	    this.file.constructorBody += ("new Vector2f(" + v.x + "f, " + v.y + "f),");
	    loopi += 3;
	}
	Vector3f nl = new Vector3f(0, 0, 0);
	loopi = 0;
	while (loopi < verticeIndexAry.length) {
	    Vector3f v = this.normal.get(getIndex(verticeIndexAry[loopi + 2], this.normal.size()));
	    nl = Vector3f.add(nl, v, nl);
	    loopi += 3;
	}
	this.file.constructorBody += ("new Vector3f(" + nl.x + "f, " + nl.y + "f, " + nl.z + "f));\n\r");
	this.file.quadCount++;
	// builder.addFace(verticeIndexAry);
    }

    private int getIndex(int i, int size) {
	return i < 0 ? size + i : i - 1;
    }

    // ------------------------------------------------------
    // From the wavefront OBJ file spec;
    // ------------------------------------------------------
    //
    // o object_name
    //
    // Polygonal and free-form geometry statement.
    //
    // Optional statement; it is not processed by any Wavefront programs.
    // It specifies a user-defined object name for the elements defined
    // after this statement.
    //
    // object_name is the user-defined object name. There is no default.
    private void processGroupName(String line) {
		if (file != null) {
			System.out.println("Processed "+file.title);
			FileWriter outFile;
			try {
				//Stijn Laptop: outFile = new FileWriter("C:\\MinecraftForge\\Minecraft\\forge\\mcp\\src\\minecraft\\ip\\industrialProcessing\\machines\\diskFilter\\model\\"+file.title + ".java");
				//Stijn Desktop: outFile = new FileWriter("D:\\Minecraft\\forge\\mcp\\src\\minecraft\\ip\\industrialProcessing\\machines\\flotationCell\\model\\"+file.title + ".java");
				//outFile = new FileWriter("C:\\IndustrialProcessing\\forge\\mcp\\src\\minecraft\\ip\\industrialProcessing\\multiblock\\dummy\\block\\ironPole\\model\\"+file.title + ".java");
				outFile = new FileWriter("C:\\MinecraftForge\\Minecraft\\forge\\mcp\\src\\minecraft\\ip\\industrialProcessing\\machines\\kiln\\model\\"+file.title + ".java");
				PrintWriter out = new PrintWriter(outFile);
				out.print(file.toString());
				out.close();
				outFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		this.group = (line.substring(OBJ_OBJECT_NAME.length()).trim());
		this.index = 0;
		file = new ObjMeshFile();
		file.title = this.group;
	}
}
