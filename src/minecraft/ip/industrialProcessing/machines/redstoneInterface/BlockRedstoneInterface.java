package ip.industrialProcessing.machines.redstoneInterface;

import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.api.rendering.IModelBlock;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupBlocks;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.decoration.trees.BlockRubberLog;
import ip.industrialProcessing.gui3.generating.GuiBuilderDefault;
import ip.industrialProcessing.gui3.generating.GuiBuilderRedstoneInterface;
import ip.industrialProcessing.gui3.generating.IGuiBlock;
import ip.industrialProcessing.gui3.generating.IGuiBuilder;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.IRotateableEntity;
import ip.industrialProcessing.machines.redstoneInterface.model.RedstoneInterfaceModel;
import ip.industrialProcessing.utils.IDescriptionBlock;
import ip.industrialProcessing.utils.working.IWorkingEntity;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockRedstoneInterface extends BlockMachineRendered implements IDescriptionBlock, IGuiBlock, IModelBlock {
    private Icon[] icons = new Icon[4];
    public static final String UNLOCALIZED_NAME = "IP.Machine.RedstoneInterface";
    private static IGuiBuilder guiBuilder = new GuiBuilderRedstoneInterface(UNLOCALIZED_NAME);

    public BlockRedstoneInterface() {
        super(ConfigMachineBlocks.getRedstoneInterfaceID(), Material.iron, 1.0f, soundMetalFootstep, UNLOCALIZED_NAME, ISetupCreativeTabs.tabOreProcessing);
        setTextureName(INamepace.TEXTURE_NAME_PREFIX + "redstoneInterface");
    }

    protected BlockRedstoneInterface(int automaticTreeTapBlockID, Material iron, float f, StepSound soundmetalfootstep, String string, CreativeTabs taboreprocessing) {
        super(automaticTreeTapBlockID, iron, f, soundmetalfootstep, string, taboreprocessing);
    }

    @Override
    public boolean canPlaceBlockOnSide(World par1World, int par2, int par3, int par4, int par5) {

        ForgeDirection side = ForgeDirection.getOrientation(par5).getOpposite();
        return canStayAt(par1World, par2, par3, par4, side);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        // super.onBlockPlacedBy(world, x, y, z, entityLivingBase, itemStack);

        TileEntity entity = world.getBlockTileEntity(x, y, z);
        if (entity instanceof IRotateableEntity) {

            int dir = MathHelper.floor_double((entityLivingBase.rotationYaw * 4F) / 360F + 0.5D) & 3;
            for (int i = dir; i < dir + 4; i++) {
                int d = i % 4;
                ForgeDirection direction = BlockMachine.getForwardFromMetadata(d);

                boolean isConnected = canStayAt(world, x, y, z, direction);
                if (isConnected) {
                    ((IRotateableEntity) entity).setForwardDirection(direction);
                    break;
                }
            }

        }
    }

    private static boolean canStayAt(World world, int x, int y, int z, ForgeDirection side) {
        // int id = world.getBlockId(x - direction.offsetX, y -
        // direction.offsetY, z - direction.offsetZ);
        if (side == ForgeDirection.DOWN || side == ForgeDirection.UP)
            return false;
        TileEntity id = world.getBlockTileEntity(x + side.offsetX, y + side.offsetY, z + side.offsetZ);
        return id instanceof IWorkingEntity;
    }

    @Override
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
        super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
        if (!canBlockStay(par1World, par2, par3, par4))
            par1World.destroyBlock(par2, par3, par4, true);
    }

    @Override
    public boolean canBlockStay(World par1World, int par2, int par3, int par4) {
        TileEntity entity = par1World.getBlockTileEntity(par2, par3, par4);
        ForgeDirection dir = BlockMachine.getForwardFromEntity(entity);
        if (dir == null)
            return false;
        return canStayAt(par1World, par2, par3, par4, dir);
    }

    /**
     * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z,
     * side, hitX, hitY, hitZ, block metadata
     */
    @Override
    public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {

        return super.onBlockPlaced(par1World, par2, par3, par4, par5, par6, par7, par8, par9);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess par1iBlockAccess, int par2, int par3, int par4) {

        super.setBlockBoundsBasedOnState(par1iBlockAccess, par2, par3, par4);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityRedstoneInterface();
    }

    @Override
    public int getRenderType() {
        return ConfigRenderers.getRendererInterface();
    }

    @Override
    public IGuiBuilder getGui() {
        return guiBuilder;
    }

    @Override
    public String getDescription() {
        return "Provides a redstone connection to a worker";
    }

    @Override
    public boolean canProvidePower() {
        return true;
    }

    @Override
    public Icon getIcon(int par1, int par2) {
        return icons[par1 % icons.length];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.icons[0] = par1IconRegister.registerIcon("redstone_torch_on");
        this.icons[1] = par1IconRegister.registerIcon("redstone_torch_off");
        this.icons[2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankSide");
        this.icons[3] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "conveyorHopperFeatures");
    }

    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {
        return 0;// isProvidingStrongPower(world, x, y, z,
                 // ForgeDirection.UP.ordinal()) / 2;
    }

    @Override
    public int isProvidingWeakPower(IBlockAccess par1iBlockAccess, int par2, int par3, int par4, int par5) {
        return isProvidingStrongPower(par1iBlockAccess, par2, par3, par4, par5);
    }

    @Override
    public int isProvidingStrongPower(IBlockAccess par1iBlockAccess, int par2, int par3, int par4, int par5) {
        ForgeDirection side = ForgeDirection.getOrientation(par5).getOpposite();

        TileEntity entity = par1iBlockAccess.getBlockTileEntity(par2, par3, par4);
        if (entity instanceof TileEntityRedstoneInterface) {
            ForgeDirection dir = BlockMachine.getForwardFromEntity(entity);
            if (dir == side)
                // dont provide power to the machine
                return 0;
            TileEntityRedstoneInterface redstoneInterface = (TileEntityRedstoneInterface) entity;
            return redstoneInterface.getOutput();
        }
        return 15;
    }

    private static ModelBlock model;

    @Override
    public ModelBlock getModel() {
        if (model == null)
            model = new RedstoneInterfaceModel();
        return model;
    }
}
