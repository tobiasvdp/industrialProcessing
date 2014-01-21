package ip.industrialProcessing.subMod.power.plant.creative;

import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.IGuiLayout;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.power.BlockPowerGenerator;
import ip.industrialProcessing.subMod.power.IPPower;
import ip.industrialProcessing.subMod.power.config.ConfigPower;
import ip.industrialProcessing.utils.IDescriptionBlock;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockCreativeGenerator extends BlockPowerGenerator implements IDescriptionBlock, IGuiLayout {

	public static GuiLayout guiLayout;
	static {
		guiLayout = new GuiLayout();
		guiLayout.addLayoutPanel(GuiLayoutPanelType.power);
	}

	Icon[] icons = new Icon[1];

	public BlockCreativeGenerator() {
		super(ConfigPower.getCreativeEngineID(), Material.iron, 1f, Block.soundMetalFootstep, "BlockCreativeGenerator", IPPower.tabPower);
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		return icons[par1 % icons.length];
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "generatorFeatures");
	}

	@Override
	public GuiLayout getGuiLayout() {
		return guiLayout;
	}

	@Override
	public String getDescription() {
		return "a cheaty creative engine";
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityCreativeGenerator();
	}

}
