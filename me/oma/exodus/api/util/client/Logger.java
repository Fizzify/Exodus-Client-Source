package me.oma.exodus.api.util.client;

import com.mojang.realmsclient.gui.ChatFormatting;

public class Logger implements Wrapper {
	
	public static Logger INSTANCE = new Logger();
	
	public String consoleName = "[Exodus]";
	
	public void info(String msg)
	{
		System.out.println(consoleName + "" + msg);
	}

}
