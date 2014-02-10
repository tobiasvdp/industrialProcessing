package ip.industrialProcessing.utils.handler.key;

import ip.industrialProcessing.subMod.mine.machines.mining.bobcatMiner.EntityBobcatMiner;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class KeyPressHandler extends KeyHandler {

    static KeyBinding[] keyBindings;
    static boolean[] keyBindingsRepeat;
    private EnumSet tickTypes = EnumSet.of(TickType.CLIENT);

    static {
	keyBindings = new KeyBinding[1];
	keyBindingsRepeat = new boolean[1];
	keyBindings[0] = new KeyBinding("Toggle tool on/off (IP)", Keyboard.KEY_O);
	keyBindingsRepeat[0] = false;
    }

    public KeyPressHandler() {
	super(keyBindings, keyBindingsRepeat);
    }

    @Override
    public String getLabel() {
	return "IP keybindings";
    }

    public boolean keyHasBeenPressed;

    @Override
    public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
	keyHasBeenPressed = true;
    }

    @Override
    public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {
	if (keyHasBeenPressed) {
	    if (Minecraft.getMinecraft() != null && Minecraft.getMinecraft().thePlayer != null && Minecraft.getMinecraft().thePlayer.isRiding()) {
		if (Minecraft.getMinecraft().thePlayer.ridingEntity instanceof EntityBobcatMiner) {
		    ((EntityBobcatMiner) Minecraft.getMinecraft().thePlayer.ridingEntity).toggleMining(Minecraft.getMinecraft().thePlayer);
		}
	    }
	    keyHasBeenPressed = false;
	}
    }

    @Override
    public EnumSet<TickType> ticks() {
	return tickTypes;
    }

}
