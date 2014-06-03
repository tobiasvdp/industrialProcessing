package ip.industrialProcessing.machines.plants.storage.storageRack.model;

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

public class ModelStorageRack extends ModelBlock {

    ObjRotator bars = new ObjRotator(new Bars(), 0);
    ObjRotator frame = new ObjRotator(new Frame(), 0);
    ObjRotator rollers = new ObjRotator(new Rollers(), 0);
    ObjRotator box1 = new ObjRotator(new Box001(), 0);
    ObjRotator box2 = new ObjRotator(new Box002(), 0);
    ObjRotator box3 = new ObjRotator(new Box003(), 0);
    ObjRotator box4 = new ObjRotator(new Box004(), 0);
    ObjRotator box5 = new ObjRotator(new Box005(), 0);
    ObjRotator box6 = new ObjRotator(new Box006(), 0);
    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

        int dir = 0;

        Vector3f position = new Vector3f(0, 0, 0);
        Icon iconBars = block.getIcon(0, 0);
        Icon iconFrame = block.getIcon(1, 0);
        Icon iconRollers = block.getIcon(2, 0);
        Icon iconBox = block.getIcon(3, 0);

        bars.getRotated(dir).renderMesh(iconBars);
        frame.getRotated(dir).renderMesh(iconFrame);
        rollers.getRotated(dir).renderMesh(iconRollers);
        box1.getRotated(dir).renderMesh(iconBox);
        box2.getRotated(dir).renderMesh(iconBox);
        box3.getRotated(dir).renderMesh(iconBox);
        box4.getRotated(dir).renderMesh(iconBox);
        box5.getRotated(dir).renderMesh(iconBox);
        box6.getRotated(dir).renderMesh(iconBox); 
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
        int dir = 6-BlockMachine.getMetadataFromForward(forward);

        Icon iconBars = reference.getIcon(0);
        Icon iconFrame = reference.getIcon(1);
        Icon iconRollers = reference.getIcon(2);
        Icon iconBox = reference.getIcon(3);

        bars.getRotated(dir).renderMesh(false, iconBars, reference);
        frame.getRotated(dir).renderMesh(false, iconFrame, reference);
        rollers.getRotated(dir).renderMesh(false, iconRollers, reference); 
        
        return true;
    }
}
