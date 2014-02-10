package ip.industrialProcessing.power.storage.model;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class ModelEnergyCellBlock extends ModelBlock {

    ObjRotator connectorSide = new ObjRotator(new BatboxConnector(), 0);
    ObjRotator rails = new ObjRotator(new BatteryBoxPowerRails(), 0);
    ObjRotator features = new ObjRotator(new BatteryBoxFeatures(), 0);
    ObjRotator hull = new ObjRotator(new BatteryBoxHull(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

	Icon powerIcon = block.getIcon(0, 0);
	Icon hullIcon = block.getIcon(1, 0);
	Icon batteryIcon = block.getIcon(2, 0);

	hull.getRotated(0).renderMesh(hullIcon);
	features.getRotated(0).renderMesh(powerIcon);
	connectorSide.getRotated(0).renderMesh(powerIcon);
	rails.getRotated(0).renderMesh(batteryIcon);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

	TileEntity entity = reference.getBlockTileEntity();
	ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
	int dir = 4 - BlockMachine.getMetadataFromForward(forward);

	Icon powerIcon = reference.getIcon(0);
	Icon hullIcon = reference.getIcon(1);
	Icon batteryIcon = reference.getIcon(2);
	Icon powerOutIcon = reference.getIcon(3);

	hull.getRotated(dir).renderMesh(false, hullIcon, reference);
	features.getRotated(dir).renderMesh(false, powerIcon, reference);
	connectorSide.getRotated(dir + 2).renderMesh(false, powerIcon, reference);
	connectorSide.getRotated(dir).renderMesh(false, powerOutIcon, reference);
	rails.getRotated(dir).renderMesh(false, batteryIcon, reference);
	return true;
    }

}
