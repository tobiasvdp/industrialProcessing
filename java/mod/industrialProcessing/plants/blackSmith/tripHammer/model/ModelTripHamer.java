package mod.industrialProcessing.plants.blackSmith.tripHammer.model;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.blockContainer.multiblock.core.TileEntityMultiblockCore;
import mod.industrialProcessing.client.rendering.block.ModelBlock;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjRotator;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.WorldReference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class ModelTripHamer  extends ModelBlock {

    ObjRotator foot = new ObjRotator(new Foot(), 0);
    ObjRotator wheelRing = new ObjRotator(new WheelRings(), 0);
    ObjRotator top = new ObjRotator(new Top(), 0);
    ObjRotator rot = new ObjRotator(new Rot(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) { 
        Vector3f position = new Vector3f(0, 0, 0);
        
        IIcon iconWood = block.getIcon(0, 0);
        
        GL11.glPushMatrix();
        GL11.glScalef(0.7f, 0.7f, 0.7f);
        GL11.glTranslatef(0, -0.5f, 0);
        
        foot.getRotated(0).renderMesh(iconWood);
        wheelRing.getRotated(0).renderMesh(iconWood);
        top.getRotated(0).renderMesh(iconWood);
        rot.getRotated(0).renderMesh(iconWood);
        
        GL11.glPopMatrix();
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockContainerIP.getForwardFromEntity(entity);
        int dir = BlockContainerIP.getMetadataFromForward(forward);
        int renderConnection = ((TileEntityMultiblockCore) entity).getModelConnection();
        
        IIcon iconWood = reference.getIcon(0);

        foot.getRotated(dir).renderMesh(false, iconWood, reference);
        wheelRing.getRotated(dir).renderMesh(false, iconWood, reference);
        top.getRotated(dir).renderMesh(false, iconWood, reference);
        rot.getRotated(dir).renderMesh(false, iconWood, reference);

        return true;
    }
}
