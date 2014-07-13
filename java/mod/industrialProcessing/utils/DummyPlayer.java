package mod.industrialProcessing.utils;

import java.lang.ref.WeakReference;
import java.util.UUID;

import mod.industrialProcessing.IndustrialProcessing;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.util.FakePlayerFactory;

import com.mojang.authlib.GameProfile;

public class DummyPlayer {

	public static UUID uuid = UUID.nameUUIDFromBytes(IndustrialProcessing.MODID.getBytes());
	public static GameProfile gameProfile = new GameProfile("6F492490-0ACF-11E4-9191-0800200C9A66", "[" + IndustrialProcessing.MODID + "]");

	public static WeakReference<EntityPlayer> player;

	public static EntityPlayer getDummy(WorldServer world) {

		if (player == null || player.get() == null) {
			player = new WeakReference<EntityPlayer>(FakePlayerFactory.get(world, gameProfile));
		}
		return player.get();
	}

}
