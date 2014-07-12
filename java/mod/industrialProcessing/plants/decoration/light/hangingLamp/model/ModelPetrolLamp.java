package mod.industrialProcessing.plants.decoration.light.hangingLamp.model;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.client.rendering.block.ModelBlock;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjRotator;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.WorldReference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class ModelPetrolLamp extends ModelBlock {

    ObjRotator hanger = new ObjRotator(new Hanger(), 0);
    ObjRotator lantern = new ObjRotator(new Lantern(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
        // TODO Auto-generated method stub
        int dir = 0;

        Vector3f position = new Vector3f(0, 0, 0);
        IIcon iconHanger = block.getIcon(0, 0);
        IIcon iconLantern = block.getIcon(1, 0);

        hanger.getRotated(dir).renderMesh(iconHanger);
        lantern.getRotated(dir).renderMesh(iconLantern);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockContainerIP.getForwardFromEntity(entity);
        int dir = 4 - BlockContainerIP.getMetadataFromForward(forward);

        IIcon iconHanger = reference.getIcon(0);
        IIcon iconLantern = reference.getIcon(1);

        hanger.getRotated(dir).renderMesh(false, iconHanger, reference);
        lantern.getRotated(dir).renderMesh(false, iconLantern, reference);
        return true;
    }

}
