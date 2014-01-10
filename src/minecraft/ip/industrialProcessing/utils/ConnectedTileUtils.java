package ip.industrialProcessing.utils;

import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.transport.TransportConnectionState;
import net.minecraft.nbt.NBTTagCompound;

public class ConnectedTileUtils {
    public static void readFromNBT(NBTTagCompound compound, TransportConnectionState[] states) {
        int[] stateInts = compound.getIntArray("TState");
        for (int i = 0; i < stateInts.length; i++) {
            states[i] = TransportConnectionState.values()[stateInts[i]];
        }
    }

    public static void writeToNBT(NBTTagCompound compound, TransportConnectionState[] states) {
        int[] stateInts = new int[6];
        for (int i = 0; i < stateInts.length; i++) {
            stateInts[i] = states[i].ordinal();
        }
        compound.setIntArray("TState", stateInts);
    }

    public static void readFromNBT(NBTTagCompound compound, ConnectionState[] states) {
        int[] stateInts = compound.getIntArray("TState");
        for (int i = 0; i < stateInts.length; i++) {
            states[i] = ConnectionState.values()[stateInts[i]];
        }
    }

    public static void writeToNBT(NBTTagCompound compound, ConnectionState[] states) {
        int[] stateInts = new int[6];
        for (int i = 0; i < stateInts.length; i++) {
            stateInts[i] = states[i].ordinal();
        }
        compound.setIntArray("TState", stateInts);
    }
}
