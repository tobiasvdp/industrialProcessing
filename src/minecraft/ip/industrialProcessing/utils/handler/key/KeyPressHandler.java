package ip.industrialProcessing.utils.handler.key;

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
		keyBindings[0] = new KeyBinding("Up (in vehicle)", Keyboard.KEY_O);
		keyBindingsRepeat[0] = true;
	}

	public KeyPressHandler() {
		super(keyBindings, keyBindingsRepeat);
	}

	@Override
	public String getLabel() {
		return "IP keybindings";
	}

	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
		System.out.println("key pressed");
		System.out.println(Minecraft.getMinecraft().theWorld);
	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {
		System.out.println("key up");
		System.out.println(Minecraft.getMinecraft().theWorld);
	}

	@Override
	public EnumSet<TickType> ticks() {
		return tickTypes;
	}

}
