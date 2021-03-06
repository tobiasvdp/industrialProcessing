package ip.industrialProcessing.fluids;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.config.ISetupDamageSource;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

public class BlockFluid extends BlockFluidClassic {

    @SideOnly(Side.CLIENT)
    protected Icon[] theIcon;
    protected boolean doDamage;

    public BlockFluid(int id, Fluid fluid, Material material, boolean doDamage) {
        super(id, fluid, material);
        setUnlocalizedName("Block" + fluid.getUnlocalizedName());
        setCreativeTab(ISetupCreativeTabs.tabFluid);
        this.disableStats();
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
    public Icon getIcon(int par1, int par2) {
        return par1 != 0 && par1 != 1 ? this.theIcon[1] : this.theIcon[0];
    }

    @Override
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        this.theIcon = new Icon[] { par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + this.getFluid().getName() + "_still"), par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + this.getFluid().getName() + "_flow") };
        this.getFluid().setIcons(theIcon[0], theIcon[1]);
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
        if (world.getBlockMaterial(x, y, z).isLiquid())
            return false;
        return super.canDisplace(world, x, y, z);
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
        if (world.getBlockMaterial(x, y, z).isLiquid())
            return false;
        return super.displaceIfPossible(world, x, y, z);
    }

}
