package client.network;

import java.util.Calendar;

import jexxus.client.ClientConnection;
import jexxus.common.Connection;
import jexxus.common.ConnectionListener;
import jexxus.common.Delivery;
import jexxus.server.ServerConnection;
import client.Client;
import client.gui.GuiChat;

public class Network
{
	public String[][] translatechars = {{"#","[n]"},{":","[d]"}};
	public ClientConnection conection;
	
	public void sendInfoToServer(String info)
	{
		try 
		{ 
			conection = new ClientConnection(new clientListener(), Client.ServerIP, Client.ServerPort, false);
			conection.connect();
			conection.send(info.getBytes(), Delivery.RELIABLE);
			conection.close();
		}
		catch(Exception exception)
		{ System.out.println("Message cannot be send :("); }
	}
	
	public class clientListener implements ConnectionListener
	{
		public void connectionBroken(Connection broken, boolean forced) 
		{
		}

		public void receive(byte[] data, Connection from) 
		{
			Calendar calendar = Calendar.getInstance();
			GuiChat.DisplayMessage("[" + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + "] " + "SERVER" + ": " + new String(data));
		}

		public void clientConnected(ServerConnection conn) 
		{
		}
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