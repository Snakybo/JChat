package server.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import server.Server;
import server.gui.GUIMain;

public class Listen {
	private static Socket socket = null;
	private int port;
		
	public Listen() {
		try {
			port = Server.listenPort;
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(port);
			GUIMain.jta.append("\nServer Started and listening for messages on port " + port + ".\n");

			while(true) {
				socket = serverSocket.accept();
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String msg = br.readLine();
				GUIMain.jta.append("Received message from client: " + msg + "\n");
			}
		} catch (Exception e) {
			GUIMain.jta.append("Port " + port + " already in use!\n");
		} finally {
			try {
				socket.close();
			}  catch(Exception e) { }
		}
	}
	
	public static void closePorts() {
		try {
			socket.close();
			GUIMain.jta.append("Server closed\n");
		} catch (IOException e) { }
	}
}