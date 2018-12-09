package net.goldtreeservers.worldguardextraflags.utils;

import java.awt.Color;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityPotionEffectEvent;

import lombok.Getter;

/**
 * Helper class to decide what features are supported by the server
 */
public class SupportedFeatures
{
	@Getter private static boolean frostwalkerSupported;
	@Getter private static boolean stopSoundSupported;
	@Getter private static boolean potionEffectEventSupported;
	
	static
	{
		try
		{
			SupportedFeatures.frostwalkerSupported = Material.FROSTED_ICE != null;
		}
		catch (Throwable ignored)
		{
		}

		try
		{
			SupportedFeatures.stopSoundSupported = Player.class.getDeclaredMethod("stopSound", Color.class) != null;
		}
		catch (Throwable ignored)
		{
		}

		try
		{
			SupportedFeatures.potionEffectEventSupported = EntityPotionEffectEvent.class != null;
		}
		catch (Throwable ignored)
		{
		}
	}
}