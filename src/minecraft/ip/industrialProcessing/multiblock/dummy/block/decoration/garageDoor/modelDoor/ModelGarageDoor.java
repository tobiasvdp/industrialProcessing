package ip.industrialProcessing.multiblock.dummy.block.decoration.garageDoor.modelDoor;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class ModelGarageDoor  extends ModelBlock {

    ObjRotator box = new ObjRotator(new Box001(), 0);
    ObjRotator front = new ObjRotator(new Object001(), 0);
    ObjRotator back = new ObjRotator(new Object002(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) { 
        Vector3f position = new Vector3f(0, 0, 0);
        Icon iconGarage = block.getIcon(0, 0);

        box.getRotated(0).renderMesh(iconGarage);
        front.getRotated(0).renderMesh(iconGarage);
        back.getRotated(0).renderMesh(iconGarage);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
        int dir = BlockMachine.getMetadataFromForward(forward);

        Icon iconGarage = reference.getIcon(0);

        box.getRotated(dir).renderMesh(false, iconGarage, reference);
        front.getRotated(dir).renderMesh(false, iconGarage, reference);
        back.getRotated(dir).renderMesh(false, iconGarage, reference);
        return true;
    }

}
