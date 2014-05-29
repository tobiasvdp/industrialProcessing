package mod.industrialProcessing.gui.binding.reply;

import ibxm.Player;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import mod.industrialProcessing.gui.binding.IValueBinding;
import mod.industrialProcessing.gui.binding.IValueBindingChangedListener;
import mod.industrialProcessing.utils.handlers.numbers.IStateConfig;
import mod.industrialProcessing.utils.handlers.packet.PacketHandler;
import mod.industrialProcessing.utils.handlers.packet.packets.StateConfigPacket;
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

       StateConfigPacket packet = new StateConfigPacket(tileEntity, index,newValue);
       PacketHandler.getInstance().sendToServer(packet);
    }

}
