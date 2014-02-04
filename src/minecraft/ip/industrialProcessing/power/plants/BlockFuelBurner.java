package ip.industrialProcessing.power.plants;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.gui3.generating.GuiBuilderDefault;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockFuelBurner extends BlockBurner {

    public static final String UNLOCALIZED_NAME = "IP.Machine.FuelBurner";
    private static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).addInputTank(0, 0, 1);

    public BlockFuelBurner() {
        super(ConfigMachineBlocks.getFuelBurnerBlockID(), UNLOCALIZED_NAME);
    }

    @Override
    public String getDescription() {
        return "Burn liquid fuels to heat up the machine above";
    }

    @Override
    public IGuiBuilder getGui() {
        return guiBuilder;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityFuelBurner();
    }
}
