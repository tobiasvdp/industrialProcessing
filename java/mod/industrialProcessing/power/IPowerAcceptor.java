package mod.industrialProcessing.power;

import net.minecraftforge.common.util.ForgeDirection;

public interface IPowerAcceptor extends IPowerEntity {
    float getResistance(ForgeDirection side, float voltage); // sense voltage
    void applyPower(ForgeDirection side, float coulombs, float voltage);
    boolean canAcceptPower(ForgeDirection side);
}
