package ip.industrialProcessing;

import ip.industrialProcessing.machines.blastFurnace.ContainerBlastFurnace;
import ip.industrialProcessing.machines.blastFurnace.GuiContainerBlastFurnace;
import ip.industrialProcessing.machines.blastFurnace.TileEntityBlastFurnace;
import ip.industrialProcessing.machines.classifier.ContainerClassifier;
import ip.industrialProcessing.machines.classifier.GuiContainerClassifier;
import ip.industrialProcessing.machines.classifier.TileEntityClassifier;
import ip.industrialProcessing.machines.crusher.ContainerCrusher;
import ip.industrialProcessing.machines.crusher.GuiCrusher;
import ip.industrialProcessing.machines.crusher.TileEntityCrusher;
import ip.industrialProcessing.machines.diskFilter.ContainerDiskFilter;
import ip.industrialProcessing.machines.diskFilter.GuiContainerDiskFilter;
import ip.industrialProcessing.machines.diskFilter.TileEntityDiskFilter;
import ip.industrialProcessing.machines.dryer.ContainerDryer;
import ip.industrialProcessing.machines.dryer.GuiContainerDryer;
import ip.industrialProcessing.machines.dryer.TileEntityDryer;
import ip.industrialProcessing.machines.extruder.ContainerExtruder;
import ip.industrialProcessing.machines.extruder.GuiContainerExtruder;
import ip.industrialProcessing.machines.extruder.TileEntityExtruder;
import ip.industrialProcessing.machines.filter.ContainerFilter;
import ip.industrialProcessing.machines.filter.GuiContainerFilter;
import ip.industrialProcessing.machines.filter.TileEntityFilter;
import ip.industrialProcessing.machines.flotationCell.ContainerFlotationCell;
import ip.industrialProcessing.machines.flotationCell.GuiContainerFlotationCell;
import ip.industrialProcessing.machines.flotationCell.TileEntityFlotationCell;
import ip.industrialProcessing.machines.hydroCyclone.ContainerHydroCyclone;
import ip.industrialProcessing.machines.hydroCyclone.GuiContainerHydroCyclone;
import ip.industrialProcessing.machines.hydroCyclone.TileEntityHydroCyclone;
import ip.industrialProcessing.machines.magneticSeparator.ContainerMagneticSeparator;
import ip.industrialProcessing.machines.magneticSeparator.GuiContainerMagneticSeparator;
import ip.industrialProcessing.machines.magneticSeparator.TileEntityMagneticSeparator;
import ip.industrialProcessing.machines.mixer.ContainerMixer;
import ip.industrialProcessing.machines.mixer.GuiContainerMixer;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;
import ip.industrialProcessing.machines.oxygenFurnace.ContainerOxygenFurnace;
import ip.industrialProcessing.machines.oxygenFurnace.GuiContainerOxygenFurnace;
import ip.industrialProcessing.machines.oxygenFurnace.TileEntityOxygenFurnace;
import ip.industrialProcessing.machines.pelletExtruder.ContainerPelletExtruder;
import ip.industrialProcessing.machines.pelletExtruder.GuiContainerPelletExtruder;
import ip.industrialProcessing.machines.pelletExtruder.TileEntityPelletExtruder;
import ip.industrialProcessing.machines.thickener.ContainerThickener;
import ip.industrialProcessing.machines.thickener.GuiContainerThickener;
import ip.industrialProcessing.machines.thickener.TileEntityThickener;
import ip.industrialProcessing.multiblock.block.inventory.TileEntityMultiblockInvInput;
import ip.industrialProcessing.multiblock.block.inventory.TileEntityMultiblockInvOutput;
import ip.industrialProcessing.multiblock.block.tank.TileEntityMultiblockTankInput;
import ip.industrialProcessing.multiblock.block.tank.TileEntityMultiblockTankOutput;
import ip.industrialProcessing.multiblock.extended.inventory.ContainerMultiblockBlockInv;
import ip.industrialProcessing.multiblock.extended.inventory.GuiContainerMultiblockBlockInv;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockBlockInv;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockCoreInv;
import ip.industrialProcessing.multiblock.extended.inventory.tank.GuiContainerMultiblockBlockTank;
import ip.industrialProcessing.multiblock.extended.inventory.tank.TileEntityMultiblockBlockTank;
import ip.industrialProcessing.multiblock.machine.crusher.ContainerMultiblockCrusher;
import ip.industrialProcessing.multiblock.machine.crusher.GuiContainerMultiblockCrusher;
import ip.industrialProcessing.multiblock.machine.crusher.TileEntityMultiblockCrusher;
import ip.industrialProcessing.multiblock.machine.mixer.ContainerMultiblockMixer;
import ip.industrialProcessing.multiblock.machine.mixer.GuiContainerMultiblockMixer;
import ip.industrialProcessing.multiblock.machine.mixer.TileEntityMultiblockMixer;
import ip.industrialProcessing.multiblock.machine.weldingStation.ContainerMultiblockWeldingStation;
import ip.industrialProcessing.multiblock.machine.weldingStation.GuiContainerMultiblockWeldingStation;
import ip.industrialProcessing.multiblock.machine.weldingStation.TileEntityMultiblockWeldingStation;
import ip.industrialProcessing.multiblock.utils.config.ContainerMultiblockConfig;
import ip.industrialProcessing.multiblock.utils.config.GuiContainerMultiblockConfig;
import ip.industrialProcessing.power.buildcraftGenerator.ContainerBuildcraftGenerator;
import ip.industrialProcessing.power.buildcraftGenerator.GuiContainerBuildcraftGenerator;
import ip.industrialProcessing.power.buildcraftGenerator.TileEntityBuildcraftGenerator;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

	TileEntity entity = world.getBlockTileEntity(x, y, z);
	if (ID == 0) {
	    if (entity instanceof TileEntityFilter)
		return new ContainerFilter(player.inventory, (TileEntityFilter) entity);
	    if (entity instanceof TileEntityCrusher)
		return new ContainerCrusher(player.inventory, (TileEntityCrusher) entity);
	    if (entity instanceof TileEntityMagneticSeparator)
		return new ContainerMagneticSeparator(player.inventory, (TileEntityMagneticSeparator) entity);
	    if (entity instanceof TileEntityMixer)
		return new ContainerMixer(player.inventory, (TileEntityMixer) entity);
	    if (entity instanceof TileEntityDryer)
		return new ContainerDryer(player.inventory, (TileEntityDryer) entity);
	    if (entity instanceof TileEntityClassifier)
		return new ContainerClassifier(player.inventory, (TileEntityClassifier) entity);
	    if (entity instanceof TileEntityThickener)
		return new ContainerThickener(player.inventory, (TileEntityThickener) entity);
	    if (entity instanceof TileEntityFlotationCell)
		return new ContainerFlotationCell(player.inventory, (TileEntityFlotationCell) entity);
	    if (entity instanceof TileEntityHydroCyclone)
		return new ContainerHydroCyclone(player.inventory, (TileEntityHydroCyclone) entity);
	    if (entity instanceof TileEntityDiskFilter)
		return new ContainerDiskFilter(player.inventory, (TileEntityDiskFilter) entity);
	    if (entity instanceof TileEntityPelletExtruder)
		return new ContainerPelletExtruder(player.inventory, (TileEntityPelletExtruder) entity);
	    if (entity instanceof TileEntityExtruder)
		return new ContainerExtruder(player.inventory, (TileEntityExtruder) entity);
	    if (entity instanceof TileEntityOxygenFurnace)
		return new ContainerOxygenFurnace(player.inventory, (TileEntityOxygenFurnace) entity);
	    if (entity instanceof TileEntityBlastFurnace)
		return new ContainerBlastFurnace(player.inventory, (TileEntityBlastFurnace) entity);
	    if (entity instanceof TileEntityMultiblockCrusher)
		return new ContainerMultiblockCrusher(player.inventory, (TileEntityMultiblockCrusher) entity);
	    if (entity instanceof TileEntityMultiblockMixer)
		return new ContainerMultiblockMixer(player.inventory, (TileEntityMultiblockMixer) entity);
	    if (entity instanceof TileEntityMultiblockBlockTank)
		return new ContainerMultiblockBlockInv(player.inventory, (TileEntityMultiblockBlockTank) entity);
	    if (entity instanceof TileEntityMultiblockBlockInv)
		return new ContainerMultiblockBlockInv(player.inventory, (TileEntityMultiblockBlockInv) entity);
	    if (entity instanceof TileEntityMultiblockWeldingStation)
		return new ContainerMultiblockWeldingStation(player.inventory, (TileEntityMultiblockWeldingStation) entity);
	    if (entity instanceof TileEntityBuildcraftGenerator)
		return new ContainerBuildcraftGenerator(player.inventory, (TileEntityBuildcraftGenerator) entity);
	} else if (ID == 1) {
	    return new ContainerMultiblockConfig(player.inventory, (TileEntityMultiblockCoreInv) entity);
	}
	return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

	TileEntity entity = world.getBlockTileEntity(x, y, z);
	if (ID == 0) {
	    if (entity instanceof TileEntityFilter)
		return new GuiContainerFilter(player.inventory, (TileEntityFilter) entity);
	    if (entity instanceof TileEntityCrusher)
		return new GuiCrusher(player.inventory, (TileEntityCrusher) entity);
	    if (entity instanceof TileEntityMagneticSeparator)
		return new GuiContainerMagneticSeparator(player.inventory, (TileEntityMagneticSeparator) entity);
	    if (entity instanceof TileEntityMixer)
		return new GuiContainerMixer(player.inventory, (TileEntityMixer) entity);
	    if (entity instanceof TileEntityDryer)
		return new GuiContainerDryer(player.inventory, (TileEntityDryer) entity);
	    if (entity instanceof TileEntityClassifier)
		return new GuiContainerClassifier(player.inventory, (TileEntityClassifier) entity);
	    if (entity instanceof TileEntityThickener)
		return new GuiContainerThickener(player.inventory, (TileEntityThickener) entity);
	    if (entity instanceof TileEntityFlotationCell)
		return new GuiContainerFlotationCell(player.inventory, (TileEntityFlotationCell) entity);
	    if (entity instanceof TileEntityHydroCyclone)
		return new GuiContainerHydroCyclone(player.inventory, (TileEntityHydroCyclone) entity);
	    if (entity instanceof TileEntityDiskFilter)
		return new GuiContainerDiskFilter(player.inventory, (TileEntityDiskFilter) entity);
	    if (entity instanceof TileEntityPelletExtruder)
		return new GuiContainerPelletExtruder(player.inventory, (TileEntityPelletExtruder) entity);
	    if (entity instanceof TileEntityExtruder)
		return new GuiContainerExtruder(player.inventory, (TileEntityExtruder) entity);
	    if (entity instanceof TileEntityOxygenFurnace)
		return new GuiContainerOxygenFurnace(player.inventory, (TileEntityOxygenFurnace) entity);
	    if (entity instanceof TileEntityBlastFurnace)
		return new GuiContainerBlastFurnace(player.inventory, (TileEntityBlastFurnace) entity);
	    if (entity instanceof TileEntityMultiblockCrusher)
		return new GuiContainerMultiblockCrusher(player.inventory, (TileEntityMultiblockCrusher) entity);
	    if (entity instanceof TileEntityMultiblockMixer)
		return new GuiContainerMultiblockMixer(player.inventory, (TileEntityMultiblockMixer) entity);
	    if (entity instanceof TileEntityMultiblockInvInput)
		return new GuiContainerMultiblockBlockInv(player.inventory, (TileEntityMultiblockBlockInv) entity, 0);
	    if (entity instanceof TileEntityMultiblockInvOutput)
		return new GuiContainerMultiblockBlockInv(player.inventory, (TileEntityMultiblockBlockInv) entity, 1);
	    if (entity instanceof TileEntityMultiblockTankInput)
		return new GuiContainerMultiblockBlockTank(player.inventory, (TileEntityMultiblockBlockTank) entity, 2);
	    if (entity instanceof TileEntityMultiblockTankOutput)
		return new GuiContainerMultiblockBlockTank(player.inventory, (TileEntityMultiblockBlockTank) entity, 3);
	    if (entity instanceof TileEntityMultiblockWeldingStation)
		return new GuiContainerMultiblockWeldingStation(player.inventory, (TileEntityMultiblockWeldingStation) entity);
	    
	    if (entity instanceof TileEntityBuildcraftGenerator)
		return new GuiContainerBuildcraftGenerator(player.inventory, (TileEntityBuildcraftGenerator) entity);

	} else if (ID == 1) {
	    return new GuiContainerMultiblockConfig(player.inventory, (TileEntityMultiblockCoreInv) entity);
	}
	return null;
    }
}
