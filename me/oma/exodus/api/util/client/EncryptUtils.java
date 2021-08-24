package me.oma.exodus.api.util.client;

import java.security.MessageDigest;

import me.oma.exodus.api.util.Util;

public class EncryptUtils extends Util {
	
	public String hashMD5(String input)
	{
		try
		{
			MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            
            byte kek[] = md.digest();
            
            for (byte byteShit : kek) 
            {
                String hex = Integer.toHexString(0xff & byteShit);
                
                if (hex.length() == 1) 
                {
                	stringBuffer.append('0');
                }
                
                stringBuffer.append(hex);
            }
            
            return stringBuffer.toString();
		} 
		catch (Exception e)
		{
			return "FAIL";
		}
	}
	

}
