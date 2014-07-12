package mod.industrialProcessing.plants.construction.solderingStation.model;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.blockContainer.multiblock.core.TileEntityMultiblockCore;
import mod.industrialProcessing.client.rendering.block.ModelBlock;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjRotator;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.WorldReference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
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
        
        IIcon iconWood = block.getIcon(0, 0);
        IIcon iconStone = block.getIcon(1, 0);
        IIcon iconIron = block.getIcon(2, 0);
        IIcon iconSponge = block.getIcon(3, 0);
        IIcon iconPlate = block.getIcon(4, 0);

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
        ForgeDirection forward = BlockContainerIP.getForwardFromEntity(entity);
        int dir = BlockContainerIP.getMetadataFromForward(forward);
        int renderConnection = ((TileEntityMultiblockCore) entity).getModelConnection();      
        
        IIcon iconWood = reference.getIcon(0);
        IIcon iconStone = reference.getIcon(1);
        IIcon iconIron = reference.getIcon(2);
        IIcon iconSponge = reference.getIcon(3);
        IIcon iconPlate = reference.getIcon(4);

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
