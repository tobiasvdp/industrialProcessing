package ip.industrialProcessing.tools;

public class ObjMeshFile {
	public String title= "ObjMeshItem";
	public String constructorBody = "";
	public int quadCount = 0;

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append("package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.atmosphericDestilationTower.model;\n\r");
		builder.append("import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;\n\r");
		builder.append("import ip.industrialProcessing.api.rendering.wavefront.ObjQuad;\n\r");
		builder.append("\n\r");
		builder.append("import org.lwjgl.util.vector.Matrix4f;\n\r");
		builder.append("import org.lwjgl.util.vector.Vector2f;\n\r");
		builder.append("import org.lwjgl.util.vector.Vector3f;\n\r");
		builder.append("public class " + title + " extends ObjMesh{\n\r");
		builder.append("	public " + title + "(){\n\r");
		builder.append("		this.quads = new ObjQuad[" + quadCount + "];\n\r");
		builder.append(constructorBody);
		builder.append("	}\n\r");

		builder.append("	@Override\n\r");
		builder.append("	public ObjMesh cloneTransformed(Matrix4f transform) {\n\r");
		builder.append("		" + title + " other = new " + title + "();\n\r");
		builder.append("		other.quads = cloneQuads(this.quads, transform);\n\r");
		builder.append("		return other;\n\r");
		builder.append("	}\n\r");
		builder.append("}\n\r");

		return builder.toString().replace("\r", "");
	}
}
