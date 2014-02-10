package ip.industrialProcessing.power.plants;

import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.api.rendering.IModelBlock;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui3.generating.GuiBuilderDefault;
import ip.industrialProcessing.gui3.generating.IGuiBlock;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;
import ip.industrialProcessing.power.BlockPowerGenerator;
import ip.industrialProcessing.power.plants.models.ModelGeneratorBlock;
import ip.industrialProcessing.utils.IDescriptionBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockGenerator extends BlockPowerGenerator implements IGuiBlock, IDescriptionBlock, IModelBlock {

    Icon[] icons = new Icon[2];
    public static final String UNLOCALIZED_NAME = "IP.Machine.Generator";
    private static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).addLabeledGauge("Voltage", "%.2fV", 0).addLabeledGauge("Current", "%.2fA", 1).addLabeledGauge("Power", "%.2fW", 2);
    private static ModelGeneratorBlock model;

    public BlockGenerator() {
        super(ConfigMachineBlocks.getGeneratorBlockID(), Material.iron, 1F, Block.soundMetalFootstep, UNLOCALIZED_NAME, ISetupCreativeTabs.tabPower);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityGenerator();
    }

    @Override
    public int getRenderType() {
        return ConfigRenderers.getRendererInterface();
    }

    @Override
    public Icon getIcon(int par1, int par2) {
        par1 %= icons.length;
        return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankSide");
        icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "generatorFeatures");
    }

    @Override
    public ModelBlock getModel() {
        if (model == null)
            model = new ModelGeneratorBlock();
        return model;
    }

    @Override
    public String getDescription() {
        return "Convertes mechanical motion to electricity";
    }

    @Override
    public IGuiBuilder getGui() {
        return guiBuilder;
    }
}
