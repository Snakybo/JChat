package client.database;

import client.Client;

public class DataClientServerlist extends DataClient
{
	public String[][] translatechars = {{" ","%20"},{"&","[a]"},{"#","[n]"}};

	public DataClientServerlist()
	{
	}
	
	public String[][] GetServerList()
	{
		String[][] newlist = new String[50][4];
		String info = sendData("http://" + Client.Database + "/?type=CLIENT_UPDATE");
		
		String[] data = info.split("&");
		for(int i = 0; i < data.length; i++)
		{
			if(data[i] != null)
			{
				String[] lineinfo = data[i].split("#");
				newlist[i][0] = Translate(lineinfo[0]); //name
				newlist[i][1] = lineinfo[1]; //ip
				newlist[i][2] = lineinfo[2]; //users
				newlist[i][3] = lineinfo[3]; //time
			}
		}
		
		return newlist;
	}
	
	public String Translate(String text)
	{
		String newtext = text;
		for(int i = 0; i < translatechars.length; i++)
		{
			newtext = newtext.replaceAll(translatechars[i][0], translatechars[i][1]);
		}
		return newtext;
	}
}
