package ip.industrialProcessing.decoration.trees;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigBlocks;
import ip.industrialProcessing.config.INamepace;

public class IndustrialTrees {

    private static String[] names = new String[] { "Rubber", "Pine" };
    private static String[] textures = new String[] { "rubber", "pine" };
    private static int[] colors = new int[] { 0xffffff, 0x4e6904 };
    private static float[] slopes = new float[] { 1.5f, 2.5f };
    private static int[] minHeight = new int[] { 3, 5 };
    private static int[] maxHeight = new int[] { 8, 15 };

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
        return INamepace.TEXTURE_NAME_PREFIX + textures[index] + "_log_top";
    }

    public static String getLogSideTexture(int index) {
        index %= textures.length;
        return INamepace.TEXTURE_NAME_PREFIX + textures[index] + "_log_side";
    }

    public static String getSpecialLogSideTexture(int index, String special) {
        index %= textures.length;
        return INamepace.TEXTURE_NAME_PREFIX + textures[index] + "_" + special + "_log_side";
    }

    public static int getLeavesID(int par1) {
        return ConfigBlocks.getLeavesID();
    }

    public static int getTreeCount() {
        return names.length;
    }

    public static String getSaplingTexture(int index) {
        index %= textures.length;
        return INamepace.TEXTURE_NAME_PREFIX + textures[index] + "_sapling";
    }

    public static String getLeavesTexture(int index, boolean opaque) {
        index %= textures.length;
        return INamepace.TEXTURE_NAME_PREFIX + textures[index] + "_leaves" + (opaque ? "_opaque" : "");
    }

    public static float getSlope(int meta) {
        meta %= textures.length;
        return slopes[meta];
    }

    public static int getMinHeight(int meta) {
        meta %= textures.length;
        return minHeight[meta];
    }

    public static int getMaxHeight(int meta) {
        meta %= textures.length;
        return maxHeight[meta];
    }
}
