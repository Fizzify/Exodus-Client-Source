package me.oma.exodus.api.friend;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class FriendProfile {
	
	public String nickName;
	public UUID uuid;
	
	public FriendProfile(String nickname, UUID uuid)
	{
		this.nickName = nickname;
		this.uuid = uuid;
	}
	
	public String getNickname()
	{
		return nickName;
	}
	
	public UUID getUUID()
	{
		return uuid;
	}
	
	public FriendProfile getUUIDFromUsername(String username, String nickName) throws UUIDFailureException
	{
        try 
        {
            URL url = new URL("https://api.mojang.com/users/profiles/minecraft/" + username);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            JsonObject jsonObject = new JsonParser().parse(new InputStreamReader(connection.getInputStream())).getAsJsonObject();
            UUID uuid = UUID.fromString(jsonObject.get("id").getAsString().replaceFirst("(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)", "$1-$2-$3-$4-$5"));
            
            return new FriendProfile(nickName, uuid);
        } 
        catch (Exception e) 
        {
        	throw new UUIDFailureException("No UUID associated with given username.");
        }
    }

}
