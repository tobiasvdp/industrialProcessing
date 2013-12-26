package ip.industrialProcessing.machines.plants.blacksmith.anvil.model;

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

public class ModelAnvil extends ModelBlock {

    ObjRotator hull = new ObjRotator(new Box002(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
        // TODO Auto-generated method stub
        int dir = 0;

        Vector3f position = new Vector3f(0, 0, 0);
        Icon iconHull = block.getIcon(0, 0);

        hull.getRotated(dir).renderMesh(iconHull);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        int dir = reference.getBlockMetadata();

        Icon iconHull = reference.getIcon(0);

        hull.getRotated(dir).renderMesh(false, iconHull, reference);
        return true;
    }
}
