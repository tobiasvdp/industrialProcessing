package mod.industrialProcessing.plants.todo.dummy.decoration.garageDoor.modelFrame;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class ModelGarageDoorFrame extends ModelBlock {

    ObjRotator box = new ObjRotator(new hull(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) { 
        Vector3f position = new Vector3f(0, 0, 0);
        Icon iconGarage = block.getIcon(0, 0);

        box.getRotated(0).renderMesh(iconGarage);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
        int dir = BlockMachine.getMetadataFromForward(forward);

        Icon iconGarage = reference.getIcon(0);

        box.getRotated(dir).renderMesh(false, iconGarage, reference);
        return true;
    }
}
