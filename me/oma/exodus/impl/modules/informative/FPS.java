package me.oma.exodus.impl.modules.informative;

import org.lwjgl.input.Keyboard;

import me.oma.exodus.api.event.ClientEvent;
import me.oma.exodus.api.event.impl.UpdateEvent;
import me.oma.exodus.api.module.Category;
import me.oma.exodus.api.module.Module;

public class FPS extends Module {

	public FPS() 
	{
		super("FPS", "Shows your FPS.", Keyboard.KEY_NONE, Category.INFORMATIVE, false, true);
	}
	
	public Object getValue()
	{
		return mc.getDebugFPS();
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
