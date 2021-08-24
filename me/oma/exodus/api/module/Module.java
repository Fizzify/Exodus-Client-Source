package me.oma.exodus.api.module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.oma.exodus.Client;
import me.oma.exodus.api.module.setting.Setting;
import me.oma.exodus.api.util.client.Wrapper;

public abstract class Module implements Wrapper {
	
	/*
	 Module Types 
	 
	 - Informative modules and game modules
	 
	 Informative modules only has a getValue() method in the code that returns a value to display on the users HUD.
	 
	 Game Modules are modules that actually change things within the game, such as ToggleSprint, NameTags, etc. 
	 */
	
	public List<Setting> settings = new ArrayList<Setting>();
	
	public Category category;
	public Object value;
	
	public String name;
	public String description;
	
	public int keybind;
	public int height;
	public int width;
	
	public boolean enabled;
	public boolean visible;
	public boolean isInformative;
	
	public Module(String name, String description, int keybind, Category category, boolean visible, boolean informative)
	{
		this.name = name;
		this.description = description;
		this.keybind = keybind;
		this.category = category;
		this.visible = visible;
		this.isInformative = informative;
	}
	
	public void addSettings(Setting...settings)
	{
		this.settings.addAll(Arrays.asList(settings));
	}
	
	public void toggle()
	{
		enabled = !enabled;
		
		if (enabled)
		{
			onEnable();
		}
		
		if (!enabled)
		{
			onDisable();
		}
	}
	
	public void onEnable()
	{
		Client.INSTANCE.eventManager.register(this);
	}
	
	public void onDisable()
	{
		Client.INSTANCE.eventManager.unregister(this);
	}
	
	public abstract Object getValue();
	
	public abstract int getHeight();
	
	public abstract int getWidth();	
	
	public String getName()
	{
		return name;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public int getKeybind()
	{
		return keybind;
	}
	
	public Category getCategory()
	{
		return category;
	}
	
	public boolean isVisible()
	{
		return visible;
	}
	
	public boolean isEnabled()
	{
		return enabled;
	}
	
	public boolean isInformative()
	{
		return isInformative();
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public void setKeybind(int keybind)
	{
		this.keybind = keybind;
	}
	
	public void setVisible(boolean visible)
	{
		this.visible = visible;
	}
	
	
}
