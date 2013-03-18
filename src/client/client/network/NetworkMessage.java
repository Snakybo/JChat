package client.network;

import java.util.Calendar;
import client.gui.GuiChat;

public class NetworkMessage extends Network
{	
	public void SendClientMessage(String name, String pass, String message)
	{
		String info = "";
		info = "message#" + name + "#" + "client" + "#" + translate(message);
		sendInfoToServer(info);
		
		Calendar calendar = Calendar.getInstance();
		GuiChat.DisplayMessage("[" + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + "] " + name + ": " + message);
	}
}
