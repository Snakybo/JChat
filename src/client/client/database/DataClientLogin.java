package client.database;

import client.Client;

public class DataClientLogin extends DataClient
{
	public DataClientLogin()
	{	
	}
	
	public int Login(String name, String pass)
	{
		return Integer.parseInt(sendData("http://" + Client.Database + "/?type=CLIENT_LOGIN&name=" + name + "&pass=" + pass));
	}
}
