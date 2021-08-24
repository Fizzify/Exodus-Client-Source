package me.oma.exodus.api.processors;

import me.oma.exodus.Client;
import me.oma.exodus.api.event.impl.KeypressEvent;
import me.oma.exodus.api.managers.ModuleManager;
import me.oma.exodus.api.module.Module;

public class KeybindProcessor {
	
	public static KeybindProcessor INSTANCE = new KeybindProcessor();
	
	public void onKeyPress(int key)
	{
		for (Module m : ModuleManager.INSTANCE.modules)
		{
			if (m.getKeybind() == key)
			{
				m.toggle();
			}
		}
		
		KeypressEvent keypressEvent = new KeypressEvent();
		keypressEvent.call();
	}

}
