package server.network.receive;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import server.Server;
import server.file.FileRead;
import server.file.FileWrite;
import server.gui.GUIMain;

public class Listen {
	private static Socket socket;
	private int port;
		
	public Listen() {
		try {
			port = Server.listenPort;
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(port);
			GUIMain.jta.append("\nServer Started and listening for messages on port " + port + ".\n");
			GUIMain.jta.append("Loading chat history..");
			FileRead.ReadHistory();
			
			while(true) {
				socket = serverSocket.accept();
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String msg = br.readLine();
							
				Calendar cal = Calendar.getInstance();
		    	cal.getTime();
		    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		    	
		    	GUIMain.jta.append("[" + sdf.format(cal.getTime()) + "] " + "Username: " + msg + "\n");
				FileWrite.WriteHistory(sdf.format(cal.getTime()), "Test", msg);
			}
		} catch (Exception e) {
			GUIMain.jta.append("Port " + port + " already in use!\n");
		} finally {
			try {
				socket.close();
			}  catch(Exception e) { }
		}
	}
}