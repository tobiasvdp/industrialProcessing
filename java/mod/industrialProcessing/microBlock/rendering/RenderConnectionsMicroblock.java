package ip.industrialProcessing.microBlock.rendering;

import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.microBlock.extend.connectionCorners.IMicroBlockConnectionCorner;
import ip.industrialProcessing.utils.registry.MicroBlockIconRegistry;
import ip.industrialProcessing.utils.registry.MicroBlockModel;
import ip.industrialProcessing.utils.registry.MicroBlockModelRegistry;

import javax.swing.Icon;

public class RenderConnectionsMicroblock {

	public static void renderMicroBlockParts(WorldReference reference) {
		IMicroBlockConnectionCorner microBlock = (IMicroBlockConnectionCorner) reference.world.getBlockTileEntity(reference.x, reference.y, reference.z);
		renderMicroblock(reference, microBlock);
	}

	private static void renderMicroblock(WorldReference reference, IMicroBlockConnectionCorner microBlock) {
		int[] sides = microBlock.getSides();
		String iconName = "";
		Icon icon = null;
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
