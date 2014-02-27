package ip.industrialProcessing.subMod.blackSmith.plant.tripHammer.dummy.woodenHammer.model;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.multiblock.core.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.dummy.TileEntityMultiblockDummy;
import ip.industrialProcessing.subMod.blackSmith.plant.tripHammer.model.Foot;
import ip.industrialProcessing.subMod.blackSmith.plant.tripHammer.model.Rot;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class ModelWoodenHammer  extends ModelBlock {

    ObjRotator hammer = new ObjRotator(new Hammer(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) { 
        Vector3f position = new Vector3f(0, 0, 0);
        
        Icon iconWood = block.getIcon(0, 0);
        
        GL11.glPushMatrix();

        hammer.getRotated(0).renderMesh(iconWood);
        
        GL11.glPopMatrix();
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
        int dir = BlockMachine.getMetadataFromForward(forward);
        int renderConnection = ((TileEntityMultiblockDummy) entity).getModelConnection();
        
        Icon iconWood = reference.getIcon(0);

        hammer.getRotated(dir).renderMesh(false, iconWood, reference);

        return true;
    }
}