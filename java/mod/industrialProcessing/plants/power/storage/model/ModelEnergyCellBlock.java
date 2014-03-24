package mod.industrialProcessing.plants.power.storage.model;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.client.rendering.block.ModelBlock;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjRotator;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.WorldReference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

public class ModelEnergyCellBlock extends ModelBlock {

    ObjRotator connectorSide = new ObjRotator(new BatboxConnector(), 0);
    ObjRotator rails = new ObjRotator(new BatteryBoxPowerRails(), 0);
    ObjRotator features = new ObjRotator(new BatteryBoxFeatures(), 0);
    ObjRotator hull = new ObjRotator(new BatteryBoxHull(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

	IIcon powerIcon = block.getIcon(0, 0);
	IIcon hullIcon = block.getIcon(1, 0);
	IIcon batteryIcon = block.getIcon(2, 0);

	hull.getRotated(0).renderMesh(hullIcon);
	features.getRotated(0).renderMesh(powerIcon);
	connectorSide.getRotated(0).renderMesh(powerIcon);
	rails.getRotated(0).renderMesh(batteryIcon);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

	TileEntity entity = reference.getBlockTileEntity();
	ForgeDirection forward = BlockContainerIP.getForwardFromEntity(entity);
	int dir = 4 - BlockContainerIP.getMetadataFromForward(forward);

	IIcon powerIcon = reference.getIcon(0);
	IIcon hullIcon = reference.getIcon(1);
	IIcon batteryIcon = reference.getIcon(2);
	IIcon powerOutIcon = reference.getIcon(3);

	hull.getRotated(dir).renderMesh(false, hullIcon, reference);
	features.getRotated(dir).renderMesh(false, powerIcon, reference);
	connectorSide.getRotated(dir + 2).renderMesh(false, powerIcon, reference);
	connectorSide.getRotated(dir).renderMesh(false, powerOutIcon, reference);
	rails.getRotated(dir).renderMesh(false, batteryIcon, reference);
	return true;
    }

}
