package me.oma.exodus.impl.modules.informative;

import org.lwjgl.input.Keyboard;

import me.oma.exodus.api.event.ClientEvent;
import me.oma.exodus.api.event.impl.UpdateEvent;
import me.oma.exodus.api.module.Category;
import me.oma.exodus.api.module.Module;

public class ServerIP extends Module {

	public ServerIP() 
	{
		super("IP", "Shows the IP of the server you're playing on.", Keyboard.KEY_NONE, Category.INFORMATIVE, false, true);
	}
	
	public Object getValue()
	{
		return serverUtils.getServerIP();
	}
	
	@Override
	public int getHeight() 
	{
		return this.height;
	}

	@Override
	public int getWidth() 
	{
		return this.width;
	}


}
