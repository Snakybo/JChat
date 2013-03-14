package server.network.receive;

import java.net.ServerSocket;
import java.net.Socket;

import server.Server;
import server.gui.GUI;

public class CreateServer {
	@SuppressWarnings("all")
	public CreateServer() {
		try {
			ServerSocket listener = new ServerSocket(Server.serverPort);
			Socket server;
			GUI.Append("Server started on: " + Server.GetIP() + ":" + Server.serverPort);
			for (int i = 0; i < Server.numThreads; i++) {
				Listen connection;

				server = listener.accept();
				Listen con = new Listen(server);
				Thread t = new Thread(con);
				t.start();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}