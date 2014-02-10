package ip.industrialProcessing.subMod.blackSmith.plant.tripHammer.model;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.multiblock.core.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.core.block.weldingStation.model.Box;
import ip.industrialProcessing.multiblock.core.block.weldingStation.model.CraftingBench;
import ip.industrialProcessing.multiblock.core.block.weldingStation.model.Holder;
import ip.industrialProcessing.multiblock.core.block.weldingStation.model.LeftBar;
import ip.industrialProcessing.multiblock.core.block.weldingStation.model.RightBar;
import ip.industrialProcessing.multiblock.core.block.weldingStation.model.Top;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class ModelTripHamer  extends ModelBlock {

    ObjRotator foot = new ObjRotator(new Foot(), 0);
    ObjRotator rot = new ObjRotator(new Rot(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) { 
        Vector3f position = new Vector3f(0, 0, 0);
        
        Icon iconWood = block.getIcon(0, 0);
        
        GL11.glPushMatrix();
        GL11.glScalef(0.7f, 0.7f, 0.7f);
        GL11.glTranslatef(0, -0.5f, 0);
        
        foot.getRotated(0).renderMesh(iconWood);
        rot.getRotated(0).renderMesh(iconWood);
        
        GL11.glPopMatrix();
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
        int dir = BlockMachine.getMetadataFromForward(forward);
        int renderConnection = ((TileEntityMultiblockCore) entity).getModelConnection();
        
        Icon iconWood = reference.getIcon(0);

        foot.getRotated(dir).renderMesh(false, iconWood, reference);
        rot.getRotated(dir).renderMesh(false, iconWood, reference);

        return true;
    }
}
