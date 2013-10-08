package ip.industrialProcessing.decoration.trees;

import javax.print.DocFlavor.STRING;

import net.minecraft.util.Icon;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigBlocks;

public class IndustrialTrees {

    private static String[] names = new String[] { "Rubber" };
    private static String[] textures = new String[] { "rubber" };
    private static int[] colors = new int[] { 0xff0000, 0x4e6904 };

    public static String getName(int index) {
	index %= names.length;
	return names[index];
    }

    public static int getColor(int index) {
	index %= colors.length;
	return colors[index];
    }

    public static String getLogTopTexture(int index) {
	index %= textures.length;
	return IndustrialProcessing.TEXTURE_NAME_PREFIX + textures[index] + "_log_top";
    }

    public static String getLogSideTexture(int index) {
	index %= textures.length;
	return IndustrialProcessing.TEXTURE_NAME_PREFIX + textures[index] + "_log_side";
    }

    public static int getLeavesID(int par1) { 
	return ConfigBlocks.getLeavesID();
    }

    public static int getTreeCount() {
	return names.length;
    }

    public static String getSaplingTexture(int index) {
	index %= textures.length;
	return IndustrialProcessing.TEXTURE_NAME_PREFIX + textures[index] + "_sapling";
    }

    public static String getLeavesTexture(int index, boolean opaque) {
	index %= textures.length;
	return IndustrialProcessing.TEXTURE_NAME_PREFIX + textures[index] + "_leaves" + (opaque ? "_opaque" : "");
    }
}
