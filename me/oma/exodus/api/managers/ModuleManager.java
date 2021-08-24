package me.oma.exodus.api.managers;

import java.util.ArrayList;

import me.oma.exodus.api.module.Module;
import me.oma.exodus.impl.modules.informative.FPS;
import me.oma.exodus.impl.modules.informative.ServerIP;

public class ModuleManager {
	
	public static ModuleManager INSTANCE = new ModuleManager();
	
	public ArrayList<Module> modules = new ArrayList<Module>();
	
	public ModuleManager()
	{
		addModule(new FPS());
		addModule(new ServerIP());
	}
	
	public void addModule(Module m)
	{
		modules.add(m);
	}

}
