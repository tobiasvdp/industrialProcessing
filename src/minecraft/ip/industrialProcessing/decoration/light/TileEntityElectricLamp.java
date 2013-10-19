package ip.industrialProcessing.decoration.light;

import ip.industrialProcessing.config.ConfigBlocks;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.machines.animation.AnimationHandler;
import ip.industrialProcessing.machines.animation.AnimationMode;
import ip.industrialProcessing.machines.animation.IAnimationSyncable;
import ip.industrialProcessing.machines.animation.TileAnimationSyncHandler;
import ip.industrialProcessing.power.IPowerAcceptor;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityElectricLamp extends TileEntity implements IPowerAcceptor, IAnimationSyncable {

    int lastLight = 0;
    float power = 0;
    private float voltage;
    private boolean changed;
    private int supplies;
    private AnimationHandler handler = new AnimationHandler(AnimationMode.CLAMP, 15, false);
    private int updateDelay;

    public int getLightValue() {
        int value = (int) this.handler.getProgress();

        if (value != lastLight) {
            boolean changed = true;
        }
        lastLight = value;
        return value;
    }

    @Override
    public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
        super.writeToNBT(par1nbtTagCompound);
        this.handler.writeToNBT(par1nbtTagCompound);
        par1nbtTagCompound.setFloat("Power", this.power);
    }

    @Override
    public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
        super.readFromNBT(par1nbtTagCompound);
        this.handler.readFromNBT(par1nbtTagCompound);
        this.power = par1nbtTagCompound.getFloat("Power");
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        if (!worldObj.isRemote) {
            power -= 1;
            if (supplies > 0) {
                this.voltage /= supplies;
            }

            int light = Math.min((int) this.voltage / 10, 15);
            if (light != lastLight) {
                this.handler.setProgress(light);
                TileAnimationSyncHandler.sendAnimationData(this, handler);
                updateDelay = 5;
                lastLight = light;
                System.out.println(light + "light");
            }
            this.supplies = 0;
            this.voltage = 0;
            if (updateDelay-- == 0) {
                System.out.println(String.format("update %s %s %s", xCoord, yCoord, zCoord));
                worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            }
        }
    }

    @Override
    public float getResistance(ForgeDirection side, float voltage) {
        return 100f;
    }

    @Override
    public void applyPower(ForgeDirection side, float coulombs, float voltage) {
        this.power += coulombs * voltage;
        if (power > 50)
            this.power = 50;
        this.voltage += voltage;
        this.supplies++;
    }

    @Override
    public boolean canAcceptPower(ForgeDirection side) {
        return side == ForgeDirection.UP;
    }

    @Override
    public AnimationHandler getAnimationHandler() {
        return this.handler;
    }

}
