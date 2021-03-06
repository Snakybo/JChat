package server.database;

import server.JServer;

public class DatabaseServerlist extends Database {
	public String[][] translatechars = {{" ","%20"},{"&","[a]"},{"#","[n]"}};
	
	public void UpdateServer() {
		String name = Translate(JServer.serverName);
		boolean connection = sendData("http://" + JServer.database + "/?type=SERVER_UPDATE&name=" + name + "&data=" + JServer.serverIP + ":" + JServer.serverPort + "&stat=" + JServer.serverUsers + ":" + JServer.serverMaxusers);
		if(!connection) {
			//database is down
		}
	}
	
	public String Translate(String text) {
		String newtext = text;
		for(int i = 0; i < translatechars.length; i++) {
			newtext = newtext.replaceAll(translatechars[i][0], translatechars[i][1]);
		}
		
		return newtext;
	}
}