package client.network;

import java.util.Calendar;

import jexxus.client.ClientConnection;
import jexxus.common.Connection;
import jexxus.common.ConnectionListener;
import jexxus.common.Delivery;
import jexxus.server.ServerConnection;
import client.gui.GuiChat;

public class Network
{
	public String[][] translatechars = {{"#","[n]"},{":","[d]"}};
	public ClientConnection conection;
	
	public void openConnection(String ip, int port)
	{
		conection = new ClientConnection(new clientListener(), ip, port, false);
		try
		{
			conection.connect();
		}
		catch(Exception exception)
		{ System.out.println("Connection to server failed"); }
	}

	public void closeConnection()
	{
		try 
		{ 
			conection.close();
		}
		catch(Exception exception)
		{ System.out.println("Closing conection failed"); }
	}
	
	public void sendInfoToServer(String info)
	{
		conection.send(info.getBytes(), Delivery.RELIABLE);
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