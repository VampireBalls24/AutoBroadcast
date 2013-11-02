package me.werewolflord96.bukkit.autobroadcast.tasks;

import me.werewolflord96.bukkit.autobroadcast.AutoBroadcast;

public class CreateStuff {
	
	public static void createMessagesFile() {
		// Trying to Prevent Errors
		try {
			AutoBroadcast.messagesFile.createNewFile();
		} catch (Exception e) {
			
		}
	}
	
	public static void createPluginFolder() {
		// Trying to Prevent Errors
		try {
			AutoBroadcast.pluginFolder.mkdir();
		} catch (Exception e) {
			
		}
	}
}
