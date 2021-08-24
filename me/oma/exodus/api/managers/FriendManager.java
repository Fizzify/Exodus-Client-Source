package me.oma.exodus.api.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import me.oma.exodus.api.friend.FriendProfile;

public class FriendManager {
	
	/*
	 
	 User types in nickname and username of the person they want to friend
	 
	 After clicking the button, the addFriend() method is called with takes in 2 parameters, the nickname and username
	 
	 The UUID of the player is received from the username with the util in PlayerUtils, and the uuid of the player, current username and nickname is saved in 
	 a JSON file. Everytime the client starts up the username of the player is checked to make sure the username is accurate. 
	 
	 */
	
    public List<FriendProfile> friends;
    
    public FriendManager()
    {
    	friends = new ArrayList<FriendProfile>();
    }
    
    public List<FriendProfile> getFriends()
    {
    	return friends;
    }
    
    public void addFriend(String nickName, UUID uuid)
    {
    	friends.add(new FriendProfile(nickName, uuid)); 
    }
    
}
