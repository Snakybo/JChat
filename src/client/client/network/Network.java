package client.network;

import java.util.Calendar;

import jexxus.client.ClientConnection;
import jexxus.common.Connection;
import jexxus.common.ConnectionListener;
import jexxus.common.Delivery;
import jexxus.server.ServerConnection;
import client.Client;
import client.gui.*;

public class Network
{
	public String[][] translatechars = {{"#","[n]"},{":","[d]"}};
	public ClientConnection conection;
	
	public void sendInfoToServer(String info)
	{
		try 
		{ 
			conection = new ClientConnection(new clientListener(), Client.ServerIP, Client.ServerPort, false);
			conection.connect(1000);
			conection.send(info.getBytes(), Delivery.RELIABLE);
			Client.Connected = true;
		}
		catch(Exception exception)
		{ 
			if(Client.Connected == true)
			{
				GuiChat.DisplayMessage("Lost connection to server! reconnecting...");
				Client.Connected = false;
			}
		}
	}
	
	public boolean pingToServer(String server, int port)
	{
		try 
		{ 
			conection = new ClientConnection(new clientListener(), server, port, false);
			conection.connect(1000);
			conection.send("ping#0#0#0".getBytes(), Delivery.RELIABLE);
			conection.close();
			return true;
		}
		catch(Exception exception)
		{ 
			return false;
		}
	}
	
	public class clientListener implements ConnectionListener
	{
		public void connectionBroken(Connection broken, boolean forced) 
		{
		}

		public void receive(byte[] data, Connection from) 
		{
			if(new String(data).equals("end") && conection.isConnected())
			{
				conection.close();
			}
			else
			{
				Calendar calendar = Calendar.getInstance();
				GuiChat.DisplayMessage("[" + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + "] " + "SERVER" + ": " + new String(data));
			}
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