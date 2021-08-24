package me.oma.exodus.api.util.client;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import me.oma.exodus.api.util.Util;

public class PlayerUtils extends Util {
	
	public String getName()
	{
		return mc.getSession().getUsername();
	}
	
	public String getSessionID()
	{
		return mc.getSession().getSessionID();
	}
	
	public String getUUID(String username)
	{
		return getUUIDFromUsername(username).toString();
	}
	
	public UUID getUUIDFromUsername(String username) 
	{
        try 
        {
            URL url = new URL("https://api.mojang.com/users/profiles/minecraft/" + username);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            JsonObject jsonObject = new JsonParser().parse(new InputStreamReader(conn.getInputStream())).getAsJsonObject();
            UUID uuid = UUID.fromString(jsonObject.get("id").getAsString().replaceFirst("(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)", "$1-$2-$3-$4-$5"));
            
            return uuid;
        } 
        catch (Exception e) 
        {
        	return UUID.fromString("No UUID associated with " + username);
        }
    }
	
	public void jump()
	{
		mc.thePlayer.jump();
	}
	
	

}
