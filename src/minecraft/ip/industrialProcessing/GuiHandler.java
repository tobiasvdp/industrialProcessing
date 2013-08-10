package ip.industrialProcessing;

import ip.industrialProcessing.machines.classifier.ContainerClassifier;
import ip.industrialProcessing.machines.classifier.GuiContainerClassifier;
import ip.industrialProcessing.machines.classifier.TileEntityClassifier;
import ip.industrialProcessing.machines.crusher.ContainerCrusher;
import ip.industrialProcessing.machines.crusher.GuiCrusher;
import ip.industrialProcessing.machines.crusher.TileEntityCrusher;
import ip.industrialProcessing.machines.dryer.ContainerDryer;
import ip.industrialProcessing.machines.dryer.GuiContainerDryer;
import ip.industrialProcessing.machines.dryer.TileEntityDryer;
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
import ip.industrialProcessing.machines.thickener.ContainerThickener;
import ip.industrialProcessing.machines.thickener.GuiContainerThickener;
import ip.industrialProcessing.machines.thickener.TileEntityThickener;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {

		TileEntity entity = world.getBlockTileEntity(x, y, z);
		if(entity  instanceof TileEntityFilter)
			return new ContainerFilter(player.inventory, (TileEntityFilter)entity);
		if(entity  instanceof TileEntityCrusher)
			return new ContainerCrusher(player.inventory, (TileEntityCrusher)entity);
		if(entity  instanceof TileEntityMagneticSeparator)
			return new ContainerMagneticSeparator(player.inventory, (TileEntityMagneticSeparator)entity); 
		if(entity  instanceof TileEntityMixer)
			return new ContainerMixer(player.inventory, (TileEntityMixer)entity); 
		if(entity  instanceof TileEntityDryer)
			return new ContainerDryer(player.inventory, (TileEntityDryer)entity); 
		if(entity  instanceof TileEntityClassifier)
			return new ContainerClassifier(player.inventory, (TileEntityClassifier)entity); 
		if(entity  instanceof TileEntityThickener)
			return new ContainerThickener(player.inventory, (TileEntityThickener)entity); 
		if(entity  instanceof TileEntityFlotationCell)
			return new ContainerFlotationCell(player.inventory, (TileEntityFlotationCell)entity);  
		if(entity  instanceof TileEntityHydroCyclone)
			return new ContainerHydroCyclone(player.inventory, (TileEntityHydroCyclone)entity); 
		return null;
	}
	 

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {

		TileEntity entity = world.getBlockTileEntity(x, y, z);
		if(entity  instanceof TileEntityFilter)
			return new GuiContainerFilter(player.inventory, (TileEntityFilter)entity);
		if(entity  instanceof TileEntityCrusher)
			return new GuiCrusher(player.inventory, (TileEntityCrusher)entity);
		if(entity  instanceof TileEntityMagneticSeparator)
			return new GuiContainerMagneticSeparator(player.inventory, (TileEntityMagneticSeparator)entity);
		if(entity  instanceof TileEntityMixer)
			return new GuiContainerMixer(player.inventory, (TileEntityMixer)entity);
		if(entity  instanceof TileEntityDryer)
			return new GuiContainerDryer(player.inventory, (TileEntityDryer)entity);
		if(entity  instanceof TileEntityClassifier)
			return new GuiContainerClassifier(player.inventory, (TileEntityClassifier)entity);
		if(entity  instanceof TileEntityThickener)
			return new GuiContainerThickener(player.inventory, (TileEntityThickener)entity);
		if(entity  instanceof TileEntityFlotationCell)
			return new GuiContainerFlotationCell(player.inventory, (TileEntityFlotationCell)entity);
		if(entity  instanceof TileEntityHydroCyclone)
			return new GuiContainerHydroCyclone(player.inventory, (TileEntityHydroCyclone)entity);
		return null;
	}

}
