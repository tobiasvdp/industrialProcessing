package ip.industrialProcessing.power.plants;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.gui3.generating.GuiBuilderDefault;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;

public class BlockSolidBurner extends BlockBurner {

    public static final String UNLOCALIZED_NAME = "IP.Machine.SolidBurner";
    private static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).enableBurner(-1, 0, 1).enableWorker();

    public BlockSolidBurner() {
        super(ConfigMachineBlocks.getSolidBurnerBlockID(), UNLOCALIZED_NAME);
    }

    @Override
    public String getDescription() {
        return "Burn solid fuels to heat up the machine above";
    }

    @Override
    public IGuiBuilder getGui() {
        return guiBuilder;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntitySolidBurner();
    }
}
