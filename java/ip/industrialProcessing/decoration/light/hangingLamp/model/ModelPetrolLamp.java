package ip.industrialProcessing.decoration.light.hangingLamp.model;

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

public class ModelPetrolLamp extends ModelBlock {

    ObjRotator hanger = new ObjRotator(new Hanger(), 0);
    ObjRotator lantern = new ObjRotator(new Lantern(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
        // TODO Auto-generated method stub
        int dir = 0;

        Vector3f position = new Vector3f(0, 0, 0);
        Icon iconHanger = block.getIcon(0, 0);
        Icon iconLantern = block.getIcon(1, 0);

        hanger.getRotated(dir).renderMesh(iconHanger);
        lantern.getRotated(dir).renderMesh(iconLantern);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
        int dir = 4 - BlockMachine.getMetadataFromForward(forward);

        Icon iconHanger = reference.getIcon(0);
        Icon iconLantern = reference.getIcon(1);

        hanger.getRotated(dir).renderMesh(false, iconHanger, reference);
        lantern.getRotated(dir).renderMesh(false, iconLantern, reference);
        return true;
    }

}
