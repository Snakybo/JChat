package server.network;

import jexxus.common.Connection;
import jexxus.common.ConnectionListener;
import jexxus.server.Server;
import jexxus.server.ServerConnection;
import server.JServer;
import server.file.FileWrite;
import server.gui.GUI;

public class Listen {
	private Server server;
	
	public Listen() {
		try {
			server = new Server(new serverListen(), JServer.serverPort, false);
			server.startServer();
			GUI.Append("Server started on: " + JServer.serverIP + ":" + JServer.serverPort);
		} catch (Exception e) {
			GUI.Append("Port " + JServer.serverPort + " already in use!");
		}
	}
	
	public class serverListen implements ConnectionListener {		
		public void connectionBroken(Connection broken, boolean forced) { }
		public void clientConnected(ServerConnection conn) { }

		public void receive(byte[] data, Connection from) {
			String r = new String(data);
			String rParts[] = r.split("#");
			
			new SendClientInfo(from);
			System.out.println(rParts[0]);
			
			// Handle commands
			if (rParts[0].equals("command")) {
				if (rParts[4].equals("null")) {
					GUI.txtArea.setText("");
					if (!JServer.debug) {
						FileWrite.WriteUsers(rParts[2]); 
						if (rParts[3] != "CMD_CLEAR") FileWrite.WriteHistory(JServer.getTime(), rParts[2], rParts[3]);
					}
				} else {
					Send.runCommandWithPar(rParts[3], rParts[4]);
				}
			}
			
			// Handle messages
			if (rParts[0].equals("message")) {
				GUI.Append(rParts[2] + ": " + rParts[3]);
				if (!JServer.debug) { 
					FileWrite.WriteHistory(JServer.getTime(), rParts[2], rParts[3]);
					FileWrite.WriteUsers(rParts[2]); 
				}
			}
		}
	}
}
