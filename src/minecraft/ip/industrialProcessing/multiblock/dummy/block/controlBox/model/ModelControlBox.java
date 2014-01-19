package ip.industrialProcessing.multiblock.dummy.block.controlBox.model;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.multiblock.dummy.block.destilationTray.model.DestillationConnectors;
import ip.industrialProcessing.multiblock.dummy.block.destilationTray.model.DestillationElementFeatures;
import ip.industrialProcessing.multiblock.dummy.block.destilationTray.model.DestillationElementHull;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class ModelControlBox  extends ModelBlock {

    ObjRotator hull = new ObjRotator(new Hull(), 0);
    ObjRotator sealing = new ObjRotator(new Sealing(), 0);
    ObjRotator button1 = new ObjRotator(new Button1(), 0);
    ObjRotator button2 = new ObjRotator(new Button2(), 0);
    ObjRotator button3 = new ObjRotator(new Button3(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) { 
        Vector3f position = new Vector3f(0, 0, 0);
        Icon iconHull = block.getIcon(0, 0);
        Icon iconSealing = block.getIcon(1, 0);
        Icon iconButton1 = block.getIcon(2, 0);
        Icon iconButton2 = block.getIcon(3, 0);
        Icon iconButton3 = block.getIcon(4, 0);

        hull.getRotated(0).renderMesh(iconHull);
        sealing.getRotated(0).renderMesh(iconSealing);
        button1.getRotated(0).renderMesh(iconButton1);
        button2.getRotated(0).renderMesh(iconButton2);
        button3.getRotated(0).renderMesh(iconButton3);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
        int dir = BlockMachine.getMetadataFromForward(forward);
        
        Icon iconHull = reference.getIcon(0);
        Icon iconSealing = reference.getIcon(1);
        Icon iconButton1 = reference.getIcon(2);
        Icon iconButton2 = reference.getIcon(3);
        Icon iconButton3 = reference.getIcon(4);

        hull.getRotated(dir).renderMesh(false, iconHull, reference);
        sealing.getRotated(dir).renderMesh(false, iconSealing, reference);
        button1.getRotated(dir).renderMesh(false, iconButton1, reference);
        button2.getRotated(dir).renderMesh(false, iconButton2, reference);
        button3.getRotated(dir).renderMesh(false, iconButton3, reference);

        return true;
    }

}
