package client.sender;

import java.util.Calendar;
import client.Client;
import client.gui.GuiChat;

public class SendMessage extends Send
{
	
	public String[][] translatechars = {{"#","[n]"},{":","[d]"}};
	
	public void SendClientMessage(String name, String pass, String message)
	{
		String info = "";
		info = "message#" + name + "#" + pass + "#" + translate(message);
		sendInfoToServer(info);
		
		Calendar calendar = Calendar.getInstance();
		GuiChat.DisplayMessage("[" + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + "] " + name + ": " + message);
	}
	
	public String translate(String message)
	{
		for(int i = 0; i < translatechars.length; i++)
		{
			message = message.replaceAll(translatechars[i][0], translatechars[i][1]);
		}

		return message;
	}
}
