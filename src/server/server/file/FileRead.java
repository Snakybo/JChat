package server.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import server.JServer;

public class FileRead {
	public static String history;
	public static String ops;
			
	public static void ReadHistory() {
		String file = JServer.rootDir + "history";
		String cLine;
		int lines = 0;
		int line = 0;
		
		history = "";
		
		try (BufferedReader bReader = new BufferedReader(new FileReader(file))) {
			while (bReader.readLine() != null)
			lines++;
		} catch (IOException ex) { }
		
		try (BufferedReader bReader = new BufferedReader(new FileReader(file))) {
			while ((cLine = bReader.readLine()) != null) {
				line++;
				if (line >= (lines - 20))
					if (history != null) { history = history + "#" + cLine; } else { history = cLine; }
			}
			bReader.close();
		} catch (IOException e) { }
	}
	
	// Read the ops file
	public static void ReadOPs() {
		String file = JServer.rootDir + "ops";
		String cLine;
		
		try (BufferedReader bReader = new BufferedReader(new FileReader(file))) {
			while ((cLine = bReader.readLine()) != null) {
				if (ops != null) { ops = ops + "#" + cLine; } else { ops = cLine; }
			}
			bReader.close();
		} catch (IOException e) { }
	}
	
	// Read the config file
	public static void ReadConfig() {
		String file = JServer.rootDir + "config";
		String[][] str = new String[3][2];
		String cLine;
		
		try (BufferedReader bReader = new BufferedReader(new FileReader(file))) {
			int i = 0;
			while ((cLine = bReader.readLine()) != null) {
				str[i] = cLine.split(": ");
				i++;
			}
			bReader.close();
			
			if (i < str.length) {
				FileWrite.WriteConfig();
				ReadConfig();
			}
			
			if (str[0][0].equals("Port")) JServer.serverPort = Integer.parseInt(str[0][1]);
			if (str[1][0].equals("Server Name")) JServer.serverName = str[1][1];
			if (str[2][0].equals("Max Users")) JServer.serverMaxusers = Integer.parseInt(str[2][1]);
		} catch (IOException e) { }
	}
}
