package mod.industrialProcessing.transport.items.conveyorBelt.rendering;

import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.Tessellator;

import org.lwjgl.opengl.GL11;

public abstract class ShapeRenderer {

	private int displayList;
	private boolean compiled;

	/**
	 * Compiles a GL display list for this model
	 */
	private void compileDisplayList(float par1) {
		this.displayList = GLAllocation.generateDisplayLists(1);
		GL11.glNewList(this.displayList, GL11.GL_COMPILE);
		Tessellator tessellator = Tessellator.instance;

		drawShape(par1);

		GL11.glEndList();
		this.compiled = true;
	}

	protected abstract void drawShape(float par1);

	public void render(float par1) {  
		
		if (!compiled) {
			compileDisplayList(par1);
		}

		GL11.glCallList(this.displayList);
	}
}
