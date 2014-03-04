package ip.industrialProcessing.machines.redstoneInterface.model;

import org.lwjgl.util.vector.Vector3f;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.treetap.model.ManualTreeTap;

public class RedstoneInterfaceModel extends ModelBlock {


    ObjRotator torch = new ObjRotator(new InterfaceTorch(), 0);
    ObjRotator box = new ObjRotator(new InterfaceBox(), 0);
    ObjRotator attachment = new ObjRotator(new InterfaceAttachment(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
        Tessellator tessellator = Tessellator.instance;
        Icon iconTorchOn = block.getIcon(0, 0);
        Icon iconTorchOff = block.getIcon(0, 1);
        Icon iconBox = block.getIcon(0, 2);
        Icon iconAttachment = block.getIcon(0, 3);
        
        Vector3f position = new Vector3f(0, 0, 0);
        torch.getRotated(0).renderMesh(iconTorchOn);
        box.getRotated(0).renderMesh(iconBox);
        attachment.getRotated(0).renderMesh(iconAttachment);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        Tessellator tessellator = Tessellator.instance;
        tessellator.setColorOpaque(255, 255, 255);
        Icon iconTorchOn = reference.getIcon(0);
        Icon iconTorchOff = reference.getIcon(1);
        Icon iconBox = reference.getIcon(2);
        Icon iconAttachment = reference.getIcon(3);
        TileEntity entity = reference.getBlockTileEntity();
        int dir = 4-BlockMachine.getMetadataFromForward(BlockMachine.getForwardFromEntity(entity));

        int power = reference.block.isProvidingStrongPower(reference.world, reference.x, reference.y, reference.z, ForgeDirection.UP.ordinal());
        Icon torchIcon = power > 0 ? iconTorchOn : iconTorchOff; 
        
        torch.getRotated(dir).renderMesh(false, torchIcon, reference);
        box.getRotated(dir).renderMesh(false, iconBox, reference);
        attachment.getRotated(dir).renderMesh(false, iconAttachment, reference);
        return true;
    }

}
