package network;
import gui.GUIMain;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Listen {
	private static Socket socket;
		
	public Listen() {
		try {
			int port = 1337;
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(port);
			GUIMain.jta.append("Server Started and listening for messages on port " + port + ".\n");
			
			while(true) {
				//Reading the message from the client
				socket = serverSocket.accept();
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String msg = br.readLine();
				GUIMain.jta.append("Message received from client is " + msg + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			}  catch(Exception e) { }
		}
	}
}