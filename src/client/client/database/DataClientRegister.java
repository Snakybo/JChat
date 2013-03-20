package client.database;

import client.Client;

public class DataClientRegister extends DataClient
{
	public DataClientRegister()
	{
	}
	
	public int Register(String name, String pass)
	{
		return Integer.parseInt(sendData("http://" + Client.Database + "/?type=CLIENT_REGISTER&name=" + name + "&pass=" + pass));
	}
}
