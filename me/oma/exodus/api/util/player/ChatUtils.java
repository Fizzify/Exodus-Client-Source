package me.oma.exodus.api.util.player;

import me.oma.exodus.api.util.Util;

public class ChatUtils extends Util {
	
	public void sendPublicMessage(String message) 
	{
		mc.thePlayer.sendChatMessage(message);
	}

}
