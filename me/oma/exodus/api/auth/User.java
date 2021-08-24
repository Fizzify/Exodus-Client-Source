package me.oma.exodus.api.auth;

import me.oma.exodus.api.util.client.Wrapper;

public class User implements Wrapper {
	
	public String username;
	public String password;
	public String hwid;
	
	public User(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String getHWID()
	{
		return hwid;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public void setHWID()
	{
		this.hwid = systemUtils.getHWID();
	}

}
