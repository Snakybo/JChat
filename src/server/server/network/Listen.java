package server.network;

import jexxus.common.Connection;
import jexxus.common.ConnectionListener;
import jexxus.common.Delivery;
import jexxus.server.Server;
import jexxus.server.ServerConnection;
import server.JServer;
import server.file.FileRead;
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
			String msg = new String(data);
			String msgParts[] = msg.split("#");
			from.send("history".getBytes(), Delivery.RELIABLE);
			from.send("users".getBytes(), Delivery.RELIABLE);
			from.send("cmd".getBytes(), Delivery.RELIABLE);
			from.send("end".getBytes(), Delivery.RELIABLE);
			
			if (msgParts[0].equals("command")) {
				if (msgParts[4].equals("null")) {
					Send.runCommand(msgParts[3]);
					if (!JServer.debug) {
						if (msgParts[3] != "CMD_CLEAR") FileWrite.WriteHistory(JServer.getTime(), msgParts[2], msgParts[3]);
						FileWrite.WriteUsers(msgParts[2]); 
					}
				} else {
					Send.runCommandWithPar(msgParts[3], msgParts[4]);
				}

				System.out.println(msgParts[3]);
			} else if (msgParts[0].equals("message")) {
				GUI.Append(msgParts[2] + ": " + msgParts[3]);
				if (!JServer.debug) { 
					FileWrite.WriteHistory(JServer.getTime(), msgParts[2], msgParts[3]);
					FileWrite.WriteUsers(msgParts[2]); 
				}
			} else if (msgParts[0].equals("check")) {
				if (!JServer.debug) { 
					FileWrite.WriteUsers(msgParts[2]); 
					checkRespond();
				}
			}
		}
	}
	
	public static void checkRespond() {
		FileRead.ReadHistory();
		FileRead.ReadUsers();
//		GUI.Append(FileRead.history);
//		GUI.Append(FileRead.users);
	}
}
