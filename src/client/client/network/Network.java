package client.network;

import client.Client;
import jexxus.client.ClientConnection;
import jexxus.common.Connection;
import jexxus.common.ConnectionListener;
import jexxus.common.Delivery;
import jexxus.server.ServerConnection;

public class Network
{
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
		}

		public void clientConnected(ServerConnection conn) 
		{
		}
	}
}