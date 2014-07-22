package mod.industrialProcessing.microBlock.rendering;

import javax.swing.Icon;

import net.minecraft.util.IIcon;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.WorldReference;
import mod.industrialProcessing.microBlock.extend.connectionCorners.IMicroBlockConnectionCorner;
import mod.industrialProcessing.utils.registry.MicroBlockIconRegistry;
import mod.industrialProcessing.utils.registry.MicroBlockModel;
import mod.industrialProcessing.utils.registry.MicroBlockModelRegistry;

public class RenderConnectionsMicroblock {

	public static void renderMicroBlockParts(WorldReference reference) {
		System.out.println(reference.world.getTileEntity(reference.x, reference.y, reference.z));
		if (reference.world.getTileEntity(reference.x, reference.y, reference.z) instanceof IMicroBlockConnectionCorner) {
			IMicroBlockConnectionCorner microBlock = (IMicroBlockConnectionCorner) reference.world.getTileEntity(reference.x, reference.y, reference.z);
			renderMicroblock(reference, microBlock);
		}
	}

	private static void renderMicroblock(WorldReference reference, IMicroBlockConnectionCorner microBlock) {
		int[] sides = microBlock.getSides();
		String iconName = "";
		IIcon icon = null;
		for (int i = 0; i < sides.length; i++) {
			if (sides[i] != -1) {
				MicroBlockModel model = MicroBlockModelRegistry.getModel(sides[i]);
				boolean[] innercon = microBlock.getInterConnections(i);
				boolean[] externCon = microBlock.getExternalConnections(i);
				boolean[] externConCor = microBlock.getExternalConnectionCorners(i);
				for (int j = 0; j < model.meshes[0].length; j++) {
					if (model.meshes[0][j][i] != null) {
						if (model.icons[0][j][i] != iconName) {
							icon = MicroBlockIconRegistry.getIcon(model.icons[0][j][i]);
							iconName = model.icons[0][j][i];
						}
						if (icon != null)
							model.meshes[0][j][i].renderMesh(false, icon, reference);
					}
				}
				for (int j = 0; j < innercon.length; j++) {
					if (innercon[j] || externCon[j]) {
						if (model.icons[1][i][j] != iconName) {
							icon = MicroBlockIconRegistry.getIcon(model.icons[1][i][j]);
							iconName = model.icons[1][i][j];
						}
						if (icon != null)
							model.meshes[1][i][j].renderMesh(false, icon, reference);
					}
					if (externConCor[j]) {
						if (model.icons[2][i][j] != iconName) {
							icon = MicroBlockIconRegistry.getIcon(model.icons[2][i][j]);
							iconName = model.icons[2][i][j];
						}
						if (model.meshes[2][i][j] != null && icon != null) {
							model.meshes[2][i][j].renderMesh(false, icon, reference);
						}
					}
				}
			}
		}
	}

}
