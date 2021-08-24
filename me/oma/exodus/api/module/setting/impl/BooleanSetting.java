package me.oma.exodus.api.module.setting.impl;

import me.oma.exodus.api.module.setting.Setting;

public class BooleanSetting extends Setting {
	
	public boolean enabled;
	
	public BooleanSetting(String name, Module module, boolean enabled)
	{
		this.name = name;
		this.module = module;
	}
	
	public String getName()
	{
		return name;
	}
	
	public boolean isEnabled()
	{
		return enabled;
	}
	
	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}
	
	public void toggle()
	{
		enabled = !enabled;
	}
}
