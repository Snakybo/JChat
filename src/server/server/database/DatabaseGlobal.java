package server.database;

import server.JServer;

public class DatabaseGlobal extends Database {
	public void GlobalBan(String op, String name) {
		boolean connection = sendData("http://" + JServer.database + "/?type=OP_BANIP&name=" + op + "&data=" + name);
		if(!connection)	{
			// Database is down
		}
	}
	
	public void GlobalUnban(String op, String name)	{
		boolean connection = sendData("http://" + JServer.database + "/?type=OP_UNBANIP&name=" + op + "&data=" + name);
		if(!connection)	{
			// Database is down
		}
	}
}
