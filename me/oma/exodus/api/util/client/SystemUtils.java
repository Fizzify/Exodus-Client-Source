package me.oma.exodus.api.util.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import me.oma.exodus.api.util.Util;

public class SystemUtils extends Util {
	
	/*
	 * @author OMA on 7/5/2021
	 * 
	 * Use with credit!
	 */
	
	public String getOS()
	{
		return System.getProperty("os.name");
	}
	
	public String getUsername()
	{
		return System.getProperty("user.name");
	}
	
	public String getPCName()
	{
        return System.getenv("COMPUTERNAME");
	}
	
	public String getOSArch()
	{
		return System.getProperty("os.arch");
	}
	
	public String getOSVersion()
	{
		return System.getProperty("os.version");
	}
	
	public String getUserHome()
	{
		return System.getProperty("user.home");
	}
	
	public String getProcessorIdentifier()
	{
		return System.getenv("PROCESSOR_IDENTIFIER");
	}
	
	public long getTotalMemory()
	{
		return Runtime.getRuntime().totalMemory();
	}
	
	// My HWID: 4df6c3921a9c0929c51fdcee18a29687
	public String getHWID()
	{
		return encryptUtils.hashMD5(
				getOS() 
				+ getUsername() 
				+ getTotalMemory()
				+ getOSArch() 
				+ getOSVersion() 
				+ getUserHome() 
				+ getPCName()
				+ getProcessorIdentifier());
	}
	
	public String getCurrentTime()
	{
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss MM/dd/yyyy");  
		 LocalDateTime now = LocalDateTime.now();  
		 
		 return(dtf.format(now));  
	}
	
	public String getIP()
	{
		try
		{
			URL ipURL = new URL("http://checkip.amazonaws.com");
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
	        		ipURL.openStream()));
	        
	        return bufferedReader.readLine();
		}
		catch (Exception e)
		{
			return "Failed to get IP.";
		}
		
	}
	
	public EnumOS getEnumOS() 
	{
		String os = getOS();
        return os.contains("win") ? EnumOS.WINDOWS : (os.contains("mac") ? EnumOS.MAC : (os.contains("linux") ? EnumOS.LINUX : EnumOS.UNKNOWN));
    }
	
	public enum EnumOS
	{
		WINDOWS("Windows"),
		LINUX("Linux"),
		MAC("Mac"),
		UNKNOWN("Unknown");
		
		String name;
		
		EnumOS(String name)
		{
			this.name = name;
		}
	}
	
}
