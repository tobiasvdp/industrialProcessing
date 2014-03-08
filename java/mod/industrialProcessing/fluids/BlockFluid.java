package mod.industrialProcessing.fluids;

import javax.swing.Icon;

import mod.industrialProcessing.utils.INamepace;
import mod.industrialProcessing.utils.creativeTab.ISetupCreativeTabs;
import mod.industrialProcessing.utils.damage.ISetupDamageSource;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFluid extends BlockFluidClassic {

    @SideOnly(Side.CLIENT)
    protected IIcon[] theIcon;
    protected boolean doDamage;

    public BlockFluid(Fluid fluid, Material material, boolean doDamage) {
        super(fluid, material);
        this.doDamage = doDamage;
    }

    @Override
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) {
        if (doDamage) {
            par5Entity.attackEntityFrom(ISetupDamageSource.DamageDirtyWater, 2.0F);
        }
    }

    @Override
	@SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return this.blockMaterial == Material.water ? 1 : 0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2) {
        return par1 != 1 ? this.theIcon[1] : this.theIcon[0];
    }

    @Override
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.theIcon = new IIcon[] { par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX +  this.getUnlocalizedName() + "_still"), par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + this.getUnlocalizedName() + "_flow") };
        this.stack.getFluid().setIcons(theIcon[0], theIcon[1]);
    }

    @Override
    public FluidStack drain(World world, int x, int y, int z, boolean doDrain) {
        if (!canDrain(world, x, y, z))
            return null;
        FluidStack stack = new FluidStack(this.getFluid(), FluidContainerRegistry.BUCKET_VOLUME);
        if (doDrain)
            world.setBlockToAir(x, y, z);
        return stack;
    }

    @Override
    public boolean canDrain(World world, int x, int y, int z) {
        return world.getBlockMetadata(x, y, z) == 0;
    }

    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
        if (world.getBlock(x, y, z).getMaterial().isLiquid())
            return false;
        return super.canDisplace(world, x, y, z);
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
        if (world.getBlock(x, y, z).getMaterial().isLiquid())
            return false;
        return super.displaceIfPossible(world, x, y, z);
    }

}
