package mod.industrialProcessing.plants.transport.conveyorChute.model;

import javax.swing.Icon;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.blockContainer.transport.ConnectionState;
import mod.industrialProcessing.client.rendering.block.ModelBlock;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjRotator;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.WorldReference;
import mod.industrialProcessing.transport.items.conveyorBelt.tileEntity.TileEntityConveyorConnectionsBase;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class ModelConveyorChuteBlock extends ModelBlock {

    Chute chute = new Chute();
    ChuteConnectors chuteConnctors = new ChuteConnectors();
    ObjRotator chuteConveyorSide = new ObjRotator(new ChuteConveyorSide(), 1);
    ObjRotator chuteConveyorSideOutput = new ObjRotator(new ChuteConveyorSideOutput(), 1);

    ObjRotator chuteSideOutput = new ObjRotator(new ChuteSideOutput(), 3);
    ObjRotator SideOutputConnector = new ObjRotator(new ChuteSideOutputConnector(), 3);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
        Vector3f position = new Vector3f(0, 0, 0);
        IIcon iconChute = block.getIcon(2, 0);
        IIcon iconConnector = block.getIcon(1, 0);

        chute.renderMesh(iconChute);
        chuteConnctors.renderMesh(iconConnector);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {
        Tessellator tessellator = Tessellator.instance;
        tessellator.setColorOpaque(255, 255, 255);

        TileEntity entity = reference.getBlockTileEntity();
        IIcon iconChute = reference.getIcon(2);
        IIcon iconConnectors = reference.getIcon(1);
        IIcon iconConveyor = reference.getIcon(0);

        chute.renderMesh(false,iconChute, reference);
        chuteConnctors.renderMesh(false, iconConnectors, reference);
        
        if (entity instanceof TileEntityConveyorConnectionsBase) {
            TileEntityConveyorConnectionsBase belt = (TileEntityConveyorConnectionsBase) entity;
            
            for (int i = 2; i < 6; i++) {
                ForgeDirection direction = ForgeDirection.getOrientation(i);
                int dir =  1-BlockContainerIP.getMetadataFromForward(direction);
                ConnectionState state = belt.getConnection(direction);
                if(state.isPlugged())
                {
                    chuteSideOutput.getRotated(dir).renderMesh(false, iconChute, reference);
                    SideOutputConnector.getRotated(dir).renderMesh(false, iconConnectors, reference);
                }else if (state.isConnected()){
                    chuteConveyorSide.getRotated(dir).renderMesh(false, iconConveyor, reference);
                    chuteConveyorSideOutput.getRotated(dir).renderMesh(false, iconConnectors, reference);
                }
            }
        }
        return true;
    }
}
