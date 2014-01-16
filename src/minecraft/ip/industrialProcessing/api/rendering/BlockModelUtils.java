package ip.industrialProcessing.api.rendering;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class BlockModelUtils {

    public static void getStoneSubBlocks(int par1, net.minecraft.creativetab.CreativeTabs par2CreativeTabs, List par3List) {
        par3List.add(new ItemStack(par1, 1, 0)); // smoothstone
        par3List.add(new ItemStack(par1, 1, 1)); // cobblestone
        par3List.add(new ItemStack(par1, 1, 2)); // mossy cobblestone
        par3List.add(new ItemStack(par1, 1, 3)); // stone brick
        par3List.add(new ItemStack(par1, 1, 4)); // mossy stone brick
        par3List.add(new ItemStack(par1, 1, 5)); // cracked stone brick
        par3List.add(new ItemStack(par1, 1, 6)); // carved stone brick
        par3List.add(new ItemStack(par1, 1, 7)); // clay brick
        par3List.add(new ItemStack(par1, 1, 8)); // quartz block
        par3List.add(new ItemStack(par1, 1, 9)); // quartz pillar
        par3List.add(new ItemStack(par1, 1, 10)); // chiseled quartz
    };

    public static void getWoodSubBlocks(int par1, net.minecraft.creativetab.CreativeTabs par2CreativeTabs, List par3List) {
        par3List.add(new ItemStack(par1, 1, 0)); // spruce
        par3List.add(new ItemStack(par1, 1, 1)); // oak
        par3List.add(new ItemStack(par1, 1, 2)); // birch
        par3List.add(new ItemStack(par1, 1, 3)); // jungle
    };

    public static Icon getEmbeddedWoodIcon(Block block, int meta) {
        return Block.planks.getIcon(0, meta);
    }

    public static Icon getEmbeddedStoneIcon(Block block, int meta) {
        switch (meta) {
        case 0:
            return Block.stone.getIcon(0, 0);
        case 1:
            return Block.cobblestone.getIcon(0, 0);
        case 2:
            return Block.cobblestoneMossy.getIcon(0, 0);
        case 3:
            return Block.stoneBrick.getIcon(0, 0);
        case 4:
            return Block.stoneBrick.getIcon(0, 1);
        case 5:
            return Block.stoneBrick.getIcon(0, 2);
        case 6:
            return Block.stoneBrick.getIcon(0, 3);
        case 7:
            return Block.brick.getIcon(0, 0);
        case 8:
            return Block.blockNetherQuartz.getIcon(0, 0);
        case 9:
            return Block.blockNetherQuartz.getIcon(0, 1);
        case 10:
            return Block.blockNetherQuartz.getIcon(0, 2);
        default:
            return null;
        } 
    }
}
