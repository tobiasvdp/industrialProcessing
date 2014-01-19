package ip.industrialProcessing.multiblock.core.block.decoration.garageDoor;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;
import ip.industrialProcessing.multiblock.core.block.weldingStation.TileEntityMultiblockWeldingStation;
import ip.industrialProcessing.multiblock.recipes.IRecipeMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.utils.IDescriptionBlock;

public class BlockGarageDoor extends BlockMultiblockCore implements IDescriptionBlock{
	private Icon[] icons = new Icon[4];

	public BlockGarageDoor() {
		super(ConfigMachineBlocks.getBlockGarageDoorID(), "BlockGarageDoor", ISetupCreativeTabs.tabMultiblocks);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityGarageDoor();
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getBLmultiblockWeldingStation();
	}
	
    @Override
    public Icon getIcon(int par1, int par2) {
        par1 %= icons.length;        
        return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        icons [0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Planks2");
        icons [1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Stone");
        icons [2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Planks2");
        icons [3] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "crafting_table_front");
    }

	@Override
	public String getDescription() {
		return "Gearbox for the garage door.";
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
		if(!player.isSneaking()){
			TileEntityGarageDoor me = (TileEntityGarageDoor) world.getBlockTileEntity(x, y, z);
			me.openOrClose();
		}
		return super.onBlockActivated(world, x, y, z, player, metadata, what, these, are);
	}
}
