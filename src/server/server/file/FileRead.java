package server.file;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import server.JServer;
import server.gui.GUI;

public class FileRead {
	public static String users;
	public static String history;
			
	public static boolean ReadHistory() {
		String file = JServer.rootDir + "history";
		String cLine;
		int lines;
		
		try (BufferedReader bReader = new BufferedReader(new FileReader(file))) {
			lines = count(file) + 1;
			for (int i = 1; i < lines; i++) {
				if (i > lines - 20) continue;
				cLine = bReader.readLine();
				if (cLine.trim().indexOf('#') == 0) continue;
				history = history + cLine + "#";
			}
			history.replace("null", "");
			GUI.Append(history);
			GUI.Append(Integer.toString(lines - 20));
			GUI.Append(Integer.toString(lines));
			
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
			}
			return true;
		} catch(IOException e) { 
			return false;
		}
	}
	
	public static int count(String f) throws IOException {
	    InputStream is = new BufferedInputStream(new FileInputStream(f));
	    try {
	        byte[] c = new byte[1024];
	        int count = 0;
	        int readChars = 0;
	        boolean empty = true;
	        while ((readChars = is.read(c)) != -1) {
	            empty = false;
	            for (int i = 0; i < readChars; ++i) {
	                if (c[i] == '\n') {
	                    ++count;
	                }
	            }
	        }
	        return (count == 0 && !empty) ? 1 : count;
	    } finally {
	        is.close();
	    }
	}
}
