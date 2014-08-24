package mod.industrialProcessing.plants.middleAge.bloomery.dummy.ironBowl.model;

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

public class ModelIronBowl extends ModelBlock {

    ObjRotator bowl = new ObjRotator(new Bowl(), 0);
    ObjRotator rope = new ObjRotator(new Rope(), 0);
    ObjRotator support = new ObjRotator(new SupportBar(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) { 
        Vector3f position = new Vector3f(0, 0, 0);
        IIcon iconSupport = block.getIcon(0, 0);
        IIcon iconRope = block.getIcon(1, 0);
        IIcon iconBowl = block.getIcon(2, 0);

        bowl.getRotated(0).renderMesh(iconBowl);
        rope.getRotated(0).renderMesh(iconRope);
        support.getRotated(0).renderMesh(iconSupport);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockContainerIP.getForwardFromEntity(entity);
        int dir = BlockContainerIP.getMetadataFromForward(forward);

        IIcon iconSupport = reference.getIcon(0);
        IIcon iconRope = reference.getIcon(1);
        IIcon iconBowl = reference.getIcon(2);

        bowl.getRotated(dir).renderMesh(false, iconBowl, reference);
        rope.getRotated(dir).renderMesh(false, iconRope, reference);
        support.getRotated(dir).renderMesh(false, iconSupport, reference);
        return true;
    }

}
