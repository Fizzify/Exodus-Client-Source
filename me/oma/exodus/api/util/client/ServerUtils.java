package me.oma.exodus.api.util.client;

import me.oma.exodus.api.util.Util;

public class ServerUtils extends Util {
	
	public boolean isOnHypixel()
	{
		if (isOnServer("hypixel.net"))
		{
			return true;
		}
		
		return false;
	}
	
	public boolean isOnServer(String server)
	{
		if (!mc.isSingleplayer() && mc.getCurrentServerData().serverIP.toLowerCase().contains(server))
		{
			return true;
		}
		
		return false;
	}
	
	public String getServerIP()
	{
		if (mc.isSingleplayer())
		{
			return "Singleplayer";
		} 
		else 
		{
			return mc.getCurrentServerData().serverIP;
		}
		
	}

}
