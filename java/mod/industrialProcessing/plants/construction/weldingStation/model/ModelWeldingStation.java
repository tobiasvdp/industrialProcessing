package mod.industrialProcessing.plants.construction.weldingStation.model;

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

public class ModelWeldingStation  extends ModelBlock {

    ObjRotator box = new ObjRotator(new Box(), 0);
    ObjRotator craftingBench = new ObjRotator(new CraftingBench(), 0);
    ObjRotator holder = new ObjRotator(new Holder(), 0);
    ObjRotator leftBar = new ObjRotator(new LeftBar(), 0);
    ObjRotator rightBar = new ObjRotator(new RightBar(), 0);
    ObjRotator top = new ObjRotator(new Top(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) { 
        Vector3f position = new Vector3f(0, 0, 0);
        
        IIcon iconWood = block.getIcon(0, 0);
        IIcon iconStone = block.getIcon(1, 0);
        IIcon iconIron = block.getIcon(2, 0);
        IIcon iconCraftingBench = block.getIcon(3, 0);

        box.getRotated(0).renderMesh(iconWood);
        craftingBench.getRotated(0).renderMesh(iconCraftingBench);
        holder.getRotated(0).renderMesh(iconIron);
        leftBar.getRotated(0).renderMesh(iconWood);
        rightBar.getRotated(0).renderMesh(iconWood);
        top.getRotated(0).renderMesh(iconStone);
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
        IIcon iconCraftingBench = reference.getIcon(3);

        box.getRotated(dir).renderMesh(false, iconWood, reference);
        craftingBench.getRotated(dir).renderMesh(false, iconCraftingBench, reference);
        holder.getRotated(dir).renderMesh(false, iconIron, reference);
        if(renderConnection != 1)
        	leftBar.getRotated(dir).renderMesh(false, iconWood, reference);
        rightBar.getRotated(dir).renderMesh(false, iconWood, reference);
        top.getRotated(dir).renderMesh(false, iconStone, reference);
        return true;
    }

}
