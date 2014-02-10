package ip.industrialProcessing.subMod.blackSmith.plant.bloomery.dummy.ironBowl.model;

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

public class ModelIronBowl extends ModelBlock {

    ObjRotator bowl = new ObjRotator(new Bowl(), 0);
    ObjRotator rope = new ObjRotator(new Rope(), 0);
    ObjRotator support = new ObjRotator(new SupportBar(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) { 
        Vector3f position = new Vector3f(0, 0, 0);
        Icon iconSupport = block.getIcon(0, 0);
        Icon iconRope = block.getIcon(1, 0);
        Icon iconBowl = block.getIcon(2, 0);

        bowl.getRotated(0).renderMesh(iconBowl);
        rope.getRotated(0).renderMesh(iconRope);
        support.getRotated(0).renderMesh(iconSupport);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
        int dir = BlockMachine.getMetadataFromForward(forward);

        Icon iconSupport = reference.getIcon(0);
        Icon iconRope = reference.getIcon(1);
        Icon iconBowl = reference.getIcon(2);

        bowl.getRotated(dir).renderMesh(false, iconBowl, reference);
        rope.getRotated(dir).renderMesh(false, iconRope, reference);
        support.getRotated(dir).renderMesh(false, iconSupport, reference);
        return true;
    }

}
