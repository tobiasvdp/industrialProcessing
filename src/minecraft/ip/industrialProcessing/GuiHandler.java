package ip.industrialProcessing;

import ip.industrialProcessing.gui.IGuiLayout;
import ip.industrialProcessing.gui.IGuiLayoutMultiblock;
import ip.industrialProcessing.gui.container.ContainerIP;
import ip.industrialProcessing.gui.guiContainer.GuiContainerIP;
import ip.industrialProcessing.items.guide.gui.GuiGuide;
import ip.industrialProcessing.machines.electrolyser.ContainerElectrolyser;
import ip.industrialProcessing.machines.electrolyser.GuiContainerElectrolyser;
import ip.industrialProcessing.machines.electrolyser.TileEntityElectrolyser;
import ip.industrialProcessing.machines.insulator.ContainerInsulator;
import ip.industrialProcessing.machines.insulator.GuiContainerInsulator;
import ip.industrialProcessing.machines.insulator.TileEntityInsulator;
import ip.industrialProcessing.machines.kiln.ContainerKiln;
import ip.industrialProcessing.machines.kiln.GuiContainerKiln;
import ip.industrialProcessing.machines.kiln.TileEntityKiln;
import ip.industrialProcessing.machines.oxygenFurnace.ContainerOxygenFurnace;
import ip.industrialProcessing.machines.oxygenFurnace.GuiContainerOxygenFurnace;
import ip.industrialProcessing.machines.oxygenFurnace.TileEntityOxygenFurnace;
import ip.industrialProcessing.machines.pelletExtruder.ContainerPelletExtruder;
import ip.industrialProcessing.machines.pelletExtruder.GuiContainerPelletExtruder;
import ip.industrialProcessing.machines.pelletExtruder.TileEntityPelletExtruder;
import ip.industrialProcessing.machines.plants.blacksmith.anvil.ContainerAnvil;
import ip.industrialProcessing.machines.plants.blacksmith.anvil.GuiContainerAnvil;
import ip.industrialProcessing.machines.plants.metalProcessing.extruder.ContainerExtruder;
import ip.industrialProcessing.machines.plants.metalProcessing.extruder.GuiContainerExtruder;
import ip.industrialProcessing.machines.plants.metalProcessing.extruder.TileEntityExtruder;
import ip.industrialProcessing.machines.plants.metalProcessing.sandCaster.ContainerSandCaster;
import ip.industrialProcessing.machines.plants.metalProcessing.sandCaster.GuiContainerSandCaster;
import ip.industrialProcessing.machines.plants.metalProcessing.sandCaster.TileEntitySandCaster;
import ip.industrialProcessing.machines.plants.metalProcessing.turretLathe.ContainerTurretLathe;
import ip.industrialProcessing.machines.plants.metalProcessing.turretLathe.GuiContainerTurretLathe;
import ip.industrialProcessing.machines.plants.metalProcessing.turretLathe.TileEntityTurretLathe;
import ip.industrialProcessing.machines.plants.metalProcessing.vacuumCaster.ContainerVacuumCaster;
import ip.industrialProcessing.machines.plants.metalProcessing.vacuumCaster.GuiContainerVacuumCaster;
import ip.industrialProcessing.machines.plants.metalProcessing.vacuumCaster.TileEntityVacuumCaster;
import ip.industrialProcessing.machines.plants.nonFerroProcessing.magneticSeparator.ContainerMagneticSeparator;
import ip.industrialProcessing.machines.plants.nonFerroProcessing.magneticSeparator.GuiContainerMagneticSeparator;
import ip.industrialProcessing.machines.plants.nonFerroProcessing.magneticSeparator.TileEntityMagneticSeparator;
import ip.industrialProcessing.machines.plants.nonFerroProcessing.quenchTank.ContainerQuenchTank;
import ip.industrialProcessing.machines.plants.nonFerroProcessing.quenchTank.GuiContainerQuenchTank;
import ip.industrialProcessing.machines.plants.nonFerroProcessing.quenchTank.TileEntityQuenchTank;
import ip.industrialProcessing.machines.plants.nonFerroProcessing.roaster.ContainerRoaster;
import ip.industrialProcessing.machines.plants.nonFerroProcessing.roaster.GuiContainerRoaster;
import ip.industrialProcessing.machines.plants.nonFerroProcessing.roaster.TileEntityRoaster;
import ip.industrialProcessing.machines.plants.nonFerroProcessing.smelter.ContainerSmelter;
import ip.industrialProcessing.machines.plants.nonFerroProcessing.smelter.GuiContainerSmelter;
import ip.industrialProcessing.machines.plants.nonFerroProcessing.smelter.TileEntitySmelter;
import ip.industrialProcessing.machines.plants.oilRefinary.AlkylationUnit.ContainerAlkylationUnit;
import ip.industrialProcessing.machines.plants.oilRefinary.AlkylationUnit.GuiContainerAlkylationUnit;
import ip.industrialProcessing.machines.plants.oilRefinary.AlkylationUnit.TileEntityAlkylationUnit;
import ip.industrialProcessing.machines.plants.oilRefinary.asphaltBlower.ContainerAsphaltBlower;
import ip.industrialProcessing.machines.plants.oilRefinary.asphaltBlower.GuiContainerAsphaltBlower;
import ip.industrialProcessing.machines.plants.oilRefinary.asphaltBlower.TileEntityAsphaltBlower;
import ip.industrialProcessing.machines.plants.oilRefinary.gasProcessor.ContainerGasProcessor;
import ip.industrialProcessing.machines.plants.oilRefinary.gasProcessor.GuiContainerGasProcessor;
import ip.industrialProcessing.machines.plants.oilRefinary.gasProcessor.TileEntityGasProcessor;
import ip.industrialProcessing.machines.plants.oilRefinary.isomerizationReactor.ContainerIsomerizationReactor;
import ip.industrialProcessing.machines.plants.oilRefinary.isomerizationReactor.GuiContainerIsomerizationReactor;
import ip.industrialProcessing.machines.plants.oilRefinary.isomerizationReactor.TileEntityIsomerizationReactor;
import ip.industrialProcessing.machines.plants.oilRefinary.sourWaterStripper.ContainerSourWaterStripper;
import ip.industrialProcessing.machines.plants.oilRefinary.sourWaterStripper.GuiContainerSourWaterStripper;
import ip.industrialProcessing.machines.plants.oilRefinary.sourWaterStripper.TileEntitySourWaterStripper;
import ip.industrialProcessing.machines.plants.waste.exhaust.coolingUnit.ContainerCoolingUnit;
import ip.industrialProcessing.machines.plants.waste.exhaust.coolingUnit.GuiContainerCoolingUnit;
import ip.industrialProcessing.machines.plants.waste.exhaust.coolingUnit.TileEntityCoolingUnit;
import ip.industrialProcessing.machines.plants.waste.waterTreatment.incubator.ContainerIncubator;
import ip.industrialProcessing.machines.plants.waste.waterTreatment.incubator.GuiContainerIncubator;
import ip.industrialProcessing.machines.plants.waste.waterTreatment.incubator.TileEntityIncubator;
import ip.industrialProcessing.machines.sinter.ContainerSinter;
import ip.industrialProcessing.machines.sinter.GuiContainerSinter;
import ip.industrialProcessing.machines.sinter.TileEntitySinter;
import ip.industrialProcessing.machines.spoolWindingMachine.ContainerSpoolWindingMachine;
import ip.industrialProcessing.machines.spoolWindingMachine.GuiContainerSpoolWindingMachine;
import ip.industrialProcessing.machines.spoolWindingMachine.TileEntitySpoolWindingMachine;
import ip.industrialProcessing.machines.treetap.ContainerAutomaticTreeTap;
import ip.industrialProcessing.machines.treetap.ContainerManualTreeTap;
import ip.industrialProcessing.machines.treetap.GuiContainerAutomaticTreeTap;
import ip.industrialProcessing.machines.treetap.GuiContainerManualTreeTap;
import ip.industrialProcessing.machines.treetap.TileEntityAutomaticTreeTap;
import ip.industrialProcessing.machines.treetap.TileEntityManualTreeTap;
import ip.industrialProcessing.machines.wireMill.ContainerWireMill;
import ip.industrialProcessing.machines.wireMill.GuiContainerWireMill;
import ip.industrialProcessing.machines.wireMill.TileEntityWireMill;
import ip.industrialProcessing.multiblock.core.block.blastFurnace.ContainerMultiblockBlastFurnace;
import ip.industrialProcessing.multiblock.core.block.blastFurnace.GuiContainerMultiblockBlastFurnace;
import ip.industrialProcessing.multiblock.core.block.blastFurnace.TEmultiblockBlastFurnace;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.CatalyticReformer.ContainerCatalyticReformer;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.CatalyticReformer.GuiContainerCatalyticReformer;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.CatalyticReformer.TileEntityCatalyticReformer;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.amineTreater.ContainerAmineTreater;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.amineTreater.GuiContainerAmineTreater;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.amineTreater.TileEntityAmineTreater;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.atmosphericDestilationTower.ContainerAtmosphericDestilationTower;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.atmosphericDestilationTower.GuiContainerAtmosphericDestilationTower;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.atmosphericDestilationTower.TileEntityAtmosphericDestilationTower;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.clausSulfurPlant.ContainerClausSulfurPlant;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.clausSulfurPlant.GuiContainerClausSulfurPlant;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.clausSulfurPlant.TileEntityClausSulfurPlant;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.delayedCoker.ContainerDelayedCoker;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.delayedCoker.GuiContainerDelayedCoker;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.delayedCoker.TileEntityDelayedCoker;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.fluidCatalyticCracker.ContainerFluidCatalyticCracker;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.fluidCatalyticCracker.GuiContainerFluidCatalyticCracker;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.fluidCatalyticCracker.TileEntityFluidCatalyticCracker;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.hydroCracker.ContainerHydroCracker;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.hydroCracker.GuiContainerHydroCracker;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.hydroCracker.TileEntityHydroCracker;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.hydroTreater.ContainerHydroTreater;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.hydroTreater.GuiContainerHydroTreater;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.hydroTreater.TileEntityHydroTreater;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.meroxTreater.ContainerMeroxTreater;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.meroxTreater.GuiContainerMeroxTreater;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.meroxTreater.TileEntityMeroxTreater;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.vacuumDestilationTower.ContainerVacuumDestilationTower;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.vacuumDestilationTower.GuiContainerVacuumDestilationTower;
import ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.vacuumDestilationTower.TileEntityVacuumDestilationTower;
import ip.industrialProcessing.multiblock.core.block.plants.storage.container.ContainerContainer;
import ip.industrialProcessing.multiblock.core.block.plants.storage.container.GuiContainerContainer;
import ip.industrialProcessing.multiblock.core.block.plants.storage.container.TileEntityContainer;
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
import ip.industrialProcessing.power.storage.ContainerEnergyCell;
import ip.industrialProcessing.power.storage.GuiContainerEnergyCell;
import ip.industrialProcessing.power.storage.TileEntityEnergyCell;
import ip.industrialProcessing.transport.fluids.ContainerTank;
import ip.industrialProcessing.transport.fluids.GuiContainerTank;
import ip.industrialProcessing.transport.fluids.TileEntityTank;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	public static final int GUIDE_ID = 1;
	public static final int ANVIL_ID = 2;
	public static final int SOLDERINGIRON_ID = 3;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		TileEntity entity = world.getBlockTileEntity(x, y, z);
		if (ID == 0) {
			if (entity.getBlockType() != null && (entity.getBlockType() instanceof IGuiLayout || entity.getBlockType() instanceof IGuiLayoutMultiblock)) {
				return new ContainerIP(player, entity);
			}
			if (entity instanceof TileEntityMagneticSeparator)
				return new ContainerMagneticSeparator(player.inventory, (TileEntityMagneticSeparator) entity);
			if (entity instanceof TileEntityPelletExtruder)
				return new ContainerPelletExtruder(player.inventory, (TileEntityPelletExtruder) entity);
			if (entity instanceof TileEntityExtruder)
				return new ContainerExtruder(player.inventory, (TileEntityExtruder) entity);
			if (entity instanceof TileEntityOxygenFurnace)
				return new ContainerOxygenFurnace(player.inventory, (TileEntityOxygenFurnace) entity);
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
			if (entity instanceof TileEntityIncubator)
				return new ContainerIncubator(player.inventory, (TileEntityIncubator) entity);
			if (entity instanceof TileEntityManualTreeTap)
				return new ContainerManualTreeTap(player.inventory, (TileEntityManualTreeTap) entity);
			if (entity instanceof TileEntityAutomaticTreeTap)
				return new ContainerAutomaticTreeTap(player.inventory, (TileEntityAutomaticTreeTap) entity);
			if (entity instanceof TileEntityWireMill)
				return new ContainerWireMill(player.inventory, (TileEntityWireMill) entity);
			if (entity instanceof TileEntityInsulator)
				return new ContainerInsulator(player.inventory, (TileEntityInsulator) entity);
			if (entity instanceof TileEntitySpoolWindingMachine)
				return new ContainerSpoolWindingMachine(player.inventory, (TileEntitySpoolWindingMachine) entity);
			if (entity instanceof TileEntityElectrolyser)
				return new ContainerElectrolyser(player.inventory, (TileEntityElectrolyser) entity);
			if (entity instanceof TileEntitySourWaterStripper)
				return new ContainerSourWaterStripper(player.inventory, (TileEntitySourWaterStripper) entity);
			if (entity instanceof TileEntityAlkylationUnit)
				return new ContainerAlkylationUnit(player.inventory, (TileEntityAlkylationUnit) entity);
			if (entity instanceof TileEntityAsphaltBlower)
				return new ContainerAsphaltBlower(player.inventory, (TileEntityAsphaltBlower) entity);
			if (entity instanceof TileEntityGasProcessor)
				return new ContainerGasProcessor(player.inventory, (TileEntityGasProcessor) entity);
			if (entity instanceof TileEntityIsomerizationReactor)
				return new ContainerIsomerizationReactor(player.inventory, (TileEntityIsomerizationReactor) entity);
			if (entity instanceof TileEntityAtmosphericDestilationTower)
				return new ContainerAtmosphericDestilationTower(player.inventory, (TileEntityAtmosphericDestilationTower) entity);
			if (entity instanceof TileEntityAmineTreater)
				return new ContainerAmineTreater(player.inventory, (TileEntityAmineTreater) entity);
			if (entity instanceof TileEntityCatalyticReformer)
				return new ContainerCatalyticReformer(player.inventory, (TileEntityCatalyticReformer) entity);
			if (entity instanceof TileEntityClausSulfurPlant)
				return new ContainerClausSulfurPlant(player.inventory, (TileEntityClausSulfurPlant) entity);
			if (entity instanceof TileEntityDelayedCoker)
				return new ContainerDelayedCoker(player.inventory, (TileEntityDelayedCoker) entity);
			if (entity instanceof TileEntityFluidCatalyticCracker)
				return new ContainerFluidCatalyticCracker(player.inventory, (TileEntityFluidCatalyticCracker) entity);
			if (entity instanceof TileEntityHydroCracker)
				return new ContainerHydroCracker(player.inventory, (TileEntityHydroCracker) entity);
			if (entity instanceof TileEntityHydroTreater)
				return new ContainerHydroTreater(player.inventory, (TileEntityHydroTreater) entity);
			if (entity instanceof TileEntityMeroxTreater)
				return new ContainerMeroxTreater(player.inventory, (TileEntityMeroxTreater) entity);
			if (entity instanceof TileEntityVacuumDestilationTower)
				return new ContainerVacuumDestilationTower(player.inventory, (TileEntityVacuumDestilationTower) entity);
			if (entity instanceof TileEntitySinter)
				return new ContainerSinter(player.inventory, (TileEntitySinter) entity);
			if (entity instanceof TileEntityKiln)
				return new ContainerKiln(player.inventory, (TileEntityKiln) entity);
			if (entity instanceof TEmultiblockBlastFurnace)
				return new ContainerMultiblockBlastFurnace(player.inventory, (TEmultiblockBlastFurnace) entity);
			if (entity instanceof TileEntitySandCaster)
				return new ContainerSandCaster(player.inventory, (TileEntitySandCaster) entity);
			if (entity instanceof TileEntityVacuumCaster)
				return new ContainerVacuumCaster(player.inventory, (TileEntityVacuumCaster) entity);
			if (entity instanceof TileEntityTurretLathe)
				return new ContainerTurretLathe(player.inventory, (TileEntityTurretLathe) entity);
			if (entity instanceof TileEntityCoolingUnit)
				return new ContainerCoolingUnit(player.inventory, (TileEntityCoolingUnit) entity);
			if (entity instanceof TileEntityRoaster)
				return new ContainerRoaster(player.inventory, (TileEntityRoaster) entity);
			if (entity instanceof TileEntitySmelter)
				return new ContainerSmelter(player.inventory, (TileEntitySmelter) entity);
			if (entity instanceof TileEntityQuenchTank)
				return new ContainerQuenchTank(player.inventory, (TileEntityQuenchTank) entity);
			if (entity instanceof TileEntityContainer)
				return new ContainerContainer(player.inventory, (TileEntityContainer) entity);
			if (entity instanceof TileEntityEnergyCell)
				return new ContainerEnergyCell(player.inventory, (TileEntityEnergyCell) entity);
			if (entity instanceof TileEntityTank)
				return new ContainerTank(player.inventory, (TileEntityTank) entity);
		} else if (ID == GUIDE_ID) {
			return null;
		} else if (ID == ANVIL_ID) {
			return new ContainerAnvil(player.inventory, world, x, y, z);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		TileEntity entity = world.getBlockTileEntity(x, y, z);
		if (ID == 0) {
			if (entity.getBlockType() != null && (entity.getBlockType() instanceof IGuiLayout || entity.getBlockType() instanceof IGuiLayoutMultiblock)) {
				return new GuiContainerIP(player, entity, new ContainerIP(player, entity));
			}
			if (entity instanceof TileEntityMagneticSeparator)
				return new GuiContainerMagneticSeparator(player.inventory, (TileEntityMagneticSeparator) entity);
			if (entity instanceof TileEntityPelletExtruder)
				return new GuiContainerPelletExtruder(player.inventory, (TileEntityPelletExtruder) entity);
			if (entity instanceof TileEntityExtruder)
				return new GuiContainerExtruder(player.inventory, (TileEntityExtruder) entity);
			if (entity instanceof TileEntityOxygenFurnace)
				return new GuiContainerOxygenFurnace(player.inventory, (TileEntityOxygenFurnace) entity);
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
			if (entity instanceof TEmultiblockToggleButton)
				return new GUImultiblockToggleButton((TEmultiblockToggleButton) entity, player);
			if (entity instanceof TileEntityIncubator)
				return new GuiContainerIncubator(player.inventory, (TileEntityIncubator) entity);
			if (entity instanceof TileEntityManualTreeTap)
				return new GuiContainerManualTreeTap(player.inventory, (TileEntityManualTreeTap) entity);
			if (entity instanceof TileEntityAutomaticTreeTap)
				return new GuiContainerAutomaticTreeTap(player.inventory, (TileEntityAutomaticTreeTap) entity);

			if (entity instanceof TileEntityWireMill)
				return new GuiContainerWireMill(player.inventory, (TileEntityWireMill) entity);
			if (entity instanceof TileEntityInsulator)
				return new GuiContainerInsulator(player.inventory, (TileEntityInsulator) entity);
			if (entity instanceof TileEntitySpoolWindingMachine)
				return new GuiContainerSpoolWindingMachine(player.inventory, (TileEntitySpoolWindingMachine) entity);
			if (entity instanceof TileEntityElectrolyser)
				return new GuiContainerElectrolyser(player.inventory, (TileEntityElectrolyser) entity);
			if (entity instanceof TileEntitySourWaterStripper)
				return new GuiContainerSourWaterStripper(player.inventory, (TileEntitySourWaterStripper) entity);
			if (entity instanceof TileEntityAlkylationUnit)
				return new GuiContainerAlkylationUnit(player.inventory, (TileEntityAlkylationUnit) entity);
			if (entity instanceof TileEntityAsphaltBlower)
				return new GuiContainerAsphaltBlower(player.inventory, (TileEntityAsphaltBlower) entity);
			if (entity instanceof TileEntityGasProcessor)
				return new GuiContainerGasProcessor(player.inventory, (TileEntityGasProcessor) entity);
			if (entity instanceof TileEntityIsomerizationReactor)
				return new GuiContainerIsomerizationReactor(player.inventory, (TileEntityIsomerizationReactor) entity);
			if (entity instanceof TileEntityAtmosphericDestilationTower)
				return new GuiContainerAtmosphericDestilationTower(player.inventory, (TileEntityAtmosphericDestilationTower) entity);
			if (entity instanceof TileEntityAmineTreater)
				return new GuiContainerAmineTreater(player.inventory, (TileEntityAmineTreater) entity);
			if (entity instanceof TileEntityCatalyticReformer)
				return new GuiContainerCatalyticReformer(player.inventory, (TileEntityCatalyticReformer) entity);
			if (entity instanceof TileEntityClausSulfurPlant)
				return new GuiContainerClausSulfurPlant(player.inventory, (TileEntityClausSulfurPlant) entity);
			if (entity instanceof TileEntityDelayedCoker)
				return new GuiContainerDelayedCoker(player.inventory, (TileEntityDelayedCoker) entity);
			if (entity instanceof TileEntityFluidCatalyticCracker)
				return new GuiContainerFluidCatalyticCracker(player.inventory, (TileEntityFluidCatalyticCracker) entity);
			if (entity instanceof TileEntityHydroCracker)
				return new GuiContainerHydroCracker(player.inventory, (TileEntityHydroCracker) entity);
			if (entity instanceof TileEntityHydroTreater)
				return new GuiContainerHydroTreater(player.inventory, (TileEntityHydroTreater) entity);
			if (entity instanceof TileEntityMeroxTreater)
				return new GuiContainerMeroxTreater(player.inventory, (TileEntityMeroxTreater) entity);
			if (entity instanceof TileEntityVacuumDestilationTower)
				return new GuiContainerVacuumDestilationTower(player.inventory, (TileEntityVacuumDestilationTower) entity);
			if (entity instanceof TileEntitySinter)
				return new GuiContainerSinter(player.inventory, (TileEntitySinter) entity);
			if (entity instanceof TileEntityKiln)
				return new GuiContainerKiln(player.inventory, (TileEntityKiln) entity);
			if (entity instanceof TEmultiblockBlastFurnace)
				return new GuiContainerMultiblockBlastFurnace(player.inventory, (TEmultiblockBlastFurnace) entity);
			if (entity instanceof TileEntitySandCaster)
				return new GuiContainerSandCaster(player.inventory, (TileEntitySandCaster) entity);
			if (entity instanceof TileEntityVacuumCaster)
				return new GuiContainerVacuumCaster(player.inventory, (TileEntityVacuumCaster) entity);
			if (entity instanceof TileEntityTurretLathe)
				return new GuiContainerTurretLathe(player.inventory, (TileEntityTurretLathe) entity);
			if (entity instanceof TileEntityCoolingUnit)
				return new GuiContainerCoolingUnit(player.inventory, (TileEntityCoolingUnit) entity);
			if (entity instanceof TileEntityRoaster)
				return new GuiContainerRoaster(player.inventory, (TileEntityRoaster) entity);
			if (entity instanceof TileEntitySmelter)
				return new GuiContainerSmelter(player.inventory, (TileEntitySmelter) entity);
			if (entity instanceof TileEntityQuenchTank)
				return new GuiContainerQuenchTank(player.inventory, (TileEntityQuenchTank) entity);
			if (entity instanceof TileEntityContainer)
				return new GuiContainerContainer(player.inventory, (TileEntityContainer) entity);
			if (entity instanceof TileEntityEnergyCell)
				return new GuiContainerEnergyCell(player.inventory, (TileEntityEnergyCell) entity);
			if (entity instanceof TileEntityTank)
				return new GuiContainerTank(player.inventory, (TileEntityTank) entity);
		} else if (ID == GUIDE_ID) {
			return new GuiGuide(player);
		} else if (ID == ANVIL_ID) {
			return new GuiContainerAnvil(player.inventory, world, x, y, z);
		}
		return null;
	}
}
