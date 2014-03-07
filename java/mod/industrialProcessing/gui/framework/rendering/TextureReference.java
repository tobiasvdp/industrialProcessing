package mod.industrialProcessing.gui.framework.rendering;

import mod.industrialProcessing.gui.framework.Size;
import mod.industrialProcessing.utils.INamepace;
import net.minecraft.util.ResourceLocation;

public class TextureReference {
    public Size size;
    public ResourceLocation resource;

    public TextureReference(Size size, String domain, String resource) {
	this.size = size;
	this.resource = new ResourceLocation(domain, resource);
    }

    public TextureReference(Size size, ResourceLocation resource) {
	this.size = size;
	this.resource = resource;
    }

    public static TextureReference createDefault(String filename, int width, int height) {
	return new TextureReference(new Size(width, height), INamepace.TEXTURE_DOMAIN, "textures/gui/" + filename);
    }
}
