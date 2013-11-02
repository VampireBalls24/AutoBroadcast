package me.werewolflord96.bukkit.autobroadcast;

import java.io.File;
import java.io.IOException;

import me.werewolflord96.bukkit.autobroadcast.tasks.BroadcastMethod;
import me.werewolflord96.bukkit.autobroadcast.tasks.CreateStuff;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class AutoBroadcast extends JavaPlugin {
	
	public static File messagesFile = new File("plugins/AutoBroadcast/messages.txt");
	public static File pluginFolder = new File("plugins/AutoBroadcast/");
	public static int TID = 0;
	public static long messageInterval = 60;
	
	@Override
	public void onDisable() {
		this.getLogger().info("Disabled.");
	}
	
	@Override
	public void onEnable() {
		this.getLogger().info("Enabled.");
		
		// Generates Folder
		if (!pluginFolder.exists()) {
			CreateStuff.createPluginFolder();
		}
		
		// Generates Messages File
		if (!messagesFile.exists()) {
			CreateStuff.createMessagesFile();
		}
		
		// Start Broadcasts
		TID = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				try {
					BroadcastMethod.broadcastMessagesNow("plugins/AutoBroadcast/messages.txt");
				} catch (IOException e) {
					
				}
			}
		}, 0, messageInterval * 20);
	}
}
