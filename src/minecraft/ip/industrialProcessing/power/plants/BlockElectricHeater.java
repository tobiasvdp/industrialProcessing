package ip.industrialProcessing.power.plants;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.gui3.generating.GuiBuilderDefault;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockElectricHeater extends BlockBurner {

    public static final String UNLOCALIZED_NAME = "IP.Machine.ElectricHeater";
    private static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).enablePower(0);

    public BlockElectricHeater() {
        super(ConfigMachineBlocks.getSolidBurnerBlockID(), UNLOCALIZED_NAME);
    }

    @Override
    public String getDescription() {
        return "Uses electricity to heat up the machine above";
    }

    @Override
    public IGuiBuilder getGui() {
        return guiBuilder;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityElectricHeater();
    }
}
