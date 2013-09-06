package ip.industrialProcessing.machines.classifier;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.ContainerFluidMachine;
import ip.industrialProcessing.machines.GuiContainerFluidMachine;
import ip.industrialProcessing.machines.TileEntityFluidMachine;
import ip.industrialProcessing.machines.mixer.ContainerMixer;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;

public class GuiContainerClassifier extends GuiContainerFluidMachine {


	public GuiContainerClassifier(InventoryPlayer inventoryPlayer,
			TileEntityClassifier tileEntity) {
		super(inventoryPlayer, tileEntity, new ContainerClassifier(inventoryPlayer, tileEntity), "Classifier", "textures/gui/Classifier.png"); 
		//setProgressBarLocation(76,34,24,17);
	}

	

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2,int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);
		drawTank(0, 8, 19);
		drawTank(1, 152, 19);
	}

}
