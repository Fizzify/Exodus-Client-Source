package me.oma.exodus.api.util.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;

public interface Wrapper {
	
	Minecraft mc = Minecraft.getMinecraft();
	FontRenderer fr = mc.fontRendererObj;
	ScaledResolution sr = new ScaledResolution(mc);
	ServerUtils serverUtils = new ServerUtils();
	SystemUtils systemUtils = new SystemUtils();
	EncryptUtils encryptUtils = new EncryptUtils();
	PlayerUtils playerUtils = new PlayerUtils();
}
