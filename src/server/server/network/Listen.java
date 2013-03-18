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
		server = new Server(new serverListen(), JServer.serverPort, false);
		server.startServer();
		GUI.Append("Server started on: " + JServer.GetIP() + ":" + JServer.serverPort);
	}
	
	public class serverListen implements ConnectionListener {
		public void connectionBroken(Connection broken, boolean forced) { }
		public void clientConnected(ServerConnection conn) { }

		public void receive(byte[] data, Connection from) {
			String msg = new String(data);
			
			String msgParts[] = msg.split("#");
			
			
			GUI.Append("[" + JServer.getTime() + "] " + msgParts[2] + ": " + msgParts[3]);
			
			if (!JServer.debug) {
				FileWrite.WriteHistory(JServer.getTime(), from, new String(data));
			}
		}
	}
}
