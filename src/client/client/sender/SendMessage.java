package client.sender;

import client.gui.GuiChat;

public class SendMessage extends Send
{
	public String[][] translatechars = {{"#","[n]"},{":","[d]"}};
	
	public void SendClientMessage(String name, String pass, String message, String server, int port)
	{
		String info = "";
		info = "message#" + name + "#" + pass + "#" + translate(message);
		sendInfoToServer(info, server, port);
		GuiChat.DisplayTranslatedMessage(info);
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
