package ip.industrialProcessing.gui3.framework.rendering;

import net.minecraft.util.ResourceLocation;
import ip.industrialProcessing.gui3.framework.Size;

public class TextureReference {
    public Size size;
    public ResourceLocation resource;

    public TextureReference(Size size, String domain, String resource) {
	this.size = size;
	this.resource = new ResourceLocation(domain, resource);
    }
    
    public TextureReference(Size size, ResourceLocation resource)
    {
	this.size = size;
	this.resource = resource;
    }
}
