package ip.industrialProcessing;

import ip.industrialProcessing.items.GuiGuide;
import ip.industrialProcessing.machines.blastFurnace.ContainerBlastFurnace;
import ip.industrialProcessing.machines.blastFurnace.GuiContainerBlastFurnace;
import ip.industrialProcessing.machines.blastFurnace.TileEntityBlastFurnace;
import ip.industrialProcessing.machines.classifier.ContainerClassifier;
import ip.industrialProcessing.machines.classifier.GuiContainerClassifier;
import ip.industrialProcessing.machines.classifier.TileEntityClassifier;
import ip.industrialProcessing.machines.crusher.ContainerCrusher;
import ip.industrialProcessing.machines.crusher.GuiContainerCrusher;
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
import ip.industrialProcessing.machines.plants.waste.waterTreatment.incubator.ContainerIncubator;
import ip.industrialProcessing.machines.plants.waste.waterTreatment.incubator.GuiContainerIncubator;
import ip.industrialProcessing.machines.plants.waste.waterTreatment.incubator.TileEntityIncubator;
import ip.industrialProcessing.machines.plants.waste.waterTreatment.tricklingFilter.ContainerTricklingFilter;
import ip.industrialProcessing.machines.plants.waste.waterTreatment.tricklingFilter.GuiContainerTricklingFilter;
import ip.industrialProcessing.machines.plants.waste.waterTreatment.tricklingFilter.TileEntityTricklingFilter;
import ip.industrialProcessing.machines.plants.waste.waterTreatment.waterTreatmentStation.ContainerWaterTreatmentStation;
import ip.industrialProcessing.machines.plants.waste.waterTreatment.waterTreatmentStation.GuiContainerWaterTreatmentStation;
import ip.industrialProcessing.machines.plants.waste.waterTreatment.waterTreatmentStation.TileEntityWaterTreatmentStation;
import ip.industrialProcessing.machines.thickener.ContainerThickener;
import ip.industrialProcessing.machines.thickener.GuiContainerThickener;
import ip.industrialProcessing.machines.thickener.TileEntityThickener;
import ip.industrialProcessing.machines.treetap.ContainerAutomaticTreeTap;
import ip.industrialProcessing.machines.treetap.ContainerManualTreeTap;
import ip.industrialProcessing.machines.treetap.GuiContainerAutomaticTreeTap;
import ip.industrialProcessing.machines.treetap.GuiContainerManualTreeTap;
import ip.industrialProcessing.machines.treetap.TileEntityAutomaticTreeTap;
import ip.industrialProcessing.machines.treetap.TileEntityManualTreeTap;
import ip.industrialProcessing.multiblock.container.ContainerMultiblockTankWorkerPowered;
import ip.industrialProcessing.multiblock.core.block.weldingStation.ContainerWeldingStation;
import ip.industrialProcessing.multiblock.core.block.weldingStation.GUIWeldingStation;
import ip.industrialProcessing.multiblock.core.block.weldingStation.TEmultiblockWeldingStation;
import ip.industrialProcessing.multiblock.dummy.block.toggleButton.GUImultiblockToggleButton;
import ip.industrialProcessing.multiblock.dummy.block.toggleButton.TEmultiblockToggleButton;
import ip.industrialProcessing.power.buildcraftGenerator.ContainerBuildcraftGenerator;
import ip.industrialProcessing.power.buildcraftGenerator.GuiContainerBuildcraftGenerator;
import ip.industrialProcessing.power.buildcraftGenerator.TileEntityBuildcraftGenerator;
import ip.industrialProcessing.power.plants.ContainerBoiler;
import ip.industrialProcessing.power.plants.ContainerGenerator;
import ip.industrialProcessing.power.plants.ContainerSolidBurner;
import ip.industrialProcessing.power.plants.ContainerTurbine;
import ip.industrialProcessing.power.plants.GuiContainerBoiler;
import ip.industrialProcessing.power.plants.GuiContainerGenerator;
import ip.industrialProcessing.power.plants.GuiContainerSolidBurner;
import ip.industrialProcessing.power.plants.GuiContainerTurbine;
import ip.industrialProcessing.power.plants.TileEntityBoiler;
import ip.industrialProcessing.power.plants.TileEntityGenerator;
import ip.industrialProcessing.power.plants.TileEntitySolidBurner;
import ip.industrialProcessing.power.plants.TileEntityTurbine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    public static final int GUIDE_ID = 1;

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
            if (entity instanceof TileEntityBuildcraftGenerator)
                return new ContainerBuildcraftGenerator(player.inventory, (TileEntityBuildcraftGenerator) entity);
            if (entity instanceof TileEntityGenerator)
                return new ContainerGenerator(player.inventory, (TileEntityGenerator) entity);
            if (entity instanceof TileEntitySolidBurner)
                return new ContainerSolidBurner(player.inventory, (TileEntitySolidBurner) entity);
            if (entity instanceof TileEntityBoiler)
                return new ContainerBoiler(player.inventory, (TileEntityBoiler) entity);
            if (entity instanceof TileEntityTurbine)
                return new ContainerTurbine(player.inventory, (TileEntityTurbine) entity);
            if (entity instanceof TEmultiblockWeldingStation)
                return new ContainerWeldingStation(player.inventory, (TEmultiblockWeldingStation) entity);
            if (entity instanceof TileEntityIncubator)
                return new ContainerIncubator(player.inventory, (TileEntityIncubator) entity);
            if (entity instanceof TileEntityWaterTreatmentStation)
                return new ContainerWaterTreatmentStation(player.inventory, (TileEntityWaterTreatmentStation) entity);
            if (entity instanceof TileEntityTricklingFilter)
                return new ContainerTricklingFilter(player.inventory, (TileEntityTricklingFilter) entity);
            if (entity instanceof TileEntityManualTreeTap)
                return new ContainerManualTreeTap(player.inventory, (TileEntityManualTreeTap) entity);
            if (entity instanceof TileEntityAutomaticTreeTap)
                return new ContainerAutomaticTreeTap(player.inventory, (TileEntityAutomaticTreeTap) entity);
        } else if (ID == GUIDE_ID)
            return null;
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        TileEntity entity = world.getBlockTileEntity(x, y, z);
        if (ID == 0) {
            if (entity instanceof TileEntityFilter)
                return new GuiContainerFilter(player.inventory, (TileEntityFilter) entity);
            if (entity instanceof TileEntityCrusher)
                return new GuiContainerCrusher(player.inventory, (TileEntityCrusher) entity);
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
            if (entity instanceof TileEntityBuildcraftGenerator)
                return new GuiContainerBuildcraftGenerator(player.inventory, (TileEntityBuildcraftGenerator) entity);
            if (entity instanceof TileEntityGenerator)
                return new GuiContainerGenerator(player.inventory, (TileEntityGenerator) entity);
            if (entity instanceof TileEntitySolidBurner)
                return new GuiContainerSolidBurner(player.inventory, (TileEntitySolidBurner) entity);
            if (entity instanceof TileEntityBoiler)
                return new GuiContainerBoiler(player.inventory, (TileEntityBoiler) entity);
            if (entity instanceof TileEntityTurbine)
                return new GuiContainerTurbine(player.inventory, (TileEntityTurbine) entity);
            if (entity instanceof TEmultiblockWeldingStation)
                return new GUIWeldingStation(player.inventory, (TEmultiblockWeldingStation) entity);
            if (entity instanceof TEmultiblockToggleButton)
                return new GUImultiblockToggleButton((TEmultiblockToggleButton) entity, player);
            if (entity instanceof TileEntityIncubator)
                return new GuiContainerIncubator(player.inventory, (TileEntityIncubator) entity);
            if (entity instanceof TileEntityWaterTreatmentStation)
                return new GuiContainerWaterTreatmentStation(player.inventory, (TileEntityWaterTreatmentStation) entity);
            if (entity instanceof TileEntityTricklingFilter)
                return new GuiContainerTricklingFilter(player.inventory, (TileEntityTricklingFilter) entity);
            if (entity instanceof TileEntityManualTreeTap)
                return new GuiContainerManualTreeTap(player.inventory, (TileEntityManualTreeTap) entity);
            if (entity instanceof TileEntityAutomaticTreeTap)
                return new GuiContainerAutomaticTreeTap(player.inventory, (TileEntityAutomaticTreeTap) entity);
        } else if (ID == GUIDE_ID)
            return new GuiGuide(player);
        return null;
    }
}
