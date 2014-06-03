package mod.industrialProcessing.plants.todo.dummy.weldingTableExt.model;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.multiblock.dummy.TileEntityMultiblockDummy;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class ModelWeldingTable extends ModelBlock {

    ObjRotator box = new ObjRotator(new Box(), 0);
    ObjRotator chest= new ObjRotator(new Chest(), 0);
    ObjRotator holder = new ObjRotator(new Holder(), 0);
    ObjRotator leftBar = new ObjRotator(new LeftBar(), 0);
    ObjRotator rightBar = new ObjRotator(new RightBar(), 0);
    ObjRotator top = new ObjRotator(new Top(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) { 
        Vector3f position = new Vector3f(0, 0, 0);
        
        Icon iconWood = block.getIcon(0, 0);
        Icon iconStone = block.getIcon(1, 0);
        Icon iconIron = block.getIcon(2, 0);
        Icon iconCraftingBench = block.getIcon(3, 0);

        box.getRotated(0).renderMesh(iconWood);
        chest.getRotated(0).renderMesh(iconCraftingBench);
        holder.getRotated(0).renderMesh(iconIron);
        leftBar.getRotated(0).renderMesh(iconWood);
        rightBar.getRotated(0).renderMesh(iconWood);
        top.getRotated(0).renderMesh(iconStone);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
        int dir = BlockMachine.getMetadataFromForward(forward);
        int renderConnection = ((TileEntityMultiblockDummy) entity).getModelConnection();
        
        Icon iconWood = reference.getIcon(0);
        Icon iconStone = reference.getIcon(1);
        Icon iconIron = reference.getIcon(2);
        Icon iconCraftingBench = reference.getIcon(3);

        box.getRotated(dir).renderMesh(false, iconWood, reference);
        chest.getRotated(dir).renderMesh(false, iconCraftingBench, reference);
        holder.getRotated(dir).renderMesh(false, iconIron, reference);
        leftBar.getRotated(dir).renderMesh(false, iconWood, reference);
        if(renderConnection != 1)
        	rightBar.getRotated(dir).renderMesh(false, iconWood, reference);
        top.getRotated(dir).renderMesh(false, iconStone, reference);
        return true;
    }

}
