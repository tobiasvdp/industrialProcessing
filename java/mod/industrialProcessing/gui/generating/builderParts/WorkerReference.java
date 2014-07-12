package mod.industrialProcessing.gui.generating.builderParts;

import mod.industrialProcessing.gui.containers.handlers.WorkHandler;
import mod.industrialProcessing.gui.framework.rendering.TextureReference;

public class WorkerReference {

    public WorkerReference(TextureReference texture) {
	this.workerTexture = texture;
    }

    WorkHandler workerHandler;
    public TextureReference workerTexture;

}
