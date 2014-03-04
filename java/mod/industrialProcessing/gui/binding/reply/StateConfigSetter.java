package mod.industrialProcessing.gui.binding.reply;

import ibxm.Player;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import mod.industrialProcessing.gui.binding.IValueBinding;
import mod.industrialProcessing.gui.binding.IValueBindingChangedListener;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

public class StateConfigSetter implements IValueBindingChangedListener, IReplyBinding {
    private int index;
    private TileEntity tileEntity;

    public static void bind(TileEntity entity, IValueBinding binding, int index) {
        new StateConfigSetter(entity, binding, index);
    }

    private StateConfigSetter(TileEntity entity, IValueBinding binding, int index) {
        binding.subscribe(this);
        this.index = index;
        this.tileEntity = entity;
    }

    @Override
    public void onValueChanged(IValueBinding binding, int oldValue, int newValue) {
        if (oldValue != newValue)
            sendPacket(tileEntity, newValue, index);
    }

    private void sendPacket(TileEntity tileEntity, int newValue, int index) {

        ByteArrayOutputStream bos = new ByteArrayOutputStream(4 * 5);
        DataOutputStream outputStream = new DataOutputStream(bos);

        try {
            PacketDataHandler.writeTileEntity(outputStream, tileEntity); // 3 *
                                                                         // 4
                                                                         // bytes
            outputStream.writeInt(index);
            outputStream.writeInt(newValue);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Packet250CustomPayload packet = PacketDataHandler.getCustomPacket(bos, PacketHandler.GUI_STATECONF);
        PacketDispatcher.sendPacketToServer(packet);
    }

    public static void handleIncomingPacket(INetworkManager manager, Packet250CustomPayload packet, Player player) {

        Entity playerEntity = (Entity) player;
        TileEntity tileEntity;

        DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
        try {
            tileEntity = PacketDataHandler.readTileEntity(inputStream, playerEntity.worldObj);
            if (tileEntity instanceof IStateConfig) {
                IStateConfig syncable = (IStateConfig) tileEntity;
                int index = inputStream.readInt();
                int value = inputStream.readInt();
                syncable.setStateValue(index, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
