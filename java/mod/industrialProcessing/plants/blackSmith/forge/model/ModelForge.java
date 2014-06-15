package mod.industrialProcessing.plants.blackSmith.forge.model;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.blockContainer.multiblock.coreAndDummy.ITileEntityMultiblockSwitcher;
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

public class ModelForge extends ModelBlock {

    ObjRotator obj1 = new ObjRotator(new Object001(), 0);
    ObjRotator obj2 = new ObjRotator(new Object002(), 0);
    ObjRotator obj3 = new ObjRotator(new Object003(), 0);
    ObjRotator obj4 = new ObjRotator(new Object004(), 0);
    ObjRotator obj5 = new ObjRotator(new Object005(), 0);
    ObjRotator obj6 = new ObjRotator(new Object006(), 0);
    ObjRotator obj7 = new ObjRotator(new Object007(), 0);
    ObjRotator obj8 = new ObjRotator(new Object008(), 0);
    ObjRotator obj9 = new ObjRotator(new Object009(), 0);
    ObjRotator obj10 = new ObjRotator(new Object010(), 0);
    ObjRotator obj11 = new ObjRotator(new Object011(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) { 
        Vector3f position = new Vector3f(0, 0, 0);
        
        IIcon iconWood = block.getIcon(0, 0);
        
        GL11.glPushMatrix();
        GL11.glScalef(0.35f, 0.35f, 0.35f);
        GL11.glTranslatef(0, -1f, 0);
        
        obj11.getRotated(0).renderMesh(iconWood);
        GL11.glTranslatef(1f, 0f, 0);
        obj11.getRotated(0).renderMesh(iconWood);
        GL11.glTranslatef(-2f, 0f, 0);
        obj11.getRotated(0).renderMesh(iconWood);
        
        GL11.glTranslatef(0f, 1f, 0);
        obj2.getRotated(0).renderMesh(iconWood);
        GL11.glTranslatef(2f, 0f, 0);
        obj1.getRotated(0).renderMesh(iconWood);
        
        GL11.glTranslatef(0f, 1f, 0);
        obj6.getRotated(0).renderMesh(iconWood);
        GL11.glTranslatef(-1f, 0f, 0);
        obj3.getRotated(0).renderMesh(iconWood);
        GL11.glTranslatef(-1f, 0f, 0);
        obj5.getRotated(0).renderMesh(iconWood);
        GL11.glTranslatef(1f, -2f, -1);
        
        obj11.getRotated(0).renderMesh(iconWood);
        GL11.glTranslatef(1f, 0f, 0);
        obj11.getRotated(0).renderMesh(iconWood);
        GL11.glTranslatef(-2f, 0f, 0);
        obj11.getRotated(0).renderMesh(iconWood);
        
        GL11.glTranslatef(0f, 1f, 0);
        obj4.getRotated(0).renderMesh(iconWood);
        GL11.glTranslatef(1f, 0f, 0);
        obj9.getRotated(0).renderMesh(iconWood);
        GL11.glTranslatef(1f, 0f, 0);
        obj10.getRotated(0).renderMesh(iconWood);
        
        GL11.glTranslatef(0f, 1f, 0);
        
        obj7.getRotated(0).renderMesh(iconWood);
        GL11.glTranslatef(-1f, 0f, 0);
        obj11.getRotated(0).renderMesh(iconWood);
        GL11.glTranslatef(-1f, 0f, 0);
        obj8.getRotated(0).renderMesh(iconWood);
        
        
        GL11.glPopMatrix();
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockContainerIP.getForwardFromEntity(entity);
        int dir = BlockContainerIP.getMetadataFromForward(forward);
        int renderConnection = ((ITileEntityMultiblockSwitcher) entity).getModelConnection();
        
        IIcon iconWood = reference.getIcon(0);
        
        switch(renderConnection){
        case 0:
        	obj11.getRotated(dir).renderMesh(false, iconWood, reference);
        	break;
        case 1:
        	obj2.getRotated(dir).renderMesh(false, iconWood, reference);
        	break;
        case 2:
        	obj1.getRotated(dir).renderMesh(false, iconWood, reference);
        	break;
        case 3:
        	obj3.getRotated(dir).renderMesh(false, iconWood, reference);
        	break;
        case 4:
        	obj5.getRotated(dir).renderMesh(false, iconWood, reference);
        	break;
        case 5:
        	obj6.getRotated(dir).renderMesh(false, iconWood, reference);
        	break;
        case 6:
        	obj9.getRotated(dir).renderMesh(false, iconWood, reference);
        	break;
        case 7:
        	obj4.getRotated(dir).renderMesh(false, iconWood, reference);
        	break;
        case 8:
        	obj10.getRotated(dir).renderMesh(false, iconWood, reference);
        	break;
        case 9:
        	obj8.getRotated(dir).renderMesh(false, iconWood, reference);
        	break;
        case 10:
        	obj7.getRotated(dir).renderMesh(false, iconWood, reference);
        	break;
        }
        return true;
    }
}