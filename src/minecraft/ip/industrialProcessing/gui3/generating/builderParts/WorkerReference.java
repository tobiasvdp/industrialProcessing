package ip.industrialProcessing.gui3.generating.builderParts;

import ip.industrialProcessing.gui3.containers.handlers.WorkHandler;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;

public class WorkerReference {

    public WorkerReference(TextureReference texture) {
	this.workerTexture = texture;
    }

    WorkHandler workerHandler;
    public TextureReference workerTexture;

}
