package mod.industrialProcessing.plants.todo.core.SolderingStation.model;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.multiblock.core.TileEntityMultiblockCore;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class ModelSolderingStation  extends ModelBlock {

    ObjRotator base = new ObjRotator(new Base(), 0);
    ObjRotator box = new ObjRotator(new Box(), 0);
    ObjRotator leftbar = new ObjRotator(new LeftBar(), 0);
    ObjRotator rightbar = new ObjRotator(new RightBar(), 0);
    ObjRotator plate = new ObjRotator(new Plate(), 0);
    ObjRotator sponge = new ObjRotator(new Sponge(), 0);
    ObjRotator stand = new ObjRotator(new Stand(), 0);
    ObjRotator top = new ObjRotator(new Top(), 0);
    ObjRotator tube = new ObjRotator(new Tube(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) { 
        Vector3f position = new Vector3f(0, 0, 0);
        
        Icon iconWood = block.getIcon(0, 0);
        Icon iconStone = block.getIcon(1, 0);
        Icon iconIron = block.getIcon(2, 0);
        Icon iconSponge = block.getIcon(3, 0);
        Icon iconPlate = block.getIcon(4, 0);

        base.getRotated(0).renderMesh(iconStone);
        box.getRotated(0).renderMesh(iconWood);
        leftbar.getRotated(0).renderMesh(iconWood);
        rightbar.getRotated(0).renderMesh(iconWood);
        plate.getRotated(0).renderMesh(iconPlate);
        sponge.getRotated(0).renderMesh(iconSponge);
        stand.getRotated(0).renderMesh(iconIron);
        top.getRotated(0).renderMesh(iconStone);
        tube.getRotated(0).renderMesh(iconIron);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
        int dir = BlockMachine.getMetadataFromForward(forward);
        int renderConnection = ((TileEntityMultiblockCore) entity).getModelConnection();      
        
        Icon iconWood = reference.getIcon(0);
        Icon iconStone = reference.getIcon(1);
        Icon iconIron = reference.getIcon(2);
        Icon iconSponge = reference.getIcon(3);
        Icon iconPlate = reference.getIcon(4);

        base.getRotated(dir).renderMesh(false,iconStone, reference);
        box.getRotated(dir).renderMesh(false,iconWood, reference);
        plate.getRotated(dir).renderMesh(false,iconPlate, reference);
        sponge.getRotated(dir).renderMesh(false,iconSponge, reference);
        stand.getRotated(dir).renderMesh(false,iconIron, reference);
        tube.getRotated(dir).renderMesh(false,iconIron, reference);
        if(renderConnection != 1)
        	leftbar.getRotated(dir).renderMesh(false, iconWood, reference);
        rightbar.getRotated(dir).renderMesh(false, iconWood, reference);
        top.getRotated(dir).renderMesh(false, iconStone, reference);
        return true;
    }
}
