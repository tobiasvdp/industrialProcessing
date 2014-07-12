package ip.industrialProcessing.machines.plants.storage.storageBox.model;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class ModelStorageBox extends ModelBlock {

    ObjRotator box2 = new ObjRotator(new Box002(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

        int dir = 0;

        Vector3f position = new Vector3f(0, 0, 0);
        Icon iconBox = block.getIcon(0, 0);

        GL11.glPushMatrix();
        
        GL11.glScalef(1.5f, 1.5f, 1.5f);
        GL11.glTranslatef(0f, 0.3f, 0f);
        
        box2.getRotated(dir).renderMesh(iconBox);
        
        GL11.glPopMatrix();
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
        int dir = 6-BlockMachine.getMetadataFromForward(forward);

        Icon iconBox = reference.getIcon(0);

        box2.getRotated(dir).renderMesh(false, iconBox, reference);

        
        return true;
    }
}
