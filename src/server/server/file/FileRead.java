package server.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import server.JServer;
import server.gui.GUI;

public class FileRead {
	public static String users;
	public static String history;
			
	public static boolean ReadHistory() {
		String file = JServer.rootDir + "history";
		String cLine;
		
		try (BufferedReader bReader = new BufferedReader(new FileReader(file))) {
			int l = 0;
			while ((cLine = bReader.readLine()) != null) {
				l++;
			}
			
			int i = (l - 23);
			while ((cLine = bReader.readLine()) != null && i < (l - 3)) {
				if (cLine.trim().indexOf('#') == 0)	continue;
				history = history + cLine + "#";
				i++;
				GUI.Append("donethat");
			}
			GUI.Append(history);
			return true;
		} catch(IOException e) {
			return false;
		}
	}
	
	public static boolean ReadConfig() {
		String file = JServer.rootDir + "config";
		String cLine;
		String[][] str = new String[3][2];
		
		try (BufferedReader bReader = new BufferedReader(new FileReader(file))) {
			int i = 0;
			while ((cLine = bReader.readLine()) != null) {
				if (cLine.trim().indexOf('#') == 0) continue;
				str[i] = cLine.split(": ");
				i++;
			}
			
			if (str[0][0].equals("Port")) JServer.serverPort = Integer.parseInt(str[0][1]);
			if (str[1][0].equals("Server Name")) JServer.serverName = str[1][1];
			if (str[2][0].equals("Max Users")) JServer.serverMaxusers = Integer.parseInt(str[2][1]);
			
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	public static boolean ReadUsers() {
		String file = JServer.rootDir + "users";
		String cLine;
	
		try (BufferedReader bReader = new BufferedReader(new FileReader(file))) {
			while ((cLine = bReader.readLine()) != null) {
				if (cLine.trim().indexOf('#') == 0)	continue;
				users = users + cLine + "#";
				GUI.Append("donethis");
			}
			GUI.Append(users);
			return true;
		} catch(IOException e) { 
			return false;
		}
	}
}
