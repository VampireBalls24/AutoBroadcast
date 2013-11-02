package me.werewolflord96.bukkit.autobroadcast.tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class BroadcastMethod {
	
	public static int currentLine = 0;
	
	public static void broadcastMessagesNow(String fileName) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(fileName);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
		
		for (int i = 0; i < currentLine; ++i)
			bufferedReader.readLine();
		
		String messageLine = bufferedReader.readLine();
		
		Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "AutoBroadcast" + ChatColor.GOLD + "] " + ChatColor.YELLOW + messageLine);
		
		LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(new File(fileName)));
		
		lineNumberReader.skip(Long.MAX_VALUE);
		
		int lastLine = lineNumberReader.getLineNumber();
		
		if (currentLine + 1 == lastLine + 1) {
			currentLine = 0;
		} else {
			currentLine++;
		}
		
		bufferedReader.close();
		lineNumberReader.close();
	}
}
